// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /* Controller IDs */

    // Drive Base IDs - CAN
    public static int DRIVE_RIGHT_FRONT_ID = 1;
    public static int DRIVE_RIGHT_BACK_ID = 2;
    public static int DRIVE_LEFT_FRONT_ID = 3;
    public static int DRIVE_LEFT_BACK_ID = 4;

    // Climber ID - CAN
    public static int CLIMBER_MOTOR_ID = 5;

    // Intake Actuator IDs
    public static int INTAKE_ACT_SOLENOID_A = 2;
    public static int INTAKE_ACT_SOLENOID_B = 3;

    // Intake IDs
    public static int INTAKE_MOTOR_ID = 9; // PWM
    public static int INDEXER_MOTOR_ID = 6; // CAN

    // Conveyor IDs
    public static int CONVEYOR_MOTOR_ID = 7;
    public static int SENSOR_ID = 0;    

    // Shooter IDs - CAN
    public static int SHOOTER_MOTOR_ID = 8;
    

    /* BUTTON IDS */

    // Joystick Axes
    public static int LEFT_STICK_AXIS = 1;
    public static int RIGHT_STICK_AXIS = 5;

    // Trigger Axes
    public static int LTRIGGER_AXIS = 2;
    public static int RTRIGGER_AXIS = 3;

    // Letter Buttons
    public static int BUTTON_A_ID = 1;
    public static int BUTTON_B_ID = 2;
    public static int BUTTON_X_ID = 3;
    public static int BUTTON_Y_ID = 4;

    // Bumper buttons
    public static int LBUMPER_ID = 5;
    public static int RBUMPER_ID = 6;

    // Center buttons
    public static int BACK_ID = 7;
    public static int START_ID = 8;

    // Joystick Buttons
    public static int LEFT_STICK_ID = 9;
    public static int RIGHT_STICK_ID = 10;

}
