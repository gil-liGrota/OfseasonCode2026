public interface PreShootIO{
    @AutoLog
    public static class PreShootIOInputs {
        public boolean preshootConnected = false;
        public double preshootPositionRad = 0.0;
        public double preshootVelocityRadPerSec = 0.0;
        public double preshootAppliedVolts = 0.0;
        public double preshootCurrentAmps = 0.0;
    }
    public default void updateInputs(PreShootIOInputs inputs) {}

    public default void setPreshootVelocity(double velocityRadPerSec) {}

    public default void setPreshootVoltage(double voltage) {}

    public default void setPreshootPosition(double positionRad) {}

    public default void setPreshootPositionClosedLoop(boolean closedLoop) {}
}