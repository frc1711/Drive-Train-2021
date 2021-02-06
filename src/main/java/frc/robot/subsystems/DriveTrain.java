package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  
  private WPI_TalonSRX flTalon, frTalon, blTalon, brTalon;
  private SpeedControllerGroup left, right;
  private DifferentialDrive diffDrive;
  
  public DriveTrain () {
    flTalon = new WPI_TalonSRX(Constants.flTalon);
    frTalon = new WPI_TalonSRX(Constants.frTalon);
    blTalon = new WPI_TalonSRX(Constants.blTalon);
    brTalon = new WPI_TalonSRX(Constants.brTalon);
    
    left = new SpeedControllerGroup(flTalon, blTalon);
    right = new SpeedControllerGroup(frTalon, brTalon);
    
    diffDrive = new DifferentialDrive(left, right);
    diffDrive.setSafetyEnabled(false);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  
  public void arcadeDrive (double forward, double rotation) {
    diffDrive.arcadeDrive(forward, rotation);
  }
  
  public void stop () {
    left.set(0);
    right.set(0);
  }
  
}