// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
  
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private DriveTrain driveTrain;
  private DoubleSupplier forward, rotation;
  
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(DriveTrain subsystem, DoubleSupplier forw, DoubleSupplier rota) {
    driveTrain = subsystem;
    addRequirements(subsystem);
    forward = forw;
    rotation = rota;
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.stop();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(-1 * forward.getAsDouble() * Constants.speed,
        rotation.getAsDouble() * Constants.speed);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}