package all;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.*;

public class ComboGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// holds label strings
	private String monthString = "Month", dayString = "Day",
			yearString = "Year";

	// holds the combo lists
	private String[] monthStrings = { "Janurary", "Febuary", "March", "April",
			"May", "June", "July", "August", "September", "October",
			"November", "December" };

	private List<String> dayStrings = new ArrayList<String>(Arrays.asList("1",
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
			"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
			"25", "26", "27", "28", "29", "30", "31"));

	private List<String> yearStrings = new ArrayList<String>();

	private int numDays;

	public ComboGUI() {

		// label creation
		JLabel monthLabel = new JLabel(monthString);
		JLabel dayLabel = new JLabel(dayString);
		JLabel yearLabel = new JLabel(yearString);

		// getting local time, date, day of week and other details in local
		// timezone
		Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

		int currentDay = localCalendar.get(Calendar.DATE);
		int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
		int currentYear = localCalendar.get(Calendar.YEAR);

		// logic for years +- 5
		for (int count = -5; count <= 5; count++)
			yearStrings.add(String.valueOf(currentYear + count));

		// the boxes
		JComboBox monthCombo = new JComboBox(monthStrings);
		monthCombo.setSelectedIndex(currentMonth -1);

		JComboBox dayCombo = new JComboBox(dayStrings.toArray());
		dayCombo.setSelectedIndex(currentDay -1);

		JComboBox yearCombo = new JComboBox(yearStrings.toArray());
		yearCombo.setSelectedIndex(5);

		// Tell accessibility tools about label/textfield pairs.
		monthLabel.setLabelFor(monthCombo);
		dayLabel.setLabelFor(dayCombo);
		yearLabel.setLabelFor(yearCombo);

		// make new pane and add combos
		JPanel comboPane = new JPanel(new GridLayout(0,1));
		comboPane.add(monthCombo);
		comboPane.add(dayCombo);
		comboPane.add(yearCombo);
		
		//Lay out the labels in a panel.
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(monthLabel);
        labelPane.add(dayLabel);
        labelPane.add(yearLabel);

		// set the border and put on the pane
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(labelPane, BorderLayout.CENTER);
        add(comboPane, BorderLayout.LINE_END);

	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Combo Date");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add contents to the window.
		frame.add(new ComboGUI());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}
