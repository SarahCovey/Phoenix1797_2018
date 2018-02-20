package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeDeployPistons extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DoubleSolenoid piston = new DoubleSolenoid(1, RobotMap.getPort("intake_deploy_piston_1"), 
			RobotMap.getPort("intake_deploy_piston_2"));
	long lastAct = Long.MAX_VALUE;
	
	public void extend() {
		piston.set(DoubleSolenoid.Value.kForward);
		lastAct = System.currentTimeMillis();
	}
	public void retract() {
		piston.set(DoubleSolenoid.Value.kReverse);
		lastAct = System.currentTimeMillis();
	}
	public void stop() {
		piston.set(DoubleSolenoid.Value.kOff);
		lastAct = Long.MAX_VALUE;
	}
	public long getLastActuation() {
		return lastAct;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

