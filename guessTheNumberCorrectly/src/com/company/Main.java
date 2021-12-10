package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean PLAY= true;
        String YorN;
        int from = 1;
        int to = 20;
        int comp = random.nextInt(to - from)+from;
        int user;
        int guesses = 0;
        System.out.println("Hello! What is your name?");
        Scanner getInput = new Scanner(System.in);
        String name = getInput.nextLine();
        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20. Take a guess.");
        do {
            user = input.nextInt();
            guesses++;
            if (user > comp) {
                System.out.println("Your guess is too high. Take a guess.");
            } else if (user < comp) {
                System.out.println("Your guess is too low. Take a guess.");
            } else {
                System.out.println("Well done, " + name + "! You guessed my number in " + guesses + " guesses. Want to play again? Y or N?");
                YorN = getInput.nextLine();
                    if (YorN.equals("Y") || YorN.equals("y")) {
                        System.out.println("Take a guess.");
                        PLAY = true;
                    } else if (YorN.equals("N") || YorN.equals("n")){
                         System.out.println("Have a great day!");
                         PLAY = false;
                } else {
                        PLAY = false;
                    }
            }//while (PLAY=true);
        } while (PLAY = true);
    }
}

