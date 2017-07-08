package org.usfirst.frc.team4206.robot.commands.leds;

import org.usfirst.frc.team4206.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleLambo extends Command {
	


    public ToggleLambo() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.leds);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.leds.islamboon = false) Robot.leds.LamboWindowsOn();
    	else Robot.leds.LamboWindowsOff();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
