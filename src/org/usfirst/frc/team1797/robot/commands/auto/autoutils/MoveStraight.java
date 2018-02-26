package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @version 2.0, changes by techtide, to allow PID and straight driving and
 *          changing direction every time it's run.
 */

public class MoveStraight extends Command {
	private double driveSpeed;
	private double maxDistance;

	public MoveStraight(double speed, double distance) {
		this.driveSpeed = speed;
		this.maxDistance = distance;
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		Robot.driveTrain.resetEncoders();
	}

	protected void execute() {
		// Calls the error correction drive (uses PID) to correct driving straight.
		Robot.driveTrain.errorCorrectionDrive(-driveSpeed);
	}

	protected boolean isFinished() {
		return Robot.driveTrain.getAverageEncoderDistance() >= maxDistance;
	}

	protected void end() {
		Robot.driveTrain.arcadeDrive(0, 0);
	}

	protected void interrupted() {
		end();
	}
}
