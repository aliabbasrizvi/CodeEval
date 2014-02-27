public class RobotMovements {
	int m, n;
	int[][] grid;

	public int computeMovements(int[][] mat, int curX, int curY) {
		int l, r, u, d;
		if (curX == m - 1 && curY == n - 1) {
			return 1;
		}
		
		l = 0; r = 0; u = 0; d = 0;
		if (curX + 1 < m && mat[curX+1][curY] != 1) {
			mat[curX+1][curY] = 1;
			d = computeMovements(mat, curX + 1, curY);
			mat[curX+1][curY] = 0;
		}
		if (curY + 1 < n && mat[curX][curY+1] != 1) {
			mat[curX][curY+1] = 1;
			r = computeMovements(mat, curX, curY + 1);
			mat[curX][curY+1] = 0;
		}
		if (curX - 1 >= 0 && mat[curX-1][curY] != 1) {
			mat[curX-1][curY] = 1;
			u = computeMovements(mat, curX - 1, curY);
			mat[curX-1][curY] = 0;
		} 
		if (curY - 1 >= 0 && mat[curX][curY-1] != 1) {
			mat[curX][curY-1] = 1;
			l = computeMovements(mat, curX, curY - 1);
			mat[curX][curY-1] = 0;
		}
		
		return (l+r+u+d);
	}

	public RobotMovements (int row, int col) {
		m = row;
		n = col;
		grid = new int[m][n];
		grid[0][0] = 1;
	}

	public int[][] getGrid() {
		return grid;
	}

	public static void main(String[] args) {
		RobotMovements rm = new RobotMovements(4,4);
		System.out.println(rm.computeMovements(rm.getGrid(),0,0));
	}
}
