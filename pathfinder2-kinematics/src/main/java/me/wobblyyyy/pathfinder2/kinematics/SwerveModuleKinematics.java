/*
 * Copyright (c) 2021.
 *
 * This file is part of the "Pathfinder2" project, available here:
 * <a href="https://github.com/Wobblyyyy/Pathfinder2">GitHub</a>
 *
 * This project is licensed under the GNU GPL V3 license.
 * <a href="https://www.gnu.org/licenses/gpl-3.0.en.html">GNU GPL V3</a>
 */

package me.wobblyyyy.pathfinder2.kinematics;

import me.wobblyyyy.pathfinder2.control.Controller;
import me.wobblyyyy.pathfinder2.geometry.Angle;

public class SwerveModuleKinematics {
    private Controller controller;

    public SwerveModuleKinematics(Controller controller) {
        this.controller = controller;
    }

    public double calculate(Angle current,
                            Angle target) {
        return controller.calculate(
                current.deg(),
                target.deg()
        );
    }
}
