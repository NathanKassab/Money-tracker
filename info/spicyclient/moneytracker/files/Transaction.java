package info.spicyclient.moneytracker.files;

import java.math.BigDecimal;

public class Transaction {
	
	public Transaction(BigDecimal amount) {
		this.amount = amount;
		date = System.currentTimeMillis();
	}
	
	public int version = 0;
	
	public long date;
	public BigDecimal amount;
	
}
