package org.usfirst.frc.team4206.robot.commands;

import org.usfirst.frc.team4206.robot.OI;
import org.usfirst.frc.team4206.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class PlayerDrive extends Command {

	private boolean reverse = false, hold = false;
	
    public PlayerDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (OI.driver.getRawButton(7) & !hold) {
    		reverse = !reverse;
    		hold = true;
    	} else if (!OI.driver.getRawButton(7) & hold) hold = false;
    	
    	if (!reverse) Robot.drivetrain.MecanumDrive(OI.driver.getX(), OI.driver.getY(), OI.driver.getRawAxis(4), 0);
    	else Robot.drivetrain.MecanumDrive(-OI.driver.getX(), -OI.driver.getY(), OI.driver.getRawAxis(4), 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run,,
    protected void interrupted() {
    }
}
