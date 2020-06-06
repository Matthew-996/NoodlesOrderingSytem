import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    /**
	 * This is the Interface of modifying the Price of the staff in menu.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */

public class ModifyMenuPrice {
    ManagementControl mc=new ManagementControl();
    Ramen rmr=ManagementControl.RamenRead();
    ModifyConfirm finished;
    JFrame BeforeFrame=new JFrame();
    String snori,schashu,sbambooshoot,sboiledegg;
    JPanel Center,Down;
    JButton confirm,tconfirm;
    JLabel Cnori,Cchashu,Cbambooshoot,Cboiedegg,jnori,jegg,jbamboo,jcha;
    JTextField Mnori,Mchashu,Mbambooshoot,Mboiledegg;
    JDialog notyet;

    JLabel[] afterPrice= new JLabel[4];

    JLabel[] Name =new JLabel[4];
    JLabel[] nowPrice=new JLabel[4];
    JTextField[] ModifyField=new JTextField[4];
    String[] modifiedString=new String[4];
    String[] LabelText={"Nori","Boiled Egg","Bamboo Shoot","ChaShu"};
    float[] currentprice = {mc.getExtraNoriPrice(rmr),mc.getExtraBoiledEggPrice(rmr),mc.getBambooShootsPrice(rmr),
                                        mc.getExtraChashuPrice(rmr)};
    Font f=new Font("alias",Font.BOLD,20);

    public ModifyMenuPrice() {
        //set notyet Dialog
        notyet=new JDialog();
        notyet.setSize(300,150);
        notyet.add(new JLabel("You have changed nothing"));

        //set Frame
        Center=new JPanel();
        Down=new JPanel();
        Center.setLayout(new GridLayout(5,3));

        //set Center of Frame
        //1
        Center.add(new JLabel());
        Center.add(new JLabel("Current"));
        Center.add(new JLabel("Modify"));

        for(int i=0;i<4;i+=1){
            nowPrice[i]=new JLabel(String.valueOf(currentprice[i]));
            nowPrice[i].setFont(f);
            ModifyField[i]=new JTextField(20);
            Name[i]=new JLabel(LabelText[i]);
            Name[i].setFont(f);
            Center.add(Name[i]);
            Center.add(nowPrice[i]);
            Center.add(ModifyField[i]);
        }

        //set South of Frame
        Down=new JPanel();
        confirm=new JButton("Modify Confirm");
        confirm.addActionListener(new AsdModify());
        Down.add(confirm);

        //set Frame
        BeforeFrame.setTitle("Modify Price");
        BeforeFrame.setSize(950,750);
        BeforeFrame.setLayout(new BorderLayout());
        BeforeFrame.add(new JPanel(),BorderLayout.NORTH);
        BeforeFrame.add(Center,BorderLayout.CENTER);
        BeforeFrame.add(Down,BorderLayout.SOUTH);
    }

    /**
	 * This is an inner class, respond to the buttons "Modify Confirm"
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	

    public class AsdModify implements ActionListener{
        ModifyConfirm finished=new ModifyConfirm();
        public void actionPerformed(ActionEvent e){
            for(int i=0;i<4;i+=1){
                modifiedString[i]=ModifyField[i].getText();
            }
            if(!modifiedString[0].isEmpty()||!modifiedString[1].isEmpty()||!modifiedString[2].isEmpty()||!modifiedString[3].isEmpty()){
                for(int i=0;i<4;i+=1){
                    if(!modifiedString[i].isEmpty()){
                        afterPrice[i].setText(modifiedString[i]);
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

    public class ConfirmModify implements ActionListener{
        public void actionPerformed(ActionEvent e){
            mc.setExtraNoriPrice(rmr,Float.parseFloat(afterPrice[0].getText()));
            mc.setExtraBoiledEggPrice(rmr,Float.parseFloat(afterPrice[1].getText()));
            mc.setBambooShootsPrice(rmr,Float.parseFloat(afterPrice[2].getText()));
            mc.setExtraChashuPrice(rmr,Float.parseFloat(afterPrice[3].getText()));
            ManagementControl.RamenWrite(rmr);

            nowPrice[0].setText(String.valueOf(rmr.getExtraNoriPrice()));
            nowPrice[1].setText(String.valueOf(rmr.getExtraBoiledEggPrice()));
            nowPrice[2].setText(String.valueOf(rmr.getBambooShootsPrice()));
            nowPrice[3].setText(String.valueOf(rmr.getExtraChashuPrice()));

//            finished.setVisible(false);
        }
    }

    /**
	 * This is an inner class, the interface of the Modification confirm Window
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 */	

    public class ModifyConfirm extends JDialog{
        public ModifyConfirm(){
            setSize(500,250);
            setLayout(new GridLayout(7,2));
            add(new JLabel("After Modified"));
            add(new JLabel());
            add(new JLabel());
            add(new JLabel("New Price"));

            add(new JLabel("Extra Nori"));
            afterPrice[0]=new JLabel(String.valueOf(rmr.getExtraNoriPrice()));
            add(afterPrice[0]);
            add(new JLabel("Extra BoiledEgg"));
            afterPrice[1]=new JLabel(String.valueOf(rmr.getExtraBoiledEggPrice()));
            add(afterPrice[1]);
            add(new JLabel("BambooShoot"));
            afterPrice[2]=new JLabel(String.valueOf(rmr.getBambooShootsPrice()));
            add(afterPrice[2]);
            add(new JLabel("Extra Chashu"));
            afterPrice[3]=new JLabel(String.valueOf(rmr.getExtraChashuPrice()));
            add(afterPrice[3]);
            tconfirm=new JButton("Confirm");
            tconfirm.addActionListener(new ConfirmModify());
            add(tconfirm);
        }
    }

    // public static void main(String[] args){
    //     ModifyMenuPrice mmp=new ModifyMenuPrice();
    //     mmp.BeforeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     mmp.BeforeFrame.setVisible(true);
    // }
}



