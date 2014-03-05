import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BitPositions {
	public BitPositions(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int num;
		int bitPos1, bitPos2;
		int num1, num2;

		while ((line = br.readLine()) != null) {
			String[] params = line.split(",");
			num = Integer.parseInt(params[0]);
			bitPos1 = Integer.parseInt(params[1]);
			bitPos2 = Integer.parseInt(params[2]);
			if (bitPos1 == bitPos2) {
				System.out.println("true");
				continue;
			}
			
			num1 = 1;
			num2 = 1;
			
			num1 = num1 << (bitPos1 - 1);
			num2 = num2 << (bitPos2 - 1);
			num1 = num1 & num;
			num2 = num2 & num;
			num1 = num1 >> (bitPos1 - 1);
			num2 = num2 >> (bitPos2 - 1);
			System.out.println((num1 == num2));
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		BitPositions bp = new BitPositions(args[0]);
	}
}
