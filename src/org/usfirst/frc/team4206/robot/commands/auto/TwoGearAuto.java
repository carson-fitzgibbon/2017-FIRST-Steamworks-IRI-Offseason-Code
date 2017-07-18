package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.commands.ResetGyro;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.IntakeGear;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TwoGearAuto extends CommandGroup {

    public TwoGearAuto() {
    	addSequential(new ResetGyro());
    	addSequential(new MotionMagic(-4.6, -4.6, 2.75));
    	addSequential(new MagicButton(4.5, 2.8));
    	addSequential(new AutoTurn(95), 2);
    	addParallel(new IntakeGear());
    	addSequential(new MotionMagic(-4.5, -4.5, 3));
    	addSequential(new MotionMagic(3.75, 3.75, 2.4));
    	addSequential(new AutoTurn(0));
    	addSequential(new AutoDriveStraight(0.6, 2));
    	addSequential(new MagicButton(1));
    	
    }
}
