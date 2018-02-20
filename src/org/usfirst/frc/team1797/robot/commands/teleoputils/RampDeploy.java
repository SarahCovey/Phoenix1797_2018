package org.usfirst.frc.team1797.robot.commands.teleoputils;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RampDeploy extends Command {
	
    public RampDeploy() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.deployRamp);
        setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.deployRamp.deploy();	
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("IM HERE "+Robot.deployRamp.isDeployed());
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
	    return isTimedOut();
	}
	
	// Called once after isFinished returns true
	protected void end() {
 		Robot.deployRamp.stop();
		
	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
    
}