package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.commands.ResetGyro;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftPeg extends CommandGroup {

    public AutoLeftPeg() {
    	addSequential(new ResetGyro());
    	addSequential(new MotionMagic(-5.2, -5.2));
    	addSequential(new AutoTurn(58), 1.3);
    	addSequential(new MotionMagic(-1.4, -1.4), 1.5);
    	addSequential(new MagicButton());
    	
    	
    }
}
