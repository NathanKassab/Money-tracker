package info.spicyclient.moneytracker.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import info.spicyclient.moneytracker.App;
import info.spicyclient.moneytracker.files.VaultTracker;
import info.spicyclient.moneytracker.gui.random.BetterButton;
import info.spicyclient.moneytracker.gui.random.BetterLabel;

public class Window {
	
	public static JFrame window = new JFrame("Money Helper V" + App.version);
	
	public static void create(VaultTracker vaultTracker) {
		
		window = new JFrame("Money Helper V" + App.version);
		
		window.setSize(1200, 62);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		ArrayList<Component> things = new ArrayList<>();
		
		for (int i = 0; i < vaultTracker.vaults.size(); i++) {
			
			window.setSize(1200, 62 + (i * 62));
			
			if (i == 0) {
				window.setSize(1200, 62 + ((i + 1) * 62));
			}
			
			things.add(new BetterButton(i, new BigDecimal(-10), "-$10", Fonts.text1));
			things.add(new BetterButton(i, new BigDecimal(-5), "-$5", Fonts.text1));
			things.add(new BetterButton(i, new BigDecimal(-1), "-$1", Fonts.text1));
			things.add(new BetterButton(i, new BigDecimal(-0.5), "-$0.5", Fonts.text1));
			things.add(new BetterButton(i, new BigDecimal(-0.01), "-$0.01", Fonts.text1));
			things.add(new BetterLabel(i, "Loading...", Fonts.text2));
			things.add(new BetterButton(i, new BigDecimal(0.01), "$0.01", Fonts.text1));
			things.add(new BetterButton(i, new BigDecimal(0.5), "$0.5", Fonts.text1));
			things.add(new BetterButton(i, new BigDecimal(1), "$1", Fonts.text1));
			things.add(new BetterButton(i, new BigDecimal(5), "$5", Fonts.text1));
			things.add(new BetterButton(i, new BigDecimal(10), "$10", Fonts.text1));
			things.add(new BetterButton("Delete vault", Fonts.text3, i));
			
		}
		
		for (int i = 0; i < 11; i++) {
			things.add(new Label());
		}
		things.add(new BetterButton("Create new vault", Fonts.text3));
		
		JPanel panel = new JPanel(new GridLayout(things.size() / 12, 12));
		
		for (Component thing : things) {
			panel.add(thing);
		}
		
		window.add(panel);
		window.setVisible(true);
		
	}
	
}
