/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pack;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author shruti
 */
@Controller
public class samplecontroller {
    String t="",s=" ",sn=" ";
   
    @RequestMapping("/homepage")
    public String home()
    {
        System.out.println("i am homepage");
        return"homepage";
    }
     @RequestMapping("/teacherlogin")
    public  String showform()
    {
        System.out.println("i am adminlogin");
        return "teacherlogin";
        //return adminlogin.jsp
    }
    @RequestMapping(value="/processform",method=RequestMethod.POST)
    public  String Handleform(@RequestParam("b") String y,
            @RequestParam("c") String z,Model object1) throws SQLException
    {
        String m="",l="";
        Connection con=null;
        PreparedStatement stmt=null;
        try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");  
stmt=con.prepareStatement("select * from teacher where username=? and password=?");  
stmt.setString(1,y);//1 specifies the first parameter in the query  
stmt.setString(2,z);  

       

         ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
            m=rs.getString("username");
            l=rs.getString("password");
            t=rs.getString("TEACHER_ID");
            System.out.println(t);
            object1.addAttribute("us", rs.getString("username"));
             
       }
       
       
        }
        
        
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
            
        }
        finally
        {
         stmt.close();
         con.close();
        }
        if(y.equals(m) && z.equals(l))
       {
        Connection con1=null;
        PreparedStatement stmt1=null;
        try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");  
stmt=con1.prepareStatement("select * from teacher where username=? and password=?");  
stmt1.setString(1,y);//1 specifies the first parameter in the query  
stmt1.setString(2,z);  

       

         ResultSet rs=stmt1.executeQuery();
       while(rs.next())
       {
            m=rs.getString("username");
            l=rs.getString("password");
            t=rs.getString("TEACHER_ID");
            System.out.println(t);
            object1.addAttribute("us", rs.getString("username"));
             
       }
       
       
        }
        
        
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
            
        }
        finally
        {
         stmt.close();
         con.close();
        }
           return "welcometeacher";
       }
       else
       {
           object1.addAttribute("ero", "*invalid credentials!!");
           return "error";
           
       }
        
    

    }
     @RequestMapping("/studentlogin")
    public  String showform4()
    {
        System.out.println("i am studentlogin");
        return "studentlogin";
        //return adminlogin.jsp
    }
   
    @RequestMapping(value="/processform1",method=RequestMethod.POST)
    public  String Handleform1(@RequestParam("b") String y,
            @RequestParam("c") String z,Model object1) throws SQLException
    {
        String m="",l="";
        Connection con=null;
        PreparedStatement stmt=null;
        try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");  
stmt=con.prepareStatement("select * from student where username=? and password=?");  
stmt.setString(1,y);//1 specifies the first parameter in the query  
stmt.setString(2,z);  

       

         ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
            m=rs.getString("username");
            l=rs.getString("password");
            s=rs.getString("student_ID");
            sn=rs.getString("username");
            System.out.println(s);
            object1.addAttribute("us", sn);
             
       }
       
       
        }
        
        
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
            
        }
        finally
        {
         stmt.close();
         con.close();
        }
        if(y.equals(m) && z.equals(l))
       {
           return "welcomestudent";
       }
       else
       {
           object1.addAttribute("ero", "*invalid credentials!!");
           return "error";
           
       }
    }
     @RequestMapping("/courses")
    public  String showform1(Model object1)
    {
        Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");  
stmt=con.prepareStatement("select teacher_id from teacher where teacher_id=?");  
stmt.setInt(1, Integer.parseInt(t));
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("tID", rs.getString("teacher_id"));
             
            
       }
        }
        
        
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
      finally
        {
         
        }
        System.out.println("i am adminlogin");
        return "cour";
    
        //return adminlogin.jsp
    }
    @RequestMapping("/course2")
    public  String showform2()
    {
        System.out.println("i am adminlogin");
        return "course2";
        //return adminlogin.jsp
    }
    @RequestMapping("/reports2")
    public  String showform3()
    {
        System.out.println("i am reports display");
        return "reports2";
        //return adminlogin.jsp
    }
    @RequestMapping("/dashboard")
    public  String showform5()
    {
        System.out.println("i am reports display");
        return "welcometeacher";
        //return adminlogin.jsp
    }
      @RequestMapping("/fpass")
    public  String showform6()
    {
        System.out.println("i am reports display");
        return "fpass";
        //return adminlogin.jsp
    }
      @RequestMapping("/phypract")
    public  String showform7()
    {
        System.out.println("i am reports display");
        return "phypract";
        //return adminlogin.jsp
    }
      @RequestMapping("/updatepm")
    public  String showform8()
    {
        System.out.println("i am reports display");
        return "updatepm";
        //return adminlogin.jsp
    }
    @RequestMapping(value="/updform",method=RequestMethod.POST)
    public  String Handleformm5( @RequestParam("id") int  u,
            @RequestParam("name") String  y,
            @RequestParam("practical1") String  z,
            @RequestParam("practical2") String  w,
            @RequestParam("practical3") String  a,
            @RequestParam("practical4") String  b,
            
            
            Model object1) throws SQLException 
    {
        
        Connection con=null;
        PreparedStatement stmt=null; 
   
        try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");
stmt=con.prepareStatement("update physicsm set practical1=?,practical2=?,practical3=?,practical4=? where student_id=?");  
  stmt.setInt(5,u);
  stmt.setString(1,z);//1 specifies the first parameter in the query  
stmt.setString(2,w); 
stmt.setString(3,a);//1 specifies the first parameter in the query  
stmt.setInt(4, Integer.parseInt(b));
//stmt.setString(5,b);//1 specifies the first parameter in the query  



         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        }
       catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
        {
            stmt.close();
            con.close();
        }
        
        return"phypract";
    }
     @RequestMapping("/phytheory")
    public  String showform9()
    {
        System.out.println("i am phytheory");
        return "phytheory";
}
     @RequestMapping("/updatetm")
    public  String showform10()
    {
        System.out.println("i am reports display");
        return "updatetm";
        //return adminlogin.jsp
    }
    @RequestMapping(value="/updtform",method=RequestMethod.POST)
    public  String Handleformm( @RequestParam("id") int  u,
            @RequestParam("name") String  y,
            @RequestParam("midsem") String  z,
            @RequestParam("endsem") String  w,
            
            
            
            Model object1) throws SQLException 
    {
        
        Connection con=null;
        PreparedStatement stmt=null; 
   
        try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");
stmt=con.prepareStatement("update physicsm set midsem=?,endsem=? where student_id=?");  
  stmt.setInt(3,u);
  stmt.setString(1,z);//1 specifies the first parameter in the query  
stmt.setString(2,w); 

//stmt.setString(5,b);//1 specifies the first parameter in the query  



         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        }
       catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
        {
            stmt.close();
            con.close();
        }
        
        return"phytheory";
}
    @RequestMapping("/phyia")
    public  String showform11()
    {
        System.out.println("i am reports display");
        return "phyia";
        //return adminlogin.jsp
    }
      @RequestMapping("/updateiap")
    public  String showform12()
    {
        System.out.println("i am reports display");
        return "updateiap";
        //return adminlogin.jsp
    }
    @RequestMapping(value="/updtiform",method=RequestMethod.POST)
    public  String Handleformm( @RequestParam("id") int  u,
            @RequestParam("name") String  y,
            @RequestParam("ia1") String  z,
            @RequestParam("ia2") String  w,
            @RequestParam("ia3") String  a,
            @RequestParam("ia4") String  b,
            
            
            Model object1) throws SQLException 
    {
        
        Connection con=null;
        PreparedStatement stmt=null; 
   
        try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");
stmt=con.prepareStatement("update physicsm set ia1=?,ia2=?,ia3=?,ia4=? where student_id=?");  
  stmt.setInt(5,u);
  stmt.setString(1,z);//1 specifies the first parameter in the query  
stmt.setString(2,w); 
stmt.setString(3,a);//1 specifies the first parameter in the query  
stmt.setInt(4, Integer.parseInt(b));
//stmt.setString(5,b);//1 specifies the first parameter in the query  



         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        }
       catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
        {
            stmt.close();
            con.close();
        }
        
        return"phyia";
    }
     @RequestMapping("/nophyenroll")
    public  String showform14()
    {
        System.out.println("i am reports display");
        return "nophyenroll";
        //return adminlogin.jsp
    }
     @RequestMapping("/viewmarks")
    public  String showform15(Model object1) throws SQLException
    {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
        System.out.println("i am reports display");
        return "viewmarks";
        //return adminlogin.jsp
    }
     @RequestMapping("/selectcourse")
    public  String showform17()
    {
        System.out.println("i am reports display");
        return "selectcourse";
        //return adminlogin.jsp
    }
     @RequestMapping("/viewmarkss")
    public  String showform18(Model object1)throws SQLException
    {
        Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
            
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from student where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
          stmt.close();
          con.close();
          
        
      }
        System.out.println("i am reports display");
        return "viewmarkss";
        //return adminlogin.jsp
    }
    @RequestMapping("/achievments")
    public  String displayform15()
    {
        System.out.println("");
        return "achievments";
    }  
    @RequestMapping(value="/displayform15",method=RequestMethod.POST)
    public  String displayform15( 
            @RequestParam("k") String y,
             @RequestParam("j") String u,
            @RequestParam("g") String z,
            @RequestParam("h") String w,
            @RequestParam("i") String r,
            Model object1) throws SQLException 
    {
      
         
       
        object1.addAttribute("msg","leave applied sucssefully ");
        Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
         
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");  
stmt=con.prepareStatement("insert into acheivement values (?,?,?,?,?)");  
  
stmt.setString(1,y);
stmt.setString(2,u);//1 specifies the first parameter in the query  
stmt.setString(3,z);
stmt.setString(4,w);//1 specifies the first parameter in the query  
stmt.setString(5,r);


         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
          stmt.close();
          con.close();
      }
      return "achievments";
        
}
    @RequestMapping("/achievementdisplay")
    public  String showform19()
    {
        System.out.println("i am reports display");
        return "achievementdisplay";
        //return adminlogin.jsp
    }
    @RequestMapping("/pattendance")
    public  String showform20()
    {
        System.out.println("i am attendance display");
        return "pattendance";
        //return adminlogin.jsp
    }  
    @RequestMapping(value="/displayform20",method=RequestMethod.POST)
    public  String displayform20( 
            @RequestParam("k") String y,
             Model object1) throws SQLException 
    {
        
         
       
        object1.addAttribute("msg","leave applied sucssefully ");
        Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 

    
stmt=con.prepareStatement("insert into pattendance values(?,null,null)");


   stmt.setString(1,y);
//   Statement st=con.createStatement();
//   String sql="alter table pattendance add ? varchar(20)";
//   
//   st.executeUpdate(sql);
          stmt.executeUpdate();
            System.out.println("table altered succesfully");
//stmt.setString(1,y);
//    stmt.setString(1,y);
//
//
//
    //it is used for all insert , update ,delete 
        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
          stmt.close();
          con.close();
      }
      return "pattendance";
        

    }
    String d="";
      @RequestMapping("/attendan")
    public  String showform21()
    {
         return "attendan";
        //return adminlogin.jsp
    }
    
        @RequestMapping(value="/displayform21",method=RequestMethod.POST)
    public  String displayform21( 
            @RequestParam("i") String y,
            @RequestParam("p1") String x,
            @RequestParam("p2") String z,
             Model object1) throws SQLException 
    {
        
         
       
       d=y;
        Connection con=null;
        PreparedStatement stmt=null;
        PreparedStatement stmt1=null;
      try 
        {
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("UPDATE pattendance SET shruti=?, hemangi =? WHERE datee=?");
   stmt.setString(2,x);
   d=y;
            System.out.println(d);
    stmt.setString(1,z);
     stmt.setString(3,y);

          stmt.executeUpdate();
          stmt1=con.prepareStatement("select datee from pattendance where datee=?"); 
          stmt1.setString(1,d);
ResultSet rs1=stmt1.executeQuery();
       while(rs1.next())
       {
           object1.addAttribute("da", rs1.getString("datee"));
             System.out.println(rs1.getString("datee"));
            
       }
            System.out.println("attendance marked successfully");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
          stmt.close();
           stmt1.close();
          con.close();
      }
        System.out.println("i am attendance marking");
       
          return "agraph";
}
     @RequestMapping("/apage")
    public  String showform22()
    {
         return "apage";
        //return adminlogin.jsp
    }
      @RequestMapping("/satt")
    public  String showform23()
    {
         return "satt";
        //return adminlogin.jsp
    }
     @RequestMapping("/coaatt")
    public  String showform46()
    {
         return "coaatt";
        //return adminlogin.jsp
    }
     @RequestMapping("/cnatt")
    public  String showform47()
    {
         return "cnatt";
        //return adminlogin.jsp
    }
     @RequestMapping("/datt")
    public  String showform48()
    {
         return "datt";
        //return adminlogin.jsp
    }
     @RequestMapping("/sc")
    public  String showform24()
    {
         return "sc";
        //return adminlogin.jsp
    }
 @RequestMapping("/pinfo")
    public  String showform25(Model object1) throws SQLException
    {
       Connection con=null;
        PreparedStatement stmt=null;
      try 
        { 
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
          
          stmt.close();
               con.close();
          
        
      }
        
       
         return "pinfo";
        //return adminlogin.jsp
    }
    @RequestMapping(value="/pinfoform",method=RequestMethod.POST)
    public  String Handleformm5( 
            @RequestParam("b") String  x,
            @RequestParam("c") String  y,
            @RequestParam("d") String  z,
            @RequestParam("e") String  w,
            
            
            Model object1) throws SQLException 
    {
        
        Connection con=null;
        PreparedStatement stmt=null; 
   
        try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");
stmt=con.prepareStatement("update studentinfo set name=?,dob=?,year=? ,department=? where student_id=?");  
 
  stmt.setString(1,x);//1 specifies the first parameter in the query  
stmt.setString(2,y); 
stmt.setString(3,z);//1 specifies the first parameter in the query  
stmt.setString(4,w);
stmt.setInt(5, Integer.parseInt(s));
//stmt.setString(5,b);//1 specifies the first parameter in the query  



         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        }
       catch(Exception k)
        {
            System.out.println(k.getMessage());
            System.out.println(sn);
        }
        
        finally
        {
            stmt.close();
            con.close();
        }
        
        return"welcomestudent";
    }
 
   @RequestMapping("/home")
    public  String showform25()
    {
         return "welcomestudent";
        //return adminlogin.jsp
    }
    @RequestMapping("s3report")
    public  String showform26(Model object1) throws SQLException
   {
       Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
            
        
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
         stmt.close();
         con.close();
      }
        
         return "s3report";
        //return adminlogin.jsp
    }
  @RequestMapping("/cdisplay")
    public  String showform27()
    {
        
         return "cdisplay";
        //return adminlogin.jsp
    }
 
     @RequestMapping("s2report")
    public  String showform29(Model object1) throws SQLException
   {
       Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
            
        
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
      }
        
         return "s2report";

}
     @RequestMapping("s1report")
    public  String showform30(Model object1) throws SQLException
   {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
         return "s1report";

}
    @RequestMapping("osreport")
    public  String showform31(Model object1) throws SQLException
   {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
       return "osreport";

}
    //yrep
    @RequestMapping("y1report")
    public  String showform32(Model object1) throws SQLException
   {
       Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
            
        
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
      }
        
         return "y1report";

}
    @RequestMapping("y2report")
    public  String showform33(Model object1) throws SQLException
   {
       Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
            
        
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
      }
        
         return "y2report";

}
     @RequestMapping("y3report")
    public  String showform34(Model object1) throws SQLException
   {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
         return "y3report";

}
    @RequestMapping("y4report")
    public  String showform35(Model object1) throws SQLException
   {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
       return "y4report";

}

@RequestMapping("/cnm")
    public  String showform41(Model object1) throws SQLException
    {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
        System.out.println("i am reports display");
        return "cnm";
        //return adminlogin.jsp
    }
    @RequestMapping("/coam")
    public  String showform42(Model object1) throws SQLException
    {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
        System.out.println("i am reports display");
        return "coam";
        //return adminlogin.jsp
    }
    
  @RequestMapping("/dam")
    public  String showform43(Model object1) throws SQLException
    {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
        System.out.println("i am reports display");
        return "dam";
        //return adminlogin.jsp
    }
   @RequestMapping("cp")
    public  String showform44(Model object1) throws SQLException
   {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
       return "cp";

}
       @RequestMapping("repo")
    public  String showform45(Model object1) throws SQLException
   {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
       return "repo";

}
     @RequestMapping("/event")
    public  String displayform51()
    {
        System.out.println("");
        return "event";
    }  
    @RequestMapping(value="/displayform51",method=RequestMethod.POST)
    public  String displayform51( 
            @RequestParam("k") String y,
            @RequestParam("g") String z,
           Model object1) throws SQLException 
    {
      
         
       
        object1.addAttribute("msg","eevent added sucssefully ");
        Connection con=null;
        PreparedStatement stmt=null;
      try 
        {
         
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");  
stmt=con.prepareStatement("insert into eventstable values (?,?)");  
  
stmt.setString(1,y);
//1 specifies the first parameter in the query  
stmt.setString(2,z);



         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
          stmt.close();
          con.close();
      }
      return "event";
        
}
     @RequestMapping("coareport")
    public  String showform54(Model object1) throws SQLException
   {
        Connection con=null;
        PreparedStatement stmt=null;
      
      try 
        {
           
         
           
         
            
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123"); 
stmt=con.prepareStatement("SELECT * from studentinfo where student_id=?");
   stmt.setInt(1,Integer.parseInt(s));
  
         
  

          stmt.executeUpdate();
          
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("sid", rs.getString("student_id"));
           
           System.out.println(rs.getString("student_id"));
            
       }
            System.out.println("id passed");
           

        }
         
        
        
        catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
        
        finally
      {
        stmt.close();
        con.close();
        
      }
        
       return "coareport";

}
}
    
    
    


    
    

