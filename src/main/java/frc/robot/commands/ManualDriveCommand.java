// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveBaseSubsystem;

public class ManualDriveCommand extends CommandBase {

  // Create an instance of the subsystem we created
  private final DriveBaseSubsystem driveBaseSubsystem;

  /** Creates a new ManualDriveCommand. */
  public ManualDriveCommand(final DriveBaseSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveBaseSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { // Set intitial values here (motor settings, etc.)

    // Sets all drive motors to coast (as apposed to brake mode)
    driveBaseSubsystem.leftLead.setIdleMode(IdleMode.kCoast);
    driveBaseSubsystem.leftFollower.setIdleMode(IdleMode.kCoast);
    driveBaseSubsystem.rightLead.setIdleMode(IdleMode.kCoast);
    driveBaseSubsystem.rightFollower.setIdleMode(IdleMode.kCoast);

    // Sets middle and back motor controllers to mirror their leaders (leader-follower method)
    driveBaseSubsystem.leftFollower.follow(driveBaseSubsystem.leftLead);
    driveBaseSubsystem.rightFollower.follow(driveBaseSubsystem.rightLead);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double maxSpeed = 0.5;
    driveBaseSubsystem.arcadDrive(RobotContainer.getLeftStick(), RobotContainer.getRightStickXAxis(), maxSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
