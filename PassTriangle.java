import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class PassTriangle {
	ArrayList<Integer> triangleNumbers;
	ArrayList<Integer> level;
	HashMap<Integer, Integer> interimValues;
	int len;
	int lastLevel;
	
	public int getMaxSum(int curIndex) {
		int tmpSum1 = 0, tmpSum2 = 0;
		int curLevel = level.get(curIndex);
		
		if (curLevel == lastLevel) {
			return triangleNumbers.get(curIndex);
		}
		
		if (curIndex + curLevel + 1 < len) {
			if (interimValues.get(curIndex + curLevel) != null) {
				tmpSum1 = interimValues.get(curIndex + curLevel); 
			} else {
				tmpSum1 = getMaxSum(curIndex + curLevel);
				interimValues.put(curIndex + curLevel, tmpSum1);
			}
			
			if (interimValues.get(curIndex + curLevel + 1) != null) {
				tmpSum2 = interimValues.get(curIndex + curLevel + 1); 
			} else {
				tmpSum2 = getMaxSum(curIndex + curLevel + 1);
				interimValues.put(curIndex + curLevel + 1, tmpSum2);
			}
		}
		
		if (tmpSum1 > tmpSum2) {
			return (triangleNumbers.get(curIndex) + tmpSum1);
		} else {
			return (triangleNumbers.get(curIndex) + tmpSum2);
		}
	}
	
	public PassTriangle(String filename) throws IOException {
		triangleNumbers = new ArrayList<Integer>();
		level = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int idx;
		int curLevel;
		
		while ((line = br.readLine()) != null) {
			String[] nums = line.split("\\s");
			curLevel = nums.length;
			for (idx = 0; idx < curLevel; idx++) {
				level.add(curLevel);
				triangleNumbers.add(Integer.parseInt(nums[idx]));
			}
		}
		len = level.size();
		lastLevel = level.get(level.size() - 1);
		interimValues = new HashMap<Integer, Integer>();
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unexpected number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		PassTriangle pt = new PassTriangle(args[0]);
		System.out.println(pt.getMaxSum(0));
	}
}
