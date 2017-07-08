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
	private double _setleftvelocity;
	private double _setrightvelocity;
	private double _setleftacc;
	private double _setrightacc;
	
	public MotionMagic(double setleft, double setright, double timeout) {
		this(setleft, setright, 410, 400, 154, 150, timeout);
	}
	
	public MotionMagic(double setleft, double setright, double leftvel, double rightvel, double timeout) {
		this(setleft, setright, leftvel, rightvel, 154, 150, timeout);
	}
	
	
    public MotionMagic(double setleft, double setright, double leftvel, double rightvel, double leftacc, double rightacc, double timeout) {

    	
    	requires(Robot.drivetrain);
    	this.setTimeout(timeout);
    	_setleft = setleft;
    	_setright = setright;
    	_setleftvelocity = leftvel;
    	_setrightvelocity = rightvel;
    	_setrightacc = rightacc;
    	_setleftacc = leftacc;
    	
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoders();
 
    	Robot.drivetrain.rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		Robot.drivetrain.rearLeft.set(Robot.drivetrain.frontLeft.getDeviceID());
		/* first choose the sensor */
		Robot.drivetrain.frontLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		Robot.drivetrain.frontLeft.reverseSensor(true);
		// Robot.drivetrain.frontLeft.configEncoderCodesPerRev(XXX), // if using
		// FeedbackDevice.QuadEncoder
		// Robot.drivetrain.frontLeft.configPotentiometerTurns(XXX), // if using
		// FeedbackDevice.AnalogEncoder or AnalogPot

		/* set the peak and nominal outputs, 12V means full */
		Robot.drivetrain.frontLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		Robot.drivetrain.frontLeft.configPeakOutputVoltage(+12.0f, -12.0f);
		/* set closed loop gains in slot0 - see documentation */
		Robot.drivetrain.frontLeft.setProfile(0);
		//Robot.drivetrain.frontLeft.setF(0);
		//Robot.drivetrain.frontLeft.setP(0);
		//Robot.drivetrain.frontLeft.setI(0);
		//Robot.drivetrain.frontLeft.setD(0);
		/* set acceleration and vcruise velocity - see documentation */
		Robot.drivetrain.frontLeft.setMotionMagicCruiseVelocity(_setleftvelocity); //default = 410
		Robot.drivetrain.frontLeft.setMotionMagicAcceleration(_setleftacc); //default = 154
		
		Robot.drivetrain.rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		Robot.drivetrain.rearRight.set(Robot.drivetrain.frontRight.getDeviceID());
		/* first choose the sensor */
		Robot.drivetrain.frontRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		Robot.drivetrain.frontRight.reverseOutput(true);
		// Robot.drivetrain.frontRight.configEncoderCodesPerRev(XXX), // if using
		// FeedbackDevice.QuadEncoder
		// Robot.drivetrain.frontRight.configPotentiometerTurns(XXX), // if using
		// FeedbackDevice.AnalogEncoder or AnalogPot

		/* set the peak and nominal outputs, 12V means full */
		Robot.drivetrain.frontRight.configNominalOutputVoltage(+0.0f, -0.0f);
		Robot.drivetrain.frontRight.configPeakOutputVoltage(+12.0f, -12.0f);
		/* set closed loop gains in slot0 - see documentation */
		Robot.drivetrain.frontRight.setProfile(0);
		//Robot.drivetrain.frontRight.setF(0);
		//Robot.drivetrain.frontRight.setP(0);
		//Robot.drivetrain.frontRight.setI(0);
		//Robot.drivetrain.frontRight.setD(0);
		/* set acceleration and vcruise velocity - see documentation */
		Robot.drivetrain.frontRight.setMotionMagicCruiseVelocity(_setrightvelocity); //default = 400
		Robot.drivetrain.frontRight.setMotionMagicAcceleration(_setrightacc);//default = 150
		Robot.drivetrain.frontLeft.changeControlMode(TalonControlMode.MotionMagic);
		Robot.drivetrain.frontRight.changeControlMode(TalonControlMode.MotionMagic);
		Robot.drivetrain.frontLeft.set(_setleft); 
		Robot.drivetrain.frontRight.set(_setright); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.frontLeft.set(_setleft); 
		Robot.drivetrain.frontRight.set(_setright); 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.drivetrain.getMotionMagicError(Robot.drivetrain.frontRight) < 8 || this.isTimedOut() ) return true;
        else return false;
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
