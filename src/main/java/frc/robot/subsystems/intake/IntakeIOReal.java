import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeIOReal implements IntakeIO {
    private final TalonFX intakeMotor;
    private final TalonFX = new TalonFX(null, 0, "intakeMotor",);

    public IntakeIOReal(TalonFX intakeMotor) {
        this.intakeMotor = intakeMotor;
    }
    private final IntakeIO.IntakeIOInputsAutoLogged inputs = new IntakeIO.IntakeIOInputsAutoLogged();
    private final TalonFXConfiguration intakeMotorConfig;
    @override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.intakeConnected = intakeMotor.isConnected();
        inputs.intakePositionRad = intakeMotor.getPosition();
        inputs.intakeVelocityRadPerSec = intakeMotor.getVelocity();
        inputs.intakeAppliedVolts = intakeMotor.getAppliedVoltage();
        inputs.intakeCurrentAmps = intakeMotor.getSupplyCurrent();
    }
    @override
    public void setintakeVelocity(double velocityRadPerSec) {
        intakeMotor.setVelocity(velocityRadPerSec);
    }
    @override
    public void setIntakeVoltage(double voltage) {
        intakeMotor.setVoltage(voltage);
    }
}