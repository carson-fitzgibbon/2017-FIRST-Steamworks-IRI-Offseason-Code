package org.usfirst.frc.team4206.robot.subsystems;


import org.usfirst.frc.team4206.robot.commands.PlayerDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon frontLeft = new CANTalon(1);
	public CANTalon frontRight = new CANTalon(2);
	public CANTalon rearLeft = new CANTalon(7);
	public CANTalon rearRight = new CANTalon(8);
	
	public StringBuilder sb = new StringBuilder();
	

	
	RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	
	
	public DriveTrain() {
		
		drive.setSafetyEnabled(false);
		//Set up encoders
		frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);		
		frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		
		//set up defualt control mode
		frontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		frontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rearLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rearRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		
		//frontRight.reverseOutput(true);
		//rearRight.reverseOutput(true);
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
		
		frontLeft.enableBrakeMode(true);
		frontRight.enableBrakeMode(true);
		rearLeft.enableBrakeMode(true);
		rearRight.enableBrakeMode(true);
	}
	
	public void MecanumDrive(double x, double y, double rotation, double gyroAngle) {
		drive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}
	
	public void setTank(double powerleft, double powerright) {
		drive.tankDrive(powerleft, powerright);
	}
	
	public void MotionMagicDrive(double leftrot, double rightrot){
		
		
		//set up motor controllers
		frontLeft.changeControlMode(CANTalon.TalonControlMode.MotionMagic);
		frontRight.changeControlMode(CANTalon.TalonControlMode.MotionMagic);
		rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		
		rearLeft.set(frontLeft.getDeviceID());
		rearRight.set(frontRight.getDeviceID());
		
		frontLeft.setProfile(0);
		frontRight.setProfile(0);
		
		//set up motion magic 
		frontLeft.setMotionMagicAcceleration(10);
		frontLeft.setMotionMagicCruiseVelocity(100);
		
		frontRight.setMotionMagicAcceleration(10);
		frontRight.setMotionMagicCruiseVelocity(100);
		
		frontRight.reverseOutput(true);
		
		//set number of wheel rotations
		
		frontLeft.set(leftrot);
		frontRight.set(rightrot);
		
	}
	
	public void getClosedLoopError() {
		double errorLeft = frontLeft.getClosedLoopError();
		double errorRight = frontRight.getClosedLoopError();
		sb.append("FL_ERROR");
		sb.append(errorLeft);
		sb.append("FR_ERROR");
		sb.append(errorRight);
	}
	

	
	public void ArcadeDrive(double x, double y) {
		drive.arcadeDrive(y, x);
	}
	
	
	public double getEncoderValue(CANTalon encoder) {
		return encoder.getPosition()
	}
	
	public void resetEncoders() {
		frontLeft.setEncPosition(0);
		frontRight.setEncPosition(0);
		
	}
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new PlayerDrive());
    }
}

