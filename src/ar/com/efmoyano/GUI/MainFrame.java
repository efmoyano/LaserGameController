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
package ar.com.efmoyano.GUI;

import ar.com.efmoyano.hardware.arduino.ArduinoDevice;
import ar.com.efmoyano.hardware.video.VideoDevice;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 * @project LaserGameContoller
 * @author Ernesto Moyano
 * @mail ef.moyano@gmail.com
 * @date 03/04/2014
 * @time 12:49:57
 * @filename MainFrame.java
 * @encoding UTF-8
 * @package ar.com.efmoyano.GUI
 * @license gpl30
 *
 */
public final class MainFrame extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private VideoDevice videoDevice;

    /**
     * Get the value of videoDevice
     *
     * @return the value of videoDevice
     */
    public VideoDevice getVideoDevice() {
        return videoDevice;
    }

    /**
     * Set the value of videoDevice
     *
     * @param videoDevice new value of videoDevice
     */
    public void setVideoDevice(VideoDevice videoDevice) {
        this.videoDevice = videoDevice;
    }

    private ArduinoDevice arduinoDevice;

    /**
     * Get the value of arduinoDevice
     *
     * @return the value of arduinoDevice
     */
    public ArduinoDevice getArduinoDevice() {
        return arduinoDevice;
    }

    /**
     * Set the value of arduinoDevice
     *
     * @param arduinoDevice new value of arduinoDevice
     */
    public void setArduinoDevice(ArduinoDevice arduinoDevice) {
        this.arduinoDevice = arduinoDevice;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public MainFrame() {

        initComponents();

        try {
            MainPanel configPanel = new MainPanel(this);
            installNewPanel(configPanel);
        } catch (Exception ex) {
            error(ex);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Methods">
    public void installNewPanel(JComponent p_component) {
        if (getContentPane().getComponentCount() > 0) {
            Component previo = getContentPane().getComponent(0);

            if (previo != null) {
                getContentPane().remove(0);
            }
            getContentPane().add(p_component, java.awt.BorderLayout.CENTER);
            validate();
        }//endif
        else {
            getContentPane().add(p_component, java.awt.BorderLayout.CENTER);
            validate();
        }
    }

    public void error(Exception ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    // </editor-fold> 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            MainFrame mf = new MainFrame();
            mf.setLocationRelativeTo(null);
            mf.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
