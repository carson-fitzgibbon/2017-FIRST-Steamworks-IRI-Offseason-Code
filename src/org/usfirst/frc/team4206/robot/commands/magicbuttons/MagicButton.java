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
	private double _timeout;
	
	public MagicButton() {
		this._distance= 1;
	}
	
	public MagicButton(double distance){
		this(distance, 1.5 );
	}
	
    public MagicButton(double distance, double timeout) {
    	requires(Robot.drivetrain);
    	requires(Robot.activegearfeeder);
    	requires(Robot.rollers);
    	
    	_distance = distance;
    	_timeout = timeout;

    	
    	addParallel(new ExhaustRollers(), 1);
    	addParallel(new MotionMagic(distance, distance, timeout));
    	addSequential(new ActiveArmDown(), 1);
    	addSequential(new StopRollers());
    	addSequential(new ActiveArmUp(), 0.75);



    


    }
}
