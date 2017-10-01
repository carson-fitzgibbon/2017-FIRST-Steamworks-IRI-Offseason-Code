package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.commands.ResetGyro;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRightPeg extends CommandGroup {

    public AutoRightPeg() {
    	addSequential(new ResetGyro());
    	addSequential(new MotionMagic(-5.1, -5.1, 2.5));
    	addSequential(new AutoTurn(-58), 1.3);
    	addSequential(new MotionMagic(-1, -1, 1.5));
    	addSequential(new MagicButton(2), 2.75);
    	addSequential(new AutoTurn(180));
    	addSequential(new MotionMagic(10, 10, 2.5));
    	}
    }
