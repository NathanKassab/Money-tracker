package info.spicyclient.moneytracker.gui.random;

import java.awt.Button;
import java.awt.Font;
import java.math.BigDecimal;

import info.spicyclient.moneytracker.gui.listeners.DeleteVaultListener;
import info.spicyclient.moneytracker.gui.listeners.IncrementButtonListener;
import info.spicyclient.moneytracker.gui.listeners.VaultButtonListener;

@SuppressWarnings("serial")
// Used to extend jbutton but I like the look of the normal awt button better
public class BetterButton extends Button {
	
	public BetterButton(int id, BigDecimal amount, String text, Font font) {
		super();
		this.id = id;
		this.amount = amount;
		this.setLabel(text);
		// For jbutton
		//this.setText(text);
		this.setFont(font);
		this.addActionListener(new IncrementButtonListener(this.id, this.amount));
	}
	
	public BetterButton(String text, Font font) {
		super();
		this.setLabel(text);
		// For jbutton
		//this.setText(text);
		this.setFont(font);
		this.addActionListener(new VaultButtonListener());
	}
	
	public BetterButton(String text, Font font, int id) {
		super();
		this.id = id;
		this.setLabel(text);
		// For jbutton
		//this.setText(text);
		this.setFont(font);
		this.addActionListener(new DeleteVaultListener(id, this));
	}
	
	public int id;
	public BigDecimal amount;
	
}
