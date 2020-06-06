import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * This class is a class to show the interface of the choice of ManagementReport
 * @author Bailin Rong
 */
public class ManagementReportInterface {

	protected ManagementReport report;
	protected ReportControl rc;
	protected JFrame ReportChooseFrame;
	protected JLabel top;
	protected JPanel topPanel;
	protected JButton Button[];
	protected JPanel centerPanel;
	protected String[] ButtonName = 
		{"soup","noodles","springOnion","nori","chashu","boiledEgg","spiciness","extraNori","extraBoiledEgg","bambooShoots","extraChashu"};
	
	public ManagementReportInterface()
	{
		ReportChooseFrame = new JFrame("ChooseYourVolumeReport");
		ReportChooseFrame.setBounds(400, 300, 650, 150);
		ReportChooseFrame.setResizable(false);
		
		topPanel = new JPanel();
		top = new JLabel("Please choose your volume report");
		
		ReportChooseFrame.getContentPane().add(topPanel, BorderLayout.NORTH);
		topPanel.add(top);
		
		
		Button = new JButton[11];
		int count;
		
		centerPanel =new JPanel();
		ReportChooseFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		rc = new ReportControl();
		report = rc.generateReport();
		
		for(count=0;count!=11;count++)
		{
		Button[count] = new JButton();
		Button[count].setText(ButtonName[count]);
		centerPanel.add(Button[count]);
		
		
		Button[count].addActionListener(
				
				new ActionListener()
				{	
					private int innerdet;
					public void actionPerformed(ActionEvent e)
					{
						new TableFrame(innerdet);
					}
					
					public ActionListener accept(int det)
					{
						this.innerdet = det;
						return this;
					}
				}.accept(count)
				
				);
		
		}	
		
		ReportChooseFrame.setVisible(true);
		topPanel.setVisible(true);
		centerPanel.setVisible(true);
		top.setVisible(true);
		
		for(count=0;count!=11;count++)
			Button[count].setVisible(true);	
		
	}
	
	public static void main(String[] args) {
		
		ManagementReportInterface a =new ManagementReportInterface();
	}
		
}
