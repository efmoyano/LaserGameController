/*
 * Copyright (C) 2014 Ernesto Moyano
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ar.com.efmoyano.utils;

/**
 * @project LaserGameContoller
 * @author Ernesto Moyano
 * @mail ef.moyano@gmail.com
 * @date 08/04/2014
 * @time 15:45:31
 * @filename StopWatch.java
 * @encoding UTF-8
 * @package ar.com.efmoyano.utils
 * @license gpl30
 *
 */
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.*;

public final class StopWatch {

    private final Timer m_timer;
    private int m_clockTick;
    private double m_seconds;

    private int minutes = 0;

    public static final String PROP_MINUTES = "minutes";

    /**
     * Get the value of minutes
     *
     * @return the value of minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Set the value of minutes
     *
     * @param minutes new value of minutes
     */
    public void setMinutes(int minutes) {
        int oldMinutes = this.minutes;
        this.minutes = minutes;
        propertyChangeSupport.firePropertyChange(PROP_MINUTES, oldMinutes, minutes);
    }

    public static final String PROP_SECONDS = "seconds";

    /**
     * Get the value of seconds
     *
     * @return the value of seconds
     */
    public double getSeconds() {
        return m_seconds;
    }

    /**
     * Set the value of seconds
     *
     * @param seconds new value of seconds
     */
    public void setSeconds(double seconds) {
        double oldSeconds = this.m_seconds;
        this.m_seconds = seconds;
        propertyChangeSupport.firePropertyChange(PROP_SECONDS, oldSeconds, seconds);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public StopWatch() {
        m_timer = new Timer(100, (ActionEvent evt) -> {
            m_clockTick++;
            setSeconds(((double) m_clockTick) / 10.0);

            if (m_seconds == 60) {
                m_clockTick = 0;
                setSeconds(0);
                setMinutes(minutes + 1);
            }
        });

    }

    public void start() {
        if (!m_timer.isRunning()) {
            m_clockTick = 0;
            m_seconds = ((double) m_clockTick) / 10.0;
            m_timer.start();
        }

    }

    public void stop() {
        m_timer.stop();
    }

    public void reset() {
        m_clockTick = 0;
        m_seconds = ((double) m_clockTick) / 10.0;
        System.out.println("Time: " + m_seconds);
    }
}
