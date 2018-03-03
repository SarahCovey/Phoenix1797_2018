package org.usfirst.frc.team1797.robot.commands.teleoputils;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RetractIntake extends Command {

	public RetractIntake() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.INTAKE_DEPLOY_PISTONS);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.INTAKE_DEPLOY_PISTONS.retract();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return System.currentTimeMillis() - Robot.INTAKE_DEPLOY_PISTONS.getLastActuation() >= 1000;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.INTAKE_DEPLOY_PISTONS.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
