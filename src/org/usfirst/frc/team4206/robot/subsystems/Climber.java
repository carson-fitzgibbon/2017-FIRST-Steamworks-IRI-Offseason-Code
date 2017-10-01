package org.usfirst.frc.team4206.robot.subsystems;

import org.usfirst.frc.team4206.robot.commands.EndGameClimb;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon climberMaster = new CANTalon(3);
	public CANTalon climberSlave = new CANTalon(4);

	
	public Climber() {
		climberSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		climberSlave.set(climberMaster.getDeviceID());
	}
	
	public void climbUpJoystick(double power) {
		climberMaster.set(-power);
		climberSlave.set(climberMaster.getDeviceID());
	}
	
	public void climbUpButton() {
		climberMaster.set(-1);
		climberSlave.set(climberMaster.getDeviceID());
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new EndGameClimb());
    }
}

