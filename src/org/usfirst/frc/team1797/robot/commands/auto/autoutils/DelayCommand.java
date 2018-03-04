package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DelayCommand extends Command {

	private int milisec;
	private long lastAct;

	public DelayCommand(int sec) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		milisec = sec * 1000;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		lastAct = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return System.currentTimeMillis() - lastAct >= milisec;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
