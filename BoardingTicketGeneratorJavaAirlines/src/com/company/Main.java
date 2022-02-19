package com.company;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String date;
    static int age;
    static char gender;

    public static void main(String[] args) throws IOException {
        int boardingPass = Random_number(1213, 1313432);
        Scanner myObj = new Scanner(System.in);
        // Taking Input From User
         // Create a Scanner object
        System.out.println("Hello! Welcome to Java Airlines. Before we get started booking your flight" +
               " we will need some details from you.");

        System.out.println("Please Enter Your First Name");
        String firstName = myObj.nextLine();  // Read user input
        System.out.println("Please Enter Your Last Name");
        String lastName = myObj.nextLine();  // Read user input


        System.out.println("Enter Email");
        String email = myObj.nextLine();  // Read user input
        while (!isValid(email) ) {
            System.out.println("Enter correct Email. Example: abc@gmail.com and include the proper .com/.net/.org");
            email = myObj.nextLine();
        }

        System.out.println("Enter Gender - F for female , M for Male");
        char gender = myObj.next().charAt(0);
        while (true) {
            if (gender == 'F' || gender == 'f' || gender == 'm' || gender == 'M')
                break;
            System.out.println("Enter correct Input. Ex: F for female , M for Male");
            gender = myObj.next().charAt(0);
        }

        myObj.nextLine();
        System.out.println("Enter Age");
        int age = myObj.nextInt();
        while (age <= 0 || age > 120) {
            System.out.println("Enter correct Age in the range of 1 to 120");
            age = myObj.nextInt();
        }
        myObj.nextLine();

        System.out.println("Enter The Year You Plan To Travel. Ex. 2023");
        int year = myObj.nextInt();
        while (Integer.toString(year).length() < 4 || year < 2022) {
            System.out.println("Please enter the year in the correct format");
            year = myObj.nextInt();
        }
        System.out.println("Enter The Month You Plan To Travel. Ex. 10 for October");
        int month = myObj.nextInt();
        while (Integer.toString(month).length() > 2 || month > 12) {
            System.out.println("Please enter the month in the correct format");
            month = myObj.nextInt();
        }
        System.out.println("Enter The Day You Plan To Travel. Ex. 12");
        int day = myObj.nextInt();
        while (Integer.toString(day).length() > 2 || day > 31) {
            if (month == 2 && day > 29) {
                System.out.println("Please enter the day in the correct format");
                month = myObj.nextInt();
            }
            System.out.println("Please enter the month in the correct format");
            month = myObj.nextInt();
        }

        String date = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);




        System.out.println("Enter Phone Number. Include your country code prefix. \n" +
                "For example 1888445687. The USA country code is 1");
        String phone = myObj.nextLine();  // Read user input
        while (isValidPhone(phone)) {
            System.out.println("Please enter valid phone number");
            phone = myObj.nextLine();
        }





        System.out.println("Enter Destination");
        String dest = myObj.nextLine();  // Read user input

        System.out.println("Enter Departure Time in 24 hr format Example 17 20 for 5:20 pm. " +
                "Use a space instead of a colon");
        int deph = myObj.nextInt(), depm = myObj.nextInt();
        while ((deph <= 0 || deph > 24) || (depm <= 0 || depm > 60)) {
            System.out.println("Enter correct Departure Time in 24 hr format e.g 16 20. Example 17 20 for 5:20 pm." +
                    "Use a space instead of a colon");
            deph = myObj.nextInt();
            depm = myObj.nextInt();
        }
        String depTime = Integer.toString(deph) + ":" + Integer.toString(depm);
        System.out.println("Enter " + depTime);

        //  Generating Ticket Price ;
         int ticketPrice = Discount(Random_number(50, 10000), age, gender);
        System.out.println("Ticket price =  " + ticketPrice);



        //Estimation Time of Arrival.
        // Hour
        int etaHour = Random_number(00, 24);
        // Minute
        int etamin = Random_number(00, 60);
        String eta = Integer.toString(etaHour) + ":" + Integer.toString(etamin);

      //  Storing Data and Generating Ticket
        Store_Data(firstName, lastName, age, email, phone, gender, date,
                dest, depTime, eta, ticketPrice, boardingPass);
    }
//Storing Data into File
    public static boolean isValid(String email) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    return email.matches(regex);
}

    public static void Store_Data(String firstName, String lastName, int age, String email, String phone, char gender, String date,
                                  String dest, String depTime, String eta, int ticketPrice, int boardingPass) throws IOException {
        FileWriter myWriter = new FileWriter("store.txt");
        myWriter.write("Name          : " + firstName +  " " + lastName + "\n");
        myWriter.write("Age           : " + age + "\n");
        myWriter.write("Email         : " + email + "\n");
        myWriter.write("Phone #       : " + phone + "\n");
        myWriter.write("Gender        : " + gender + "\n");
        myWriter.write("Date          : " + date + "\n");
        myWriter.write("Destination  : " + dest + "\n");
        myWriter.write("Departure Time : " + depTime + "\n");
        myWriter.write("ETA           : " + eta + "\n");
        myWriter.write("Ticket Price  : " + ticketPrice + "\n");
        myWriter.close();
        System.out.println("Successfully Store the data into file to the file.");
        Generate_Ticket(firstName, lastName, age, email, phone, gender, date,
                dest, depTime, eta, ticketPrice, boardingPass);
    }

    // Generating Ticket
    public static void Generate_Ticket(String firstName, String lastName, int age, String email, String phone, char gender, String date,
                                       String dest, String depTime, String eta, int ticketPrice, int boardingPass) throws IOException {
        FileWriter myWriter1 = new FileWriter("ticket" + firstName.charAt(0) + lastName.charAt(0) + boardingPass + ".txt");
        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);

        ///////
        myWriter1.write("Boarding Pass : " + firstName.charAt(0) + lastName.charAt(0) + boardingPass + "\n");
        myWriter1.write("-----------------------------------\n");
        myWriter1.write("-----------------------------------\n");
        myWriter1.write("PASSENGER DETAILS: \n");
        myWriter1.write("Name          : " + firstName + " " + lastName + "\n");
        myWriter1.write("Age           : " + age + "\n");
        myWriter1.write("Email         : " + email + "\n");
        myWriter1.write("Phone #       : " + phone + "\n");
        myWriter1.write("Gender        : " + gender + "\n");
        myWriter1.write("----------------------------------- \n");
        myWriter1.write("-----------------------------------\n");
        myWriter1.write("\nFLIGHT INFORMATION: \n");
        myWriter1.write("Date          : " + date + "\n");
        myWriter1.write("Destination  : " + dest + "\n");
        myWriter1.write("Departure Time : " + depTime + "\n");
        myWriter1.write("ETA           : " + eta + "\n");
        myWriter1.write("Ticket Price  : " + ticketPrice + "\n");
        myWriter1.write("Trip Booked: " + formatted);
        myWriter1.write("-----------------------------------\n");
        myWriter1.write("-----------------------------------\n");
        myWriter1.write("\n \nThank you for choosing Java Airlines! \nEnjoy your trip.");
        myWriter1.close();
        System.out.println("Successfully Generated Boarding Pass.\n Enjoy Your Trip!");
        System.out.println("Thank you for choosing Java Airlines.");
    }

    // Generating Random Numbers;
    public static int Random_number(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    // Discount on Ticket Price
    public static int Discount(int ticketPrice, int age, char gender) {
        if (age <= 12) {
            ticketPrice = ticketPrice - (ticketPrice * 50) / 100;
        } else if (age >= 60) {
            ticketPrice = ticketPrice - (ticketPrice * 60) / 100;
        } else if (gender == 'F' || gender == 'f') {
            ticketPrice = ticketPrice - (ticketPrice * 25) / 100;
        }
        return ticketPrice;
    }

    public static boolean isValidPhone(String s)  {
        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        return (m.matches());
    }




}
