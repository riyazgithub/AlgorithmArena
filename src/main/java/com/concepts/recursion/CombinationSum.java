package com.concepts.recursion;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> perm = new ArrayList<>();
    ArrayList<Integer> slate = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHelp(candidates, target, 0);
        return perm;
    }

    private void combinationSumHelp(int[] candidates, int target, int start) {

        if(target == 0){
            List<Integer> l1 = new ArrayList<>(slate);
            Collections.sort(l1, (a, b) -> a.compareTo(b));
            if(!perm.contains(l1))
                perm.add(l1);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i< candidates.length; i++){
            slate.add(candidates[i]);
            combinationSumHelp(candidates, target-candidates[i], i);
            slate.remove(slate.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = new int[]{2,3,6,7};
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists = cs.combinationSum(candidates, 8);

        System.out.println("Size of List of Lists: " + listOfLists.size());

        for (int i = 0; i < listOfLists.size(); i++) {
            System.out.println("List " + (i + 1) + ":");
            List<Integer> innerList = listOfLists.get(i);

            for (int j = 0; j < innerList.size(); j++) {
                System.out.print(innerList.get(j) + ", ");
            }
            System.out.println();
        }

    }

}
