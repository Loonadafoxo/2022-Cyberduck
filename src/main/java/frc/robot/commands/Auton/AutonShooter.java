// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class AutonShooter extends CommandBase {
  private final Shooter shooter;
  private Timer autonTimer;
  /** Creates a new AutonShooter. */
  public AutonShooter(Shooter shooter) {
    this.shooter = shooter;
    addRequirements(this.shooter);
    autonTimer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autonTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(autonTimer.get() > 2){
      shooter.powerShooter(.75);
    }
    if(autonTimer.get() > 6){
      shooter.powerShooter(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
