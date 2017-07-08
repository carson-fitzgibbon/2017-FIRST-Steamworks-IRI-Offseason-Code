package org.usfirst.frc.team4206.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDS extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public boolean isvisionon = false;
	public boolean islamboon = false;
	
	Solenoid VisionLight = new Solenoid(1);
	Solenoid LamboWindows = new Solenoid(2);
	
	public void visionLightOn() {
		VisionLight.set(true);
	}
	
	public void visionLightOff() {
		VisionLight.set(false);
	}
	
	public void LamboWindowsOn() {
		LamboWindows.set(true);
	}
	
	public void LamboWindowsOff() {
		LamboWindows.set(false);
	}
	


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

