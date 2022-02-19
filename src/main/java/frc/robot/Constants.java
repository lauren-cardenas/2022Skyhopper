// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int kLeftDrivePort1 = 0;
        public static final int kLeftDrivePort2 = 1;
        public static final int kRightDrivePort1 = 2;
        public static final int kRightDrivePort2 = 3;

        public static final int[] kLeftEncoderPorts = new int[] {0,1};
        public static final int[] kRightEncoderPorts = new int[] {6,7};
        public static final boolean kLeftEncoderReversed = false;
        public static final boolean kRightEncoderReversed = true;

        public static final double kTrackwidthMeters = 1.1;
        public static final DifferentialDriveKinematics kDriveKinematics =
            new DifferentialDriveKinematics(kTrackwidthMeters);

        public static final int kEncoderCPR = 220;
        public static final double kWheelDiameterMeters = 0.16;
        public static final double kEncoderDistancePerPulse =
        // Assumes the encoders are directly mounted on the wheel shafts
            (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;

        // These are example values only - DO NOT USE THESE FOR YOUR OWN ROBOT!
        // These characterization values MUST be determined either experimentally or theoretically
        // for *your* robot's drive.
        // The Robot Characterization Toolsuite provides a convenient tool for obtaining these
        // values for your robot.
        public static final double ksVolts = 1.01;
        public static final double kvVoltSecondsPerMeter = 0.0952;
        public static final double kaVoltSecondsSquaredPerMeter = 0.0201;

        // Example value only - as above, this must be tuned for your drive!
        public static final double kPDriveVel = 0.913;
    }

    public static final class OIConstants {
        public static final int kDriverControllerPort1 = 0;
        public static final int kOperatorControllerPort2 = 1;

    }
    
    public static final class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 6;
    
        // Reasonable baseline values for a RAMSETE follower in units of meters and seconds
        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = 0.7;
    }
    public static final class SpeedConstants{
        public static final double driveSpeed = 1;
        public static final double armSpeed = 0.75;
        public static final double speedMoniter = 1;
        public static final double aArmSpeed = 0.5;
        public static final double aRollerSpeed = 0.5;
        public static final double aTransitionSpeed = 0.5;
        public static final double aHighShootSpeed = 0.7;
        public static final double aLowShootSpeed = 0.4;
        public static final double aRot = 0.75;
    }
    public static final class ArmConstants{
        public static final int armPort = 6;
        public static final int sensorPort1 = 2;
        public static final int sensorPort2 = 8;
    }
    public static final class IntakeMech{
        public static final int intakeport = 7;
    }
    public static final class ShooterClass{
        public static final int shooterportright = 0;
        public static final int shooterportleft = 1;
    }
    public static final class TransitionClass{
        public static final int transtitionPort = 8;
    }
}
