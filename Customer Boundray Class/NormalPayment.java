import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import java.awt.BorderLayout;

/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * This is a interface for regular customers to finish payment.
 * 
 * @author Yuyang Wu
 * @version 1.0
 */	

public class NormalPayment {

	JFrame myFrame;
	JLabel top,soup,noodles,onion,sp,
	Nori,Chashu,egg,
	ext1,ext2,ext3,ext4,time,price;
	JPanel myPanel,underground;
	
	CustomerControl cc;
	Ticket ticket;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//ʱ��
	private String noticeDate="";
	
	
	public NormalPayment(JFrame myFrame,Ticket ticket) {
		myFrame.getContentPane().removeAll();
		myFrame.getContentPane().setLayout(new BorderLayout());
		
		cc = new CustomerControl();
		noticeDate=new String(df.format(new Date()));
		
		top=new JLabel();
		top.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		try {
			top.setText("Comfirm your choice:"+"                  "+df.parse(noticeDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		myPanel=new JPanel();
		myPanel.setLayout(null);
		TitledBorder b1=BorderFactory.createTitledBorder("Your Choice");
		myPanel.setBorder(b1);
		
		 String[] soups = {"Tonkotsu", "Shoyu", "Shio"};
	     String[] noodless = {"Soft", "Medium", "Firm"};
	     String[] springOnion = {"No please", "Just a little", "A lot!"};
	     String[] others = {"No" ,"Yes"};
		
		soup=new JLabel();
		soup.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		soup.setText("Soup:"+soups[(cc.getSoupChoice(ticket)-1)]);
		myPanel.add(soup);
		soup.setBounds(72,20,400,50);
		
		noodles=new JLabel();
		noodles.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		noodles.setText("Noodles:"+noodless[(cc.getNoodlesChoice(ticket)-1)]);
		myPanel.add(noodles);
		noodles.setBounds(37,85,400,50);
		
		onion=new JLabel();
		onion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		onion.setText("Spring onion:"+springOnion[(cc.getSpringOnionChoice(ticket)-1)]);
		myPanel.add(onion);
		onion.setBounds(10,150,400,50);
		
		sp=new JLabel();
		sp.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		sp.setText("Spiciness:"+ cc.getSpicinessChoice(ticket));
		myPanel.add(sp);
		sp.setBounds(17,215,400,50);
		
		Nori=new JLabel();
		Nori.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		Nori.setText("Nori:"+others[cc.getNoriChoice(ticket)]);
		myPanel.add(Nori);
		Nori.setBounds(82,280,400,50);
		
		Chashu=new JLabel();
		Chashu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		Chashu.setText("Chashu:"+others[cc.getChashuChoice(ticket)]);
		myPanel.add(Chashu);
		Chashu.setBounds(39,345,400,50);
		
		egg=new JLabel();
		egg.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		egg.setText("Boiled egg:"+others[cc.getBoiledEggChoice(ticket)]);
		myPanel.add(egg);
		egg.setBounds(7,410,400,50);
		
		ext1=new JLabel();
		ext1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ext1.setText("Extra Nori:"+others[cc.getExtraNoriChoice(ticket)]);
		myPanel.add(ext1);
		ext1.setBounds(400,85,500,50);
		
		ext2=new JLabel();
		ext2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ext2.setText("Extra boiled egg:"+others[cc.getExtraBoiledEggChoice(ticket)]);
		myPanel.add(ext2);
		ext2.setBounds(400,150,500,50);
		
		ext3=new JLabel();
		ext3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ext3.setText("Extra Bamboo shoots:"+others[cc.getBambooShootsChoice(ticket)]);
		myPanel.add(ext3);
		ext3.setBounds(400,215,500,50);
		
		ext4=new JLabel();
		ext4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ext4.setText("Extra Chashu:"+others[cc.getExtraChashuChoice(ticket)]);
		myPanel.add(ext4);
		ext4.setBounds(400,280,500,50);
		
		time=new JLabel();
		time.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		try {
			time.setText("Create Time:"+df.parse(noticeDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		myPanel.add(time);
		time.setBounds(400,20,500,50);
		
		price=new JLabel();
		price.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		price.setText("Price:"+cc.getTotalPrice(ticket));
		myPanel.add(price);
		price.setBounds(350,500,200,50);
		
		underground=new JPanel();
		underground.setLayout(null);
		underground.setPreferredSize(new Dimension(100,100));
		
		JButton pay = new JButton("Pay");
		pay.setBounds(50,10,300,80);
		pay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		underground.add(pay);
		pay.addActionListener(new pay());

		JButton back = new JButton("Back");
		back.setBounds(600,10,300,80);
		back.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		underground.add(back);
		back.addActionListener(new back());
		
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
	/**
	 * This is an inner class, respond to the button "pay".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class pay implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			cc.setPayByStamp(ticket, 0);
			cc.generateTicket(ticket);////////////////////////////////////////Create ticket
			System.exit(0);
		}
	}
}
