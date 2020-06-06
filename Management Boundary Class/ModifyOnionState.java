import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    /**
	 * This is the Interface of modifying the State of Onion.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */
public class ModifyOnionState {
    ManagementControl mc;
    Ramen rm;
    JFrame BeforeFrame;
    JPanel Center,Down;
    JLabel CNoplease,CJustalittle,CAlot;
    JComboBox<String> MNoplease,MJustalittle,MAlot;
    JButton confirm;
    String sNoplease,sJustalittle,sAlot;
    public ModifyOnionState(ManagementControl amc, Ramen arm) {
        mc=amc;
        rm=arm;
        BeforeFrame=new JFrame();
        //set Center of Panel
        Center=new JPanel();
        Center.setLayout(new GridLayout(4,3));
        //1
        Center.add(new JLabel());
        Center.add(new JLabel("Current"));
        Center.add(new JLabel("Modify"));
        //2
        Center.add(new JLabel("No please:can be ordered"));
        CNoplease=new JLabel();
        if(mc.getSpringOnion(rm)[0]==1) {
            CNoplease.setText("Yes");
        }
        else {
            CNoplease.setText("No");
        }
        MNoplease=new JComboBox<>();
        MNoplease.addItem("Yes");
        MNoplease.addItem("No");
        Center.add(CNoplease);
        Center.add(MNoplease);
        //3
        Center.add(new JLabel("Just a little:can be ordered"));
        CJustalittle=new JLabel();
        if(mc.getSpringOnion(rm)[1]==1){
            CJustalittle.setText("Yes");
        }
        else{
            CJustalittle.setText("No");
        }
        MJustalittle=new JComboBox<>();
        MJustalittle.addItem("Yes");
        MJustalittle.addItem("No");
        Center.add(CJustalittle);
        Center.add(MJustalittle);
        //4
        Center.add(new JLabel("A lot!:can be ordered"));
        CAlot=new JLabel();
        if(mc.getSpringOnion(rm)[2]==1) {
            CAlot.setText("Yes");
        }
        else {
            CAlot.setText("No");
        }
        MAlot=new JComboBox<>();
        MAlot.addItem("Yes");
        MAlot.addItem("No");
        Center.add(CAlot);
        Center.add(MAlot);

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
            sNoplease=MNoplease.getItemAt(MNoplease.getSelectedIndex());
            sJustalittle=MJustalittle.getItemAt(MJustalittle.getSelectedIndex());
            sAlot=MAlot.getItemAt(MAlot.getSelectedIndex());
            int[] set=new int[3];
            if(sNoplease.equals("Yes")) {
                set[0]=1;
            }
            else{
                set[0]=0;
            }
            if(sJustalittle.equals("Yes")) {
                set[1]=1;
            }
            else{
                set[1]=0;
            }
            if(sAlot.equals("Yes")) {
                set[2]=1;
            }
            else{
                set[2]=0;
            }

            mc.setSpringOnion(rm,set);
            ManagementControl.RamenWrite(rm);
            if(mc.getSpringOnion(rm)[0]==1) {
                CNoplease.setText("Yes");
            }
            else {
                CNoplease.setText("No");
            }
            if(mc.getSpringOnion(rm)[1]==1){
                CJustalittle.setText("Yes");
            }
            else{
                CJustalittle.setText("No");
            }
            if(mc.getSpringOnion(rm)[2]==1) {
                CAlot.setText("Yes");
            }
            else {
                CAlot.setText("No");
            }
            BeforeFrame.setVisible(false);
        }
    }
}