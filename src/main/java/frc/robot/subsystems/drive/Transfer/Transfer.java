package frc.robot.subsystems.drive.Transfer;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


//TODO: finish the Transfer.Java file to include all the lambdas and constructor
public class Transfer extends SubsystemBase{
    //private final TransferIO io; //find out whats wrong with this
    private final TransferIOInputsAutoLogged inputs = new TransferIOInputsAutoLogged();

    private static final double TRANSFER_VOLTS = 8.0;
    private static final double PRESHOOT_VOLTS = 10.0;
    private static final double REVERSE_VOLTS = -6.0;


    
}
