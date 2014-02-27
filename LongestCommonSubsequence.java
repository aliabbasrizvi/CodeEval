import java.io.*;

public class LongestCommonSubsequence {
	int[][] lcsMat;
	
	private void constructLCSMatrix(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int i, j;
		lcsMat = new int[len1 + 1][len2 + 1];
		
		for (i = 1; i <= len1; i++) {
			for (j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lcsMat[i][j] = lcsMat[i-1][j-1] + 1;
				} else {
					if (lcsMat[i-1][j] > lcsMat[i][j-1]) {
						lcsMat[i][j] = lcsMat[i-1][j];
					} else {
						lcsMat[i][j] = lcsMat[i][j-1];
					}
				}
			}
		}
	}
	
	private String computeLCS(String str1, String str2) {
		int i = str1.length();
		int j = str2.length();

		String lcs = "";
		
		if (i == 0 || j == 0) {
			return lcs;
		}
		constructLCSMatrix(str1, str2);
		
		while (lcsMat[i][j] != 0) {
			while(lcsMat[i-1][j] == lcsMat[i][j]) {
				i--;
			}
			while(lcsMat[i][j-1] == lcsMat[i][j]) {
				j--;
			}
			i--;
			j--;
			lcs = str1.charAt(i) + lcs;
		}
		return lcs;
	}
	
	public LongestCommonSubsequence (String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split(";");
			System.out.println(computeLCS(params[0], params[1]));
		}
	}
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence(args[0]);
	}
}
