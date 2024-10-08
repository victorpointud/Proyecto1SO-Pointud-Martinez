package GUI;

import Number.CompanyNumber;
import Rules.DELLRules;
import Rules.CompanyRules;
import Rules.HPRules;
import Store.FileEntity;
import Store.JSONStore;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Global;

/*
* made by: victorpointud
*/

public class Settings extends javax.swing.JFrame {

    CompanyRules hpRules = new HPRules();
    CompanyRules dellRules = new DELLRules();
    JSONStore storeJSON = new JSONStore();

    public Settings() {
        initComponents();
        try {
            FileEntity dellFile = storeJSON.GetFile(CompanyNumber.DELL);
            FileEntity hpFile = storeJSON.GetFile(CompanyNumber.HP);
            dellBasePlates.setValue(dellFile.getBasePlates());
            dellCPUs.setValue(dellFile.getCPUs());
            dellRAMs.setValue(dellFile.getRAMs());
            dellPowerSupplies.setValue(dellFile.getPowerSupplies());
            dellGraphicsCards.setValue(dellFile.getGraphicsCards());
            dellIntegrators.setValue(dellFile.getIntegrators());
            hpBasePlates.setValue(hpFile.getBasePlates());
            hpCPUs.setValue(hpFile.getCPUs());
            hpRAMs.setValue(hpFile.getRAMs());
            hpPowerSupplies.setValue(hpFile.getPowerSupplies());
            hpGraphicsCards.setValue(hpFile.getGraphicsCards());
            hpIntegrators.setValue(hpFile.getIntegrators());
            timeLeft.setValue(hpFile.getDeadLineDays());
            timeDuration.setValue(hpFile.getDurationDay() / 1000);
            this.repaint();
        } 
        catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, "Error al cargar los archivos JSON", ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        timeLeft = new javax.swing.JSpinner();
        dellBasePlates = new javax.swing.JSpinner();
        dellCPUs = new javax.swing.JSpinner();
        dellRAMs = new javax.swing.JSpinner();
        dellPowerSupplies = new javax.swing.JSpinner();
        dellIntegrators = new javax.swing.JSpinner();
        timeDuration = new javax.swing.JSpinner();
        hpBasePlates = new javax.swing.JSpinner();
        hpCPUs = new javax.swing.JSpinner();
        hpRAMs = new javax.swing.JSpinner();
        hpPowerSupplies = new javax.swing.JSpinner();
        hpGraphicsCards = new javax.swing.JSpinner();
        BackButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        dellGraphicsCards = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        hpIntegrators = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SaveButton.setBackground(new java.awt.Color(0, 0, 0));
        SaveButton.setFont(new java.awt.Font("BM Yeonsung", 1, 18)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("Guardar");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar(evt);
            }
        });
        jPanel1.add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 130, 40));

        jLabel3.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tiempo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 170, -1));

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Integradores");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dias para finalizar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CPUs");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("RAMs");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fuentes de Energía");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Placas Base");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLabel11.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Duración de dias");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        jLabel13.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tarjetas Gráficas");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CPUs");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        jLabel16.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("RAMs");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        jLabel17.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Fuentes de Energía");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));

        jLabel19.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Placas Base");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        timeLeft.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tiempoJuegos(evt);
            }
        });
        jPanel1.add(timeLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 110, -1));

        dellBasePlates.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                capcomSistemasChange(evt);
            }
        });
        jPanel1.add(dellBasePlates, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 110, -1));

        dellCPUs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dellCPUsChange(evt);
            }
        });
        jPanel1.add(dellCPUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 110, -1));

        dellRAMs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                capcomNivelesChange(evt);
            }
        });
        jPanel1.add(dellRAMs, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 110, -1));

        dellPowerSupplies.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                capcomNarrativasChange(evt);
            }
        });
        jPanel1.add(dellPowerSupplies, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 110, -1));

        dellIntegrators.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dellIntegratorsChange(evt);
            }
        });
        jPanel1.add(dellIntegrators, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 110, -1));

        timeDuration.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tiempoDias(evt);
            }
        });
        jPanel1.add(timeDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 110, -1));

        hpBasePlates.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nintendoSistemasChange(evt);
            }
        });
        jPanel1.add(hpBasePlates, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 110, -1));

        hpCPUs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hpCPUsChange(evt);
            }
        });
        jPanel1.add(hpCPUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 110, -1));

        hpRAMs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nintendoNivelesChange(evt);
            }
        });
        jPanel1.add(hpRAMs, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 110, -1));

        hpPowerSupplies.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nintendoNarrativasChange(evt);
            }
        });
        jPanel1.add(hpPowerSupplies, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 110, -1));

        hpGraphicsCards.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hpGraphicsCardsChange(evt);
            }
        });
        jPanel1.add(hpGraphicsCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 110, -1));

        BackButton.setBackground(new java.awt.Color(0, 0, 0));
        BackButton.setFont(new java.awt.Font("BM Yeonsung", 1, 18)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setText("Volver");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver(evt);
            }
        });
        jPanel1.add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 130, 40));

        jLabel12.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tarjetas Gráficas");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        dellGraphicsCards.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dellGraphicsCardsChange(evt);
            }
        });
        jPanel1.add(dellGraphicsCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 110, -1));

        jLabel20.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("CONFIGURACIÓN");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 490, 70));

        jLabel14.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Integradores");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, -1, -1));

        hpIntegrators.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hpIntegratorsChange(evt);
            }
        });
        jPanel1.add(hpIntegrators, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, 110, -1));

        jLabel18.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dell.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 60, 240, 240));

        jLabel21.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo-negrito.jpg"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 310, 60));

        jLabel22.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo-negrito.jpg"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 330, 210));

        jLabel23.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo-negrito.jpg"))); // NOI18N
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 330, 210));

        jLabel24.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo hp 2.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 490, 240));

        jLabel25.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo-negrito.jpg"))); // NOI18N
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 330, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volver(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver
        // TODO add your handling code here:
        this.setVisible(false);
        Global.mainMenu.setVisible(true);
    }//GEN-LAST:event_volver

    
    private void dellCPUsChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dellCPUsChange
        // TODO add your handling code here:
        if ((int) this.dellCPUs.getValue() <= 0) {
            this.dellCPUs.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.DELL);
        if (dif < 0) {
            this.dellCPUs.setValue(((int) this.dellCPUs.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_dellCPUsChange

    private void capcomNivelesChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_capcomNivelesChange
        // TODO add your handling code here:
        if ((int) this.dellRAMs.getValue() <= 0) {
            this.dellRAMs.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.DELL);
        if (dif < 0) {
            this.dellRAMs.setValue(((int) this.dellRAMs.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_capcomNivelesChange

    private void capcomNarrativasChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_capcomNarrativasChange
        // TODO add your handling code here:
        if ((int) this.dellPowerSupplies.getValue() <= 0) {
            this.dellPowerSupplies.setValue(1);
            this.repaint();
        }

        int dif = validateEmployeesNumber(CompanyNumber.DELL);
        if (dif < 0) {
            this.dellPowerSupplies.setValue(((int) this.dellPowerSupplies.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_capcomNarrativasChange

    private void dellIntegratorsChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dellIntegratorsChange
        // TODO add your handling code here:
        if ((int) this.dellIntegrators.getValue() <= 0) {
            this.dellIntegrators.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.DELL);
        if (dif < 0) {
            this.dellIntegrators.setValue(((int) this.dellIntegrators.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_dellIntegratorsChange

    private void nintendoSistemasChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nintendoSistemasChange
        // TODO add your handling code here:
        if ((int) this.hpBasePlates.getValue() <= 0) {
            this.hpBasePlates.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.HP);
        if (dif < 0) {
            this.hpBasePlates.setValue(((int) this.hpBasePlates.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_nintendoSistemasChange

    private void hpCPUsChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hpCPUsChange
        // TODO add your handling code here:
        if ((int) this.hpCPUs.getValue() <= 0) {
            this.hpCPUs.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.HP);
        if (dif < 0) {
            this.hpCPUs.setValue(((int) this.hpCPUs.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_hpCPUsChange

    private void nintendoNivelesChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nintendoNivelesChange
        // TODO add your handling code here:
        if ((int) this.hpRAMs.getValue() <= 0) {
            this.hpRAMs.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.HP);
        if (dif < 0) {
            this.hpRAMs.setValue(((int) this.hpRAMs.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_nintendoNivelesChange

    private void nintendoNarrativasChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nintendoNarrativasChange
        // TODO add your handling code here:
        if ((int) this.hpPowerSupplies.getValue() <= 0) {
            this.hpPowerSupplies.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.HP);
        if (dif < 0) {
            this.hpPowerSupplies.setValue(((int) this.hpPowerSupplies.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_nintendoNarrativasChange

    private void hpGraphicsCardsChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hpGraphicsCardsChange
        // TODO add your handling code here:
        if ((int) this.hpGraphicsCards.getValue() <= 0) {
            this.hpGraphicsCards.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.HP);
        if (dif < 0) {
            this.hpGraphicsCards.setValue(((int) this.hpGraphicsCards.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_hpGraphicsCardsChange

    private void tiempoDias(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tiempoDias
        // TODO add your handling code here:
        if ((int) this.timeDuration.getValue() <= 0) {
            this.timeDuration.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_tiempoDias

    private void tiempoJuegos(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tiempoJuegos
        // TODO add your handling code here:
        if ((int) this.timeLeft.getValue() <= 0) {
            this.timeLeft.setValue(1);
            this.repaint();
        }
    }//GEN-LAST:event_tiempoJuegos

    private void dellGraphicsCardsChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dellGraphicsCardsChange
        // TODO add your handling code here:
        if ((int) this.dellGraphicsCards.getValue() <= 0) {
            this.dellGraphicsCards.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.DELL);
        if (dif < 0) {
            this.dellGraphicsCards.setValue(((int) this.dellGraphicsCards.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_dellGraphicsCardsChange

    private void hpIntegratorsChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hpIntegratorsChange
        // TODO add your handling code here:
        int dif = validateEmployeesNumber(CompanyNumber.HP);
        if (dif < 0) {
            this.hpIntegrators.setValue(((int) this.hpIntegrators.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_hpIntegratorsChange

    private void guardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar
        try {
            // TODO add your handling code here:
            this.storeJSON.setFile(getFile(CompanyNumber.DELL), CompanyNumber.DELL);
            this.storeJSON.setFile(getFile(CompanyNumber.HP), CompanyNumber.HP);
            Global.daysBetweenReleases = (int) this.timeLeft.getValue();
            Global.daysDuration = (float) ((int) this.timeDuration.getValue()) * 1000;
            this.setVisible(false);
            Global.mainMenu.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardar

    private void capcomSistemasChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_capcomSistemasChange
        // TODO add your handling code here:
        if ((int) this.dellBasePlates.getValue() <= 0) {
            this.dellBasePlates.setValue(1);
            this.repaint();
        }
        int dif = validateEmployeesNumber(CompanyNumber.DELL);
        if (dif < 0) {
            this.dellBasePlates.setValue(((int) this.dellBasePlates.getValue()) - dif);
            this.repaint();
        }
    }//GEN-LAST:event_capcomSistemasChange

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JSpinner dellBasePlates;
    private javax.swing.JSpinner dellCPUs;
    private javax.swing.JSpinner dellGraphicsCards;
    private javax.swing.JSpinner dellIntegrators;
    private javax.swing.JSpinner dellPowerSupplies;
    private javax.swing.JSpinner dellRAMs;
    private javax.swing.JSpinner hpBasePlates;
    private javax.swing.JSpinner hpCPUs;
    private javax.swing.JSpinner hpGraphicsCards;
    private javax.swing.JSpinner hpIntegrators;
    private javax.swing.JSpinner hpPowerSupplies;
    private javax.swing.JSpinner hpRAMs;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner timeDuration;
    private javax.swing.JSpinner timeLeft;
    // End of variables declaration//GEN-END:variables

    private FileEntity getFile(CompanyNumber company) {
        switch (company) {
            case HP:
                return new FileEntity(((int) this.timeDuration.getValue()) * 1000, (int) this.timeLeft.getValue(), (int) this.hpPowerSupplies.getValue(), (int) this.hpRAMs.getValue(),
                        (int) this.hpGraphicsCards.getValue(), (int) this.hpBasePlates.getValue(), (int) this.hpCPUs.getValue(), (int) this.hpIntegrators.getValue());
            case DELL:
                return new FileEntity(((int) this.timeDuration.getValue()) * 1000, (int) this.timeLeft.getValue(), (int) this.dellPowerSupplies.getValue(), (int) this.dellRAMs.getValue(),
                        (int) this.dellGraphicsCards.getValue(), (int) this.dellBasePlates.getValue(), (int) this.dellCPUs.getValue(), (int) this.dellIntegrators.getValue());
            default:
                throw new AssertionError(company.name());
        }
    }

    private int validateEmployeesNumber(CompanyNumber company) {
        int diference = 0;
        int max = 0;
        int sum = 0;
        switch (company) {
            case HP:
                max = this.hpRules.getEmployees();
                sum = (int) this.hpPowerSupplies.getValue() + (int) this.hpRAMs.getValue() + (int) this.hpGraphicsCards.getValue() + (int) this.hpBasePlates.getValue()
                        + (int) this.hpCPUs.getValue() + (int) this.hpIntegrators.getValue();
                diference = max - sum;
                break;
            case DELL:
                max = this.dellRules.getEmployees();
                sum = (int) this.dellPowerSupplies.getValue() + (int) this.dellRAMs.getValue() + (int) this.dellGraphicsCards.getValue() + (int) this.dellBasePlates.getValue()
                        + (int) this.dellCPUs.getValue() + (int) this.dellIntegrators.getValue();
                diference = max - sum;
                break;
            default:
                throw new AssertionError(company.name());
        }
        return diference;
    }
}
