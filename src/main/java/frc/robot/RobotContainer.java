// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

// Drive Components
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.commands.ManualDriveCommand;
import frc.robot.commands.ManualDriveBoostCommand;

// Climber Components
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.commands.ClimberClimbCommand;

// Intake Components
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.IntakeStopCommand;

// Shooter Components
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.ShooterStopCommand;
import frc.robot.commands.ShooterShootCommand;

// Intake Actuator Components
import frc.robot.subsystems.IntakeActuatorSubsystem;
import frc.robot.commands.HoldIntakeCommand;
import frc.robot.commands.RaiseIntakeCommand;
import frc.robot.commands.LowerIntakeCommand;

// Conveyor Components
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.commands.ConveyorStopCommand;
import frc.robot.commands.ConveyorRunCommand;

// Command Groups
import frc.robot.commands.PickUpBallCommandGroup;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Drive Base components
  private final DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  private final ManualDriveCommand manualDriveCommand = new ManualDriveCommand(driveBaseSubsystem);
  private final ManualDriveBoostCommand manualDriveBoostCommand = new ManualDriveBoostCommand(driveBaseSubsystem);

  // Intake Components
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final IntakeStopCommand intakeStopCommand = new IntakeStopCommand(intakeSubsystem);
  // private final IntakeInCommand intakeInCommand = new IntakeInCommand(intakeSubsystem);


  // Shooter Components
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ShooterStopCommand shooterStopCommand = new ShooterStopCommand(shooterSubsystem);
  private final ShooterShootCommand shooterShootCommand = new ShooterShootCommand(shooterSubsystem);


  // Climber Components
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  private final ClimberClimbCommand climberClimbCommand = new ClimberClimbCommand(climberSubsystem);

  // Intake Actuator Components
  private final IntakeActuatorSubsystem intakeActuatorSubsystem = new IntakeActuatorSubsystem();
  private final HoldIntakeCommand holdIntakeCommand = new HoldIntakeCommand(intakeActuatorSubsystem);
  private final RaiseIntakeCommand raiseIntakeCommand = new RaiseIntakeCommand(intakeActuatorSubsystem);
  private final LowerIntakeCommand lowerIntakeCommand = new LowerIntakeCommand(intakeActuatorSubsystem);

  // Conveyor Components
  private final ConveyorSubsystem conveyorSubsystem = new ConveyorSubsystem();
  private final ConveyorStopCommand ConveyorStopCommand = new ConveyorStopCommand(conveyorSubsystem);
  // private final ConveyorIdleCommand conveyorIdleCommand = new ConveyorIdleCommand(conveyorSubsystem);
  private final ConveyorRunCommand conveyorRunCommand = new ConveyorRunCommand(conveyorSubsystem);

  // Command Groups
  private final PickUpBallCommandGroup pickUpBallCommandGroup = new PickUpBallCommandGroup(intakeSubsystem, conveyorSubsystem);

  // set up joystick controllers
  public static Joystick driveJoystick = new Joystick(0);
  public static Joystick operatorJoystick = new Joystick(1);

  // Buttons
  public static JoystickButton buttonA = new JoystickButton(driveJoystick, Constants.BUTTON_A_ID);
  public static JoystickButton rBumper = new JoystickButton(driveJoystick, Constants.RBUMPER_ID);
  public static JoystickButton lBumper = new JoystickButton(driveJoystick, Constants.LBUMPER_ID);

  // Operator
  public static JoystickButton rBumperOperator = new JoystickButton(operatorJoystick, Constants.RBUMPER_ID);
  public static JoystickButton lBumperOperator = new JoystickButton(operatorJoystick, Constants.LBUMPER_ID);
  public static JoystickButton buttonAOperator = new JoystickButton(operatorJoystick, Constants.BUTTON_A_ID);

  // returns the value of the left stick y-axis on a logitech controller
  public static double getLeftStick() {
    return driveJoystick.getRawAxis(Constants.LEFT_STICK_AXIS);
  }

  // returns the value of the right stick y-axis on a logitech controller
  public static double getRightStick() {
    return driveJoystick.getRawAxis(Constants.RIGHT_STICK_AXIS);
  }

  public static double getRightStickXAxis() {
    return driveJoystick.getRawAxis(4);
  }

  public static double getOperatorLeftStick() {
    return operatorJoystick.getRawAxis(Constants.LEFT_STICK_AXIS);
  }

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    driveBaseSubsystem.setDefaultCommand(manualDriveCommand);
    intakeActuatorSubsystem.setDefaultCommand(holdIntakeCommand);
    intakeSubsystem.setDefaultCommand(intakeStopCommand);
    conveyorSubsystem.setDefaultCommand(ConveyorStopCommand);
    shooterSubsystem.setDefaultCommand(shooterStopCommand);
    climberSubsystem.setDefaultCommand(climberClimbCommand);
    configureButtonBindings();
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Boost Drive
    rBumper.whenHeld(manualDriveBoostCommand);

    // lower Intake
    rBumperOperator.whenPressed(lowerIntakeCommand);

    // raisge Intake
    lBumperOperator.whenPressed(raiseIntakeCommand);

    // Pick up balls
    lBumper.whenHeld(pickUpBallCommandGroup);

    // run fly wheel
    buttonAOperator.whenHeld(shooterShootCommand);

    // run conveyor
    buttonA.whenHeld(conveyorRunCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return manualDriveCommand;
    // return autoCoreCommandGroup();
  }
}
