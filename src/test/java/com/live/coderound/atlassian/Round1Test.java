package com.live.coderound.atlassian;

import com.live.coderound.atlassian.Round1;
import com.live.coderound.atlassian.score;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Round1Test {
    @Test
    public void testDosSomething(){
        Round1 r1 = new Round1();
        assertEquals("test", r1.doSomething());
    }

    @Test
    public void testInput(){
        HashMap<String, score> judgeScore = new HashMap<>();
        judgeScore.put("t1", new score(1,2,3));
        judgeScore.put("t2", new score(2,2,3));
        judgeScore.put("t3", new score(4,2,3));
        HashMap<String, HashMap<String,score>> input = new HashMap<>();

        input.put("j1", judgeScore);
        judgeScore = new HashMap<>();
        judgeScore.put("t1", new score(1,2,3));
        judgeScore.put("t2", new score(1,2,3));
        judgeScore.put("t3", new score(1,2,3));
        judgeScore.put("t4", new score(5,5,5));
        input.put("j2", judgeScore);
        Round1 r1 = new Round1();
        assertEquals(3, r1.findTop3(input).size());
    }
}
