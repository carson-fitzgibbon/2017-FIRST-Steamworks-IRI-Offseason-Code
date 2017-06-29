package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class InitiateCranceManeuver extends CommandGroup {

    public InitiateCranceManeuver() {
    	requires(Robot.drivetrain);
    	requires(Robot.navigationsensor);
    	
    	addSequential(new MotionMagic(2));
    	addSequential(new AutoTurn(30));
    	
    	
    	
    }
}
