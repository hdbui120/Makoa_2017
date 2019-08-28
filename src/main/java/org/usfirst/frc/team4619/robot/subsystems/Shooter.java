package org.usfirst.frc.team4619.robot.subsystems;

import org.usfirst.frc.team4619.robot.RobotMap;
import org.usfirst.frc.team4619.robot.commands.ShootBall;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/*
	This class create and develop shooting mechanism for the robot
	The shooter uses one SIM motor to shoot the ball
	The trajectory is determined by the arc of the ball, which is determined by the speed of the motor
*/

public class Shooter extends Subsystem{	
	
	//declare the motor object, which uses CAN to control 
	CANTalon shooter;

	//Assign the CAN proper id
	int devID = 0;

	//declare PID gains
	double kF = 0;
	double kP = .8;
	double kI = .2;
	double kD = .5;
	double profile = 0;
	double nominalOutPut = 0;
	double peakOutPut = 12;
	double speed;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//this default method calls the shootball command with parameter as motor rpm
		//11000 should be default (original rpm -10%)
		setDefaultCommand(new ShootBall(11000));
	}
	
	//constructor that initialize PID control and shooting motor
	public Shooter() {
		shooter = new CANTalon(devID);
		shooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooter.configNominalOutputVoltage(nominalOutPut, nominalOutPut);
		shooter.configPeakOutputVoltage(peakOutPut, peakOutPut);
		shooter.setProfile(0);
		shooter.setF(kF);
		shooter.setP(kP);
		shooter.setI(kI);
		shooter.setD(kD);
	}
	
	//method that makes motor spin at specify rpm to shoot
	public void Shoot(double speed) {
		//maximum rpm is 13180 +/- 10%
		this.speed = speed;
		shooter.changeControlMode(TalonControlMode.Speed);
		shooter.set(speed);
	}
	
	//motor does not spin
	public void doNothing() {
		shooter.changeControlMode(TalonControlMode.Speed);
		shooter.set(0);
	}
}
