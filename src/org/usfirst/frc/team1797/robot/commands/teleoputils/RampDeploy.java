package org.usfirst.frc.team1797.robot.commands.teleoputils;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RampDeploy extends Command {
	
    public RampDeploy() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.deployRamp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.deployRamp.deploy();
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
	    return System.currentTimeMillis() - Robot.deployRamp.getLastActuation() >= 5000;
	}
	
	// Called once after isFinished returns true
	protected void end() {
// 		Robot.deployRamp.stop();
		
	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
    
}