
package org.usfirst.frc.team4206.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4206.robot.commands.ExampleCommand;
import org.usfirst.frc.team4206.robot.commands.StopArm;
import org.usfirst.frc.team4206.robot.subsystems.ActiveGearFeeder;
import org.usfirst.frc.team4206.robot.subsystems.Climber;
import org.usfirst.frc.team4206.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4206.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4206.robot.subsystems.NavigationSensor;
import org.usfirst.frc.team4206.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4206.robot.subsystems.Rollers;
import org.usfirst.frc.team4206.robot.subsystems.Vision;
import org.usfirst.frc.team4206.robot.commands.auto.AutoCenterPeg;
import org.usfirst.frc.team4206.robot.commands.auto.AutoLeftPeg;
import org.usfirst.frc.team4206.robot.commands.auto.AutoRightPeg;
import org.usfirst.frc.team4206.robot.commands.auto.RedAutoLeftPeg;
import org.usfirst.frc.team4206.robot.commands.auto.RedAutoRightPeg;
import org.usfirst.frc.team4206.robot.commands.auto.TwoGearAuto;
import org.usfirst.frc.team4206.robot.commands.auto.VisionTurnTest;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final Climber climber = new Climber();
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final ActiveGearFeeder activegearfeeder = new ActiveGearFeeder();
	public static final Rollers rollers = new Rollers();
	public static final NavigationSensor navigationsensor = new NavigationSensor();
	public static final Vision vision = new Vision();

	public static OI oi;

	Command AutoCenterPeg;
	Command AutoLeftPeg;
	Command AutoRightPeg;
	Command AutoCenterPegWithVision;
	Command AutoLeftPegWithVision;
	Command AutoRightPegWithVision;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(480, 320);
        camera.setExposureManual(0);
        
        navigationsensor.init();
        vision.init();
        
		chooser.addDefault("Center Auto", new AutoCenterPeg());
		chooser.addObject("Vision Test", new VisionTurnTest());
		chooser.addObject("Left Auto", new AutoLeftPeg());
		chooser.addObject("Left Vision", new AutoLeftPeg());
		chooser.addObject("Right Auto", new AutoRightPeg());
		chooser.addObject("Right Vision", new AutoRightPeg());
		chooser.addObject("Red Left Peg", new RedAutoLeftPeg());
		chooser.addObject("Red Right Peg", new RedAutoRightPeg());
		chooser.addObject("Two Gear Auto", new TwoGearAuto());
		
		SmartDashboard.putData("EMERGENCY ARM STOP", new StopArm());
		
		SmartDashboard.putData("Auto mode", chooser);
		/*
        if (OI.Vision.get()) isVision = true;
        if (OI.LeftPeg.get()) {
        	if (OI.Vision.get()) 
        } else if (OI.RightPeg.get()) {
        	
        }
        */
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		chooser.getSelected().start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
