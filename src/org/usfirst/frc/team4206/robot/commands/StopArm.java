package org.usfirst.frc.team4206.robot.commands;

import org.usfirst.frc.team4206.robot.Robot;
import org.usfirst.frc.team4206.robot.subsystems.Rollers;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

public class StopArm extends Command {

    public StopArm() {
        requires(Robot.rollers);
        requires(Robot.activegearfeeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(3);
    	Robot.rollers.stop();
    	Robot.activegearfeeder.stop();
    	Robot.activegearfeeder.activeMaster.set(0.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.pdp.getCurrent(15) > 30 | this.isTimedOut()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.activegearfeeder.activeMaster.set(0);
    	Robot.activegearfeeder.resetArm();
    	Robot.activegearfeeder.activeMaster.changeControlMode(CANTalon.TalonControlMode.MotionMagic);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
