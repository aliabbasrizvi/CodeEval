import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;


public class CashRegister {
	String filename;
	LinkedHashMap<String, Float> values;
	
	public CashRegister(String filename) {
		this.filename = filename;
		values = new LinkedHashMap<String, Float>();
		values.put("ONE HUNDRED", (float) 100.00); values.put("FIFTY", (float) 50.00);
		values.put("TWENTY", (float) 20.00); values.put("TEN", (float) 10.00);
		values.put("FIVE", (float) 5.00); values.put("TWO", (float) 2.00);
		values.put("ONE", (float) 1.00); values.put("HALF DOLLAR", (float) 0.50);
		values.put("QUARTER", (float) 0.25); values.put("DIME", (float) 0.10);
		values.put("NICKEL", (float) 0.05); values.put("PENNY", (float) 0.01);
	}
	
	private String currencyOrder(float difference) {
		StringBuffer order = new StringBuffer();
		difference = (float) (Math.round(difference*100)/100.00);
		for (String currency : values.keySet()) {
			while (difference >= Math.round(values.get(currency) * 100)/100.00) {
				order.append("," + currency);
				difference -= values.get(currency);
			}
		}
		return order.substring(1).toString();
	}
	
	public void findChange() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while ((line = br.readLine()) != null) {
			float purchasePrice;
			float cash;
			
			String[] vals = line.split(";");
			purchasePrice = Float.parseFloat(vals[0]);
			cash = Float.parseFloat(vals[1]);
			
			if (purchasePrice > cash) {
				System.out.println("ERROR");
			} else if (purchasePrice == cash) {
				System.out.println("ZERO");
			} else {
				System.out.println(currencyOrder(cash - purchasePrice));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Unsupported number of parameters passed. Exiting.");
			System.exit(1);
		}
		
		CashRegister cr = new CashRegister(args[0]);
		cr.findChange();
	}
}
