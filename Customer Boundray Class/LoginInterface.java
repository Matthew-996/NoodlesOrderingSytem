import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

/**
 * This is a interface for member users to login.
 * 
 * @author Yuyang Wu
 * @version 1.0
 */	
public class LoginInterface {
	JFrame myFrame;
	Ticket ticket;
	JLabel top,welcome,title,title2,under1,under2,error;
	JPanel myPanel,underground;
	JTextField memberID;
	JPasswordField passWord;
	JButton login,back;
	JDialog myDialog;
	
	String surname,firstname,memberId,password;
	int stamp,id;
	MemberControl mco;
	
	public LoginInterface(JFrame myFrame,Ticket ticket) {
		myFrame.getContentPane().removeAll();
		myFrame.getContentPane().setLayout(new BorderLayout());
		
		myFrame.setLayout(new BorderLayout());
		top=new JLabel();
		top.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		top.setText("Membership System");
		
		myDialog=new JDialog(myFrame);
		error = new JLabel("Don't find match information!");
		error.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		myDialog.add(error);
		myDialog.setBounds(100,0,400,300);
		myDialog.setLocationRelativeTo(null);
		
		myPanel=new JPanel();
		myPanel.setLayout(null);
		TitledBorder b1=BorderFactory.createTitledBorder("What you need to do:");
		myPanel.setBorder(b1);
		
		welcome = new JLabel("Welcome to membership system! Please enter your:");
		welcome.setBounds(10,25,950,80);
		welcome.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(welcome);
		
		title = new JLabel("Membership ID:");
		title.setBounds(150,120,350,80);
		title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(title);
		
		memberID = new JTextField();
		memberID.setBounds(400,135,400,50);
		memberID.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(memberID);
		
		title2 = new JLabel("Password:");
		title2.setBounds(150,200,350,80);
		title2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(title2);
		
		passWord = new JPasswordField();
		passWord.setBounds(400,215,400,50);
		passWord.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(passWord);
		passWord.setEchoChar('\u2605');
		
		
		login = new JButton("Login");
		login.setBounds(350,350,200,60);
		login.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(login);
		login.addActionListener(new login());
		
		back = new JButton("Back");
		back.setBounds(350,450,200,60);
		back.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(back);
		back.addActionListener(new back());
		
		underground=new JPanel();
		underground.setLayout(null);
		underground.setPreferredSize(new Dimension(100,100));
		
		under1 = new JLabel("We'll send you an email or an SMS with your present number of stamps after the new stamp");
		under1.setBounds(50,20,950,20);
		under1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		underground.add(under1);
		
		under2 = new JLabel(" recorded successfully!");
		under2.setBounds(0,40,950,20);
		under2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		underground.add(under2);
		
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
			mco=new MemberControl();
			memberId=memberID.getText();
			password=passWord.getText();
			
			//id=Integer.parseInt(memberId);
			//System.out.println(id);
			surname=mco.getSurname(memberId);////////getSurname
			firstname=mco.getFirstname(memberId);/////////getFirstname
			stamp=mco.login(memberId,password);
			System.out.println(stamp);
			if(stamp>=0) {
				new MembershipPayment(myFrame,ticket,stamp,firstname,surname);////////////login successful
			}
			else if(stamp==-1){
				myDialog.setVisible(true);
				error.setText("The user does not exist.");
				memberID.setText("");
				passWord.setText("");
			}
			else if(stamp==-11){
				myDialog.setVisible(true);
				error.setText("Password ERROR!");
				passWord.setText("");
			}
		}
	}
	/**
	 * This is an inner class, respond to the button "back".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new ChoosePayment(myFrame,ticket);
		}
	}
}
