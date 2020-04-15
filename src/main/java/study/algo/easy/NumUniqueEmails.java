package study.algo.easy;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {

    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"};

        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmailSet = new HashSet<>();

        for (String email: emails) {
            StringBuilder builder = new StringBuilder();
            int domainIndex = Integer.MAX_VALUE;
            for (int i = 0; i< email.length(); i++) {
                char c = email.charAt(i);
                if (c == '.' &&  i <= domainIndex) {
                    continue;
                } else if(c == '+') {
                    while(email.charAt(i) != '@'){
                        i++;
                    }
                    builder.append(email.substring(i));
                    break;
                } else if ( c == '@'){
                    domainIndex = i+1;
                    builder.append(c);
                } else {
                    builder.append(c);
                }
            }
            uniqueEmailSet.add(builder.toString());
        }

        for(String var: uniqueEmailSet){
            System.out.println(var);
        }
        return uniqueEmailSet.size();
    }
}
