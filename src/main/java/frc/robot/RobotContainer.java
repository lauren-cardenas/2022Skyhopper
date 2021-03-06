// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.Constants.OIConstants;
import frc.robot.Constants.SpeedConstants;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmUp;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.transition;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_robotDrive = new Drivetrain();
  private final Shooter a_shooter = new Shooter();
  private final Intake a_rollerIntake = new Intake();
  private final Arm a_arm = new Arm();
  private final transition a_transition = new transition();


  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  // The driver's controller
  XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort1);
  XboxController m_operatorController = new XboxController(OIConstants.kOperatorControllerPort2);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    /*
    m_robotDrive.setDefaultCommand(
      new RunCommand(() -> m_robotDrive.arcadeDrive(
        m_driverController.getLeftY(),
        m_driverController.getRightX()
      ), m_robotDrive));
    */

    m_robotDrive.setDefaultCommand(
      new RunCommand(() -> m_robotDrive.arcadeDrive(
        m_driverController.getRightTriggerAxis()*SpeedConstants.driveSpeed
           - m_driverController.getLeftTriggerAxis()*SpeedConstants.driveSpeed,
        m_driverController.getLeftX()*SpeedConstants.driveSpeed
      ), m_robotDrive));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_driverController, Button.kRightBumper.value)
    .whenPressed(() -> a_shooter.shoot())
    .whenReleased(() -> a_shooter.shootoff());

    new JoystickButton(m_driverController, Button.kX.value)
    .whenPressed(() -> a_rollerIntake.intake(SpeedConstants.aRollerSpeed))
    .whenReleased(() -> a_rollerIntake.intake(0.0));

    new JoystickButton(m_driverController, Button.kA.value)
    .whenPressed(new ArmUp(a_arm))
    .whenReleased(() -> a_arm.intakeArmStop());

    new JoystickButton(m_driverController, Button.kB.value)
    .whenPressed(new ArmDown(a_arm))
    .whenReleased(() -> a_arm.intakeArmStop());

    new JoystickButton(m_driverController, Button.kY.value)
    .whenPressed(() -> a_transition.transitionRun(SpeedConstants.aTransitionSpeed))
    .whenReleased(() -> a_transition.transitionStop());

    new JoystickButton(m_operatorController, Button.kA.value)
    .whenPressed(new ArmUp(a_arm))
    .whenReleased(() -> a_arm.intakeArmStop());

    new JoystickButton(m_operatorController, Button.kB.value)
    .whenPressed(new ArmDown(a_arm))
    .whenReleased(() -> a_arm.intakeArmStop());

    new JoystickButton(m_operatorController, Button.kY.value)
    .whenPressed(() -> a_transition.transitionRun(SpeedConstants.aTransitionSpeed))
    .whenReleased(() -> a_transition.transitionStop());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
