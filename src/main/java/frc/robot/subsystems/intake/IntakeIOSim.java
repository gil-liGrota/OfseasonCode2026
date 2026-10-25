package frc.robot.subsystems.drive.intake;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.swerve.SwerveModuleConstants;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class IntakeIOSim implements IntakeIO {}
    private final DCMotorSim intakeSim;

    private boolean isIntakeClosedLoop = false;
    private PIDController intakePidController =
            new PIDController(INTAKE_KP, INTAKE_KI, INTAKE_KD);
    private double intakeMotorVoltage = 0.0;

    public IntakeIOSim() {
        intakeSim =
            new DCMotorSim(LinearSystemId.createDCMotorSystem(
                DRIVE_GEARBOX, constants.DriveInertia, constants.DriveMotorGearRatio),
            DRIVE_GEARBOX)
    }

@override
    public void updateInputs(IntakeIOInputs inputs) {
        intakeSim.setInputVoltage(intakeMotorVoltage);
        intakeSim.update(0.02);
        inputs.intakePositionRad = intakeSim.getAngularPositionRad();
        inputs.intakeVelocityRadPerSec = intakeSim.getAngularVelocityRadPerSec();
        inputs.intakeAppliedVolts = intakeMotorVoltage;
        inputs.intakeCurrentAmps = intakeSim.getCurrentDrawAmps();
        }
    @Override
    public void setintakeVelocity(double velocityRadPerSec) {
        isIntakeClosedLoop = true;
        intakePidController.setSetpoint(velocityRadPerSec);
        }
    @override
    public void setIntakeVoltage(double voltage) {
        isIntakeClosedLoop = false;
        intakeMotorVoltage = voltage;
        }
    