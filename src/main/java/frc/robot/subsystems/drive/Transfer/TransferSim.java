package frc.robot.subsystems.drive.Transfer;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class TransferSim implements TransferIO{

    //first number is the inertia (in kg*m^2)
    //secound number is the gear ratio, need to find what they need to be, these are placeholders
    private final DCMotorSim transferSim = new DCMotorSim(
        LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 0.004, 1.0),
        DCMotor.getNEO(1));

    private final DCMotorSim preShootSim = new DCMotorSim(
        LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 0.002, 1.0),
        DCMotor.getNEO(1));

    private double transferAppliedVolts = 0.0;
    private double preShootAppliedVolts = 0.0;
    

    @Override
    public void updateInputs(TransferIOInputs inputs){
        //find out how big dtSeconds(update time) needs to be
        transferSim.update(0.02);
        preShootSim.update(0.02);

        inputs.transferVelocityRPM = transferSim.getAngularVelocityRPM();
        inputs.preShootVelocityRPM = preShootSim.getAngularVelocityRPM();
    }

    @Override
    public void setTransferVoltage(double volts){
        //find out what the clamp thing is
        transferAppliedVolts = MathUtil.clamp(volts, -12.0, 12.0);
        transferSim.setInputVoltage(transferAppliedVolts);
    }

    @Override
    public void setPreShootVoltage(double volts){
        preShootAppliedVolts = MathUtil.clamp(volts, -12.0, 12.0);
        transferSim.setInputVoltage(preShootAppliedVolts);
    }
}
