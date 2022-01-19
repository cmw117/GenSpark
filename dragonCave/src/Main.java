import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Main {
    @Test
    public static void main(String[] args) {
        String errorMessage = "Please input one of the numbers.";
        try {
            System.out.println("You are in a land full of dragons. In front of you, you see two caves. In one cave, the dragon is friendly and will share his treasure with you. The other dragon is greedy and hungry and will eat you on sight. Which cave will you go into? (1 or 2)");
            Scanner getInput = new Scanner(System.in);
            public String input = getInput.nextLine();
            if (input == "1") {
                System.out.println("You approach the cave...It is dark and spooky...A large dragon jumps out in front of you! He opens his jaws and...Gobbles you down in one bite!");
            } else {
                System.out.println("You approach the cave...a cute baby dragon flies out and wants to hang out with you");
            }
        } catch (Exception e) {
            System.out.println(errorMessage);
        }
        //public String getErrorMessage () {
            //return errorMessage;
        }
    }
}
