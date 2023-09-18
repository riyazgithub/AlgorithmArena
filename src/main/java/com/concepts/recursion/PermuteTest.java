package com.concepts.recursion;

import java.util.*;

public class PermuteTest {

    // Define a custom comparator for List<List<Integer>>
    Comparator<List<Integer>> listComparator = (list1, list2) -> {
        int size1 = list1.size();
        int size2 = list2.size();
        int minSize = Math.min(size1, size2);

        for (int i = 0; i < minSize; i++) {
            int cmp = Integer.compare(list1.get(i), list2.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }

        return Integer.compare(size1, size2);
    };


    public static void main(String[] args) {
        PermuteTest tester = new PermuteTest();

//         Test Case 1
        int[] nums1 = {1, 2, 3};
        tester.testPermute(nums1);

        // Test Case 2
        int[] nums2 = {4, 5};
        tester.testPermute(nums2);

//        tester.testUniqueSubsets();
    }

    public void testUniqueSubsets() {
        List<List<Integer>> listOfLists = new ArrayList<>();

        listOfLists.add(new ArrayList<>()); // []
        listOfLists.add(Arrays.asList(1)); // [1]
        listOfLists.add(Arrays.asList(2)); // [2]
        listOfLists.add(Arrays.asList(1, 2)); // [1, 2]
        listOfLists.add(Arrays.asList(3)); // [3]
        listOfLists.add(Arrays.asList(1, 3)); // [1, 3]
        listOfLists.add(Arrays.asList(2, 3)); // [2, 3]
        listOfLists.add(Arrays.asList(1, 2, 3)); // [1, 2, 3]

   // Sort the list of lists using the custom comparator
        Collections.sort(listOfLists, listComparator);

        UniqueSubSets uss = new UniqueSubSets();
        List<List<Integer>> result = uss.subsets(new int[] {1,2,3});

        Collections.sort(result, listComparator);

        if(result.equals(listOfLists)){
            System.out.println("Pass");
        } else
            System.out.println("Fail");
    }
    public void testletterCase() {
        List<String> expected = new ArrayList<>();
        expected.add("a1b2");
        expected.add("A1b2");
        expected.add("a1B2");
        expected.add("A1B2");

        letterCasePermutation lcp = new letterCasePermutation();
        List<String> result = lcp.letterCasePermutation("a1b2");
        Collections.sort(result);
        Collections.sort(expected);
        if (expected.equals(result)) {
            System.out.println("Test Result: " + result);
            System.out.println("Test Passed: " + "a1b2");
        } else {
            System.out.println("Test Failed: " + "a1b2");
        }

    }
    public void testPermute(int[] nums) {
        List<List<Integer>> expected = generateExpectedPermutations(nums);
        permutationLearn permutations = new permutationLearn();
        List<List<Integer>> result = permutations.permute(nums);

        if (expected.equals(result)) {
            System.out.println("Test Result: " + result);
            System.out.println("Test Passed: " + Arrays.toString(nums));
        } else {
            System.out.println("Test Failed: " + Arrays.toString(nums));
        }
    }

    private List<List<Integer>> generateExpectedPermutations(int[] nums) {
        // This function generates all permutations of the input array for testing purposes.
        List<List<Integer>> permutations = new ArrayList<>();
        permuteHelper(nums, permutations, new ArrayList<>());
        return permutations;
    }

    private void permuteHelper(int[] nums, List<List<Integer>> permutations, List<Integer> slate) {
        if (slate.size() == nums.length) {
            permutations.add(new ArrayList<>(slate));
            return;
        }
        for (int num : nums) {
            if (!slate.contains(num)) {
                slate.add(num);
                permuteHelper(nums, permutations, slate);
                slate.remove(slate.size() - 1);
            }
        }
    }

}
