package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.Robot;
import org.usfirst.frc.team4206.robot.subsystems.DriveTrain;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MotionMagic extends Command {

	private double _setleft;
	private double _setright;
	
	public MotionMagic(double setleft, double setright, double timeout) {
		
		this.setTimeout(timeout);
		
		_setleft = setleft;
		_setright = setright;
		
	}	

    protected void initialize() {
    	Robot.drivetrain.resetEncoders();
 
    	Robot.drivetrain.rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);

		/* first choose the sensor */
		Robot.drivetrain.frontLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		Robot.drivetrain.frontLeft.reverseSensor(true);
		Robot.drivetrain.frontLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		Robot.drivetrain.frontLeft.configPeakOutputVoltage(+12.0f, -12.0f);
		Robot.drivetrain.frontLeft.setProfile(0);
		//Robot.drivetrain.frontLeft.setF(0);
		//Robot.drivetrain.frontLeft.setP(0);
		//Robot.drivetrain.frontLeft.setI(0);
		//Robot.drivetrain.frontLeft.setD(0);
		/* set acceleration and vcruise velocity - see documentation */
		Robot.drivetrain.frontLeft.setMotionMagicCruiseVelocity(410); //default = 410
		Robot.drivetrain.frontLeft.setMotionMagicAcceleration(154); //default = 154
		
		Robot.drivetrain.rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);

		/* first choose the sensor */
		Robot.drivetrain.frontRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		Robot.drivetrain.frontRight.reverseOutput(true);
		Robot.drivetrain.frontRight.configNominalOutputVoltage(+0.0f, -0.0f);
		Robot.drivetrain.frontRight.configPeakOutputVoltage(+12.0f, -12.0f);
		Robot.drivetrain.frontRight.setProfile(0);
		//Robot.drivetrain.frontRight.setF(0);
		//Robot.drivetrain.frontRight.setP(0);
		//Robot.drivetrain.frontRight.setI(0);
		//Robot.drivetrain.frontRight.setD(0);
		Robot.drivetrain.frontRight.setMotionMagicCruiseVelocity(400); //default = 400
		Robot.drivetrain.frontRight.setMotionMagicAcceleration(150);//default = 150
		Robot.drivetrain.frontLeft.changeControlMode(TalonControlMode.MotionMagic);
		Robot.drivetrain.frontRight.changeControlMode(TalonControlMode.MotionMagic);
		Robot.drivetrain.frontLeft.set(_setleft); 
		Robot.drivetrain.frontRight.set(_setright); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.drivetrain.rearLeft.set(Robot.drivetrain.frontLeft.getDeviceID());
		Robot.drivetrain.rearRight.set(Robot.drivetrain.frontRight.getDeviceID());
    	Robot.drivetrain.frontLeft.set(_setleft); 
		Robot.drivetrain.frontRight.set(_setright); 
		
		System.out.println(Robot.drivetrain.frontLeft.getClosedLoopError());
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(this.isTimedOut()) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	System.out.println("Ending Error");
    	System.out.println(Robot.drivetrain.getMotionMagicError(Robot.drivetrain.frontRight));
    	
    	Robot.drivetrain.frontRight.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.drivetrain.frontLeft.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.drivetrain.rearRight.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.drivetrain.rearLeft.changeControlMode(TalonControlMode.PercentVbus);
    	
    	Robot.drivetrain.frontRight.set(0);
    	Robot.drivetrain.frontLeft.set(0);
    	Robot.drivetrain.rearRight.set(0);
    	Robot.drivetrain.rearLeft.set(0);
}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
