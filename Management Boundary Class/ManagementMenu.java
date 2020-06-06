import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the Menu Interface of Management System.
 * 
 * @author Xiaochen Liu
 * @version 1.0
 */
public class ManagementMenu extends JFrame{
    private ModifyMenuPrice mmp;
    private ModifyMenuState mms;
    private ModifyExtraState mes;
    private ManagementReportInterface mri;
    //private ManagementReportMenu mrm;
    JButton[] Option=new JButton[4];//state,estate,price,report;
    String[] ButtonText= {"Modify Menu State","Modify Extra State","Modify Price","Manager Report"};

    public ManagementMenu(){
        this.setSize(950,750);
        this.setTitle("Management Modification");
        this.setLayout(new GridLayout(4,1));
        Font f=new Font("alias",Font.BOLD,20);

        for(int i=0;i<4;i+=1){
            Option[i]=new JButton(ButtonText[i]);
            Option[i].setFont(f);
            this.add(Option[i]);
            Option[i].addActionListener(new show());
        }

        mmp=new ModifyMenuPrice();
        mmp.BeforeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mmp.BeforeFrame.setVisible(false);
        mms=new ModifyMenuState();
        mms.BeforeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mms.BeforeFrame.setVisible(false);
        mes=new ModifyExtraState();
        mes.BeforeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mes.BeforeFrame.setVisible(false);
        mri=new ManagementReportInterface();
        mri.ReportChooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mri.ReportChooseFrame.setVisible(false);
    }
    
    /**
  	 * This is an inner class, respond to the buttons "Modify Menu State","Modify Extra State","Modify Price","Manager Report"
  	 * 
  	 * @author Xiaochen Liu
  	 * @version 1.0
  	 */
    public class show implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            if(e.getSource()==Option[0]){
                mms.BeforeFrame.setVisible(true);
            }
            else if(e.getSource()==Option[1]){
                mes.BeforeFrame.setVisible(true);
            }
            else if(e.getSource()==Option[2]){
                mmp.BeforeFrame.setVisible(true);
            }
            else if(e.getSource()==Option[3]){
                mri.ReportChooseFrame.setVisible(true);
            }
            setVisible(false);
        }
    }
    /**
	 * This is the main function of the order system.
	 * 
	 * @author Xiaochen Liu
	 * @version 1.0
	 * @param args no use
	 */
    public static void main(String[] args){
    	ManagementMenu mn=new ManagementMenu();
        mn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mn.setVisible(true);
    }
}
