import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FizzBuzz {
	String filename;
	
	public FizzBuzz (String filename) {
		this.filename = filename;
	}
	
	private void printSeries (int fizzNumber, int buzzNumber, int limit) {
		for (int i = 1; i <= limit; i++) {
			if (i % fizzNumber == 0 && i % buzzNumber == 0) {
				System.out.print("FB");
			} else if (i % fizzNumber == 0) {
				System.out.print("F");
			} else if (i % buzzNumber == 0) {
				System.out.print("B");
			} else {
				System.out.print(i);
			}
			
			if (i != limit) {
				System.out.print(" ");
			}
		}
		
		System.out.println();
	}
	
	public void parseFile () throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\s");
			printSeries(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters. Exiting.");
			System.exit(1);
		}
		
		FizzBuzz fb = new FizzBuzz(args[0]);
		fb.parseFile();
	}
}
