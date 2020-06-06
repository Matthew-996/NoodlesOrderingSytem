import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    /**
	 * This is the Interface of modifying the State of Noodles.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */
public class ModifyNoodleState {
    ManagementControl mc;
    Ramen rm;
    JFrame BeforeFrame;
    JPanel Center,Down;
    JLabel Csoft,Cmedium,CFirm;
    JComboBox<String> Msoft,Mmedium,MFirm;
    JButton confirm;
    String ssoft,smedium,sFirm;
    public ModifyNoodleState(ManagementControl amc, Ramen arm) {
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
        Center.add(new JLabel("Soft:can be ordered"));
        Csoft=new JLabel();
        if(mc.getNoodles(rm)[0]==1){
            Csoft.setText("Yes");
        }
        else{
            Csoft.setText("No");
        }
        Msoft=new JComboBox<>();
        Msoft.addItem("Yes");
        Msoft.addItem("No");
        Center.add(Csoft);
        Center.add(Msoft);
        //3
        Center.add(new JLabel("Medium:can be ordered"));
        Cmedium=new JLabel();
        if(mc.getNoodles(rm)[1]==1){
            Cmedium.setText("Yes");
        }
        else{
            Cmedium.setText("No");
        }
        Mmedium=new JComboBox<>();
        Mmedium.addItem("Yes");
        Mmedium.addItem("No");
        Center.add(Cmedium);
        Center.add(Mmedium);
        //4
        Center.add(new JLabel("Firm:can be ordered"));
        CFirm=new JLabel();
        if(mc.getNoodles(rm)[2]==1){
            CFirm.setText("Yes");
        }
        else{
            CFirm.setText("No");
        }
        MFirm=new JComboBox<>();
        MFirm.addItem("Yes");
        MFirm.addItem("No");
        Center.add(CFirm);
        Center.add(MFirm);

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
            ssoft=Msoft.getItemAt(Msoft.getSelectedIndex());
            smedium=Mmedium.getItemAt(Mmedium.getSelectedIndex());
            sFirm=MFirm.getItemAt(MFirm.getSelectedIndex());

            int[] set=new int[3];
            if(ssoft.equals("Yes")){
                set[0]=1;
            }
            else{
                set[0]=0;
            }
            if(smedium.equals("Yes")) {
                set[1]=1;
            }
            else{
                set[1]=0;
            }
            if(sFirm.equals("Yes")) {
                set[2]=1;
            }
            else{
                set[2]=0;
            }
            mc.setNoodles(rm,set);
            ManagementControl.RamenWrite(rm);
            if(mc.getNoodles(rm)[0]==1){
                Csoft.setText("Yes");
            }
            else{
                Csoft.setText("No");
            }
            if(mc.getNoodles(rm)[1]==1){
                Cmedium.setText("Yes");
            }
            else{
                Cmedium.setText("No");
            }
            if(mc.getNoodles(rm)[2]==1){
                CFirm.setText("Yes");
            }
            else{
                CFirm.setText("No");
            }
            BeforeFrame.setVisible(false);
        }
    }
}