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
import javax.swing.JTextField;


public class AddProduct implements ActionListener {
	private JDialog addProd;
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
	private JButton addBtn;
	private JLabel id;
	private JTextField pid;

	public AddProduct() {
		addProd = new JDialog();
		addProd.setBackground(Color.WHITE);
		JLabel title=new JLabel("Fill Details of the new Product");
		title.setBounds(60, 10, 290, 20);	
		title.setFont(new Font("Ariel", Font.BOLD, 16));
		addProd.add(title);
		
		id = new JLabel("Id");
		id.setBounds(20, 70, 80, 20);
		addProd.add(id);
		
		pid = new JTextField();
		pid.setBounds(130, 70, 200, 20);
		addProd.add(pid);
		
		name = new JLabel("Name");
		name.setBounds(20, 120, 80, 20);
		addProd.add(name);
		
		pname = new JTextField();
		pname.setBounds(130, 120, 200, 20);
		addProd.add(pname);
		
		type = new JLabel("Type");
		type.setBounds(20, 170, 80, 20);
		addProd.add(type);
		
		ptype = new JTextField();
		ptype.setBounds(130, 170, 200, 20);
		addProd.add(ptype);
		
		cost = new JLabel("Cost");
		cost.setBounds(20, 220, 80, 20);
		addProd.add(cost);
		
		pcost = new JTextField();
		pcost.setBounds(130, 220, 200, 20);
		addProd.add(pcost);
		
		units = new JLabel("Units");
		units.setBounds(20, 270, 80, 20);
		addProd.add(units);
		
		punits = new JTextField();
		punits.setBounds(130, 270, 200, 20);
		addProd.add(punits);
		
		addBtn = new JButton("  Add  ");
		addBtn.setBounds(150, 330, 80, 20);
		addProd.add(addBtn);
		
		addBtn.addActionListener(this);
		
		addProd.getContentPane().setLayout(null);
		addProd.setBounds(100, 100, 400, 400);
		
		addProd.setTitle("Add Prodomer");
		addProd.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddProduct();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==addBtn) {
			String Pid=pid.getText().toString();
			String Pname=pname.getText().toString();
			String Ptype=ptype.getText().toString();
			String Pcost=pcost.getText().toString();
			String Punits=punits.getText().toString();			
			
			Connection c=PConnection.connect();
			String query = "insert into products values (?,?,?,?,?)";
			
			try {
				PreparedStatement ps = c.prepareStatement(query);
				
				ps.setString(1, Pid);
				ps.setString(2, Pname);
				ps.setString(3, Ptype);
				ps.setInt(4, Integer.parseInt(Pcost));
				ps.setInt(5, Integer.parseInt(Punits));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Product added");
				//addProd.dispose();
				pid.setText("");
				pname.setText("");
				ptype.setText("");
				pcost.setText("");
				punits.setText("");	
				
			}
			catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}

}
