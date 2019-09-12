import LexGrammar.java;
import java.util.*;

public class LexParser {
    private static Scanner in;
    private static LexGrammar grammar;
    private static String lastString;
    private static int id;

    Starter(String s) {
        Scanner in = new Scanner(new File(s));
        grammar = new LexGrammar('...'); // дописать
        lastString = "";
        id = 0;
    }

    private boolean isLetter(char ch) {
        return ((int)ch >= (int)'a' && (int)ch <= (int)'z') || ((int)ch >= (int)'A' && (int)ch <= (int)'Z');
    }

    private boolean isNumber(char ch) {
        return ((int)ch >= (int)'0' && (int)ch <= (int)'9');
    }

    public String getLexeme() {
        String ans = "";
        if (this.lastString == "" || this.id == this.lastString.length()) {
            this.lastString = this.in.nextLin();
            id = 0;
        }

        switch (id) {
            case (isLetter(lastString[id])):
                for (int i = id; i < lastString.length(); i++) {
                    if !(isLetter(lastString[i]) || isNumber(lastString[i]))
                        break;
                    ans += lastString[i];
                    continue;
                }
                id = i;
                break;
            case (isNumber(lastString[id])):
                for (int i = id; i < lastString.length(); i++) {
                    if !(isNumber(lastString[i]))
                        break;
                    ans += lastString[i];
                    continue;
                }
                id = i;
                break;
            default:
                String sampleStr = "";
                constLen = 4;
                for (int i = id; i < min(id + constLen, lastString.length()); i++) {
                    if !(isLetter(lastString[i]) || isNumber(lastString[i])) {
                        sampleStr = sampleStr + lastString[i];
                        if (grammar.contain(sampleStr)) {
                            id = i + 1;
                            ans = sampleStr;
                        }
                    }
                }
                break;
        }
    }
}
