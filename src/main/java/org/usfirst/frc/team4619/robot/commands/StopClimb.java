package org.usfirst.frc.team4619.robot.commands;

public class StopClimb extends CommandBase
{
	/*This class sets the climber to 0 rpm

	*/
	public StopClimb()
	{
		requires(climberMech);
	}
	
	protected void initialize() 
	{
		
	}
	
	protected void execute() 
	{
		climberMech.doNothing();
	}
	
	protected boolean isFinished() 
	{
		return false;
	}
	
	protected void end() 
	{
		climberMech.doNothing();
	}
	
	protected void interrupted() 
	{
		climberMech.doNothing();
	}
}
