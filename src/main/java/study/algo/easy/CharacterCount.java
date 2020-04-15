package study.algo.easy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {

    public static void main(String[] args) {

        CharacterCount count = new CharacterCount();
        count.startCounting();



    }

    private void startCounting() {
        String test = "Hello how are you doing 232323?";
        //Map<Character, Integer> characterMap = new HashMap<>();
        int count = 0;
        StringTokenizer tokenizerSentence = new StringTokenizer(test);
        List<Character> characterList = new ArrayList<>();
        while (tokenizerSentence.hasMoreTokens()){
            String word = tokenizerSentence.nextToken();
            System.out.println("Word: "+ word);
            for (int i = 0; i < word.length(); i++) {
                characterList.add(word.charAt(i));
            }
        }

        Map<Character, Long> countMap = characterList.stream().filter(Character::isLetter).map(Character::toUpperCase).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(countMap);

    }

    private void addOrUpdateCount(Map<Character, Integer> characterMap, Character character) {

        if(Character.isLetter(character)){
            Character upperCase = Character.toUpperCase(character);
            if(characterMap.get(upperCase) != null) {
                int val = characterMap.get(upperCase);
                characterMap.put(upperCase, ++val);
            }else{
                characterMap.put(character, 1);
            }
        }

    }

}
