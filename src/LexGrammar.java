import java.util.HashMap;
import java.util.Scanner;

public class LexGrammar {
    HashMap<String, String> grammar;

    LexGrammar(String path) {
        grammar = new HashMap<>(300);
        Scanner input = new Scanner(path);
        String[] temp;
        while (input.hasNextLine()) {
            temp = input.nextLine().split(" ");
            grammar.put(temp[0], temp[1]);
        }
    }

    public boolean contains(String key, String val) {
        return grammar.get(key).equals(val);
    }

    public String put (String key, String val) {
        return grammar.put(key, val);
    }

    public String putIfAbsent (String key, String val) {
        return grammar.putIfAbsent(key, val);
    }
}