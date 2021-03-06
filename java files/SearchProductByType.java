package DolphinElectronics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class SearchProductByType implements ActionListener {
	private JDialog searchProd;
	private JLabel name;
	private JTextField pname;
	private JLabel type;
	private JTextField ptype;
	private JLabel item;
	private JTextField pitem;
	private JLabel units;
	private JTextField punits;
	private JLabel cost;
	private JTextField pcost;
	private JButton searchBtn;
	private JLabel id;
	private JTextField pid;
	private JTable table;

	public SearchProductByType() {
		searchProd = new JDialog();
		searchProd.setBackground(Color.WHITE);
		JLabel title=new JLabel("Enter the type of Product");
		title.setBounds(60, 10, 290, 20);	
		title.setFont(new Font("Ariel", Font.BOLD, 16));
		searchProd.add(title);
		
		type = new JLabel("P. type");
		type.setBounds(20, 60, 80, 20);
		searchProd.add(type);
		
		ptype = new JTextField();
		ptype.setBounds(130, 60, 200, 20);
		searchProd.add(ptype);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(150, 120, 100, 20);
		searchProd.add(searchBtn);
		
		searchBtn.addActionListener(this);
		
		searchProd.getContentPane().setLayout(null);
		searchProd.setBounds(100, 100, 400, 400);
		
		searchProd.setTitle("Search for Product");
		searchProd.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchProductByType();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==searchBtn) {
			String Ptype=ptype.getText().toString();		
			
			Connection c=PConnection.connect();
			String query = "select * from products where type=?";
			
			try {
				PreparedStatement ps = c.prepareStatement(query);
				ps.setString(1, Ptype);
				ResultSet rs=ps.executeQuery();
				String data[][]=new String[100][5];
				int count=0;
				data[count][0]="Id";
				data[count][1]="Name";
				data[count][2]="Type";
				data[count][3]="Cost";
				data[count][4]="Units";
				count++;
				while(rs.next()) {
					data[count][0]=rs.getString(1);
					data[count][1]=rs.getString(2);
					data[count][2]=rs.getString(3);
					data[count][3]=rs.getString(4);
					data[count][4]=rs.getString(5);
					count++;
				}
				
				String colNames[]= {"Id","Name","Type","Cost","Units"};
				table = new JTable(data,colNames);
				table.setBounds(20,180,350,100);
				searchProd.add(table);
				searchProd.setVisible(true);
				//searchProd.dispose();
				ptype.setText("");
				
			}
			catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}

}
