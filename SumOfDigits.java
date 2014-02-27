import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SumOfDigits {
	
	private int computeSum(int num) {
		int sum=0;
		int digit;
		
		while(num != 0) {
			digit = num%10;
			sum+=digit;
			num/=10;
		}
		return sum;
	}
	
	public SumOfDigits(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int number;
		
		while ((line = br.readLine()) != null) {
			number = Integer.valueOf(line).intValue();
			System.out.println(computeSum(number));
		}
	}
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		SumOfDigits sod = new SumOfDigits(args[0]);
	}
}
