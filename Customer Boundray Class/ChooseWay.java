import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
/**
 * This is a interface to finish dining choose.
 * 
 * @author Yuyang Wu
 * @version 1.0
 */	
public class ChooseWay {
	JFrame myFrame;
	Ticket ticket;
	JLabel top,error;
	JPanel myPanel,underground;
	JRadioButton eatIn,takeAway;
	ButtonGroup choose;
	JDialog myDialog;
	
	int state=0;
	CustomerControl cc;
	
	public ChooseWay(JFrame myFrame,Ticket ticket) {
		myFrame.getContentPane().removeAll();
		myFrame.getContentPane().setLayout(new BorderLayout());
		
		cc = new CustomerControl();
		
		myFrame.setLayout(new BorderLayout());
		top=new JLabel();
		top.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		top.setText("Choose Your Dining Way:");
		
		myDialog=new JDialog(myFrame);
		error = new JLabel("You must choose dining way!");
		error.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myDialog.add(error);
		myDialog.setBounds(100,0,400,300);
		myDialog.setLocationRelativeTo(null);
		
		myPanel=new JPanel();
		myPanel.setLayout(null);
		TitledBorder b1=BorderFactory.createTitledBorder("MAKE YOUR CHOICE");
		myPanel.setBorder(b1);
		
		eatIn = new JRadioButton("Eat In");
		eatIn.setBounds(300,150,300,80);
		eatIn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(eatIn);
		eatIn.addActionListener(new chooseWay());
		
		takeAway = new JRadioButton("Take Away");
		takeAway.setBounds(300,300,300,80);
		takeAway.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myPanel.add(takeAway);
		takeAway.addActionListener(new chooseWay());
		
		choose=new ButtonGroup();	
		choose.add(eatIn);
		choose.add(takeAway);
		
		underground=new JPanel();
		underground.setLayout(null);
		underground.setPreferredSize(new Dimension(100,100));
		
		JButton back = new JButton("Next step");
		back.setBounds(125,10,700,80);
		back.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		underground.add(back);
		back.addActionListener(new confirmChoice());
		
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
	 * This is an inner class, respond to the button group "choose".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseWay implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==eatIn) {
				state=1;
				cc.setTakeOrStay(ticket, 0);
			}
			else if(e.getSource()==takeAway) {
				state=1;
				cc.setTakeOrStay(ticket, 1);
			}
				
		}
	}

	/**
	 * This is an inner class, respond to the button "confirm".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class confirmChoice implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(state==0) {
				myDialog.setVisible(true);
			}
			else {
				new ChoosePayment(myFrame,ticket);
			}
		}
	}
}
