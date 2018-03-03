package org.usfirst.frc.team1797.robot.auto;

import org.usfirst.frc.team1797.robot.Robot;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.MoveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossBaseline13 extends CommandGroup {

    public AutoCrossBaseline13() {
        requires(Robot.DRIVETRAIN);
        
        addSequential(new MoveStraight(0.6, 196));
    }
}
