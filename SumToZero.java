import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SumToZero {
	String filename;
	int numbersRequired; 
	
	public SumToZero (String filename) {
		this.filename = filename;
		numbersRequired = 4;
	}
	
	public int getCount (int[] arr, int sum, int numbersSeen, int curNumber) {
		if (numbersSeen == numbersRequired && sum == 0) {
			return 1;
		}
		
		if (numbersSeen == numbersRequired || curNumber == arr.length) {
			return 0;
		}
		
		return (getCount(arr, sum, numbersSeen, curNumber + 1) + 
				getCount(arr, sum - arr[curNumber], numbersSeen + 1, curNumber + 1));
	}
	
	public void parseFile () throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i;
		
		while((line = br.readLine()) != null) {
			String[] values = line.split(",");
			int[] numbers = new int[values.length];
			for (i = 0; i < values.length; i++) {
				numbers[i] = Integer.parseInt(values[i]);
			}
			
			System.out.println(getCount(numbers, 0, 0, 0));
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters. Exiting.");
			System.exit(1);
		}
		
		SumToZero stz = new SumToZero(args[0]);
		stz.parseFile();
	}
}
