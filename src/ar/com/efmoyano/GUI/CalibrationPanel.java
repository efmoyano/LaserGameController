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

import ar.com.efmoyano.hardware.arduino.ArduinoCommands;
import ar.com.efmoyano.hardware.arduino.ArduinoEventAdapter;
import ar.com.efmoyano.utils.Utils;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @project LaserGameContoller
 * @author Ernesto Moyano
 * @mail ef.moyano@gmail.com
 * @date 09/04/2014
 * @time 21:58:11
 * @filename CalibrationPanel.java
 * @encoding UTF-8
 * @package ar.com.efmoyano.GUI
 * @license gpl30
 *
 */
public final class CalibrationPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private int photocellValue = 0;
    private Color colorTest;

    public static final String PROP_COLORTEST = "colorTest";

    /**
     * Get the value of colorTest
     *
     * @return the value of colorTest
     */
    public Color getColorTest() {
        return colorTest;
    }

    /**
     * Set the value of colorTest
     *
     * @param colorTest new value of colorTest
     */
    public void setColorTest(Color colorTest) {
        Color oldColorTest = this.colorTest;
        this.colorTest = colorTest;
        propertyChangeSupport.firePropertyChange(PROP_COLORTEST, oldColorTest, colorTest);
    }

    public static final String PROP_PHOTOCELLVALUE = "photocellValue";

    /**
     * Get the value of photocellValue
     *
     * @return the value of photocellValue
     */
    public int getPhotocellValue() {
        return photocellValue;
    }

    /**
     * Set the value of photocellValue
     *
     * @param photocellValue new value of photocellValue
     */
    public void setPhotocellValue(int photocellValue) {
        int oldPhotocellValue = this.photocellValue;
        this.photocellValue = photocellValue;
        propertyChangeSupport.firePropertyChange(PROP_PHOTOCELLVALUE, oldPhotocellValue, photocellValue);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * Get the value of mainFrame
     *
     * @return the value of mainFrame
     */
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * Set the value of mainFrame
     *
     * @param mainFrame new value of mainFrame
     */
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public CalibrationPanel(MainFrame p_mainFrame) {
        setMainFrame(p_mainFrame);
        getMainFrame().getArduinoDevice().addArduinoEventListener(new ArduinoEventAdapter() {

            int l_value;

            @Override
            public void onMessageReceived(String p_message) {
                l_value = Integer.parseInt(p_message);
                setPhotocellValue(l_value);
                if (l_value <= 510) {
                    setColorTest(Utils.valueToColor(l_value));
                }
            }
        });
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        bt_arduinoTest1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(java.awt.Color.red);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${colorTest}"), this, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        setLayout(layout);

        bt_arduinoTest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/laserTest.png"))); // NOI18N
        bt_arduinoTest1.setText("Laser Test");
        bt_arduinoTest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_arduinoTest1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 126;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 60, 60, 60);
        add(bt_arduinoTest1, gridBagConstraints);

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jButton5, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Photoresitence Value"));
        jPanel2.setMaximumSize(new java.awt.Dimension(150, 150));
        jPanel2.setMinimumSize(new java.awt.Dimension(150, 150));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(150, 150));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Photocell Value");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${photocellValue}"), jLabel1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -5;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        jPanel2.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(60, 60, 60, 60);
        add(jPanel2, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_arduinoTest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_arduinoTest1ActionPerformed

        getMainFrame().getArduinoDevice().sendData(ArduinoCommands.LASER_TEST);


    }//GEN-LAST:event_bt_arduinoTest1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            MainPanel configPanel = new MainPanel(getMainFrame());
            getMainFrame().installNewPanel(configPanel);
        } catch (Exception ex) {
            getMainFrame().error(ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_arduinoTest1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
