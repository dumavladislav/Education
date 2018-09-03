package ru.dumsky284.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] Args) {

        try
        {
            // create object mapper

            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO
            // data/sample-lite.json

            Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

            // print first name and last name
            System.out.println("First name = " + theStudent.getFirstName());
            System.out.println("First name = " + theStudent.getLastName());

            // print out address

            Address tempAddress = theStudent.getAddress();
            System.out.println("Street = " + tempAddress.getStreet());
            System.out.println("City = " + tempAddress.getCity());

            for (String theLang: theStudent.getLanguages()) {
                System.out.println(theLang);
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
