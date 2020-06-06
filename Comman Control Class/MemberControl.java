import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;


/**
 *
 *This class is a control class for Member class, which will manily implement login and register methods
 *@author Weng Huaiyuan,Gao Jingyun
 *@version 1.3
 */
public class MemberControl
{
	String filePath = FilePathGet.getpath("MemberInfor.txt");/////////////////////////////////modify address
    public MemberControl(){}
    
    /**
	 * get corresponding membership number
	 * @param member a member object
	 * @return MembershipNumber the number of membership
	 */
    public String getMembershipNumber(Member member)
	{
		return member.getMembershipNumber();
	}
    /**
	 * get corresponding membership first name
	 * @param member a member object
	 * @return MemberFirName the firstname of the  member object
	 */
	public String getMemberFirName(Member member)
	{
		return member.getMemberFirName();
	}
	/**
	 * get corresponding membership surname
	 * @param member a member object
	 * @return MemberSurName the surname of the member object
	 */
	public String getMemberSurName(Member member)
	{
		return member.getMemberSurName();
	}
	/**
	 * get corresponding membership contact information
	 * @param member a member object
	 * @return MemberContactInfo the contect information of the member object
	 */
	public String getMemberContactInfo(Member member)
	{
		return member.getMemberContactInfo();
	}
	/**
	 * get corresponding membership stamp number
	 * @param member a member object
	 * @return NumberOfStamps the number of stamps of the member object
	 */
	public int getNumberOfStamps(Member member)
	{
		return member.getNumberOfStamps();
	}
	/**
	 * get corresponding membership password
	 * @param member a member object
	 * @return member.password the password of the member object
	 */
	public String getPassword(Member member) {
		return member.getPassword();
	}
	
	
	/**
	 * This method is used to record new member information into a file named MemberInfo.txt
	 * @param member a member object
	 * 
	 */
	public void memberInfoRecord(Member member)
    {
        try
        {
            String content =    member.getMembershipNumber()+" "
                              + member.getMemberSurName()+" "
                              + member.getMemberFirName()+" "
                              + member.getMemberContactInfo()+" "
                              + member.getNumberOfStamps() + " "
                              + member.getPassword() + "\r\n";
            File file =new File(filePath);
            if(!file.exists())//Fault-tolerant:if the user is the first member,we need to create a new file
            {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(FilePathGet.getpath(file.getName()),true);//Use true to append file 
            fileWritter.write(content);
            fileWritter.close();
            System.out.println("finish");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
	
	/**
	 * This method is used to generate membership number in order
	 * it reads the membership number of the last member in MemberInfo.txt and plus 1 to get the new membership number 
	 * @return MembershipNumber
	 */
	public String generateMembershipNumber()
	{
		String newMembershipNumber= "00000000";//The first membership number will be '00000000'.
		int flag=7;	//This flag is used to verify whether the digits of membership number is enough or not.
		File file =new File(filePath);
		if(file.exists())//Fault-tolerant:if the user is the first member,we need to create a new file
        {
			try
			{
				Scanner sc=new Scanner(new FileReader(filePath));
				String line=null;
				int t = 10;
				while((sc.hasNextLine()&&(line=sc.nextLine())!=null)) {
					if(!sc.hasNextLine())
					{	int id = 0;
						String[] splite = line.split(" ");
						try 
						{	
							id = Integer.parseInt(splite[0]);
						}catch(Exception e) 
						{
							System.out.println("Error");
						}
		
						id ++;
						String strid = String.valueOf(id);
						while(id > t) {
							t = t*10;
							flag --;
						}
						newMembershipNumber = strid;
						for(int i = 0; i < flag; i++) {
							newMembershipNumber = "0" + newMembershipNumber ;
						}
					}
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}            
        }
		
		return newMembershipNumber;
	}
	
	
	/**
	 * this method gets the input from user then it records the member's information and generate a new membership number and return it.
	 * @param newMember a new created member object
	 */
	public void memberRegister(Member newMember)
	{
		newMember.setMembershipNumber(generateMembershipNumber());
		newMember.setNumberOfStamps(0);
		this.memberInfoRecord(newMember);
	}
	
	/**
	 * if id and password are both correct: return virtualStamp that is equal to 0 or more than 0
	 * if id is correct and password is not correct: return virtualStamp = -11   
	 * if id and password are both not correct: return virtualStamp = -1
	 * @param id the id number of the login member object
	 * @param password the password number of the login member object
	 * @return stampsNumber the stamp number of the member object or -1/-11 to represent failure status
	 */
	public int login(String id, String password) {										
		String temp;
		int res = -1;
		int virtualStamp;
		try 
		{
		    File file = new File(filePath);
			if(file.isFile() && file.exists()) 
			{
		      	InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
		      	BufferedReader br = new BufferedReader(isr);
				while ( (temp = br.readLine()) != null) 
				{
		        	virtualStamp = compareId(temp, id, password);
					if(virtualStamp >= 0) 
					{
		        		return virtualStamp;
					}
					if(virtualStamp == -1) {
						res = -11;
					}
			    }
		      	br.close();
			} 
			else 
		      	System.out.println("File does not exist!");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}
		
	/**
	 * this methods decrease virtual stamps by 10 when is used for a free meal
	 * 
	 * @param givenname the given name of the member object
	 * @param firstname the first name of the member object
	 * @return numberOfStamps the number of stamps of the member object
	 */
	public int decreaseVirtualStamp(String givenname , String firstname) 
	{
		String temp;
		int virtualStamp = 0;
		int reverse = 0;
		int flag = 0;
		try 
		{
            File file = new File(filePath);
			if(file.isFile() && file.exists()) 
			{
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				StringBuffer buf = new StringBuffer();
				flag = 0;
				while ( (temp = br.readLine()) != null) 
				{
					virtualStamp = compare(temp, givenname, firstname);
					if(virtualStamp >= 10)
					{
						flag = 1;
						String[] splite = temp.split(" ");
						virtualStamp = Integer.parseInt(splite[4]);
						virtualStamp = virtualStamp - 10;
						reverse = virtualStamp;
						String virtualStampString = virtualStamp + "";
						String context =  splite[0]+" "
										+ splite[1]+" "
										+ splite[2]+" "
										+ splite[3]+" "
										+ virtualStampString + " "
										+ splite[5] + "\n";
						buf = buf.append(context);
						System.out.println("Decrease Successfully");
					}
					else
                    	buf = buf.append(temp+"\n");
                	//buf = buf.append(System.getProperty("line.separator"));
            	}
				br.close();
				FileOutputStream fos = new FileOutputStream(file);
				PrintWriter pw = new PrintWriter(fos);
				pw.write(buf.toString().toCharArray());
				pw.flush();
				pw.close();
            }
		} 
		catch (IOException e) 
		{
        	e.printStackTrace();
        }
        if(flag == 1) 
        	return reverse;
        else 
        	return -1;    
	}
	
	
	/**
	 * this methods decrease virtual stamps by 1 when a  member pay for a noodle
	 * 
	 * @param givenname the given name of the member object
	 * @param firstname the first name of the member object
	 * @return numberOfStamps the number of stamps of the member object after increamentation
	 */
	public int increaseVirtualStamp(String givenname , String firstname) 
	{
		String temp;
		int virtualStamp = 0;
		int flag = 0;
		int reverse = 0;
		try 
		{
            File file = new File(filePath);
			if(file.isFile() && file.exists()) 
			{
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				StringBuffer buf = new StringBuffer();
				flag = 0;
				while ( (temp = br.readLine()) != null) 
				{
            		virtualStamp = compare(temp, givenname, firstname);
					if(virtualStamp >= 0)
					{
                		flag = 1;
						String[] splite = temp.split(" ");
						virtualStamp = Integer.parseInt(splite[4]);
						virtualStamp = virtualStamp + 1;
						reverse = virtualStamp;
						String virtualStampString = virtualStamp + "";
						String context =  splite[0]+" "
										+ splite[1]+" "
										+ splite[2]+" "
										+ splite[3]+" "
										+ virtualStampString + " "
										+ splite[5]+ "\n";
						buf = buf.append(context);
						System.out.println("Increase Successfully");
					}
					else
                    	buf = buf.append(temp+"\n");
                	//buf = buf.append(System.getProperty("line.separator"));
            	}
				br.close();
				FileOutputStream fos = new FileOutputStream(file);
				PrintWriter pw = new PrintWriter(fos);
				pw.write(buf.toString().toCharArray());
				pw.flush();
				pw.close();
			}
		} 
		catch (IOException e) 
		{
        	e.printStackTrace();
        }
        if(flag == 1) 
        	return reverse;
        else 
        	return -1;		
	}
	
	/**
	 * search in the memberInfor.txt to find whether id and password match
	 * 
	 * @param temp the compare object
	 * @param id the id number of the member object
	 * @param password the password of the member object
  	 * @return numberOfStamps the number of objects of member account
	 */
	public int compareId(String temp, String id, String password) 
	{
		String tempId = "";
		int virtualStamp = 0;
		String temp_word = "";
		String[] splite = temp.split(" ");
		try 
		{
			tempId = splite[0];
			virtualStamp = Integer.parseInt(splite[4]);
			temp_word = splite[5];
		}
		catch(Exception e) 
		{
			System.out.println("Error");
		}
		if(tempId.equals(id)){
			System.out.println("word"+ temp_word);
			if(temp_word.equals(password))
			{
				return virtualStamp;
			}
			else{
				return -11;
			}
		}
		else 
			return -1;
	}
	
	/**
	 * search in the memberInfor.txt to find whether given name and first name match
	 * 
	 * @param temp the compare object
	 * @param givenname the givenname of the member object
	 * @param firstname the firstname of the member object
  	 * @return numberOfStamps the number of objects of member account
	 */
	public int compare(String temp, String givenname, String firstname) 
	{
		String gotname1 = "";
		String gotname2 = "";
		int virtualStamp = 0;
		String[] splite = temp.split(" ");
		try {
			gotname1 = (String)splite[1];
			gotname2 = (String)splite[2];
			virtualStamp = Integer.parseInt(splite[4]);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(gotname1.equals(givenname) && gotname2.equals(firstname)) 
			return virtualStamp;
		else 
			return -1;
	}

	
	/**
	 * get the first name in the MemberInfor.txt
	 * 
	 * @param id the id number of the target member object
 	 * @return firstname firstname of the owner of the member object
	 */
	public String getFirstname(String id) 
	{		
		String temp;
		String result = "";	
		try 
		{
		    File file = new File(filePath);
			if(file.isFile() && file.exists()) 
			{
		      	InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
		      	BufferedReader br = new BufferedReader(isr);
				while ( (temp = br.readLine()) != null) 
				{	        
		        	result = compareFirstname(temp, id);		        
					if(result != null) 
					{
		        		return result;
		        	}		       
		      	}
		      	br.close();
			} 	
			else 
			{
		      System.out.println("file does not exist!");
		    }
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * get the surname in the MemberInfor.txt
	 * 
	 * @param id the id number of the target member object
	 * @return surname the surname of the targect member object
	 */
	public String getSurname(String id) 
	{		
		String temp;
		String result = "";	
		try 
		{
		    File file = new File(filePath);
			if(file.isFile() && file.exists()) 
			{
		      	InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
		      	BufferedReader br = new BufferedReader(isr);
				while((temp = br.readLine()) != null) 
				{	        
					result = compareSurname(temp, id);		        
					if(result != null) 
					{
						return result;
					}		       
		      	}
		      	br.close();
			} 
			else 
			{
		      System.out.println("file does not exist!");
		    }
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * compare the surname of the id 
	 * 
	 * @param temp the compare value
	 * @param id the id number of the target member object
	 * @return Surname the surname of the target member object
	 */
	public String compareSurname(String temp, String id) 
	{
		String firstName = "";	
		String tempId = "";
		String[] splite = temp.split(" ");
		try 
		{	
			firstName = splite[1];
			tempId = splite[0];
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}			
		if(tempId.contentEquals(id)) 
			return firstName;
		else 
			return null;
	}
	
	
	/**
	 * compare the surname of the id 
	 * 
	 * @param temp the compare value
	 * @param id the id number of the target member object
	 * @return firstName the compare result
	 */
	public String compareFirstname(String temp, String id) 
	{
		String surName = "";	
		String tempId = "";
		String[] splite = temp.split(" ");
		try 
		{	
			surName = splite[2];
			tempId = splite[0];
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}		
		if(tempId.equals(id)) 
			return surName;
		else 
			return null;
	}
	
	
	/**
	 * used to handle the special notes
	 * 
	 * @param str1 the testing object
	 * @return count the counting result
	 */
	public static int tj1(String str1){
		   int count=0;
		   for(int i=0;i<str1.length();i++){
			   if(str1.charAt(i)>='a'&&str1.charAt(i)<='z'
			   ||str1.charAt(i)>='A'&&str1.charAt(i)<='Z'
			   ||str1.charAt(i)>='0'&&str1.charAt(i)<='9'
			   ||str1.charAt(i)=='_'
			   ||str1.charAt(i)=='@'
			   ||str1.charAt(i)=='.'){
				   count=1;
			   }
			   else{
				   count=2;
				   break;
			   }
		}
		return count;	   
	   }
	
	
	/**
	 * used to handle the special notes
	 * 
	 * @param str1 the testing object
	 * @return count the counting result
	 */
	public static int tj2(String str1){
		   int count = 0;
		   for(int i=0;i<str1.length();i++){
			   if(str1.charAt(i)=='@'){
				   count=1;
			   }
		   }
		   while(count==1){
		      int i=str1.indexOf('@');
		      if(i==0)
		    	  return 2;
		      if(((str1.charAt(i-1)>='a'&&str1.charAt(i-1)<='z')
		      ||(str1.charAt(i-1)>='A'&&str1.charAt(i-1)<='Z')
		      ||(str1.charAt(i-1)>='0'&&str1.charAt(i-1)<='9'))
		      &&((str1.charAt(i+1)>='a'&&str1.charAt(i+1)<='z')
		      ||(str1.charAt(i+1)>='A'&&str1.charAt(i+1)<='Z')
		      ||(str1.charAt(i+1)>='0'&&str1.charAt(i+1)<='9'))){
			    count=3;
		      }
		      else{
		    	  count=2;
		      }
		   }
		return count;
	   }

	
	/**
	 * used to handle the special notes
	 * 
	 * @param str1 the testing object
	 * @return count the counting result
	 */
	public static int tj3(String str1){ 
		   int count=0;
		   if(str1.charAt(str1.length()-4)=='.'
		   &&str1.charAt(str1.length()-3)=='c'
		   &&str1.charAt(str1.length()-2)=='o'
		   &&str1.charAt(str1.length()-1)=='m'){
			   count=1;
		   }
		   else{
			   count=2;
		   }		   
		return count;
	   }

	
	
	/**
	 * used to check the email address
	 * 
	 * @param email the testing email object
	 * @return boolean the check result
	 */
	public Boolean mailValidation(String email) {
		if(email.length()<=5) {
			return false;
		}
		
		   int jg1=tj1(email);
		   int jg2=tj2(email);
		   int jg3=tj3(email);
		   if(jg1==1&&jg2==3&&jg3==1){
			   System.out.println("YES");
			   return true;
		   }
		   else{
			   System.out.println("NO");
			   return false;
		   }

	}
	
	
	/**
	 * used to check phone number
	 * 
	 * @param phone the testing phone number
	 * @return boolean the testing result
	 */
	public Boolean phoneValidation(String phone) {
		if(phone.length()!= 11) {
		//	JOptionPane.showMessageDialog(null, "Phone Numbers are not up to standard.","Error",JOptionPane.WARNING_MESSAGE);
            return false;
		}
		for (int i = phone.length();--i>=0;) {
			if (!Character.isDigit(phone.charAt(i))){
				//JOptionPane.showMessageDialog(null, "telnumber must be numbers!","Error",JOptionPane.WARNING_MESSAGE);
	            return false;
	        }
		}
		if(!phone.subSequence(0,1).equals("1")) {
		//	JOptionPane.showMessageDialog(null, "Phone Numbers are not up to standard.","Error",JOptionPane.WARNING_MESSAGE);
            return false;
		}
		return true;
	}
	/**
	 * used to check name format
	 * 
	 *  @param name customers' first name or surname
	 *  @return right or false
	 */
	public Boolean nameValidation(String name) {
		char firsts=(name.charAt(0));
		if(Character.isUpperCase(firsts)) {
			String regex = "^[a-zA-Z]+$";
			return name.matches(regex);
		}
		else
			return false;
	}
	
}