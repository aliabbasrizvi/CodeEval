import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class ClimbingStairs {	
	private BigInteger countWays(int n) {
		if (n == 1 || n == 2) {
			return BigInteger.valueOf(n);
		}
		int i;
		BigInteger j = BigInteger.valueOf(3);
		BigInteger k = BigInteger.valueOf(2);
		BigInteger tmp;
		
		for (i = 3; i < n; i++) {
			tmp = j;
			j = j.add(k);
			k = tmp;
		}
		
		return j;
	}

	public ClimbingStairs(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int stairs;
		
		while ((line = br.readLine()) != null) {
			try {
				stairs = Integer.valueOf(line).intValue();
				if (stairs < 1) {
					System.out.println("Not a valid case. Skipping.");
					continue;
				}
				
				System.out.println(countWays(stairs));
			} catch (NumberFormatException e) {
				System.out.println("Not a number. Going to next line.");
				continue;
			}
		}
	}

	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}

		ClimbingStairs cs = new ClimbingStairs(args[0]);
	}
}
