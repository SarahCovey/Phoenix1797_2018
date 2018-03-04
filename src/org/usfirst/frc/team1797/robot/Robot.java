package org.usfirst.frc.team1797.robot;

import java.awt.Image;

import org.usfirst.frc.team1797.robot.auto.AutoCrossBaseline13;
import org.usfirst.frc.team1797.robot.auto.AutoCrossBaseline2;
import org.usfirst.frc.team1797.robot.auto.LeftAutoDeliverBox;
import org.usfirst.frc.team1797.robot.auto.MiddleAutoDeliverBox;
import org.usfirst.frc.team1797.robot.auto.RightAutoDeliverBox;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.DelayCommand;
// import org.usfirst.frc.team1797.robot.commands.teleoputils.RetractIntake;
import org.usfirst.frc.team1797.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1797.robot.subsystems.Flipper;
// import org.usfirst.frc.team1797.robot.subsystems.IntakeDeployPistons;
import org.usfirst.frc.team1797.robot.subsystems.IntakeMotors;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final Drivetrain DRIVETRAIN = new Drivetrain();
	public static final IntakeMotors INTAKE_MOTORS = new IntakeMotors();
	// public static final IntakeDeployPistons INTAKE_DEPLOY_PISTONS = new IntakeDeployPistons();
	public static final Flipper FLIPPER = new Flipper();
	public static OI oi;


	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<Command>();
	@SuppressWarnings("deprecation")

	SendableChooser<Command> autonomousChooser;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		autonomousChooser = new SendableChooser<Command>();
		
		// Reset the AHRS gyro angles and displacement.
		Robot.DRIVETRAIN.resetEncoders();
		RobotMap.gyro.reset();
		RobotMap.gyro.resetDisplacement();
		
		CameraServer.getInstance().startAutomaticCapture();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
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
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
//		autonomousChooser.addDefault("Do Nothing", new DelayCommand(0));
//		autonomousChooser.addDefault("Cross Baseline Side", new AutoCrossBaseline13());
		autonomousChooser.addDefault("Cross Baseline Middle", new AutoCrossBaseline2());
//		autonomousChooser.addDefault("Deliver Box Left", new LeftAutoDeliverBox());
//		autonomousChooser.addDefault("Deliver Box Middle", new MiddleAutoDeliverBox());
//		autonomousChooser.addDefault("Deliver Box Right", new RightAutoDeliverBox());
		
		autonomousCommand = (Command) autonomousChooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
		// Scheduler.getInstance().add(new RetractIntake());
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		// System.out.println("Left Distance: " +
		// Robot.DRIVE_TRAIN.leftEncoder.getDistance()
		// + "Right Distance: " + Robot.DRIVE_TRAIN.rightEncoder.getDistance());
		System.out.println("ROBOT: "+RobotMap.gyro.getAngle());
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