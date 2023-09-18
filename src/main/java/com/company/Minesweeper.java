package com.company;

import java.util.Random;
import java.util.Stack;

public class Minesweeper {

    /**
     *
     * Amperity
     * Requirement
     * generateArray -- input size of array, no of bombs output -- array with bombs and adjCount
     * click -- input x,y output, visited -- Update the array cascading reveal
     *
     * 2 , 5*5
     * 0,0
     * 0,1 and 1,0 1
     *
     *
     *
     */

    /**
     * 2*2 -- > 1,1 1,2 1,3 2,1  2,3 3,1 3,2 3,3
     *
     *
     * @param numberOfBombs
     * @param sizeArr
     * @return
     */
    public int[][] generateArray(int numberOfBombs, int sizeArr) {
        int[][] retArr = new int[sizeArr][sizeArr];
        // fill in the bombs
        int size = sizeArr*sizeArr;
        Random rn = new Random();
        for (int count =0;count<numberOfBombs; count++ ){
            int point = rn.nextInt(size);
            int x = point / sizeArr;
            int y = point % sizeArr;
            if(retArr[x][y] !=-1 ) retArr[x][y] = -1;
            else count--;
        }

        for(int x =0; x<sizeArr; x++){
            for(int y=0; y<sizeArr; y++){
                if(retArr[x][y] == -1) {
                    // update the 3 *  3 boundaries
                    for(int x1 = 0; x1< 3; x1++) {
                        for (int y1 =0; y1< 3; y1++){


                        }
                    }
//                    if(x-1 > 0 && y-1>0 && retArr[x-1][y-1]!=-1) retArr[x-1][y-1]++;
//                    if(x-1 > 0 && y>0 && retArr[x-1][y]!=-1) retArr[x-1][y-1]++;
                }
            }
        }


        return retArr;
    }


    public void click (int x, int y, int[][] output, int[][] visited) {
        Stack<pair> s = new Stack<>();
        if(output[x][y] != 0) {
            visited[x][y] = 1;
            return;
        }
        s.push(new pair(x,y));
        while(!s.isEmpty()) {
            pair p = s.pop();
            if(output[p.x-1][p.y-1] == 0 ) {
                visited[p.x][p.y] = 1;
//                s.push()
            }
        }
    }

    class pair {
        int x;
        int y;
        pair( int x1, int y1) {
            this.x = x1; this.y = y1;
        }
    }
}
