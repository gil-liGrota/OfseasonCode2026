package frc.robot.subsystems.drive.Transfer;

import org.littletonrobotics.junction.AutoLog;

public interface TransferIO {

  @AutoLog
  public static class TransferIOInputs {
    public double transferVelocityRPM = 0.0; // example of data to record in the log
    public double preShootVelocityRPM = 0.0;
  }

  public default void updateInputs(
      TransferIOInputs inputs) {} // always put this into IOs, the other
  // stuff will use it to update

  public default void setTransferVoltage(double volts) {} // example of a method to put in the IO, the other
  // stuff will expand upon this as needed, its kept empty here

  public default void setPreShootVoltage(double volts) {}

}
