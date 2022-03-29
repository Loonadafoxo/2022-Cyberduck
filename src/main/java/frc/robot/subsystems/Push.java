// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Push extends SubsystemBase {
  private VictorSPX push;
  /** Creates a new Stop. */
  public Push() {
    push = new VictorSPX(8);
    push.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void powerPush(double power){
    push.set(VictorSPXControlMode.PercentOutput, power);
  }
}
