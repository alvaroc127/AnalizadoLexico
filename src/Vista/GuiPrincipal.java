/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFileChooser;
import Controlador.ControladorGuiPrincipal;
import Negocio.AdministradorAutomatas;
import Negocio.AutomataDigito;
import Negocio.AutomataIdentificador;
import Negocio.AutomataLetra;
import Negocio.AutomatadeSimbolo;
/**
 *
 * @author felipe
 */
public class GuiPrincipal extends javax.swing.JFrame {
    /**
     * Creates new form GuiPrincipal
     */
    private JFileChooser fileCho;
    private ControladorGuiPrincipal guiCon;
    
    
    public GuiPrincipal() {
        initComponents();
        fileCho=new JFileChooser();
        guiCon=new ControladorGuiPrincipal(new AdministradorAutomatas(new AutomataLetra(new int[1]),new AutomataDigito(new int[1]), new AutomataIdentificador(new int[1]),new AutomatadeSimbolo(new int[1])));
        guiCon.createTabIni();
        guiCon.loadTable();
        jtSimbol.setModel(guiCon.getTab());
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
        btnBuscaArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSimbol = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txSourceCod = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txObje = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAnalizaArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscaArchivo.setText("Cargar Archivo");
        btnBuscaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaArchivoActionPerformed(evt);
            }
        });

        jtSimbol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtSimbol);

        txSourceCod.setColumns(20);
        txSourceCod.setRows(5);
        jScrollPane2.setViewportView(txSourceCod);

        txObje.setColumns(20);
        txObje.setRows(5);
        jScrollPane3.setViewportView(txObje);

        jLabel1.setText("Archivo Objeto");

        jLabel2.setText("Tabla de Simbolos");

        jLabel3.setText("Archivo Fuente");

        btnAnalizaArchivo.setText("Analizar Archivo");
        btnAnalizaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizaArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscaArchivo)
                        .addGap(341, 419, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnalizaArchivo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscaArchivo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAnalizaArchivo)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaArchivoActionPerformed
        // TODO add your handling code here:
        txSourceCod.setText("");
        fileCho.showOpenDialog(this);
        if(fileCho.getSelectedFile()!=null){
        guiCon.loadFile(fileCho.getSelectedFile());
        txSourceCod.append(guiCon.getTextSourceFile());
        }
    }//GEN-LAST:event_btnBuscaArchivoActionPerformed

    private void btnAnalizaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizaArchivoActionPerformed
        // TODO add your handling code here:
        if(fileCho.getSelectedFile()!=null){
            guiCon.StarALEX();
            txObje.append(guiCon.getTextObjFil());
            jtSimbol.removeAll();
            guiCon.loadTable();
            jtSimbol.setModel(guiCon.getTab());
        }
    }//GEN-LAST:event_btnAnalizaArchivoActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizaArchivo;
    private javax.swing.JButton btnBuscaArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtSimbol;
    private javax.swing.JTextArea txObje;
    private javax.swing.JTextArea txSourceCod;
    // End of variables declaration//GEN-END:variables
}
