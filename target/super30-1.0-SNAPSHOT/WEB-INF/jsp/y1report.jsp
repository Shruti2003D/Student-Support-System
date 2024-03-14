<%-- 
    Document   : yearly report
    Created on : 08-May-2023, 11:34:47 pm
    Author     : shruti
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Support System</title>
</head>
<style>
    *{
        margin: 0px;
        padding: 0px;
    }
    .top_sec {
        background:rgba(0, 0, 0,0.2) url(https://images.static-collegedunia.com/public/college_data/images/campusimage/1567662778accad.png);
        background-size: cover;
        background-blend-mode: darken;
        height: 100vh;
        position: relative;
        
        background-repeat: no-repeat;
        align-items: center;
    }
    .heading{
        text-align: center;
        padding-top: 5%;
        font-size: 24px;
        color: whitesmoke;
        
    }
    table{
        border-collapse: collapse;
        border-radius: 10px;
        margin: auto;
        padding: auto;
        height: 150px;
        width:65%;
        background-color: whitesmoke;
        padding: 2%;
       
    }
    .stud_info{
        
        margin: 3%;
    }
    .stud_grade{
        
        margin: 3%;
    }
    th{
        padding: 1.8% 1%;
    }
    span{
        font-weight: bold;
        font-size: 18px;
    }
    td{
        padding: 0.5%;
        font-size: 18px;
    }
</style>
<% 
          
     String r=(String)  request.getAttribute("sid");
     %>
      <%
          float A[];    //declaring array
A = new float[20];
String B[];    //declaring array
B = new String[20];
float d[];    //declaring array
d = new float[20];
String c[];    //declaring array
c = new String[20];
  
           Connection con=null;
        Statement st=null;
        Statement ts=null;
       PreparedStatement stmt=null;
       try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root@123");  
st= con.createStatement();

ResultSet rs=st.executeQuery("SELECT * FROM s1result WHEre prn= "+r);

while(rs.next())
{
    //String ida=rs.getString("empid");
    A[0]=rs.getInt(4);
    A[1]=rs.getInt(5);
    A[2]=rs.getInt(6);
    for(int i=0;i<5;i++){
    if(A[i]>80)
    B[i]="AA";
    else if(A[i]>70)
    B[i]="AB";
    else if(A[i]>60)
    B[i]="BB";
    else if(A[i]>50)
    B[i]="CC";
    else if(A[i]>40)
    B[i]="DD";
    else 
    B[i]="FF";
          }
   ts= con.createStatement();
 
ResultSet sr=ts.executeQuery("SELECT * FROM s2result WHEre prn= "+r);

while(sr.next())
{
    //String ida=rs.getString("empid");
    d[0]=sr.getInt(4);
    d[1]=sr.getInt(5);
    d[2]=sr.getInt(6);
    for(int i=0;i<5;i++){
    if(d[i]>80)
    c[i]="AA";
    else if(d[i]>70)
    c[i]="AB";
    else if(d[i]>60)
    c[i]="BB";
    else if(d[i]>50)
    c[i]="CC";
    else if(d[i]>40)
    c[i]="DD";
    else 
    c[i]="FF";
          }
                      
      
   %>
<body>
    <section class="top_sec">
        <div class="heading">
             <form id="Form">
                       <input type="radio"  onclick="document.location='y1report'" name="s1report" value="sem1"/>1st year
                          <input type="radio" onclick="document.location='y2report'" name="link" value="sem2"/>2nd year
                    <input type="radio" onclick="document.location='y3report'" name="link" value="sem3"/>3rd year
                     <input type="radio" onclick="document.location='y4report'" name="link" value="sem4"/>4th year
                </form>
            <h1>GRADE CARD</h1>
        </div>
        <div class="stud_info">
            <table border="1px">
                <tr>
                    <td colspan="8" style="padding-left: 2%;"><span>Statement of grades for:</span> Second Year BTech Examination</td>
                </tr>
                <tr>
                    <td style="padding-left: 2%;"><span>Seat No:</span> <%=rs.getString(3)%></td>
                    <td style="padding-left: 2%;"><span>PRN:</span> <%=rs.getString(1)%></td>
                </tr>
                <tr>
                    <td colspan="8" style="padding-left: 2%;"><span>Name:</span> <%=rs.getString(2)%></td>
                </tr>
            </table>
        </div>
        <div class="stud_grade">
            <table border="1px">
                <tr>
                    <th>CODE</th>
                    <th>COURSE NAME</th>
                    <th>GRADE</th>
                </tr>
                <tr>
                    <td colspan="8">SEMESTER: 1</td>
                </tr>
                <tr>
                    <td>AS106T</td>
                    <td>CDE</td>
                    <td><%=B[0]%></td>
                </tr>
                <tr>
                    <td>CS221T</td>
                    <td>DESIGN THINKING</td>
                    <td><%=B[1]%></td>
                </tr>
                <tr>
                    <td>CS223T</td>
                    <td>SCIENCE OF NATURE</td>
                    <td><%=B[2]%></td>
                </tr>
               
                <tr>
                  
                 <tr>
                    <td colspan="8">SEMESTER: 2</td>
                </tr>
                <tr>
                    <td>AS109T</td>
                    <td>SIC</td>
                    <td><%=c[0]%></td>
                </tr>
                <tr>
                    <td>IT321T</td>
                    <td>APPLIED MECHANNICS</td>
                    <td><%=c[1]%></td>
                </tr>
                <tr>
                    <td>CS228T</td>
                    <td>ENGINEERING GRAPHICS</td>
                    <td><%=c[2]%></td>
                </tr>       
                        
                        
                    
                 <%
                      
         
 stmt=con.prepareStatement("INSERT INTO fyresult VALUES (?,?,?,?,?,?,?,?)");
stmt.setString(1,r);
stmt.setString(2,rs.getString(2));
stmt.setString(3,B[0]);
stmt.setString(4,B[1]);
stmt.setString(5,B[2]);
stmt.setString(6,c[0]);
stmt.setString(7,c[1]);
stmt.setString(8,c[2]);
stmt.executeUpdate();
  }}
}
           catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        finally
{
        st.close();
ts.close();
stmt.close();
        con.close();

}
           
           %>
            </table>
            
        </div>
</body>
</html>
