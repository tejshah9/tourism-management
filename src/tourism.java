import java.sql.*;
import java.io.*;
import java.util.*;
import java.lang.*;

class user
{
	void soln() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection i=DriverManager.getConnection("jdbc:mysql://localhost:3307/place","root","");
		
		Scanner o=new Scanner(System.in);
        int cho=0;
        
        while(cho!=3)
        {
			System.out.println("*****MAIN MENU*****");
	        System.out.println("1. Register");
	        System.out.println("2. Login");
	        System.out.println("3. Exit");
	        System.out.println("*******************");
	        System.out.print("Enter your choice :");
	        cho=o.nextInt();
	        switch(cho)
	        {
	        	case 1:
				try
				{
					String uname,id,password;
					Scanner j= new Scanner(System.in);
					System.out.print("Enter User id :");
					id=j.nextLine();
					System.out.print("Enter Your Name :");
					uname=j.nextLine();
					System.out.print("Enter Your Password :");
					password=j.nextLine();
					String vv="insert into user values(?,?,?)";
			        PreparedStatement nn=i.prepareStatement(vv);
			        nn.setString(1,id);
					nn.setString(2,uname);
					nn.setString(3,password);
					int c=nn.executeUpdate();
					System.out.println(c +"rows Affected");
			        System.out.println("Registered...");
					nn.close();
				}
				catch(Exception d)
				{
					System.err.println("Error...");
					System.err.println(d.getMessage());
				}
				break;
				
	        	case 2:
	        	try
	        	{
	        		int k=0;
	        		String password,id;
	        		Scanner m=new Scanner(System.in);
					System.out.println("Enter User id :");
					id=m.nextLine();
					System.out.println("Enter Your password :");
					password=m.nextLine();
					String vs="select id,uname from user where id='"+id+"' and uname='"+password+"'";
			        Statement bb=i.createStatement();
			        ResultSet rs=bb.executeQuery(vs);
			        rs.next();
			        if(k<=1)
			        {
				        String data=rs.getString(1)+":"+rs.getString(2);
				        k++;
			        }
	        		if(k>0)
	        		{
	        			System.out.println("loged in..");
	        		}
	        		bb.close();
	        		
	        		Scanner sc=new Scanner(System.in);
	        		int cf=0;
	        		
	        		while(cf!=2)
	        		{
		        		System.out.println("*****MAIN MENU*****");
		    	        System.out.println("1. Search the place");
		    	        System.out.println("2. Exit");
		    	        System.out.println("*******************");
		    	        System.out.print("Enter your choice :");
		    	        cf=sc.nextInt();
		    	        switch(cf)
		    	        {
		    	        	case 1:
		    	        	try
		    	    		{
		    	    			String nam,info;
		    	            	Scanner x=new Scanner(System.in);
		    	    			System.out.println("Search place Name :");
		    	    			nam=x.nextLine();
		    	    			String sv="select name,info from places where name='"+nam+"'";
		    	    		    Statement bc=i.createStatement();
		    	    		    ResultSet rq=bc.executeQuery(sv);
		    	    		    rq.next();
		    	    		    String dat=rq.getString(1)+" : "+rq.getString(2);
		    	    		    System.out.println(dat);
		    	           		bc.close();
		    	            }
		    	   			catch(Exception f)
		    	   			{
		    	   				System.err.println("Error...");
		    	   				System.err.println(f.getMessage());
		        			}
		    	        	break;
		    	        	
		    	        	case 2:
		    	        	break;
		    	        }
	        		}
		        }
				catch(Exception d)
				{
					System.err.println("Error...");
					System.err.println("Invalid Id or Password");
					System.err.println(d.getMessage());
				}
	        	break;
	        	
	        	case 3:
	        	break;
	        }
        }
        i.close();
	}
}

class admin
{
	void soln() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection s=DriverManager.getConnection("jdbc:mysql://localhost:3307/place","root","");
		
		String name,info;
		Scanner e=new Scanner(System.in);
	    int ch=0;
		
	    while(ch!=6)
	    {
			System.out.println("*****MAIN MENU*****");
	        System.out.println("1. Insert");
	        System.out.println("2. Delete");
	        System.out.println("3. Update Place Name");
	        System.out.println("4. Update Place Information");
	        System.out.println("5. Delete User");
	        System.out.println("6. Exit");
	        System.out.println("*******************");
	        System.out.print("Enter your choice :");
	        ch=e.nextInt();
	        switch(ch)
	        {
	        	case 1:
				try
				{
					Scanner sc= new Scanner(System.in);
					System.out.print("Enter City Name :");
					name = sc.nextLine();
					System.out.print("Enter its information :");
					info = sc.nextLine();
		            String v="insert into places values(?,?)";
		            PreparedStatement sa=s.prepareStatement(v);
		            sa.setString(1,name);
					sa.setString(2,info);
					int count=sa.executeUpdate();
					System.out.println(count +"rows Affected");
					sa.close();
				}
				catch(Exception f)
				{
					System.err.println("Error...");
					System.err.println(f.getMessage());
				}
	        	break;
				
	        	case 2:
	        	try
	        	{
	        		Scanner cc= new Scanner(System.in);
					System.out.print("Enter City Name :");
					name= cc.nextLine();
		            String f="delete from places where name=(?)";
		            PreparedStatement fa=s.prepareStatement(f);
		            fa.setString(1,name);
					int count=fa.executeUpdate();
					System.out.println(count +"rows Affected");
					fa.close();
				}
				catch(Exception g)
				{
					System.err.println("Error...");
					System.err.println(g.getMessage());	
				}
				break;
					
	        	case 3:
        		try
				{
        			String nam;
					Scanner fc= new Scanner(System.in);
					System.out.print("Enter City Name : ");
					name = fc.nextLine();
					System.out.print("Enter City Name that you want to be update: ");
					nam = fc.nextLine();
					String v="update places set name='"+nam+"' where name='"+name+"'";
			        PreparedStatement df=s.prepareStatement(v);
					int coun=df.executeUpdate();
					System.out.println(coun +"rows Affected");
					df.close();
				}
				catch(Exception j)
				{
					System.err.println("Error...");
					System.err.println(j.getMessage());
				}
		        break;
		        
	        	case 4:
	        	try
				{
					Scanner fc= new Scanner(System.in);
					System.out.print("Enter City Name : ");
					name = fc.nextLine();
					System.out.print("Enter Place Information that you want to update: ");
					info = fc.nextLine();
					String v="update places set info='"+info+"' where name='"+name+"'";
				    PreparedStatement df=s.prepareStatement(v);
					int coun=df.executeUpdate();
					System.out.println(coun +"rows Affected");
					df.close();
				}
				catch(Exception j)
				{
					System.err.println("Error...");
					System.err.println(j.getMessage());
				}
	        	break;
	        	
	        	case 5:
	        	try
		        {
		        	Scanner cc= new Scanner(System.in);
					System.out.print("Enter User Id :");
					String id = cc.nextLine();
			        String f="delete from user where id='"+id+"'";
			        PreparedStatement fa=s.prepareStatement(f);
					int count=fa.executeUpdate();
					System.out.println(count +"rows Affected");
					fa.close();
				}
				catch(Exception g)
				{
					System.err.println("Error...");
					System.err.println(g.getMessage());	
				}
	        	break;
	        	
	        	case 6:
	        	break;
	        }
	    }
	s.close();
	}
}

class tourism
{
	public static void main(String[] args) throws Exception
	{
		admin a=new admin();
		user l=new user();
		
		Scanner h=new Scanner(System.in);
		int hj=0;
		
        while(hj!=3)
        {
			System.out.println("*****MAIN MENU*****");
	        System.out.println("1. User");
	        System.out.println("2. Admin");
	        System.out.println("3. Exit");
	        System.out.println("*******************");
	        System.out.print("Enter your choice :");
	        hj=h.nextInt();
	        switch(hj)
	        {
	        	case 1:
				l.soln();
				break;
	        
	        	case 2:
				a.soln();
		        break;
		        
	        	case 3:
	        	break;
	        }
        }
	}
}