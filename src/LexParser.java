import java.io.*;
import java.io.File;
import java.util.Scanner;

import static java.lang.Integer.min;

public class LexParser {
    private static Scanner in;
    private static LexGrammar grammar;
    private static String lastString;
    private static int id;
    private static boolean flag;

    LexParser(String s) throws Exception {
        in = new Scanner(new File(s));
        grammar = new LexGrammar();
        if (in.hasNextLine())
            lastString = in.nextLine();
        else
            lastString = "";
        id = 0;
        flag = false;
    }

    private static boolean isLetter(char ch) {
        return ((int)ch >= (int)'a' && (int)ch <= (int)'z') || ((int)ch >= (int)'A' && (int)ch <= (int)'Z');
    }

    private static boolean isNumber(char ch) {
        return ((int)ch >= (int)'0' && (int)ch <= (int)'9');
    }

    public static String getLexeme() {
        String ans = "";

        if (flag)
            return "";

        if (lastString.isEmpty()) {
            id = 0;
            if (in.hasNextLine())
                lastString = in.nextLine();
            else flag = true;

            return "\\n";
        }

        if (id == lastString.length()) {
            id = 0;
            if (in.hasNextLine())
                lastString = in.nextLine();
            else flag = true;

            return "\\n";
        }

        int i;
        if (isLetter(lastString.charAt(id))) {
            for (i = id; i < lastString.length(); i++) {
                if (!(isLetter(lastString.charAt(i)) || isNumber(lastString.charAt(i)) || lastString.charAt(i) == '_'))
                    break;
                ans = ans + lastString.charAt(i);
            }
            id = i;
        } else if (isNumber(lastString.charAt(id))) {
            boolean flDot = false;

            for (i = id; i < lastString.length(); i++) {
                if (lastString.charAt(i) == '.' && !flDot && (i + 1 < lastString.length() && isNumber(lastString.charAt(i + 1))))
                    flDot = true;
                else if (!(isNumber(lastString.charAt(i))))
                    break;

                ans = ans + lastString.charAt(i);
            }
            id = i;
        } else {
            String sampleStr = "";
            int constLen = 20;
            if (lastString.charAt(id) == ' ') {
                id++;
                return " ";
            }
            for (i = id; i < min(id + constLen, lastString.length()); i++) {
                sampleStr = sampleStr + lastString.charAt(i);
                if (grammar.contains(sampleStr)) {
                    id = i + 1;
                    ans = sampleStr;
                }
            }
        }
        if (ans.equals("//"))
            id = lastString.length();
        return ans;
    }
    public static void main(String[] args) throws Exception {
        LexParser ls = new LexParser("input.txt");
        while (true) {
            String s = getLexeme();
            if (s.equals(""))
                break;
            else
                if (s.equals("\\n"))
                    System.out.println("<" + s + ">");
                else System.out.print("<" + s + ">");

        }
    }
}
