package org.usfirst.frc.team4619.robot.subsystems;

import org.usfirst.frc.team4619.robot.RobotMap;
import org.usfirst.frc.team4619.robot.commands.DriveJoystick;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
	This class create the drive base of the robot
	The drive base is tank drive style
	There are 2 type of sensors to control the movemennt of the drive base: encoder and gyroscope
	encoder for exact distance measurements
	gyro for angle measurements to control turn
*/

public class DriveBase extends Subsystem
{	
	//initialize 4 motors that drive the robot
	private VictorSP frontL = new VictorSP(RobotMap.PWM_PORT_3);
	private VictorSP backL = new VictorSP(RobotMap.PWM_PORT_2);
	private VictorSP frontR = new VictorSP(RobotMap.PWM_PORT_1);
	private VictorSP backR = new VictorSP(RobotMap.PWM_PORT_0);

	//declare encoder sensors for both sides to match the rotations
	private Encoder rightEncoder;
	private Encoder leftEncoder;

	//declare gyroscope
	public ADXRS450_Gyro gyro;

	//initialize the P-I-D gains
	private final static double p = 2;
	private final static double i = .75;
	private final static double d = 1;
	
	//declare the drive train object
	public RobotDrive driveTrain;
	
	//constructor that initialize all the objects and set the drive train control behavior
	public DriveBase() {
		rightEncoder = new Encoder(2, 3, false);
		leftEncoder = new Encoder(0, 1, true);
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		frontL.setInverted(true);
		backL.setInverted(true);
		frontR.setInverted(true);
		backR.setInverted(true);
	    driveTrain = new RobotDrive(frontL, backL, frontR, backR);
	}
	
	//declare the speed of the drive train = 0
	private double noVector = 0;
	
	//method that specify the controlling style of the drive train
	public void arcadeDrive(double y, double x)
	{
		driveTrain.arcadeDrive(y, x, true);
	}
	
	//default command for the drive train enables manual control from joystick
	@Override
	protected void initDefaultCommand() 
	{
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveJoystick());
	} 
	
	//method that stop the drive train from doing anything
	public void doNothing()
	{
		frontL.set(noVector);
	}
	
	//move forward at 75%
	public void moveForward() 
	{
		moveForward(0.75);
	}
	
	//move forward at the speed of parameter input
	public void moveForward(double speed)
	{
		frontL.set(speed);
		frontR.set(-speed);
		backL.set(speed);
		backR.set(-speed);
	}

	//move back at 75%
	public void moveBack() 
	{
		moveBack(.75);
	}
	
	//move back at the speed of parameter input
	public void moveBack(double speed)
	{
		frontL.set(-speed);
		frontR.set(speed);
		backL.set(-speed);
		backR.set(speed);
	}
	
	//turn left at 75%
	public void turnL()
	{
		turnL(.75);
	}
	
	//improvisation due to encoder break down
	//right side needs to rotate slower to match the rotation of the left side
	public void forwardMod(double speed)
	{
		frontL.set(-speed);
		frontR.set(speed*.965);
		backL.set(-speed);
		backR.set(speed*.965);
	}
	
	//turn left at the speed of parameter input
	public void turnL(double speed) 
	{
		frontL.set(-speed);
		frontR.set(-speed);
		backL.set(-speed);
		backR.set(-speed);
	}

	//turn right at 75%
	public void turnR()
	{
		turnR(.75);
	}
	
	//turn right at the speed of parameter input
	public void turnR(double speed) 
	{
		frontL.set(speed);
		frontR.set(speed);
		backL.set(speed);
		backR.set(speed);
	}

	//get method that return the right encoder
	public Encoder getRightEncoder() {
		return rightEncoder;
	}

	//get method that return the left encoder
	public Encoder getLeftEncoder()
	{
		return leftEncoder;
	}
	
}
