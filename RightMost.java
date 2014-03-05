import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RightMost {
	public RightMost(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i;
		char ch;

		while ((line = br.readLine()) != null) {
			String[] params = line.split(",");
			ch = params[1].charAt(0);
			
			for (i = params[0].length() - 1; i >= 0; i--) {
				if (params[0].charAt(i) == ch) {
					System.out.println(i);
					break;
				}
			}
			
			if (i == -1) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		RightMost rm = new RightMost(args[0]);
	}
}
