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


public class RemoveCustomerByItem implements ActionListener {
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
	private JButton deleteBtn;
	private JLabel id;
	private JTextField cid;

	public RemoveCustomerByItem() {
		updateCust = new JDialog();
		updateCust.setBackground(Color.WHITE);
		JLabel title=new JLabel("Enter id of item purchased by Customer");
		title.setBounds(20, 10, 400, 20);	
		title.setFont(new Font("Ariel", Font.BOLD, 16));
		updateCust.add(title);
		
		item = new JLabel("Item Id");
		item.setBounds(20, 60, 80, 20);
		updateCust.add(item);
		
		citem = new JTextField();
		citem.setBounds(130, 60, 200, 20);
		updateCust.add(citem);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(150, 120, 100, 20);
		updateCust.add(deleteBtn);
		
		deleteBtn.addActionListener(this);
		
		updateCust.getContentPane().setLayout(null);
		updateCust.setBounds(100, 120, 400, 180);
		
		updateCust.setTitle("Delete Customer");
		updateCust.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveCustomerByItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==deleteBtn) {
			String Citem=citem.getText().toString();		
			
			Connection c=PConnection.connect();
			String query = "delete from customers where item=?";
			
			try {
				PreparedStatement ps = c.prepareStatement(query);
				
				ps.setString(1, Citem);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Customer deleted");
				//updateCust.dispose();
				citem.setText("");
				
			}
			catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}

}
