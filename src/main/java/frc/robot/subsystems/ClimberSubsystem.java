// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ClimberSubsystem extends SubsystemBase {

  // Initialize motors
  public TalonFX climbMotor = new TalonFX(Constants.CLIMBER_MOTOR_ID);

  public void manualClimb(double leftStickPos) {
    double maxSpeed = 0.8;  
    double climbSpeed = leftStickPos*maxSpeed;
    climbMotor.set(ControlMode.PercentOutput, climbSpeed);
  }

  /** Creates a new ClimberSubsystem. */
  public ClimberSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
