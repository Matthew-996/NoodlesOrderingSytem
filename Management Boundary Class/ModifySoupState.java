import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    /**
	 * This is the Interface of modifying the State of Soup.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */
public class ModifySoupState {
    ManagementControl mc;
    Ramen rm;
    JFrame BeforeFrame;
    JPanel Center,Down;
    JLabel CTonkotsu,CShoyu,CShio;
    JComboBox<String> MTonkotsu,MShoyu,MShio;
    JButton confirm;
    String sTonkotsu,sShoyu,sShio;
    public ModifySoupState(ManagementControl amc, Ramen arm) {
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
        Center.add(new JLabel("Tonkotsu:can be ordered"));
        CTonkotsu=new JLabel();
        if(mc.getSoup(rm)[0]==1) {
            CTonkotsu.setText("Yes");
        }
        else {
            CTonkotsu.setText("No");
        }
        MTonkotsu=new JComboBox<>();
        MTonkotsu.addItem("Yes");
        MTonkotsu.addItem("No");
        Center.add(CTonkotsu);
        Center.add(MTonkotsu);
        //3
        Center.add(new JLabel("Shoyu:can be ordered"));
        CShoyu=new JLabel();
        if(mc.getSoup(rm)[1]==1) {
            CShoyu.setText("Yes");
        }
        else {
            CShoyu.setText("No");
        }
        MShoyu=new JComboBox<>();
        MShoyu.addItem("Yes");
        MShoyu.addItem("No");
        Center.add(CShoyu);
        Center.add(MShoyu);
        //4
        Center.add(new JLabel("Shio:can be ordered"));
        CShio=new JLabel();
        if(mc.getSoup(rm)[2]==1) {
            CShio.setText("Yes");
        }
        else {
            CShio.setText("No");
        }
        MShio=new JComboBox<>();
        MShio.addItem("Yes");
        MShio.addItem("No");
        Center.add(CShio);
        Center.add(MShio);

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
            sTonkotsu=MTonkotsu.getItemAt(MTonkotsu.getSelectedIndex());
            sShoyu=MShoyu.getItemAt(MShoyu.getSelectedIndex());
            sShio=MShio.getItemAt(MShio.getSelectedIndex());
            int[] set=new int[3];
            if(sTonkotsu.equals("Yes")){
                set[0]=1;
            }
            else{
                set[0]=0;
            }
            if(sShoyu.equals("Yes")) {
                set[1]=1;
            }
            else{
                set[1]=0;
            }
            if(sShio.equals("Yes")) {
                set[2]=1;
            }
            else{
                set[2]=0;
            }
            mc.setSoup(rm,set);

            ManagementControl.RamenWrite(rm);
            if(mc.getSoup(rm)[0]==1) {
                CTonkotsu.setText("Yes");
            }
            else {
                CTonkotsu.setText("No");
            }
            if(mc.getSoup(rm)[1]==1) {
                CShoyu.setText("Yes");
            }
            else {
                CShoyu.setText("No");
            }
            if(mc.getSoup(rm)[2]==1) {
                CShio.setText("Yes");
            }
            else {
                CShio.setText("No");
            }
            BeforeFrame.setVisible(false);
        }
    }
}