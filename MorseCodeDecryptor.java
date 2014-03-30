import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MorseCodeDecryptor {
    String filename;
    HashMap<String, Character> morseToChar;

    public MorseCodeDecryptor (String filename) {
        this.filename = filename;
        morseToChar = new HashMap<String, Character>();
        morseToChar.put(".-", 'A');morseToChar.put("-...", 'B');morseToChar.put("-.-.", 'C');morseToChar.put("-..", 'D');
        morseToChar.put(".", 'E');morseToChar.put("..-.", 'F');morseToChar.put("--.", 'G');morseToChar.put("....", 'H');
        morseToChar.put("..", 'I');morseToChar.put(".---", 'J');morseToChar.put("-.-", 'K');morseToChar.put(".-..", 'L');
        morseToChar.put("--", 'M');morseToChar.put("-.", 'N');morseToChar.put("---", 'O');morseToChar.put(".--.", 'P');
        morseToChar.put("--.-", 'Q');morseToChar.put(".-.", 'R');morseToChar.put("...", 'S');morseToChar.put("-", 'T');
        morseToChar.put("..-", 'U');morseToChar.put("...-", 'V');morseToChar.put(".--", 'W');morseToChar.put("-..-", 'X');
        morseToChar.put("-.--", 'Y');morseToChar.put("--..", 'Z');
        morseToChar.put("-----", '0');morseToChar.put(".----", '1');morseToChar.put("..---", '2');morseToChar.put("...--", '3');
        morseToChar.put("....-", '4');morseToChar.put(".....", '5');morseToChar.put("-....", '6');morseToChar.put("--...", '7');
        morseToChar.put("---..", '8');morseToChar.put("----.", '9');
    }

    public void displayText (String word) {
        int i;
        String[] chars = word.split(" ");

        for (i = 0; i < chars.length; i++) {
            System.out.print(morseToChar.get(chars[i]));
        }
        System.out.print(" ");
    }

    public void parseFile () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        int i;

        while ((line = br.readLine()) != null) {
            String[] words = line.split("  ");
            for (i = 0; i < words.length; i++) {
                displayText(words[i]);
            }
            System.out.println();
        }
    }
    public static void main (String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Unsupported number of parameters. Exiting.");
            System.exit(1);
        }
        MorseCodeDecryptor mcd = new MorseCodeDecryptor(args[0]);
        mcd.parseFile();
    }
}
