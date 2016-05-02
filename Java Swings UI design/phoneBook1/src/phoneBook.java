import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.*;
import java.io.*;


public class phoneBook extends javax.swing.JFrame {

    
    //Creates new form phoneBook
    public phoneBook() {
        initComponents();
    }


    public static void main(String args[]) {

        //phoneBook phBk= new phoneBook();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new phoneBook().setVisible(true);
            }
        });
    }

    //This method is called from within the constructor to initialize the form.


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cntctSPanel = new javax.swing.JScrollPane();
        Tbl_contacts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        B_New = new javax.swing.JButton();
        B_Edit = new javax.swing.JButton();
        B_Save = new javax.swing.JButton();
        B_Delete = new javax.swing.JButton();
        dtlPanel = new javax.swing.JPanel();
        L_fName = new javax.swing.JLabel();
        javax.swing.JLabel L_mInit = new javax.swing.JLabel();
        javax.swing.JLabel L_lName = new javax.swing.JLabel();
        L_phone = new javax.swing.JLabel();
        L_gender = new javax.swing.JLabel();
        L_addrL1 = new javax.swing.JLabel();
        L_addrL2 = new javax.swing.JLabel();
        L_city = new javax.swing.JLabel();
        L_state = new javax.swing.JLabel();
        L_zipCd = new javax.swing.JLabel();
        T_fName = new javax.swing.JTextField();
        T_mInit = new javax.swing.JTextField();
        T_lName = new javax.swing.JTextField();
        T_phone = new javax.swing.JTextField();
        T_gender = new javax.swing.JComboBox();
        T_addrL1 = new javax.swing.JTextField();
        T_addrL2 = new javax.swing.JTextField();
        T_city = new javax.swing.JTextField();
        T_state = new javax.swing.JTextField();
        T_zipCd = new javax.swing.JTextField();
        L_status = new javax.swing.JLabel();
        PBar = new javax.swing.JProgressBar();
        L_country = new javax.swing.JLabel();
        T_country = new javax.swing.JTextField();
        L_email = new javax.swing.JLabel();
        T_email = new javax.swing.JTextField();
        B_Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setName("PhoneBook"); // NOI18N

        cntctSPanel.setBackground(new java.awt.Color(0, 204, 204));
        cntctSPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cntctSPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        cntctSPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        cntctSPanel.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        cntctSPanel.setAutoscrolls(true);
        cntctSPanel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cntctSPanel.setName("cntctSPanel"); // NOI18N

        String[] colNames = {"FirstName", "M", "LastName", "Phone"};
        Mdl_Tbl_contacts = new DefaultTableModel(colNames, 0);
        Tbl_contacts.setAutoCreateRowSorter(true);
        Tbl_contacts.setBackground(new java.awt.Color(0, 204, 255));
        Tbl_contacts.setModel(Mdl_Tbl_contacts);
        Tbl_contacts.setColumnSelectionAllowed(true);
        Tbl_contacts.setGridColor(new java.awt.Color(0, 204, 255));
        Tbl_contacts.setName("Tbl_contacts");
        Tbl_contacts.setSelectionBackground(new java.awt.Color(0, 204, 255));
        Tbl_contacts.getTableHeader().setReorderingAllowed(false);
        cntctSPanel.setViewportView(Tbl_contacts);
        Tbl_contacts.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        Tbl_contacts.getAccessibleContext().setAccessibleName("");
        fRead();
        Tbl_contacts.setModel(Mdl_Tbl_contacts);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        B_New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New.png"))); // NOI18N
        B_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_NewActionPerformed(evt);
            }
        });

        B_Edit.setBackground(new java.awt.Color(255, 255, 255));
        B_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit.png"))); // NOI18N
        B_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_EditActionPerformed(evt);
            }
        });

        B_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save.png"))); // NOI18N
        B_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SaveActionPerformed(evt);
            }
        });

        B_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete.png"))); // NOI18N
        B_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_DeleteActionPerformed(evt);
            }
        });

        dtlPanel.setBackground(new java.awt.Color(204, 255, 204));
        dtlPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dtlPanel.setName("dtlPanel"); // NOI18N

        L_fName.setText("First Name *");

        L_mInit.setText("Middle Initial");

        L_lName.setText("Last Name * ");

        L_phone.setText("Phone Number *");

        L_gender.setText("Gender ");

        L_addrL1.setText("Address Line 1");

        L_addrL2.setText("Address Line 2");

        L_city.setText("City");

        L_state.setText("State");

        L_zipCd.setText("Zip Code");

        T_fName.setColumns(20);
        T_fName.setDocument(new JTextFieldLimit(20));
        new textMandator(T_fName);

        T_fName.addFocusListener(new PBFocusListener(PBar));
        T_fName.setFocusCycleRoot(true);
        T_fName.setName("T_fName");

        T_mInit.setColumns(1);
        T_mInit.setDocument(new JTextFieldLimit(1));
        T_mInit.addFocusListener(new PBFocusListener(PBar));
        T_mInit.setName("T_mInit"); // NOI18N
        T_mInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_mInitActionPerformed(evt);
            }
        });

        T_lName.setColumns(20);
        T_lName.setDocument(new JTextFieldLimit(20));
        new textMandator(T_lName);
        T_lName.addFocusListener(new PBFocusListener(PBar));
        T_lName.setName("T_lName"); // NOI18N
        T_lName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_lNameActionPerformed(evt);
            }
        });

        T_phone.setColumns(21);
        T_phone.setDocument(new JTextFieldLimit(21));
        new textMandator(T_phone);
        T_phone.addFocusListener(new PBFocusListener(PBar));
        T_phone.setName("T_phone"); // NOI18N
        T_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_phoneActionPerformed(evt);
            }
        });

        T_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F", "O" }));
        T_gender.addFocusListener(new PBFocusListener(PBar));
        T_gender.setName("T_gender"); // NOI18N
        T_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_genderActionPerformed(evt);
            }
        });

        T_addrL1.setColumns(35);
        T_addrL1.setDocument(new JTextFieldLimit(35));
        T_addrL1.addFocusListener(new PBFocusListener(PBar));
        T_addrL1.setName("T_addrL1"); // NOI18N
        T_addrL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_addrL1ActionPerformed(evt);
            }
        });

        T_addrL2.setColumns(35);
        T_addrL2.setDocument(new JTextFieldLimit(35));
        T_addrL2.addFocusListener(new PBFocusListener(PBar));
        T_addrL2.setName("T_addrL2"); // NOI18N
        T_addrL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_addrL2ActionPerformed(evt);
            }
        });

        T_city.setColumns(25);
        T_city.setDocument(new JTextFieldLimit(25));
        T_city.addFocusListener(new PBFocusListener(PBar));
        T_city.setName("T_city"); // NOI18N
        T_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_cityActionPerformed(evt);
            }
        });

        T_state.setColumns(2);
        T_state.setDocument(new JTextFieldLimit(2));
        T_state.addFocusListener(new PBFocusListener(PBar));
        T_state.setName("T_state"); // NOI18N
        T_state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_stateActionPerformed(evt);
            }
        });

        T_zipCd.setColumns(9);
        T_zipCd.setDocument(new JTextFieldLimit(9));
        T_zipCd.addFocusListener(new PBFocusListener(PBar));
        T_zipCd.setName("T_zipCd"); // NOI18N
        T_zipCd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_zipCdActionPerformed(evt);
            }
        });

        PBar.setRequestFocusEnabled(false);
        PBar.setStringPainted(true);

        L_country.setText("Country");

        L_email.setText("Email*");

        javax.swing.GroupLayout dtlPanelLayout = new javax.swing.GroupLayout(dtlPanel);
        dtlPanel.setLayout(dtlPanelLayout);
        dtlPanelLayout.setHorizontalGroup(
            dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dtlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_status, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PBar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
            .addGroup(dtlPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_fName)
                    .addComponent(L_phone)
                    .addComponent(L_gender)
                    .addComponent(L_city)
                    .addComponent(L_state)
                    .addComponent(L_zipCd)
                    .addComponent(L_mInit)
                    .addComponent(L_lName)
                    .addComponent(L_addrL1)
                    .addComponent(L_addrL2)
                    .addComponent(L_country)
                    .addComponent(L_email))
                .addGap(57, 57, 57)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(T_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_country)
                    .addComponent(T_state)
                    .addComponent(T_city, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(T_addrL2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(T_addrL1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(T_email)
                    .addComponent(T_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(T_lName, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(T_fName, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(T_mInit)
                    .addComponent(T_zipCd, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        dtlPanelLayout.setVerticalGroup(
            dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtlPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(PBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_status, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_fName)
                    .addComponent(T_fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_mInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_mInit))
                .addGap(18, 18, 18)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_lName)
                    .addComponent(T_lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_phone)
                    .addComponent(T_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_email)
                    .addComponent(T_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_gender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_addrL1)
                    .addComponent(T_addrL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_addrL2)
                    .addComponent(T_addrL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dtlPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(L_city, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(L_state))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dtlPanelLayout.createSequentialGroup()
                        .addComponent(T_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(T_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_country)
                    .addComponent(T_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(dtlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_zipCd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_zipCd))
                .addContainerGap())
        );

        L_fName.getAccessibleContext().setAccessibleName("");
        L_mInit.getAccessibleContext().setAccessibleName("");
        L_lName.getAccessibleContext().setAccessibleName("");
        L_phone.getAccessibleContext().setAccessibleName("L_phone");
        L_gender.getAccessibleContext().setAccessibleName("L_gender");
        L_addrL1.getAccessibleContext().setAccessibleName("L_addrL1");
        L_addrL2.getAccessibleContext().setAccessibleName("L_addrL2");
        L_city.getAccessibleContext().setAccessibleName("L_city");
        L_state.getAccessibleContext().setAccessibleName("L_state");
        L_zipCd.getAccessibleContext().setAccessibleName("L_zipCd");
        T_fName.getAccessibleContext().setAccessibleName("");
        T_mInit.getAccessibleContext().setAccessibleName("");
        T_lName.getAccessibleContext().setAccessibleName("");
        T_phone.getAccessibleContext().setAccessibleName("");
        T_gender.getAccessibleContext().setAccessibleName("");
        T_addrL1.getAccessibleContext().setAccessibleName("");
        T_addrL2.getAccessibleContext().setAccessibleName("");
        T_city.getAccessibleContext().setAccessibleName("");
        T_zipCd.getAccessibleContext().setAccessibleName("");
        L_status.getAccessibleContext().setAccessibleName("L_status");
        T_country.setColumns(30);
        T_country.setDocument(new JTextFieldLimit(30));
        T_country.addFocusListener(new PBFocusListener(PBar));
        T_email.setColumns(10);
        T_email.setDocument(new JTextFieldLimit(10));
        new textMandator(T_email);
        T_email.addFocusListener(new PBFocusListener(PBar));

        B_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clear.png"))); // NOI18N
        B_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B_New, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(dtlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(B_New)
                        .addGap(18, 18, 18)
                        .addComponent(B_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(B_Delete)
                        .addGap(27, 27, 27)
                        .addComponent(B_Save)
                        .addGap(18, 18, 18)
                        .addComponent(B_Clear)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dtlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        B_New.getAccessibleContext().setAccessibleName("B_New");
        dtlPanel.getAccessibleContext().setAccessibleName("");
        T_fName.setNextFocusableComponent(T_mInit);
        T_mInit.setNextFocusableComponent(T_lName);
        T_lName.setNextFocusableComponent(T_phone);
        T_phone.setNextFocusableComponent(T_email);
        T_email.setNextFocusableComponent(T_gender);
        T_gender.setNextFocusableComponent(T_addrL1);
        T_addrL1.setNextFocusableComponent(T_addrL2);
        T_addrL2.setNextFocusableComponent(T_city);
        T_city.setNextFocusableComponent(T_state);
        T_state.setNextFocusableComponent(country);
        T_country.setNextFocusableComponent(T_zipCD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cntctSPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cntctSPanel)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cntctSPanel.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void T_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_cityActionPerformed

    }//GEN-LAST:event_T_cityActionPerformed

    private void T_addrL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_addrL2ActionPerformed

    }//GEN-LAST:event_T_addrL2ActionPerformed

    private void T_lNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_lNameActionPerformed

    }//GEN-LAST:event_T_lNameActionPerformed

    private void B_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_NewActionPerformed
        clearForm();
        edited = false;
        sRow = 0;
        added = true;
    }//GEN-LAST:event_B_NewActionPerformed

    private void B_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_EditActionPerformed

        added = false;
        L_status.setVisible(false); 
        PBar.setValue(0);
               
        sRow = Tbl_contacts.getSelectedRow();

        T_fName.setText(CList[sRow].fName);
	T_mInit.setText(CList[sRow].mInit);
	T_lName.setText(CList[sRow].lName);
	T_phone.setText(CList[sRow].phone);
        T_email.setText(CList[sRow].email);
	//T_gender.s
	T_addrL1.setText(CList[sRow].addrL1);
	T_addrL2.setText(CList[sRow].addrL2);
	T_city.setText(CList[sRow].city);
	T_state.setText(CList[sRow].state);
        T_country.setText(CList[sRow].country);
	T_zipCd.setText(CList[sRow].zipCd);
        edited = true;

    }//GEN-LAST:event_B_EditActionPerformed

    private void B_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SaveActionPerformed
        
        String fRef = "";
        String line = "";
        
        L_status.setVisible(false);
        
              
        if(!doValidations())
            return;
        
        if(edited == true)
        {   
            sRow = Tbl_contacts.getSelectedRow();

            fRef = CList[sRow].fRef;
            CList[sRow] = getFormData();
            CList[sRow].fRef = fRef;

            line = prepareLine(CList[sRow]);
            fUpdate(fRef,line);
            
            L_status.setForeground(Color.GREEN);
            L_status.setText("Contact Saved Successlly!!");
            L_status.setVisible(true);            
                        
            edited = false;
        }
        if (added == true)
        {   
            CList[listLen] = new Contact();
            CList[listLen] = getFormData();
            CList[listLen].fRef = Integer.toString(++maxfRef);

            line = prepareLine(CList[listLen]);
            listLen++;
            fAppend(line);
            
            L_status.setForeground(Color.GREEN);
            L_status.setText("Contact Saved Successlly!!");
            L_status.setVisible(true);  
        
            added = false;
        } 

    }//GEN-LAST:event_B_SaveActionPerformed

    private void B_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_DeleteActionPerformed
        String fRef = "";
        
        sRow = Tbl_contacts.getSelectedRow();
        fRef = CList[sRow].fRef;
        for (int i = sRow; i<listLen;i++)
            CList[i]= CList[i+1];
        listLen--;
        
        //fRef = Integer.valueOf((String)Mdl_Tbl_contacts.getValueAt(sRow,0));
        fUpdate(fRef,"");
        
        L_status.setForeground(Color.GREEN);
        L_status.setText("Contact Deleted Successlly!!");
        L_status.setVisible(true); 
    }//GEN-LAST:event_B_DeleteActionPerformed

    private void B_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ClearActionPerformed
        clearForm();
    }//GEN-LAST:event_B_ClearActionPerformed

    private void T_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_phoneActionPerformed

    }//GEN-LAST:event_T_phoneActionPerformed

    private void T_mInitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_mInitActionPerformed

    }//GEN-LAST:event_T_mInitActionPerformed

    private void T_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_genderActionPerformed

    }//GEN-LAST:event_T_genderActionPerformed

    private void T_addrL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_addrL1ActionPerformed

    }//GEN-LAST:event_T_addrL1ActionPerformed

    private void T_stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_stateActionPerformed

    }//GEN-LAST:event_T_stateActionPerformed

    private void T_zipCdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_zipCdActionPerformed

    }//GEN-LAST:event_T_zipCdActionPerformed

    
    boolean doValidations()
    {   
        String fName,lName, mInit ="";
        
        if(T_fName.getText().isEmpty()|| T_lName.getText().isEmpty() ||
           T_phone.getText().isEmpty())
        {
            L_status.setForeground(Color.ORANGE);
            L_status.setText("*Required Fields Empty!");
            L_status.setVisible(true);
            return false;
        }
        else
        {
            fName = T_fName.getText();
            mInit = T_mInit.getText();
            lName = T_lName.getText();
            
            for (int i = 0; i<listLen; i++)
            {   if (edited == true && i == sRow)
                    continue;
                if(fName.equals(CList[i].fName)&&
                   mInit.equals(CList[i].mInit)&&
                   lName.equals(CList[i].lName))
                {   
                    L_status.setForeground(Color.RED);
                    L_status.setText("Name Already Exists!");
                    L_status.setVisible(true);
                    return false;
                }
            }   
            
        }
        
        return true;
    }
    
    void clearForm()
    {  
        PBar.setValue(0);
        L_status.setText("");
        L_status.setVisible(false); 
        T_fName.setText("");
        T_mInit.setText("");
	T_lName.setText("");
	T_phone.setText("");
        T_email.setText("");
	T_addrL1.setText("");
	T_addrL2.setText("");
	T_city.setText("");
	T_state.setText("");
        T_country.setText("");
	T_zipCd.setText("");
        
        L_status.setForeground(Color.BLACK);
        L_status.setText("");
 
        
    }
 
    Contact getFormData()
    {   
        
        Contact c = new Contact();
        
        c.fRef = "";
        c.fName = T_fName.getText();
        c.mInit = T_mInit.getText();
        c.lName = T_lName.getText();
        c.phone = T_phone.getText();
        c.email = T_email.getText();
        c.gender = (String)T_gender.getSelectedItem();
        c.addrL1 = T_addrL1.getText();	
        c.addrL2 = T_addrL2.getText();	
        c.city = T_city.getText();	
        c.state = T_state.getText();
        c.country = T_country.getText();
        c.zipCd = T_zipCd.getText();
        return c;
    }

    String prepareLine(Contact c)
    {
        String line = "";

	line += c.fRef	 + "\t" ;
        line += c.fName  + "\t" ;
        line += c.mInit  + "\t" ;
        line += c.lName  + "\t" ;
        line += c.phone  + "\t" ;
        line += c.email + "\t";
        line += c.gender + "\t" ;
        line += c.addrL1 + "\t" ;
	line += c.addrL2 + "\t" ;
        line += c.city 	 + "\t" ;
        line += c.state  + "\t" ;
        line += c.country + "\t";
        line += c.zipCd  ;
        
        return line;
    }
    
    void sortList()
    {
        boolean swapped = true;
        int j = 0;
        Contact tmp = new Contact();
        while (swapped) 
        {
            swapped = false;
            j++;
            for (int i = 0; i < listLen - j; i++) 
            {
                if (CList[i].fName.compareToIgnoreCase( CList[i+1].fName)>0)
                {
                    tmp = CList[i];
                    CList[i] = CList[i + 1];
                    CList[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
    
    void displayList()
    {
        
        String[] Cdata = new String[4];
        
        sortList();
        
        Mdl_Tbl_contacts.setRowCount(0);
        Tbl_contacts.setModel(Mdl_Tbl_contacts);
        Tbl_contacts.revalidate();
                
        for(int i=0;i<listLen;i++)
        {
            Cdata[0] =  CList[i].fName;
            Cdata[1] =  CList[i].mInit;
            Cdata[2] =  CList[i].lName;                
            Cdata[3] =  CList[i].phone;
            
            Mdl_Tbl_contacts.addRow(Cdata);
        }                       

    }
    
    void fRead()
    {   

        String line;
        String words[] = new String[13];
        String Cdata[] = new String[13];

        listLen = 0;
        
        sRow = 0;
        try{
            File f = new File("Contacts.tsv");
            
            FileInputStream In_cntctFile = new FileInputStream(f);

            Scanner scan = new Scanner(In_cntctFile);
                        
            while (scan.hasNextLine())
            {
                
                line = scan.nextLine();
                //line = line.trim();
                words = line.split("\t");
                for (int i=0;i<words.length;i++)
                Cdata[i] = words[i];
                
                CList[listLen] = new Contact(Cdata);
                
                listLen++;
                
             }

            maxfRef = Integer.valueOf(CList[listLen-1].fRef);
        
            In_cntctFile.close();
            displayList();
       }
       catch(IOException ioe) 
       {
        JOptionPane.showMessageDialog(this, ioe, "Error reading data", JOptionPane.ERROR_MESSAGE);
       }
        
    }

  
    void fAppend (String line)
    {
        
        try{
            File f = new File("Contacts.tsv");
            FileOutputStream Out_cntctFile = new FileOutputStream(f,true); 
            
            line = line + "\r\n";
            Out_cntctFile.write(line.getBytes());      
            Out_cntctFile.close();
            
            displayList();
       }
       catch(IOException ioe) 
       {
            JOptionPane.showMessageDialog(this, ioe, "Error reading data", JOptionPane.ERROR_MESSAGE);
       }
    }
    
    void fUpdate(String fRef,String newLine)
    {
        try
        {
            String currentLine;
            
            fRef= fRef + "\t";
            File oldFile = new File("Contacts.tsv");
            File newFile = new File("NewContacts.tsv");

            BufferedReader reader = new BufferedReader(new FileReader(oldFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));

            while((currentLine = reader.readLine()) != null) {

                String trimmedLine = currentLine;
                if(trimmedLine.startsWith(fRef)) 
                {if (newLine=="")
                    continue;
                 else
                    currentLine = newLine; 
                }
                writer.write(currentLine);
                writer.write("\r\n");
            }
            writer.close();
            reader.close();
            boolean successful = oldFile.delete();
            
            successful = newFile.renameTo(oldFile);
 
            displayList(); 
            

            //fRead();
        }
       catch(IOException ioe) 
       {
            JOptionPane.showMessageDialog(this, ioe, "File Rewrite Error", JOptionPane.ERROR_MESSAGE);
       }  
    }
 
 
    private Contact CList[] = new Contact[200];
    private int listLen = 0;
    private DefaultTableModel Mdl_Tbl_contacts;

    private int sRow=0;
    private int maxfRef;
    private Boolean edited = false;
    private Boolean added = true ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Clear;
    private javax.swing.JButton B_Delete;
    private javax.swing.JButton B_Edit;
    private javax.swing.JButton B_New;
    private javax.swing.JButton B_Save;
    private javax.swing.JLabel L_addrL1;
    private javax.swing.JLabel L_addrL2;
    private javax.swing.JLabel L_city;
    private javax.swing.JLabel L_country;
    private javax.swing.JLabel L_email;
    private javax.swing.JLabel L_fName;
    private javax.swing.JLabel L_gender;
    private javax.swing.JLabel L_phone;
    private javax.swing.JLabel L_state;
    private javax.swing.JLabel L_status;
    private javax.swing.JLabel L_zipCd;
    private javax.swing.JProgressBar PBar;
    private javax.swing.JTextField T_addrL1;
    private javax.swing.JTextField T_addrL2;
    private javax.swing.JTextField T_city;
    private javax.swing.JTextField T_country;
    private javax.swing.JTextField T_email;
    javax.swing.JTextField T_fName;
    private javax.swing.JComboBox T_gender;
    private javax.swing.JTextField T_lName;
    javax.swing.JTextField T_mInit;
    private javax.swing.JTextField T_phone;
    private javax.swing.JTextField T_state;
    private javax.swing.JTextField T_zipCd;
    private javax.swing.JTable Tbl_contacts;
    private javax.swing.JScrollPane cntctSPanel;
    private javax.swing.JPanel dtlPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

class Contact 
{
    public String fRef;
    public String fName,mInit,lName;
    public String phone,email,gender;
    public String addrL1,addrL2;
    public String city,state,country,zipCd;

    public Contact()
    {}

    public Contact(String[] data)
    {
        int i = 0;

        fRef    = data[i++];
        fName	= data[i++];
        mInit	= data[i++];
        lName	= data[i++];
        phone	= data[i++];
        email   = data[i++];
        addrL1	= data[i++];
        addrL2	= data[i++];
        city	= data[i++];
        state	= data[i++];
        country = data[i++];
        zipCd	= data[i++];
    }

}

class JTextFieldLimit extends PlainDocument 
{
    private int limit;
    JTextFieldLimit(int limit) {
      super();
      this.limit = limit;
    }

    JTextFieldLimit(int limit, boolean upper) {
      super();
      this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
      if (str == null)
        return;

      if ((getLength() + str.length()) <= limit) {
        super.insertString(offset, str, attr);
      }
    }
}

class textMandator implements DocumentListener
{
    JTextComponent comp = null;
    Border dfBorder = null;
    Border hgltBorder = BorderFactory.createLineBorder(java.awt.Color.ORANGE);

    public textMandator(JTextComponent jtc) 
    {
        comp = jtc;
        dfBorder = comp.getBorder();
        comp.getDocument().addDocumentListener(this);
        this.Highlight();
    }
    
    public void insertUpdate(DocumentEvent e) { Highlight(); }
    public void removeUpdate(DocumentEvent e) { Highlight(); }
    public void changedUpdate(DocumentEvent e) { Highlight(); }
    
    private void Highlight() 
    { 
        if (comp.getText().trim().length() > 0)
            comp.setBorder(dfBorder);
        else
        {   comp.setBorder(hgltBorder);
            comp.setVisible(true);
            //comp.requestFocusInWindow();
        }
    }
    
}

class PBFocusListener implements FocusListener
{
    JProgressBar pbar;
    int offset = 9;
    
    PBFocusListener(JProgressBar pb)
    {
       pbar =  pb;
    }
    
    public void focusGained(FocusEvent e) {
        decreasePB();
      }

    public void focusLost(FocusEvent e) {
        increasePB();
    }
    
    void increasePB()
    {
        int pbVal = 0;
        System.out.println("PB updated");
        pbVal = pbar.getValue();
        pbVal = pbVal + (2*offset);
        pbar.setValue(pbVal);    
    } 
    
    void decreasePB()
    {   int pbVal = 0;
        System.out.println("PB updated");
        pbVal = pbar.getValue();
        if(pbVal>0)
            pbVal = pbVal - offset;
        pbar.setValue(pbVal);  
        
    }

}

