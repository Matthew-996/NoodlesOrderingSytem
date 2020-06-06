import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//import java.awt.BorderLayout;

/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * This is a interface to finish self-help order.
 * 
 * @author Yuyang Wu
 * @version 1.0
 */

public class Menu {
	JFrame myFrame;
	JDialog myDialog;
	JRadioButton s1,s2,s3,				//soup
			n1,n2,n3,					//noodles
			o1,o2,o3,					//spring onion
			sp1,sp2,sp3,sp4,sp5,sp6,	//spiciness
			no1,no2,					//Nori
			ch1,ch2,					//Chashu
			egg1,egg2,					//Boiled egg
			ex1,ex2,ex3,ex4,ex5,ex6,ex7,ex8,
			back;
	JPanel myPanel,underground;
	JLabel top,soup,noodles,onion,sp,
			Nori,Chashu,egg,
			ext1,ext2,ext3,ext4,
			error;
	ButtonGroup sop,noo,oni,spy,
				nor,cha,begg,
				extra1,extra2,extra3,extra4;
	Ticket ticket;
	Ramen ramen;
	ManagementControl mc;
	CustomerControl cc;
	ReportControl rc;
	
	public Menu() {
		mc = new ManagementControl();
		cc = new CustomerControl();
		rc=new ReportControl();
		ticket = cc.createTicket();

		ramen = ManagementControl.RamenRead();						//read Ramen's infromation from file
		
		myFrame = new JFrame("Self-Service kiosk");
		myFrame.setSize(950, 750);
		
		myFrame.setLayout(new BorderLayout());
		top=new JLabel();
		top.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		top.setText("Choose your meal combination:");
		
		myDialog=new JDialog(myFrame);
		error = new JLabel("You didn't finish order!");
		error.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		myDialog.add(error);
		myDialog.setBounds(100,0,400,300);
		myDialog.setLocationRelativeTo(null);
		
		myPanel=new JPanel();
		myPanel.setLayout(null);
		TitledBorder b1=BorderFactory.createTitledBorder("What you want to do");
		myPanel.setBorder(b1);
		
		soup=new JLabel();
		soup.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		soup.setText("Soup:");
		myPanel.add(soup);
		soup.setBounds(72,20,200,50);
		
		s1=new JRadioButton("Tonkotsu");
		s1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		s1.setBounds(150,20,200,50);
		myPanel.add(s1);
		/*s1.setEnabled(false);
		s1.setText("Sell out");*/
		s1.addActionListener(new chooseSoup());
		if(mc.getSoup(ramen)[0]==0) 
			s1.setEnabled(false);
		
		
		s2=new JRadioButton("Shoyu");
		s2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		s2.setBounds(400,20,200,50);
		myPanel.add(s2);
		s2.addActionListener(new chooseSoup());
		if(mc.getSoup(ramen)[1]==0) 
			s2.setEnabled(false);
		
		s3=new JRadioButton("Shio");									//final soup
		s3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		s3.setBounds(650,20,200,50);
		myPanel.add(s3);
		s3.addActionListener(new chooseSoup());
		if(mc.getSoup(ramen)[2]==0) 
			s3.setEnabled(false);
		
		sop=new ButtonGroup();	
		sop.add(s1);
		sop.add(s2);
		sop.add(s3);
	
		noodles=new JLabel();
		noodles.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		noodles.setText("Noodles:");
		myPanel.add(noodles);
		noodles.setBounds(37,85,200,50);;
		
		n1=new JRadioButton("Soft");
		n1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		n1.setBounds(150,85,200,50);
		myPanel.add(n1);
		n1.addActionListener(new chooseNoodles());
		if(mc.getNoodles(ramen)[0]==0) 
			n1.setEnabled(false);

		n2=new JRadioButton("Medium");
		n2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		n2.setBounds(400,85,200,50);
		myPanel.add(n2);
		n2.addActionListener(new chooseNoodles());
		if(mc.getNoodles(ramen)[1]==0) 
			n2.setEnabled(false);
		
		n3=new JRadioButton("Firm");/////////////////////////////////////////////Final noodles
		n3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		n3.setBounds(650,85,200,50);
		myPanel.add(n3);
		n3.addActionListener(new chooseNoodles());
		if(mc.getNoodles(ramen)[2]==0) 
			n3.setEnabled(false);
		
		noo=new ButtonGroup();	
		noo.add(n1);
		noo.add(n2);
		noo.add(n3);
		
		onion=new JLabel();
		onion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		onion.setText("Spring onion:");
		myPanel.add(onion);
		onion.setBounds(10,150,200,50);;
		
		o1=new JRadioButton("No please");
		o1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		o1.setBounds(150,150,200,50);
		myPanel.add(o1);
		o1.addActionListener(new chooseOnion());
		if(mc.getSpringOnion(ramen)[0]==0) 
			o1.setEnabled(false);
		
		o2=new JRadioButton("Just a little");
		o2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		o2.setBounds(400,150,200,50);
		myPanel.add(o2);
		o2.addActionListener(new chooseOnion());
		if(mc.getSpringOnion(ramen)[1]==0) 
			o2.setEnabled(false);
		
		o3=new JRadioButton("A lot");
		o3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		o3.setBounds(650,150,200,50);
		myPanel.add(o3);
		o3.addActionListener(new chooseOnion());
		if(mc.getSpringOnion(ramen)[2]==0) 
			o3.setEnabled(false);
		
		oni=new ButtonGroup();	///////////////////////////////////////Final onion
		oni.add(o1);
		oni.add(o2);
		oni.add(o3);
		
		sp=new JLabel();
		sp.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		sp.setText("Spiciness:");
		myPanel.add(sp);
		sp.setBounds(17,215,200,50);;
		
		sp1=new JRadioButton("0(No)");
		sp1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		sp1.setBounds(150,215,100,50);
		myPanel.add(sp1);
		sp1.addActionListener(new chooseSpiciness());
		if(mc.getSpiciness(ramen)[0]==0) 
			sp1.setEnabled(false);
		
		sp2=new JRadioButton("1");
		sp2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		sp2.setBounds(250,215,100,50);
		myPanel.add(sp2);
		sp2.addActionListener(new chooseSpiciness());
		if(mc.getSpiciness(ramen)[1]==0) 
			sp2.setEnabled(false);
		
		sp3=new JRadioButton("2");
		sp3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		sp3.setBounds(350,215,100,50);
		myPanel.add(sp3);
		sp3.addActionListener(new chooseSpiciness());
		if(mc.getSpiciness(ramen)[2]==0) 
			sp3.setEnabled(false);
		
		sp4=new JRadioButton("3");
		sp4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		sp4.setBounds(450,215,100,50);
		myPanel.add(sp4);
		sp4.addActionListener(new chooseSpiciness());
		if(mc.getSpiciness(ramen)[3]==0) 
			sp4.setEnabled(false);
		
		sp5=new JRadioButton("4");
		sp5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		sp5.setBounds(550,215,100,50);
		myPanel.add(sp5);
		sp5.addActionListener(new chooseSpiciness());
		if(mc.getSpiciness(ramen)[4]==0) 
			sp5.setEnabled(false);
		
		sp6=new JRadioButton("5(Max)");
		sp6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		sp6.setBounds(650,215,200,50);
		myPanel.add(sp6);
		sp6.addActionListener(new chooseSpiciness());
		if(mc.getSpiciness(ramen)[5]==0) 
			sp6.setEnabled(false);
		
		spy=new ButtonGroup();	
		spy.add(sp1);
		spy.add(sp2);
		spy.add(sp3);
		spy.add(sp4);
		spy.add(sp5);
		spy.add(sp6);
		
		Nori=new JLabel();
		Nori.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		Nori.setText("Nori:");
		myPanel.add(Nori);
		Nori.setBounds(82,280,200,50);
		
		no1=new JRadioButton("Yes");
		no1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		no1.setBounds(150,280,100,50);
		myPanel.add(no1);
		no1.addActionListener(new chooseNori());
		if(mc.getNori(ramen)[0]==0) 
			no1.setEnabled(false);
		
		no2=new JRadioButton("No");
		no2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		no2.setBounds(250,280,100,50);
		myPanel.add(no2);
		no2.addActionListener(new chooseNori());
		/*if(mc.getNori(ramen)[1]==0) 
			no2.setEnabled(false);*/
		
		nor=new ButtonGroup();	////////////////////////////////////Final Nori
		nor.add(no1);
		nor.add(no2);
		
		
		Chashu=new JLabel();
		Chashu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		Chashu.setText("Chashu:");
		myPanel.add(Chashu);
		Chashu.setBounds(39,345,200,50);;
		
		ch1=new JRadioButton("Yes");
		ch1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ch1.setBounds(150,345,100,50);
		myPanel.add(ch1);
		ch1.addActionListener(new chooseChashu());
		if(mc.getChashu(ramen)[0]==0) 
			ch1.setEnabled(false);

		
		ch2=new JRadioButton("No");
		ch2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ch2.setBounds(250,345,100,50);
		myPanel.add(ch2);
		ch2.addActionListener(new chooseChashu());
		/*if(mc.getChashu(ramen)[1]==0) 
			ch2.setEnabled(false);*/
		
		cha=new ButtonGroup();	////////////////////////////////////////////Final Chashu
		cha.add(ch1);
		cha.add(ch2);
		
		egg=new JLabel();
		egg.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		egg.setText("Boiled egg:");
		myPanel.add(egg);
		egg.setBounds(7,410,200,50);
		
		
		egg1=new JRadioButton("Yes");
		egg1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		egg1.setBounds(150,410,100,50);
		myPanel.add(egg1);
		egg1.addActionListener(new chooseEgg());
		if(mc.getBoiledEgg(ramen)[0]==0) 
			egg1.setEnabled(false);
		
		egg2=new JRadioButton("No");
		egg2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		egg2.setBounds(250,410,100,50);
		myPanel.add(egg2);
		egg2.addActionListener(new chooseEgg());
		/*if(mc.getBoiledEgg(ramen)[1]==0) 
			egg2.setEnabled(false);*/
		
		begg=new ButtonGroup();	
		begg.add(egg1);
		begg.add(egg2);
		
		ext1=new JLabel();
		ext1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		ext1.setText("Extra Nori("+ mc.getExtraNoriPrice(ramen)+"f):");
		myPanel.add(ext1);
		ext1.setBounds(350,280,200,50);
		ext1.setForeground(Color.red);
		
		ex1=new JRadioButton("Yes");
		ex1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ex1.setBounds(550,280,100,50);
		myPanel.add(ex1);
		ex1.addActionListener(new chooseExtraNori());
		if(mc.getExtraNori(ramen)==0) 
			ex1.setEnabled(false);
		
		ex2=new JRadioButton("No");
		ex2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ex2.setBounds(650,280,100,50);
		myPanel.add(ex2);
		ex2.addActionListener(new chooseExtraNori());
		/*if(mc.getExtraNori(ramen)==0) 
			ex2.setEnabled(false);*/
		
		extra1=new ButtonGroup();	
		extra1.add(ex1);
		extra1.add(ex2);
		
		ext2=new JLabel();
		ext2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		ext2.setText("Extra Chashu("+mc.getExtraChashuPrice(ramen)+"f):");
		myPanel.add(ext2);
		ext2.setBounds(350,345,200,50);;
		ext2.setForeground(Color.red);
		
		ex3=new JRadioButton("Yes");
		ex3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ex3.setBounds(550,345,100,50);
		myPanel.add(ex3);
		ex3.addActionListener(new chooseExtraChashu());
		if(mc.getExtraChashu(ramen)==0) 
			ex3.setEnabled(false);
		
		ex4=new JRadioButton("No");
		ex4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ex4.setBounds(650,345,100,50);
		myPanel.add(ex4);
		ex4.addActionListener(new chooseExtraChashu());
		/*if(mc.getExtraChashu(ramen)==0) 
			ex4.setEnabled(false);*/
		
		extra2=new ButtonGroup();	
		extra2.add(ex3);
		extra2.add(ex4);
		
		ext3=new JLabel();
		ext3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		ext3.setText("Extra Boiled egg("+mc.getExtraBoiledEggPrice(ramen)+"f):");
		myPanel.add(ext3);
		ext3.setBounds(350,410,200,50);;
		ext3.setForeground(Color.red);
		
		ex5=new JRadioButton("Yes");
		ex5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ex5.setBounds(550,410,100,50);
		myPanel.add(ex5);
		ex5.addActionListener(new chooseExtraEgg());
		if(mc.getExtraBoiledEgg(ramen)==0) 
			ex5.setEnabled(false);
		
		ex6=new JRadioButton("No");
		ex6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ex6.setBounds(650,410,100,50);
		myPanel.add(ex6);
		ex6.addActionListener(new chooseExtraEgg());
		/*if(mc.getExtraBoiledEgg(ramen)==0) 
			ex6.setEnabled(false);*/
		
		extra3=new ButtonGroup();	
		extra3.add(ex5);
		extra3.add(ex6);
		
		ext4=new JLabel();
		ext4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		ext4.setText("Bomboo shoots("+mc.getBambooShootsPrice(ramen)+"f):");
		myPanel.add(ext4);
		ext4.setBounds(350,475,200,50);;
		ext4.setForeground(Color.red);
		
		ex7=new JRadioButton("Yes");
		ex7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ex7.setBounds(550,475,100,50);
		myPanel.add(ex7);
		ex7.addActionListener(new chooseExtraBambooshoots());
		if(mc.getBambooShoots(ramen)==0) 
			ex7.setEnabled(false);
		
		ex8=new JRadioButton("No");
		ex8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		ex8.setBounds(650,475,100,50);
		myPanel.add(ex8);
		ex8.addActionListener(new chooseExtraBambooshoots());
		/*if(mc.getBambooShoots(ramen)==0) 
			ex8.setEnabled(false);*/
		
		extra4=new ButtonGroup();	
		extra4.add(ex7);
		extra4.add(ex8);
		
		
		underground=new JPanel();
		underground.setLayout(null);
		underground.setPreferredSize(new Dimension(100,100));
		
		JButton recommand = new JButton("Recommend");
		recommand.setBounds(125,10,300,80);
		recommand.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		underground.add(recommand);
		recommand.addActionListener(new recommend());
		
		JButton back = new JButton("Confirm");
		back.setBounds(525,10,300,80);
		back.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		underground.add(back);
		back.addActionListener(new confirmOrder());
		
		myFrame.getContentPane().add(top, BorderLayout.NORTH);
		myFrame.getContentPane().add(myPanel, BorderLayout.CENTER);
		myFrame.getContentPane().add(underground, BorderLayout.SOUTH);
		//System.out.println("0");
		
		myFrame.repaint();
		myFrame.revalidate();

		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Close the window to stop the program
		myFrame.setVisible(true);
		
	}
	
	/**
	 * This is an inner class, respond to the button "recommend".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class recommend implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(rc.getRecommendReport()[0]==0&&mc.getSoup(ramen)[0]==1) {
				s1.setSelected(true);
				ticket = cc.setSoupChoice(ticket,1);
			}
			if(rc.getRecommendReport()[0]==1&&mc.getSoup(ramen)[1]==1) {
				s2.setSelected(true);
				ticket = cc.setSoupChoice(ticket,2);
			}
			if(rc.getRecommendReport()[0]==2&&mc.getSoup(ramen)[2]==1) {
				s3.setSelected(true);
				ticket = cc.setSoupChoice(ticket,3);
			}
			
			
			if(rc.getRecommendReport()[1]==0&&mc.getNoodles(ramen)[0]==1) {
				n1.setSelected(true);
				ticket = cc.setNoodlesChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[1]==1&&mc.getNoodles(ramen)[1]==1) {
				n2.setSelected(true);
				ticket = cc.setNoodlesChoice(ticket, 2);
			}
			if(rc.getRecommendReport()[1]==2&&mc.getNoodles(ramen)[2]==1) {
				n3.setSelected(true);
				ticket = cc.setNoodlesChoice(ticket, 3);
			}
			
			if(rc.getRecommendReport()[2]==0&&mc.getSpringOnion(ramen)[0]==1) {
				o1.setSelected(true);
				ticket = cc.setSpringOnionChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[2]==1&&mc.getSpringOnion(ramen)[1]==1) {
				o2.setSelected(true);
				ticket = cc.setSpringOnionChoice(ticket, 2);
			}
			if(rc.getRecommendReport()[2]==2&&mc.getSpringOnion(ramen)[2]==1) {
				o3.setSelected(true);
				ticket = cc.setSpringOnionChoice(ticket, 3);
			}
			
			if(rc.getRecommendReport()[3]==0&&mc.getSpiciness(ramen)[0]==1) {
				sp1.setSelected(true);
				ticket = cc.setSpicinessChoice(ticket, 0);
			}
			if(rc.getRecommendReport()[3]==1&&mc.getSpiciness(ramen)[1]==1) {
				sp2.setSelected(true);
				ticket = cc.setSpicinessChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[3]==2&&mc.getSpiciness(ramen)[2]==1) {
				sp3.setSelected(true);
				ticket = cc.setSpicinessChoice(ticket, 2);
			}
			if(rc.getRecommendReport()[3]==3&&mc.getSpiciness(ramen)[3]==1) {
				sp4.setSelected(true);
				ticket = cc.setSpicinessChoice(ticket, 3);
			}
			if(rc.getRecommendReport()[3]==4&&mc.getSpiciness(ramen)[4]==1) {
				sp5.setSelected(true);
				ticket = cc.setSpicinessChoice(ticket, 4);
			}
			if(rc.getRecommendReport()[3]==5&&mc.getSpiciness(ramen)[5]==1) {
				sp6.setSelected(true);
				ticket = cc.setSpicinessChoice(ticket, 5);
			}
			
			if(rc.getRecommendReport()[4]==0&&mc.getNori(ramen)[0]==1) {
				no1.setSelected(true);
				ticket = cc.setNoriChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[4]==1&&mc.getNori(ramen)[1]==1) {
				no2.setSelected(true);
				ticket = cc.setNoriChoice(ticket, 0);
			}
			
			if(rc.getRecommendReport()[5]==0&&mc.getChashu(ramen)[0]==1) {
				ch1.setSelected(true);
				ticket = cc.setChashuChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[5]==1&&mc.getChashu(ramen)[1]==1) {
				ch2.setSelected(true);
				ticket = cc.setChashuChoice(ticket, 0);
			}
			
			if(rc.getRecommendReport()[6]==0&&mc.getBoiledEgg(ramen)[0]==1) {
				egg1.setSelected(true);
				ticket = cc.setBoiledEggChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[6]==1&&mc.getBoiledEgg(ramen)[1]==1) {
				egg2.setSelected(true);
				ticket = cc.setBoiledEggChoice(ticket, 0);
			}
			
			if(rc.getRecommendReport()[7]==0&&mc.getExtraNori(ramen)==1) {
				ex1.setSelected(true);
				ticket = cc.setExtraNoriChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[7]==1&&mc.getExtraNori(ramen)==1) {
				ex2.setSelected(true);
				ticket = cc.setExtraNoriChoice(ticket, 0);
			}
			
			if(rc.getRecommendReport()[8]==0&&mc.getExtraChashu(ramen)==1) {
				ex3.setSelected(true);
				ticket = cc.setExtraChashuChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[8]==1&&mc.getExtraChashu(ramen)==1) {
				ex4.setSelected(true);
				ticket = cc.setExtraChashuChoice(ticket, 0);
			}
			
			if(rc.getRecommendReport()[9]==0&&mc.getExtraBoiledEgg(ramen)==1) {
				ex5.setSelected(true);
				ticket = cc.setExtraBoiledEggChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[9]==1&&mc.getExtraBoiledEgg(ramen)==1) {
				ex6.setSelected(true);
				ticket = cc.setExtraBoiledEggChoice(ticket, 0);
			}
			
			if(rc.getRecommendReport()[10]==0&&mc.getBambooShoots(ramen)==1) {
				ex7.setSelected(true);
				ticket = cc.setBambooShootsChoice(ticket, 1);
			}
			if(rc.getRecommendReport()[10]==1&&mc.getBambooShoots(ramen)==1) {
				ex8.setSelected(true);
				ticket = cc.setBambooShootsChoice(ticket, 0);
			}
		}
	}

	/**
	 * This is an inner class, respond to the button group "sop".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseSoup implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==s1) { 
				ticket = cc.setSoupChoice(ticket,1);
				System.out.println("a");
			}
			else if(e.getSource()==s2) 
				ticket = cc.setSoupChoice(ticket,2);
			else if(e.getSource()==s3)
				ticket = cc.setSoupChoice(ticket,3);	
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "noo".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseNoodles implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==n1) 
				ticket = cc.setNoodlesChoice(ticket, 1);
			else if(e.getSource()==n2) 
				ticket = cc.setNoodlesChoice(ticket, 2);
			else if(e.getSource()==n3)
				ticket = cc.setNoodlesChoice(ticket, 3);	
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "oni".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseOnion implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==o1) 
				ticket = cc.setSpringOnionChoice(ticket, 1);
			else if(e.getSource()==o2) 
				ticket = cc.setSpringOnionChoice(ticket, 2);
			else if(e.getSource()==o3)
				ticket = cc.setSpringOnionChoice(ticket, 3);
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "spy".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseSpiciness implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==sp1) 
				ticket = cc.setSpicinessChoice(ticket, 0);
			else if(e.getSource()==sp2) 
				ticket = cc.setSpicinessChoice(ticket, 1);
			else if(e.getSource()==sp3)
				ticket = cc.setSpicinessChoice(ticket, 2);
			else if(e.getSource()==sp4)
				ticket = cc.setSpicinessChoice(ticket, 3);
			else if(e.getSource()==sp5)
				ticket = cc.setSpicinessChoice(ticket, 4);
			else if(e.getSource()==sp6)
				ticket = cc.setSpicinessChoice(ticket, 5);
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "nor".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseNori implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==no1) 
				ticket = cc.setNoriChoice(ticket, 1);
			else if(e.getSource()==no2) 
				ticket = cc.setNoriChoice(ticket, 0);
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "cha".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseChashu implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==ch1) 
				ticket = cc.setChashuChoice(ticket, 1);
			else if(e.getSource()==ch2) 
				ticket = cc.setChashuChoice(ticket, 0);
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "begg".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseEgg implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==egg1) 
				ticket = cc.setBoiledEggChoice(ticket, 1);
			else if(e.getSource()==egg2) 
				ticket = cc.setBoiledEggChoice(ticket, 0);
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "extra1".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseExtraNori implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==ex1) 
				ticket = cc.setExtraNoriChoice(ticket, 1);
			else if(e.getSource()==ex2) 
				ticket = cc.setExtraNoriChoice(ticket, 0);
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "extra2".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseExtraChashu implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==ex3) 
				ticket = cc.setExtraChashuChoice(ticket, 1);
			else if(e.getSource()==ex4) 
				ticket = cc.setExtraChashuChoice(ticket, 0);
		}
	}

	/**
	 * This is an inner class, respond to the button group "extra3".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseExtraEgg implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==ex5) 
				ticket = cc.setExtraBoiledEggChoice(ticket, 1);
			else if(e.getSource()==ex6) 
				ticket = cc.setExtraBoiledEggChoice(ticket, 0);
		}
	}
	
	/**
	 * This is an inner class, respond to the button group "extra4".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class chooseExtraBambooshoots implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==ex7) 
				ticket = cc.setBambooShootsChoice(ticket, 1);
			else if(e.getSource()==ex8) 
				ticket = cc.setBambooShootsChoice(ticket, 0);
		}
	}
	

	/**
	 * This is an inner class, respond to the button "confirm".
	 * 
	 * @author Yuyang Wu
	 * @version 1.0
	 */	
	public class confirmOrder implements ActionListener{

		public void actionPerformed(ActionEvent e){
			
			if(cc.getSoupChoice(ticket)==0||cc.getNoodlesChoice(ticket)==0||cc.getSpringOnionChoice(ticket)==0) {
				myDialog.setVisible(true);
			}
			else{
				cc.getTotalPrice(ticket, mc.getExtraNoriPrice(ramen), mc.getExtraBoiledEggPrice(ramen), mc.getBambooShootsPrice(ramen), mc.getExtraChashuPrice(ramen));
				new ChooseWay(myFrame,ticket);
			}
				
			
		}
	}
}


	
	
