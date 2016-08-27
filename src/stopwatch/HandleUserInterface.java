package stopwatch;

import java.awt.event.*;
import javax.swing.*;


/**
 * @name 	StopwatchGUI
 * @package	Stopwatch
 * @author 	Jesse Pasos
 * @desc 	Handle the stopwatch user interface.
 */
public class HandleUserInterface extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	// Declarations:
	TimerControl 	swTimer = new TimerControl();
	Boolean 		timerOn = false;
	int 			counter;
	
	
	// GUI components:
	JPanel 	panelMain 			= new JPanel();
	JLabel 	labelPlaceholder 	= new JLabel("  ");
	JButton buttonControl 		= new JButton("Begin");
	JButton buttonRestart 		= new JButton("Restart");
	
	
	/**
	 * @name 	StopwatchGUI
	 * @desc 	Load GUI components and assign action listeners.
	 */
	public HandleUserInterface() {
		
		// GUI components:
		panelMain.add(swTimer.printTime());
		panelMain.add(labelPlaceholder);
		panelMain.add(buttonControl);
		panelMain.add(buttonRestart);
		add(panelMain);
		
		// Action listeners:
		buttonControl.addActionListener(this);
		buttonRestart.addActionListener(this);		
	}
	
	
	/**
	 * @name 	actionPerformed
	 * @desc 	Respond to and handle user actions.
	 * 
	 * @param 	ActionEvent		actionEvent
	 * @return 	void
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		
		// Begin timer:
		swTimer.start();
		
		// Set counter:
		counter = swTimer.getTime();		
			
		// Check if the control button has been clicked:
		if(actionEvent.getSource() == buttonControl) {		
			
			// Toggle timer:
			if(timerOn) { 
				disable(); 
			}			
			else { 
				enable(); 
			}					
		}
		
		// Check if the restart button has been clicked:
		if(actionEvent.getSource() == buttonRestart) {
			
			// Clear timer:
			swTimer.clear();	
			
			// Disable timer:
			if(timerOn) { 
				disable(); 
			}
		}		
	}
	
	
	/**
	 * @name	enable
	 * @desc	Pause the timer, change the label text to "Start", and update the timerOn boolean.
	 */
	public void enable() {		
		buttonControl.setText("Pause");
		timerOn = true;	
	}
	
	
	/**
	 * @name 	disable
	 * @desc 	Change text to 'pause' and update timerOn boolean.
	 */
	public void disable() {		
		swTimer.pause();
		buttonControl.setText("  Start  ");
		timerOn = false;
	} 
}