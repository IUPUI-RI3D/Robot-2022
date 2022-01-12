// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ShooterSubsystem extends SubsystemBase {
  
  // Shoot motor
  public TalonFX shooterMotor = new TalonFX(Constants.SHOOTER_MOTOR_ID);
  
  /* Functions */
  
  // stop shooter
  public void stopShooter() {
    shooterMotor.set(ControlMode.PercentOutput, 0);
  }

  // shoot ball
  public void shoot() {
    shooterMotor.set(ControlMode.PercentOutput, 0.7);
  }

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
