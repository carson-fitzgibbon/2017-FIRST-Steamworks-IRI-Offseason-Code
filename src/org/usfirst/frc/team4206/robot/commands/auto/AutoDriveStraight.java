package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveStraight extends Command {
	
	private double _power;
	private double kP;

    public AutoDriveStraight(double power, double seconds) {
    	requires(Robot.drivetrain);
    	requires(Robot.navigationsensor);
    	this.setTimeout(seconds);

    	_power = power;

    	kP = 0.02;
    	
    }
    protected void initialize() {
    	System.out.println("Driving");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.ArcadeDrive(_power, Robot.navigationsensor.getGyro()*kP);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (this.isTimedOut()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.ArcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
