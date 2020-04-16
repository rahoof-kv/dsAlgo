package study.algo.easy;

import java.util.ArrayList;
import java.util.Collections;

public class ReorderLogFiles {

    public static void main(String[] args) {
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] result = reorderLogFiles(logs);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] reorderLogFiles(String[] logs) {

        if (logs == null || logs.length == 0) {
            return null;
        }

        String[] result = new String[logs.length];

        ArrayList<String> letterlogs = new ArrayList<>();
        ArrayList<String> digitlogs = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String[] temp = logs[i].split(" ", 2);
            if (!Character.isDigit(temp[1].charAt(0))) {
                letterlogs.add(logs[i]);
            } else {
                digitlogs.add(logs[i]);
            }
        }

        Collections.sort(letterlogs, (a, b) -> {
            String[] s1 = a.split(" ", 2);
            String[] s2 = b.split(" ", 2);
            if (s1[1].compareTo(s2[1]) == 0) {
                return s1[0].compareTo(s2[0]);
            }
            return s1[1].compareTo(s2[1]);
        });

        int k = 0;
        for (String log : letterlogs) {
            result[k] = log;
            k++;
        }
        for (String log : digitlogs) {
            result[k] = log;
            k++;
        }
        return result;
    }
}
