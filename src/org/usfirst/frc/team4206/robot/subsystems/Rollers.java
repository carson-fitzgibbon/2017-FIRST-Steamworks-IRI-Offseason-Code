package org.usfirst.frc.team4206.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Rollers extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon activeRoller = new CANTalon(9);
	
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	public void intake() {
		activeRoller.set(0.8);
	}

	public void exhaust() {
		activeRoller.set(-0.8);
	}
	
	public void stop() {
		activeRoller.set(0);
	}
	
	public double getRollerCurrent() {
		return pdp.getCurrent(11);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

