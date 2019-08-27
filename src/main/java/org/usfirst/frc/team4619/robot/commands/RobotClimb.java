package org.usfirst.frc.team4619.robot.commands;

public class RobotClimb extends CommandBase
{
	double climbingSpeed;
	
	public RobotClimb(double climbingSpeed)
	{
		requires(climberMech);
		this.climbingSpeed = climbingSpeed;
	}
	
	protected void initialize() 
	{
		climberMech.Climb(climbingSpeed);
	}
	
	protected void execute() 
	{

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
