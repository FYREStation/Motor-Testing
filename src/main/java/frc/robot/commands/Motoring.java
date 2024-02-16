package frc.robot.commands;

import com.revrobotics.CANSparkLowLevel;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motorsubsystem;

public class Motoring extends Command{

    Motorsubsystem mymotor;

    public Motoring(CANSparkLowLevel.MotorType type, int port) {
        mymotor = new Motorsubsystem(type, port);
    }

    public Motoring(int throttle) {

    }

    public void changeThrottle(int throttle) {
        mymotor.setThrottle(throttle);
    }

    public void runMotorforward() {
        mymotor.runMotorforward();

    }
    public void runMotorbackward() {
        mymotor.runMotorbackward();

    }

    public void stopMotor() {
        mymotor.stopMotor();

    }
    

}
