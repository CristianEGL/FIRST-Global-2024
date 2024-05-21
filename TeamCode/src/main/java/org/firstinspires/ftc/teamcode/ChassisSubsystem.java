package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ChassisSubsystem {
    private static ChassisSubsystem instance;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    private Gamepad chassisController;
    public DcMotor rightMotor;
    public DcMotor leftMotor;

    public ChassisSubsystem(HardwareMap hardwareMap, Telemetry telemetry, Gamepad chassisController) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        this.chassisController = chassisController;

        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
    }

    public static ChassisSubsystem GetInstance(HardwareMap hardwareMap, Telemetry telemetry, Gamepad chassisController) {
        if (instance == null) {
            instance = new ChassisSubsystem(hardwareMap, telemetry, chassisController);
        }

        return instance;
    }

    public void initChassis() {
        TankDrive(chassisController);
    }

    public void TankDrive(Gamepad controller) {
        rightMotor.setPower(controller.left_stick_y + controller.right_stick_x);
        leftMotor.setPower(controller.left_stick_y - controller.right_stick_x);
    }
}
