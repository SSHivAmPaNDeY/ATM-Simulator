package project;
import java.sql.*;
//connectivity takes 5 steps
//generate driver - create connectivity-generate statement
//execute query-close connection

public class connect {
    Connection c;
    static Statement s;
    public connect(){
        //exeption handeling because my sql is an external entity(run time)
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            //registering driver
            //Class.forName(com.mysql.cj.jdbc.Driver);as we imported library it will automatically do the job
            //create connection
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","divya1711");
            //create statement
            s=c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
