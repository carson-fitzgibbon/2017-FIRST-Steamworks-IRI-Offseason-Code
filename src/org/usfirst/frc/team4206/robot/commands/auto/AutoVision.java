package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class AutoVision extends Command {

	private final double kP = 0.004;
	
    public AutoVision() {
        requires(Robot.vision);
        requires(Robot.drivetrain);
        this.setTimeout(2.75);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.ArcadeDrive(Robot.vision.getErr() * kP, -0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (this.isTimedOut()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
