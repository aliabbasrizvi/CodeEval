import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DecodeNumbers {
	String filename;
	
	public DecodeNumbers (String filename) {
		this.filename = filename;
	}
	
	private int countDecodeWays(String number, int start) {
		if (start == number.length() - 1 && number.charAt(start) != '0') {
			return 1;
		} 
		
		if ((number.charAt(start) == '1' || number.charAt(start) == '2') && 
		  (start + 1) < number.length() && number.charAt(start + 1) >= '0' && number.charAt(start + 1) <= '6') {
			return(1 + countDecodeWays(number, start + 1));
		} else {
			return countDecodeWays(number, start + 1);
		}		
	}
	
	public void parseFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			System.out.println(countDecodeWays(line, 0));
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters. Exiting.");
			System.exit(1);
		}
		
	    DecodeNumbers dn = new DecodeNumbers(args[0]);
	    dn.parseFile();
	}
}
