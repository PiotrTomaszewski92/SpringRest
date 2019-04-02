package com.spring.rest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Main {
    public static void main(String[] args) {
	    try{
	        //create object mapper
            ObjectMapper mapper = new ObjectMapper();

            //read JSON file and map/convert to Java POJO:
            // data/sample-lite.json
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
            Address address = student.getAddress();
            //print first name and last name
            System.out.println("First name: "+student.getFirstName()+"\nLast name: "+student.getLastName()
                +"\nCity: "+address.getCity());
            for (String lang : student.getLanguages())
                System.out.print(lang+", ");
        }catch (Exception exc){
	        exc.printStackTrace();
        }
    }
}
