import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GenerateRoman {
	
	private String printRomanEquivalent(int number) {
		int dig;
		int idx;
		StringBuffer romanEquivalent = new StringBuffer();
		
		if (number >= 1000) {
			dig = number/1000;
			for (idx = 0; idx < dig; idx++) {
				romanEquivalent.append("M");
			}
			number-=dig*1000;
		}

		if (number >= 900) {
			romanEquivalent.append("CM");
			number-=900;
		}
		
		if (number >= 500) {
			romanEquivalent.append("D");
			number-=500;
		}
		
		if (number >= 400) {
			romanEquivalent.append("CD");
			number-=400;
		}
		
		if (number >= 100) {
			dig = number/100;
			for (idx = 0; idx < dig; idx++) {
				romanEquivalent.append("C");
			}
			number-=dig*100;
		}
		
		if (number >= 90) {
			romanEquivalent.append("XC");
			number-=90;
		}
		
		if (number >= 50) {
			romanEquivalent.append("L");
			number-=50;
		}
		
		if (number >= 40) {
			romanEquivalent.append("XL");
			number-=40;
		}
		
		if (number >= 10) {
			dig = number/10;
			for (idx = 0; idx < dig; idx++) {
				romanEquivalent.append("X");
			}
			number-=dig*10;
		}
		
		if (number == 9) {
			romanEquivalent.append("IX");
			number-=9;
		}
		
		if (number >= 5) {
			romanEquivalent.append("V");
			number-=5;
		}
		
		if (number == 4) {
			romanEquivalent.append("IV");
			number-=4;
		}
		
		if (number >= 1) {
			for (idx = 0; idx < number; idx++) {
				romanEquivalent.append("I");
			}
			number-=number;
		}
		
		return romanEquivalent.toString();
	}
	
	public GenerateRoman(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int number;
		
		while ((line = br.readLine()) != null) {
			number = Integer.valueOf(line).intValue();
			if (number > 0 && number < 4000) {
				System.out.println(printRomanEquivalent(number));
			} else {
				System.out.println("Unsupported number.");
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		GenerateRoman genRom = new GenerateRoman(args[0]);
	}
}
