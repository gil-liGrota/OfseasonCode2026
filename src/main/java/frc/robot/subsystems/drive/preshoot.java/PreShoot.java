public class Preshooter extends SubsystemBase {
    private final PreShootIO preShootIO;
    private final PreShootIO.PreShootIOInputs inputs = new PreShootIO.PreShootIOInputs();

    public Preshooter(PreShootIO preShootIO) {
        this.preShootIO = preShootIO;
    }

    @Override
    public void periodic() {
        preShootIO.updateInputs(inputs);
    }

    public void setPreshootVelocity(double velocityRadPerSec) {
        preShootIO.setPreshootVelocity(velocityRadPerSec);
    }

    public void setPreshootVoltage(double voltage) {
        preShootIO.setPreshootVoltage(voltage);
    }

    public void setPreshootPosition(double positionRad) {
        preShootIO.setPreshootPosition(positionRad);
    }

    public void setPreshootPositionClosedLoop(boolean closedLoop) {
        preShootIO.setPreshootPositionClosedLoop(closedLoop);
    }
}