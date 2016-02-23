/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5485.robot.commands;

import org.usfirst.frc.team5485.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Opens the claw for one second. Real robots should use sensors, stalling
 * motors is BAD!
 */
public class ShootBall extends Command {

	public ShootBall() {
		requires(Robot.ballShooter);
		setTimeout(1);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.ballShooter.shoot();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.ballShooter.shoot();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.ballShooter.shotIt();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
