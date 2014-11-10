package all;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class RadioGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// holds the radio button label strings
	private String smallString = "Small", mediumString = "Medium",
			largeString = "Large";
	
	//make the buttons
	private JRadioButton button1 = new JRadioButton(smallString), button2 = new JRadioButton(mediumString), button3 = new JRadioButton(largeString);
	
	//make the radio ButtonGroup
	private ButtonGroup radioGroup = new ButtonGroup();
	

	public RadioGUI() {

		// setup
		super(new BorderLayout());
		
		//add radio button to group
		radioGroup.add(button1);
		radioGroup.add(button2);
		radioGroup.add(button3);
		
		//make new pane and add buttons
		JPanel radioPane = new JPanel(new GridLayout(0,1));
		radioPane.add(button1);
		radioPane.add(button2);
		radioPane.add(button3);
		button1.setSelected(true);
		
		//set the border and put on the pane
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(radioPane, BorderLayout.CENTER);
		
	}
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Radio buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new RadioGUI());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
            UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

}
