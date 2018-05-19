package DolphinElectronics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Home extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSearch;
	private JMenuBar menuBar_1;
	private JMenuBar menuBar_2;
	private JMenu mnCustomers;
	private JMenuItem custAdd;
	private JMenu custSearch;
	private JMenuItem byName;
	private JMenuItem byAddress;
	private JMenuItem byCost;
	private JMenuItem byItem;
	private JMenu custRemove;
	private JMenuItem byCName;
	private JMenuItem byCAddress;
	private JMenuItem byCId;
	private JMenuItem custUpdate;
	private JDialog addCust;
	private JMenu mnProduct;
	private JMenuItem prodAdd;
	private JMenu prodSearch;
	private JMenuItem pbyName;
	private JMenuItem pbyType;
	private JMenuItem pbyCost;
	private JMenuItem pbyItem;
	private JMenu prodRemove;
	private JMenuItem byPName;
	private JMenuItem byPType;
	private JMenuItem byPCost;
	private JMenuItem prodUpdate;
	private JMenuItem byCItem;
	private JMenuItem pbyId;
	private JMenuItem byPId;
	private JMenuItem byId;

	Home() {
		getContentPane().setFont(new Font("Cambria", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dolphin Electronics");
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("/home/akansha/Downloads/image.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(800, 560, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		setContentPane(new JLabel(imageIcon));
		getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 80, 21);
		getContentPane().add(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);

		mntmSearch = new JMenuItem("Search");
		mnFile.add(mntmSearch);

		menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(82, 0, 120, 21);
		getContentPane().add(menuBar_1);

		mnCustomers = new JMenu("Customers");
		menuBar_1.add(mnCustomers);

		custAdd = new JMenuItem("Add Customer");
		mnCustomers.add(custAdd);

		custSearch = new JMenu("Search Customer");
		mnCustomers.add(custSearch);
		
		byId = new JMenuItem("By Id");
		custSearch.add(byId);

		byName = new JMenuItem("By Name");
		custSearch.add(byName);

		byAddress = new JMenuItem("By Address");
		custSearch.add(byAddress);

		byItem = new JMenuItem("By Item Purchased");
		custSearch.add(byItem);

		custRemove = new JMenu("Remove Customer");
		mnCustomers.add(custRemove);
		
		byCId = new JMenuItem("By Id");
		custRemove.add(byCId);

		byCName = new JMenuItem("By Name");
		custRemove.add(byCName);

		byCAddress = new JMenuItem("By Address");
		custRemove.add(byCAddress);

		byCItem = new JMenuItem("By Item Purchased");
		custRemove.add(byCItem);

		custUpdate = new JMenuItem("Update Customer");
		mnCustomers.add(custUpdate);
		
		custAdd.addActionListener(this);
		byName.addActionListener(this);
		byCName.addActionListener(this);
		byAddress.addActionListener(this);
		byCAddress.addActionListener(this);
		byId.addActionListener(this);
		byCId.addActionListener(this);
		byItem.addActionListener(this);
		byCItem.addActionListener(this);
		custUpdate.addActionListener(this);
		
		
		menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(204, 0, 120, 21);
		getContentPane().add(menuBar_2);

		mnProduct = new JMenu("Product");
		menuBar_2.add(mnProduct);

		prodAdd = new JMenuItem("Add Product");
		mnProduct.add(prodAdd);

		prodSearch = new JMenu("Search Product");
		mnProduct.add(prodSearch);
		
		pbyId = new JMenuItem("By Id");
		prodSearch.add(pbyId);

		pbyName = new JMenuItem("By Name");
		prodSearch.add(pbyName);

		pbyType = new JMenuItem("By Type");
		prodSearch.add(pbyType);

		pbyCost = new JMenuItem("By Cost");
		prodSearch.add(pbyCost);

		prodRemove = new JMenu("Remove Product");
		mnProduct.add(prodRemove);

		byPId = new JMenuItem("By Id");
		prodRemove.add(byPId);
		
		byPName = new JMenuItem("By Name");
		prodRemove.add(byPName);

		byPType = new JMenuItem("By Type");
		prodRemove.add(byPType);

		byPCost = new JMenuItem("By Cost");
		prodRemove.add(byPCost);

		prodUpdate = new JMenuItem("Update Product");
		mnProduct.add(prodUpdate);
		
		prodAdd.addActionListener(this);
		pbyName.addActionListener(this);
		byPName.addActionListener(this);
		pbyType.addActionListener(this);
		byPType.addActionListener(this);
		pbyCost.addActionListener(this);
		byPCost.addActionListener(this);
		byPId.addActionListener(this);
		pbyId.addActionListener(this);
		prodUpdate.addActionListener(this);
		
		
		setResizable(true);
		setSize(getMaximumSize());
		setLocation(300, 70);
		setSize(800, 600);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==custAdd) {
			new AddCustomer();
		}
		if(obj==prodAdd) {
			new AddProduct();
		}
		if(obj==custUpdate) {
			new UpdateCustomer();
		}
		if(obj==prodUpdate) {
			new UpdateProduct();
		}
		if(obj==byCId) {
			new RemoveCustomerById();
		}
		if(obj==byCName) {
			new RemoveCustomerByName();
		}
		if(obj==byCAddress) {
			new RemoveCustomerByAddress();
		}
		if(obj==byCItem) {
			new RemoveCustomerByItem();
		}
		if(obj==byPId) {
			new RemoveProductById();
		}
		if(obj==byPName) {
			new RemoveProductByName();
		}
		if(obj==byPType) {
			new RemoveProductByType();
		}
		if(obj==byPCost) {
			new RemoveProductByCost();
		}
		if(obj==byId) {
			new SearchCustomerById();
		}
		if(obj==byName) {
			new SearchCustomerByName();
		}
		if(obj==byAddress) {
			new SearchCustomerByAddress();
		}
		if(obj==byItem) {
			new SearchCustomerByItem();
		}
		if(obj==pbyId) {
			new SearchProductById();
		}
		if(obj==pbyName) {
			new SearchProductByName();
		}
		if(obj==pbyType) {
			new SearchProductByType();
		}
		if(obj==pbyCost) {
			new SearchProductByCost();
		}
		if(obj==custUpdate) {
			new UpdateCustomer();
		}
		if(obj==prodUpdate) {
			new UpdateProduct();
		}
	}
}
