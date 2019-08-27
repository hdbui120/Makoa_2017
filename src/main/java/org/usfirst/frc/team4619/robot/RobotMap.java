package org.usfirst.frc.team4619.robot;

/**
 * The RobotMap is a mapping from the pORTs sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public final static int A = 1;
	public final static int B = 2;
	public final static int X = 3;
	public final static int Y = 4;
	public final static int L_BUMPER = 5;
	public final static int R_BUMPER = 6;
	public final static int BACK = 7;
	public final static int START = 8;	
	public final static int R_TRIGGER = 3;
	public final static int L_TRIGGER = 4;
	
	//this constant is for the logitech button 
	public final static int TRIGGER = 0;
	public final static int BUTTON3 = 3;
	
	public final static int CAN_PORT_0 = 0;
	public final static int CAN_PORT_3 = 3;
	
	//Create PWM Ports
	public final static int PWM_PORT_0 = 0;
	public final static int PWM_PORT_1 = 1;
	public final static int PWM_PORT_2 = 2;
	public final static int PWM_PORT_3 = 3;
	public final static int PWM_PORT_4 = 4;
	public final static int PWM_PORT_5 = 5;
	public final static int PWM_PORT_6 = 6;
	public final static int PWM_PORT_7 = 7;
	public final static int PWM_PORT_8 = 8;
	public final static int PWM_PORT_9 = 9;
	
	//Create DIO Ports
	public final static int DIO_PORT_0 = 0;
	public final static int DIO_PORT_1 = 1;
	public final static int DIO_PORT_2 = 2;
	public final static int DIO_PORT_3 = 3;
	public final static int DIO_PORT_4 = 4;
	public final static int DIO_PORT_5 = 5;
	public final static int DIO_PORT_6 = 6;
	public final static int DIO_PORT_7 = 7;
	public final static int DIO_PORT_8 = 8;
	public final static int DIO_PORT_9 = 9;
	
	//Create Xbox Port
	public final static int XBOX_PORT = 0;
	
	//Create Logitech Port
	public final static int LOGITECH_PORT = 1;
	
	//Created xbox x and y axes values
	public final static int XBOX_XAXIS = 1;
	public final static int XBOX_YAXIS = 4;

}