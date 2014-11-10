package all;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PasswordGUI extends JPanel implements ActionListener {

	// took a lot of this from the example source code

	private static String OK = "ok";
	private static String HELP = "help";
	private JPasswordField passwordField;
	private static JFrame controllingFrame; // needed for dialogs

	public PasswordGUI() {
		// layout
		super(new BorderLayout());

		// create the things
		passwordField = new JPasswordField(10);
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);

		JLabel label = new JLabel("Enter the password: ");
		label.setLabelFor(passwordField);

		JButton okButton = new JButton("OK");
		JButton helpButton = new JButton("Help");

		okButton.setActionCommand(OK);
		helpButton.setActionCommand(HELP);
		okButton.addActionListener(this);
		helpButton.addActionListener(this);

		JPanel buttonPane = new JPanel(new GridLayout(0, 1));
		buttonPane.add(okButton);
		buttonPane.add(helpButton);

		JPanel fieldPane = new JPanel(new GridLayout(0, 1));
		fieldPane.add(label);
		fieldPane.add(passwordField);

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(fieldPane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.LINE_END);
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (OK.equals(cmd)) { // Process the password.
			char[] input = passwordField.getPassword();
			if (isPasswordCorrect(input)) {
				JOptionPane.showMessageDialog(controllingFrame,
						"Success! You typed the right password.");
			} else {
				JOptionPane.showMessageDialog(controllingFrame,
						"Invalid password. Try again.", "Error Message",
						JOptionPane.ERROR_MESSAGE);
			}

			// Zero out the possible password, for security.
			for (int i = 0; i < input.length; i++) {
				input[i] = 0;
			}

			passwordField.selectAll();
		} else { // The user has asked for help.
			JOptionPane
					.showMessageDialog(
							controllingFrame,
							"You can get the password by searching this example's\n"
									+ "source code for the string \"correctPassword\".\n"
									+ "Or look at the section How to Use Password Fields in\n"
									+ "the components section of The Java Tutorial.");
		}
	}

	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };

		if (input.length != correctPassword.length) {
			isCorrect = false;
		} else {
			for (int i = 0; i < input.length; i++) {
				if (input[i] != correctPassword[i]) {
					isCorrect = false;
				}
			}
		}

		// Zero out the password.
		for (int i = 0; i < correctPassword.length; i++) {
			correctPassword[i] = 0;
		}

		return isCorrect;
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Investment Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		controllingFrame = frame;

		// Add contents to the window.
		frame.add(new PasswordGUI());

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
