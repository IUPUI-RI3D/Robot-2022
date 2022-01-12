// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyorSubsystem;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class ConveyorIdleCommand extends CommandBase {
  private final ConveyorSubsystem conveyorSubsystem;
  /** Creates a new ConveyorIdleCommand. */
  public ConveyorIdleCommand(final ConveyorSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    conveyorSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    conveyorSubsystem.conveyorMotor.setNeutralMode(NeutralMode.Brake);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conveyorSubsystem.conveyorIdle();
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
