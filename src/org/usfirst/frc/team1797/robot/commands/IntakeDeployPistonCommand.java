package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeDeployPistonCommand extends Command {

	private long lastAct;
	
    public IntakeDeployPistonCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.INTAKE_DEPLOY_PISTONS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.operatorInput.getPOV() == 180) {
			lastAct = System.currentTimeMillis();
			Robot.INTAKE_DEPLOY_PISTONS.extend();
		} else if (Robot.oi.operatorInput.getPOV() == 0) {
			lastAct = System.currentTimeMillis();
			Robot.INTAKE_DEPLOY_PISTONS.retract();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
