package org.usfirst.frc.team1797.robot.commands.auto.autoutils;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.*;

/**
 * @author techtide
 * @see The path of the different autonomous routines, on the Github routine. @
 */

public class AutoDeliverBoxLToR extends CommandGroup {
	public AutoDeliverBoxLToR() {
		addSequential(new MoveStraight(0.5, 228.735));
		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
		addSequential(new MoveStraight(0.5, 252));
		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
		addSequential(new MoveStraight(0.5, 56.735));
		addSequential(new TurnCommand(Direction.RIGHT, 0.5, 90));
		addSequential(new MoveStraight(0.5, 99.4));
	}
}