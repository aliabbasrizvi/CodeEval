import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LargestSum {
	int[] array;
	int numElements;

	private int maxSubsequenceSum() {
		int i;
		int maxSum;
		int tmpSum;
		
		maxSum = array[0];
		tmpSum = array[0];
		
		for (i = 1; i < numElements; i++) {
			if (tmpSum + array[i] > array[i]) {
				tmpSum+=array[i];
			} else {
				tmpSum = array[i];
			}
			
			if (tmpSum > maxSum) {
				maxSum = tmpSum;
			}
		}
		
		return maxSum;
	}

	public LargestSum(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i;

		while((line = br.readLine()) != null) {
			String[] numbers = line.split(",");
			numElements = numbers.length;
			array = new int[numElements];

			for (i = 0; i < numElements; i++) {
				array[i] = Integer.valueOf(numbers[i]).intValue();
			}

			System.out.println(maxSubsequenceSum());
		}
	}

	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}

		LargestSum ls = new LargestSum(args[0]);
	}
}
