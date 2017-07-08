package org.usfirst.frc.team4206.robot.commands.auto.redalliance;

import org.usfirst.frc.team4206.robot.commands.ResetGyro;
import org.usfirst.frc.team4206.robot.commands.auto.AutoTurn;
import org.usfirst.frc.team4206.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedRightPeg extends CommandGroup {

    public RedRightPeg() {
    	addSequential(new ResetGyro());
    	addSequential(new MotionMagic(-5.2, -5.2, 3));
    	addSequential(new AutoTurn(58), 1.3);
    	addSequential(new MotionMagic(-1.4, -1.4, 2));
    	addSequential(new MagicButton(2));
    	addSequential(new AutoTurn(0), 1.3);
    	addSequential(new MotionMagic(-7, -7, 550, 550, 650, 350, 5));
    }
}
