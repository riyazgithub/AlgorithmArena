package com.ds.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 *
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 *
 * Implement the Logger class:
 *
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
 */
class SnakeGame {
    class point {
        int x;
        int y;
        public point(int x1, int y1){
            this.x =x1;
            this.y = y1;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof point)) return false;
            point point = (point) o;
            return x == point.x && y == point.y;
        }

    }
    Deque<point> snakeQ;
    Deque<point> foodQ;
    int bx,by;
    int score;
    public SnakeGame(int width, int height, int[][] food) {
        snakeQ = new LinkedList<>();
        snakeQ.add(new point(0,0));
        foodQ = new LinkedList<>();
        score =0;
        this.bx = height; this.by = width;
        for (int[] ints : food) {
            foodQ.add(new point(ints[0], ints[1]));
        }
    }

    public int move(String direction) {
        point curr = snakeQ.peekLast();
        point newPosition = new point(-1, -1);
        if("r".equalsIgnoreCase(direction))
        {
            assert curr != null;
            newPosition = new point(curr.x, curr.y+1);
        }
        if("l".equalsIgnoreCase(direction))
        {
            assert curr != null;
            newPosition = new point(curr.x, curr.y-1);
        }
        if("d".equalsIgnoreCase(direction))
        {
            assert curr != null;
            newPosition = new point(curr.x+1, curr.y);
        }
        if("u".equalsIgnoreCase(direction))
        {
            assert curr != null;
            newPosition = new point(curr.x-1, curr.y);
        }

        // validate boundaries
        if((newPosition.x >= bx || newPosition.y>= by || newPosition.y < 0 || newPosition.x < 0))
            return -1;

        // can collide
        if(snakeQ.contains(newPosition))
        {
            if(snakeQ.size()>4)
                return -1;
        }
        System.out.println(String.format("Current location (%s, %s), New Position (%s,%s), Direction: %s, size of snake %s, snakeQ.contains(newPosition) %s, FoodExists %s ", curr.x,curr.y, newPosition.x, newPosition.y, direction, snakeQ.size(), snakeQ.contains(newPosition), !foodQ.isEmpty() && foodQ.peek().equals(newPosition)));

        // check if food exist
        if(!foodQ.isEmpty() && foodQ.peek().equals(newPosition)){
            point foodPosition =foodQ.poll();
            snakeQ.offer(foodPosition);
            this.score++;
            return this.score;
        }
        // Move the snake
        snakeQ.offer(newPosition);
        snakeQ.poll();
        return this.score;
    }

    public static void main(String[] args) {
        SnakeGame sg = new SnakeGame(3,3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {1, 0}});
        System.out.println(sg.move("R"));
        System.out.println(sg.move("R"));
        System.out.println(sg.move("D"));
        System.out.println(sg.move("L"));
        System.out.println(sg.move("L"));
        System.out.println(sg.move("U"));
        System.out.println(sg.move("U"));
        System.out.println(sg.move("R"));
        System.out.println(sg.move("R"));
        System.out.println(sg.move("D"));
        System.out.println(sg.move("D"));
        System.out.println(sg.move("L"));
        System.out.println(sg.move("L"));
        System.out.println(sg.move("U"));
        System.out.println(sg.move("R"));
        System.out.println(sg.move("U"));
        System.out.println(sg.move("L"));
        System.out.println(sg.move("D"));
    }
}