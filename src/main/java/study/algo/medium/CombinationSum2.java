package study.algo.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidate = new int[]{10,1,2,7,6,1,5};
        //1 1 2 2 5 6 7 10
        List<List<Integer>> result = combinationSum2(candidate, 8);
        System.out.println(result.toString());
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private static void findCombinations(List<List<Integer>> result, List<Integer> currentList, int currentPosition, int[] candidates, int target) {

        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = currentPosition; i < candidates.length; i++) {
            if(currentPosition == i || candidates[i] != candidates[i-1]) {
                currentList.add(candidates[i]);
                findCombinations(result, new ArrayList<>(currentList), i+1, candidates, target - candidates[i]);
                currentList.remove(currentList.size()-1);
            }
        }

    }


}
