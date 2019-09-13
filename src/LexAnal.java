import java.util.HashMap;

public class LexAnal {
    LexAnal(LexGrammar lexGrammar) {
        this.lexGrammar = lexGrammar;
    }

    private String lexeme;
    private LexGrammar lexGrammar;

    public HashMap<String, String> getToken(String lexeme) {
        HashMap<String, String> token = new HashMap<String, String>();
        String type;

        if (lexGrammar.contains(lexeme)) {          // lexeme is already in grammar
            type = lexGrammar.get(lexeme);
        } else {                                    // lexeme is not in grammar
            try {                                   // lexeme is Integer number
                Integer intLexeme = Integer.parseInt(lexeme);
                type = "num";
            } catch (Exception e) {                 // lexeme is variable name
                type = "var";
                lexGrammar.put(lexeme, type);
            }
        }

        token.put("value", lexeme);
        token.put("type", type);

        return token;
    }

    public LexGrammar getLexGrammar() {
        return this.lexGrammar;
    }
}
