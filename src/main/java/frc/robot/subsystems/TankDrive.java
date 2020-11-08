/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import frc.robot.Constants;
import poroslib.subsystems.DiffDrivetrain;

import edu.wpi.first.wpilibj.SPI;

public class TankDrive extends DiffDrivetrain {
  /**
   * Creates a new TankDrive.
   */
  private WPI_TalonSRX masterLeft;
  private WPI_TalonSRX masterRight;
  private WPI_TalonSRX middleLeft;
  private WPI_TalonSRX middleRight;

  private WPI_VictorSPX rearLeft;
  private WPI_VictorSPX rearRight;

  private AHRS navx;

  public TankDrive() {
    super(new WPI_TalonSRX(Constants.kForwardLeftPort), new WPI_TalonSRX(Constants.kForwardRightPort));
    configMotors();
  }
  
  private void createMotors(){
    this.masterLeft = (WPI_TalonSRX)this.leftController;
    this.masterRight = (WPI_TalonSRX)this.rightController;
    
    this.middleLeft = new WPI_TalonSRX(Constants.kMiddleLeftPort);
    this.middleRight = new WPI_TalonSRX(Constants.kMiddleRightPort);

    this.rearLeft = new WPI_VictorSPX(Constants.kRearLeftPort);
    this.rearRight = new WPI_VictorSPX(Constants.kRearRightPort);
  }

  private void configFollowers(){
    this.middleLeft.follow(this.masterLeft);
    this.middleRight.follow(this.masterRight);

    this.rearLeft.follow(this.masterLeft);
    this.rearRight.follow(this.masterRight);
  }

  private void setNeutralMode(){
    this.masterLeft.setNeutralMode(NeutralMode.Brake);
    this.masterRight.setNeutralMode(NeutralMode.Brake);

    this.middleLeft.setNeutralMode(NeutralMode.Brake);
    this.middleRight.setNeutralMode(NeutralMode.Brake);

    this.rearLeft.setNeutralMode(NeutralMode.Brake);
    this.rearRight.setNeutralMode(NeutralMode.Brake);
  }

  private void setInvertion(){
    this.masterLeft.setInverted(InvertType.None);
    this.masterRight.setInverted(InvertType.None);

    this.middleLeft.setInverted(InvertType.FollowMaster);
    this.middleRight.setInverted(InvertType.FollowMaster);

    this.rearLeft.setInverted(InvertType.FollowMaster);
    this.rearRight.setInverted(InvertType.FollowMaster);
  }

  private void setSensors(){
    this.masterLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    this.masterRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    this.navx = new AHRS(SPI.Port.kMXP);
  }

  private void configMotors(){
    createMotors();
    configFollowers();
    setNeutralMode();
    setInvertion();
    setSensors();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public int getRawLeftPosition() {
    // TODO Auto-generated method stub
    return this.masterLeft.getSelectedSensorPosition();
  }

  @Override
  public int getRawRightPosition() {
    // TODO Auto-generated method stub
    return this.masterRight.getSelectedSensorPosition();
  }

  @Override
  public double getHeading() {
    // TODO Auto-generated method stub
    return this.navx.getYaw();
  }

  /** 
   * get if the bottom elevator limit switch is closed
  */
  public boolean getIsElevatorReverseLimit(){
    return !this.middleLeft.getSensorCollection().isRevLimitSwitchClosed();
  }
}
