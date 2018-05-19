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


public class SearchCustomerByName implements ActionListener {
	private JDialog searchCust;
	private JLabel name;
	private JTextField cname;
	private JLabel address;
	private JTextField caddress;
	private JLabel item;
	private JTextField citem;
	private JLabel phone;
	private JTextField cphone;
	private JLabel cost;
	private JTextField ccost;
	private JButton searchBtn;
	private JLabel id;
	private JTextField cid;
	private JTable table;

	public SearchCustomerByName() {
		searchCust = new JDialog();
		searchCust.setBackground(Color.WHITE);
		JLabel title=new JLabel("Enter the name of the Customer");
		title.setBounds(70, 10, 350, 20);	
		title.setFont(new Font("Ariel", Font.BOLD, 16));
		searchCust.add(title);
		
		name = new JLabel("Name");
		name.setBounds(20, 60, 80, 20);
		searchCust.add(name);
		
		cname = new JTextField();
		cname.setBounds(130, 60, 200, 20);
		searchCust.add(cname);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(150, 120, 100, 20);
		searchCust.add(searchBtn);
		
		searchBtn.addActionListener(this);
		
		searchCust.getContentPane().setLayout(null);
		searchCust.setBounds(100, 120, 400, 400);
		
		searchCust.setTitle("Search for Customer");
		searchCust.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchCustomerByName();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==searchBtn) {
			String Cname=cname.getText().toString();		
			
			Connection c=PConnection.connect();
			String query = "select * from customers where name=?";
			
			try {
				PreparedStatement ps = c.prepareStatement(query);
				ps.setString(1, Cname);
				ResultSet rs=ps.executeQuery();
				String data[][]=new String[100][6];
				int count=0;
				data[count][0]="Id";
				data[count][1]="Name";
				data[count][2]="Address";
				data[count][3]="Item";
				data[count][4]="Amount";
				data[count][5]="Phone";
				count++;
				while(rs.next()) {
					data[count][0]=rs.getString(1);
					data[count][1]=rs.getString(2);
					data[count][2]=rs.getString(3);
					data[count][3]=rs.getString(4);
					data[count][4]=rs.getString(5);
					data[count][5]=rs.getString(6);
					count++;
				}
				
				String colNames[]= {"Id","Name","Address","item","amount","phone"};
				table = new JTable(data,colNames);
				table.setBounds(20,180,350,100);
				searchCust.add(table);
				searchCust.setVisible(true);
				
				cname.setText("");
				
			}
			catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}

}
