package org.usfirst.frc.team4206.robot;

import org.usfirst.frc.team4206.robot.commands.ActiveArmDown;
import org.usfirst.frc.team4206.robot.commands.ActiveArmUp;
import org.usfirst.frc.team4206.robot.commands.StopRollers;
import org.usfirst.frc.team4206.robot.commands.auto.AutoCenterPeg;
import org.usfirst.frc.team4206.robot.commands.auto.AutoLeftPeg;
import org.usfirst.frc.team4206.robot.commands.auto.AutoRightPeg;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.IntakeGear;
import org.usfirst.frc.team4206.robot.commands.magicbuttons.MagicButton;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardLayout {
	
	
	public void initSmartDashboard() {
		
		SmartDashboard.putData(Scheduler.getInstance());
		
		//Add Commands
		SmartDashboard.putData("Active Arm Down", new ActiveArmDown());
		SmartDashboard.putData("Active Arm Up", new ActiveArmUp());
		SmartDashboard.putData("Stop Rollers", new StopRollers());
		SmartDashboard.putData("Magic Button", new MagicButton());
		SmartDashboard.putData("Intake Gear", new IntakeGear());
		
		//Add Auto Commands
		SmartDashboard.putData("Center Peg", new AutoCenterPeg());
		SmartDashboard.putData("Left Peg", new AutoLeftPeg());
		SmartDashboard.putData("Right Peg", new AutoRightPeg());
		
		
		
		//Drive Train
		SmartDashboard.putNumber("Front Left Velocity", Robot.drivetrain.frontLeft.getEncVelocity());
		SmartDashboard.putNumber("Front Right Velocity", Robot.drivetrain.frontRight.getEncVelocity());
		SmartDashboard.putNumber("Front Left Position", Robot.drivetrain.frontLeft.getPosition());
		SmartDashboard.putNumber("Front Right Position", Robot.drivetrain.frontLeft.getPosition());
		
		//Active Feeder
		SmartDashboard.putNumber("Active Feeder Position", Robot.activegearfeeder.activeMaster.getPosition());
		SmartDashboard.putNumber("Active Feeder Error", Robot.activegearfeeder.activeMaster.getClosedLoopError());
		SmartDashboard.putNumber("Active Feeder Roller Current", Robot.rollers.getRollerCurrent());
		
		//PDP
		SmartDashboard.putNumber("Total Energy (Watts)", Robot.rollers.pdp.getTotalPower());
		
		//Climber
		SmartDashboard.putNumber("Climber Current", Robot.climber.climberMaster.getOutputCurrent());
		
		//Gyro
		SmartDashboard.putNumber("Gyro Angle", Robot.navigationsensor.getGyro());
		
		//Passive Feeder
		
		//Pneumatics - to be added
		
	}

}
