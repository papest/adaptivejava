import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.LinkedList;

/**
 * Obtain the correct bracket sequence
 */

public class BracketSequence {
    static String secondBracket = "}])";
    static String firstBracket = "{[(";
    String bracketSequence = readBrackets();

    private String readBrackets() {
        final int maxLength = 1000002;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            CharBuffer charBuffer = CharBuffer.allocate(maxLength);
            int n = bufferedReader.read(charBuffer);
            String brackets = "";
            if (n > 0) brackets = new String(charBuffer.array()).replaceAll("[^{}()\\[\\]]", "");
            bufferedReader.close();
            return brackets;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        BracketSequence bracketsClass = new BracketSequence();
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        for (char ch : bracketsClass.bracketSequence.toCharArray()) {
            int index = secondBracket.indexOf(ch);
            if (index > -1) {
                if (stack.isEmpty()) {
                    char insertChar = firstBracket.charAt(secondBracket.indexOf(ch));
                    left.insert(0, insertChar);
                } else {
                    if (stack.pop() != firstBracket.charAt(index)) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
            } else {
                stack.push(ch);
            }
        }
        for (char ch : stack) {
            char appendChar = secondBracket.charAt(firstBracket.indexOf(ch));
            right.append(appendChar);
        }
        System.out.print(left);
        System.out.print(bracketsClass.bracketSequence);
        System.out.println(right);
    }
}
