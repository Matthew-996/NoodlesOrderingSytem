import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
/**
 * This is a interface to choose payment way.
 * 
 * @author Yuyang Wu
 * @version 1.0
 */	
public class ChoosePayment {
	JFrame myFrame;
	Ticket ticket;
	JLabel top;
	JPanel myPanel,underground;
	JButton login,register,finish;
	
	public ChoosePayment(JFrame myFrame,Ticket ticket) {
		myFrame.getContentPane().removeAll();
		myFrame.getContentPane().setLayout(new BorderLayout());
		
		myFrame.setLayout(new BorderLayout());
		top=new JLabel();
		top.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		top.setText("You have ordered successfully!");
		
		myPanel=new JPanel();
		myPanel.setLayout(null);
		TitledBorder b1=BorderFactory.createTitledBorder("Would you want to:");
		myPanel.setBorder(b1);
		
		login = new JButton("Login and get a stamp!");
		login.setBounds(200,100,500,80);
		login.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(login);
		login.addActionListener(new login());
		
		register = new JButton("Register and get a stamp!");
		register.setBounds(200,250,500,80);
		register.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(register);
		register.addActionListener(new register());
		
		finish = new JButton("Don't login and pay!");
		finish.setBounds(200,400,500,80);
		finish.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(finish);
		finish.addActionListener(new finish());
		
		underground=new JPanel();
		underground.setLayout(null);
		underground.setPreferredSize(new Dimension(100,100));
		
		JLabel back = new JLabel("If you have membership number and 10 stamps, you have a free of charge chance!");
		back.setBounds(50,10,950,80);
		back.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		underground.add(back);
		
		myFrame.getContentPane().add(top, BorderLayout.NORTH);
		myFrame.getContentPane().add(myPanel, BorderLayout.CENTER);
		myFrame.getContentPane().add(underground, BorderLayout.SOUTH);
		
		myFrame.repaint();
		myFrame.revalidate();

		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Close the window to stop the program
		myFrame.setVisible(true);
		
		this.myFrame=myFrame;
		this.ticket=ticket;
	}
	
	/**
	 * This is an inner class, respond to the button "login".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class login implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new LoginInterface(myFrame,ticket);
		}
	}
	/**
	 * This is an inner class, respond to the button "register".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class register implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new RegisterInterface(myFrame,ticket);
		}
	}
	/**
	 * This is an inner class, respond to the button "finish".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class finish implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new NormalPayment(myFrame,ticket);
		}
	}
}
