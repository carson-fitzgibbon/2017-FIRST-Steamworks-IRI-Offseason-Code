package org.usfirst.frc.team4206.robot;


import org.usfirst.frc.team4206.robot.commands.ActiveArmDown;
import org.usfirst.frc.team4206.robot.commands.ActiveArmUp;
import org.usfirst.frc.team4206.robot.commands.auto.AutoCenterPeg;
import org.usfirst.frc.team4206.robot.commands.auto.MagicButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	
	//set up button map
	public static Joystick driver = new Joystick(0);
	public static Joystick operator = new Joystick(1); 
	public static Joystick auto = new Joystick(2);
	
	Button A = new JoystickButton(driver, 1);
	Button B = new JoystickButton(driver, 2);
	Button X = new JoystickButton(driver, 3);
	Button Y = new JoystickButton(driver, 4);
	Button LB = new JoystickButton(driver, 5);
	Button RB = new JoystickButton(driver, 6);
	Button Start = new JoystickButton(driver, 7);
	Button Select = new JoystickButton(driver, 8);
	
	
	Button LeftPeg = new JoystickButton(auto, 1);
	Button RightPeg = new JoystickButton(auto, 3);
	Button Center = new JoystickButton(auto, 2);
	
	public OI() {
		
		A.whenPressed(new ActiveArmDown());
		Y.whenPressed(new ActiveArmUp());
		B.whenPressed(new AutoCenterPeg());
		X.whenPressed(new MagicButton());
		
	}
	
	
	
}
