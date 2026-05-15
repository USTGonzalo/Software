/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DataBase.Conexion;
import Models.Tecnicos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import Models.equips;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Sistema extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Sistema.class.getName());

    /**
     * Creates new form Equipos
     */
    private int id = 0;

    private int idEquipo = 0;

    private int idPieza = 0;

    private ArrayList<equips> listaEquipos = new ArrayList<>();

    private Tecnicos tecnico;

    public Sistema(Tecnicos tecnico) {
        initComponents();

        this.tecnico = tecnico;
        setLocationRelativeTo(null);
        TxtTecnic.setText(tecnico.toString());
        BoxNewAdmin.removeAllItems();
        BoxNewAdmin.addItem("Normal");
        BoxNewAdmin.addItem("Admin");

        BoxEditAdmin.removeAllItems();
        BoxEditAdmin.addItem("Normal");
        BoxEditAdmin.addItem("Admin");

        cargarTabla();

        cargarTablaEquipos();

        cargarTablaPiezas();

        cargarEquipos();

        cargarMantenimientos();

        crearMenuTabla();

        BoxNewStatus.removeAllItems();
        BoxNewStatus.addItem("Lleno");
        BoxNewStatus.addItem("Medio");
        BoxNewStatus.addItem("Vacio");

        BoxEditStatus.removeAllItems();
        BoxEditStatus.addItem("Lleno");
        BoxEditStatus.addItem("Medio");
        BoxEditStatus.addItem("Vacio");
        TblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int fila = TblUsers.getSelectedRow();

                if (fila != -1) {
                    id = Integer.parseInt(TblUsers.getValueAt(fila, 0).toString());

                    TxtActualUser.setText(TblUsers.getValueAt(fila, 1).toString());
                    TxtActualPass.setText(TblUsers.getValueAt(fila, 2).toString());

                    boolean admin = Boolean.parseBoolean(
                            TblUsers.getValueAt(fila, 3).toString()
                    );

                    TxtActualAdmin.setText(admin ? "Admin" : "Normal");

                    // Cargar datos en edición
                    TxtEditUser.setText(TxtActualUser.getText());
                    TxtEditPass.setText(TxtActualPass.getText());

                    if (admin) {
                        BoxEditAdmin.setSelectedIndex(1);
                    } else {
                        BoxEditAdmin.setSelectedIndex(0);
                    }
                }
            }
        });

        TblEquips.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int fila = TblEquips.getSelectedRow();

                if (fila != -1) {
                    idEquipo = Integer.parseInt(
                            TblEquips.getValueAt(fila, 0).toString()
                    );

                    TxtEditType.setText(
                            TblEquips.getValueAt(fila, 1).toString()
                    );

                    TxtEditMarca.setText(
                            TblEquips.getValueAt(fila, 2).toString()
                    );

                    TxtEditModel.setText(
                            TblEquips.getValueAt(fila, 3).toString()
                    );

                    TxtEditNumber.setText(
                            TblEquips.getValueAt(fila, 4).toString()
                    );

                    TxtEditUbi.setText(
                            TblEquips.getValueAt(fila, 5).toString()
                    );
                }
            }
        });

        TblParts.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int fila = TblParts.getSelectedRow();

                if (fila != -1) {
                    idPieza = Integer.parseInt(
                            TblParts.getValueAt(fila, 0).toString()
                    );

                    TxtEditName.setText(
                            TblParts.getValueAt(fila, 1).toString()
                    );

                    TxtEditType2.setText(
                            TblParts.getValueAt(fila, 2).toString()
                    );

                    TxtEditMonth.setText(
                            TblParts.getValueAt(fila, 3).toString()
                    );

                    BoxEditStatus.setSelectedItem(
                            TblParts.getValueAt(fila, 4).toString()
                    );

                    TxtEditUbi2.setText(
                            TblParts.getValueAt(fila, 5).toString()
                    );
                }
            }
        });
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
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtActualUser = new javax.swing.JTextField();
        TxtActualPass = new javax.swing.JTextField();
        TxtActualAdmin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TxtEditUser = new javax.swing.JTextField();
        TxtEditPass = new javax.swing.JTextField();
        BtnUpdateTec = new javax.swing.JButton();
        BtnDeleteTec = new javax.swing.JButton();
        BoxEditAdmin = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblUsers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        TxtNewUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtNewPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        BoxNewAdmin = new javax.swing.JComboBox<>();
        BtnClearTec = new javax.swing.JButton();
        BtnCreateTec = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TblEquips = new javax.swing.JTable();
        jLabel50 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel51 = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel52 = new javax.swing.JLabel();
        TxtNewType = new javax.swing.JTextField();
        BtnClearEquip = new javax.swing.JButton();
        BtnCreateEquip = new javax.swing.JButton();
        TxtNewMarca = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        TxtNewModel = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        TxtNewNumber = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TxtNewUbi = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        TxtEditType = new javax.swing.JTextField();
        TxtEditModel = new javax.swing.JTextField();
        TxtEditMarca = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        TxtEditNumber = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        TxtEditUbi = new javax.swing.JTextArea();
        BtnDeleteEquip = new javax.swing.JButton();
        BtnEditEquip = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TblParts = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        jLabel64 = new javax.swing.JLabel();
        jSeparator33 = new javax.swing.JSeparator();
        jSeparator34 = new javax.swing.JSeparator();
        jLabel65 = new javax.swing.JLabel();
        TxtNewName = new javax.swing.JTextField();
        BtnClearPart = new javax.swing.JButton();
        BtnCreatePart = new javax.swing.JButton();
        TxtNewType2 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        TxtNewMonth = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        TxtNewUbi2 = new javax.swing.JTextArea();
        BoxNewStatus = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jSeparator35 = new javax.swing.JSeparator();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        TxtEditName = new javax.swing.JTextField();
        TxtEditMonth = new javax.swing.JTextField();
        TxtEditType2 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TxtEditUbi2 = new javax.swing.JTextArea();
        BtnDeletePart = new javax.swing.JButton();
        BtnEditPart = new javax.swing.JButton();
        BoxEditStatus = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        TblMain = new javax.swing.JTable();
        jLabel82 = new javax.swing.JLabel();
        jSeparator37 = new javax.swing.JSeparator();
        jLabel83 = new javax.swing.JLabel();
        jSeparator38 = new javax.swing.JSeparator();
        jSeparator39 = new javax.swing.JSeparator();
        jLabel84 = new javax.swing.JLabel();
        TxtNewType3 = new javax.swing.JTextField();
        BtnClearMain = new javax.swing.JButton();
        BtnCreateMain = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        TxtNewStatusEquip = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        TxtNewObs = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        TxtNewDesc = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        BoxEquip = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        TxtTecnic = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("SOFTWARE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Información actual");

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Información nueva");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Usuario:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Contraseña:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Permisos:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Usuario:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Contraseña:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Permisos:");

        BtnUpdateTec.setText("Actualizar");
        BtnUpdateTec.addActionListener(this::BtnUpdateTecActionPerformed);

        BtnDeleteTec.setText("Eliminar");
        BtnDeleteTec.addActionListener(this::BtnDeleteTecActionPerformed);

        BoxEditAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDeleteTec))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtActualPass)
                            .addComponent(TxtActualAdmin)
                            .addComponent(TxtActualUser))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtEditPass)
                            .addComponent(TxtEditUser)
                            .addComponent(BoxEditAdmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnUpdateTec)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(BtnDeleteTec))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TxtActualUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TxtActualPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TxtActualAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(BtnUpdateTec))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(TxtEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(TxtEditPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(BoxEditAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Contraseña", "Admin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblUsers);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tecnicos operativos");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nuevo tecnico");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Usuario");

        TxtNewUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Contraseña");

        TxtNewPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNewPass.setText("jPasswordField1");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Permisos de administrador");

        BoxNewAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BtnClearTec.setText("Limpiar");
        BtnClearTec.addActionListener(this::BtnClearTecActionPerformed);

        BtnCreateTec.setText("Crear");
        BtnCreateTec.addActionListener(this::BtnCreateTecActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewUser)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewPass)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoxNewAdmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(BtnCreateTec, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnClearTec, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxNewAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnClearTec)
                                    .addComponent(BtnCreateTec))))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tecnicos", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TblEquips.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Marca", "Modelo", "N° de serie", "Ubicación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(TblEquips);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Equipos operativos");

        jSeparator28.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Nuevo equipo");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Tipo");

        TxtNewType.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BtnClearEquip.setText("Limpiar");
        BtnClearEquip.addActionListener(this::BtnClearEquipActionPerformed);

        BtnCreateEquip.setText("Crear");
        BtnCreateEquip.addActionListener(this::BtnCreateEquipActionPerformed);

        TxtNewMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Marca");

        TxtNewModel.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Modelo");

        TxtNewNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("N° de serie");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Ubicación");

        TxtNewUbi.setColumns(20);
        TxtNewUbi.setLineWrap(true);
        TxtNewUbi.setRows(5);
        TxtNewUbi.setAutoscrolls(false);
        jScrollPane10.setViewportView(TxtNewUbi);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(jSeparator29)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator30)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewType)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(BtnCreateEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(BtnClearEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewMarca)
                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewModel)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewNumber)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator28)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnClearEquip)
                                    .addComponent(BtnCreateEquip))))))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel53.setText("Información actual");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setText("Tipo:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setText("Marca:");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setText("Modelo:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setText("N° de serie:");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setText("Ubicación:");

        TxtEditUbi.setColumns(20);
        TxtEditUbi.setLineWrap(true);
        TxtEditUbi.setRows(5);
        jScrollPane11.setViewportView(TxtEditUbi);

        BtnDeleteEquip.setText("Eliminar");
        BtnDeleteEquip.addActionListener(this::BtnDeleteEquipActionPerformed);

        BtnEditEquip.setText("Actualizar");
        BtnEditEquip.addActionListener(this::BtnEditEquipActionPerformed);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator31)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEditEquip)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDeleteEquip))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtEditType, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(TxtEditMarca)
                            .addComponent(TxtEditModel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11)
                            .addComponent(TxtEditNumber))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(BtnDeleteEquip)
                    .addComponent(BtnEditEquip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel59)
                                    .addComponent(TxtEditType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel60)
                                    .addComponent(TxtEditMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel63)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(TxtEditModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(TxtEditNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Equipos", jPanel3);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TblParts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Cantidad", "Estado", "Ubicación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(TblParts);

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Inventario de piezas");

        jSeparator32.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Nueva pieza");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Nombre");

        TxtNewName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BtnClearPart.setText("Limpiar");
        BtnClearPart.addActionListener(this::BtnClearPartActionPerformed);

        BtnCreatePart.setText("Crear");
        BtnCreatePart.addActionListener(this::BtnCreatePartActionPerformed);

        TxtNewType2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Tipo");

        TxtNewMonth.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Cantidad");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Estado");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Ubicación");

        TxtNewUbi2.setColumns(20);
        TxtNewUbi2.setLineWrap(true);
        TxtNewUbi2.setRows(5);
        TxtNewUbi2.setAutoscrolls(false);
        jScrollPane13.setViewportView(TxtNewUbi2);

        BoxNewStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lleno", "Medio", "vacio" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(jSeparator33)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator34)
                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(BtnCreatePart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(BtnClearPart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewType2)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewMonth)
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane13)
                    .addComponent(BoxNewStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator32)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jLabel64))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxNewStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnClearPart)
                                    .addComponent(BtnCreatePart))))))
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel70.setText("Información actual");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setText("Nombre:");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel72.setText("Tipo:");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel73.setText("Cantidad:");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setText("Estado:");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setText("Ubicación:");

        TxtEditUbi2.setColumns(20);
        TxtEditUbi2.setLineWrap(true);
        TxtEditUbi2.setRows(5);
        jScrollPane14.setViewportView(TxtEditUbi2);

        BtnDeletePart.setText("Eliminar");
        BtnDeletePart.addActionListener(this::BtnDeletePartActionPerformed);

        BtnEditPart.setText("Actualizar");
        BtnEditPart.addActionListener(this::BtnEditPartActionPerformed);

        BoxEditStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lleno", "medio", "vacio" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator35)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEditPart)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDeletePart))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtEditName, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(TxtEditType2)
                            .addComponent(TxtEditMonth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane14)
                            .addComponent(BoxEditStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(BtnDeletePart)
                    .addComponent(BtnEditPart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator35, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel71)
                                    .addComponent(TxtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel72)
                                    .addComponent(TxtEditType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel74)
                                    .addComponent(BoxEditStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel75)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(TxtEditMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Piezas", jPanel17);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID mantenimiento", "ID equipo", "Fecha", "Tipo", "Descripción", "Estado", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane16.setViewportView(TblMain);

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Historial de mantenciones");

        jSeparator37.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Nueva mantención");

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Tipo");

        TxtNewType3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BtnClearMain.setText("Limpiar");
        BtnClearMain.addActionListener(this::BtnClearMainActionPerformed);

        BtnCreateMain.setText("Crear");
        BtnCreateMain.addActionListener(this::BtnCreateMainActionPerformed);

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Descripción");

        TxtNewStatusEquip.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Estado del equipo");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Observaciones");

        TxtNewObs.setColumns(20);
        TxtNewObs.setLineWrap(true);
        TxtNewObs.setRows(5);
        TxtNewObs.setAutoscrolls(false);
        jScrollPane18.setViewportView(TxtNewObs);

        TxtNewDesc.setColumns(20);
        TxtNewDesc.setLineWrap(true);
        TxtNewDesc.setRows(5);
        TxtNewDesc.setAutoscrolls(false);
        jScrollPane19.setViewportView(TxtNewDesc);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Equipo");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Técnico a cargo");

        TxtTecnic.setEditable(false);
        TxtTecnic.setFocusable(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator38)
                    .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addComponent(jScrollPane16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(BtnCreateMain, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(BtnClearMain, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewStatusEquip, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewType3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoxEquip, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtTecnic, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator39, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator37)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addComponent(jLabel83))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jSeparator38, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane16))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jSeparator39, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtTecnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel84)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewType3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel85)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel87)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewStatusEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel88)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnClearMain)
                                    .addComponent(BtnCreateMain))))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mantenimientos", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Actualizaciones", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void crearMenuTabla() {
        JPopupMenu menu = new JPopupMenu();

        JMenuItem itemDetalles
                = new JMenuItem("Detalles");

        itemDetalles.addActionListener(e -> abrirDetalles());

        menu.add(itemDetalles);

        TblMain.setComponentPopupMenu(menu);
    }

    private void abrirDetalles() {
        int fila = TblMain.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null,
                    "Seleccione un mantenimiento");

            return;
        }

        int idMantenimiento
                = Integer.parseInt(
                        TblMain.getValueAt(fila, 0).toString()
                );

        new DetailsMain(idMantenimiento)
                .setVisible(true);
    }

    private void BtnEditPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditPartActionPerformed
        // TODO add your handling code here:
        if (idPieza == 0) {
            JOptionPane.showMessageDialog(null,
                    "Seleccione una pieza");
            return;
        }

        String nombre = TxtEditName.getText();
        String tipo = TxtEditType2.getText();
        int cantidad = Integer.parseInt(TxtEditMonth.getText());
        String estado = BoxEditStatus.getSelectedItem().toString();
        String ubicacion = TxtEditUbi2.getText();

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "UPDATE inventario_piezas SET nombre=?, tipo=?, cantidad=?, estado=?, ubicacion=? WHERE id_pieza=?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setInt(3, cantidad);
            ps.setString(4, estado);
            ps.setString(5, ubicacion);
            ps.setInt(6, idPieza);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Pieza actualizada");

            cargarTablaPiezas();

            ps.close();

        } catch (NumberFormatException e) {
            //System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se permiten numeros en el campo de cantidad", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            //System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error desconocido", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnEditPartActionPerformed

    private void BtnDeletePartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletePartActionPerformed
        // TODO add your handling code here:
        if (idPieza == 0) {
            JOptionPane.showMessageDialog(null,
                    "Seleccione una pieza");
            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "DELETE FROM inventario_piezas WHERE id_pieza=?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idPieza);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Pieza eliminada");

            cargarTablaPiezas();

            TxtEditName.setText("");
            TxtEditType2.setText("");
            TxtEditMonth.setText("");
            TxtEditUbi2.setText("");

            BoxEditStatus.setSelectedIndex(0);

            idPieza = 0;

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

        }
    }//GEN-LAST:event_BtnDeletePartActionPerformed

    private void BtnCreatePartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreatePartActionPerformed
        // TODO add your handling code here:
        String nombre = TxtNewName.getText();
        String tipo = TxtNewType2.getText();
        String cantidadText = TxtNewMonth.getText();
        String estado = BoxNewStatus.getSelectedItem().toString();
        String ubicacion = TxtNewUbi2.getText();

        if (nombre.isEmpty() || tipo.isEmpty()
                || cantidadText.isEmpty()
                || ubicacion.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Complete todos los campos");
            return;
        }

        int cantidad = Integer.parseInt(cantidadText);

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "INSERT INTO inventario_piezas(nombre, tipo, cantidad, estado, ubicacion) VALUES(?,?,?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setInt(3, cantidad);
            ps.setString(4, estado);
            ps.setString(5, ubicacion);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Pieza creada correctamente");

            cargarTablaPiezas();

            TxtNewName.setText("");
            TxtNewType2.setText("");
            TxtNewMonth.setText("");
            TxtNewUbi2.setText("");

            BoxNewStatus.setSelectedIndex(0);

            ps.close();

        } catch (NumberFormatException e) {
            //System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se permiten numeros en el campo de cantidad", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            //System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error desconocido", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnCreatePartActionPerformed

    private void BtnClearPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearPartActionPerformed
        // TODO add your handling code here:
        TxtNewName.setText("");
        TxtNewType2.setText("");
        TxtNewMonth.setText("");
        TxtNewUbi2.setText("");

        BoxNewStatus.setSelectedIndex(0);

    }//GEN-LAST:event_BtnClearPartActionPerformed

    private void BtnEditEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditEquipActionPerformed
        // TODO add your handling code here:
        if (idEquipo == 0) {
            JOptionPane.showMessageDialog(null,
                    "Seleccione un equipo");
            return;
        }

        String tipo = TxtEditType.getText();
        String marca = TxtEditMarca.getText();
        String modelo = TxtEditModel.getText();
        String numero = TxtEditNumber.getText();
        String ubi = TxtEditUbi.getText();

        if (tipo.isEmpty() || marca.isEmpty() || modelo.isEmpty()
                || numero.isEmpty() || ubi.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Complete todos los campos");
            return;
        }
        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "UPDATE equipos SET tipo_equipo=?, marca=?, modelo=?, numero_serie=?, ubicacion=? WHERE id_equipo=?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, tipo);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, numero);
            ps.setString(5, ubi);
            ps.setInt(6, idEquipo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Equipo actualizado");

            cargarTablaEquipos();

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {
            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnEditEquipActionPerformed

    private void BtnDeleteEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteEquipActionPerformed
        // TODO add your handling code here:
        if (idEquipo == 0) {
            JOptionPane.showMessageDialog(null,
                    "Seleccione un equipo");
            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "DELETE FROM equipos WHERE id_equipo = ?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idEquipo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Equipo eliminado");

            cargarTablaEquipos();

            TxtEditType.setText("");
            TxtEditMarca.setText("");
            TxtEditModel.setText("");
            TxtEditNumber.setText("");
            TxtEditUbi.setText("");

            idEquipo = 0;

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

        }
    }//GEN-LAST:event_BtnDeleteEquipActionPerformed

    private void BtnCreateEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreateEquipActionPerformed
        // TODO add your handling code here:
        String tipo = TxtNewType.getText();
        String marca = TxtNewMarca.getText();
        String modelo = TxtNewModel.getText();
        String numero = TxtNewNumber.getText();
        String ubi = TxtNewUbi.getText();

        if (tipo.isEmpty() || marca.isEmpty() || modelo.isEmpty()
                || numero.isEmpty() || ubi.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Complete todos los campos");
            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "INSERT INTO equipos(tipo_equipo, marca, modelo, numero_serie, ubicacion) VALUES(?,?,?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, tipo);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, numero);
            ps.setString(5, ubi);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Equipo creado correctamente");

            cargarTablaEquipos();

            TxtNewType.setText("");
            TxtNewMarca.setText("");
            TxtNewModel.setText("");
            TxtNewNumber.setText("");
            TxtNewUbi.setText("");

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

            cargarEquipos();
        }
    }//GEN-LAST:event_BtnCreateEquipActionPerformed

    private void BtnClearEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearEquipActionPerformed
        // TODO add your handling code here:
        TxtNewType.setText("");
        TxtNewMarca.setText("");
        TxtNewModel.setText("");
        TxtNewNumber.setText("");
        TxtNewUbi.setText("");
    }//GEN-LAST:event_BtnClearEquipActionPerformed

    private void BtnCreateTecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreateTecActionPerformed
        // TODO add your handling code here:
        String user = TxtNewUser.getText();
        String pass = String.valueOf(TxtNewPass.getPassword());

        int admin = BoxNewAdmin.getSelectedIndex();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Complete todos los campos");
            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "INSERT INTO tecnicos(user, password, admin) VALUES(?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, admin);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Técnico creado correctamente");

            TxtNewUser.setText("");
            TxtNewPass.setText("");
            BoxNewAdmin.setSelectedIndex(0);

            cargarTabla();
            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

        }
    }//GEN-LAST:event_BtnCreateTecActionPerformed

    private void BtnClearTecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearTecActionPerformed
        // TODO add your handling code here:
        TxtNewUser.setText("");
        TxtNewPass.setText("");

        BoxNewAdmin.setSelectedIndex(0);
    }//GEN-LAST:event_BtnClearTecActionPerformed

    private void BtnDeleteTecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteTecActionPerformed
        // TODO add your handling code here:
        if (id == 0) {
            JOptionPane.showMessageDialog(null,
                    "Seleccione un técnico");
            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "DELETE FROM tecnicos WHERE id_tecnico = ?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Técnico eliminado");

            cargarTabla();

            TxtActualUser.setText("");
            TxtActualPass.setText("");
            TxtActualAdmin.setText("");

            TxtEditUser.setText("");
            TxtEditPass.setText("");

            id = 0;

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

        }
    }//GEN-LAST:event_BtnDeleteTecActionPerformed

    private void BtnUpdateTecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateTecActionPerformed
        // TODO add your handling code here:
        if (id == 0) {
            JOptionPane.showMessageDialog(null,
                    "Seleccione un técnico");
            return;
        }

        String user = TxtEditUser.getText();
        String pass = TxtEditPass.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Complete todos los campos");
            return;
        }
        int admin = BoxEditAdmin.getSelectedIndex();

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "UPDATE tecnicos SET user = ?, password = ?, admin = ? WHERE id_tecnico = ?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, admin);
            ps.setInt(4, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Técnico actualizado");

            cargarTabla();

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

        }
    }//GEN-LAST:event_BtnUpdateTecActionPerformed

    private void BtnClearMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearMainActionPerformed
        // TODO add your handling code here:
        BoxEquip.setSelectedIndex(0);

        TxtNewType3.setText("");

        TxtNewDesc.setText("");

        TxtNewStatusEquip.setText("");

        TxtNewObs.setText("");
    }//GEN-LAST:event_BtnClearMainActionPerformed

    private void BtnCreateMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreateMainActionPerformed
        // TODO add your handling code here:      
        Connection cn = null;

        try {

            cn = Conexion.conectar();

            equips equipo = (equips) BoxEquip.getSelectedItem();

            String tipo = TxtNewType3.getText();
            String descripcion = TxtNewDesc.getText();
            String estado = TxtNewStatusEquip.getText();
            String observaciones = TxtNewObs.getText();

            int idTecnico = tecnico.getIdTecnico();

            String sql
                    = "INSERT INTO mantenimientos "
                    + "(id_equipo, fecha, tipo, descripcion, estado_equipo, observaciones, id_tecnico) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = cn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, equipo.getIdEquipo());
            ps.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            ps.setString(3, tipo);
            ps.setString(4, descripcion);
            ps.setString(5, estado);
            ps.setString(6, observaciones);
            ps.setInt(7, idTecnico);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            int idMantenimiento = 0;

            if (rs.next()) {
                idMantenimiento = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Mantenimiento registrado"
            );

            CheckParts check = new CheckParts(idMantenimiento);

            check.setLocationRelativeTo(null);
            check.setVisible(true);

            rs.close();
            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        } finally {
            cargarMantenimientos();
            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnCreateMainActionPerformed

    private void cargarMantenimientos() {

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                        "ID",
                        "Modelo",
                        "Serie",
                        "Fecha",
                        "Tipo",
                        "Descripción",
                        "Estado",
                        "Observaciones",
                        "Técnico"
                    }
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            TblMain.setModel(modelo);

            String sql
                    = "SELECT "
                    + "m.id_mantenimiento, "
                    + "e.modelo, "
                    + "e.numero_serie, "
                    + "m.fecha, "
                    + "m.tipo, "
                    + "m.descripcion, "
                    + "m.estado_equipo, "
                    + "m.observaciones, "
                    + "t.user AS tecnico "
                    + "FROM mantenimientos m "
                    + "INNER JOIN equipos e "
                    + "ON m.id_equipo = e.id_equipo "
                    + "LEFT JOIN tecnicos t "
                    + "ON m.id_tecnico = t.id_tecnico";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getInt("id_mantenimiento"),
                    rs.getString("modelo"),
                    rs.getString("numero_serie"),
                    rs.getDate("fecha"),
                    rs.getString("tipo"),
                    rs.getString("descripcion"),
                    rs.getString("estado_equipo"),
                    rs.getString("observaciones"),
                    rs.getString("tecnico")
                });
            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            Conexion.desconectar(cn);
        }
    }

    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Admin");

        TblUsers.setModel(modelo);

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "SELECT * FROM tecnicos";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object fila[] = new Object[4];

                fila[0] = rs.getInt("id_tecnico");
                fila[1] = rs.getString("user");
                fila[2] = rs.getString("password");
                fila[3] = rs.getBoolean("admin");

                modelo.addRow(fila);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

        }
    }

    private void cargarTablaEquipos() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Tipo");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Número Serie");
        modelo.addColumn("Ubicación");

        TblEquips.setModel(modelo);

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "SELECT * FROM equipos";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object fila[] = new Object[6];

                fila[0] = rs.getInt("id_equipo");
                fila[1] = rs.getString("tipo_equipo");
                fila[2] = rs.getString("marca");
                fila[3] = rs.getString("modelo");
                fila[4] = rs.getString("numero_serie");
                fila[5] = rs.getString("ubicacion");

                modelo.addRow(fila);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

        }
    }

    private void cargarEquipos() {
        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "SELECT * FROM equipos";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            BoxEquip.removeAllItems();

            listaEquipos.clear();

            while (rs.next()) {
                equips equipo = new equips();

                equipo.setIdEquipo(
                        rs.getInt("id_equipo")
                );

                equipo.setModelo(
                        rs.getString("modelo")
                );

                equipo.setNumeroSerie(
                        rs.getString("numero_serie")
                );

                listaEquipos.add(equipo);

                BoxEquip.addItem(equipo);
            }

            rs.close();

            ps.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        } finally {

            Conexion.desconectar(cn);
        }
    }

    private void cargarTablaPiezas() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Estado");
        modelo.addColumn("Ubicación");

        TblParts.setModel(modelo);

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql = "SELECT * FROM inventario_piezas";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object fila[] = new Object[6];

                fila[0] = rs.getInt("id_pieza");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("tipo");
                fila[3] = rs.getInt("cantidad");
                fila[4] = rs.getString("estado");
                fila[5] = rs.getString("ubicacion");

                modelo.addRow(fila);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            Conexion.desconectar(cn);

        }
    }

    /**
     * @param args the command line arguments
     */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> new Sistema().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxEditAdmin;
    private javax.swing.JComboBox<String> BoxEditStatus;
    private javax.swing.JComboBox<equips> BoxEquip;
    private javax.swing.JComboBox<String> BoxNewAdmin;
    private javax.swing.JComboBox<String> BoxNewStatus;
    private javax.swing.JButton BtnClearEquip;
    private javax.swing.JButton BtnClearMain;
    private javax.swing.JButton BtnClearPart;
    private javax.swing.JButton BtnClearTec;
    private javax.swing.JButton BtnCreateEquip;
    private javax.swing.JButton BtnCreateMain;
    private javax.swing.JButton BtnCreatePart;
    private javax.swing.JButton BtnCreateTec;
    private javax.swing.JButton BtnDeleteEquip;
    private javax.swing.JButton BtnDeletePart;
    private javax.swing.JButton BtnDeleteTec;
    private javax.swing.JButton BtnEditEquip;
    private javax.swing.JButton BtnEditPart;
    private javax.swing.JButton BtnUpdateTec;
    private javax.swing.JTable TblEquips;
    private javax.swing.JTable TblMain;
    private javax.swing.JTable TblParts;
    private javax.swing.JTable TblUsers;
    private javax.swing.JTextField TxtActualAdmin;
    private javax.swing.JTextField TxtActualPass;
    private javax.swing.JTextField TxtActualUser;
    private javax.swing.JTextField TxtEditMarca;
    private javax.swing.JTextField TxtEditModel;
    private javax.swing.JTextField TxtEditMonth;
    private javax.swing.JTextField TxtEditName;
    private javax.swing.JTextField TxtEditNumber;
    private javax.swing.JTextField TxtEditPass;
    private javax.swing.JTextField TxtEditType;
    private javax.swing.JTextField TxtEditType2;
    private javax.swing.JTextArea TxtEditUbi;
    private javax.swing.JTextArea TxtEditUbi2;
    private javax.swing.JTextField TxtEditUser;
    private javax.swing.JTextArea TxtNewDesc;
    private javax.swing.JTextField TxtNewMarca;
    private javax.swing.JTextField TxtNewModel;
    private javax.swing.JTextField TxtNewMonth;
    private javax.swing.JTextField TxtNewName;
    private javax.swing.JTextField TxtNewNumber;
    private javax.swing.JTextArea TxtNewObs;
    private javax.swing.JPasswordField TxtNewPass;
    private javax.swing.JTextField TxtNewStatusEquip;
    private javax.swing.JTextField TxtNewType;
    private javax.swing.JTextField TxtNewType2;
    private javax.swing.JTextField TxtNewType3;
    private javax.swing.JTextArea TxtNewUbi;
    private javax.swing.JTextArea TxtNewUbi2;
    private javax.swing.JTextField TxtNewUser;
    private javax.swing.JTextField TxtTecnic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
