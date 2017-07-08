package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.Robot;
import org.usfirst.frc.team4206.robot.VisionProcessor.TargetType;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignWithPegWhileDriving extends Command {

	private double kP;
	private double pegAngle;
	private double powerFoward;
	
    public AlignWithPegWhileDriving(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	kP = 0.02;
    	pegAngle = Robot.visionprocessor.getAngleFromCenter(TargetType.GEAR_VISION);
    	
    	powerFoward = power;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.ArcadeDrive(pegAngle*kP, powerFoward);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.visionprocessor.getAdjustedAverageDistanceToGearTargetsHorizontal()) > 0.0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.ArcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
