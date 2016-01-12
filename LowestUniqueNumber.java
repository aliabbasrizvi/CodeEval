import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LowestUniqueNumber {
	String filename;
	
	public LowestUniqueNumber(String filename) {
		this.filename = filename;
	}
	
	public void findUnique() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int i;
		
		while ((line = br.readLine()) != null) {
			int[] counts = new int[10];
			int lowestUnique = 0;
			
			String[] nums = line.split("\\s");
			for (i = 0; i < nums.length; i++) {
				counts[Integer.parseInt(nums[i]) - 1]++;
			}			
			
			for (i = 0; i < counts.length; i++) {
				if (counts[i] == 1) {
					lowestUnique = i + 1;
					break;
				}
			}
			
			if (lowestUnique != 0) {
				for (i = 0; i < nums.length; i++) {
					if (lowestUnique == Integer.parseInt(nums[i])) {
						break;
					}
				}
				System.out.println(i+1);
			} else {
				System.out.println(lowestUnique);
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		LowestUniqueNumber lun = new LowestUniqueNumber(args[0]);
		lun.findUnique();
	}
}
