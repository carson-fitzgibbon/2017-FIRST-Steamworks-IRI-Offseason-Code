package org.usfirst.frc.team4206.robot.commands.magicbuttons;

import org.usfirst.frc.team4206.robot.Robot;
import org.usfirst.frc.team4206.robot.commands.ActiveArmDown;
import org.usfirst.frc.team4206.robot.commands.ActiveArmUp;
import org.usfirst.frc.team4206.robot.commands.ExhaustRollers;
import org.usfirst.frc.team4206.robot.commands.InaccurateDrive;
import org.usfirst.frc.team4206.robot.commands.StopRollers;
import org.usfirst.frc.team4206.robot.commands.auto.MotionMagic;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MagicButton extends CommandGroup {

	private double _distance;
	
	public MagicButton() {
		this._distance= 1;
	}
	
    public MagicButton(double distance) {
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
    	requires(Robot.drivetrain);
    	requires(Robot.activegearfeeder);
    	requires(Robot.rollers);
    	
    	_distance = distance;

    	addParallel(new ExhaustRollers(), 1.5);
    	addParallel(new MotionMagic(_distance, _distance, 1.5));
    	addSequential(new ActiveArmDown(), 2);
    	addSequential(new StopRollers());
    	addSequential(new ActiveArmUp(), 1.25);



    


    }
}
