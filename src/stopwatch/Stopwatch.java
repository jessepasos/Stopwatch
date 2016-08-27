package stopwatch;

import javax.swing.JFrame;


/**
 * @name 	Stopwatch
 * @package	Stopwatch
 * @author 	Jesse Pasos
 * @desc 	Initialize the Stopwatch program.
 */
public class Stopwatch {

	/**
	 * @name 	main
	 * @desc 	Initialize JFrame and Stopwatch GUI objects. 
	 * 
	 * @param	String Array	args	
	 * @return	void
	 */
	public static void main(String[] args) {		
		
		JFrame swJFrame = new JFrame("Stopwatch");					// Declare JFrame object
		
		swJFrame.add(new HandleUserInterface());							// Add UI interface
		swJFrame.pack();											// Set frame size to fit
		swJFrame.setVisible(true);									// Show UI window
		swJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// Define actions on close
	}	
}
