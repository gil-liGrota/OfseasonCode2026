package frc.robot.subsystems.drive.intake;
import edu.wpi.first.wpilibj2.command.SubsystemBase;    
public interface IntakeIO {
    @AutoLog
    public static class IntakeIOInputs {
        public boolean intakeConnected = false;
        public double intakePositionRad = 0.0;
        public double intakeVelocityRadPerSec = 0.0;
        public double intakeAppliedVolts = 0.0;
        public double intakeCurrentAmps = 0.0;
    }
    public default void updateInputs(IntakeIOInputs inputs) {}

    public default void setintakeVelocity(double velocityRadPerSec) {}

    public default void setIntakeVoltage(double voltage) {}
}