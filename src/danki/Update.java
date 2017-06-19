
package danki;
import static danki.PreCarga.*;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JFileChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;




public class Update extends javax.swing.JFrame {
    public static File Ruta;
    public static String Nombre="";
    public static String Address;
    public static boolean Actua=false;
    static boolean aux=false;
    static boolean aux1=false;
    
    
     public static boolean Ventana(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HHmmss");
        dateFormat.format(date);
        Nombre="Log-"+dateFormat.format(date)+".txt";
        Log_frame.setIconImage(Toolkit.getDefaultToolkit().getImage(danki.DAnkiMG.class.getClass().getResource("/Img/Icono.png")));
        Log_frame.setTitle(_Alert2);
        Log_frame.pack();
        Log_frame.setAlwaysOnTop(true);
        Log_frame.setLocationRelativeTo(null);
        Log_frame.setVisible(true);
        return true;
    }
    
    
    public Update() {
       initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Frame_Upgrade = new javax.swing.JFrame();
        L_MensajeNuevo = new javax.swing.JLabel();
        URLclic = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Label_ver = new javax.swing.JLabel();
        L_Ava = new javax.swing.JLabel();
        Log_frame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        BodyError_Label = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        DirectoryChooser = new javax.swing.JFileChooser();
        Web = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();

        Frame_Upgrade.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Frame_Upgrade.setTitle(danki.PreCarga._New);
        Frame_Upgrade.setAlwaysOnTop(true);

        L_MensajeNuevo.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        L_MensajeNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_MensajeNuevo.setText(danki.PreCarga._Update);
        L_MensajeNuevo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        URLclic.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        URLclic.setForeground(new java.awt.Color(0, 153, 255));
        URLclic.setText("http://dankimg.blogspot.com");
        URLclic.setBorder(null);
        URLclic.setBorderPainted(false);
        URLclic.setContentAreaFilled(false);
        URLclic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                URLclicActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icono.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("DAnkiMG ver. ");

        Label_ver.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        Label_ver.setForeground(new java.awt.Color(0, 153, 255));
        Label_ver.setText("____");

        L_Ava.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        L_Ava.setText(danki.PreCarga._Ava);

        javax.swing.GroupLayout Frame_UpgradeLayout = new javax.swing.GroupLayout(Frame_Upgrade.getContentPane());
        Frame_Upgrade.getContentPane().setLayout(Frame_UpgradeLayout);
        Frame_UpgradeLayout.setHorizontalGroup(
            Frame_UpgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Frame_UpgradeLayout.createSequentialGroup()
                .addGap(0, 120, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(103, 103, 103))
            .addGroup(Frame_UpgradeLayout.createSequentialGroup()
                .addGroup(Frame_UpgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Frame_UpgradeLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(URLclic))
                    .addGroup(Frame_UpgradeLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(Label_ver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(L_Ava)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(L_MensajeNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Frame_UpgradeLayout.setVerticalGroup(
            Frame_UpgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Frame_UpgradeLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_MensajeNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(URLclic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Frame_UpgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Label_ver)
                    .addComponent(L_Ava))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Log_frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Log_frame.setTitle(_Alert2);
        Log_frame.setIconImage(getIconImage());
        Log_frame.setResizable(false);

        jButton2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jButton2.setText(_Report);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BodyError_Label.setEditable(false);
        BodyError_Label.setBackground(new java.awt.Color(240, 240, 240));
        BodyError_Label.setColumns(2);
        BodyError_Label.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        BodyError_Label.setLineWrap(true);
        BodyError_Label.setRows(5);
        BodyError_Label.setText(_Body_Err);
        BodyError_Label.setWrapStyleWord(true);
        BodyError_Label.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        BodyError_Label.setEnabled(false);

        jButton4.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jButton4.setText(_Cancel);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BodyError_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BodyError_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout Log_frameLayout = new javax.swing.GroupLayout(Log_frame.getContentPane());
        Log_frame.getContentPane().setLayout(Log_frameLayout);
        Log_frameLayout.setHorizontalGroup(
            Log_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Log_frameLayout.setVerticalGroup(
            Log_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        DirectoryChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        DirectoryChooser.setDialogTitle("");
        DirectoryChooser.setFileHidingEnabled(false);
        DirectoryChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        Web.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout WebLayout = new javax.swing.GroupLayout(Web.getContentPane());
        Web.getContentPane().setLayout(WebLayout);
        WebLayout.setHorizontalGroup(
            WebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        WebLayout.setVerticalGroup(
            WebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void URLclicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_URLclicActionPerformed
        try {
                Desktop.getDesktop().browse(new URL("http://dankimg.blogspot.com/p/new-version.html").toURI());
        } catch (Exception e) {}
    }//GEN-LAST:event_URLclicActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Log_frame.setAlwaysOnTop(false);
            DirectoryChooser.setDialogTitle(_T_Guardar);
            if (DirectoryChooser.showSaveDialog(Log_frame) == JFileChooser.APPROVE_OPTION) {
                DirectoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                Ruta = DirectoryChooser.getSelectedFile();
                Log_frame.dispose();
                danki.Log.info(danki.Log.arg, danki.Log.e);
                Address = "https://docs.google.com/forms/d/1Rvm0IEG7-fj0uXhA6WJ0Tkbut5jRphQrJ9-p-oZchso/viewform";
                String args[]=null;
                Browser.Web(args);
            } 
        } catch (SecurityException | HeadlessException e) {}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Log_frame.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


        static Thread Actu;
        static void Code() { 
            Runnable runnable = new Runnable(){
                public void run() {  
                    try{
                        if(aux1==false){
                            aux1=true;
                            Actu.sleep(500);
                        if(netIsAvailable()){
                            Frame_Upgrade.setTitle(_New);
                            URL url=new URL("http://dankimg.blogspot.com");
                            String line;
                            InputStream is=url.openStream();
                            BufferedReader br=new BufferedReader(new InputStreamReader(is));
                            while ((line = br.readLine()) != null) {
                                if(line.contains("ver='true ")){
                                    if(aux==false){
                                        aux=true;
                                        Actua=true;
                                        Label_ver.setText(line.substring(line.indexOf("ver=")+9,line.indexOf("ver=")+17));
                                        Frame_Upgrade.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/Icono.png")));
                                        Frame_Upgrade.pack();
                                        Frame_Upgrade.setLocationRelativeTo(null);
                                        Frame_Upgrade.setVisible(true);
                                        Frame_Upgrade.validate();
                                        Frame_Upgrade.repaint();
                                        Frame_Upgrade.revalidate();
                                        Frame_Upgrade.doLayout();
                                        Actu.suspend();
                                    }
                                }
                                else{
                                    if(aux==false){
                                        aux=true;
                                        if( new Random().nextDouble() <= 0.3 ){  // %40
                                            About About= new About();
                                            About.setAlwaysOnTop(true);
                                            About.setLocationRelativeTo(null);
                                            About.setTitle("Some considerations first.");
                                            About.pack();
                                            About.setVisible(true);
                                            Actu.suspend();
                                        }
                                    }

                                }

                           }
                            Actu.suspend();
                            
                        }
                        else{
                            if(aux==false){
                                aux=true;
                                if( new Random().nextDouble() <= 0.3 ){  // %40
                                    About About= new About();
                                    About.setAlwaysOnTop(true);
                                    About.setLocationRelativeTo(null);
                                    About.setTitle("Some considerations first.");
                                    About.pack();
                                    About.setVisible(true);
                                    Actu.suspend();
                                }
                            }
                        }   
                    }
                    }catch(Exception e){
                        Actu.suspend();
                    }
                }
            };    
            Actu = new Thread(runnable);
            Actu.start();  
        }   
        
        public static void actu(){
            
        }

private static boolean netIsAvailable() throws IOException {
    try {
        final URL url = new URL("http://dankimg.blogspot.com");
        final URLConnection conn = url.openConnection();
        conn.connect();
        return true;
    } catch (MalformedURLException e) {                                                                                                                                                                                                   
        throw new RuntimeException(e);                                                                                                                                                                                                    
    } catch (IOException e) {                                                                                                                                                                                                             
        return false;                                                                                                                                                                                                                     
    } 
}    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea BodyError_Label;
    public static javax.swing.JFileChooser DirectoryChooser;
    public static javax.swing.JFrame Frame_Upgrade;
    public static javax.swing.JLabel L_Ava;
    public static javax.swing.JLabel L_MensajeNuevo;
    private static javax.swing.JLabel Label_ver;
    public static javax.swing.JFrame Log_frame;
    public static javax.swing.JButton URLclic;
    public static javax.swing.JFrame Web;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
