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
import ar.com.efmoyano.hardware.arduino.ArduinoDevice;
import ar.com.efmoyano.hardware.arduino.ArduinoEventAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @project LaserGameContoller
 * @author Ernesto Moyano
 * @mail ef.moyano@gmail.com
 * @date 03/04/2014
 * @time 21:34:01
 * @filename ArduinoPanel.java
 * @encoding UTF-8
 * @package ar.com.efmoyano.GUI
 * @license gpl30
 *
 */
public final class ArduinoPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;

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

    public ArduinoPanel(MainFrame p_mainframe) {

        setMainFrame(p_mainframe);

        if (getMainFrame().getArduinoDevice() == null) {
            ArduinoDevice l_arduinoDevice = new ArduinoDevice();
            getMainFrame().setArduinoDevice(l_arduinoDevice);

            getMainFrame().getArduinoDevice().addArduinoEventListener(new ArduinoEventAdapter() {

                @Override
                public void onMessageReceived(String p_message) {
                    switch (p_message) {

                        case "cutted":

                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ArduinoPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            getMainFrame().getArduinoDevice().sendData(ArduinoCommands.BUZZER_OFF);

                            break;
                    }
                }
            });
        }

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lb_arduinoPort = new javax.swing.JLabel();
        cb_arduinoPort = new javax.swing.JComboBox();
        cb_arduinoDataRate = new javax.swing.JComboBox();
        bt_arduinoTest = new javax.swing.JButton();
        bt_arduinoDisconnect = new javax.swing.JButton();
        bt_arduinoConnect = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lb_arduinoPort1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        setLayout(layout);

        lb_arduinoPort.setFont(new java.awt.Font("Xolonium", 3, 18)); // NOI18N
        lb_arduinoPort.setForeground(new java.awt.Color(255, 255, 255));
        lb_arduinoPort.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lb_arduinoPort, gridBagConstraints);

        cb_arduinoPort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${mainFrame.arduinoDevice.availablesPorts}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, cb_arduinoPort);
        bindingGroup.addBinding(jComboBoxBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${mainFrame.arduinoDevice.port}"), cb_arduinoPort, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 202;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(cb_arduinoPort, gridBagConstraints);

        cb_arduinoDataRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${mainFrame.arduinoDevice.dataRates}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, cb_arduinoDataRate);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${mainFrame.arduinoDevice.dataRate}"), cb_arduinoDataRate, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 202;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(cb_arduinoDataRate, gridBagConstraints);

        bt_arduinoTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        bt_arduinoTest.setText("Test");
        bt_arduinoTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_arduinoTestActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 174;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(bt_arduinoTest, gridBagConstraints);

        bt_arduinoDisconnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/disconnect.png"))); // NOI18N
        bt_arduinoDisconnect.setText("Disconnect");
        bt_arduinoDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_arduinoDisconnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(bt_arduinoDisconnect, gridBagConstraints);

        bt_arduinoConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/connect.png"))); // NOI18N
        bt_arduinoConnect.setText("Connect");
        bt_arduinoConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_arduinoConnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(bt_arduinoConnect, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buzzerOff.png"))); // NOI18N
        jButton3.setText("OFF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jButton3, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buzzerOn.png"))); // NOI18N
        jButton4.setText("ON");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jButton4, gridBagConstraints);

        lb_arduinoPort1.setFont(new java.awt.Font("Xolonium", 3, 18)); // NOI18N
        lb_arduinoPort1.setForeground(new java.awt.Color(255, 255, 255));
        lb_arduinoPort1.setText("Data Rate:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lb_arduinoPort1, gridBagConstraints);

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jButton5, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_arduinoConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_arduinoConnectActionPerformed

        if (getMainFrame().getArduinoDevice().initialize()) {
            JOptionPane.showMessageDialog(null, "Connected");
        } else {
            JOptionPane.showMessageDialog(null, "Failed");
        }

    }//GEN-LAST:event_bt_arduinoConnectActionPerformed

    private void bt_arduinoTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_arduinoTestActionPerformed
        getMainFrame().getArduinoDevice().verifyConnection();
    }//GEN-LAST:event_bt_arduinoTestActionPerformed

    private void bt_arduinoDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_arduinoDisconnectActionPerformed
        getMainFrame().getArduinoDevice().close();
    }//GEN-LAST:event_bt_arduinoDisconnectActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        getMainFrame().getArduinoDevice().sendData(ArduinoCommands.BUZZER_OFF);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        getMainFrame().getArduinoDevice().sendData(ArduinoCommands.BUZZER_ON);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            MainPanel configPanel = new MainPanel(getMainFrame());
            getMainFrame().installNewPanel(configPanel);
        } catch (Exception ex) {
            getMainFrame().error(ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_arduinoConnect;
    private javax.swing.JButton bt_arduinoDisconnect;
    private javax.swing.JButton bt_arduinoTest;
    private javax.swing.JComboBox cb_arduinoDataRate;
    private javax.swing.JComboBox cb_arduinoPort;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel lb_arduinoPort;
    private javax.swing.JLabel lb_arduinoPort1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
