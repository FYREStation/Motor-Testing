package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorLiftConstants; 

class Elevator extends Command {
    private final Elevator elevator;

    public Elevator(Elevator elevator) {
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override

    public void initialize() {
        driverControl = RobotContainer.driverControl;
    }

    public Command goToAmp = Commands.runOnce(() -> {
        if (currentPosition.equals("speaker")) {
            elevator.runMotorsUntil("down", ElevatorLiftConstants.bottomToAmpDistance);
        }
        else if (currentPosition.equals("down")) {
            elevator.runMotorsUntil("speaker", ElevatorLiftConstants.speakerToAmpDistance);

        }
    }
    )
    
    public Command goToSpeaker = Commands.runOnce(() -> {
        if (currentPosition.equals("speaker")) {
            elevator.runMotorsUntil("down", ElevatorLiftConstants.bottomToAmpDistance);
        }
        else if (currentPosition.equals("down")) {
            elevator.runMotorsUntil("speaker", ElevatorLiftConstants.speakerToAmpDistance);

        }
    }
}
