package info.spicyclient.moneytracker;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

import info.spicyclient.moneytracker.files.Vault;
import info.spicyclient.moneytracker.files.VaultTracker;
import info.spicyclient.moneytracker.gui.LabelRefresh;
import info.spicyclient.moneytracker.gui.Window;
import info.spicyclient.moneytracker.utils.FileUtils;

public class App {
	
	public static VaultTracker vaultTracker;
	
	public static int version = 1;
	
	public static void startApp() {
		
		if (!FileUtils.mainDir.exists()) {
			System.err.println("Could not find main dir");
			FileUtils.mainDir.mkdirs();
			System.err.println("Created main dir");
		}else {
			System.out.println("Found main dir");
		}
		
		if (!FileUtils.vaultTracker.exists()) {
			System.err.println("Could not find vault tracker");
			try {
				FileUtils.vaultTracker.createNewFile();
				VaultTracker newVaultTracker = new VaultTracker();
				newVaultTracker.vaults.add(new Vault());
				FileUtils.writeJsonToFile(FileUtils.vaultTracker, newVaultTracker);
				System.err.println("Created vault tracker");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Found vault tracker");
		}
		
		try {
			vaultTracker = (VaultTracker) FileUtils.readJsonFromFile(FileUtils.vaultTracker, new VaultTracker());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			System.err.println("Failed to load the vault tracker");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Failed to load the vault tracker");
			System.exit(0);
		}
		
		System.out.println("Loaded a vault tracker with a version of " + vaultTracker.version);
		
		if (vaultTracker.version < new VaultTracker().version) {
			System.err.println("This version is outdated and might cause a crash");
		}
		
		Window.create(vaultTracker);
		LabelRefresh.labelRefresh.start();
		
	}
	
}
