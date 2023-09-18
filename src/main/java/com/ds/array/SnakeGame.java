package com.ds.array;

import java.util.Deque;
import java.util.LinkedList;


/**
 Design a Snake game that is played on a device with screen size height x width. Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0, 0) with a length of 1 unit.

 You are given an array food where food[i] = (ri, ci) is the row and column position of a piece of food that the snake can eat. When a snake eats a piece of food, its length and the game's score both increase by 1.

 Each piece of food appears one by one on the screen, meaning the second piece of food will not appear until the snake eats the first piece of food.

 When a piece of food appears on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 The game is over if the snake goes out of bounds (hits a wall) or if its head occupies a space that its body occupies after moving (i.e. a snake of length 4 cannot run into itself).

 Implement the SnakeGame class:

 SnakeGame(int width, int height, int[][] food) Initializes the object with a screen of size height x width and the positions of the food.
 int move(String direction) Returns the score of the game after applying one direction move by the snake. If the game is over, return -1.
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