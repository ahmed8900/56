//    Chromis POS  - The New Face of Open Source POS
//    Copyright (c) (c) 2015-2016
//    http://www.chromis.co.uk
//
//    This file is part of Chromis POS
//
//     Chromis POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Chromis POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Chromis POS.  If not, see <http://www.gnu.org/licenses/>.

package uk.chromis.pos.sales;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import uk.chromis.basic.BasicException;
import uk.chromis.pos.forms.AppLocal;
import uk.chromis.pos.forms.DataLogicSales;
import uk.chromis.pos.forms.DataLogicSystem;
import uk.chromis.pos.ticket.TicketInfo;
import uk.chromis.pos.ticket.TicketLineInfo;

/**
 *
 *
 */
public class JRefundLines extends javax.swing.JPanel {

    private final JTicketLines ticketlines;
    private static List m_aLines;
    private static DataLogicSales dlSales;
    private final JPanelTicketEdits m_jTicketEdit;
    private static TicketLineInfo tmpTicketInfo;

    /**
     * Creates new form JRefundLines
     *
     * @param dlSystem
     * @param jTicketEdit
     */
    public JRefundLines(DataLogicSystem dlSystem, DataLogicSales dlsales, JPanelTicketEdits jTicketEdit) {

        dlSales = dlsales;
        m_jTicketEdit = jTicketEdit;

        initComponents();
        ticketlines = new JTicketLines(dlSystem.getResourceAsXML("Ticket.Line"));
        jPanel3.add(ticketlines, BorderLayout.CENTER);
    }

    /**
     *
     * @param aRefundLines
     */
    public void setLines(List aRefundLines) {
        m_aLines = aRefundLines;
        ticketlines.clearTicketLines();
        if (m_aLines != null) {
            for (Object m_aLine : m_aLines) {
                ticketlines.addTicketLine((TicketLineInfo) m_aLine);
            }
        }
    }

    public static void addBackLine(String name, Double qty, Double price, String line) {
        int i = 0;
        for (Object m_aLine : m_aLines) {
            tmpTicketInfo = ((TicketLineInfo) m_aLine);
            if (line.equals(tmpTicketInfo.getProperty("orgLine"))) {
                tmpTicketInfo.setRefundQty(tmpTicketInfo.getRefundQty() + (qty));
                tmpTicketInfo.setMultiply(tmpTicketInfo.getMultiply() + (qty * -1));
                m_aLines.set(i, tmpTicketInfo);
            }
            i++;
        }
    }

    public static void updateRefunds() throws BasicException {
        if (m_aLines != null){
        for (Object m_aLine : m_aLines) {
            tmpTicketInfo = ((TicketLineInfo) m_aLine);
            dlSales.updateRefundQty(tmpTicketInfo.getRefundQty(), tmpTicketInfo.getTicket(), tmpTicketInfo.getTicketLine());
        }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        m_jbtnAddOne = new javax.swing.JButton();
        m_jbtnAddLine = new javax.swing.JButton();
        m_jbtnAddAll = new javax.swing.JButton();

        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(15, 200));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        m_jbtnAddOne.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddOne.setText(AppLocal.getIntString("button.refundone")); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        m_jbtnAddOne.setToolTipText(bundle.getString("tiptext.refundanitem")); // NOI18N
        m_jbtnAddOne.setFocusPainted(false);
        m_jbtnAddOne.setFocusable(false);
        m_jbtnAddOne.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddOne.setRequestFocusEnabled(false);
        m_jbtnAddOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddOneActionPerformed(evt);
            }
        });
        jPanel2.add(m_jbtnAddOne);

        m_jbtnAddLine.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddLine.setText(AppLocal.getIntString("button.refundline")); // NOI18N
        m_jbtnAddLine.setToolTipText(bundle.getString("tiptext.refundaline")); // NOI18N
        m_jbtnAddLine.setFocusPainted(false);
        m_jbtnAddLine.setFocusable(false);
        m_jbtnAddLine.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddLine.setRequestFocusEnabled(false);
        m_jbtnAddLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddLineActionPerformed(evt);
            }
        });
        jPanel2.add(m_jbtnAddLine);

        m_jbtnAddAll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddAll.setText(AppLocal.getIntString("button.refundall")); // NOI18N
        m_jbtnAddAll.setToolTipText(bundle.getString("tiptext.refundeverything")); // NOI18N
        m_jbtnAddAll.setFocusPainted(false);
        m_jbtnAddAll.setFocusable(false);
        m_jbtnAddAll.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddAll.setRequestFocusEnabled(false);
        m_jbtnAddAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddAllActionPerformed(evt);
            }
        });
        jPanel2.add(m_jbtnAddAll);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.add(jPanel1, java.awt.BorderLayout.EAST);

        add(jPanel3, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jbtnAddAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddAllActionPerformed
        for (Object m_aLine : m_aLines) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLine;
            if (oLine.getMultiply() > 0.0) {
                oLine.setProperty("orgLine", String.valueOf(oLine.getTicketLine()));
                TicketLineInfo oNewLine = new TicketLineInfo(oLine);
                oNewLine.setMultiply(-oLine.getMultiply());
                oLine.setRefundQty(oLine.getRefundQty() + oLine.getMultiply());
                oLine.setMultiply(oLine.getMultiply() - oLine.getMultiply());
                m_aLine = oLine;
                m_jTicketEdit.addTicketLine(oNewLine);
            }
        }
    }//GEN-LAST:event_m_jbtnAddAllActionPerformed


    private void m_jbtnAddOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddOneActionPerformed
        int index = ticketlines.getSelectedIndex();
        if (index >= 0) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLines.get(index);
            if (oLine.isProductCom()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        AppLocal.getIntString("message.refundauxiliaryitem")+ AppLocal.getIntString("button.refundone"),
                        "auxiliary Item", JOptionPane.WARNING_MESSAGE);
            } else if (oLine.getMultiply() > 0.0) {
                oLine.setProperty("orgLine", String.valueOf(index));
                oLine.setRefundQty(oLine.getRefundQty() + 1.0);
                oLine.setMultiply(oLine.getMultiply() - 1.0);
                m_aLines.set(index, oLine);
                TicketLineInfo oNewLine = new TicketLineInfo(oLine);
                oNewLine.setMultiply(-1.0);
                m_jTicketEdit.addTicketLine(oNewLine);

                if (index < m_aLines.size() - 1) {
                    oLine = (TicketLineInfo) m_aLines.get(++index);
                    while (index < m_aLines.size() && oLine.isProductCom()) {
                        oLine.setProperty("orgLine", String.valueOf(index));
                        oLine.setRefundQty(oLine.getRefundQty() + 1.0);
                        oLine.setMultiply(oLine.getMultiply() - 1.0);
                        m_aLines.set(index, oLine);
                        oNewLine = new TicketLineInfo(oLine);
                        oNewLine.setMultiply(-1.0);
                        m_jTicketEdit.addTicketLine(oNewLine);
                        try {
                            oLine = (TicketLineInfo) m_aLines.get(++index);
                        } catch (Exception ex) {
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_m_jbtnAddOneActionPerformed

    private void m_jbtnAddLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddLineActionPerformed
        int index = ticketlines.getSelectedIndex();
        if (index >= 0) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLines.get(index);
            if (oLine.isProductCom()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        AppLocal.getIntString("message.refundauxiliaryitem")+ AppLocal.getIntString("button.refundline"),
                        "auxiliary Item", JOptionPane.WARNING_MESSAGE);
            } else if (oLine.getMultiply() > 0.0) {
                oLine.setProperty("orgLine", String.valueOf(index));
                TicketLineInfo oNewLine = new TicketLineInfo(oLine);
                oNewLine.setMultiply(-oLine.getMultiply());
                oLine.setRefundQty(oLine.getRefundQty() + oLine.getMultiply());
                oLine.setMultiply(oLine.getMultiply() - oLine.getMultiply());
                m_aLines.set(index, oLine);
                m_jTicketEdit.addTicketLine(oNewLine);

                if (index < m_aLines.size() - 1) {
                    oLine = (TicketLineInfo) m_aLines.get(++index);
                    while (index < m_aLines.size() && oLine.isProductCom()) {
                        oLine.setProperty("orgLine", String.valueOf(index));
                        oNewLine = new TicketLineInfo(oLine);
                        oNewLine.setMultiply(-oLine.getMultiply());
                        oLine.setRefundQty(oLine.getRefundQty() + oLine.getMultiply());
                        oLine.setMultiply(oLine.getMultiply() - oLine.getMultiply());
                        m_aLines.set(index, oLine);
                        m_jTicketEdit.addTicketLine(oNewLine);
                        try {
                            oLine = (TicketLineInfo) m_aLines.get(++index);
                        } catch (Exception ex) {
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_m_jbtnAddLineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton m_jbtnAddAll;
    private javax.swing.JButton m_jbtnAddLine;
    private javax.swing.JButton m_jbtnAddOne;
    // End of variables declaration//GEN-END:variables

}
