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
public class CRUDPelicula extends javax.swing.JFrame {

    Seleccion ventana_anterior;
    DefaultListModel ModeloPaises,ModeloActores,ModeloPeliculas;
    Conector Query;
    ArrayList<String> Paises,Actores;
    ArrayList<Pelicula> Peliculas;
    boolean Crear;
    
    public CRUDPelicula() {
        initComponents();
    }

    public CRUDPelicula(Seleccion ventana) {
        ModeloPaises = new DefaultListModel();
        ModeloActores = new DefaultListModel();
        ModeloPeliculas = new DefaultListModel();
        ventana_anterior = ventana;
        initComponents();
        Crear = false;
        jLabelModficarMensaje.setVisible(false);
        jPanelCreate.setVisible(false);
        jPanelDelete.setVisible(false);
        Query = new Conector();
        this.VerPelicula();
    }
    
    public void CrearPelicula(){
        try {
            String Duracion = TextDuracion.getText();
            String Fecha = TextFecha.getText();
            Query.insertPelicula(TextNombre.getText(), TextGenero.getText(),
                    TextDirector.getText(), TextFranquicia.getText(),
                    Paises,Double.parseDouble(Duracion), Double.parseDouble(Fecha),
                    TextCompaniaProductora.getText(), Actores);
            JOptionPane.showMessageDialog(this, "Pelicula registrada", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            this.BorrarView();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar la película", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarPelicula (){
        try {
            Query.deletePelicula(TextNombreEliminar.getText());
            JOptionPane.showMessageDialog(this, "Pelicula eliminada", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar la película", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void VerPelicula(){
        try {
            ModeloPeliculas.removeAllElements();
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
        TextDirector.setText(peli.Director);
        TextFranquicia.setText(peli.Franquicia);
        TextCompaniaProductora.setText(peli.Compania_productora);
        TextGenero.setText(peli.Genero);
        String duracion = ""+peli.Duracion;
        TextDuracion.setText(duracion.replace(".0", ""));
        String fecha = ""+peli.Fecha;
        TextFecha.setText(fecha.replace(".0", ""));
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
            String Fecha = TextFecha.getText();
            Query.setPelicula(TextNombre.getText(), TextGenero.getText(),
                    TextDirector.getText(), TextFranquicia.getText(),
                    Paises, Double.parseDouble(Duracion), Double.parseDouble(Fecha),
                    TextCompaniaProductora.getText(), Actores);
            JOptionPane.showMessageDialog(this, "Pelicula ha sido actualizada", "Actualizada", JOptionPane.INFORMATION_MESSAGE);
            this.BorrarView();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la película", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BorrarView(){
        ModeloPaises.removeAllElements();
        ModeloActores.removeAllElements();
        TextActor.setText("");
        TextPais.setText("");
        TextNombre.setText("");
        TextDirector.setText("");
        TextGenero.setText("");
        TextFecha.setText("");
        TextCompaniaProductora.setText("");
        TextFranquicia.setText("");
        TextDuracion.setText("");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPaises = new javax.swing.JList<String>(ModeloPaises);
        TextNombre = new javax.swing.JTextField();
        TextDirector = new javax.swing.JTextField();
        TextFranquicia = new javax.swing.JTextField();
        TextGenero = new javax.swing.JTextField();
        TextFecha = new javax.swing.JTextField();
        TextActor = new javax.swing.JTextField();
        TextPais = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListActores = new javax.swing.JList<String>(ModeloActores);
        LabelGuardar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextCompaniaProductora = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TextDuracion = new javax.swing.JTextField();
        jLabelModficarMensaje = new javax.swing.JLabel();
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
        jLabelCrearMensaje.setText("Crear una nueva película");

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Nombre:");

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Director:");

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Franquicia:");

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Genero:");

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Pais de producción:");

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Actores:");

        jListPaises.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jListPaises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPaisesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListPaises);

        TextNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        TextDirector.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        TextFranquicia.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        TextGenero.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        TextFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        TextActor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TextActor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextActorKeyPressed(evt);
            }
        });

        TextPais.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TextPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextPaisKeyPressed(evt);
            }
        });

        jListActores.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jListActores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListActoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListActores);

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
        jLabel8.setText("Fecha:");

        jLabel9.setBackground(java.awt.Color.white);
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Compañía productora:");

        TextCompaniaProductora.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel10.setBackground(java.awt.Color.white);
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Duración:");

        TextDuracion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabelModficarMensaje.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelModficarMensaje.setForeground(new java.awt.Color(255, 255, 255));
        jLabelModficarMensaje.setText("Modificar una película");

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
                        .addGap(34, 34, 34)
                        .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCreateLayout.createSequentialGroup()
                                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCreateLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextNombre))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCreateLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCreateLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelCreateLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanelCreateLayout.createSequentialGroup()
                                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCreateLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCreateLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextCompaniaProductora, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCreateLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextPais, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCreateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCreateLayout.createSequentialGroup()
                        .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCreateLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextActor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCreateLayout.createSequentialGroup()
                        .addComponent(LabelGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(281, 281, 281))))
            .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCreateLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabelModficarMensaje)
                    .addContainerGap(286, Short.MAX_VALUE)))
        );
        jPanelCreateLayout.setVerticalGroup(
            jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCrearMensaje)
                .addGap(10, 10, 10)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addComponent(TextDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(TextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TextGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextCompaniaProductora, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextPais, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(TextActor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCreateLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabelModficarMensaje)
                    .addContainerGap(471, Short.MAX_VALUE)))
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

    private void LabelGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelGuardarMouseClicked
        // TODO add your handling code here:
        if (this.Crear){
            CrearPelicula();
        }else{
            ActualizarPelicula();
        }
    }//GEN-LAST:event_LabelGuardarMouseClicked

    private void LabelGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelGuardarMouseEntered
        // TODO add your handling code here:
        LabelGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LabelGuardarMouseEntered

    private void TextPaisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextPaisKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (!Paises.contains(TextPais.getText())){
                ModeloPaises.addElement(TextPais.getText());
                Paises.add(TextPais.getText());
                TextPais.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Ya se encuentra ese país", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_TextPaisKeyPressed

    private void TextActorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextActorKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (!Actores.contains(TextActor.getText())){
                ModeloActores.addElement(TextActor.getText());
                Actores.add(TextActor.getText());
                TextActor.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Ya se encuentra ese actor", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_TextActorKeyPressed

    private void LabelELIMINARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelELIMINARMouseClicked
        // TODO add your handling code here:
        EliminarPelicula();
    }//GEN-LAST:event_LabelELIMINARMouseClicked

    private void LabelELIMINARMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelELIMINARMouseEntered
        // TODO add your handling code here:
        LabelELIMINAR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LabelELIMINARMouseEntered

    private void jListPaisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPaisesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            int valor = jListPaises.getSelectedIndex();
            ModeloPaises.remove(valor);
            Paises.remove(valor);
        }
    }//GEN-LAST:event_jListPaisesMouseClicked

    private void jListActoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListActoresMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int valor = jListActores.getSelectedIndex();
            ModeloActores.remove(valor);
            Actores.remove(valor);
        }
    }//GEN-LAST:event_jListActoresMouseClicked

    private void jListPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPeliculasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            int valor = jListPeliculas.getSelectedIndex();
            try {
                Pelicula peli = Peliculas.get(valor);
                setPelicula(peli);
            } catch (Exception e) {
                Logger.getLogger(CRUDPelicula.class.getName()).log(Level.INFO, "message "+e);
                JOptionPane.showMessageDialog(this, "Se produjo un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jListPeliculasMouseClicked

    private void LabelModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelModificarMouseClicked
        // TODO add your handling code here:
        this.VerPelicula();
        jPanelCreate.setVisible(false);
        jLabelCrearMensaje.setVisible(false);  //Mensaje Crear
        jLabelModficarMensaje.setVisible(true);   //Mensaje Modificar
        jPanelView.setVisible(true);
        jPanelDelete.setVisible(false);
        Crear = false;
    }//GEN-LAST:event_LabelModificarMouseClicked

    private void LabelModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelModificarMouseEntered
        // TODO add your handling code here:
        LabelModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_LabelModificarMouseEntered

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
            java.util.logging.Logger.getLogger(CRUDPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDPelicula().setVisible(true);
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
    private javax.swing.JTextField TextActor;
    private javax.swing.JTextField TextCompaniaProductora;
    private javax.swing.JTextField TextDirector;
    private javax.swing.JTextField TextDuracion;
    private javax.swing.JTextField TextFecha;
    private javax.swing.JTextField TextFranquicia;
    private javax.swing.JTextField TextGenero;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JTextField TextNombreEliminar;
    private javax.swing.JTextField TextPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCrearMensaje;
    private javax.swing.JLabel jLabelCrearMensaje1;
    private javax.swing.JLabel jLabelCrearMensaje2;
    private javax.swing.JLabel jLabelModficarMensaje;
    private javax.swing.JList<String> jListActores;
    private javax.swing.JList<String> jListPaises;
    private javax.swing.JList<String> jListPeliculas;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelCreate;
    private javax.swing.JPanel jPanelDelete;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
