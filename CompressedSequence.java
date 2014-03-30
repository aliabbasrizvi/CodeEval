import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompressedSequence {
	int[] numberArray;
	
	public void generateCompressedSequence() {
		int curNumber;
		int curCount;
		int i;
		
		curNumber = numberArray[0];
		curCount = 1;
		
		for (i = 1; i < numberArray.length; i++) {
			if (curNumber == numberArray[i]) {
				curCount++;
			} else {
				System.out.print(curCount + " " + curNumber + " ");
				curCount = 1;
				curNumber = numberArray[i];
			}
		}
		
		System.out.println(curCount + " " + curNumber);
	}
	
	public CompressedSequence(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i;
		
		while ((line = br.readLine()) != null) {
			String[] numbers = line.split("\\s");
			numberArray = new int[numbers.length];
			for (i = 0; i < numbers.length; i++) {
				numberArray[i] = Integer.parseInt(numbers[i]);
			}
			generateCompressedSequence();
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters. Exiting.");
			System.exit(1);
		}
		
		CompressedSequence cs = new CompressedSequence(args[0]);
	}
}
