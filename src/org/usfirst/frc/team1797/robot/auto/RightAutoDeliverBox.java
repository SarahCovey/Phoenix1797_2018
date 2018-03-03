package org.usfirst.frc.team1797.robot.auto;

import org.usfirst.frc.team1797.robot.commands.FlipCommand;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.AutoDeliverBoxRToR;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.DelayCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightAutoDeliverBox extends CommandGroup {

    public RightAutoDeliverBox() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	char ch = DriverStation.getInstance().getGameSpecificMessage().toLowerCase().charAt(0);
    	addSequential(new DelayCommand(0));
    	if(ch == 'l') {
    		addSequential(new AutoDeliverBoxRToR());
    	} else {
    		addSequential(new AutoDeliverBoxRToR());
    	}
    	// addSequential(new FlipCommand());
    }
}
