// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;

public class ConveyorSubsystem extends SubsystemBase {

  // initialize conveyor motor
  public VictorSPX conveyorMotor = new VictorSPX(Constants.CONVEYOR_MOTOR_ID);
  // initialize sensor
  public DigitalInput entranceSensor = new DigitalInput(Constants.SENSOR_ID);

  // if sensor is true, then stop conveyor
  public void conveyorIdle() {
    if(!entranceSensor.get()) {
      conveyorMotor.set(ControlMode.PercentOutput, 0);
    }
    else {
      conveyorMotor.set(ControlMode.PercentOutput, -0.6);
    }
  }

  // run conveyor
  public void runConveyor() {
    conveyorMotor.set(ControlMode.PercentOutput, -1);
  }

  //stop conveyor
  public void stopConveyor() {
    conveyorMotor.set(ControlMode.PercentOutput, 0);
  }

  /** Creates a new ConveyorSubsystem. */
  public ConveyorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
