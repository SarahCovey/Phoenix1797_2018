package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampDeployPistons extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DoubleSolenoid deployPiston = new DoubleSolenoid(RobotMap.getPort("ramp_deploy_piston_1"),
			RobotMap.getPort("ramp_deploy_piston_2"));
	private long lastAct = Long.MAX_VALUE;
	private boolean isDeployed = false;
	
	public void deploy() {
		deployPiston.set(DoubleSolenoid.Value.kForward);
		lastAct = System.currentTimeMillis();
		isDeployed = true;
		System.out.println("RAMP DEPLOYED: "+isDeployed);
	}

	public void stop() {
		deployPiston.set(DoubleSolenoid.Value.kOff);
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

