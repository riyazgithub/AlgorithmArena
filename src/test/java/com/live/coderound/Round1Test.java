package com.live.coderound;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Round1Test {
    @Test
    public void testDosSomething(){
        Round1 r1 = new Round1();
        assertEquals("test", r1.doSomething());
    }
}
