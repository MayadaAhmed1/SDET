package javaToJson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.text.StringEscapeUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class javaToOneJson {

        public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, IOException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=null;
            ArrayList<customerDetails> a=new ArrayList<customerDetails>();
            JsonArray js=new JsonArray();
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
                Gson g=new Gson(); //convert java object to json string content
                String jsonstring=g.toJson(a.get(i));
                js.add(jsonstring);
            }

            //Json simple to create json file formate
            JsonObject jsonObject=new JsonObject();
            jsonObject.add("Data", js);

            String jsonformate= StringEscapeUtils.unescapeJava(jsonObject.toString());
            System.out.println(jsonformate);
//Create file and write json data
            try (FileWriter file=new FileWriter("SEDT:\\JsonJava\\customerInfo_AllJson.json"))
            {
                file.write(jsonformate);
            }



            connection.close();

        }

    }

