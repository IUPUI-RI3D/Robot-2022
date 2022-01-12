// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.lang.Math;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class DriveBaseSubsystem extends SubsystemBase {

  /* Initialize DriveBase motors */

  // Left motors
  public CANSparkMax leftLead = new CANSparkMax(Constants.DRIVE_LEFT_FRONT_ID, MotorType.kBrushless);
  public CANSparkMax leftFollower = new CANSparkMax(Constants.DRIVE_LEFT_BACK_ID, MotorType.kBrushless);
  
  // Right motors
  public CANSparkMax rightLead = new CANSparkMax(Constants.DRIVE_RIGHT_FRONT_ID, MotorType.kBrushless);
  public CANSparkMax rightFollower = new CANSparkMax(Constants.DRIVE_RIGHT_BACK_ID, MotorType.kBrushless);


  /* Methods */

  // Tank drive method for tele-op
  public void tankDrive(double leftStickPos, double rightStickPos, double maxSpeed) {
    // apply drive curve (cubic) - x^3
    double leftSpeed = Math.pow(leftStickPos, 3);
    double rightSpeed = Math.pow(rightStickPos, 3);

    // Set lead motor values based on joystick positions, with a max value
    double leftDrive = leftSpeed*maxSpeed;
    double rightDrive = rightSpeed*maxSpeed;

    // Set lead motor speeds
    leftLead.set(-leftDrive);
    rightLead.set(rightDrive);
  }

  public void arcadDrive(double leftStickPos, double rightStickPos, double maxSpeed) {
    // Set speed 
    double drivePower = Math.pow(leftStickPos, 3);

    // Apply left-right modifier based on right stick x-axis - adjust multiplier for faster/slower turning
    double leftDrive = drivePower + rightStickPos*0.5;
    double rightDrive = drivePower - rightStickPos*0.5;

    // Set lead motor values based on joystick positions, with a max value
    leftDrive = leftDrive*maxSpeed;
    rightDrive = rightDrive*maxSpeed;

    // Create dead zone (due to joystick drift)
    if(leftDrive > 0) {
      if(leftDrive < 0.05) {
        leftDrive = 0;
      }
    }

    if(leftDrive < 0) {
      if(leftDrive > -0.05) {
        leftDrive = 0;
      }
    }

    if(rightDrive > 0) {
      if(rightDrive < 0.05) {
        rightDrive = 0;
      }
    }

    if(rightDrive < 0) {
      if(rightDrive > -0.05) {
        rightDrive = 0;
      }
    }

    // set motor speeds
    leftLead.set(leftDrive);
    rightLead.set(-rightDrive);
  }

  /** Creates a new DriveBaseSubsystem. */
  public DriveBaseSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
