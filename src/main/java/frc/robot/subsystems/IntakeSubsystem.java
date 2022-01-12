// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;

public class IntakeSubsystem extends SubsystemBase {

  // instantiate motors
  public PWMTalonFX intakeMotor = new PWMTalonFX(Constants.INTAKE_MOTOR_ID);
  public VictorSPX indexerMotor = new VictorSPX(Constants.INDEXER_MOTOR_ID);

  /* Functions */

  // Stop Intake
  public void stopIntake() {
    intakeMotor.set(0);
    indexerMotor.set(ControlMode.PercentOutput, 0);
  }

  // Intake pull in
  public void intakeIn() {
    intakeMotor.set(-0.3);
    indexerMotor.set(ControlMode.PercentOutput, -0.9);
  }

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
