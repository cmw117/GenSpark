package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String[] wordsForGame = {"cat", "dog", "house", "watermelon", "wife", "table", "programming", "java", "phone"};
    static Random RANDOM = new Random();
    //the word solution for hangman
    private static String wordToFind;
    private static char[] wordFound;
    private static int nbErrors;
    static ArrayList<Character> letters = new ArrayList<>();



    public static void main(String[] args) {
	    nbErrors = 0;
        letters.clear();
        wordToFind = findNextWord();
        //word found initialization
        Scanner keyboard = new Scanner(System.in);

        wordFound = new char[wordToFind.length()];
        System.out.println(findNextWord());
       // for (int i = 0; i < wordFound.length; i++) {
            //wordFound[i] = '';
        //}
        Integer nbErrors = 0;
        while (true) {
            printedHangMan(nbErrors);

            if (nbErrors >= 6) {
                System.out.println("You lose!");
                System.out.println("The word was: " + wordToFind);
                break;
            }
            printWordState(wordToFind, letters);
            if (!getPlayerGuess(keyboard, wordToFind, letters)) {
                nbErrors++;
            }
            if (printWordState(wordToFind,letters)){
                System.out.println("You win!");
                break;
            }
            System.out.println("Please enter your guess for the word: ");
            if (keyboard.nextLine().equals(wordToFind)) {
                System.out.println("You win!");
                break;
            } else {
                System.out.println("Nope! Try again.");
            }
        }

    }
    private static String findNextWord() {
        return wordsForGame[RANDOM.nextInt(wordsForGame.length)];
    }
    private static void printedHangMan(Integer nbErrors) {
        System.out.println("--------");
        System.out.println("   |      |    ");
        if (nbErrors >=1) {
            System.out.println(" 0");
        }
        if (nbErrors >= 2 ) {
            System.out.print("\\  ");
            if (nbErrors >=3) {
                System.out.println("/");
            }
        }

        if (nbErrors >=5) {
            System.out.println("/  ");
            if (nbErrors >= 6) {
                System.out.println("\\  ");
            } else { System.out.println(""); }
        }
    }
    private static boolean getPlayerGuess (Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Please enter a letter:");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }
    private static boolean printWordState(String wordToFind, List<Character> letters) {
        int correctCount = 0;
        for (int i = 0; i < wordToFind.length(); i++) {
            if (letters.contains(wordToFind.charAt(i))) {
                System.out.print("this letter is in your word: " + wordToFind.charAt(i));
                correctCount++;
            }

        } return wordToFind.length() == correctCount;
    }
    public boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }
    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < wordFound.length; i++) {
            builder.append(wordFound[i]);

            if (i < wordFound.length - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
    }
