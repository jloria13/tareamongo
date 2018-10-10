/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import com.sun.glass.events.KeyEvent;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import tareamongo.Conector;
import tareamongo.Pelicula;

/**
 *
 * @author jlori
 */
public class CRUDCompaniaProductora extends javax.swing.JFrame {

    Seleccion ventana_anterior;
    Conector Query;
    boolean Crear;
    ArrayList<CompaniaProductora> Companias;
    
    public CRUDCompaniaProductora() {
        initComponents();
    }

    public CRUDCompaniaProductora(Seleccion ventana) {
        ventana_anterior = ventana;
        initComponents();
        Crear = false;
        jPanelCreate.setVisible(false);
        jPanelDelete.setVisible(false);
        Query = new Conector();
        this.VerPelicula();
    }
    
    public void CrearPelicula(){
        try {
            String Duracion = TextDuracion.getText();
            String Fecha = TextFundacion.getText();
            Query.insertPelicula(TextNombre.getText(), TextGenero.getText(),
                    TextWeb.getText(), TextFranquicia.getText(),
                    Paises,Double.parseDouble(Duracion), Double.parseDouble(Fecha),
                    TextCompaniaProductora.getText(), Actores);
            JOptionPane.showMessageDialog(this, "Pelicula registrada", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            this.BorrarView();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar la película", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarCompania (){
        try {
            Query.deleteCompaniaProductora(TextNombreEliminar.getText());
            JOptionPane.showMessageDialog(this, "Compañía productora eliminada", "Eliminada", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar la compañía productora", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void VerPelicula(){
        try {
            Peliculas = Query.getPeliculas();
            for (Pelicula peli : Peliculas) {
                ModeloPeliculas.addElement(peli.Nombre);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "No se pudo cargar las películas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setPelicula(Pelicula peli){
        this.BorrarView();
        TextNombre.setText(peli.Nombre);
        TextWeb.setText(peli.Director);
        TextFranquicia.setText(peli.Franquicia);
        TextCompaniaProductora.setText(peli.Compania_productora);
        TextGenero.setText(peli.Genero);
        String duracion = ""+peli.Duracion;
        TextDuracion.setText(duracion.replace(".0", ""));
        String fecha = ""+peli.Fecha;
        TextFundacion.setText(fecha.replace(".0", ""));
        Actores = peli.Actores;
        for (String Actor:peli.Actores){
            ModeloActores.addElement(Actor);
        }
        Paises = peli.Paises;
        for (String Pais:peli.Paises){
            ModeloPaises.addElement(Pais);
        }
        jLabelModficarMensaje.setVisible(false);
        jLabelCrearMensaje.setVisible(false);
        jPanelView.setVisible(false);
        jPanelCreate.setVisible(true);
    }
    
    public void ActualizarPelicula(){
        try {
            String Duracion = TextDuracion.getText();
            String Fecha = TextFundacion.getText();
            Query.setPelicula(TextNombre.getText(), TextGenero.getText(),
                    TextWeb.getText(), TextFranquicia.getText(),
                    Paises, Double.parseDouble(Duracion), Double.parseDouble(Fecha),
                    TextCompaniaProductora.getText(), Actores);
            JOptionPane.showMessageDialog(this, "Pelicula ha sido actualizada", "Actualizada", JOptionPane.INFORMATION_MESSAGE);
            this.BorrarView();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la película", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BorrarView(){
        TextNombre.setText("");
        TextWeb.setText("");
        TextFundacion.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAdmin = new javax.swing.JPanel();
        LabelCrear = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        LabelEliminar = new javax.swing.JLabel();
        LabelModificar = new javax.swing.JLabel();
        jPanelCreate = new javax.swing.JPanel();
        jLabelCrearMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextNombre = new javax.swing.JTextField();
        TextWeb = new javax.swing.JTextField();
        TextFundacion = new javax.swing.JTextField();
        LabelGuardar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanelView = new javax.swing.JPanel();
        jLabelCrearMensaje2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListPeliculas = new javax.swing.JList<String>(ModeloPeliculas);
        jPanelDelete = new javax.swing.JPanel();
        jLabelCrearMensaje1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextNombreEliminar = new javax.swing.JTextField();
        LabelELIMINAR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelAdmin.setBackground(java.awt.Color.white);

        LabelCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelCrear.setForeground(new java.awt.Color(0, 153, 153));
        LabelCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCrear.setText("CREAR");
        LabelCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelCrearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelCrearMouseEntered(evt);
            }
        });

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/return.png"))); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
        });

        LabelEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelEliminar.setForeground(new java.awt.Color(0, 153, 153));
        LabelEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelEliminar.setText("ELIMINAR");
        LabelEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelEliminarMouseEntered(evt);
            }
        });

        LabelModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelModificar.setForeground(new java.awt.Color(0, 153, 153));
        LabelModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelModificar.setText("MODIFICAR");
        LabelModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelModificarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelModificar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Back)
                .addGap(79, 79, 79)
                .addComponent(LabelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(LabelModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(LabelEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        getContentPane().add(jPanelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 540));

        jPanelCreate.setBackground(new java.awt.Color(0, 153, 153));

        jLabelCrearMensaje.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelCrearMensaje.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCrearMensaje.setText("Crear una nueva compañía productora");

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Nombre:");

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Web:");

        TextNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        TextWeb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TextWeb.setText("http://");

        TextFundacion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        LabelGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelGuardar.setForeground(java.awt.Color.white);
        LabelGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelGuardar.setText("GUARDAR");
        LabelGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        LabelGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelGuardarMouseEntered(evt);
            }
        });

        jLabel8.setBackground(java.awt.Color.white);
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Fundacion:");

        javax.swing.GroupLayout jPanelCreateLayout = new javax.swing.GroupLayout(jPanelCreate);
        jPanelCreate.setLayout(jPanelCreateLayout);
        jPanelCreateLayout.setHorizontalGroup(
            jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreateLayout.createSequentialGroup()
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCreateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCrearMensaje))
                    .addGroup(jPanelCreateLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelCreateLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFundacion))
                            .addGroup(jPanelCreateLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextNombre))
                            .addGroup(jPanelCreateLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCreateLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        jPanelCreateLayout.setVerticalGroup(
            jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCrearMensaje)
                .addGap(133, 133, 133)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(TextWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LabelGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanelCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 680, 540));

        jPanelView.setBackground(new java.awt.Color(0, 153, 153));

        jLabelCrearMensaje2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelCrearMensaje2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCrearMensaje2.setText("Ver películas");

        jListPeliculas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jListPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPeliculasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListPeliculas);

        javax.swing.GroupLayout jPanelViewLayout = new javax.swing.GroupLayout(jPanelView);
        jPanelView.setLayout(jPanelViewLayout);
        jPanelViewLayout.setHorizontalGroup(
            jPanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelViewLayout.createSequentialGroup()
                .addGroup(jPanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelViewLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabelCrearMensaje2))
                    .addGroup(jPanelViewLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanelViewLayout.setVerticalGroup(
            jPanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelViewLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelCrearMensaje2)
                .addGap(86, 86, 86)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 680, 540));

        jPanelDelete.setBackground(new java.awt.Color(0, 153, 153));

        jLabelCrearMensaje1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelCrearMensaje1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCrearMensaje1.setText("Eliminar una película");

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Nombre:");

        TextNombreEliminar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        LabelELIMINAR.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelELIMINAR.setForeground(java.awt.Color.white);
        LabelELIMINAR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelELIMINAR.setText("ELIMINAR");
        LabelELIMINAR.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        LabelELIMINAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelELIMINARMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelELIMINARMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanelDeleteLayout = new javax.swing.GroupLayout(jPanelDelete);
        jPanelDelete.setLayout(jPanelDeleteLayout);
        jPanelDeleteLayout.setHorizontalGroup(
            jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteLayout.createSequentialGroup()
                .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDeleteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCrearMensaje1))
                    .addGroup(jPanelDeleteLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(TextNombreEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDeleteLayout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(LabelELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(284, Short.MAX_VALUE)))
        );
        jPanelDeleteLayout.setVerticalGroup(
            jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCrearMensaje1)
                .addGap(131, 131, 131)
                .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextNombreEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap(321, Short.MAX_VALUE))
            .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDeleteLayout.createSequentialGroup()
                    .addGap(249, 249, 249)
                    .addComponent(LabelELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(250, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanelDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 680, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        ventana_anterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        // TODO add your handling code here:
        Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BackMouseEntered

    private void LabelCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelCrearMouseClicked
        // TODO add your handling code here:
        this.BorrarView();
        jPanelCreate.setVisible(true);
        jLabelCrearMensaje.setVisible(true);  //Mensaje Crear
        jLabelModficarMensaje.setVisible(false);   //Mensaje Modificar
        jPanelDelete.setVisible(false);
        jPanelView.setVisible(false);
        Crear = true;
        Paises = new ArrayList<>();
        Actores = new ArrayList<>();
    }//GEN-LAST:event_LabelCrearMouseClicked

    private void LabelCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelCrearMouseEntered
        // TODO add your handling code here:
        LabelCrear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LabelCrearMouseEntered

    private void LabelEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelEliminarMouseClicked
        // TODO add your handling code here:
        jPanelCreate.setVisible(false);
        jPanelDelete.setVisible(true);
        jPanelView.setVisible(false);
        Crear = false;
    }//GEN-LAST:event_LabelEliminarMouseClicked

    private void LabelEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelEliminarMouseEntered
        // TODO add your handling code here:
        LabelEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LabelEliminarMouseEntered

    private void LabelELIMINARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelELIMINARMouseClicked
        // TODO add your handling code here:
        EliminarCompania();
    }//GEN-LAST:event_LabelELIMINARMouseClicked

    private void LabelELIMINARMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelELIMINARMouseEntered
        // TODO add your handling code here:
        LabelELIMINAR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LabelELIMINARMouseEntered

    private void jListPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPeliculasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            int valor = jListPeliculas.getSelectedIndex();
            try {
                Pelicula peli = Peliculas.get(valor);
                setPelicula(peli);
            } catch (Exception e) {
                Logger.getLogger(CRUDCompaniaProductora.class.getName()).log(Level.INFO, "message"+e);
                JOptionPane.showMessageDialog(this, "Se produjo un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jListPeliculasMouseClicked

    private void LabelModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelModificarMouseClicked
        // TODO add your handling code here:
        this.VerPelicula();
        jPanelCreate.setVisible(false);
        jLabelCrearMensaje.setVisible(false);  //Mensaje Crear
        jPanelView.setVisible(true);
        jPanelDelete.setVisible(false);
        Crear = false;
    }//GEN-LAST:event_LabelModificarMouseClicked

    private void LabelModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelModificarMouseEntered
        // TODO add your handling code here:
        LabelModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LabelModificarMouseEntered

    private void LabelGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelGuardarMouseEntered
        // TODO add your handling code here:
        LabelGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LabelGuardarMouseEntered

    private void LabelGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelGuardarMouseClicked
        // TODO add your handling code here:
        if (this.Crear){
            CrearPelicula();
        }else{
            ActualizarPelicula();
        }
    }//GEN-LAST:event_LabelGuardarMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUDCompaniaProductora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDCompaniaProductora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDCompaniaProductora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDCompaniaProductora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDCompaniaProductora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JLabel LabelCrear;
    private javax.swing.JLabel LabelELIMINAR;
    private javax.swing.JLabel LabelEliminar;
    private javax.swing.JLabel LabelGuardar;
    private javax.swing.JLabel LabelModificar;
    private javax.swing.JTextField TextFundacion;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JTextField TextNombreEliminar;
    private javax.swing.JTextField TextWeb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCrearMensaje;
    private javax.swing.JLabel jLabelCrearMensaje1;
    private javax.swing.JLabel jLabelCrearMensaje2;
    private javax.swing.JList<String> jListPeliculas;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelCreate;
    private javax.swing.JPanel jPanelDelete;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
