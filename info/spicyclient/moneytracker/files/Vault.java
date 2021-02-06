package info.spicyclient.moneytracker.files;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Vault {
	
	public int version = 1;
	
	// Removed in version 1
	//public ArrayList<Transaction> transactionHistory = new ArrayList<>();
	
	public BigDecimal balance = new BigDecimal(0);
	
}
