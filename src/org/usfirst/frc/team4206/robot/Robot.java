
package org.usfirst.frc.team4206.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4206.robot.commands.StopArm;
import org.usfirst.frc.team4206.robot.subsystems.ActiveGearFeeder;
import org.usfirst.frc.team4206.robot.subsystems.Climber;
import org.usfirst.frc.team4206.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4206.robot.subsystems.NavigationSensor;
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

	public static final Climber climber = new Climber();
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final ActiveGearFeeder activegearfeeder = new ActiveGearFeeder();
	public static final Rollers rollers = new Rollers();
	public static final NavigationSensor navigationsensor = new NavigationSensor();
	public static final Vision vision = new Vision();
	public static final PowerDistributionPanel pdp = new PowerDistributionPanel();

	public static OI oi;

	Command AutoCenterPeg;
	Command AutoLeftPeg;
	Command AutoRightPeg;
	Command AutoCenterPegWithVision;
	Command AutoLeftPegWithVision;
	Command AutoRightPegWithVision;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
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
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		chooser.getSelected().start();
	}

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

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
