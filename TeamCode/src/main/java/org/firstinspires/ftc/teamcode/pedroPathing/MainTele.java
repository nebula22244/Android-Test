package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class MainTele extends LinearOpMode {


    @Override
    public void runOpMode() {

        DcMotor fr = hardwareMap.get(DcMotor.class, "fr");
        DcMotor br = hardwareMap.get(DcMotor.class, "br");
        DcMotor fl = hardwareMap.get(DcMotor.class, "fl");
        DcMotor bl = hardwareMap.get(DcMotor.class, "bl");

        DcMotor shootl = hardwareMap.get(DcMotor.class, "shootl");
        DcMotor shootr = hardwareMap.get(DcMotor.class, "shootr");

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double flPower = (-y + x + rx) / denominator;
            double blPower = (-y - x + rx) / denominator;
            double frPower = (y + x + rx) / denominator;
            double brPower = (y - x + rx) / denominator;

            fl.setPower(flPower);
            bl.setPower(blPower);
            fr.setPower(frPower);
            br.setPower(brPower);



            if (gamepad2.right_trigger>0.1){


            }



        }
    }
}
//Test Two