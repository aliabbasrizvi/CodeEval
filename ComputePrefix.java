import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class ComputePrefix {
	private int calculateExpression (String line) {
		int val, operand1, operand2;
		int i;
		String tmp;
		Stack<String> st = new Stack<String>();
		String[] params = line.split("\\s");
		System.out.println("Expression is " + line);
		
		for (i = 0; i < params.length; i++) {
			if (params[i].equals("+") || params[i].equals("*") || params[i].equals("/")) {
				st.push(params[i]);
			} else {
				tmp = st.peek();
				if (tmp.equals("+") || tmp.equals("*") || tmp.equals("/")) {
					st.push(params[i]);
				} else {
					operand1 = Integer.valueOf(st.pop()).intValue();
					operand2 = Integer.valueOf(params[i]).intValue();
					tmp = st.pop();
					if (tmp.equals("+")) {
						val=operand1 + operand2;
						st.push(Integer.toString(val));
					}
					if (tmp.equals("*")) {
						val=operand1 * operand2;
						st.push(Integer.toString(val));
					}
					if (tmp.equals("/")) {
						val=operand1/operand2;
						st.push(Integer.toString(val));
					}
				}
			}
		}
		
		while (st.size() != 1) {
			operand2 = Integer.valueOf(st.pop()).intValue();
			operand1 = Integer.valueOf(st.pop()).intValue();
			tmp = st.pop();
			if (tmp.equals("+")) {
				val=operand1 + operand2;
				st.push(Integer.toString(val));
			}
			if (tmp.equals("*")) {
				val=operand1 * operand2;
				st.push(Integer.toString(val));
			}
			if (tmp.equals("/")) {
				val=operand1/operand2;
				st.push(Integer.toString(val));
			}
		}
		
		val = Integer.valueOf(st.pop()).intValue();
		return val;
	}
	
	public ComputePrefix(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			System.out.println(calculateExpression(line));
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		ComputePrefix cp = new ComputePrefix(args[0]);
	}
}
