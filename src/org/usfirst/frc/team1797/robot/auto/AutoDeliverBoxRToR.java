package org.usfirst.frc.team1797.robot.auto;

//import org.usfirst.frc.team1797.robot.commands.FlipCommand;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.Direction;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.MoveStraight;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;;

/**
 * @author techtide
 * @see The path of the different autonomous routines, on the Github routine.
 */

public class AutoDeliverBoxRToR extends CommandGroup {
	public AutoDeliverBoxRToR() {
		// Move forward ~150 units till the robot is past the switch.
		addSequential(new MoveStraight(0.7, 150));
		// Now, turn at a right angle and hit the fence opposite the switch to wall
		// align with it.
		addSequential(new TurnCommand(Direction.LEFT, 0.5, 90));
		// Reverse so the robot hits the fence.
		addSequential(new MoveStraight(0.7, 85.25));
		// Deliver the box and throw it backwards.
		// addSequential(new FlipCommand());
	}
}