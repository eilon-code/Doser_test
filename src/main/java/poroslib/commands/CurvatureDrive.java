package poroslib.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;


import edu.wpi.first.wpilibj2.command.CommandBase;
import poroslib.subsystems.DiffDrivetrain;

public class CurvatureDrive extends CommandBase {

  private final DiffDrivetrain drivetrain;
  private final DoubleSupplier throttle;
  private final DoubleSupplier turn;
  private final BooleanSupplier isQuickTurn;
  private final BooleanSupplier isSlowMode;
  
  /**
   * Creates a new ControllerDrive.
   */
  public CurvatureDrive(DiffDrivetrain drivetrain, DoubleSupplier throttle, DoubleSupplier turn, BooleanSupplier isQuickTurn, BooleanSupplier isSlowMode) {
    this.throttle = throttle;
    this.isSlowMode = isSlowMode;
    this.turn = turn;
    this.isQuickTurn = isQuickTurn;
    this.drivetrain = drivetrain;

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // System.out.println(isSlowMode.getAsBoolean());
    if (isSlowMode.getAsBoolean()) {
      this.drivetrain.curvatureDrive(throttle.getAsDouble(), turn.getAsDouble(), isQuickTurn.getAsBoolean(), 0.35);
    } else {
      this.drivetrain.curvatureDrive(throttle.getAsDouble(), turn.getAsDouble(), isQuickTurn.getAsBoolean(), 1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.drivetrain.tankDrive(0, 0, 1);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}