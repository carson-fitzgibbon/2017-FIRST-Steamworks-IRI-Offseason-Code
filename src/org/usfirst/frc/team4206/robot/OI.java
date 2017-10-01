package org.usfirst.frc.team4206.robot;

import org.usfirst.frc.team4206.robot.commands.ActiveArmUp;
import org.usfirst.frc.team4206.robot.commands.StopArm;
import org.usfirst.frc.team4206.robot.commands.StopRollers;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.IntakeGear;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

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
	
	static Button A = new JoystickButton(driver, 1);
	static Button B = new JoystickButton(driver, 2);
	static Button X = new JoystickButton(driver, 3);
	static Button Y = new JoystickButton(driver, 4);
	static Button LB = new JoystickButton(driver, 5);
	static Button RB = new JoystickButton(driver, 6);
	static Button Start = new JoystickButton(driver, 7);// DO NOT USE BECUASE IT IS USED IN PLAYERDRIVE COMMAND
	static Button Select = new JoystickButton(driver, 8);
	
	//DO NOT USE RIGHT TRIGGER BECUASE IT MAKES THE ROBOT CLIMB
	
	static Button LeftPeg = new JoystickButton(auto, 1);
	static Button RightPeg = new JoystickButton(auto, 2);
	static Button Vision = new JoystickButton(auto, 3);
	
	public OI() {
		A.whenPressed(new MagicButton(1));
		B.whenPressed(new IntakeGear());
		Select.whenPressed(new StopRollers());
		X.whenPressed(new StopArm());
		//Y.whenPressed(new TwoGearAuto());
		Y.whenPressed(new ActiveArmUp());
	}
}
