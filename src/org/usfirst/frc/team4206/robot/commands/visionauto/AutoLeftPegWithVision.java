package org.usfirst.frc.team4206.robot.commands.visionauto;

import org.usfirst.frc.team4206.robot.commands.ResetGyro;
import org.usfirst.frc.team4206.robot.commands.auto.AlignWithPegWhileDriving;
import org.usfirst.frc.team4206.robot.commands.auto.AutoTurn;
import org.usfirst.frc.team4206.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftPegWithVision extends CommandGroup {

    public AutoLeftPegWithVision() {
    	addSequential(new ResetGyro());
    	addSequential(new MotionMagic(-5.2, -5.2));
    	addSequential(new AutoTurn(58), 1.3);
    	addSequential(new AlignWithPegWhileDriving(0.4));
    	addSequential(new MagicButton());
    	
    	
    }
}
