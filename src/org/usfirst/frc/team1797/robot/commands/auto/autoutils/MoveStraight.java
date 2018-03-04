package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @version 2.0
 * changes by techtide, to allow PID and straight driving and
 *          changing direction every time it's run.
 */

public class MoveStraight extends Command {
	private double driveSpeed;
	private double maxDistance;

	public MoveStraight(double speed, double distance) {
		this.driveSpeed = speed;
		this.maxDistance = distance;
		requires(Robot.DRIVETRAIN);
	}

	protected void initialize() {
		Robot.DRIVETRAIN.resetEncoders();
	}

	protected void execute() {
		// Calls the error correction drive (uses PID) to correct driving straight.
		Robot.DRIVETRAIN.errorCorrectionDrive(driveSpeed);
	}

	protected boolean isFinished() {
		return Robot.DRIVETRAIN.getAverageEncoderDistance() >= maxDistance;
	}

	protected void end() {
		Robot.DRIVETRAIN.arcadeDrive(0, 0);
	}

	protected void interrupted() {
		end();
	}
}
