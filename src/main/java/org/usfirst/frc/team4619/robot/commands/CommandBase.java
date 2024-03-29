package org.usfirst.frc.team4619.robot.commands;

import org.usfirst.frc.team4619.robot.OI;
import org.usfirst.frc.team4619.robot.subsystems.Climber;
import org.usfirst.frc.team4619.robot.subsystems.DriveBase;
import org.usfirst.frc.team4619.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command{

	//create joystick object from oi class
	public static OI oi;

	//Initialize all the subsystems
	public static DriveBase driveMech = new DriveBase();
	public static Shooter shooterMech = new Shooter();
	public static Climber climberMech = new Climber();
	
	public static void init() {
		//initialize oi object
		oi = new OI();

		//calibrate gyroscope
		driveMech.gyro.calibrate();
	}	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-gene rated method stub
		return false;
	}

	
}
