/*
 * Copyright (c) 2021.
 *
 * This file is part of the "Pathfinder2" project, available here:
 * <a href="https://github.com/Wobblyyyy/Pathfinder2">GitHub</a>
 *
 * This project is licensed under the GNU GPL V3 license.
 * <a href="https://www.gnu.org/licenses/gpl-3.0.en.html">GNU GPL V3</a>
 */

package me.wobblyyyy.pathfinder2.examples;

import me.wobblyyyy.pathfinder2.Pathfinder;
import me.wobblyyyy.pathfinder2.control.Controller;
import me.wobblyyyy.pathfinder2.control.GenericTurnController;
import me.wobblyyyy.pathfinder2.drive.MeccanumDrive;
import me.wobblyyyy.pathfinder2.follower.FollowerGenerator;
import me.wobblyyyy.pathfinder2.follower.generators.GenericFollowerGenerator;
import me.wobblyyyy.pathfinder2.geometry.PointXY;
import me.wobblyyyy.pathfinder2.geometry.PointXYZ;
import me.wobblyyyy.pathfinder2.geometry.Translation;
import me.wobblyyyy.pathfinder2.robot.Drive;
import me.wobblyyyy.pathfinder2.robot.Odometry;
import me.wobblyyyy.pathfinder2.robot.Robot;
import me.wobblyyyy.pathfinder2.robot.simulated.SimulatedDrive;
import me.wobblyyyy.pathfinder2.robot.simulated.SimulatedMotor;
import me.wobblyyyy.pathfinder2.robot.simulated.SimulatedOdometry;
import me.wobblyyyy.pathfinder2.utils.DualJoystick;
import me.wobblyyyy.pathfinder2.utils.Gamepad;
import me.wobblyyyy.pathfinder2.utils.Joystick;

import java.util.ArrayList;
import java.util.List;

public class ExampleMethodChaining {
    private final Drive drive = new SimulatedDrive();
    private final Odometry odometry = new SimulatedOdometry();
    private final Robot robot = new Robot(drive, odometry);

    private final Controller turnController = new GenericTurnController(0.05);
    private final FollowerGenerator followerGenerator = new GenericFollowerGenerator(turnController);
    private final Pathfinder pathfinder = new Pathfinder(robot, followerGenerator);

    public ExampleMethodChaining() {

    }

    /**
     * Drive in autonomous mode! Very cool.
     *
     * You don't have to do any looping - this method will execute until
     * Pathfinder has finished following its path. There's a variety of
     * ways to improve upon this that we can explore later.
     */
    @SuppressWarnings("DuplicatedCode")
    public void autonomousDrive() {
        pathfinder
                .goTo(new PointXYZ(0, 0, 0)).tickUntil()
                .goTo(new PointXYZ(10, 0, 0)).tickUntil()
                .goTo(new PointXYZ(10, 10, 0)).tickUntil()
                .goTo(new PointXYZ(0, 10, 0)).tickUntil()
                .goTo(new PointXYZ(0, 0, 0)).tickUntil()
                .andThen((pf) -> {
                    // print the position at the very end
                    System.out.printf(
                            "Current position: %s%n",
                            pf.getPosition()
                    );
                });
    }
}
