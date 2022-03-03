/*
 * Copyright (c) 2022.
 *
 * This file is part of the "Pathfinder2" project, available here:
 * <a href="https://github.com/Wobblyyyy/Pathfinder2">GitHub</a>
 *
 * This project is licensed under the GNU GPL V3 license.
 * <a href="https://www.gnu.org/licenses/gpl-3.0.en.html">GNU GPL V3</a>
 */

package me.wobblyyyy.pathfinder2.utils;

import me.wobblyyyy.pathfinder2.exceptions.ValidationException;

/**
 * Validation utilities.
 *
 * @author Colin Robertson
 * @since 1.4.2
 */
public class ValidationUtils {
    private static final String NO_NAME = "parameter name not specified";
    private static final String NO_MORE_INFO = "no more information specified";

    public static double validateNotNaN(double value,
                                        String parameterName,
                                        String customMessage) {
        if (Double.isNaN(value))
            throw new ValidationException(StringUtils.format(
                    "Failed to validate double <%s> because " +
                            "the value was not a number! Value: <%s> (%s)",
                    parameterName,
                    value,
                    customMessage
            ));

        return value;
    }

    public static double validateNotNaN(double value,
                                        String parameterName) {
        return validateNotNaN(value, parameterName, NO_MORE_INFO);
    }

    public static double validateNotInfinite(double value,
                                             String parameterName,
                                             String customMesssage) {
        if (Double.isInfinite(value))
            throw new ValidationException(StringUtils.format(
                    "Failed to validate double <%s> because " +
                            "the value was infinite! Value: <%s> (%s)",
                    parameterName,
                    value,
                    customMesssage
            ));

        return value;
    }

    public static double validateNotInfinite(double value,
                                             String parameterName) {
        return validateNotInfinite(value, parameterName, NO_MORE_INFO);
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @param parameterName the name of the parameter that's being validated.
     * @param customMessage a custom message to display at the end of the
     *                      exception that's thrown if validation fails.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static double validate(double value,
                                  String parameterName,
                                  String customMessage) {
        validateNotNaN(value, parameterName, customMessage);
        validateNotInfinite(value, parameterName, customMessage);

        return value;
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @param parameterName the name of the parameter that's being validated.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static double validate(double value,
                                  String parameterName) {
        return validate(value, parameterName, NO_MORE_INFO);
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * a {@link ValidationException.
     *
     * @param value         the value to validate.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static double validate(double value) {
        return validate(value, NO_NAME);
    }

    /**
     * Validate a float value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @param parameterName the name of the parameter that's being validated.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static float validate(float value,
                                 String parameterName) {
        validate((double) value, parameterName);
        return value;
    }

    /**
     * Validate a double value by ensuring it's not {@code NaN} or infinite.
     * If the number is {@code NaN} or infinite, this method will throw
     * an {@link ValidationException}.
     *
     * @param value         the value to validate.
     * @return if the value is validated (meaning it's not {@code NaN} and
     * it's not infinite), return the value.
     */
    public static float validate(float value) {
        return validate(value, NO_NAME);
    }

    public static <T> T validateNotNull(T t,
                                        String parameterName) {
        if (t == null) throw new ValidationException(StringUtils.format(
                    "Failed to validate object <%s> because it was null!",
                    parameterName
            ));

        return t;
    }

    /**
     * Validate an object by checking to see if it's null.
     *
     * @param object        the object to validate.
     * @param parameterName the name of the object.
     * @return the object.
     */
    public static <T> T validate(T t,
                                 String parameterName) {
        return validateNotNull(t, parameterName);
    }

    /**
     * Validate an object by checking to see if it's null.
     *
     * @param object        the object to validate.
     * @param parameterName the name of the object.
     * @return the object.
     */
    public static <T> T validate(T t) {
        return validate(t, NO_NAME);
    }
}
