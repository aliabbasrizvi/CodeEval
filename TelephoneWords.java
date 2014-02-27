import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TelephoneWords {
	
	private String digitCharacters(char digit) {
		switch (digit) {
		case '0': return "0".toString();
		case '1': return "1".toString();
		case '2': return "abc".toString();
		case '3': return "def".toString();
		case '4': return "ghi".toString();
		case '5': return "jkl".toString();
		case '6': return "mno".toString();
		case '7': return "pqrs".toString();
		case '8': return "tuv".toString();
		case '9': return "wxyz".toString();
		default : return "Invalid request".toString();
		}
	}
	
	private void printPatterns(String num, int cur, StringBuffer curPattern, int lastWordFlag) {
		int i;
		int len;
		if (curPattern == null) {
			curPattern = new StringBuffer();
		}
		
		if (cur == num.length()) {
			System.out.print(curPattern.toString());
			if (lastWordFlag < num.length()) {
				System.out.print(",");
			}
			return;
		}
		
		String list = digitCharacters(num.charAt(cur));
		len = list.length();
		for (i = 0; i < len; i++) {
			curPattern.append(list.charAt(i));
			if (i == len - 1) {
				printPatterns(num, cur+1,curPattern, lastWordFlag + 1);
			} else {
				printPatterns(num, cur+1,curPattern, lastWordFlag);
			}
			curPattern.deleteCharAt(curPattern.length() - 1);
		}
	}
	
	public TelephoneWords(String filename) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.length() != 7) {
				System.out.println("Unsupported number. Skipping.");
				continue;
			}
			printPatterns(line, 0, null, 0);
			System.out.println();
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		TelephoneWords tw = new TelephoneWords(args[0]);
	}
}
