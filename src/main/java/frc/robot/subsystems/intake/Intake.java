package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drive.intake.IntakeIO;
import frc.robot.subsystems.drive.intake.IntakeIOInputsAutoLogged;
import org.littletonrobotics.junction.Logger;

public class Intake extends SubsystemBase {
    private final IntakeIO io;
    private final IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();

    public Intake(IntakeIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake", inputs);

        if (DriverStation.isDisabled()) {
            stop();
        }
    }

    public void setVelocity(double velocityRadPerSec) {
        io.setintakeVelocity(velocityRadPerSec);
    }

    public void setVoltage(double voltage) {
        io.setIntakeVoltage(voltage);
    }

    public void stop() {
        io.setIntakeVoltage(0.0);
    }

    public double getPositionRad() {
        return inputs.intakePositionRad;
    }

    public double getVelocityRadPerSec() {
        return inputs.intakeVelocityRadPerSec;
    }
}