package com.dynamicP;

public class PartionProblemMemoization {
    public static boolean partitionProblem(int[] set) {
        int sum =0;
        for(int i=0;i<set.length;i++)
            sum+=set[i];
        if(sum%2!=0)
            return false;

        int[][] lookupTable = new int[set.length][sum/2+1];
        for(int i=0;i<set.length;i++)
            for(int j=0;j<sum/2+1;j++)
                lookupTable[i][j]=-1;

        return partitionProblemRecursive(set, sum/2, 0, lookupTable) == 1;
    }

    private static int partitionProblemRecursive(int[] set, int sum, int currIndex, int[][] lookupTable) {

        if(currIndex >= set.length || sum < 0)
            return 0;
        if(sum == 0)
            return 1;
        if(lookupTable[currIndex][sum] == -1) {
            if(set[currIndex] <= sum) {
                if(partitionProblemRecursive(set, sum - set[currIndex], currIndex+1, lookupTable) == 1)
                {
                    lookupTable[currIndex][sum] = 1;
                    return 1;
                }
            }
            lookupTable[currIndex][sum] = partitionProblemRecursive(set, sum, currIndex+1, lookupTable);
        }

        return lookupTable[currIndex][sum];
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3, 4, 5};
        System.out.println("Partition one " + PartionProblemMemoization.partitionProblem(set));
    }
}
