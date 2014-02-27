import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SplittedNumber {
	private int computeNumber(int num1, int num2, char operator) {
		if (operator == '+') {
			return (num1 + num2);
		} else {
			return (num1 - num2);
		}
	}
	
	public SplittedNumber(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int num1, num2;
		char operator;
		
		while ((line = br.readLine()) != null) {
			String[] args = line.split("\\s");
			String[] params = args[1].split("\\+|-");
			
			num1 = Integer.parseInt(args[0].substring(0, params[0].length()));
			num2 = Integer.parseInt(args[0].substring(params[0].length()));
			
			operator = args[1].charAt(params[0].length());
			System.out.println(computeNumber(num1, num2, operator));
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		SplittedNumber sn = new SplittedNumber(args[0]);
	}
}
