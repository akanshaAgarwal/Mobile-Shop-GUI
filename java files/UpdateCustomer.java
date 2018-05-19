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


public class UpdateCustomer implements ActionListener {
	private JDialog updateCust;
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

	public UpdateCustomer() {
		updateCust = new JDialog();
		updateCust.setBackground(Color.WHITE);
		JLabel title=new JLabel("Fill Updated Details of the Customer");
		title.setBounds(40, 10, 350, 20);	
		title.setFont(new Font("Ariel", Font.BOLD, 16));
		updateCust.add(title);
		
		id = new JLabel("Id");
		id.setBounds(20, 70, 80, 20);
		updateCust.add(id);
		
		cid = new JTextField();
		cid.setBounds(130, 70, 200, 20);
		updateCust.add(cid);
		
		name = new JLabel("Name");
		name.setBounds(20, 120, 80, 20);
		updateCust.add(name);
		
		cname = new JTextField();
		cname.setBounds(130, 120, 200, 20);
		updateCust.add(cname);
		
		address = new JLabel("Address");
		address.setBounds(20, 170, 80, 20);
		updateCust.add(address);
		
		caddress = new JTextField();
		caddress.setBounds(130, 170, 200, 20);
		updateCust.add(caddress);
		
		item = new JLabel("Item");
		item.setBounds(20, 220, 80, 20);
		updateCust.add(item);
		
		citem = new JTextField();
		citem.setBounds(130, 220, 200, 20);
		updateCust.add(citem);
		
		cost = new JLabel("Amount");
		cost.setBounds(20, 270, 80, 20);
		updateCust.add(cost);
		
		ccost = new JTextField();
		ccost.setBounds(130, 270, 200, 20);
		updateCust.add(ccost);
		
		phone = new JLabel("Phone No.");
		phone.setBounds(20, 320, 80, 20);
		updateCust.add(phone);
		
		cphone = new JTextField();
		cphone.setBounds(130, 320, 200, 20);
		updateCust.add(cphone);
		
		addBtn = new JButton("Update");
		addBtn.setBounds(150, 400, 100, 20);
		updateCust.add(addBtn);
		
		addBtn.addActionListener(this);
		
		updateCust.getContentPane().setLayout(null);
		updateCust.setBounds(100, 100, 400, 500);
		
		updateCust.setTitle("Update Customer Details");
		updateCust.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateCustomer();
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
			String query = "update customers set name=?,address=?,item=?,amount=?,phone=? where id=?";
			
			try {
				PreparedStatement ps = c.prepareStatement(query);
				
				ps.setString(1, Cname);
				ps.setString(2, Caddress);
				ps.setString(3, Citem);
				ps.setInt(4, Integer.parseInt(Ccost));
				ps.setString(5, Cphone);
				ps.setInt(6, Integer.parseInt(Cid));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Customer updated");
				//updateCust.dispose();
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
