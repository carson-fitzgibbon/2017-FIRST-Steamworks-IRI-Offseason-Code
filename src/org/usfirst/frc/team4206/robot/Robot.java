
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
import org.usfirst.frc.team4206.robot.subsystems.ActiveGearFeeder;
import org.usfirst.frc.team4206.robot.subsystems.Climber;
import org.usfirst.frc.team4206.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4206.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4206.robot.subsystems.LEDS;
import org.usfirst.frc.team4206.robot.subsystems.NavigationSensor;
import org.usfirst.frc.team4206.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4206.robot.subsystems.Rollers;

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
	public static final SmartDashboardLayout smartdashboard = new SmartDashboardLayout();
	public static final VisionProcessor visionprocessor = new VisionProcessor();
	public static final LEDS leds = new LEDS();
	

	public static OI oi;

	Command AutoCenterPeg;
	Command AutoLeftPeg;
	Command AutoRightPeg;
	Command AutoCenterPegWithVision;
	Command AutoLeftPegWithVision;
	Command AutoRightPegWithVision;


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(480, 320);
        
        navigationsensor.init();
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
		if(Robot.oi.auto.getRawButton(1)) AutoRightPeg.start();
		
		else if (Robot.oi.auto.getRawButton(2)) AutoLeftPeg.start();
		
		else if (Robot.oi.auto.getRawButton(1)) AutoCenterPeg.start();
		
		else AutoCenterPeg.start();
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
		
		smartdashboard.initSmartDashboard();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
