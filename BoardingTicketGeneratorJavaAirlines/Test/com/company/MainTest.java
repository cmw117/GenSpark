package com.company;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        String name;
        name="cassie";
        assertEquals("cassie",name);

        int age;
        age=12;
        assertEquals(12,age);

        String email="cjwest07@gmail.com";
        assertEquals("cjwest07@gmail.com",email);

        String phone="1234567890";
        assertEquals("1234567890",phone);

        char gender='f';
        assertEquals('f',gender);

        String dest="newyork";
        assertEquals("newyork",dest);

        int deph = 12, depm = 12;
        String depTime = Integer.toString(deph) + ":" + Integer.toString(depm);
        assertEquals("12:12",depTime);


    }
}