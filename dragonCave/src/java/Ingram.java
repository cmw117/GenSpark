import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Ingram {
    Ingram ingram;

    @BeforeEach
    void setUp() {
        ingram = new Ingram();
    }
    @Test
    short getErrorMessage() {assertEquals("Please input one of the numbers.", ingram.getErrorMessage(), "That's not a number");
        //Main.getInput("")
        //void getErrorMessage(){assertEquals("Please input one of the numbers.", ingram.getErrorMessage(), "That wasn't a number")

        return 0;
    }

    //private void assertEquals(String s) {
    //}

}
