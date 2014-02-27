import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BitCounter {	
	private int totalSetBits(int number) {
		int setBits = 0;
		
		while (number != 0) {
			if (number % 2 == 1) {
				setBits++;
			}
			number = number >> 1;
		}
		return setBits;
	}

	public BitCounter(String filename) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int number;
		
		while ((line = br.readLine()) != null) {
			number = Integer.valueOf(line).intValue();
			System.out.println(totalSetBits(Math.abs(number)));
		}
	}

	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		BitCounter bc = new BitCounter(args[0]);
	}
}