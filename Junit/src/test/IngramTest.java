//import static org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngramTest {

    Ingram ingram;

    @BeforeEach
    void setUp() {
        ingram = new Ingram();
    }


    @Test
    void getName() {
        assertEquals("Cassie", ingram.getName(), "What");
    }
    @Test
    void getAge() {
        assertEquals(30, ingram.getAge(), "you're old");
    }

    @AfterEach
    void tearDown() {
    }
}