package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeWheelPistons extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DoubleSolenoid piston;
	private long lastAct = Long.MAX_VALUE;
	
	public IntakeWheelPistons() {
		piston = new DoubleSolenoid(RobotMap.getPort("intake_wheel_piston_1"), 
				RobotMap.getPort("intake_wheel_piston_2"));
	}
	
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
	public long getLastAct() {
		return lastAct;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

