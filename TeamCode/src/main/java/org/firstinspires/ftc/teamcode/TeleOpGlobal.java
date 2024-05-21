package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class TeleOpGlobal extends LinearOpMode {
    @Override
    public void runOpMode() {

        ChassisSubsystem chassis = ChassisSubsystem.GetInstance(hardwareMap, telemetry, gamepad1);

        waitForStart();

        while (opModeIsActive()) {
            chassis.initChassis();

        }

        telemetry.addData("Status: ", "Running IG IDK !!!! :DDDDD");
        telemetry.update();
    }
}
