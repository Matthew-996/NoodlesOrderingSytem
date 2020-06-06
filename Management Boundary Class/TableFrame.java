import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * This class is a class to show the data of the choice of ManagementReport
 * @author Bailin Rong
 */
public class TableFrame {

	protected JFrame Frame;
	protected String[] ColumnNames;
	protected String[][] tableValues;
	protected ManagementReport report;
	protected ReportControl rc;
	protected String[] name = 
		{"soup","noodles","springOnion","nori","chashu","boiledEgg","spiciness","extraNori","extraBoiledEgg","bambooShoots","extraChashu"};
	
	public TableFrame(int det)
	{	
	Frame = new JFrame(name[det]);
	Frame.setBounds(300, 400, 500, 80);
	Frame.setResizable(false);
	
	ReportControl rc =new ReportControl();
	report = rc.generateReport();
	
	switch(det)
	{
	case 0:
		ColumnNames = new String[]{"Tonkotsu","Shoyu","Shio"};
		tableValues = new String[][]{ {""+(report.getSoup())[0],""+(report.getSoup())[1],""+(report.getSoup())[2]} };
		break;
	
	case 1:
		ColumnNames = new String[]{"Soft","Medium","Firm"};
		tableValues = new String[][]{{""+(report.getNoodles())[0],""+(report.getNoodles())[1],""+(report.getNoodles())[2]}};
		break;
	
	case 2:
		ColumnNames = new String[]{"No please","Just a little","A lot!"};
		tableValues = new String[][]{{""+(report.getSpringOnion())[0],""+(report.getSpringOnion())[1],""+(report.getSpringOnion())[2]}};
		break;
	
	case 3:
		ColumnNames = new String[]{"Yes","No"};
		tableValues = new String[][]{{""+(report.getNori())[0],""+(report.getNori())[1]}};
		break;
	
	case 4:
		ColumnNames = new String[]{"Yes","No"};
		tableValues = new String[][]{{""+(report.getChashu())[0],""+(report.getChashu())[1]}};
		break;
	
	case 5:
		ColumnNames = new String[]{"Yes","No"};
		tableValues = new String[][]{{""+(report.getBoiledEgg())[0],""+(report.getBoiledEgg())[1]}};
		break;
	
	case 6:
		ColumnNames = new String[]{"0","1","2","3","4","5"};
		tableValues = new String[][]{
			
									{
									""+(report.getSpiciness())[0],
									""+(report.getSpiciness())[1],
									""+(report.getSpiciness())[2],
									""+(report.getSpiciness())[3],
									""+(report.getSpiciness())[4],
									""+(report.getSpiciness())[5]
											 }
		
									};
		break;
	
	case 7:
		ColumnNames = new String[]{"Yes","No"};
		tableValues = new String[][]{{""+(report.getExtraNori())[0],""+(report.getExtraNori())[1]}};
		break;	
	
	case 8:
		ColumnNames = new String[]{"Yes","No"};
		tableValues = new String[][]{{""+(report.getExtraBoiledEgg())[0],""+(report.getExtraBoiledEgg())[1]}};
		break;
		
	case 9:
		ColumnNames = new String[]{"Yes","No"};
		tableValues = new String[][]{{""+(report.getBambooShoots())[0],""+(report.getBambooShoots())[1]}};
		break;
		
	case 10:
		ColumnNames = new String[]{"Yes","No"};
		tableValues = new String[][]{{""+(report.getExtraChashu())[0],""+(report.getExtraChashu())[1]}};
		break;			
	}
	
	JTable table = new JTable(tableValues, ColumnNames);
	setTableColumnCenter(table);
	table.setBounds(100, 100, 100, 100);
	JScrollPane scrollPane = new JScrollPane(table);
	
	Frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	Frame.setVisible(true);
	scrollPane.setVisible(true);
	table.setVisible(true);
	}
	
	public void setTableColumnCenter(JTable table){
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class, r);
	}

}
