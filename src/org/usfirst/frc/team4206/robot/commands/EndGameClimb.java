package org.usfirst.frc.team4206.robot.commands;

import org.usfirst.frc.team4206.robot.OI;
import org.usfirst.frc.team4206.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EndGameClimb extends Command {

    public EndGameClimb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Climbing");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climber.climbUpJoystick(OI.driver.getRawAxis(3));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.cancel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
