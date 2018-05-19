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


public class AddCustomer implements ActionListener {
	private JDialog addCust;
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
	private JButton addBtn;
	private JLabel id;
	private JTextField cid;

	public AddCustomer() {
		addCust = new JDialog();
		addCust.setBackground(Color.WHITE);
		JLabel title=new JLabel("Fill Details of the Customer");
		title.setBounds(80, 10, 250, 20);	
		title.setFont(new Font("Ariel", Font.BOLD, 16));
		addCust.add(title);
		
		id = new JLabel("Id");
		id.setBounds(20, 70, 80, 20);
		addCust.add(id);
		
		cid = new JTextField();
		cid.setBounds(130, 70, 200, 20);
		addCust.add(cid);
		
		name = new JLabel("Name");
		name.setBounds(20, 120, 80, 20);
		addCust.add(name);
		
		cname = new JTextField();
		cname.setBounds(130, 120, 200, 20);
		addCust.add(cname);
		
		address = new JLabel("Address");
		address.setBounds(20, 170, 80, 20);
		addCust.add(address);
		
		caddress = new JTextField();
		caddress.setBounds(130, 170, 200, 20);
		addCust.add(caddress);
		
		item = new JLabel("Item");
		item.setBounds(20, 220, 80, 20);
		addCust.add(item);
		
		citem = new JTextField();
		citem.setBounds(130, 220, 200, 20);
		addCust.add(citem);
		
		cost = new JLabel("Amount");
		cost.setBounds(20, 270, 80, 20);
		addCust.add(cost);
		
		ccost = new JTextField();
		ccost.setBounds(130, 270, 200, 20);
		addCust.add(ccost);
		
		phone = new JLabel("Phone No.");
		phone.setBounds(20, 320, 80, 20);
		addCust.add(phone);
		
		cphone = new JTextField();
		cphone.setBounds(130, 320, 200, 20);
		addCust.add(cphone);
		
		addBtn = new JButton("  Add  ");
		addBtn.setBounds(150, 400, 80, 20);
		addCust.add(addBtn);
		
		addBtn.addActionListener(this);
		
		addCust.getContentPane().setLayout(null);
		addCust.setBounds(100, 100, 400, 500);
		
		addCust.setTitle("Add Customer");
		addCust.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddCustomer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==addBtn) {
			String Cid=cid.getText().toString();
			String Cname=cname.getText().toString();
			String Caddress=caddress.getText().toString();
			String Citem=citem.getText().toString();
			String Ccost=ccost.getText().toString();
			String Cphone=cphone.getText().toString();			
			
			Connection c=PConnection.connect();
			String query = "insert into customers values (?,?,?,?,?,?)";
			
			try {
				PreparedStatement ps = c.prepareStatement(query);
				
				ps.setInt(1, Integer.parseInt(Cid));
				ps.setString(2, Cname);
				ps.setString(3, Caddress);
				ps.setString(4, Citem);
				ps.setInt(5, Integer.parseInt(Ccost));
				ps.setString(6, Cphone);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Customer added");
				//addCust.dispose();
				cid.setText("");
				cname.setText("");
				caddress.setText("");
				citem.setText("");
				ccost.setText("");
				cphone.setText("");	
				
			}
			catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}

}
