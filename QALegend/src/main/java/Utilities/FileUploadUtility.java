package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadUtility {
	
	public void fileUploadUsingRobotClass(String path) throws AWTException {
		StringSelection ss = new StringSelection(path);        //class's obj
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);     // ss know path | copying path to clipboard
		Robot robot = new Robot();                     // robot class obj | used for keyboard evnts
		robot.delay(250);                              // wait for popup display
		robot.keyPress(KeyEvent.VK_ENTER);             // enter key press to make cursor inside text box
		robot.keyRelease(KeyEvent.VK_ENTER);           // enter key relese
		robot.keyPress(KeyEvent.VK_CONTROL);           // cntl key press | cntl + v -for pasting path
		robot.keyPress(KeyEvent.VK_V);           	   // V key press
		robot.keyRelease(KeyEvent.VK_V);               // V key release
		robot.keyRelease(KeyEvent.VK_CONTROL);         // cntl key release
		robot.keyPress(KeyEvent.VK_ENTER);             // enter key press for open btn click
		robot.delay(250); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
	}

}
