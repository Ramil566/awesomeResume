/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.company.panel;

import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.main.Config;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramil Abbaszade
 */
public class SkillsPanel extends javax.swing.JPanel {
    SkillDaoInter skillDao=new SkillDaoImpl();
    UserSkillDaoInter userSkillDao=new UserSkillDaoImpl();
    UserDaoInter userDao=new UserDaoImpl();
    private List<Skill> skills;
    List<UserSkill> userSkills;
    private User loggedInUser;
    /**
     * Creates new form ProfilePanel
     */
    public SkillsPanel() {
        initComponents();
    }
    
    private void initVariables(){
        loggedInUser=Config.loggedInUser;
        int id=loggedInUser.getId();
        userSkills=userSkillDao.getAllSkillByUserId(id);
    }
    
    public void fillTable(){
        fillWindow();
        Vector<Vector> rows=new Vector<Vector>();
        
        for(UserSkill us:userSkills){
            Vector row=new Vector();
            row.add(us.getSkill());
            row.add(us.getPower());
            rows.add(row);
        }
        
        DefaultTableModel DTM=new DefaultTableModel(rows,new Vector(Arrays.asList("Skill","Power")));

        tblSkills.setModel(DTM);
    }
    
    public void fillWindow(){
        skills=skillDao.getAllSkill();
        for(Skill s: skills)
            cbSkill.addItem(s);
    }
    
    public void fillUserComponents(){
        initVariables();
        fillTable();
    }
    
    public void fillUser(){
        loggedInUser.setSkills(userSkills); 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSkills = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblSkill = new javax.swing.JLabel();
        txtSkillName = new javax.swing.JTextField();
        lblPower = new javax.swing.JLabel();
        sliderPower = new javax.swing.JSlider();
        cbSkill = new javax.swing.JComboBox<>();
        btdAdd = new javax.swing.JButton();
        btdDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(tblSkills);

        lblSkill.setText("Skill");

        txtSkillName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSkillNameActionPerformed(evt);
            }
        });

        lblPower.setText("Power");

        sliderPower.setMaximum(10);
        sliderPower.setMinimum(1);
        sliderPower.setPaintLabels(true);
        sliderPower.setPaintTicks(true);

        btdAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btdAdd.setText("+");
        btdAdd.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdAddActionPerformed(evt);
            }
        });

        btdDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btdDelete.setText("-");
        btdDelete.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSkill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSkillName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPower)
                        .addGap(18, 18, 18)
                        .addComponent(sliderPower, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(211, 211, 211))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSkill)
                        .addComponent(lblPower)
                        .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSkillName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sliderPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSkillNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSkillNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSkillNameActionPerformed

    private void btdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdDeleteActionPerformed
        // TODO add your handling code here:
        int index=tblSkills.getSelectedRow();
        userSkills.remove(index);
        
        fillTable();  
    }//GEN-LAST:event_btdDeleteActionPerformed

    private void btdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdAddActionPerformed
        // TODO add your handling code here:
        String skillName=txtSkillName.getText();
        int power=sliderPower.getValue(); 
        Skill newSkill=null;
        int index;
        if(skillName!=null&&!skillName.trim().isEmpty()){
            newSkill=new Skill(null,skillName);
            index=skillDao.addSkill(newSkill);
            newSkill.setId(index);
        }else{
            newSkill=(Skill)cbSkill.getSelectedItem();
        }

        userSkills.add(new UserSkill(null,loggedInUser,newSkill,power));
        
        fillTable();
    }//GEN-LAST:event_btdAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String skillName=txtSkillName.getText();
        int power=sliderPower.getValue(); 
        int index;
        Skill newSkill=null;
        if(skillName!=null&&!skillName.trim().isEmpty()){
            newSkill=new Skill(null,skillName);
            index=skillDao.addSkill(newSkill);
            newSkill.setId(index);
        }else{
            newSkill=(Skill)cbSkill.getSelectedItem();
        }
        userSkills.get(tblSkills.getSelectedRow()).setPower(power);
        userSkills.get(tblSkills.getSelectedRow()).setSkill(newSkill);
        fillTable();
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdAdd;
    private javax.swing.JButton btdDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Skill> cbSkill;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPower;
    private javax.swing.JLabel lblSkill;
    private javax.swing.JSlider sliderPower;
    private javax.swing.JTable tblSkills;
    private javax.swing.JTextField txtSkillName;
    // End of variables declaration//GEN-END:variables
}
