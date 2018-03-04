package org.usfirst.frc.team1797.robot.auto;

import org.usfirst.frc.team1797.robot.commands.FlipCommand;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.AutoDeliverBoxMToL;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.AutoDeliverBoxMToR;
import org.usfirst.frc.team1797.robot.commands.auto.autoutils.DelayCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleAutoDeliverBox extends CommandGroup {

    public MiddleAutoDeliverBox() {
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

    	addSequential(new DelayCommand(0));
    	char ch = DriverStation.getInstance().getGameSpecificMessage().toLowerCase().charAt(0);
    	System.out.println(""+ch);
    	if(ch == 'l') {
    		addSequential(new AutoDeliverBoxMToL());
    		System.out.println("in the LEFT if statement");
    	} else {
    		addSequential(new AutoDeliverBoxMToR());
    		System.out.println("in the RIGHT if statement");
    	}
    	// addSequential(new FlipCommand());
    }
}
