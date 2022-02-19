// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.MechConstants;
import frc.robot.Constants.TransitionClass;

public class transition extends SubsystemBase {
  /** Creates a new transition. */
  WPI_VictorSPX a_transition;
  public transition() {
    a_transition = new WPI_VictorSPX(TransitionClass.transtitionPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void transitionRun(double speed) {
    System.out.println("Setting transition speed to ");
    System.out.println(speed);
    a_transition.set(speed);
  }
  public void transitionStop(){
    a_transition.set(0);
  }
}
