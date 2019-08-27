package org.usfirst.frc.team4619.robot.commands;

public class DriveJoystick extends CommandBase {

	public DriveJoystick()
	{
		requires(driveMech);
	}
	
	public void initialize()
	{
	}
	
	public void execute()
	{
		driveMech.arcadeDrive(oi.getXAxis(), oi.getYAxis());	
	}
	
	public boolean isFinished()
	{
		return false;
	}
	
	public void end()
	{
		
	}
	
	public void interrupted()
	{
		
	}
	
}
