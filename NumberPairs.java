import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberPairs {
	private void displayPairs(String numberString, int sum) {
		int numPairs = 0;
		int[] numArr;
		int i;
		int frontPointer, backPointer;
		int tmpSum;
		
		String[] num = numberString.split(",");
		numArr = new int[num.length];
		
		for (i = 0; i < num.length; i++) {
			numArr[i] = Integer.parseInt(num[i]);
		}
		
		frontPointer = 0;
		backPointer = num.length - 1;
		
		while (frontPointer < backPointer) {
			tmpSum = numArr[frontPointer] + numArr[backPointer];
			
			if (tmpSum == sum) {
				numPairs++;
				if (numPairs == 1) {
					System.out.print(numArr[frontPointer] + "," + numArr[backPointer]);
				} else {
					System.out.print(";" + numArr[frontPointer] + "," + numArr[backPointer]);
				}
				frontPointer++;
				backPointer--;
			} else if (tmpSum > sum) {
				backPointer--;
			} else {
				frontPointer++;
			}
		}
		
		if (numPairs == 0) {
			System.out.println("NULL");
		} else {
			System.out.println();
		}
	}
	
	public NumberPairs(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split(";");
			displayPairs(params[0], Integer.parseInt(params[1]));
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		NumberPairs np = new NumberPairs(args[0]);
	}
}
