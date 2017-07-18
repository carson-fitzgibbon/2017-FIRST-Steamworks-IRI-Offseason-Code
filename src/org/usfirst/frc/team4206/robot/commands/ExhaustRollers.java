package org.usfirst.frc.team4206.robot.commands;

import org.usfirst.frc.team4206.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExhaustRollers extends Command {

    public ExhaustRollers() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.rollers);
    	this.setTimeout(1.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Exh Rollers");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.rollers.exhaust();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (this.isTimedOut()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rollers.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
