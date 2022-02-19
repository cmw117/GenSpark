import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1 or 2 players?");
        String players = keyboard.nextLine();
            String word;
        if (players.equals("1")) {
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
        } else {
                System.out.println("Player 1, please enter your word:");
                word = keyboard.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Ready for player 2! Good luck!");
            }

        List<Character> playerGuesses = new ArrayList<>();

        Integer wrongCount = 0;

        while (true) {
                printHangedMan(wrongCount);

        if (wrongCount >= 6) {
                    System.out.println("You lose!");
                    System.out.println("The word was: " + word);
                    break;
        }
        if(printWordState(word, playerGuesses)) {
                    System.out.println("You win!");
                    break;
        }
        if (!getPlayerGuess(keyboard, word, playerGuesses)) {
                    wrongCount++;
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
                } else {
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
                } else {
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
            System.out.println(letterGuess + " is in the word is " + word.contains(letterGuess));
            return word.contains(letterGuess);
        }

        private static boolean printWordState(String word, List<Character> playerGuesses) {
            String s = word.codePoints().map(operand -> playerGuesses.contains((char)operand) ? operand : '-').collect(StringBuilder::new,
                            StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            System.out.println(s);
            return s.equals(word);
        }
    }

