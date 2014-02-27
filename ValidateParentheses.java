import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;


public class ValidateParentheses {
	public ValidateParentheses(String filename) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int idx;
		int invalidFlag;
		char ch, peekchar;
		Stack<Character> parenthesesStack = new Stack<Character>();
		
		while ((line = br.readLine()) != null) {
			line = line.trim();
			invalidFlag = 0;
			for (idx = 0; idx < line.length(); idx++) {
				ch = line.charAt(idx);
				if (ch == '(' || ch == '{' || ch == '[') {
					parenthesesStack.push(ch);
				} else if (ch == ')' || ch == '}' || ch == ']') {
					if (!parenthesesStack.empty()) {
						peekchar = parenthesesStack.peek();
					} else {
						invalidFlag = 1;
						break;
					}
					if (ch == ')' && peekchar == '(') {
						parenthesesStack.pop();
					} else if (ch == '}' && peekchar == '{') {
						parenthesesStack.pop();
					} else if (ch == ']' && peekchar == '[') {
						parenthesesStack.pop();
					} else {
						invalidFlag = 1;
						break;
					}
				} else {
					invalidFlag = 1;
					break;
				}
			}
			if (invalidFlag == 1 || !parenthesesStack.empty()) {
				System.out.println("False");
				parenthesesStack.clear();
			} else {
				System.out.println("True");
			}
		}
	}

	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		ValidateParentheses vp = new ValidateParentheses(args[0]);
	}
}
