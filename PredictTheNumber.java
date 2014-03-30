import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PredictTheNumber {
	String filename;
	
	public PredictTheNumber (String filename) {
		this.filename = filename;
	}
	
	private int findTransformOperations (long index) {
		if (index == 0) {
			return 0;
		}
		
		int count = (int) Math.floor(Math.log((double)index)/Math.log(2));
		return (1 + findTransformOperations((long) (index - Math.pow(2, count))));
	}
	
	public int predictNumber (long index) {
		if (index == 0) {
			return 0;
		}
			
		int changeCount = findTransformOperations(index);
		
		return ((changeCount)%3);
	}
	
	public void parseFile () throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			System.out.println(predictNumber(Long.parseLong(line)));
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		PredictTheNumber ptn = new PredictTheNumber(args[0]);
		ptn.parseFile();
	}
}
