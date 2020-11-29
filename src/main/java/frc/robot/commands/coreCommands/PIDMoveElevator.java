/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.coreCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class PIDMoveElevator extends CommandBase {
  /**
   * Creates a new ActivateFeeder.
   */
  private final Elevator elevator;

  // private final double power;
  private final int tolerance;
  private final int targetPos;

  private final double kp;
  private final double ki;
  private final double kd;
  private final double kf;

  public PIDMoveElevator(Elevator elevator, int targetPos, double kp, double ki, double kd, double kf, int tolerance) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.elevator = elevator;
    this.targetPos = targetPos;
    this.tolerance = tolerance;
    this.kp = kp;
    this.ki = ki;
    this.kd = kd;
    this.kf = kf;
    addRequirements(this.elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.elevator.configPIDSlot(this.kp, this.ki, this.kd, this.kf, this.elevator.getPIDSlotID());
    this.elevator.setPosition(this.targetPos);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(this.elevator.getPosition() - this.targetPos) < this.tolerance;
  }
}
