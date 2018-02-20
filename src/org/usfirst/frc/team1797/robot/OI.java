package org.usfirst.frc.team1797.robot;

import org.usfirst.frc.team1797.robot.commands.FlipCommand;
import org.usfirst.frc.team1797.robot.commands.IntakeCommand;
import org.usfirst.frc.team1797.robot.commands.IntakePistonsExtend;
import org.usfirst.frc.team1797.robot.commands.IntakePistonsRetract;
import org.usfirst.frc.team1797.robot.commands.LeftRampCommand;
import org.usfirst.frc.team1797.robot.commands.OuttakeCommand;
import org.usfirst.frc.team1797.robot.commands.RightRampCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public Joystick driverInput = new Joystick(RobotMap.DRIVER_CONTROLLER_PORT);
	public Joystick operatorInput = new Joystick(RobotMap.OPERATOR_CONTROLLER_PORT);
	
	public JoystickButton intakeButton = new JoystickButton(operatorInput, 1);
	public JoystickButton outtakeButton = new JoystickButton(operatorInput, 4);
	public JoystickButton intakePistonsButton = new JoystickButton(operatorInput, 5);
	public JoystickButton flipButton = new JoystickButton(operatorInput, 6);
	public JoystickButton leftRampButton = new JoystickButton(operatorInput, 7);
	public JoystickButton rightRampButton = new JoystickButton(operatorInput, 8);
	
	public OI() {
		leftRampButton.whenPressed(new LeftRampCommand());
		rightRampButton.whenPressed(new RightRampCommand());
		flipButton.whenPressed(new FlipCommand());
		outtakeButton.whileHeld(new OuttakeCommand());
		intakeButton.whileHeld(new IntakeCommand());
		intakeButton.whenPressed(new IntakePistonsRetract());
		intakePistonsButton.whenPressed(new IntakePistonsExtend());
	}
}