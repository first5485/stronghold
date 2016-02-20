/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5485.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The ballIntake subsystem is a simple system with a motor for opening and
 * closing. If using stronger motors, you should probably use a sensor so that
 * the motors don't stall.
 */
public class BallIntake extends Subsystem {
	private SpeedController motor;
	private DigitalInput contact;

	public BallIntake() {
		super();
		motor = new CANTalon(7);
		contact = new DigitalInput(0);

		// Let's show everything on the LiveWindow
		LiveWindow.addActuator("Ball Intake", "Motor", (Talon) motor);
		LiveWindow.addActuator("Ball Intake", "Ball Ready", contact);
	}

	public void initDefaultCommand() {
	}

	public void log() {
	}

	/**
	 * Set the ballIntake motor to move in the open direction.
	 */
	public void open() {
		motor.set(-1);
	}

	/**
	 * Set the ballIntake motor to move in the close direction.
	 */
	public void close() {
		motor.set(1);
	}

	/**
	 * Stops the ballIntake motor from moving.
	 */
	public void stop() {
		motor.set(0);
	}

	/**
	 * Return true when the robot is grabbing an object hard enough to trigger
	 * the limit switch.
	 */
	public boolean isSucking() {
		return contact.get();
	}
}
