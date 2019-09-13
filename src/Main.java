import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        LexParser lexParser = new LexParser("input.txt");
        LexGrammar lexGrammar = new LexGrammar();
        LexAnal lexAnal = new LexAnal(lexGrammar);

        HashMap token;
        String lexeme;

        while (true) {
            lexeme = lexParser.getLexeme();
            if (lexeme.equals(""))
                break;
            else {
                token = lexAnal.getToken(lexeme);

                System.out.print("'" + lexeme + "' -> ");
                System.out.println(token.toString());
            }
        }
    }
}
