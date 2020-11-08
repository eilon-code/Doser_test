/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Feeder port
    public final static int kFeederPort = 0;
    
    // FeederArm port
    public final static int kFeederArmPort = 3;
    
    // Elevator port
    public final static int kElevatorPort = 2;

    // Tank Drive ports
    public final static int kForwardLeftPort = 0;
    public final static int kForwardRightPort = 1;
    public final static int kMiddleLeftPort = 5;
    public final static int kMiddleRightPort = 6;
    public final static int kRearLeftPort = 1;
    public final static int kRearRightPort = 3;
}
