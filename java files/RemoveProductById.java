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


public class RemoveProductById implements ActionListener {
	private JDialog deleteProd;
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
	private JButton deleteBtn;
	private JLabel id;
	private JTextField pid;

	public RemoveProductById() {
		deleteProd = new JDialog();
		deleteProd.setBackground(Color.WHITE);
		JLabel title=new JLabel("Enter ID of the Product");
		title.setBounds(60, 10, 290, 20);	
		title.setFont(new Font("Ariel", Font.BOLD, 16));
		deleteProd.add(title);
		
		id = new JLabel("Id");
		id.setBounds(20, 60, 80, 20);
		deleteProd.add(id);
		
		pid = new JTextField();
		pid.setBounds(130, 60, 200, 20);
		deleteProd.add(pid);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(150, 120, 100, 20);
		deleteProd.add(deleteBtn);
		
		deleteBtn.addActionListener(this);
		
		deleteProd.getContentPane().setLayout(null);
		deleteProd.setBounds(100, 100, 400, 180);
		
		deleteProd.setTitle("Delete Product");
		deleteProd.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveProductById();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==deleteBtn) {
			String Pid=pid.getText().toString();		
			
			Connection c=PConnection.connect();
			String query = "delete from products where id=?";
			
			try {
				PreparedStatement ps = c.prepareStatement(query);
				ps.setString(1, Pid);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Product deleted");
				//deleteProd.dispose();
				pid.setText("");
				
			}
			catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}

}
