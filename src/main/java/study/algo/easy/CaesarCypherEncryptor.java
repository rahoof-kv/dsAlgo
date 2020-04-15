package study.algo.easy;

public class CaesarCypherEncryptor {

    public static void main(String[] args) {

        System.out.println(caesarCypherEncryptor("xyz",2));
    }

    public static String caesarCypherEncryptor(String str, int key) {

        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {

            result[i] = getNewCharacter(chars[i], key);
        }

        return new String(result);
    }

    private static char getNewCharacter(char character, int key) {

        int val = character + key;

        if (val > 122) {
            int offset = val % 122;
            val = 96 + offset;
            return (char)val;
        } else {
            return (char)val;
        }
    }
}
