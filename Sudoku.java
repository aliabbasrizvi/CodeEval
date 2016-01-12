import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Sudoku {
	int[][] sudokuBoard;
	int n;
	String filename;
	
	public Sudoku(String filename) {
		this.filename = filename;
	}
	
	public void buildSudoku(String nums) {
		String[] numbers = nums.split(",");
		for (int i = 0; i < numbers.length; i++) {
			sudokuBoard[i/n][i%n] = Integer.parseInt(numbers[i]);
		}
	}
	
	public void isValidSolution() {
		int targetSum = (int) (Math.pow(2, n+1) - 2);
		for (int i = 0; i < n; i++) {
			int sumR = 0;
			int sumC = 0;
			for (int j = 0; j < n; j++) {
				sumR+=Math.pow(2, sudokuBoard[i][j]);
				sumC+=Math.pow(2, sudokuBoard[j][i]);
			}
			
			if (sumR != targetSum) {
				System.out.println("False");
				return;
			}

			if (sumC != targetSum) {
				System.out.println("False");
				return;
			}
		}
		
		int blockSize = (int) Math.sqrt(n);
		for (int i = 0; i < n; i+=blockSize) {
			for (int j = 0; j < n; j+=blockSize) {
				int sum = 0;
				for (int x = i; x < i + blockSize; x++) {
					for (int y = j; y < j + blockSize; y++) {
						sum+=Math.pow(2, sudokuBoard[x][y]);
					}
				}
				
				if (sum != targetSum) {
					System.out.println("False");
					return;
				}
			}
		}
		
		System.out.println("True");
	}
	
	public void verifySudoku() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split(";");
			n = Integer.parseInt(params[0]);
			sudokuBoard = new int[n][n];
			buildSudoku(params[1]);
			isValidSolution();
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}	
		
		Sudoku s = new Sudoku(args[0]);
		s.verifySudoku();
	}
}
