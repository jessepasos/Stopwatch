package stopwatch;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;


/**
 * @name 	StopwatchTimer
 * @package	Stopwatch
 * @author 	Jesse Pasos
 * @desc 	Handle the stopwatch mechanisms.
 */
public class TimerControl extends JPanel implements ActionListener {  
	
	private static final long serialVersionUID = 1L;

	// Declarations:
	private Timer 	swTimer 	= new Timer(100, this); 	
	private JLabel 	labelTime 	= new JLabel();
	
	int counter = 0;
	int millisecond, 
		second, 
		minute, 
		hour;	 

	
	/**
	 * @name 	actionPerformed
	 * @desc 	Start the timer on user action.
	 * 
	 * @param 	ActionEvent		actionEvent
	 * 
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		start();
	}

	
	/**
	 * @name	start
	 * @desc	Begin the timer object, increment the counter, and run the convert method. 	
	 */
	public void start() {
		
		swTimer.start();
		counter++;
		convert();
	}

	
	/**
	 * @name 	pause
	 * @desc 	Pause the timer and run the convert method.
	 */
	public void pause() {
		
		swTimer.stop();
		convert();
	}

	
	/**
	 * @name 	clear
	 * @desc 	Run the pause method and reset the counter back to 0. 
	 */
	public void clear() {
		
		pause();
		counter = 0;
	}

	
	/**
	 * @name 	convert
	 * @desc 	Convert the counter into milliseconds, seconds, minutes, and hours. Print the time label.
	 */
	public void convert() {
		
      millisecond 	= (int) (counter / (1) ) % 10;
      second 		= (int) (counter / (10) ) % 60;
      minute 		= (int) (counter / ( 10 * 60 ) ) % 60;
      hour 			= (int) (counter / ( 1000 * 60 * 60 ) ) % 24;  
              
      printTime();
      
	}

	
	/**
	 * @name 	printTime
	 * @desc 	Formats the time integer values into a clean string. This string is set to the time label.
	 * 
	 * @return  JLabel 		labelTime 		Timer label.
	 */
	public JLabel printTime() {
		
		labelTime.setText(
			String.format(
				"%02d:%02d:%02d.%02d", 
				hour, 
				minute, 
				second, 
				millisecond
			)
		);
		
		return labelTime;
	}

	
	/**
	 * @name 	getTime
	 * @desc 	Returns the current time increment.
	 * 
	 * @return  Integer		counter 	The current timer increment. 
	 */
    public int getTime() {
        return counter;
    }

}