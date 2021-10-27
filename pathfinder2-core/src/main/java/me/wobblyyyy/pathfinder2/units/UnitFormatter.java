/*
 * Copyright (c) 2021.
 *
 * This file is part of the "Pathfinder2" project, available here:
 * <a href="https://github.com/Wobblyyyy/Pathfinder2">GitHub</a>
 *
 * This project is licensed under the GNU GPL V3 license.
 * <a href="https://www.gnu.org/licenses/gpl-3.0.en.html">GNU GPL V3</a>
 */

package me.wobblyyyy.pathfinder2.units;

import java.util.EnumMap;
import java.util.Map;

import static me.wobblyyyy.pathfinder2.units.Unit.*;

public class UnitFormatter {
    private static final Map<Unit, String> NAMES_SHORT =
            new EnumMap<Unit, String>(Unit.class) {{
                put(INCH, "in");
                put(CM, "cm");
                put(M, "m");
                put(KM, "km");
                put(MM, "mm");
                put(MILE, "mi");
                put(YARD, "yd");
                put(FOOT, "ft");
                put(NAUTICAL_MILE, "NM");
            }};

    private static final Map<Unit, String> NAMES_SINGULAR =
            new EnumMap<Unit, String>(Unit.class) {{
                put(INCH, "inch");
                put(CM, "centimeter");
                put(M, "meter");
                put(KM, "kilometer");
                put(MM, "millimeter");
                put(MILE, "mile");
                put(YARD, "yard");
                put(FOOT, "foot");
                put(NAUTICAL_MILE, "nautical mile");
            }};

    private static final Map<Unit, String> NAMES_PLURAL =
            new EnumMap<Unit, String>(Unit.class) {{
                put(INCH, "inches");
                put(CM, "centimeters");
                put(M, "meters");
                put(KM, "kilometers");
                put(MM, "millimeters");
                put(MILE, "miles");
                put(YARD, "yards");
                put(FOOT, "feet");
                put(NAUTICAL_MILE, "nautical miles");
            }};

    private UnitFormatter() {

    }

    public static String getShortName(Unit unit) {
        return NAMES_SHORT.get(unit);
    }

    public static String getSingularName(Unit unit) {
        return NAMES_SINGULAR.get(unit);
    }

    public static String getPluralName(Unit unit) {
        return NAMES_PLURAL.get(unit);
    }

    public static String formatShort(Unit unit, double value) {
        return value + " " + getShortName(unit);
    }

    public static String format(Unit unit, double value) {
        String suffix = Math.abs(value - 1) < 0.001 ?
                getSingularName(unit) :
                getPluralName(unit);

        return value + " " + suffix;
    }
}
