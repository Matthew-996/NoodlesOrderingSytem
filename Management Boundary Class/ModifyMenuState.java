import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    /**
	 * This is the Interface of modifying the State of the staff in menu.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */

public class ModifyMenuState {
    ManagementControl mc=new ManagementControl();;
    Ramen rm=ManagementControl.RamenRead();
    JFrame BeforeFrame;
    JPanel Center;
    JButton[] Choosewhich = new JButton[7]; 
    String[] ButtonText={"Modify Nori State","Modify Chashu State","Modify BoiledEgg State","Modigy Soup State",
                                    "Modify Noodle State","Modify Spice State","Modify Spring Onion State"};
    Font f=new Font("alias",Font.BOLD,16);
    ModifySoupState msoup;
    ModifyNoodleState mnoodle;
    ModifyNoriState mnori;
    ModifyChashuState mchashu;
    ModifyBoiledeggState mboiledegg;
    ModifySpiceState mspice;
    ModifyOnionState monion;
    public ModifyMenuState() {
        BeforeFrame=new JFrame();
        mboiledegg=new ModifyBoiledeggState(mc,rm);
        mchashu=new ModifyChashuState(mc,rm);
        mnoodle=new ModifyNoodleState(mc,rm);
        mnori=new ModifyNoriState(mc,rm);
        monion=new ModifyOnionState(mc,rm);
        msoup=new ModifySoupState(mc,rm);
        mspice=new ModifySpiceState(mc,rm);
        //set Center of Panel
        Center=new JPanel();
        //Center.setLayout(new GridLayout(7,1));
        Center.setLayout(null);

        for(int i=0;i<7;i+=1){
            Choosewhich[i]=new JButton(ButtonText[i]);
            Choosewhich[i].setFont(f);
            Choosewhich[i].addActionListener(new AskModify());
            Choosewhich[i].setBounds(250,30+80*i,300,60);
            Center.add(Choosewhich[i]);
        }

        //set frame
        BeforeFrame.setTitle("Modify State");
        BeforeFrame.setSize(800,660);
        BeforeFrame.setLayout(new BorderLayout());
        BeforeFrame.add(new Panel(),BorderLayout.NORTH);
        BeforeFrame.add(Center,BorderLayout.CENTER);
    }

    /**
	 * This is an inner class, respond to the buttons Choosewhich
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	

    public class AskModify implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==Choosewhich[0]) mnori.BeforeFrame.setVisible(true);
            else if(e.getSource()==Choosewhich[1]) mchashu.BeforeFrame.setVisible(true);
            else if(e.getSource()==Choosewhich[2]) mboiledegg.BeforeFrame.setVisible(true);
            else if(e.getSource()==Choosewhich[3]) msoup.BeforeFrame.setVisible(true);
            else if(e.getSource()==Choosewhich[4]) mnoodle.BeforeFrame.setVisible(true);
            else if(e.getSource()==Choosewhich[5]) mspice.BeforeFrame.setVisible(true);
            else if(e.getSource()==Choosewhich[6]) monion.BeforeFrame.setVisible(true);
        }
    }

    // public static void main(String[] args){
    //     ModifyMenuState mms = new ModifyMenuState();
    //     mms.BeforeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     mms.BeforeFrame.setVisible(true);
    // }
}

