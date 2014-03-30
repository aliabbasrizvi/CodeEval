import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Coordinates {
	float x;
	float y;
	
	public float squareDistance (Coordinates p) {
		return (float) (Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
	}
	
	public void setValues (String coordinates) {
		String[] vals = coordinates.split(",");
		x = Float.parseFloat(vals[0].substring(1));
		y = Float.parseFloat(vals[1].substring(0, vals[1].length() - 1));
	}
}

public class FindSquare {
	Coordinates[] p;
	
	public boolean isSquare() {
		float[] dist = new float[6];
		float diagDist;
		float side;
		int diagDistCount = 0;
		int sideCount = 0;
		
		dist[0] = p[0].squareDistance(p[1]);
		dist[1] = p[0].squareDistance(p[2]);
		
		if (dist[0] == dist[1]) {
			sideCount+=2;
			side = dist[0];
			diagDist = 2 * side;
		} else if (dist[0] == 2 * dist[1]) {
			diagDistCount++;
			diagDist = dist[0];
			side = dist[1];
			sideCount++;
		} else if (dist[1] == 2 * dist[0]) {
			diagDistCount++;
			diagDist = dist[1];
			side = dist[0];
			sideCount++;
		} else {
			return false;
		}
		
		dist[2] = p[0].squareDistance(p[3]);
		if (dist[2] == side) {
			sideCount++;
		} else if (dist[2] == diagDist) {
			diagDistCount++;
		} else {
			return false;
		}
		
		dist[3] = p[1].squareDistance(p[2]);
		if (dist[3] == side) {
			sideCount++;
		} else if (dist[3] == diagDist) {
			diagDistCount++;
		} else {
			return false;
		}

		dist[4] = p[1].squareDistance(p[3]);
		if (dist[4] == side) {
			sideCount++;
		} else if (dist[4] == diagDist) {
			diagDistCount++;
		} else {
			return false;
		}
		
		dist[5] = p[2].squareDistance(p[3]);
		if (dist[5] == side) {
			sideCount++;
		} else if (dist[5] == diagDist) {
			diagDistCount++;
		} else {
			return false;
		}
		
		if (diagDistCount == 2 && sideCount == 4) {
			return true;
		}
				
		return false;
	}
	
	public FindSquare (String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i;
		
		while ((line = br.readLine()) != null) {
			p = new Coordinates[4];
			String[] params = line.split(",\\s");
			for (i = 0; i < 4; i++) {
				p[i] = new Coordinates();
				p[i].setValues(params[i]);
			}
			
			System.out.println(isSquare());
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters. Exiting.");
			System.exit(1);
		}
		
		FindSquare fs = new FindSquare(args[0]);
	}
}
