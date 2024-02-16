package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;


public class Motorsubsystem extends SubsystemBase {
    CANSparkMax motor;
    double throttle


    public Motorsubsystem(double throttle, CANSparkMax type, int port) {
        motor = new CANSparkMax(this.port, this.type);
        this.throttle = throttle;
    }
    public Motorsubsystem(CANSparkMax type, int port) {
        this.motor = new CANSparkMax(this.port, this.type);
        this.throttle = 0.2;
    }

    public void runMotorforward() {
        motor.set(this.throttle);
    }

    public void runMotorbackward() {
        motor.set(0-this.throttle);
    }

    public void stopMotor() {
        motor.set(0);
    }

    public void follows(CANSparkMax leader) {
        motor.follow(this.leader);
    }
}