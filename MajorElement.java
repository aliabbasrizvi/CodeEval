import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MajorElement {
	String filename;
	int[] elements;
	
	public MajorElement (String filename) {
		this.filename = filename;
	}
	
	public boolean isMajor (int majorContender) {
		int count = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == majorContender) {
				count++;
			}
		}
		
		if (count > elements.length/2) {
			return true;
		}
		return false;
	}
	
	public void parseFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i;
		int curMajor;
		int majorCount;
		
		while ((line = br.readLine()) != null) {
			String[] vals = line.split(",");
			if (vals.length == 0) {
				continue;
			}
			elements = new int[vals.length];
			elements[0] = Integer.parseInt(vals[0]);
			curMajor = elements[0];
			majorCount = 1;
			for (i = 1; i < vals.length; i++) {
				elements[i] = Integer.parseInt(vals[i]);
				
				if (elements[i] == curMajor) {
					majorCount++;
				} else {
					majorCount--;
				}
				
				if (majorCount == -1) {
					curMajor = elements[i];
					majorCount = 1;
				}
			}
			
			if (isMajor(curMajor)) {
				System.out.println(curMajor);
			} else {
				System.out.println("None");
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		MajorElement me = new MajorElement(args[0]);
		me.parseFile();
	}
}
