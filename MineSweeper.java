import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MineSweeper {
	int[][] grid;
	int m, n;
	
	private void prepareGrid(String values) {
		int i, j;
		
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (values.charAt(i*n + j) == '*') {
					grid[i][j] = -1;
				}
			}
		}
	}
	
	private void fillGrid() {
		int i, j;
		for (i = 1; i < m-1; i++) {
			for (j = 1; j < n-1; j++) {
				if (grid[i][j] == -1) {
					if (grid[i-1][j-1] != -1) {
						grid[i-1][j-1]++;
					}
					if (grid[i-1][j] != -1) {
						grid[i-1][j]++;
					}
					if (grid[i-1][j+1] != -1) {
						grid[i-1][j+1]++;
					}
					if (grid[i][j-1] != -1) {
						grid[i][j-1]++;
					}
					if (grid[i][j+1] != -1) {
						grid[i][j+1]++;
					}
					if (grid[i+1][j-1] != -1) {
						grid[i+1][j-1]++;
					}
					if (grid[i+1][j] != -1) {
						grid[i+1][j]++;
					}
					if (grid[i+1][j+1] != -1) {
						grid[i+1][j+1]++;
					}
				}
			}
		}
		
		// First row
		for (j = 0; j < n; j++) {
			if (grid[0][j] == -1) {
				if (j != 0 && grid[0][j-1] != -1) {
					grid[0][j-1]++;
				}
				if (j != 0 && grid[1][j-1] != -1) {
					grid[1][j-1]++;
				}
				if (grid[1][j] != -1) {
					grid[1][j]++;
				}
				if (j != n-1 && grid[0][j+1] != -1) {
					grid[0][j+1]++;
				}
				if (j != n-1 && grid[1][j+1] != -1) {
					grid[1][j+1]++;
				}
			}
		}
		
		// Last row
		for (j = 0; j < n; j++) {
			if (grid[m-1][j] == -1) {
				if (j != 0 && grid[m-1][j-1] != -1) {
					grid[m-1][j-1]++;
				}
				if (j != 0 && grid[m-2][j-1] != -1) {
					grid[m-2][j-1]++;
				}
				if (grid[m-2][j] != -1) {
					grid[m-2][j]++;
				}
				if (j != n-1 && grid[m-2][j+1] != -1) {
					grid[m-2][j+1]++;
				}
				if (j != n-1 && grid[m-1][j+1] != -1) {
					grid[m-1][j+1]++;
				}
			}
		}
		
		// First column
		for (i = 1; i < m-1; i++) {
			if (grid[i][0] == -1) {
				if (grid[i-1][0] != -1) {
					grid[i-1][0]++;
				}
				if (grid[i-1][1] != -1) {
					grid[i-1][1]++;
				}
				if (grid[i][1] != -1) {
					grid[i][1]++;
				}
				if (grid[i+1][1] != -1) {
					grid[i+1][1]++;
				}
				if (grid[i+1][0] != -1) {
					grid[i+1][0]++;
				}
			}
		}
		
		// Last column
		for (i = 1; i < m-1; i++) {
			if (grid[i][n-1] == -1) {
				if (grid[i-1][n-1] != -1) {
					grid[i-1][n-1]++;
				}
				if (grid[i-1][n-2] != -1) {
					grid[i-1][n-2]++;
				}
				if (grid[i][n-2] != -1) {
					grid[i][n-2]++;
				}
				if (grid[i+1][n-2] != -1) {
					grid[i+1][n-2]++;
				}
				if (grid[i+1][n-1] != -1) {
					grid[i+1][n-1]++;
				}
			}
		}
	}
	
	private void displayGrid() {
		int i, j;
		
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (grid[i][j] == -1) {
					System.out.print("*");
				} else {
					System.out.print(grid[i][j]);
				}
			}
		}
		System.out.println();
	}
	
	public MineSweeper(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split(";");
			if (params.length != 2) {
				System.out.println("Insufficient parameters. Skipping line.");
				continue;
			}
			
			String[] dimensions = params[0].split(",");
			if (dimensions.length != 2) {
				System.out.println("Insufficient parameters. Skipping line.");
			}
			
			m = Integer.valueOf(dimensions[0]).intValue();
			n = Integer.valueOf(dimensions[1]).intValue();
			
			grid = new int[m][n];
			
			prepareGrid(params[1]);
			fillGrid();
			displayGrid();
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		MineSweeper ms = new MineSweeper(args[0]);
	}
}
