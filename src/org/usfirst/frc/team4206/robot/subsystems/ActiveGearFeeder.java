package org.usfirst.frc.team4206.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ActiveGearFeeder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon activeMaster = new CANTalon(5);
	CANTalon activeSlave = new CANTalon(6);

	private boolean isUp = true;
	
	public ActiveGearFeeder() {
		//Change to Slave
		activeSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		activeSlave.set(activeMaster.getDeviceID());
		
		//Enable Brake Mode
		activeMaster.enableBrakeMode(true);
		activeSlave.enableBrakeMode(true); 
		
		//Config Motion Magic
		activeMaster.changeControlMode(CANTalon.TalonControlMode.MotionMagic);
		activeMaster.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		
		activeMaster.setProfile(0);
		activeMaster.setP(4);
		activeMaster.setI(0);
		activeMaster.setD(0);
		activeMaster.setF(0.006);
		
		//KEEP THESE REALLY LOW
		activeMaster.setMotionMagicAcceleration(45);
		activeMaster.setMotionMagicCruiseVelocity(35);
		//KEEP THESE REALLY LOW
		
		activeMaster.set(-0.04);
		
		
	}
	
	public void armDown() {
		activeMaster.set(-0.328);
		isUp = false;
	}
	
	public void armUp() {
		activeMaster.set(-0.04);
		isUp = true;
	}
	
	public void setArm(double position) {
		activeMaster.set(position);
	}
	
	
	public void resetArm() {
		activeMaster.setEncPosition(0);
	}
	
		
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

