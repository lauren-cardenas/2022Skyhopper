// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import static frc.robot.Constants.ArmConstants.sensorPort2;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.SpeedConstants;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  WPI_VictorSPX a_arm;

  DigitalInput armSwitchDown = new DigitalInput(ArmConstants.sensorPort1);
  DigitalInput armSwitchUp = new DigitalInput(ArmConstants.sensorPort2);
  public Arm() {
    a_arm = new WPI_VictorSPX(ArmConstants.armPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void intakeDown(){
    a_arm.set(-SpeedConstants.armSpeed);
  }
  public void intakeUp(){
    a_arm.set(SpeedConstants.armSpeed);
  }
  public void intakeArmStop(){
    a_arm.set(0);
  }
  public boolean getstatusUp(){
    return armSwitchUp.get();
  }
  public boolean getstatusDown(){
    return armSwitchDown.get();
  }
}
