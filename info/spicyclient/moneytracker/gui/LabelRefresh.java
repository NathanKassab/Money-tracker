package info.spicyclient.moneytracker.gui;

import java.text.DecimalFormat;
import java.util.concurrent.CopyOnWriteArrayList;

import info.spicyclient.moneytracker.App;
import info.spicyclient.moneytracker.gui.random.BetterLabel;

public class LabelRefresh extends Thread {
	
	public static LabelRefresh labelRefresh = new LabelRefresh();
	
	public static CopyOnWriteArrayList<BetterLabel> labels = new CopyOnWriteArrayList<>();
	
	@Override
	public void run() {
		
		while (true) {
			
			try {
				
				for (BetterLabel label : labels) {
					DecimalFormat decimalFormat = new DecimalFormat("#.##");
					label.setText("$" + decimalFormat.format(App.vaultTracker.vaults.get(label.id).balance));
				}
				
			} catch (Exception e) {
				System.err.println("Failed to refresh labels...");
			}
			
		}
		
	}
	
}
