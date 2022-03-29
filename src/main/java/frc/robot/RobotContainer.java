// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Triggers.LeftTriggerDown;
import frc.robot.Triggers.LeftTriggerUp;
import frc.robot.Triggers.RightTriggerDown;
import frc.robot.Triggers.RightTriggerUp;
import frc.robot.commands.Climb.IdleClimb;
import frc.robot.commands.Climb.LowerClimb;
import frc.robot.commands.Climb.RaiseClimb;
import frc.robot.commands.Drivetrain.Drive;
import frc.robot.commands.ShooterBuild.Intake.IdleIntake;
import frc.robot.commands.ShooterBuild.Intake.IntakeActive;
import frc.robot.commands.ShooterBuild.Intake.IntakeReverse;
import frc.robot.commands.ShooterBuild.Shooter.IdlePushing;
import frc.robot.commands.ShooterBuild.Shooter.IdleShoot;
import frc.robot.commands.ShooterBuild.Shooter.Pushing;
import frc.robot.commands.ShooterBuild.Shooter.Shoot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Push;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public final Drivetrain m_drivetrain;
  public final Intake m_intake;
  public final Climb m_climb;
  public final Push m_push;
  public final Shooter m_shooter;


  public static final XboxController controller = new XboxController(0);

  //Don't worry about these
  private Trigger rightTriggerDown = new RightTriggerDown(controller);
  private Trigger leftTriggerDown = new LeftTriggerDown(controller);
  private Trigger rightTriggerUp = new RightTriggerUp(controller);
  private Trigger leftTriggerUp = new LeftTriggerUp(controller);

  public RobotContainer() {
    //Defining the subsystems
    m_drivetrain = new Drivetrain();
    m_intake = new Intake();
    m_climb = new Climb();
    m_push = new Push();
    m_shooter = new Shooter();

    //If no code is saying otherwise, the drivetrain will listen to the controller, arms will not move, the shooter will not move, and the climb will not climb
    m_drivetrain.setDefaultCommand(new Drive(m_drivetrain, controller));
    m_shooter.setDefaultCommand(new IdleShoot(m_shooter));
    m_climb.setDefaultCommand(new IdleClimb(m_climb));
    m_push.setDefaultCommand(new IdlePushing(m_push));

    //sets the controls
    configureButtonBindings();
  }

  //controls are set here
  private void configureButtonBindings() {

    //Lower climb
    new Button(controller::getAButton).whenHeld(new LowerClimb(m_climb));

    //Raise climb
    new Button(controller::getYButton).whenHeld(new RaiseClimb(m_climb));

    //Activates shooter    
    leftTriggerDown.whenActive(new Shoot(m_shooter));

    //Stops shooter
    leftTriggerUp.whenActive(new IdleShoot(m_shooter));

    //Pushes balls to shooter
    rightTriggerDown.whenActive(new Pushing(m_push));

    //Stops push
    rightTriggerUp.whenActive(new IdlePushing(m_push));

    //Activates intake
    new Button(controller::getLeftBumper).whenHeld(new IntakeActive(m_intake));

    //Stops intake
    new Button(controller::getLeftBumper).whenReleased(new IdleIntake(m_intake));

    //Activates intake reverse
    new Button(controller::getRightBumper).whenHeld(new IntakeReverse(m_intake));

    //Stops intake reverse
    new Button(controller::getRightBumper).whenReleased(new IdleIntake(m_intake));
  }

}
