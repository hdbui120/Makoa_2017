package org.usfirst.frc.team4619.robot.subsystems;

import org.usfirst.frc.team4619.robot.RobotMap;
import org.usfirst.frc.team4619.robot.commands.StopClimb;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
	This class construct the climber mechanism 
	The climber is used at the end of the match to get the final points
	The climber uses two mini-SIM motor to climb
	It stops when the limit switch is activated
*/

public class Climber extends Subsystem
{
	//declare essetial objects for climber mechanism
	//1 limit switch, 2 victor motor, and 2 variables to control the motors
	private static DigitalInput limitSwitch;
	private static VictorSP motor;
	private static VictorSP motor2;
	double climbSpeed;
	double zeroSpeed = 0;
	

	protected void initDefaultCommand() 
	{
		// TODO Auto-generated method stub
		//set the default state to doing nothing, climb speed = 0
		setDefaultCommand(new StopClimb());
	}	
	
	//constructor that initialize motors and limit switch
	public Climber()
	{
		motor = new VictorSP(RobotMap.PWM_PORT_4);
		motor2 = new VictorSP(RobotMap.PWM_PORT_6);
		limitSwitch = new DigitalInput(4);
	}
	
	//get method for acquiring the limitSwitch
	public DigitalInput getLimitSwitch()
	{
		return limitSwitch;
	}
	
	//get method for acquiring motor 1
	public VictorSP getMotor()
	{
		return motor;
	}
	
	//get method for acquiring motor 2
	public VictorSP getMotor2()
	{
		return motor2;
	}
	
	//make climber climbs at parameter input speed
	public void Climb(double climbSpeed)
	{
		this.climbSpeed = climbSpeed;
			motor.set(-climbSpeed);
			motor2.set(climbSpeed);
	}
	
	//make the climber do nothing
	public void StopClimb()
	{
		motor.set(zeroSpeed);
		motor2.set(zeroSpeed);
	}
	
	//make the climber do nothing
	public void doNothing() 
	{
		motor.set(zeroSpeed);
		motor2.set(zeroSpeed);
	}
}
