package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Motorsubsystem extends SubsystemBase {
    private CANSparkMax motor;
    private CANSparkLowLevel.MotorType type;
    private double throttle;


    public Motorsubsystem(double throttle, CANSparkLowLevel.MotorType type, int port) {
        motor = new CANSparkMax(port, type);
        this.throttle = throttle;
    }
    public Motorsubsystem(CANSparkLowLevel.MotorType type, int port) {
        motor = new CANSparkMax(port, type);
        throttle = 0.2;
    }

    public void runMotorforward() {
        motor.set(throttle);
    }

    public void runMotorbackward() {
        motor.set(-throttle);
    }

    public void stopMotor() {
        motor.set(0);
    }

    public void follows(CANSparkMax leader) {
        motor.follow(leader);
    }

    public void setThrottle(double throttle) {
        this.throttle = throttle;
    }

    public CANSparkLowLevel.MotorType getType() {
        return type;
    }

    public double getThrottle() {
        return throttle;
    }
}