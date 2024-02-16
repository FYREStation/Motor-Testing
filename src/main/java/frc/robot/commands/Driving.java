// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Vibhav: this is the imports from other files

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriveTrainConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

/** An example command that uses an example subsystem. */
// Vibhav: Example, creates drive train var
public class Driving extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrain driveTrain;

    // Initialize the move speed variables.
    // Vibhav: not much to say here... ^^^
    private double leftMovementSpeed;
    private double rightMovementSpeed;

    // Initialize our speed variables for controlling motor speeds.
    // Vibhav: not much to say here... ^^^
    private double leftStick;
    private double rightStick;

    // Initialize the tank drive toggle value. 
    // Vibhav: not much to say here... ^^^
    private boolean isTank;

    // Fetch the driver controller from the RobotContainer.
    // Vibhav: creates driver control var of type CommandXboxController
    private CommandXboxController driverControl;
    
    /**
     * Creates a new Driving command based on a DriveTrain subsystem.
     *
     * @param subsystem - The DriveTrain subsystem to be integrated into the command.
     */
    // Vibhav: this sets what subsystem will be used
    public Driving(DriveTrain subsystem) {
        this.driveTrain = subsystem;
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    // Vibhav: gives control to human operator
    @Override
    public void initialize() {
        // Set the driverControl variable to our XboxController.
        driverControl = RobotContainer.driverControl;
    }

    // Called every time the scheduler runs while the command is scheduled.
    // Vibhav: this runs what needs to be run, accesd by ticker
    @Override
    public void execute() {
        // Get the values of the joysticks we will use for our particular drive.
        // Vibhav: not much to say here... ^^^
        leftStick = isTank ? -driverControl.getLeftY() : driverControl.getLeftY();
        rightStick = isTank ? driverControl.getRightY() : driverControl.getRightX();
        
        // Vibhav: same as below

        // if (isTank) {
        //     leftStick = -driverControl.getLeftY();
        // } else {
        //     leftStick = driverControl.getRightX();
        // }

        // Calculates the power to apply to each set of motors. 
        // Vibhav: not much to say here... ^^^ by multipliying by constant
        leftMovementSpeed = leftStick * DriveTrainConstants.throttle;
        rightMovementSpeed = rightStick * DriveTrainConstants.throttle;

        // Runs each set of motors based on their calculated power levels.
        // Vibhav: not much to say here... ^^^
        if (isTank) {
            driveTrain.tankDrive(leftMovementSpeed, rightMovementSpeed);
        } else {
            driveTrain.arcadeDrive(rightMovementSpeed, leftMovementSpeed);
        }
    }

    // Toggles the isTank value, switching the robot from tank to 
    // arcade drive and vice versa.
    // Vibhav: toggles tank controls.
    public Command toggleDriveTrain = Commands.runOnce(() -> {
        isTank = !isTank;
    });
}
