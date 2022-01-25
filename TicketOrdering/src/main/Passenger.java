package main;

public class Passenger {

    public final String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public final int age;
    public final String gender;
    public final String email;
    public final String phoneNumber;

    public String startingLocation;
    public String destinationLocation;


    public Passenger(String name, int age, String gender, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;


        this.phoneNumber = phoneNumber;
    }

}

