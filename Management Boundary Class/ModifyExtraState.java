import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    /**
	 * This is the Interface of modifying the State of the Extra staff.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */
public class ModifyExtraState {
    ManagementControl mc=new ManagementControl();
    Ramen rm=ManagementControl.RamenRead();
    JFrame BeforeFrame=new JFrame();

    JPanel Center,Down;
    JButton confirm,tconfirm;
    JLabel[] finishedLabel = new JLabel[4];

    JLabel[] name = new JLabel[4];
    JLabel[] currentState = new JLabel[4]; 
    JComboBox<String>[] modifyState =(JComboBox<String>[]) new JComboBox[4];

    String[] aftermodify = new String[4];
    ModifyConfirmWindow finished = new ModifyConfirmWindow();
    NothingChanged notyet =new NothingChanged();

    String[] LabelText = {"Nori","Boiled Egg","Bamboo Shoot","ChaShu"};
    float[] nowState = {mc.getExtraNori(rm),mc.getExtraBoiledEgg(rm),mc.getBambooShoots(rm),mc.getExtraChashu(rm)};
    Font f=new Font("alias",Font.BOLD,16);

    public ModifyExtraState() {
        //set Center of Panel
        Center=new JPanel();
        Center.setLayout(null);
        //1
        Center.add(new JLabel());
        JLabel current=new JLabel("Current");
        current.setFont(f);
        current.setBounds(250,0,275,100);
        JLabel modify=new JLabel("Modify");
        modify.setFont(f);
        modify.setBounds(525,0,275,100);

        Center.add(current);
        Center.add(modify);

        for(int i=0;i<4;i+=1){
            name[i]=new JLabel(LabelText[i]);
            name[i].setFont(f);
            name[i].setBounds(50,80+150*i,225,150);

            currentState[i]=new JLabel();
            if(nowState[i]==1) {
                currentState[i].setText("Yes");
            } else {
                currentState[i].setText("No");
            }
            currentState[i].setFont(f);
            currentState[i].setBounds(250,100+150*i,225,100);

            modifyState[i]=new JComboBox<>();
            modifyState[i].addItem("Yes");
            modifyState[i].addItem("No");
            modifyState[i].setFont(f);
            modifyState[i].setBounds(525,100+150*i,225,100);

            Center.add(name[i]);
            Center.add(currentState[i]);
            Center.add(modifyState[i]);
        }

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
	 * This is an inner class, respond to the buttons "Modify Confirm"
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	

    public class AskModify implements ActionListener{
        public void actionPerformed(ActionEvent e){
            nowState = new float[]{mc.getExtraNori(rm), mc.getExtraBoiledEgg(rm), mc.getBambooShoots(rm), mc.getExtraChashu(rm)};
            boolean[] haschanged=new boolean[4];
            for(int i=0;i<4;i+=1){
                aftermodify[i]=modifyState[i].getItemAt(modifyState[i].getSelectedIndex());
            }

            for(int i=0;i<4;i+=1){
                haschanged[i]=false;
            }

            for(int i=0;i<4;i+=1){
                if((aftermodify[i]=="No"&&nowState[i]==0)||(aftermodify[i]=="Yes"&&nowState[i]==1)){
                    haschanged[i]=false;
                }
                else{
                    haschanged[i]=true;
                }
            }


            if(haschanged[0]||haschanged[1]||haschanged[2]||haschanged[3]){
                for(int i=0;i<4;i+=1){
                    if(aftermodify[i].equals("Yes")){
                        finishedLabel[i].setText("Yes");
                    }
                    else{
                        finishedLabel[i].setText("No");
                    }
                }
                finished.setVisible(true);
            }
            else{
                notyet.setVisible(true);
            }
        }
    }

    /**
	 * This is an inner class, respond to the buttons "Confirm"
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	


    public class ConfirmModify implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (aftermodify[0].equals("Yes")) {
                mc.setExtraNori(rm, 1);
            } else {
                mc.setExtraNori(rm, 0);
            }
            if (aftermodify[1].equals("Yes")) {
                mc.setExtraBoiledEgg(rm, 1);
            } else {
                mc.setExtraBoiledEgg(rm, 0);
            }
            if (aftermodify[2].equals("Yes")) {
                mc.setBambooShoots(rm, 1);
            } else {
                mc.setBambooShoots(rm, 0);
            }
            if (aftermodify[3].equals("Yes")) {
                mc.setExtraChashu(rm, 1);
            } else {
                mc.setExtraChashu(rm, 0);
            }

            float[] bnowState = {mc.getExtraNori(rm),mc.getExtraBoiledEgg(rm),mc.getBambooShoots(rm),mc.getExtraChashu(rm)};
            for(int i=0;i<4;i+=1){
                if(bnowState[i]==1) {
                    currentState[i].setText("Yes");
                } else {
                    currentState[i].setText("No");
                }
            }
            ManagementControl.RamenWrite(rm);
            finished.setVisible(false);
        }
    }

    /**
	 * This is an inner class, the interface of the Modification confirm Window
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	

    public class ModifyConfirmWindow extends JDialog{
        String[] aLabelText = {"Nori","Boiled Egg","Bamboo Shoot","ChaShu"};
        float[] anowState = {mc.getExtraNori(rm),mc.getExtraBoiledEgg(rm),mc.getBambooShoots(rm),mc.getExtraChashu(rm)};
        public ModifyConfirmWindow(){
            setSize(500,250);
            setLayout(new GridLayout(7,2));
            add(new JLabel("After Modified"));
            add(new JLabel());
            add(new JLabel());
            add(new JLabel("New State"));

            for(int i=0;i<4;i+=1){
                JLabel name=new JLabel(aLabelText[i]);
                add(name);
                finishedLabel[i]=new JLabel();
                if(anowState[i]==1){
                    finishedLabel[i].setText("Yes");
                }
                else{
                    finishedLabel[i].setText("No");
                }
                add(finishedLabel[i]);
            }

            tconfirm=new JButton("Confirm");
            tconfirm.addActionListener(new ConfirmModify());
            add(tconfirm);

            setVisible(false);
        }
    }

    /**
	 * This is an inner class, which show the message that nothing changed
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	

    public class NothingChanged extends JDialog{
        public NothingChanged(){
            setTitle("NotingChanged");
            setSize(600,450);
            JLabel tits =new JLabel("You have changed nothing");
            tits.setFont(new Font("alias",Font.BOLD,16));
            add(tits);
            setVisible(false);
        }
    }

    // public static void main(String[] args){
    //     ModifyExtraState mes = new ModifyExtraState();
    //     mes.BeforeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     mes.BeforeFrame.setVisible(true);
    // }
}