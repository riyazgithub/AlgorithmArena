package com.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class pairTuple {
    char vertex;
    int value;

    public pairTuple(char v, int i){
        vertex =v;
        value = i;
    }
    public char getVertex() {
        return vertex;
    }
}
public class FindOverLap {

    public int overLap(int[][] v) {
        int count = 0;
        int ret = 0;
        ArrayList<pairTuple> vTransform =  new ArrayList<>();
        for(int i =0; i< v.length; i++){
            vTransform.add(new pairTuple('x', v[i][0]));
            vTransform.add(new pairTuple('y', v[i][1]));
        }
        Collections.sort(vTransform, Comparator.comparingInt(a -> a.value));

        for(int i =0; i<vTransform.size(); i++) {
           if(vTransform.get(i).vertex == 'x'){
               count++;
           } else if(vTransform.get(i).vertex == 'y'){
               count--;
           }
           ret = Math.max(ret, count);
        }
        return ret;
    }
    public static void main(String[] args) {
        int[][] v = { { 1, 8 },
                { 2, 5 },
                { 5, 6 },
                { 3, 7 }};
        FindOverLap fo = new FindOverLap();
        System.out.println("Max Overlap "+ fo.overLap(v));
        int[] s ={1,6,2,0,-4,5,-2};
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
    }
}
