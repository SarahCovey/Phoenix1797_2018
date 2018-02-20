package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RightRamp extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private DoubleSolenoid liftPiston;
	
	private long lastActuation;
	
	private boolean isExtended = false;
		
	public RightRamp() {
		liftPiston = new DoubleSolenoid(RobotMap.getPort("right_ramp_1"),
				RobotMap.getPort("right_ramp_2"));
	}
	
    public long getLastActuation() {
    	return lastActuation;
    }
    public void lift() {
    	System.out.println("LIFT!!!!!!!!!!!");
    	liftPiston.set(DoubleSolenoid.Value.kForward);
    	lastActuation = System.currentTimeMillis();
    	isExtended = true;
    }
    public void retract() {
    	System.out.println("***********RETRACT");
    	liftPiston.set(DoubleSolenoid.Value.kReverse);
    	lastActuation = System.currentTimeMillis();
    	isExtended = false;
    }
    public void stop() {
    	liftPiston.set(DoubleSolenoid.Value.kOff);
    	lastActuation = Long.MAX_VALUE;
    }
    public boolean isExtended() {
    	return isExtended;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

