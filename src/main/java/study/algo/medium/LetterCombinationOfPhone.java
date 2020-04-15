package study.algo.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone {

    public static void main(String[] args) {

        List<String> combinations = letterCombinations("34");
        combinations.stream().forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }

        String[] mappings = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        letterCombinationsRecursive(result,mappings,digits,"",0);

        return result;

    }

    private static void letterCombinationsRecursive(List<String> result, String[] mappings, String digits, String current, int index) {

        if (digits.length() == index) {
            result.add(current);
            return;
        }

        String letters = mappings[digits.charAt(index) - '0'];

        for(int i =0; i< letters.length(); i++) {
            letterCombinationsRecursive(result, mappings, digits, current + letters.charAt(i) ,index+1 );
        }


    }
}
