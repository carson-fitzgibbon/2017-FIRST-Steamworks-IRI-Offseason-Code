package org.usfirst.frc.team4206.robot.commands.auto.redalliance;

import org.usfirst.frc.team4206.robot.commands.ResetGyro;
import org.usfirst.frc.team4206.robot.commands.auto.AutoDriveStraight;
import org.usfirst.frc.team4206.robot.commands.auto.AutoTurn;
import org.usfirst.frc.team4206.robot.commands.auto.MotionMagic;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedCenterPeg extends CommandGroup {

    public RedCenterPeg() {
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
    	addSequential(new AutoDriveStraight(-0.5, 2.75));
    	addSequential(new MagicButton());
    	addSequential(new MotionMagic(-4, -4, 3));
    	addSequential(new AutoTurn(90));
    	addSequential(new MotionMagic(-4, -4, 550, 550, 5));
    	addSequential(new AutoTurn(180));
    	addSequential(new MotionMagic(9, 9, 550, 550, 275, 275, 6));
    }
}
