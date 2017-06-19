
package danki;

import static danki.PreCarga._HowI;
import static danki.PreCarga._HowI_C;
import java.awt.Desktop;

import java.awt.Toolkit;

import java.net.URL;


public class About extends javax.swing.JFrame {

    static String Espanol ="<html>Soy estudiante de Ingeniería nacido y criado en Venezuela, con la gran aspiración de ser útil a la comunidad internauta con mi trabajos futuros.<br><br> Haber nacido en Venezuela es un reto todos los días, a pesar de que mi computadora es demasiado antigua, mi velocidad de conexión a Internet es el más lento de el continente, todavía sigo trabajando, y no sólo yo, sino también todas las las personas que quieren tener éxito superando las necesidades mediante la creación de nuevas rutas para alcanzar el éxito. <br><br >Si te gusta mi trabajo, tenga en cuenta donar. Realmente ayudaría con mis tasas y matrícula universitaria en Venezuela (América del Sur).<html>";
    static String Ingles="<html>I'm a Engineering student born and raised in Venezuela, with the great aspiration of being helpful to the Internet community with my future works. <br><br> Being born in Venezuela is a challenge everyday, even though my computer is too old, my internet connection speed is the slowest of the continent, I'm still working, and it's not just me, but also all the people who want to succeed and exceed the needs by creating new routes to reach success. <br><br> If you like my work, please consider to donate. It would really help my university fees and college tuition in Venezuela (South America).<html>";
    static String Frances="<html>Je suis un étudiant d'ingénierie né et grandi au Venezuela, avec la grande aspiration d'être serviable à la communauté de l'Internet avec mes travaux futurs. <br>Être né au Venezuela est un challenge de tous les jours, même si mon ordinateur est trop vieux, ma vitesse de connexion à Internet est la plus lente du continent, je travaille encore, et pas seulement moi, mais aussi tous les personnes qui veulent réussir et dépasser les besoins en créant de nouvelles routes pour atteindre le succès. <br><br> Si vous aimez mon travail, s'il vous plaît, considérez de faire une donation. Cela aiderait vraiment mes frais universitaires et ceux de scolarité au Venezuela (Amérique du Sud) <html>";
    static String Japones="<html>私はベネズエラで生まれ育ちました。エンジニアリングを学んでいる学生です。私は将来、自らの開発したプログラムで、インターネットコミュニティの皆さんの役に立ちたいと思っています。 <br><br>ベネズエラ生まれのため、毎日が挑戦です。 私のパソコンは大変古くてインターネットの接続速度が、とても遅いです。私は、まだ働いています。それは私だけではありません。新しい道を作り成功したがっている他の人も同様です。 <br><br>私の活動を気に入って下さったのなら、是非とも寄付をご検討していただければ幸いです。南米のベネズエラで大学の手数料や授業料にとても役立ちます。<html>";
    
    
    public About() {
        setIcon();
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextArea1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Circle.png"))); // NOI18N

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/paypal.png"))); // NOI18N
        jToggleButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jTextArea1.setText("<html>I'm a Engineering student born and raised in Venezuela, with the great aspiration of being helpful to the Internet community with my future works. <br><br> Being born in Venezuela is a challenge everyday, even though my computer is too old, my internet connection speed is the slowest of the continent, I'm still working, and it's not just me, but also all the people who want to succeed and exceed the needs by creating new routes to reach success. <br><br> If you like my work, please consider to donate. It would really help my university fees and college tuition in Venezuela (South America).<html>");

        jButton1.setText("EN");
        jButton1.setFocusable(false);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ES");
        jButton2.setFocusable(false);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("FR");
        jButton3.setFocusable(false);
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("JP");
        jButton4.setFocusable(false);
        jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("UseSpecificCatch")
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            Desktop.getDesktop().browse(new URL("http://dankimg.blogspot.com/p/about.html").toURI());
        } catch (Exception e) {
        danki.Log.write(String.valueOf("Metodo jToggleButton1ActionPerformed"),e);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextArea1.setText(Ingles);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextArea1.setText(Espanol);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextArea1.setText(Frances);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextArea1.setText(Japones);
    }//GEN-LAST:event_jButton4ActionPerformed
    private final String icono="/Img/Icono.png";
    private void setIcon() {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icono)));
    }
    
    
    public static void Mostrar(){
        About about = new About();   
        about.setTitle(_HowI);
        about.setLocationRelativeTo(null);
        about.setVisible(true);
        about.setAlwaysOnTop(true);
        jTextArea1.setText(_HowI_C);
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jTextArea1;
    public static javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
