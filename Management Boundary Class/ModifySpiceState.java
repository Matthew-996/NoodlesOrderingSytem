import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
    /**
	 * This is the Interface of modifying the State of Spice option.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */
public class ModifySpiceState {
    ManagementControl mc;
    Ramen rm;
    JFrame BeforeFrame;
    JPanel Center,Down;
    JLabel Czero,Cone,Ctwo,Cthree,Cfour,Cfive;
    JComboBox<String> Mzero,Mone,Mtwo,Mthree,Mfour,Mfive;
    JButton confirm;
    String szero,sone,stwo,sthree,sfour,sfive;
    public ModifySpiceState(ManagementControl amc, Ramen arm) {
        mc=amc;
        rm=arm;
        BeforeFrame=new JFrame();
        //set Center of Panel
        Center=new JPanel();
        Center.setLayout(new GridLayout(7,3));
        //1
        Center.add(new JLabel());
        Center.add(new JLabel("Current"));
        Center.add(new JLabel("Modify"));
        //2
        Center.add(new JLabel("Zero Spiciness:can be ordered"));
        Czero=new JLabel();
        if(mc.getSpiciness(rm)[0]==1) {
            Czero.setText("Yes");
        }
        else {
            Czero.setText("No");
        }
        Mzero=new JComboBox<>();
        Mzero.addItem("Yes");
        Mzero.addItem("No");
        Center.add(Czero);
        Center.add(Mzero);
        //3
        Center.add(new JLabel("One Spiciness:can be ordered"));
        Cone=new JLabel();
        if(mc.getSpiciness(rm)[1]==1) {
            Cone.setText("Yes");
        }
        else {
            Cone.setText("No");
        }
        Mone=new JComboBox<>();
        Mone.addItem("Yes");
        Mone.addItem("No");
        Center.add(Cone);
        Center.add(Mone);
        //4
        Center.add(new JLabel("Two Spiciness:can be ordered"));
        Ctwo=new JLabel();
        if(mc.getSpiciness(rm)[2]==1) {
            Ctwo.setText("Yes");
        }
        else {
            Ctwo.setText("No");
        }
        Mtwo=new JComboBox<>();
        Mtwo.addItem("Yes");
        Mtwo.addItem("No");
        Center.add(Ctwo);
        Center.add(Mtwo);
        //5
        Center.add(new JLabel("Three Spiciness:can be ordered"));
        Cthree=new JLabel();
        if(mc.getSpiciness(rm)[3]==1) {
            Cthree.setText("Yes");
        }
        else {
            Cthree.setText("No");
        }
        Mthree=new JComboBox<>();
        Mthree.addItem("Yes");
        Mthree.addItem("No");
        Center.add(Cthree);
        Center.add(Mthree);
        //6
        Center.add(new JLabel("Four Spiciness:can be ordered"));
        Cfour=new JLabel();
        if(mc.getSpiciness(rm)[4]==1) {
            Cfour.setText("Yes");
        }
        else {
            Cfour.setText("No");
        }
        Mfour=new JComboBox<>();
        Mfour.addItem("Yes");
        Mfour.addItem("No");
        Center.add(Cfour);
        Center.add(Mfour);
        //7
        Center.add(new JLabel("Five Spiciness:can be ordered"));
        Cfive=new JLabel();
        if(mc.getSpiciness(rm)[5]==1) {
            Cfive.setText("Yes");
        }
        else {
            Cfive.setText("No");
        }
        Mfive=new JComboBox<>();
        Mfive.addItem("Yes");
        Mfive.addItem("No");
        Center.add(Cfive);
        Center.add(Mfive);

        //set South of Frame
        Down=new JPanel();
        confirm=new JButton("Modify Confirm");
        confirm.addActionListener(new AskModify());
        Down.add(confirm);
        //set frame
        BeforeFrame.setTitle("Modify Extra Item State");
        BeforeFrame.setSize(950,750);
        BeforeFrame.setLayout(new BorderLayout());
        BeforeFrame.add(new Panel(),BorderLayout.NORTH);
        BeforeFrame.add(Center,BorderLayout.CENTER);
        BeforeFrame.add(Down,BorderLayout.SOUTH);
    }
    
    /**
	 * This is an inner class, respond to the button "Modify Confirm"
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	

    public class AskModify implements ActionListener {
        public void actionPerformed(ActionEvent e){
            szero=Mzero.getItemAt(Mzero.getSelectedIndex());
            sone=Mone.getItemAt(Mone.getSelectedIndex());
            stwo=Mtwo.getItemAt(Mtwo.getSelectedIndex());
            sthree=Mthree.getItemAt(Mthree.getSelectedIndex());
            sfour=Mfour.getItemAt(Mfour.getSelectedIndex());
            sfive=Mfive.getItemAt(Mfive.getSelectedIndex());
            int[] set=new int[6];
            if(szero.equals("Yes")) {
                set[0]=1;
            }
            else{
                set[0]=0;
            }
            if(sone.equals("Yes")) {
                set[1]=1;
            }
            else{
                set[1]=0;
            }
            if(stwo.equals("Yes")) {
                set[2]=1;
            }
            else{
                set[2]=0;
            }
            if(sthree.equals("Yes")) {
                set[3]=1;
            }
            else{
                set[3]=0;
            }
            if(sfour.equals("Yes")) {
                set[4]=1;
            }
            else{
                set[4]=0;
            }
            if(sfive.equals("Yes")) {
                set[5]=1;
            }
            else{
                set[5]=0;
            }

            mc.setSpiciness(rm,set);
            ManagementControl.RamenWrite(rm);
            if(mc.getSpiciness(rm)[0]==1) {
                Czero.setText("Yes");
            }
            else {
                Czero.setText("No");
            }
            if(mc.getSpiciness(rm)[1]==1) {
                Cone.setText("Yes");
            }
            else {
                Cone.setText("No");
            }
            if(mc.getSpiciness(rm)[2]==1) {
                Ctwo.setText("Yes");
            }
            else {
                Ctwo.setText("No");
            }
            if(mc.getSpiciness(rm)[3]==1) {
                Cthree.setText("Yes");
            }
            else {
                Cthree.setText("No");
            }
            if(mc.getSpiciness(rm)[4]==1) {
                Cfour.setText("Yes");
            }
            else {
                Cfour.setText("No");
            }
            if(mc.getSpiciness(rm)[5]==1) {
                Cfive.setText("Yes");
            }
            else {
                Cfive.setText("No");
            }
            BeforeFrame.setVisible(false);
        }
    }
}