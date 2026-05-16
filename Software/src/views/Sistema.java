/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DataBase.Conexion;
import Models.Software;
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

        cargarSoftwares();

        cargarSoftware();

        cargarActualizacionesSoftware();

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
        jLabel100 = new javax.swing.JLabel();
        BoxSoftware = new javax.swing.JComboBox<>();
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
        jLabel80 = new javax.swing.JLabel();
        BoxEditSoftware = new javax.swing.JComboBox<>();
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
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        TblSoftware = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        jSeparator43 = new javax.swing.JSeparator();
        jLabel96 = new javax.swing.JLabel();
        jSeparator44 = new javax.swing.JSeparator();
        jSeparator45 = new javax.swing.JSeparator();
        jLabel97 = new javax.swing.JLabel();
        TxtNewSoftwareName = new javax.swing.JTextField();
        BtnClearSoftware = new javax.swing.JButton();
        BtnCreateSoftware = new javax.swing.JButton();
        TxtNewSoftwareVersion = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        TxtNewSoftwareStatus = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        TxtNewSoftwareDesc = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jSeparator46 = new javax.swing.JSeparator();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        TxtEditSoftwareName = new javax.swing.JTextField();
        TxtEditSoftwareNewVersion = new javax.swing.JTextField();
        TxtEditSoftwareVersion = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        TxtEditSoftwareStatus = new javax.swing.JTextField();
        jScrollPane22 = new javax.swing.JScrollPane();
        TxtEditSoftwareDesc = new javax.swing.JTextArea();
        BtnDeleteSoftware = new javax.swing.JButton();
        BtnEditSoftware = new javax.swing.JButton();
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
        jPanel12 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        TblActSoftwares = new javax.swing.JTable();
        jLabel76 = new javax.swing.JLabel();
        jSeparator36 = new javax.swing.JSeparator();
        jLabel77 = new javax.swing.JLabel();
        jSeparator40 = new javax.swing.JSeparator();
        jSeparator41 = new javax.swing.JSeparator();
        jLabel78 = new javax.swing.JLabel();
        BtnClearMake = new javax.swing.JButton();
        BtnMakeAct = new javax.swing.JButton();
        BoxEquips2 = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        TxtActualVersion = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        TxtNewVersion = new javax.swing.JTextField();
        BoxStatus = new javax.swing.JComboBox<>();
        jLabel95 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        TxtSoftware = new javax.swing.JTextField();
        TxtObs = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jSeparator42 = new javax.swing.JSeparator();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        TxtEditSoftware = new javax.swing.JTextField();
        TxtEditVersionAct = new javax.swing.JTextField();
        TxtOldVersion = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        TxtEditObsAct = new javax.swing.JTextArea();
        BtnDeleteMake = new javax.swing.JButton();
        BtnEditMake = new javax.swing.JButton();
        BoxEditStatusAct = new javax.swing.JComboBox<>();

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

        TxtActualUser.setEditable(false);

        TxtActualPass.setEditable(false);

        TxtActualAdmin.setEditable(false);

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

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Software a instalar");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(BtnClearEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewMarca)
                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewModel)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewNumber)
                    .addComponent(jScrollPane10)
                    .addComponent(BoxSoftware, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(jLabel100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxSoftware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel80.setText("Software:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11)
                            .addComponent(TxtEditNumber)
                            .addComponent(BoxEditSoftware, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addComponent(TxtEditNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(TxtEditModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BoxEditSoftware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80))
                        .addGap(2, 2, 2)))
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
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
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

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TblSoftware.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Versión Antigua", "Última versión", "Versión Actual", "Estado", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblSoftware.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblSoftwareMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(TblSoftware);

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Software existente");

        jSeparator43.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("Nuevo software");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Nombre");

        TxtNewSoftwareName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        BtnClearSoftware.setText("Limpiar");
        BtnClearSoftware.addActionListener(this::BtnClearSoftwareActionPerformed);

        BtnCreateSoftware.setText("Crear");
        BtnCreateSoftware.addActionListener(this::BtnCreateSoftwareActionPerformed);

        TxtNewSoftwareVersion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Versión actual");

        TxtNewSoftwareStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Estado");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("Descripción");

        TxtNewSoftwareDesc.setColumns(20);
        TxtNewSoftwareDesc.setLineWrap(true);
        TxtNewSoftwareDesc.setRows(5);
        TxtNewSoftwareDesc.setAutoscrolls(false);
        jScrollPane21.setViewportView(TxtNewSoftwareDesc);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(jSeparator44)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator43, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator45)
                    .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewSoftwareName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(BtnCreateSoftware, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(BtnClearSoftware, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewSoftwareVersion)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNewSoftwareStatus)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane21))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator43)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addComponent(jLabel96))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jSeparator44, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jSeparator45, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewSoftwareName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewSoftwareVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel99)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewSoftwareStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel101)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnClearSoftware)
                                    .addComponent(BtnCreateSoftware))))))
                .addContainerGap())
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel102.setText("Información actual");

        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel103.setText("Nombre:");

        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel104.setText("Versión Actual:");

        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel105.setText("Versión Nueva:");

        TxtEditSoftwareVersion.setEditable(false);
        TxtEditSoftwareVersion.setFocusable(false);

        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel106.setText("Estado:");

        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel107.setText("Descripción");

        TxtEditSoftwareDesc.setColumns(20);
        TxtEditSoftwareDesc.setLineWrap(true);
        TxtEditSoftwareDesc.setRows(5);
        jScrollPane22.setViewportView(TxtEditSoftwareDesc);

        BtnDeleteSoftware.setText("Eliminar");
        BtnDeleteSoftware.addActionListener(this::BtnDeleteSoftwareActionPerformed);

        BtnEditSoftware.setText("Actualizar");
        BtnEditSoftware.addActionListener(this::BtnEditSoftwareActionPerformed);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator46)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEditSoftware)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDeleteSoftware))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel103, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtEditSoftwareName, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(TxtEditSoftwareVersion)
                            .addComponent(TxtEditSoftwareNewVersion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane22)
                            .addComponent(TxtEditSoftwareStatus))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(BtnDeleteSoftware)
                    .addComponent(BtnEditSoftware))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator46, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel103)
                                    .addComponent(TxtEditSoftwareName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel104)
                                    .addComponent(TxtEditSoftwareVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel106)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel107)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel105)
                            .addComponent(TxtEditSoftwareNewVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(TxtEditSoftwareStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Software", jPanel15);

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
                    .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
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

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TblActSoftwares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Equipo", "Software", "Versión anterior", "Versión nueva", "Fecha", "Tecnico", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblActSoftwares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblActSoftwaresMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(TblActSoftwares);

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Actualizaciones de software");

        jSeparator36.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Nueva actualización");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Equipo");

        BtnClearMake.setText("Limpiar");
        BtnClearMake.addActionListener(this::BtnClearMakeActionPerformed);

        BtnMakeAct.setText("Realizar");
        BtnMakeAct.addActionListener(this::BtnMakeActActionPerformed);

        BoxEquips2.addActionListener(this::BoxEquips2ActionPerformed);

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Versión actual");

        TxtActualVersion.setEditable(false);
        TxtActualVersion.setBackground(new java.awt.Color(153, 153, 153));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Versión nueva");

        BoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Exitosa", "Fallida" }));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Estado");

        jLabel108.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("Software instalado");

        TxtSoftware.setEditable(false);
        TxtSoftware.setBackground(new java.awt.Color(153, 153, 153));

        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("Observación");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator40)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addComponent(jScrollPane15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(TxtSoftware)
                            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(TxtActualVersion)
                            .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(TxtNewVersion)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(BtnMakeAct, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtnClearMake, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator41, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BoxEquips2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator36)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76)
                            .addComponent(jLabel77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jSeparator40, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jSeparator41, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxEquips2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel108)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtSoftware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtActualVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel86)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNewVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel95)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel109)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnClearMake)
                                    .addComponent(BtnMakeAct))))))
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel89.setText("Información actual");

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setText("Software:");

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel91.setText("Versión anterior:");

        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel92.setText("Versión actualizada:");

        TxtEditSoftware.setEditable(false);

        TxtOldVersion.setEditable(false);

        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel93.setText("Estado:");

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel94.setText("Observación:");

        TxtEditObsAct.setColumns(20);
        TxtEditObsAct.setLineWrap(true);
        TxtEditObsAct.setRows(5);
        jScrollPane20.setViewportView(TxtEditObsAct);

        BtnDeleteMake.setText("Eliminar");
        BtnDeleteMake.addActionListener(this::BtnDeleteMakeActionPerformed);

        BtnEditMake.setText("Actualizar");
        BtnEditMake.addActionListener(this::BtnEditMakeActionPerformed);

        BoxEditStatusAct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Exitosa", "Fallida" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator42)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEditMake)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDeleteMake))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel92, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtEditSoftware, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(TxtOldVersion)
                            .addComponent(TxtEditVersionAct))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane20)
                            .addComponent(BoxEditStatusAct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(BtnDeleteMake)
                    .addComponent(BtnEditMake))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator42, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel90)
                                    .addComponent(TxtEditSoftware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel91)
                                    .addComponent(TxtOldVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BoxEditStatusAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel93))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel94)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(TxtEditVersionAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        JMenuItem itemEliminar
                = new JMenuItem("Eliminar");

        itemDetalles.addActionListener(e -> abrirDetalles());

        itemEliminar.addActionListener(e -> eliminarMantenimiento());

        menu.add(itemDetalles);
        menu.add(itemEliminar);

        TblMain.setComponentPopupMenu(menu);
    }

    private void eliminarMantenimiento() {

        int fila = TblMain.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione un mantenimiento"
            );

            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar este mantenimiento?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        int idMantenimiento
                = Integer.parseInt(
                        TblMain.getValueAt(fila, 0).toString()
                );

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sqlDetalle
                    = "DELETE FROM detalle_mantenimiento "
                    + "WHERE id_mantenimiento = ?";

            PreparedStatement psDetalle
                    = cn.prepareStatement(sqlDetalle);

            psDetalle.setInt(1, idMantenimiento);

            psDetalle.executeUpdate();

            psDetalle.close();

            String sqlMain
                    = "DELETE FROM mantenimientos "
                    + "WHERE id_mantenimiento = ?";

            PreparedStatement psMain
                    = cn.prepareStatement(sqlMain);

            psMain.setInt(1, idMantenimiento);

            psMain.executeUpdate();

            psMain.close();

            JOptionPane.showMessageDialog(
                    null,
                    "Mantenimiento eliminado correctamente"
            );

            cargarMantenimientos();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
    }

    private void cargarSoftwares() {

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            BoxSoftware.removeAllItems();

            String sql = "SELECT * FROM softwares";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Software software = new Software();

                software.setIdSoftware(
                        rs.getInt("id_software")
                );

                software.setNombre(
                        rs.getString("nombre")
                );

                BoxSoftware.addItem(software);
                BoxEditSoftware.addItem(software);

            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            System.out.println(
                    "Error cargando softwares: "
                    + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
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

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione un equipo"
            );

            return;
        }

        String tipo = TxtEditType.getText();
        String marca = TxtEditMarca.getText();
        String modelo = TxtEditModel.getText();
        String numero = TxtEditNumber.getText();
        String ubi = TxtEditUbi.getText();

        Software software
                = (Software) BoxEditSoftware.getSelectedItem();

        if (tipo.isEmpty()
                || marca.isEmpty()
                || modelo.isEmpty()
                || numero.isEmpty()
                || ubi.isEmpty()
                || software == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Complete todos los campos"
            );

            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql
                    = "UPDATE equipos SET "
                    + "tipo_equipo=?, "
                    + "marca=?, "
                    + "modelo=?, "
                    + "numero_serie=?, "
                    + "ubicacion=?, "
                    + "id_software=? "
                    + "WHERE id_equipo=?";

            PreparedStatement ps
                    = cn.prepareStatement(sql);

            ps.setString(1, tipo);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, numero);
            ps.setString(5, ubi);

            ps.setInt(
                    6,
                    software.getIdSoftware()
            );

            ps.setInt(7, idEquipo);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Equipo actualizado"
            );

            cargarTablaEquipos();

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );

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

        Software software
                = (Software) BoxSoftware.getSelectedItem();

        if (tipo.isEmpty()
                || marca.isEmpty()
                || modelo.isEmpty()
                || numero.isEmpty()
                || ubi.isEmpty()
                || software == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Complete todos los campos"
            );

            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            String sql
                    = "INSERT INTO equipos("
                    + "tipo_equipo, "
                    + "marca, "
                    + "modelo, "
                    + "numero_serie, "
                    + "ubicacion, "
                    + "id_software"
                    + ") VALUES(?,?,?,?,?,?)";

            PreparedStatement ps
                    = cn.prepareStatement(sql);

            ps.setString(1, tipo);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, numero);
            ps.setString(5, ubi);

            ps.setInt(
                    6,
                    software.getIdSoftware()
            );

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Equipo creado correctamente"
            );

            cargarTablaEquipos();

            TxtNewType.setText("");
            TxtNewMarca.setText("");
            TxtNewModel.setText("");
            TxtNewNumber.setText("");
            TxtNewUbi.setText("");

            BoxSoftware.setSelectedIndex(0);

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );

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

    private void BtnClearMakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearMakeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnClearMakeActionPerformed

    private void BtnMakeActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMakeActActionPerformed
        equips equipo = (equips) BoxEquips2.getSelectedItem();

        if (equipo == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione un equipo"
            );

            return;
        }

        String software = TxtSoftware.getText();
        String versionActual = TxtActualVersion.getText();
        String nuevaVersion = TxtNewVersion.getText();
        String estado = BoxStatus.getSelectedItem().toString();
        String observaciones = TxtObs.getText();

        if (software.isEmpty()
                || versionActual.isEmpty()
                || nuevaVersion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Complete todos los campos"
            );

            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            /*
            OBTENER ID DEL SOFTWARE
             */
            String sqlSoftware
                    = "SELECT id_software "
                    + "FROM softwares "
                    + "WHERE nombre = ?";

            PreparedStatement psSoftware
                    = cn.prepareStatement(sqlSoftware);

            psSoftware.setString(1, software);

            ResultSet rs = psSoftware.executeQuery();

            int idSoftware = 0;

            if (rs.next()) {

                idSoftware = rs.getInt("id_software");

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Software no encontrado"
                );

                return;
            }

            rs.close();
            psSoftware.close();

            /*
            INSERTAR EN TABLA software
             */
            String sqlInsert
                    = "INSERT INTO software "
                    + "(id_equipo, id_software_catalogo, "
                    + "fecha_actualizacion, id_tecnico, estado, observaciones) "
                    + "VALUES (?, ?, NOW(), ?, ?, ?)";

            PreparedStatement psInsert
                    = cn.prepareStatement(sqlInsert);

            psInsert.setInt(1, equipo.getIdEquipo());
            psInsert.setInt(2, idSoftware);
            psInsert.setInt(3, tecnico.getIdTecnico());
            psInsert.setString(4, estado);
            psInsert.setString(5, observaciones);

            psInsert.executeUpdate();

            psInsert.close();

            /*
            SOLO SI LA ACTUALIZACION ES EXITOSA
             */
            if (estado.equals("Exitosa")) {

                String sqlUpdate
                        = "UPDATE softwares SET "
                        + "version_antigua = version_actual, "
                        + "version_actual = ?, "
                        + "ultima_version = ? "
                        + "WHERE id_software = ?";

                PreparedStatement psUpdate
                        = cn.prepareStatement(sqlUpdate);

                psUpdate.setString(1, nuevaVersion);
                psUpdate.setString(2, nuevaVersion);
                psUpdate.setInt(3, idSoftware);

                psUpdate.executeUpdate();

                psUpdate.close();
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Actualización realizada correctamente"
            );

            cargarActualizacionesSoftware();
            cargarSoftware();

            /*
            LIMPIAR CAMPOS
             */
            TxtSoftware.setText("");
            TxtActualVersion.setText("");
            TxtNewVersion.setText("");
            TxtObs.setText("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnMakeActActionPerformed

    private void BtnDeleteMakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteMakeActionPerformed
        // TODO add your handling code here:
        int fila = TblActSoftwares.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione una actualización"
            );

            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar esta actualización?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            int idActualizacion = Integer.parseInt(
                    TblActSoftwares.getValueAt(fila, 0).toString()
            );

            String sql
                    = "DELETE FROM software "
                    + "WHERE id_software = ?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idActualizacion);

            ps.executeUpdate();

            ps.close();

            JOptionPane.showMessageDialog(
                    null,
                    "Actualización eliminada correctamente"
            );

            cargarActualizacionesSoftware();

            /*
            LIMPIAR CAMPOS
             */
            TxtEditSoftware.setText("");
            TxtOldVersion.setText("");
            TxtEditVersionAct.setText("");
            TxtEditObsAct.setText("");

            BoxEditStatusAct.setSelectedIndex(0);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnDeleteMakeActionPerformed

    private void BtnEditMakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditMakeActionPerformed
        // TODO add your handling code here:
        int fila = TblActSoftwares.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione una actualización"
            );

            return;
        }

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            int idRegistro = Integer.parseInt(
                    TblActSoftwares.getValueAt(fila, 0).toString()
            );

            String nuevaVersion = TxtEditVersionAct.getText();
            String estado = BoxEditStatusAct.getSelectedItem().toString();
            String observaciones = TxtEditObsAct.getText();

            /*
            ACTUALIZAR TABLA software
             */
            String sql
                    = "UPDATE software SET "
                    + "estado = ?, "
                    + "observaciones = ? "
                    + "WHERE id_software = ?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, estado);
            ps.setString(2, observaciones);
            ps.setInt(3, idRegistro);

            ps.executeUpdate();

            ps.close();

            /*
            SOLO SI ES EXITOSA
             */
            if (estado.equals("Exitosa")) {

                /*
                OBTENER ID SOFTWARE CATALOGO
                 */
                String sqlGet
                        = "SELECT id_software_catalogo "
                        + "FROM software "
                        + "WHERE id_software = ?";

                PreparedStatement psGet
                        = cn.prepareStatement(sqlGet);

                psGet.setInt(1, idRegistro);

                ResultSet rs = psGet.executeQuery();

                int idSoftwareCatalogo = 0;

                if (rs.next()) {

                    idSoftwareCatalogo = rs.getInt(
                            "id_software_catalogo"
                    );
                }

                rs.close();
                psGet.close();

                /*
                ACTUALIZAR VERSIONES
                 */
                String sqlUpdate
                        = "UPDATE softwares SET "
                        + "version_antigua = version_actual, "
                        + "version_actual = ?, "
                        + "ultima_version = ? "
                        + "WHERE id_software = ?";

                PreparedStatement psUpdate
                        = cn.prepareStatement(sqlUpdate);

                psUpdate.setString(1, nuevaVersion);
                psUpdate.setString(2, nuevaVersion);
                psUpdate.setInt(3, idSoftwareCatalogo);

                psUpdate.executeUpdate();

                psUpdate.close();
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Actualización realizada"
            );

            cargarActualizacionesSoftware();
            cargarSoftware();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnEditMakeActionPerformed

    private void BtnClearSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearSoftwareActionPerformed
        // TODO add your handling code here:
        TxtNewSoftwareName.setText("");
        TxtNewSoftwareVersion.setText("");
        TxtNewSoftwareStatus.setText("");
        TxtNewSoftwareDesc.setText("");

        TxtEditSoftwareName.setText("");
        TxtEditSoftwareVersion.setText("");
        TxtEditSoftwareNewVersion.setText("");
        TxtEditSoftwareStatus.setText("");
        TxtEditSoftwareDesc.setText("");

        TblSoftware.clearSelection();
    }//GEN-LAST:event_BtnClearSoftwareActionPerformed

    private void BtnCreateSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreateSoftwareActionPerformed
        // TODO add your handling code here:
        Connection cn = null;

        try {

            String nombre = TxtNewSoftwareName.getText();
            String version = TxtNewSoftwareVersion.getText();
            String estado = TxtNewSoftwareStatus.getText();
            String descripcion = TxtNewSoftwareDesc.getText();

            if (nombre.isEmpty()
                    || version.isEmpty()
                    || estado.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Complete los campos"
                );

                return;
            }

            cn = Conexion.conectar();

            String sql
                    = "INSERT INTO softwares "
                    + "(nombre, version_antigua, ultima_version, version_actual, estado, descripcion) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, nombre);

            // version antigua
            ps.setString(2, version);

            // ultima version
            ps.setString(3, version);

            // version actual
            ps.setString(4, version);

            ps.setString(5, estado);
            ps.setString(6, descripcion);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Software registrado"
            );

            cargarSoftware();

            TxtNewSoftwareName.setText("");
            TxtNewSoftwareVersion.setText("");
            TxtNewSoftwareStatus.setText("");
            TxtNewSoftwareDesc.setText("");

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnCreateSoftwareActionPerformed

    private void BtnDeleteSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteSoftwareActionPerformed
        // TODO add your handling code here:
        int fila = TblSoftware.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione un software"
            );

            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(
                null,
                "¿Desea eliminar este software?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }

        Connection cn = null;

        try {

            int idSoftware = Integer.parseInt(
                    TblSoftware.getValueAt(fila, 0).toString()
            );

            cn = Conexion.conectar();

            String sql
                    = "DELETE FROM softwares "
                    + "WHERE id_software = ?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, idSoftware);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Software eliminado"
            );

            cargarSoftware();

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnDeleteSoftwareActionPerformed

    private void BtnEditSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditSoftwareActionPerformed
        int fila = TblSoftware.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione un software"
            );

            return;
        }

        Connection cn = null;

        try {

            int idSoftware = Integer.parseInt(
                    TblSoftware.getValueAt(fila, 0).toString()
            );

            String nombre = TxtEditSoftwareName.getText();

            String versionActual
                    = TxtEditSoftwareVersion.getText();

            String ultimaVersion
                    = TxtEditSoftwareNewVersion.getText();

            String estado
                    = TxtEditSoftwareStatus.getText();

            String descripcion
                    = TxtEditSoftwareDesc.getText();

            if (nombre.isEmpty()
                    || versionActual.isEmpty()
                    || ultimaVersion.isEmpty()
                    || estado.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Complete los campos"
                );

                return;
            }

            cn = Conexion.conectar();

            String sql
                    = "UPDATE softwares SET "
                    + "nombre = ?, "
                    + "ultima_version = ?, "
                    + "version_actual = ?, "
                    + "estado = ?, "
                    + "descripcion = ? "
                    + "WHERE id_software = ?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, ultimaVersion);
            ps.setString(3, versionActual);
            ps.setString(4, estado);
            ps.setString(5, descripcion);
            ps.setInt(6, idSoftware);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Software actualizado"
            );

            cargarSoftware();

            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BtnEditSoftwareActionPerformed

    private void TblSoftwareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblSoftwareMouseClicked
        // TODO add your handling code here:
        int fila = TblSoftware.getSelectedRow();

        if (fila == -1) {
            return;
        }

        TxtEditSoftwareName.setText(
                TblSoftware.getValueAt(fila, 1).toString()
        );

        TxtEditSoftwareVersion.setText(
                TblSoftware.getValueAt(fila, 4).toString()
        );

        Object nuevaVersion
                = TblSoftware.getValueAt(fila, 3);

        TxtEditSoftwareNewVersion.setText(
                nuevaVersion != null
                        ? nuevaVersion.toString()
                        : ""
        );

        TxtEditSoftwareStatus.setText(
                TblSoftware.getValueAt(fila, 5).toString()
        );

        Object descripcion
                = TblSoftware.getValueAt(fila, 6);

        TxtEditSoftwareDesc.setText(
                descripcion != null
                        ? descripcion.toString()
                        : ""
        );
    }//GEN-LAST:event_TblSoftwareMouseClicked

    private void BoxEquips2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxEquips2ActionPerformed
        // TODO add your handling code here:
        Connection cn = null;

        try {

            equips equipo = (equips) BoxEquips2.getSelectedItem();

            if (equipo == null) {
                return;
            }

            cn = Conexion.conectar();

            String sql
                    = "SELECT "
                    + "s.id_software, "
                    + "s.nombre, "
                    + "s.version_actual, "
                    + "s.ultima_version "
                    + "FROM equipos e "
                    + "INNER JOIN softwares s "
                    + "ON e.id_software = s.id_software "
                    + "WHERE e.id_equipo = ?";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, equipo.getIdEquipo());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                TxtSoftware.setText(
                        rs.getString("nombre")
                );

                TxtActualVersion.setText(
                        rs.getString("version_actual")
                );

                TxtNewVersion.setText(
                        rs.getString("ultima_version")
                );

            } else {

                TxtSoftware.setText("");
                TxtActualVersion.setText("");
                TxtNewVersion.setText("");
            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage());

        } finally {

            Conexion.desconectar(cn);
        }
    }//GEN-LAST:event_BoxEquips2ActionPerformed

    private void TblActSoftwaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblActSoftwaresMouseClicked
        // TODO add your handling code here:

        int fila = TblActSoftwares.getSelectedRow();

        if (fila == -1) {
            return;
        }

        /*
        CARGAR DATOS EN LOS CAMPOS
         */
        TxtEditSoftware.setText(
                TblActSoftwares.getValueAt(fila, 2).toString()
        );

        TxtOldVersion.setText(
                TblActSoftwares.getValueAt(fila, 3).toString()
        );

        Object versionNueva = TblActSoftwares.getValueAt(fila, 4);

        TxtEditVersionAct.setText(
                versionNueva != null
                        ? versionNueva.toString()
                        : ""
        );

        Object estado = TblActSoftwares.getValueAt(fila, 7);

        if (estado != null) {

            BoxEditStatusAct.setSelectedItem(
                    estado.toString()
            );
        }
    }//GEN-LAST:event_TblActSoftwaresMouseClicked

    private void cargarSoftware() {

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            DefaultTableModel modelo
                    = (DefaultTableModel) TblSoftware.getModel();

            modelo.setRowCount(0);

            String sql = "SELECT * FROM softwares";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getInt("id_software"),
                    rs.getString("nombre"),
                    rs.getString("version_antigua"),
                    rs.getString("ultima_version"),
                    rs.getString("version_actual"),
                    rs.getString("estado"),
                    rs.getString("descripcion")
                });
            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            Conexion.desconectar(cn);
        }
    }

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

    private void cargarActualizacionesSoftware() {

        Connection cn = null;

        try {

            cn = Conexion.conectar();

            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                        "ID",
                        "Equipo",
                        "Software",
                        "Versión anterior",
                        "Versión nueva",
                        "Fecha",
                        "Técnico",
                        "Estado"
                    }
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            TblActSoftwares.setModel(modelo);

            String sql
                    = "SELECT "
                    + "s.id_software, "
                    + "e.modelo, "
                    + "sw.nombre, "
                    + "sw.version_antigua, "
                    + "sw.version_actual, "
                    + "s.fecha_actualizacion, "
                    + "t.user AS tecnico, "
                    + "s.estado "
                    + "FROM software s "
                    + "INNER JOIN equipos e "
                    + "ON s.id_equipo = e.id_equipo "
                    + "INNER JOIN softwares sw "
                    + "ON s.id_software_catalogo = sw.id_software "
                    + "LEFT JOIN tecnicos t "
                    + "ON s.id_tecnico = t.id_tecnico "
                    + "ORDER BY s.id_software DESC";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getInt("id_software"),
                    rs.getString("modelo"),
                    rs.getString("nombre"),
                    rs.getString("version_antigua"),
                    rs.getString("version_actual"),
                    rs.getDate("fecha_actualizacion"),
                    rs.getString("tecnico"),
                    rs.getString("estado")
                });
            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage()
            );

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
                BoxEquips2.addItem(equipo);
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
    private javax.swing.JComboBox<Software> BoxEditSoftware;
    private javax.swing.JComboBox<String> BoxEditStatus;
    private javax.swing.JComboBox<String> BoxEditStatusAct;
    private javax.swing.JComboBox<equips> BoxEquip;
    private javax.swing.JComboBox<equips> BoxEquips2;
    private javax.swing.JComboBox<String> BoxNewAdmin;
    private javax.swing.JComboBox<String> BoxNewStatus;
    private javax.swing.JComboBox<Software> BoxSoftware;
    private javax.swing.JComboBox<String> BoxStatus;
    private javax.swing.JButton BtnClearEquip;
    private javax.swing.JButton BtnClearMain;
    private javax.swing.JButton BtnClearMake;
    private javax.swing.JButton BtnClearPart;
    private javax.swing.JButton BtnClearSoftware;
    private javax.swing.JButton BtnClearTec;
    private javax.swing.JButton BtnCreateEquip;
    private javax.swing.JButton BtnCreateMain;
    private javax.swing.JButton BtnCreatePart;
    private javax.swing.JButton BtnCreateSoftware;
    private javax.swing.JButton BtnCreateTec;
    private javax.swing.JButton BtnDeleteEquip;
    private javax.swing.JButton BtnDeleteMake;
    private javax.swing.JButton BtnDeletePart;
    private javax.swing.JButton BtnDeleteSoftware;
    private javax.swing.JButton BtnDeleteTec;
    private javax.swing.JButton BtnEditEquip;
    private javax.swing.JButton BtnEditMake;
    private javax.swing.JButton BtnEditPart;
    private javax.swing.JButton BtnEditSoftware;
    private javax.swing.JButton BtnMakeAct;
    private javax.swing.JButton BtnUpdateTec;
    private javax.swing.JTable TblActSoftwares;
    private javax.swing.JTable TblEquips;
    private javax.swing.JTable TblMain;
    private javax.swing.JTable TblParts;
    private javax.swing.JTable TblSoftware;
    private javax.swing.JTable TblUsers;
    private javax.swing.JTextField TxtActualAdmin;
    private javax.swing.JTextField TxtActualPass;
    private javax.swing.JTextField TxtActualUser;
    private javax.swing.JTextField TxtActualVersion;
    private javax.swing.JTextField TxtEditMarca;
    private javax.swing.JTextField TxtEditModel;
    private javax.swing.JTextField TxtEditMonth;
    private javax.swing.JTextField TxtEditName;
    private javax.swing.JTextField TxtEditNumber;
    private javax.swing.JTextArea TxtEditObsAct;
    private javax.swing.JTextField TxtEditPass;
    private javax.swing.JTextField TxtEditSoftware;
    private javax.swing.JTextArea TxtEditSoftwareDesc;
    private javax.swing.JTextField TxtEditSoftwareName;
    private javax.swing.JTextField TxtEditSoftwareNewVersion;
    private javax.swing.JTextField TxtEditSoftwareStatus;
    private javax.swing.JTextField TxtEditSoftwareVersion;
    private javax.swing.JTextField TxtEditType;
    private javax.swing.JTextField TxtEditType2;
    private javax.swing.JTextArea TxtEditUbi;
    private javax.swing.JTextArea TxtEditUbi2;
    private javax.swing.JTextField TxtEditUser;
    private javax.swing.JTextField TxtEditVersionAct;
    private javax.swing.JTextArea TxtNewDesc;
    private javax.swing.JTextField TxtNewMarca;
    private javax.swing.JTextField TxtNewModel;
    private javax.swing.JTextField TxtNewMonth;
    private javax.swing.JTextField TxtNewName;
    private javax.swing.JTextField TxtNewNumber;
    private javax.swing.JTextArea TxtNewObs;
    private javax.swing.JPasswordField TxtNewPass;
    private javax.swing.JTextArea TxtNewSoftwareDesc;
    private javax.swing.JTextField TxtNewSoftwareName;
    private javax.swing.JTextField TxtNewSoftwareStatus;
    private javax.swing.JTextField TxtNewSoftwareVersion;
    private javax.swing.JTextField TxtNewStatusEquip;
    private javax.swing.JTextField TxtNewType;
    private javax.swing.JTextField TxtNewType2;
    private javax.swing.JTextField TxtNewType3;
    private javax.swing.JTextArea TxtNewUbi;
    private javax.swing.JTextArea TxtNewUbi2;
    private javax.swing.JTextField TxtNewUser;
    private javax.swing.JTextField TxtNewVersion;
    private javax.swing.JTextField TxtObs;
    private javax.swing.JTextField TxtOldVersion;
    private javax.swing.JTextField TxtSoftware;
    private javax.swing.JTextField TxtTecnic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
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
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
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
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
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
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
