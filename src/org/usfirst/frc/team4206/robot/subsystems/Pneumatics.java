package org.usfirst.frc.team4206.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid passiveGearPiston = new DoubleSolenoid(4,5);
	
	public void toggle() {
		if (passiveGearPiston.get() == DoubleSolenoid.Value.kForward) passiveGearPiston.set(DoubleSolenoid.Value.kReverse);
		else passiveGearPiston.set(DoubleSolenoid.Value.kForward);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

