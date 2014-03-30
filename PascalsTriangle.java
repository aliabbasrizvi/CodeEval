import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class PascalsTriangle {
	String filename;
	HashMap<Integer, Long> factorialMap;
	
	private long computeFactorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
		if (factorialMap.get(n) != null) {
			return factorialMap.get(n);
		} else {
			factorialMap.put(n, n * computeFactorial(n - 1));
			return factorialMap.get(n);
		}
	}
	
	private long nCr(int n, int r) {
		return (computeFactorial(n)/(computeFactorial(r) * computeFactorial(n - r)));
	}

	public void generateTriangle() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int n;
		
		while ((line = br.readLine()) != null) {
			n = Integer.parseInt(line);
			StringBuilder pascalTriangle = new StringBuilder();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					pascalTriangle.append(nCr(i, j) + " ");
				}
			}
			
			System.out.println(pascalTriangle);
		}
	}
	
	public PascalsTriangle(String filename) {
		this.filename = filename;
		factorialMap = new HashMap<Integer, Long>();
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters. Exiting.");
			System.exit(1);
		}
		
		PascalsTriangle pt = new PascalsTriangle(args[0]);
		pt.generateTriangle();
	}
}
