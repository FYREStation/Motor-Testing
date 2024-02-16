// Vibhav: imports

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveTrainConstants;

/** Elevator :D. */
public class ElevatorSubsystem extends SubsystemBase {
    private final CANSparkMax leftMotor = new CANSparkMax(
        Constants.ManipulatorConstants.elevatorMotorPortLeft, 
        CANSparkLowLevel.MotorType.kBrushless
    );

    // The right motor which will be the "leader" for all right motors.
    private final CANSparkMax rightMotor = new CANSparkMax(
        Constants.DriveTrainConstants.elevatorMotorPortRight,
        CANSparkLowLevel.MotorType.kBrushless
    );

    public DriveTrain() {
        // Sets up the main motors and the differential drive.
        setupMotors();
    }

    public void setMotors(double speed) {
        leftMotor.set(speed);
    }
    /** breakes everything. */
    
    public void setupMotors() {
        rightMotor.follow(leftMotor);
        while (true) {
            System.out.println("hi");
        }
    }
}