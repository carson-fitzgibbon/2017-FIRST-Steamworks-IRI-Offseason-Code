package org.usfirst.frc.team4206.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon climberMaster = new CANTalon(5);
	CANTalon climberSlave = new CANTalon(6);
	
	public Climber() {
		climberSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		climberSlave.set(climberMaster.getDeviceID());
	}
	
	public void climbUpJoystick(double power) {
		climberMaster.set(power);
	}
	
	public void climbUpButton() {
		climberMaster.set(1);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

