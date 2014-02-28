import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextToNumber {
	String file;
	HashMap<String, Integer> vals;
	
	public TextToNumber (String filename) {
		file = filename;
		vals = new HashMap<String, Integer>();
		vals.put("zero", 0);vals.put("one", 1);vals.put("two", 2);vals.put("three", 3);
		vals.put("four", 4);vals.put("five", 5);vals.put("six", 6);vals.put("seven", 7);
		vals.put("eight", 8);vals.put("nine", 9);vals.put("ten", 10);vals.put("eleven", 11);
		vals.put("twelve", 12);vals.put("thirteen", 13);vals.put("fourteen", 14);vals.put("fifteen", 15);
		vals.put("sixteen", 16);vals.put("seventeen", 17);vals.put("eighteen", 18);vals.put("nineteen", 19);
		vals.put("twenty", 20);vals.put("thirty", 30);vals.put("forty", 40);vals.put("fifty", 50);
		vals.put("sixty", 60);vals.put("seventy", 70);vals.put("eighty", 80);vals.put("ninety", 90);
		vals.put("hundred", 100);vals.put("thousand", 1000);vals.put("million", 1000000);
	}
	
	public void computeValues() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int val;
		int idx;
		int tmpVal;
		int prevVal;
		boolean negativeFlag;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\s");
			negativeFlag = false;
			idx = 0;
			val = 0;
			prevVal = 0;
			if (params[0].equals("negative")) {
				negativeFlag = true;
				idx = 1;
			}
			
			while (idx < params.length) {
				tmpVal = vals.get(params[idx]);
				if (tmpVal == 1000 || tmpVal == 1000000) {
					val+=prevVal*tmpVal;
					prevVal = 0;
				} else if (tmpVal == 100) {
					prevVal=prevVal*tmpVal;
				} else {
					prevVal+=tmpVal;
				}
				idx++;
			}
			
			val+=prevVal;
			if (negativeFlag) {
				val=-val;
			}
			System.out.println(val);
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		TextToNumber ttn = new TextToNumber(args[0]);
		ttn.computeValues();
	}
}
