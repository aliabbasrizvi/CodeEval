import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pangrams {	
	public Pangrams(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String str;
		int i;
		int flag;
		char ch;
		char[] pangram = new char[26];		
		
		while ((str = br.readLine()) != null) {
		    for (i = 0; i < 26; i++) {
		        pangram[i] = '0';
		      }   
		      flag = 0;
		      for (i = 0; i < str.length(); i++) {
		        if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
		          pangram[str.charAt(i) - 'a'] = '*';
		        } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
		          pangram[str.charAt(i) - 'A'] = '*';
		        }   
		      }   
		      for (i = 0; i < 26; i++) {
		        if (pangram[i] == '0') {
		          ch = (char) ('a' + i);
		          System.out.print(ch);
		          flag = 1;
		        }   
		      }   
		      if (flag == 0) {
		        System.out.print("NULL");
		      }   
		      System.out.println();
		}
	}
	public static void main (String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Insufficient number of parameters passed. Exiting.");
			System.exit(1);
		}

		Pangrams pg = new Pangrams(args[0]);
	}
}
