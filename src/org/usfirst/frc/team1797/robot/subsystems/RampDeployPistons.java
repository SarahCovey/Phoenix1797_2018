package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampDeployPistons extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Solenoid deployPiston = new Solenoid(1, RobotMap.getPort("ramp_deploy_piston"));
	private long lastAct = Long.MAX_VALUE;
	private boolean isDeployed = false;
	
	public void deploy() {
		deployPiston.set(true);
		lastAct = System.currentTimeMillis();
		isDeployed = true;
	}

	public void stop() {
		deployPiston.set(false);
	}
	public long getLastActuation() {
		return lastAct;
	}
	public boolean isDeployed() {
		return isDeployed;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

