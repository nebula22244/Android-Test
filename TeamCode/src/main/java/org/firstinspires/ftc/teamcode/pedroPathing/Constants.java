package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.ThreeWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants().mass(5);   //TODO: please CHANGE MASS TO BE CORRECT, kg


    public static MecanumConstants driveConstants = new MecanumConstants() //LATER PROBLEM oops
            .maxPower(1)
            .rightFrontMotorName("fr")
            .rightRearMotorName("br")
            .leftRearMotorName("bl")
            .leftFrontMotorName("fl")
            .leftFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .leftRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightRearMotorDirection(DcMotorSimple.Direction.REVERSE);


    public static ThreeWheelConstants localizerConstants = new ThreeWheelConstants()
            .forwardTicksToInches(0.001978937)
            .strafeTicksToInches(0.001978937)
            .turnTicksToInches(0.001978937)
            .leftPodY(-7.5)
            .rightPodY(7.5)                                               //TODO fix this,  ticks to inches please
            .strafePodX(4.65)
            .leftEncoder_HardwareMapName("br")
            .rightEncoder_HardwareMapName("bl")
            .strafeEncoder_HardwareMapName("fl")
            .leftEncoderDirection(Encoder.REVERSE)//other may need reversed if its being stupid and goes the other way
            .rightEncoderDirection(Encoder.FORWARD)//same with this
            .strafeEncoderDirection(Encoder.FORWARD)// and this
            .forwardTicksToInches(.005)//this number is also very wrong do the tuning tests
            .strafeTicksToInches(.005) //this is also just a place holder do the steps it says please
            .turnTicksToInches(.005)//this is also a place holder guy
;

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .threeWheelLocalizer(localizerConstants)
                .build();
    }
}
