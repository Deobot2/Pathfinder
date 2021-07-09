/*
 * Copyright (c) 2021.
 *
 * This file is part of the "Pathfinder2" project, available here:
 * <a href="https://github.com/Wobblyyyy/Pathfinder2">GitHub</a>
 *
 * This project is licensed under the GNU GPL V3 license.
 * <a href="https://www.gnu.org/licenses/gpl-3.0.en.html">GNU GPL V3</a>
 */

package me.wobblyyyy.pathfinder2.control;

/**
 * An abstract implementation of the {@link Controller} interface, designed
 * to simplify most of the tedious methods.
 *
 * <p>
 * The only method you have to implement is {@link #calculate(double)}. If
 * you need to get the target, you can use {@link #getTarget()}. Of course,
 * minimum and maximum are {@link #getMin()} and {@link #getMax()}.
 * </p>
 *
 * @author Colin Robertson
 * @since 0.0.0
 */
public abstract class AbstractController implements Controller {
    /**
     * The controller's default minimum. Unless changed, this value is
     * equal to negative infinity, meaning there is no minimum.
     */
    private double min = Double.NEGATIVE_INFINITY;

    /**
     * The controller's default maximum. Unless changed, this value is
     * equal to positive infinity, meaning there is no maximum.
     */
    private double max = Double.POSITIVE_INFINITY;

    /**
     * The controller's target value.
     */
    private double target = 0.0;

    /**
     * Get the controller's minimum.
     *
     * @return the controller's minimum.
     */
    @Override
    public double getMin() {
        return min;
    }

    /**
     * Get the controller's maximum.
     *
     * @return the controller's maximum.
     */
    @Override
    public double getMax() {
        return max;
    }

    /**
     * Set the controller's minimum.
     *
     * @param min the controller's minimum output value.
     */
    @Override
    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Set the controller's maximum.
     *
     * @param max the controller's maximum output value.
     */
    @Override
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * Reset the controller. By default, there's nothing to reset here. You
     * can (and should) override this method if there IS something to reset,
     * but otherwise, it doesn't do anything.
     */
    @Override
    public void reset() {

    }

    /**
     * Get the controller's target.
     *
     * @return the controller's target.
     */
    @Override
    public double getTarget() {
        return target;
    }

    /**
     * Set the controller's target.
     *
     * @param target the controller's target value.
     */
    @Override
    public void setTarget(double target) {
        this.target = target;
    }

    /**
     * A method that calls the {@link #setTarget(double)} method and then
     * returns the result of the {@link #calculate(double)} method. Because
     * the function of this method is fairly universal, it's implemented
     * here so there's no need to do it yourself.
     *
     * @param value  the input the controller should calculate for.
     * @param target the value the controller should attempt to reach.
     * @return the result of the {@link #calculate(double)} method after
     * setting the {@link #target} to equal the provided target.
     */
    @Override
    public double calculate(double value, double target) {
        setTarget(target);
        return calculate(value);
    }
}