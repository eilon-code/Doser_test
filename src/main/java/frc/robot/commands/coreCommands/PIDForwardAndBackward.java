/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.coreCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TankDrive;

public class PIDForwardAndBackward extends CommandBase {
  /**
   * Creates a new PIDForwardAndBackward.
   */
  private TankDrive driveTrain;

  private final int tolerance;
  private final int distance;
  private int endPosition;

  private final double kp;
  private final double ki;
  private final double kd;
  private final double kf;

  public PIDForwardAndBackward(TankDrive driveTrain, int distance, double kp, double ki, double kd, double kf, int tolerance) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.distance = distance;
    this.tolerance = tolerance;
    this.kp = kp;
    this.ki = ki;
    this.kd = kd;
    this.kf = kf;
    addRequirements(this.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.endPosition = this.driveTrain.getRawLeftPosition() + this.distance;
    
    this.driveTrain.configPIDSlot(this.kp, this.ki, this.kd, this.kf, this.driveTrain.getPIDSlotID());
    this.driveTrain.setLeftPosition(this.driveTrain.getRawLeftPosition());
    this.driveTrain.setRightPosition(this.driveTrain.getRawLeftPosition());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.driveTrain.StopSystem();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(this.driveTrain.getRawLeftPosition() - this.endPosition) < this.tolerance;
  }
}
