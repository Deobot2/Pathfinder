/*
 * Copyright (c) 2022.
 *
 * This file is part of the "Pathfinder2" project, available here:
 * <a href="https://github.com/Wobblyyyy/Pathfinder2">GitHub</a>
 *
 * This project is licensed under the GNU GPL V3 license.
 * <a href="https://www.gnu.org/licenses/gpl-3.0.en.html">GNU GPL V3</a>
 */

package me.wobblyyyy.pathfinder2.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTranslation {
    @Test
    public void testAdd() {
        Translation a = new Translation(0, 0, 0);
        Translation b = new Translation(1, 1, 0);
        Translation c = new Translation(0, 1, 0);
        Translation d = new Translation(1, 0, 0);

        Assertions.assertEquals(
                a,
                b.add(new Translation(-1, -1, 0))
        );
        Assertions.assertEquals(
                c.add(new Translation(1, 0, 0)),
                d.add(new Translation(0, 1, 0))
        );
        Assertions.assertEquals(
                c.add(new Translation(1, 0, 0))
                        .add(new Translation(10, 10, 10)),
                d.add(new Translation(0, 1, 0))
                        .add(new Translation(10, 10, 10))
        );
    }

    @Test
    public void testAbsoluteToRelative() {
        Translation a = new Translation(1, 0, 0);
        Translation b = new Translation(0, 1, 0);

        Assertions.assertEquals(
                b,
                a.toRelative(Angle.fromDeg(90))
        );
        Assertions.assertEquals(
                a,
                b.toRelative(Angle.fixedDeg(-90))
        );
        Assertions.assertEquals(
                a.toRelative(Angle.fromDeg(90)),
                b.toRelative(Angle.fixedDeg(-90))
                        .toRelative(Angle.fromDeg(90))
        );
        Assertions.assertEquals(
                a.toRelative(Angle.fromDeg(33)),
                b.toRelative(Angle.fixedDeg(-90))
                        .toRelative(Angle.fromDeg(33))
        );
    }

    @Test
    public void testMultiply() {
        Translation a = new Translation(1, 1, 0.5);
        Translation b = new Translation(0.5, 0.5, 0.25);

        Assertions.assertEquals(
                b,
                a.multiply(0.5)
        );
        Assertions.assertEquals(
                b.multiply(5.3),
                a.multiply(0.5).multiply(5.3)
        );
        Assertions.assertEquals(
                b.multiply(5.3).multiply(0.1),
                a.multiply(0.5).multiply(5.3).multiply(0.1)
        );
    }

    @Test
    public void testFromPointXYZ() {
        Translation a = new Translation(1, 0.5, 0.75);
        Translation b = Translation.fromPointXYZ(new PointXYZ(1, 0.5, 0.75));

        Assertions.assertEquals(a, b);
    }

    @Test
    public void testWithVx() {
        Translation a = new Translation(1, 1, 1);
        Translation b = new Translation(0, 1, 1);

        Assertions.assertEquals(
                a,
                b.withVx(1)
        );
    }

    @Test
    public void testWithVy() {
        Translation a = new Translation(1, 1, 1);
        Translation b = new Translation(1, 0, 1);

        Assertions.assertEquals(
                a,
                b.withVy(1)
        );
    }

    @Test
    public void testWithVz() {
        Translation a = new Translation(1, 1, 1);
        Translation b = new Translation(1, 1, 0);

        Assertions.assertEquals(
                a,
                b.withVz(1)
        );
    }
}