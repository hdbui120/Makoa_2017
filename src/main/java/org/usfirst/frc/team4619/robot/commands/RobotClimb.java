package org.usfirst.frc.team4619.robot.commands;

public class RobotClimb extends CommandBase
{	
	/*
		This class creates command for the climber mechanism to climb at certain speed
	*/

	//climb motor rpm
	double climbingSpeed;
	
	//constructor  that activate climber mechanism at specify speed
	public RobotClimb(double climbingSpeed)
	{
		requires(climberMech);
		this.climbingSpeed = climbingSpeed;
	}
	
	//initialize this class
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
