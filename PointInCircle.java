import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PointInCircle {
	double circleX, circleY;
	double pointX, pointY;
	double rad;
	
	public PointInCircle(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;

		while ((line = br.readLine()) != null) {
			System.out.println(isPointInCircle(line));
		}
	}
	
	private double computeDistance() {
		return (Math.sqrt(Math.pow((circleX - pointX), 2) + Math.pow((circleY - pointY), 2)));
	}
	
	private boolean isPointInCircle(String line) {
		String[] params = line.split(";\\s");
		String[] args;
		
		args = params[0].split("\\s");
		args[1] = args[1].substring(1, args[1].length() - 1);
		args[2] = args[2].substring(0, args[2].length() - 1);
		circleX = Double.valueOf(args[1]).doubleValue();
		circleY = Double.valueOf(args[2]).doubleValue();
		
		args = params[2].split("\\s");
		args[1] = args[1].substring(1, args[1].length() - 1);
		args[2] = args[2].substring(0, args[2].length() - 1);
		pointX = Double.valueOf(args[1]).doubleValue();
		pointY = Double.valueOf(args[2]).doubleValue();

		
		args = params[1].split("\\s");
		rad = Double.valueOf(args[1]).doubleValue();
		
		if (rad > computeDistance()) { 
			return true;
		} else { 
			return false;
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}

		PointInCircle pic = new PointInCircle(args[0]);
	}
}
