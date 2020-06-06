import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
	 * This is the Interface of modifying the State of BoiledEgg.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */
public class ModifyBoiledeggState {
    ManagementControl mc;
    Ramen rm;
    JFrame BeforeFrame;
    JPanel Center,Down;
    JLabel Cyes,Cno;
    JComboBox<String> Myes,Mno;
    JButton confirm;
    String syes,sno;
    public ModifyBoiledeggState(ManagementControl amc, Ramen arm) {
        mc=amc;
        rm=arm;
        BeforeFrame=new JFrame();
        //set Center of Panel
        Center=new JPanel();
        Center.setLayout(new GridLayout(3,3));
        //1
        Center.add(new JLabel());
        Center.add(new JLabel("Current"));
        Center.add(new JLabel("Modify"));
        //2
        Center.add(new JLabel("Boiled Egg:can be ordered"));
        Cyes=new JLabel();
        if(mc.getBoiledEgg(rm)[0]==1) {
//            System.out.println("yes: "+mc.getBoiledEgg(rm)[0]);
            Cyes.setText("Yes");
        }
        else {
//            System.out.println("yes: "+mc.getBoiledEgg(rm)[0]);
            Cyes.setText("No");
        }
        Myes=new JComboBox<>();
        Myes.addItem("Yes");
        Myes.addItem("No");
        Center.add(Cyes);
        Center.add(Myes);
        //3
        Center.add(new JLabel("Boiled Egg::can't be ordered"));
        Cno=new JLabel();
        if(mc.getBoiledEgg(rm)[1]==1){
//            System.out.println("no: "+mc.getBoiledEgg(rm)[1]);
            Cno.setText("Yes");
        }
        else{
//            System.out.println("no: "+mc.getBoiledEgg(rm)[1]);
            Cno.setText("No");
        }
        Mno=new JComboBox<>();
        Mno.addItem("Yes");
        Mno.addItem("No");
        Center.add(Cno);
        Center.add(Mno);

        //set South of Frame
        Down=new JPanel();
        confirm=new JButton("Modify Confirm");
        confirm.addActionListener(new AskModify());
        Down.add(confirm);
        //set frame
        BeforeFrame.setTitle("Modify State");
        BeforeFrame.setSize(950,750);
        BeforeFrame.setLayout(new BorderLayout());
        BeforeFrame.add(new Panel(),BorderLayout.NORTH);
        BeforeFrame.add(Center,BorderLayout.CENTER);
        BeforeFrame.add(Down,BorderLayout.SOUTH);
    }

    // public static void main(String args[]){
    //     ManagementControl mc=new ManagementControl();;
    //     Ramen rm=ManagementControl.RamenRead();
    //     ModifyBoiledeggState ms=new ModifyBoiledeggState(mc,rm);
    //     ms.BeforeFrame.setVisible(true);
    // }
    
    /**
	 * This is an inner class, respond to the button "Modify Confirm"
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	
    public class AskModify implements ActionListener {
        public void actionPerformed(ActionEvent e){
            syes=Myes.getItemAt(Myes.getSelectedIndex());
            sno=Mno.getItemAt(Mno.getSelectedIndex());
            int[] set=new int[2];
            if(syes.equals("Yes")){
                set[0]=1;
            }
            else{
                set[0]=0;
            }
            if(sno.equals("Yes")){
                set[1]=1;
            }
            else{
                set[1]=0;
            }
            mc.setBoiledEgg(rm,set);

            ManagementControl.RamenWrite(rm);
            if (mc.getBoiledEgg(rm)[0] == 1){
                Cyes.setText("Yes");
            }
            else{
                Cyes.setText("No");
            }
            if (mc.getBoiledEgg(rm)[1] == 1){
                Cno.setText("Yes");
            }
            else{
                Cno.setText("No");
            }
            BeforeFrame.setVisible(false);
        }
    }
}