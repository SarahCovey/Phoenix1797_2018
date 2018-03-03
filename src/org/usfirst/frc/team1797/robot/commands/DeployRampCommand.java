package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployRampCommand extends Command {

	private DoubleSolenoid deployPiston;
	private long lastActuation;
	
    public DeployRampCommand() {
        requires(Robot.DEPLOY_RAMP);
        deployPiston = new DoubleSolenoid(RobotMap.getPort("ramp_deploy_piston_1"), RobotMap.getPort("ramp_deploy_piston_2"));
        lastActuation = Long.MAX_VALUE;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.DEPLOY_RAMP.deploy();
    		lastActuation = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - lastActuation >= 1000;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.DEPLOY_RAMP.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
