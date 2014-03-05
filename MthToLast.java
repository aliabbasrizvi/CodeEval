import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ElementList {
	char ch;
	ElementList next;

	public ElementList() {
		next = null;
	}
	
	public char getMthToLast(int m) {
		ElementList tmpNode = this;
		ElementList mthLastNode;
		int i = 0;
		while (i < m) {
			tmpNode = tmpNode.next;
			i++;
		}
		mthLastNode = this;
		while (tmpNode != null) {
			mthLastNode = mthLastNode.next;
			tmpNode = tmpNode.next;
		}
		
		return mthLastNode.ch;
	}

	public void createList(String str) {
		int i;
		ElementList tmpNode = this;
		ElementList newNode;
		tmpNode.ch = str.charAt(0);
		for (i = 1; i < str.length(); i++) {
			newNode = new ElementList();
			newNode.ch = str.charAt(i);
			tmpNode.next = newNode;
			tmpNode = tmpNode.next;
		}
	}
}

public class MthToLast {
	int m;
	
	public MthToLast(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		ElementList el;
		StringBuffer str = new StringBuffer();
		int i;
		
		while ((line = br.readLine()) != null) {
			String[] params = line.split("\\s");
			m = Integer.parseInt(params[params.length - 1]);
			if (m > params.length - 1 || m <= 0) {
				continue;
			}
			el = new ElementList();
			for (i = 0; i < params.length - 1; i++) {
				str.append(params[i]);
			}
			el.createList(str.toString());
			System.out.println(el.getMthToLast(m));
		}
	}
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters. Exiting.");
			System.exit(1);
		}
		
		MthToLast mtl = new MthToLast(args[0]);
	}
}
