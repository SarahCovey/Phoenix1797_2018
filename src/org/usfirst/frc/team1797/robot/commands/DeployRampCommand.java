package org.usfirst.frc.team1797.robot.commands;

import javax.swing.plaf.basic.BasicBorders.RolloverButtonBorder;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployRampCommand extends Command {
	
	private long lastAct = Long.MAX_VALUE;
	
    public DeployRampCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(lastAct==Long.MAX_VALUE && Robot.oi.operatorInput.getPOV()==180) {
    		lastAct = System.currentTimeMillis();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - lastAct >= 1000;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
