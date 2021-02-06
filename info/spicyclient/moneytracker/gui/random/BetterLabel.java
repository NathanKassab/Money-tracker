package info.spicyclient.moneytracker.gui.random;

import java.awt.Font;

import javax.swing.JLabel;

import info.spicyclient.moneytracker.gui.LabelRefresh;

@SuppressWarnings("serial")
public class BetterLabel extends JLabel {
	
	public BetterLabel(int id, String text, Font font) {
		super();
		this.id = id;
		this.setText(text);
		this.setFont(font);
		LabelRefresh.labels.add(this);
	}
	
	public int id;
	
}
