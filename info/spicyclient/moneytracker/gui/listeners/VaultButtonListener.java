package info.spicyclient.moneytracker.gui.listeners;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.Action;

import info.spicyclient.moneytracker.App;
import info.spicyclient.moneytracker.files.Vault;
import info.spicyclient.moneytracker.gui.LabelRefresh;
import info.spicyclient.moneytracker.gui.Window;
import info.spicyclient.moneytracker.utils.FileUtils;

public class VaultButtonListener implements Action {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		App.vaultTracker.vaults.add(new Vault());
		try {
			FileUtils.writeJsonToFile(FileUtils.vaultTracker, App.vaultTracker);
			Window.window.setVisible(false);
			LabelRefresh.labels.clear();
			Window.create(App.vaultTracker);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("Failed to save vault tracker");
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
