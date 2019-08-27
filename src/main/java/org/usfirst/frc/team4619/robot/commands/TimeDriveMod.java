package org.usfirst.frc.team4619.robot.commands;

public class TimeDriveMod extends CommandBase{
	
	double time;
	long startTime;
	double speed;
	
	public TimeDriveMod(double time, double speed)
	{
		requires(driveMech);
		this.time = time;
		this.speed = speed;
	}
	
	protected void initialize() 
	{
		//setTimeout(this.time);
		this.startTime = System.currentTimeMillis();
	}

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
		//return isTimedOut();
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
