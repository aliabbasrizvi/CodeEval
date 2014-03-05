import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CharList {
	char ch;
	CharList next;
	CharList firstNode;

	public CharList() {
		next = null;
	}

	public void createList(String str) {
		int i;
		CharList tmpNode = this;
		CharList newNode;

		tmpNode.ch = str.charAt(0);
		for (i = 1; i < str.length(); i++) {
			newNode = new CharList();
			newNode.ch = str.charAt(i);
			tmpNode.next = newNode;
			tmpNode = tmpNode.next;
		}
	}

	public void removeChar(String delStr) {
		int i;
		CharList tmpNode;
		CharList prevNode;
		firstNode = this;
		
		for (i = 0; i < delStr.length(); i++) {
			tmpNode = firstNode;
			prevNode = firstNode;
			while (tmpNode != null && tmpNode.ch == delStr.charAt(i)) {
				prevNode = tmpNode;
				tmpNode = tmpNode.next;
			}
			firstNode = tmpNode;
			if (tmpNode == null) {
				continue;
			}
			while (tmpNode != null) {
				if (tmpNode.ch == delStr.charAt(i)) {
					prevNode.next = tmpNode.next;
				} else {
					prevNode = tmpNode;
				}
				tmpNode = tmpNode.next;
			}
		}
	}

	public String getList() {
		CharList tmpNode = this;
		StringBuffer sb = new StringBuffer();
		while (tmpNode != firstNode) {
			tmpNode = tmpNode.next;
		}
		while (tmpNode != null) {
			sb.append(tmpNode.ch);
			tmpNode =  tmpNode.next;
		}
		return sb.toString();
	}
}

public class RemoveCharacters {
	public String deleteCharacters(String str, String delChar) {
		CharList cl = new CharList();
		cl.createList(str);
		cl.removeChar(delChar);
		return cl.getList();
	}

	public RemoveCharacters(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;

		while ((line = br.readLine()) != null) {
			String[] params = line.split(",\\s");
			System.out.println(deleteCharacters(params[0], params[1]).trim().replaceAll("( )+", " "));
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		RemoveCharacters rc = new RemoveCharacters(args[0]);
	}
}
