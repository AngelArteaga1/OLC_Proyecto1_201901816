/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Analizadores.parser;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Angel Arteaga
 */
public class App extends javax.swing.JFrame {

    //VARIABLES GLOBALES
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    public static List<Transiciones> ListaTransiciones;
    public static List<Conjunto> ListaConjuntos;
    public static List<Cadena> ListaCadenas;
    public static List<Errores> ListaErrores;
    
    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        //SOLO AJUSTAMOS LA IMAGENF
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/img/icon.jpg"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(Imagen.getWidth(),
                Imagen.getHeight(), Image.SCALE_DEFAULT);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        Imagen.setIcon(iconoEscalado);
        ListaTransiciones = new ArrayList<Transiciones>();
        ListaConjuntos = new ArrayList<Conjunto>();
        ListaCadenas = new ArrayList<Cadena>();
        ListaErrores = new ArrayList<Errores>();
        try {
            scanner();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String Abrir(File archivo){
        String docu = "";
        try{
            entrada = new FileInputStream(archivo);
            int ascii;
            while((ascii = entrada.read())!= -1){
                char caracter = (char)ascii;
                docu += caracter;
            }
            
        } catch (Exception e){
            System.out.println(e);
        }
        return docu;
    }
    
    public String Guardar(File archivo, String doc){
        String message = null;
        System.out.println("");
        try{
            salida = new FileOutputStream(archivo);
            byte[] txt = doc.getBytes();
            salida.write(txt);
            message = "Archivo Guardado";
        } catch(Exception e) {
            System.out.println(e);
        }
        return message;
    }

    public void scanner() throws InterruptedException {
        // creates a file with the location filename
        String location = "Graficas";
        File currentDir = new File(location);

        // result is the variable name for jtree
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        // gets the root of the current model used only once at the starting
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        // function called
        displayDirectoryContents(currentDir, root);
    }
    
    public void displayDirectoryContents(File dir, DefaultMutableTreeNode root2)
            throws InterruptedException {

        DefaultMutableTreeNode newdir = new DefaultMutableTreeNode();

        // creates array of file type for all the files found
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file == null) {
                System.out.println("NUll directory found ");
                continue;
            }
            if (file.isDirectory()) {
                // file is a directory that is a folder has been dound

                if (file.listFiles() == null) {
                    // skips null files
                    continue;
                }

                // gets the current model of the jtree
                DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();

                // gets the root
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

                // generates a node newdir using filename
                newdir = new DefaultMutableTreeNode(file.getName());

                // adds a node to the root of the jtree
                root2.add(newdir);

                // refresh the model to show the changes
                model.reload();

                // recursively calls the function again to explore the contents
                // folder
                displayDirectoryContents(file, newdir);
            } else {
                // Else part File is not a directory

                // gets the current model of the tree
                DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();

                // selected node is the position where the new node will be
                // inserted
                DefaultMutableTreeNode selectednode = root2;

                DefaultMutableTreeNode newfile = new DefaultMutableTreeNode(file.getName());

                // inserts a node newfile under selected node which is the root
                model.insertNodeInto(newfile, selectednode, selectednode.getChildCount());

                // refresh the model to show the changes
                model.reload();

            }

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

        jScrollPane1 = new javax.swing.JScrollPane();
        TxtEntrada = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtSalida = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane4 = new javax.swing.JScrollPane();
        Imagen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TxtEntrada.setColumns(20);
        TxtEntrada.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        TxtEntrada.setRows(5);
        jScrollPane1.setViewportView(TxtEntrada);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel1.setText("Entrada");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel2.setText("Salida");

        jButton1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jButton1.setText("Generar Autómatas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jButton2.setText("Analizar Entradas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TxtSalida.setEditable(false);
        TxtSalida.setColumns(20);
        TxtSalida.setForeground(new java.awt.Color(255, 0, 0));
        TxtSalida.setRows(5);
        jScrollPane2.setViewportView(TxtSalida);

        //jTree1.setModel(new FileSystemModel(new File("C:\\Users\\Angel Arteaga\\Downloads\\Filmora X Suscribete a JEYLINI")));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Graficas");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTree1);

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        Imagen.setBackground(new java.awt.Color(255, 255, 255));
        Imagen.setForeground(new java.awt.Color(255, 255, 255));
        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon.jpg"))); // NOI18N
        jScrollPane4.setViewportView(Imagen);

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Abrir");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar como...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Generar XML");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)))
                            .addComponent(jScrollPane3))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MenuSelected

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("olc")){
                    String docu = Abrir(archivo);
                    TxtEntrada.setText(docu);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo incorrecto");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("olc")){
                String doc = TxtEntrada.getText();
                String message = Guardar(archivo, doc);
                if(message != null){
                    JOptionPane.showMessageDialog(null, message);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo incorrecto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Guardar documento de texto");
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        String doc = TxtEntrada.getText();
        if (archivo != null) {
            String message = null;
            try {
                salida = new FileOutputStream(archivo);
                byte[] txt = doc.getBytes();
                salida.write(txt);
                message = "Archivo Guardado";
            } catch (Exception e) {
                System.out.println(e);
            }
            if (message != null) {
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, "Archivo incorrecto");
            }
        } else {
            if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("olc")){
                String message = Guardar(archivo, doc);
                if(message != null){
                    JOptionPane.showMessageDialog(null, message);
                } else {
                    JOptionPane.showMessageDialog(null, "Su archivo se encuentra vacío");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Guardar documento de texto");
            }
        }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //REINICIAMOS LAS LISTAS
        ListaTransiciones.clear();
        ListaConjuntos.clear();
        ListaCadenas.clear();
        ListaErrores.clear();
        //INTENTAR INICIALIZAR ALGO
        parser.Caracteres = new ArrayList<String>();
        TxtSalida.setText("");
        try {
            String path = TxtEntrada.getText();
            Analizadores.parser sintactico;
            sintactico = new Analizadores.parser(new Analizadores.Lexico(new StringReader(path)));
            sintactico.parse();
        } catch (Exception e) {
        }
        //ELIMINAMOS LOS HIJOS DEL BICHO
        DefaultTreeModel modelo = (DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) modelo.getRoot();
        root.removeAllChildren();
        modelo.reload();
        try {
            TimeUnit.SECONDS.sleep(1);
            scanner();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.out.println("");
        System.out.println("***************** SE VINO LO CHIDO *****************");
        TxtSalida.setText("");
        /*
        System.out.println("");
        System.out.println("***************************************************************************************");
        System.out.println("ESTA ES LA LISTA DE LEXEMAS:");
        for (int i  = 0; i < ListaCadenas.size(); i++){
            System.out.println("Lexema: " + ListaCadenas.get(i).Lexema + " nombre: " + ListaCadenas.get(i).nombre);
        }
        System.out.println("ESTA ES LA LISTA DE CONJUNTOS:");
        for (int i  = 0; i < ListaConjuntos.size(); i++){
            System.out.println("************************");
            System.out.println("Conjunto: " + ListaConjuntos.get(i).nombre);
            System.out.println(ListaConjuntos.get(i).Caracteres);
        }
        System.out.println("TABLA DE TRANSICIONES:");
        for (int i = 0; i < ListaTransiciones.size(); i++){
            System.out.println("**********************************************");
            System.out.println("Transicion: " + ListaTransiciones.get(i).nombre);
            for (int x = 0; x < ListaTransiciones.get(i).transiciones.length; x++){
                for (int y = 0; y < ListaTransiciones.get(i).transiciones[x].length; y++){
                    System.out.print(ListaTransiciones.get(i).transiciones[x][y] + ", ");
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("Conjuntos en orden: " + ListaTransiciones.get(i).conjuntos);
        }*/
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            if (archivo != null){
                String name = archivo.getName();
                name = name.replaceFirst("[.][^.]+$", "");
                fichero = new FileWriter("Graficas/Salidas/" + name + ".json");
                pw = new PrintWriter(fichero);
            } else {
                fichero = new FileWriter("Graficas/Salidas/Lexemas.json");
                pw = new PrintWriter(fichero);
            }
            pw.println("[");
            //EMPEXAMOS A LEER LOS LEXEMAS:
            for (int i = 0; i < ListaCadenas.size(); i++) {
                int S = 0;
                String cadena = ListaCadenas.get(i).Lexema;
                cadena = cadena.replace("\"", "");
                String nombre = ListaCadenas.get(i).nombre;
                int[][] trans = null;
                int EstadoFinal = -10;
                List<String> conjuntos = null;
                Conjunto ConjuntoReal = null;
                boolean correcto = true;
                //System.out.println("LEXEMA ACTUAL: " + cadena);
                //System.out.println("ID: " + nombre);
                //System.out.println("AHORA COMPARAMOS: ");
                //OBTENEMOS LA MATRIZ INDICE
                for (int j = 0; j < ListaTransiciones.size(); j++) {
                    String nombre2 = ListaTransiciones.get(j).nombre;
                    //System.out.println(nombre2 + "<->" + nombre);
                    if (nombre.equals(nombre2)) {
                        //System.out.println("ENCONTRADO!");
                        trans = ListaTransiciones.get(j).transiciones;
                        EstadoFinal = ListaTransiciones.get(j).EstadoFinal;
                        conjuntos = ListaTransiciones.get(j).conjuntos;
                        break;
                    }
                }
                //System.out.println("ESTADO FINAL: " + EstadoFinal);
                //System.out.println("CONJUNTOS: " + conjuntos);
                //System.out.println("TRANSICIONES: ");
                for (int x = 0; x < trans.length; x++) {
                    for (int y = 0; y < trans[x].length; y++) {
                        //System.out.print(trans[x][y] + ", ");
                    }
                    //System.out.println("");
                }
                //RECORREMOS LA CADENA ACTUAL
                //System.out.println("AHORA RECORREMOS LA CADENA:");
                for (int j = 0; j < cadena.length(); j++) {
                    String caracter = String.valueOf(cadena.charAt(j));
                    //System.out.println("CARACTER: " + caracter);
                    if (correcto == true) {
                        //RECORREMOS LA FILA DEL ESTADO ACTUAL
                        //System.out.println("RECORREMOS LA FILA DEL ESTADO:" + S);
                        for (int x = 0; x < trans[S].length - 1; x++) {
                            //System.out.println("POSICION: " + S + ", " + x + " INDICE: " + trans[S][x]);
                            boolean encontrado = false;
                            if (trans[S][x] != -1) {
                                //ENCONTRAMOS UNA POSIBLE TRANSICION
                                //OBTENEMOS EL NOMBRE DE LOS CONJUNTO DE ESA POSICION
                                String conjuntoActual = conjuntos.get(x);
                                if (conjuntoActual.equals("\\n") || conjuntoActual.equals("\\'") || conjuntoActual.equals("\\\"")) {
                                    if (caracter.equals("\\")) {
                                        break;
                                    }
                                }
                                //OBTENEMOS LA LISTA DE CARACTERES
                                for (int z = 0; z < ListaConjuntos.size(); z++) {
                                    if (ListaConjuntos.get(z).nombre.equals(conjuntoActual)) {
                                        ConjuntoReal = ListaConjuntos.get(z);
                                    }
                                }
                                //VERIFICAMOS SI EL CARACTER ESTA EN ESE CONJUNTO
                                if (ConjuntoReal.Caracteres.contains(caracter)) {
                                    //EL NUEVO ESTADO ES:
                                    S = trans[S][x];
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (x == trans[S].length - 2 && encontrado == false) {
                                correcto = false;
                            }
                        }
                    }
                }
                //IMPRIMIMOS SI ES CORRECTO O INCORRECTO Y SEGUIMOS EL JSON
                //System.out.println("EL LEXEMA FINALIZO EN EL ESTADO: " + S);
                if (EstadoFinal == S && correcto == true) {
                    TxtSalida.append("EL LEXEMA: " + ListaCadenas.get(i).Lexema + " ES CORRECTO\n");
                    pw.println("{");
                    pw.println("\"valor\": " + ListaCadenas.get(i).Lexema + ",");
                    pw.println("\"ExpresionRegular\": \"" + ListaCadenas.get(i).nombre + "\",");
                    pw.println("\"Resultado\":" + "\"Cadena Válida\"");
                    pw.println("},");
                } else {
                    TxtSalida.append("EL LEXEMA: " + ListaCadenas.get(i).Lexema + " ES INCORRECTO\n");
                    pw.println("{");
                    pw.println("\"valor\": " + ListaCadenas.get(i).Lexema + ",");
                    pw.println("\"ExpresionRegular\": \"" + ListaCadenas.get(i).nombre + "\",");
                    pw.println("\"Resultado\":" + "\"Cadena Inválida\"");
                    pw.println("},");
                }
            }
            pw.println("]");
        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo");
            TxtSalida.append("error, no se realizo el archivo\n");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            String nombre = jTree1.getSelectionPath().toString().replaceAll("[\\[\\]]", "").replace(", ", "/");
            try {
                Image image = new ImageIcon(nombre).getImage();
                Icon iconoEscalado = new ImageIcon(image);
                Imagen.setIcon(iconoEscalado);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jTree1MouseClicked

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen;
    private javax.swing.JTextArea TxtEntrada;
    public static javax.swing.JTextArea TxtSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
