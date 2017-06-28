package org.usfirst.frc.team4206.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Rollers extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon activeRoller = new CANTalon(9);
	
	public void intake() {
		activeRoller.set(0.6);
	}

	public void exhausr() {
		activeRoller.set(-0.6);
	}
	
	public void stop() {
		activeRoller.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

