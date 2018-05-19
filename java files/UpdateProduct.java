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


public class UpdateProduct implements ActionListener {
	private JDialog updateProd;
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

	public UpdateProduct() {
		updateProd = new JDialog();
		updateProd.setBackground(Color.WHITE);
		JLabel title=new JLabel("Fill Updated Details of the Product");
		title.setBounds(60, 10, 290, 20);	
		title.setFont(new Font("Ariel", Font.BOLD, 16));
		updateProd.add(title);
		
		id = new JLabel("Id");
		id.setBounds(20, 70, 80, 20);
		updateProd.add(id);
		
		pid = new JTextField();
		pid.setBounds(130, 70, 200, 20);
		updateProd.add(pid);
		
		name = new JLabel("Name");
		name.setBounds(20, 120, 80, 20);
		updateProd.add(name);
		
		pname = new JTextField();
		pname.setBounds(130, 120, 200, 20);
		updateProd.add(pname);
		
		type = new JLabel("Type");
		type.setBounds(20, 170, 80, 20);
		updateProd.add(type);
		
		ptype = new JTextField();
		ptype.setBounds(130, 170, 200, 20);
		updateProd.add(ptype);
		
		cost = new JLabel("Cost");
		cost.setBounds(20, 220, 80, 20);
		updateProd.add(cost);
		
		pcost = new JTextField();
		pcost.setBounds(130, 220, 200, 20);
		updateProd.add(pcost);
		
		units = new JLabel("Units");
		units.setBounds(20, 270, 80, 20);
		updateProd.add(units);
		
		punits = new JTextField();
		punits.setBounds(130, 270, 200, 20);
		updateProd.add(punits);
		
		addBtn = new JButton("Update");
		addBtn.setBounds(150, 330, 100, 20);
		updateProd.add(addBtn);
		
		addBtn.addActionListener(this);
		
		updateProd.getContentPane().setLayout(null);
		updateProd.setBounds(100, 100, 400, 400);
		
		updateProd.setTitle("Update Product");
		updateProd.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateProduct();
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
			String query = "update products set name=?,type=?,cost=?,units=? where id=?";
			
			try {
				PreparedStatement ps = c.prepareStatement(query);
				
				ps.setString(1, Pname);
				ps.setString(2, Ptype);
				ps.setInt(3, Integer.parseInt(Pcost));
				ps.setInt(4, Integer.parseInt(Punits));
				ps.setString(5, Pid);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Product updated");
				//updateProd.dispose();
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
