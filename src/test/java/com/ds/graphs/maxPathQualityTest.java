package com.ds.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class maxPathQualityTest {

    @Test
    public void testMaxPath() {
        int[] values1 = {0, 32, 10, 43};
        int[][] edges1 = {{0, 1, 10}, {1, 2, 15}, {0, 3, 10}};
        int maxTime1 = 49;
        maxPathQuality mx = new maxPathQuality();
        int expected =75;
        assertEquals(expected, mx.maximalPathQuality(values1,edges1,maxTime1));
    }
}
