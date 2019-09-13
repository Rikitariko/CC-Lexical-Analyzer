import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LexGrammar {
    HashMap<String, String> grammar;

    LexGrammar() throws FileNotFoundException {
        grammar = new HashMap<>(300);
        grammar.put(" ", "opSpace");
        Scanner input = new Scanner(new File("grammarSwift.txt"));
        String[] temp;
        while (input.hasNextLine()) {
            temp = input.nextLine().split(" ");
            grammar.put(temp[1], temp[0]);
        }
    }

    LexGrammar(String path) {
        grammar = new HashMap<>(1000);
        grammar.put(" ", "opSpace");
        Scanner input = new Scanner(path);
        String[] temp;
        while (input.hasNextLine()) {
            temp = input.nextLine().split(" ");
            grammar.put(temp[1], temp[0]);
        }
    }

    public boolean contains(String val) {
        return grammar.containsKey(val);
    }

    public String put (String key, String val) {
        return grammar.put(key, val);
    }

    public String get (String key) {
        return grammar.get(key);
    }

    public void print () {
        for (Map.Entry<String, String> entry : grammar.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        LexGrammar lexGrammar = new LexGrammar();
        System.out.println(lexGrammar.get("opTry"));
    }
}
