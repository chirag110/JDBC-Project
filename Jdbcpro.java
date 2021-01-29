package jdbcpro;
import java.sql.*;
import java.util.*;
public class Jdbcpro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String adm="";
		String nm="";
		String phn="";
		String em="";
		String enn="";
		String ennd="";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded");
		Connection con=DriverManager.getConnection(url,"System","student");
		Statement st=con.createStatement();
		
		System.out.println("Connection Established");
			System.out.println("THIRD YEAR STUDENTS INFORMATION MACHINE");
			System.out.println("Select the Operation You want to Perform:");
			System.out.println("Press 1 for Getting Student Details:");
			System.out.println("Press 2 for Enrolling New Student:");
			System.out.println("Press 3 to Remove a Student:");
			System.out.println("Press 4 to View All Content");
			int ch=sc.nextInt();
			switch(ch){
			case 1:
				System.out.println("Enter the Enrollment Number of Student You are Looking For:");
				int en=sc.nextInt();
				ResultSet rs=st.executeQuery("select * from Student2 where enrollmentnumber='"+en+"'");
				System.out.println("ADMISSION NUMBER\t\tNAME\t\tEMAIL\t\tPHONENUMBER\t\t");
				rs.next();
				System.out.println(rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
				break;
			case 2:
				System.out.println("Enter the Following Details of the Student You Want to Enroll:");
				System.out.print("Enter enrollment number,Admission Number,Name,Email,PhoneNumber:");
				enn=sc.nextLine();
				enn=sc.nextLine();
				adm= sc.nextLine();
				nm=sc.nextLine();
				em=sc.nextLine();
				phn=sc.nextLine();
			    String qry="insert into Student2(ENROLLMENTNUMBER,ADMISSIONNUMBER,NAME,EMAIL,PHONENUMBER) values('"+enn+"','"+adm+"','"+nm+"','"+em+"','"+phn+"')";
			    int cnt=st.executeUpdate(qry);
			    con.commit();
			    break;
			case 3:
				System.out.println("Enter the EnrollmentNumber of the Student You want to Remove:");
		        ennd=sc.nextLine();
		        ennd=sc.nextLine();
				String qrry="delete from Student2 where EnrollmentNumber='"+ennd+"'";
				int cnnt=st.executeUpdate(qrry);
				con.commit();
				break;
			case 4:
				ResultSet rs1=st.executeQuery("select * from Student2");
				System.out.println("ENROLLMENT NUMBER\t\tADMISSION NUMBER\t\tNAME\t\tEMAIL\t\tPHONENUMBER\t\t");
				while(rs1.next()) {
					System.out.println(rs1.getString(1)+"\t\t"+rs1.getString(2)+"\t\t"+rs1.getString(3)+"\t\t"+rs1.getString(4)+"\t\t"+rs1.getString(5));
				}
			}
			con.close();
	}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Not Loaded");
		}
		catch(SQLException e) {
			System.out.println("Connection Not Established"+e.getMessage());
		}
	
}
}