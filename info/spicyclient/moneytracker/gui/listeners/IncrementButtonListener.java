package info.spicyclient.moneytracker.gui.listeners;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.Action;

import info.spicyclient.moneytracker.App;
import info.spicyclient.moneytracker.files.Transaction;
import info.spicyclient.moneytracker.utils.FileUtils;

public class IncrementButtonListener implements Action {
	
	public IncrementButtonListener(int id, BigDecimal amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	
	public int id;
	public BigDecimal amount;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Removed in version 1r
		//App.vaultTracker.vaults.get(id).transactionHistory.add(new Transaction(amount));
		
		App.vaultTracker.vaults.get(id).balance = App.vaultTracker.vaults.get(id).balance.add(amount);
		try {
			FileUtils.writeJsonToFile(FileUtils.vaultTracker, App.vaultTracker);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("Failed to save the vault tracker");
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
