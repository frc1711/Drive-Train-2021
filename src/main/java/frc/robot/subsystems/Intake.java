// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private WPI_TalonSRX intakeTalon;

  /** Creates a new Intake. */
  public Intake() {
    intakeTalon = new WPI_TalonSRX(Constants.intake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    intakeTalon.set(0); 
  }

  public void run(double speed) {
    intakeTalon.set(speed); 
  }
}
