// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterClass;
import frc.robot.Constants.SpeedConstants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  WPI_TalonFX a_shooterleft;
  WPI_TalonFX a_shooterright;
  DifferentialDrive a_shooter;


  public Shooter() {
    a_shooterleft = new WPI_TalonFX(ShooterClass.shooterportleft);
    a_shooterright = new WPI_TalonFX(ShooterClass.shooterportright);
    a_shooterleft.setInverted(true);
    //a_shooter = new DifferentialDrive(a_shooterleft,a_shooterright);
    a_shooterleft.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,0,0);
    a_shooterright.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,0,0);



  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void shoot(){
    System.out.println("setting shooter speed to ");
    System.out.println(SpeedConstants.aLowShootSpeed);
    a_shooterleft.set(SpeedConstants.aLowShootSpeed);
    a_shooterright.set(SpeedConstants.aLowShootSpeed);

    // a_shooter.arcadeDrive(speed,rot);
  }
  public void shootoff(){
    a_shooterleft.set(0.0);
    a_shooterright.set(0.0);

  }
}
