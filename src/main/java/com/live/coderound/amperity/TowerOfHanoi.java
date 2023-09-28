package com.live.coderound.amperity;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 3 towers -- Move disks 1,2,3 from tower1 to 3 -- final order should be the same
 * Condition - always smallest disk on top
 * Accept input , validate moves, knowing when game is finishes
 * you can move a disk to any other tower
 * [1,2,3] --> 2 : [1,] 1:[2,3]
 *
 * Move , validate (move is correct, end condition),
 */
public class TowerOfHanoi {

    int countDisks = 3;
    int countTowers = 3;

    ArrayList<Stack<Integer>> tower = new ArrayList<>();
    int[][] dp = new int[countDisks][countTowers];

    public TowerOfHanoi() {
        Stack<Integer> t1 = new Stack<>();
        t1.push(3);t1.push(2);t1.push(1);
        tower.add(t1);
        for (int i =1; i< countTowers; i++) {
            tower.add(new Stack<>());
        }

    }
    public int move(int disk, int srcTower, int targetTower) {
        if(isValidMove(disk, targetTower)){
          Stack<Integer> srcList = tower.get(srcTower);
          int diskFromsrc = srcList.pop();
          if(disk != diskFromsrc) {
              return -1; // wrong move
          }
            Stack<Integer> targetList = tower.get(targetTower);
          targetList.push(disk);
          return isEndGame() ? 2 : 1;
        }
        return -1;
    }

    public boolean isValidMove(int disk, int targetTower){
        Stack<Integer> targetStack = tower.get(targetTower);
        if(targetStack.isEmpty()) return true;
        int diskOnTarget = targetStack.peek();
        return disk < diskOnTarget;
    }

    public boolean isEndGame(){
        return tower.get(2).size() ==3;
    }
    public static void main(String[] args) {
        TowerOfHanoi th = new TowerOfHanoi();
        System.out.println(th.move(1,0,2));
        System.out.println(th.move(2,0,2));
    }
}
