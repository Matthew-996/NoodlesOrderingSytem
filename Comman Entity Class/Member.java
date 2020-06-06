import java.io.Serializable;
/*This class is used to indicate attributes of members*/
public class Member implements Serializable{    
    private String membershipNumber;//Membership number of a member
    private String memberSurName;//Surname of a member
    private String memberFirName;//First name of a member
    private String memberContactInfo;//Contact information of a member
    private int numberOfStamps;//Number of virtual stamps of a member
    private String password;
    //Constructor of member class
    public Member() {
    	
    }
    
	public Member(String memberSurName,String memberFirName,String memberContactInfo, String password)
    {
		this.memberFirName=memberFirName;
		this.memberSurName=memberSurName;
		this.memberContactInfo=memberContactInfo;
		this.password = password;
	}
	//Get methods
	public String getMembershipNumber()
	{
		return membershipNumber;
	}
	public String getMemberFirName()
	{
		return memberFirName;
	}
	public String getMemberSurName()
	{
		return memberSurName;
	}
	public String getMemberContactInfo()
	{
		return memberContactInfo;
	}
	public int getNumberOfStamps()
	{
		return numberOfStamps;
	}
	public String getPassword() {
		return password;
	}
	//Set methods
	public void setMembershipNumber(String membershipNumber)
	{
		this.membershipNumber=membershipNumber;
	}
	public void setNumberOfStamps(int numberOfStamps)
	{
		this.numberOfStamps=numberOfStamps;
	}
	public void setMemberFirName(String memberFirName)
	{
		this.memberFirName=memberFirName;
	}
	public void setMemberSurName(String memberSurName)
	{
		this.memberSurName=memberSurName;
	}
	public void setMemberContactInfo(String memberContactInfo)
	{
		this.memberContactInfo=memberContactInfo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

