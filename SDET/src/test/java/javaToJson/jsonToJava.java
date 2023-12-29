package javaToJson;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;



public class jsonToJava {

        public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, IOException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=null;
            ArrayList<customerDetails> a=new ArrayList<customerDetails>();

//DB connection config
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");
//object of statement class will help us to execute queries
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("select * from CustomerInfo where location = 'Asia' and purchasedDate=curdate();");
            while(rs.next()) //next=Pointer pointing point - while boolean value
            {
                customerDetails c=new customerDetails();
                c.setCourseName(rs.getString(1));
                c.setPurchasedDate(rs.getString(2));
                c.setAmount(rs.getInt(3));
                c.setLocation(rs.getString(4));
                a.add(c); //add values in the array

            }
            for(int i=0;i<a.size();i++)
            {
                ObjectMapper o=new ObjectMapper();
                o.writeValue(new File("SEDT:\\JsonJava\\customerInfo"+i+".json"),a.get(i));

            }
            connection.close();

        }

    }

