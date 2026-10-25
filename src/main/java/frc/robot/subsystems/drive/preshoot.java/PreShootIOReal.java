public class PreShootIOReal implements PreShootIO {
    private final TalonFX  = new preshootMotor(null, 0, "preshootMotor",);
    private final TalonFXConfiguration preshootMotorConfig;

    public PreShootIOReal(TalonFX preshootMotor) {
        this.preshootMotor = preshootMotor;
        this.preshootMotorConfig = new TalonFXConfiguration();
    }

    @Override
    public void updateInputs(PreShootIOInputs inputs) {
        inputs.preshootConnected = preshootMotor.isConnected();
        inputs.preshootPositionRad = preshootMotor.getPosition();
        inputs.preshootVelocityRadPerSec = preshootMotor.getVelocity();
        inputs.preshootAppliedVolts = preshootMotor.getAppliedVoltage();
        inputs.preshootCurrentAmps = preshootMotor.getSupplyCurrent();
    }

    @Override
    public void setPreshootVelocity(double velocityRadPerSec) {
        preshootMotor.setVelocity(velocityRadPerSec);
    }

    @Override
    public void setPreshootVoltage(double voltage) {
        preshootMotor.setVoltage(voltage);
    }

    @Override
    public void setPreshootPosition(double positionRad) {
        preshootMotor.setPosition(positionRad);
    }

    @Override
    public void setPreshootPositionClosedLoop(boolean closedLoop) {
        // Implement closed-loop control logic here if needed
    }
}