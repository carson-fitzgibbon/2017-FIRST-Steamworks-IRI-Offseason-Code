package org.usfirst.frc.team4206.robot.commands;

import org.usfirst.frc.team4206.robot.Robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeRollers extends Command {


	
    public IntakeRollers() {
    	requires(Robot.rollers);
    	
    	this.setTimeout(0.5);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Intaking Gear");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.rollers.intake();
    	System.out.println(Robot.rollers.getRollerCurrent());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
<<<<<<< HEAD
    	if (this.isTimedOut() & Robot.rollers.getRollerCurrent() >= 10) return true;
=======
    	if(Robot.rollers.getRollerCurrent() >= 6) return true;
>>>>>>> 5eb174f3bf9d778fb45d14b25299e01c2d392972
    	else return false;

    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rollers.stop();
    	System.out.println("Finished Intaking Gear");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.rollers.stop();
    }
}
