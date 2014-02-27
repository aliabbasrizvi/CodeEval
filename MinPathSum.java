import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MinPathSum {
	int n;
	int[][] matrix;
	
	private int computeMinSum(int curX, int curY) {
		int sum1, sum2;
		if (curX == n - 1 && curY == n - 1) {
			return matrix[curX][curY];
		} else if (curX == n - 1) {
			return (matrix[curX][curY] + computeMinSum(curX, curY + 1));
		} else if (curY == n - 1) {
			return (matrix[curX][curY] + computeMinSum(curX + 1, curY));
		} else {
			sum1 = computeMinSum(curX + 1, curY);
			sum2 = computeMinSum(curX, curY + 1);
			if (sum1 < sum2) {
				return (matrix[curX][curY] + sum1);
			} else {
				return (matrix[curX][curY] + sum2);
			}
		}
	}
	
	public MinPathSum (String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		String matRow;
		String[] params;
		int i, j;
		
		while ((line = br.readLine()) != null) {
			n = Integer.valueOf(line).intValue();
			matrix = new int[n][n];
			
			for (i = 0; i < n; i++) {
				matRow = br.readLine();
				params = matRow.split(",");
				for (j = 0; j < n; j++) {
					matrix[i][j] = Integer.valueOf(params[j]).intValue();
				}
			}
			
			System.out.println(computeMinSum(0, 0));
		}		
	}
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		MinPathSum mps = new MinPathSum(args[0]);
	}
}
