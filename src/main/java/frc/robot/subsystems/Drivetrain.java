// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private VictorSPX leftOne;
  private VictorSPX leftTwo;
  private VictorSPX leftThree;
  private VictorSPX rightOne;
  private VictorSPX rightTwo;
  private VictorSPX rightThree;


  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftOne = new VictorSPX(1);
    leftOne.setInverted(false);

    leftTwo = new VictorSPX(5);
    leftTwo.setInverted(false);

    leftThree = new VictorSPX(2);
    leftThree.setInverted(false);

    rightOne = new VictorSPX(4);
    rightOne.setInverted(false);

    rightTwo = new VictorSPX(0);
    rightTwo.setInverted(false);


    rightThree = new VictorSPX(3);
    rightThree.setInverted(false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("leftFront", leftFront.getMotorOutputPercent());
    // SmartDashboard.putNumber("leftMid", leftMid.getMotorOutputPercent());
    // SmartDashboard.putNumber("leftBack", leftBack.getMotorOutputPercent());
    // SmartDashboard.putNumber("rightFront", rightFront.getMotorOutputPercent());
    // SmartDashboard.putNumber("left speed", RobotContainer.controller.getLeftY());
    // SmartDashboard.putNumber("right speed", RobotContainer.controller.getRightX());

  }

  public void drive(double leftPower, double rightPower){
    leftOne.set(VictorSPXControlMode.PercentOutput, -leftPower);
    leftTwo.set(VictorSPXControlMode.PercentOutput, -leftPower);
    // leftThree.set(VictorSPXControlMode.PercentOutput, -leftPower);
    rightOne.set(VictorSPXControlMode.PercentOutput, -rightPower);
    rightTwo.set(VictorSPXControlMode.PercentOutput, -rightPower);
    // rightThree.set(VictorSPXControlMode.PercentOutput, -rightPower);
  }
}
