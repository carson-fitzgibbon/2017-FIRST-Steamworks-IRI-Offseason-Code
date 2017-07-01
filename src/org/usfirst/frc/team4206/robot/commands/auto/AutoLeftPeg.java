package org.usfirst.frc.team4206.robot.commands.auto;

import org.usfirst.frc.team4206.robot.commands.ResetGyro;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftPeg extends CommandGroup {

    public AutoLeftPeg() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new ResetGyro());
    	addSequential(new MotionMagic(-5.2, -5.2));
    	addSequential(new AutoTurn(58), 1.3);
    	addSequential(new MotionMagic(-1.4, -1.4), 1.5);
    	addSequential(new MagicButton());
    	
    	
    }
}
