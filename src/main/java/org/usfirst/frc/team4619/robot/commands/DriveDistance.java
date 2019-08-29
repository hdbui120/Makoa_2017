package org.usfirst.frc.team4619.robot.commands;

public class DriveDistance extends CommandBase{

	//create variable to set desire distance
	double setPoint;
	
	//method to make the robot goes straight to the setpoint/distance
	public DriveDistance(double setPoint)
	{
		requires(driveMech);
	}
	
	//run these code when the class is called
	@Override
	protected void initialize() {
		driveMech.getLeftEncoder().reset();
		driveMech.getRightEncoder().reset();
	}

	//robot drive forward and prints encoder value on dashboard
	protected void execute()
	{
		driveMech.moveForward();
		System.out.println(driveMech.getLeftEncoder().get());
	}
	
	//check to see if robot reached desired distance
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isOnPoint();
	}
	
	//robot does nothing
	@Override
	protected void end() {
		driveMech.doNothing();
	}

	//robot stop if interuptted by something else
	@Override
	protected void interrupted() {
		driveMech.doNothing();
	}
	
	//use encoder value to determine if robot has reached setpoint
	protected boolean isOnPoint()
	{
		if(driveMech.getLeftEncoder().get() == setPoint && driveMech.getRightEncoder().get() == setPoint)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}
