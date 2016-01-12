import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MultiplyLists {
	int[] prod;
	String filename;
	
	public MultiplyLists(String filename) {
		this.filename = filename;
	}
	
	public void parseData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] lists = line.split("\\|");
			String[] l1 = lists[0].split("\\s");
			String[] l2 = lists[1].split("\\s");
			prod = new int[l1.length];
			
			for (int i = 0; i < l1.length; i++) {
				prod[i] = Integer.parseInt(l1[i]) * Integer.parseInt(l2[i+1]);
			}
			
			for (int i = 0; i < prod.length; i++) {
				System.out.print(prod[i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		MultiplyLists ml = new MultiplyLists(args[0]);
		ml.parseData();
	}
}
