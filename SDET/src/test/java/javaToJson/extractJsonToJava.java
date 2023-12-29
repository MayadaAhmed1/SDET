package javaToJson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class extractJsonToJava {

    public static void main(String[] args) throws ClassNotFoundException, JsonGenerationException, IOException {

//Will use Jackson library to convert json to java ,so it will reda from json file and set values in declaration class
    ObjectMapper o = new ObjectMapper();
    customerDetails c=o.readValue(new File("SEDT:\\JsonJava\\customerInfo0.json"), customerDetails.class);
   System.out.println(c.getCourseName());
}
    }
