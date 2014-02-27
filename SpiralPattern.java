import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SpiralPattern {
	int m,n;
	String[][] arr;

	private void displayPattern() {
		int l = 0, r = m-1, t = 0, b = n-1;
		int valuesRemaining = m*n;
		int i;

		while(valuesRemaining != 0) {
			for (i = l; i <= r && valuesRemaining != 0; i++) {
				valuesRemaining--;
				System.out.print(arr[t][i] + " ");
			}
			for (i = t+1; i <= b && valuesRemaining != 0; i++) {
				valuesRemaining--;
				System.out.print(arr[i][r] + " ");
			}
			for (i = r-1; i >= l && valuesRemaining != 0; i--) {
				valuesRemaining--;
				System.out.print(arr[b][i] + " ");
			}
			for (i = b-1; i > t && valuesRemaining != 0; i--) {
				valuesRemaining--;
				System.out.print(arr[i][l] + " ");
			}

			l++;
			t++;
			r--;
			b--;
		}
		System.out.println();
	}

	public SpiralPattern(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i, j, flag = 0;

		while ((line = br.readLine()) != null) {
			String[] params = line.split(";");
			if (params.length != 3) {
				System.out.println("Insufficient parameter. Skipping line.");
				continue;
			}
			flag = 0;
			try {
				n = Integer.valueOf(params[0]).intValue();
				m = Integer.valueOf(params[1]).intValue();
			} catch (NumberFormatException e) {
				e.printStackTrace();
				continue;
			}

			if (n < 1 || m < 1) {
				continue;
			}

			arr = new String[n][m];
			String[] arrayVals = params[2].split("\\s");
			if (arrayVals.length < m*n) {
				System.out.println("Insufficient parameter. Skipping line.");
				continue;
			}
			for (i = 0; i < n && flag == 0; i++) {
				for (j = 0; j < m && flag == 0; j++) {
					arr[i][j] = arrayVals[i*m+j];
				}
			}
			displayPattern();
		}

	}

	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}

		SpiralPattern vp = new SpiralPattern(args[0]);
	}
}
