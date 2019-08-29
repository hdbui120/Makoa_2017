package org.usfirst.frc.team4619.robot.commands;

public class TimeDriveMod extends CommandBase{
	
	/*
		This class let the drive train to drive at a certain amount of seconds in the event the encoders break
	*/

	//variables needed to calculate difference in time
	double time;
	long startTime;

	//rpm of the motors
	double speed;
	
	//constructor that take desire time and speed
	public TimeDriveMod(double time, double speed)
	{
		requires(driveMech);
		this.time = time;
		this.speed = speed;
	}
	
	protected void initialize() 
	{
		this.startTime = System.currentTimeMillis();
	}

	//drive forward at certain speed
	@Override
	protected void execute() 
	{
		driveMech.forwardMod(this.speed);
	}
	
	@Override
	protected boolean isFinished() 
	{
		// TODO Auto-generated method stub
		return System.currentTimeMillis() - this.startTime > this.time * 1000;
	}
	
	@Override
	protected void end() 
	{
		driveMech.doNothing();
	}

	@Override
	protected void interrupted() {
		driveMech.doNothing();
	}

}
