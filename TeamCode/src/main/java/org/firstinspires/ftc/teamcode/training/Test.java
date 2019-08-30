package org.firstinspires.ftc.teamcode.training;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="4.DrivTri", group="Linear Opmode")
public class Test extends LinearOpMode {

    DcMotor leftMotor, rightMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        //Declare all hardware
        leftMotor = hardwareMap.dcMotor.get("leftmotor");
        rightMotor = hardwareMap.dcMotor.get("rightmotor");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");

        telemetry.update();

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        sleep(1000);

        double speedControlPowerSetting = 0.5;

        while (opModeIsActive()) {


            //*************************************************************************************
            //                                  GamePad 1 Settings

            //Set speed control
            if (gamepad1.right_bumper) {
                speedControlPowerSetting = 0.75;
            }
            if (gamepad1.left_bumper) {
                speedControlPowerSetting = 0.25;
            }

            //Set motor speeds for driving
            if ((gamepad1.dpad_right == false && gamepad1.dpad_left == false)){

                leftMotor.setPower(gamepad1.left_stick_y * speedControlPowerSetting);

                rightMotor.setPower(gamepad1.right_stick_y * speedControlPowerSetting);


                //telemetry.addData("Status", "Running");
                telemetry.addData("Path1",  "Running to Target LF, RF,  :%7d :%7d",
                        leftMotor.getCurrentPosition(),
                        rightMotor.getCurrentPosition());

                telemetry.update();

            }

              while (gamepad1.left_trigger >0) {
                  leftMotor.setPower(+speedControlPowerSetting);
                  rightMotor.setPower(-speedControlPowerSetting);

              telemetry.addData("Path1",  "Running to Target LF,RF :%7d :%7d",
                      leftMotor.getCurrentPosition(),
                      rightMotor.getCurrentPosition());
                telemetry.update();
            }
            telemetry.update();
        }

    }
}
