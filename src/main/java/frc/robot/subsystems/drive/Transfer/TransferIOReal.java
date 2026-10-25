package frc.robot.subsystems.drive.Transfer;

import java.lang.module.Configuration;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;


public class TransferIOReal implements TransferIO {
   private final SparkMax transferMotor = new SparkMax(0, MotorType.kBrushless);//find actuall ID
   private final SparkMax preShootMotor = new SparkMax(0, MotorType.kBrushless); //find actuall ID

   private final RelativeEncoder transferEncoder = transferMotor.getEncoder();
   private final RelativeEncoder preShootEncoder = preShootMotor.getEncoder();

   public TransferIOReal(){
        configure(transferMotor, false);
        configure(preShootMotor, false);//change true to false if spins the other way

   }

@SuppressWarnings("removal")
//create a configure method to configure each motor
private void configure(SparkMax motor, Boolean inverted){
    var config = new SparkMaxConfig();
    //smart current limit is to prevent voltage spikes and damage to the motor
    //can impede robot functionallity and might not be used durring season if its problematic
    config.idleMode(IdleMode.kBrake).smartCurrentLimit(30).inverted(inverted);
    motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
   }

@Override
public void updateInputs(TransferIOInputs inputs){

    //reads the values of the variables we put inside the IO inputs class in the IO interface
    inputs.preShootVelocityRPM = transferEncoder.getVelocity();
    inputs.transferVelocityRPM = preShootEncoder.getPosition();
}

@Override
public void setTransferVoltage(double volts){
    transferMotor.setVoltage(volts);
}

@Override
public void setPreShootVoltage(double volts){
    preShootMotor.setVoltage(volts);
}
    

}
