package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Boolean playing = true;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("1 or 2 players?");
        String players = keyboard.nextLine();

        String word;

        if (players.equals("1")) {
            //Scanner scanner = new Scanner(new File(".txt"));
            List<String> words = new ArrayList<>();
            words.add("java");
            words.add("television");
            words.add("computer");
            words.add("cat");
            words.add("dog");
            words.add("spouse");
            words.add("speaker");
            words.add("platform");
            words.add("snapback");
            words.add("kayak");
            words.add("skateboard");


            Random rand = new Random();
            word = (words.get(new Random().nextInt(words.size())));
        }
        else {
            System.out.println("Player 1, please enter your word:");
            word = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Ready for player 2! Good luck!");
        }

        //System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        Integer wrongCount = 0;

        while(true) {
            printHangedMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose!");
                System.out.println("The word was: " + word);
                break;
            }

            printWordState(word, playerGuesses);
            if (!getPlayerGuess(keyboard, word, playerGuesses)) {
                wrongCount++;
            }

            if(printWordState(word, playerGuesses)) {
                System.out.println("You win!");
                break;
            }
            //add play again
            System.out.println("Please enter your guess for the word:");
            if(keyboard.nextLine().equals(word)) {
                System.out.println("You win!");
                break;
            }
            else {
                System.out.println("Nope! Try again.");
            }
        }
    }

    private static void printHangedMan(Integer wrongCount) {
        System.out.println(" -------");
        System.out.println(" |     |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            }
            else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            }
            else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }

    private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Please guess a letter:");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
        String isItThere;
        //return word.contains(letterGuess);
        if (word.contains(letterGuess)) {
            isItThere = "true";
        } else { isItThere = "false"; }
        System.out.println(letterGuess + " is in the word is " + word.contains(letterGuess));
        return word.contains(letterGuess);
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            }

        }
        System.out.println();

        return (word.length() == correctCount);
    }
    }

