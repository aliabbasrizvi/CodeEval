import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringRotation {
	int[] array;
	int numElements;

	private String isRotation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return "False";
		}
	
		String concatenatedString = str2 + str2;

		if (concatenatedString.contains(str1)) {
			return "True";	
		} else {
			return "False";
		}
	}

	public StringRotation(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;

		while ((line = br.readLine()) != null) {
			String[] vals = line.split(",");
			System.out.println(isRotation(vals[0], vals[1]));
		}
	}

	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}

		StringRotation sr = new StringRotation(args[0]);
	}
}
