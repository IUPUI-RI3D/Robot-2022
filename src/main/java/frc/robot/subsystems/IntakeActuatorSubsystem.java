// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
/* import edu.wpi.first.wpilibj.Solenoid; */
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class IntakeActuatorSubsystem extends SubsystemBase {
  
  // Instantiate solenoids
  public DoubleSolenoid intakeActuator = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_ACT_SOLENOID_A, Constants.INTAKE_ACT_SOLENOID_B);

  // lower intake
  public void lowerIntake() {
    intakeActuator.set(Value.kForward);
  }

  // raise intake
  public void raiseIntake() {
    intakeActuator.set(Value.kReverse);
  }

  // hold intake in place
  public void intakeIdle() {
    intakeActuator.set(Value.kOff);
  }
  
  /** Creates a new IntakeActuatorSubsystem. */
  public IntakeActuatorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
