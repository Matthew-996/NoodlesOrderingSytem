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
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;


/**
 * This is a interface to for regular cuntomers to become a member in restaurant.
 * 
 * @author Yuyang Wu
 * @version 1.0
 */	
public class RegisterInterface {
	JFrame myFrame;
	Ticket ticket;
	JLabel top,welcome,hei,title1,title2,title3,title4,under1,under2,error1,error2,error3;
	JPanel myPanel,underground;
	JTextField firstName,surName,contact,passWord;
	JButton register,back;
	JDialog myDialog;
	
	int stamp;
	String firstname,surname,contacts,password;
	Member newMember;
	MemberControl mco;
	
	public RegisterInterface(JFrame myFrame,Ticket ticket) {
		myFrame.getContentPane().removeAll();
		myFrame.getContentPane().setLayout(new BorderLayout());
		
		myFrame.setLayout(new BorderLayout());
		top=new JLabel();
		top.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		top.setText("Membership System");
		
		myDialog=new JDialog(myFrame);
		error1 = new JLabel("");
		error1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myDialog.add(error1);
		myDialog.setBounds(100,0,600,300);
		myDialog.setLocationRelativeTo(null);
		error1.setBounds(0, 0, 500, 100);
		
		error2 = new JLabel("");
		error2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myDialog.add(error2);
		error2.setBounds(0, 40, 500, 100);
		
		
		error3 = new JLabel("");
		error3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myDialog.add(error3);
		error3.setBounds(0, 200, 500, 100);
		
		
		myPanel=new JPanel();
		myPanel.setLayout(null);
		TitledBorder b1=BorderFactory.createTitledBorder("What you need to do:");
		myPanel.setBorder(b1);
		
		welcome = new JLabel("Welcome to membership system! Please finish registering:");
		welcome.setBounds(10,25,950,80);
		welcome.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(welcome);
		
		title1 = new JLabel("First name:");
		title1.setBounds(50,105,350,80);
		title1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(title1);
		
		firstName = new JTextField();
		firstName.setBounds(400,120,400,50);
		firstName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(firstName);
		
		title2 = new JLabel("Surname:");
		title2.setBounds(50,185,350,80);
		title2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(title2);
		
		surName = new JTextField();
		surName.setBounds(400,200,400,50);
		surName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(surName);
		
		title3 = new JLabel("Contact:");
		title3.setBounds(50,265,350,80);
		title3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(title3);
		
		contact = new JTextField();
		contact.setBounds(400,280,400,50);
		contact.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(contact);
		
		title4 = new JLabel("Password:");
		title4.setBounds(50,345,350,80);
		title4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(title4);
		
		passWord = new JTextField();
		passWord.setBounds(400,360,400,50);
		passWord.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(passWord);
		
		register = new JButton("register");
		register.setBounds(350,420,200,60);
		register.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(register);
		register.addActionListener(new register());
		
		back = new JButton("Back");
		back.setBounds(350,490,200,60);
		back.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(back);
		back.addActionListener(new back());
		
		underground=new JPanel();
		underground.setLayout(null);
		underground.setPreferredSize(new Dimension(100,100));
		
		under1 = new JLabel("Please make sure your contact information is validate and we'll send you an email or a SNS ");
		under1.setBounds(50,20,950,20);
		under1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		under1.setLayout(null);
		underground.add(under1);
		
		under2 = new JLabel("with your membership number.");
		under2.setBounds(0,40,950,20);
		under2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		under2.setLayout(null);
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
	 * This is an inner class, respond to the button "register".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */
	public class register implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mco=new MemberControl();
			firstname=firstName.getText();
			surname=surName.getText();
			contacts=contact.getText();
			password=passWord.getText();
			error1.setText("");
			error2.setText("");
			error3.setText("");
			
			
			if(!mco.nameValidation(firstname)){
				firstName.setText("");
				error1.setText("Wrong firstname format");
				myDialog.setVisible(true);
			}
			
			if(!mco.nameValidation(surname)){
				surName.setText("");
				error2.setText("Wrong surname format");
				myDialog.setVisible(true);
			}
			
			if(!(mco.mailValidation(contacts)||mco.phoneValidation(contacts))){
				contact.setText("");
				error3.setText("Wrong contact format");
				myDialog.setVisible(true);
			}
			
			if(firstname.isEmpty()||surname.isEmpty()||contacts.isEmpty()||password.isEmpty()) {
				myDialog.setVisible(true);
				error1.setText("You didn't finish information!");
				error2.setText("");
				error3.setText("");
			}
			
			if((mco.mailValidation(contacts)||mco.phoneValidation(contacts))&&(mco.nameValidation(firstname))&&(mco.nameValidation(surname))) {
				
				newMember=new Member(surname,firstname,contacts,password);
				mco.memberRegister(newMember);
				stamp=mco.getNumberOfStamps(newMember);
				new MembershipPayment(myFrame,ticket,stamp,firstname,surname);

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
