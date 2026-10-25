public class PreShootIOSim implements PreShootIO {
    private final DCMotorSim preshootSim;

    private boolean isPreshootClosedLoop = false;
    private PIDController preshootPidController =
            new PIDController(PRESHOOT_KP, PRESHOOT_KI, PRESHOOT_KD);
    private double preshootMotorVoltage = 0.0;

    public PreShootIOSim() {
        preshootSim =
                new DCMotorSim(
                        LinearSystemId.createDCMotorSystem(
                                DRIVE_GEARBOX, constants.DriveInertia, constants.DriveMotorGearRatio),
                        constants.DriveMotorGearRatio,
                        constants.DriveWheelRadiusMeters);
    }

    @Override
    public void updateInputs(PreShootIOInputs inputs) {
        preshootSim.setInputVoltage(preshootMotorVoltage);
        preshootSim.update(0.02);
        inputs.preshootPositionRad = preshootSim.getAngularPositionRad();
        inputs.preshootVelocityRadPerSec = preshootSim.getAngularVelocityRadPerSec();
        inputs.preshootAppliedVolts = preshootMotorVoltage;
        inputs.preshootCurrentAmps = preshootSim.getCurrentDrawAmps();
    }
    @Override
    public void setPreshootVelocity(double velocityRadPerSec) {
        isPreshootClosedLoop = true;
        preshootPidController.setSetpoint(velocityRadPerSec);
    }
    @Override
    public void setPreshootVoltage(double voltage) {
        isPreshootClosedLoop = false;
        preshootMotorVoltage = voltage;
    }
    @Override
    public void setPreshootPosition(double positionRad) {
        isPreshootClosedLoop = true;
        preshootPidController.setSetpoint(positionRad);
    }
    @Override
    public void setPreshootPositionClosedLoop(boolean closedLoop) {
        isPreshootClosedLoop = closedLoop;
    }
}