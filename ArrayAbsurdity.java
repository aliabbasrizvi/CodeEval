import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayAbsurdity {
	int sum;
	int n;
	int expectVal;
	public ArrayAbsurdity(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i;
		while ((line = br.readLine())!= null) {
			String[] params = line.split(";");
			n = Integer.parseInt(params[0]);
			expectVal = n*(n-1)/2;
			sum = 0;
			String[] vals = params[1].split(",");
			for (i = 0; i < n; i++) {
				sum+=Integer.parseInt(vals[i]);
			}
			System.out.println(sum + (n - 1) - expectVal);
		}
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unexpected number of parameters. Exiting.");
			System.exit(1);
		}
		
		ArrayAbsurdity aa = new ArrayAbsurdity(args[0]);
	}
}
