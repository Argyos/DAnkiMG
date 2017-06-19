
package danki;

import static danki.CollectionHandle.destination;
import static danki.PreCarga.*;
import static danki.Update.*;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.File;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import net.lingala.zip4j.core.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Row;

final class DAnkiMG extends javax.swing.JFrame {
    private Thread threadObject; 
    @SuppressWarnings("FieldMayBeFinal")
    private int limite=1;
    private final String icono="/Img/Icono.png";
    @SuppressWarnings("Convert2Diamond")
    private int color=0;
    private int tipo=0;
    private int dominio=0;
    @SuppressWarnings("Convert2Diamond")
    private final List<JButton> buttons = new ArrayList<JButton>();  
    @SuppressWarnings("Convert2Diamond")
    private final List<BufferedImage> BuffedImg = new ArrayList<BufferedImage>();  
    @SuppressWarnings("Convert2Diamond")
    private final List<String> ButtonReady = new ArrayList<String>();  
    private BufferedImage BuffImg1,BuffImg2,BuffImg3,BuffImg4,BuffImg5,BuffImg6,BuffImg7,BuffImg8,BuffImg9,BuffImg10,BuffImg11,BuffImg12;
    public File ruta;
    ZipOutputStream out;
    String Camp_1=null;
    String Camp_2=null;
    private static String Original;
    private static String posc;        
    private static String ID;
    private boolean texto=false;
    List<String> NameFields = new ArrayList();
    List<String> Tags = new ArrayList();
    List<String> ID_P = new ArrayList();
    List<List<String>> Palabras = new ArrayList();
    int Fld1;
    int Fld2;
    int Amo;
    int FLD3;
    int borrar=0;
            
    

    
    DAnkiMG() {
        PreLoad();        
        initComponents(); 
        PostLoad();
        arrs();
        magic(); 
        Selection();
    }
    
    private void PreLoad(){
        setIcon();
        Update Update= new Update();
        Update.Code();
        try {
            danki.Update.Actu.stop();
        } catch (Exception e) {
        }
        
    }
    
    private void PostLoad(){
        Panel_Trans.setVisible(false);
        buttons.add(ImgBoton_1);buttons.add(ImgBoton_2);buttons.add(ImgBoton_3);buttons.add(ImgBoton_4);       
        buttons.add(ImgBoton_5);buttons.add(ImgBoton_6);buttons.add(ImgBoton_7);buttons.add(ImgBoton_8);       
        buttons.add(ImgBoton_9);buttons.add(ImgBoton_10);buttons.add(ImgBoton_11);buttons.add(ImgBoton_12);
        BuffedImg.add(BuffImg1);BuffedImg.add(BuffImg2);BuffedImg.add(BuffImg3);BuffedImg.add(BuffImg4);BuffedImg.add(BuffImg5);
        BuffedImg.add(BuffImg6);BuffedImg.add(BuffImg7);BuffedImg.add(BuffImg8);BuffedImg.add(BuffImg9);BuffedImg.add(BuffImg10);
        BuffedImg.add(BuffImg11);BuffedImg.add(BuffImg12);
        ButtonReady.add("0");ButtonReady.add("0");ButtonReady.add("0");ButtonReady.add("0");ButtonReady.add("0");ButtonReady.add("0");ButtonReady.add("0");
        ButtonReady.add("0");ButtonReady.add("0");ButtonReady.add("0");ButtonReady.add("0");ButtonReady.add("0");
        hide(1,1);hide(2,1);hide(3,1);hide(1,2);hide(2,2);hide(3,2);
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                getNewRenderedTable(Table_Undone);
                getNewRenderedTable1(Table_injected);
            }
        });
        Scroll_undone.getViewport().setBackground(java.awt.Color.WHITE);
        Scroll_injected.getViewport().setBackground(java.awt.Color.WHITE);
        Panel_newField.setVisible(false);
        Label_Recomend.setVisible(false);
        Table_injected.getTableHeader().setReorderingAllowed(false);
        Table_injected.setAutoCreateRowSorter(true);
        Table_Undone.setAutoCreateRowSorter(true);
        ListSelectionModel cellSelectionModel1 = Table_injected.getSelectionModel();
        cellSelectionModel1.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
        int row = Table_injected.getSelectedRow();
        if ((row > -1)) {
            Table_injected.setRowSelectionInterval(row, row);
                }
            }
        });
         //
        ListSelectionModel cellSelectionModel2 = Table_Undone.getSelectionModel();
        cellSelectionModel2.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
        int row = Table_Undone.getSelectedRow();
        if ((row > -1)) {
            Table_Undone.setRowSelectionInterval(row, row);
                }
            }
        });
         threadObject = new Thread(runnable); 
    }
    
   
    
@SuppressWarnings("Convert2Lambda")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        File_Output = new javax.swing.JFileChooser();
        Selector = new javax.swing.JFileChooser();
        Salida_conjunta = new javax.swing.JFileChooser();
        Frame_About = new javax.swing.JFrame();
        Label_icono = new javax.swing.JLabel();
        B_paypal = new javax.swing.JToggleButton();
        TermsCheck = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area_About = new javax.swing.JTextPane();
        Decode = new javax.swing.JFrame();
        Panel_Decode = new javax.swing.JPanel();
        Text_magic = new javax.swing.JTextField();
        ChooseFlds = new javax.swing.JFrame();
        Label_Recomend = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Btn_cancel = new javax.swing.JButton();
        Btn_Acept = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Labe_lFldT = new javax.swing.JLabel();
        FLD2 = new javax.swing.JComboBox<>();
        FLD1 = new javax.swing.JComboBox<>();
        label_fld1 = new javax.swing.JLabel();
        label_fld2 = new javax.swing.JLabel();
        Main_Panel = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        Label_Mostrar = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        Language_List1 = new javax.swing.JComboBox<>();
        Menu_About = new javax.swing.JButton();
        Menu_HowTo = new javax.swing.JButton();
        B_HowI = new javax.swing.JToggleButton();
        Inner_Panel = new javax.swing.JPanel();
        Orig_Panel = new javax.swing.JPanel();
        Label_Orig = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Text_Original = new javax.swing.JTextArea();
        Traduc_Panel = new javax.swing.JPanel();
        Label_Trans = new javax.swing.JCheckBox();
        Panel_Trans = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Text_Traduccion = new javax.swing.JTextArea();
        P_Icon = new javax.swing.JPanel();
        ImgBoton_10 = new javax.swing.JButton();
        ImgBoton_8 = new javax.swing.JButton();
        ImgBoton_12 = new javax.swing.JButton();
        ImgBoton_1 = new javax.swing.JButton();
        ImgBoton_2 = new javax.swing.JButton();
        ImgBoton_5 = new javax.swing.JButton();
        ImgBoton_4 = new javax.swing.JButton();
        ImgBoton_3 = new javax.swing.JButton();
        ImgBoton_6 = new javax.swing.JButton();
        ImgBoton_9 = new javax.swing.JButton();
        ImgBoton_7 = new javax.swing.JButton();
        ImgBoton_11 = new javax.swing.JButton();
        Text_JtextPanel = new javax.swing.JScrollPane();
        Copy_TextArea = new javax.swing.JTextArea();
        Lista_Tipos = new javax.swing.JComboBox();
        Tipo_Colors = new javax.swing.JComboBox();
        List_Dominios = new javax.swing.JComboBox();
        B_Refresh = new javax.swing.JButton();
        Label_Buscar = new javax.swing.JLabel();
        Pestanas = new javax.swing.JTabbedPane();
        Scroll_undone = new javax.swing.JScrollPane();
        Table_Undone = new javax.swing.JTable();
        Scroll_injected = new javax.swing.JScrollPane();
        Table_injected = new javax.swing.JTable();
        Sub_pane = new javax.swing.JPanel();
        Ch_Descarga = new javax.swing.JCheckBox();
        L_Amount = new javax.swing.JLabel();
        C_Amout = new javax.swing.JComboBox<>();
        C_FieldPlace = new javax.swing.JComboBox<>();
        L_DeckFields = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Btn_addField = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Panel_newField = new javax.swing.JPanel();
        text_newfld1 = new javax.swing.JTextField();
        Btn_newfld1 = new javax.swing.JButton();
        Btn_addFldClose = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Label_NunDone = new javax.swing.JLabel();
        Label_injected = new javax.swing.JLabel();
        Label_Ninject = new javax.swing.JLabel();
        Label_undone = new javax.swing.JLabel();
        Check_Show = new javax.swing.JCheckBox();
        Btn_Campos = new javax.swing.JButton();

        File_Output.setDialogTitle("");
        File_Output.setFocusable(false);

        Selector.setFocusable(false);

        Salida_conjunta.setFocusable(false);

        Frame_About.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Frame_About.setTitle(_Menu_About);
        Frame_About.setFont(new java.awt.Font("Arial Unicode MS", 0, 10)); // NOI18N
        Frame_About.setResizable(false);

        Label_icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/About.png"))); // NOI18N

        B_paypal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/paypal.png"))); // NOI18N
        B_paypal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_paypal.setFocusable(false);
        B_paypal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_paypalActionPerformed(evt);
            }
        });

        TermsCheck.setText("Terms & Conditions");
        TermsCheck.setFocusable(false);
        TermsCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TermsCheckActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setFocusable(false);

        Area_About.setEditable(false);
        Area_About.setBorder(null);
        Area_About.setContentType("text/html"); // NOI18N
        Area_About.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Area_About.setText(_About);
        Area_About.setToolTipText("");
        Area_About.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Area_About.setEnabled(false);
        Area_About.setFocusable(false);
        jScrollPane1.setViewportView(Area_About);

        javax.swing.GroupLayout Frame_AboutLayout = new javax.swing.GroupLayout(Frame_About.getContentPane());
        Frame_About.getContentPane().setLayout(Frame_AboutLayout);
        Frame_AboutLayout.setHorizontalGroup(
            Frame_AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Frame_AboutLayout.createSequentialGroup()
                .addComponent(Label_icono, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Frame_AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Frame_AboutLayout.createSequentialGroup()
                        .addComponent(B_paypal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TermsCheck))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Frame_AboutLayout.setVerticalGroup(
            Frame_AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_icono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Frame_AboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Frame_AboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B_paypal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TermsCheck))
                .addGap(23, 23, 23))
        );

        Decode.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Decode.setFont(new java.awt.Font("Arial Unicode MS", 0, 10)); // NOI18N
        Decode.setResizable(false);

        Text_magic.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout Panel_DecodeLayout = new javax.swing.GroupLayout(Panel_Decode);
        Panel_Decode.setLayout(Panel_DecodeLayout);
        Panel_DecodeLayout.setHorizontalGroup(
            Panel_DecodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DecodeLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(Text_magic, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        Panel_DecodeLayout.setVerticalGroup(
            Panel_DecodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DecodeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text_magic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DecodeLayout = new javax.swing.GroupLayout(Decode.getContentPane());
        Decode.getContentPane().setLayout(DecodeLayout);
        DecodeLayout.setHorizontalGroup(
            DecodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Decode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DecodeLayout.setVerticalGroup(
            DecodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Decode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ChooseFlds.setTitle(_Title_Campos);
        ChooseFlds.setIconImage(getIconImage());
        ChooseFlds.setResizable(false);

        Label_Recomend.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        Label_Recomend.setForeground(new java.awt.Color(255, 0, 51));
        Label_Recomend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Recomend.setText(_Label_Recomend);
        Label_Recomend.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));

        Btn_cancel.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Btn_cancel.setText(_Cancel);
        Btn_cancel.setFocusable(false);
        Btn_cancel.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cancelActionPerformed(evt);
            }
        });

        Btn_Acept.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Btn_Acept.setText(_Btn_Acept);
        Btn_Acept.setFocusable(false);
        Btn_Acept.setMargin(new java.awt.Insets(2, 2, 2, 2));
        Btn_Acept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Acept, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_cancel)
                    .addComponent(Btn_Acept))
                .addContainerGap())
        );

        Labe_lFldT.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Labe_lFldT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Labe_lFldT.setText(_Label_Campos);

        FLD2.setFocusable(false);

        FLD1.setFocusable(false);
        FLD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FLD1ActionPerformed(evt);
            }
        });

        label_fld1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        label_fld1.setForeground(new java.awt.Color(0, 102, 204));
        label_fld1.setText(_Label_FLD1);

        label_fld2.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        label_fld2.setForeground(new java.awt.Color(0, 102, 204));
        label_fld2.setText(_Label_FLD2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Labe_lFldT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_fld1)
                            .addComponent(FLD1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_fld2)
                            .addComponent(FLD2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Labe_lFldT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label_fld1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FLD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label_fld2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FLD2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout ChooseFldsLayout = new javax.swing.GroupLayout(ChooseFlds.getContentPane());
        ChooseFlds.getContentPane().setLayout(ChooseFldsLayout);
        ChooseFldsLayout.setHorizontalGroup(
            ChooseFldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ChooseFldsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Recomend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ChooseFldsLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ChooseFldsLayout.setVerticalGroup(
            ChooseFldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChooseFldsLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Recomend, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(674, 604));

        menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Label_Mostrar.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Label_Mostrar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Label_Mostrar.setText("<html>"+_Label_Mostrar+"<html>");
        Label_Mostrar.setFocusable(false);
        Label_Mostrar.setMaximumSize(new java.awt.Dimension(180, 180));

        jButton3.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 204));
        jButton3.setText("www.DAnkiMG.blogspot.com");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("✓");
        jToggleButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToggleButton2.setContentAreaFilled(false);
        jToggleButton2.setFocusable(false);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        Language_List1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Language_List1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Spanish", "French", "Japanese" }));
        Language_List1.setAlignmentX(0.0F);
        Language_List1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Language_List1.setFocusable(false);
        Language_List1.setMaximumSize(new java.awt.Dimension(100, 100));

        Menu_About.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Menu_About.setText(_Menu_About);
        Menu_About.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Menu_About.setContentAreaFilled(false);
        Menu_About.setFocusPainted(false);
        Menu_About.setFocusable(false);
        Menu_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_AboutActionPerformed(evt);
            }
        });

        Menu_HowTo.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Menu_HowTo.setText(_Menu_HowTo);
        Menu_HowTo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Menu_HowTo.setContentAreaFilled(false);
        Menu_HowTo.setFocusPainted(false);
        Menu_HowTo.setFocusable(false);
        Menu_HowTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_HowToActionPerformed(evt);
            }
        });

        B_HowI.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        B_HowI.setText(_HowI);
        B_HowI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B_HowI.setContentAreaFilled(false);
        B_HowI.setFocusable(false);
        B_HowI.setMargin(new java.awt.Insets(2, 2, 2, 2));
        B_HowI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_HowIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addComponent(Menu_HowTo)
                .addGap(0, 0, 0)
                .addComponent(Menu_About)
                .addGap(0, 0, 0)
                .addComponent(B_HowI, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Label_Mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Language_List1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B_HowI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Language_List1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Menu_About, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Menu_HowTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Label_Mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        menuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Menu_About, Menu_HowTo, jButton3, jToggleButton2});

        Inner_Panel.setOpaque(false);

        Label_Orig.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Label_Orig.setForeground(new java.awt.Color(0, 153, 204));
        Label_Orig.setText("A");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Text_Original.setEditable(false);
        Text_Original.setColumns(20);
        Text_Original.setFont(new java.awt.Font("Arial Unicode MS", 0, 20)); // NOI18N
        Text_Original.setRows(5);
        Text_Original.setMargin(new java.awt.Insets(3, 0, 0, 3));
        Text_Original.setOpaque(false);
        Text_Original.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        Text_Original.setSelectionColor(new java.awt.Color(240, 240, 240));
        jScrollPane4.setViewportView(Text_Original);

        javax.swing.GroupLayout Orig_PanelLayout = new javax.swing.GroupLayout(Orig_Panel);
        Orig_Panel.setLayout(Orig_PanelLayout);
        Orig_PanelLayout.setHorizontalGroup(
            Orig_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Orig_PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Orig_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Orig, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        Orig_PanelLayout.setVerticalGroup(
            Orig_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Orig_PanelLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(Label_Orig, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Label_Trans.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Label_Trans.setForeground(new java.awt.Color(0, 153, 204));
        Label_Trans.setText("B");
        Label_Trans.setContentAreaFilled(false);
        Label_Trans.setFocusPainted(false);
        Label_Trans.setFocusable(false);
        Label_Trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Label_TransActionPerformed(evt);
            }
        });

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Text_Traduccion.setEditable(false);
        Text_Traduccion.setColumns(20);
        Text_Traduccion.setFont(new java.awt.Font("Arial Unicode MS", 0, 20)); // NOI18N
        Text_Traduccion.setRows(5);
        Text_Traduccion.setMargin(new java.awt.Insets(3, 0, 0, 3));
        Text_Traduccion.setOpaque(false);
        Text_Traduccion.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        Text_Traduccion.setSelectionColor(new java.awt.Color(240, 240, 240));
        jScrollPane6.setViewportView(Text_Traduccion);

        javax.swing.GroupLayout Panel_TransLayout = new javax.swing.GroupLayout(Panel_Trans);
        Panel_Trans.setLayout(Panel_TransLayout);
        Panel_TransLayout.setHorizontalGroup(
            Panel_TransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        Panel_TransLayout.setVerticalGroup(
            Panel_TransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Traduc_PanelLayout = new javax.swing.GroupLayout(Traduc_Panel);
        Traduc_Panel.setLayout(Traduc_PanelLayout);
        Traduc_PanelLayout.setHorizontalGroup(
            Traduc_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Traduc_PanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(Traduc_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Traduc_PanelLayout.createSequentialGroup()
                        .addComponent(Label_Trans, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Panel_Trans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Traduc_PanelLayout.setVerticalGroup(
            Traduc_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Traduc_PanelLayout.createSequentialGroup()
                .addComponent(Label_Trans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Trans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        P_Icon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ImgBoton_10.setBorder(null);
        ImgBoton_10.setBorderPainted(false);
        ImgBoton_10.setContentAreaFilled(false);
        ImgBoton_10.setFocusable(false);
        ImgBoton_10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_10ActionPerformed(evt);
            }
        });

        ImgBoton_8.setBorder(null);
        ImgBoton_8.setBorderPainted(false);
        ImgBoton_8.setContentAreaFilled(false);
        ImgBoton_8.setFocusable(false);
        ImgBoton_8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_8ActionPerformed(evt);
            }
        });

        ImgBoton_12.setBorder(null);
        ImgBoton_12.setBorderPainted(false);
        ImgBoton_12.setContentAreaFilled(false);
        ImgBoton_12.setFocusable(false);
        ImgBoton_12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_12ActionPerformed(evt);
            }
        });

        ImgBoton_1.setBackground(new java.awt.Color(255, 255, 255));
        ImgBoton_1.setForeground(new java.awt.Color(255, 0, 0));
        ImgBoton_1.setBorder(null);
        ImgBoton_1.setBorderPainted(false);
        ImgBoton_1.setContentAreaFilled(false);
        ImgBoton_1.setFocusable(false);
        ImgBoton_1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_1ActionPerformed(evt);
            }
        });

        ImgBoton_2.setBorder(null);
        ImgBoton_2.setBorderPainted(false);
        ImgBoton_2.setContentAreaFilled(false);
        ImgBoton_2.setFocusable(false);
        ImgBoton_2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_2ActionPerformed(evt);
            }
        });

        ImgBoton_5.setBorder(null);
        ImgBoton_5.setBorderPainted(false);
        ImgBoton_5.setContentAreaFilled(false);
        ImgBoton_5.setFocusable(false);
        ImgBoton_5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_5ActionPerformed(evt);
            }
        });

        ImgBoton_4.setBorder(null);
        ImgBoton_4.setBorderPainted(false);
        ImgBoton_4.setContentAreaFilled(false);
        ImgBoton_4.setFocusable(false);
        ImgBoton_4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_4ActionPerformed(evt);
            }
        });

        ImgBoton_3.setBorder(null);
        ImgBoton_3.setBorderPainted(false);
        ImgBoton_3.setContentAreaFilled(false);
        ImgBoton_3.setFocusable(false);
        ImgBoton_3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_3ActionPerformed(evt);
            }
        });

        ImgBoton_6.setBorder(null);
        ImgBoton_6.setBorderPainted(false);
        ImgBoton_6.setContentAreaFilled(false);
        ImgBoton_6.setFocusable(false);
        ImgBoton_6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_6ActionPerformed(evt);
            }
        });

        ImgBoton_9.setBorder(null);
        ImgBoton_9.setBorderPainted(false);
        ImgBoton_9.setContentAreaFilled(false);
        ImgBoton_9.setFocusable(false);
        ImgBoton_9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_9ActionPerformed(evt);
            }
        });

        ImgBoton_7.setBorder(null);
        ImgBoton_7.setBorderPainted(false);
        ImgBoton_7.setContentAreaFilled(false);
        ImgBoton_7.setFocusable(false);
        ImgBoton_7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_7ActionPerformed(evt);
            }
        });

        ImgBoton_11.setBorder(null);
        ImgBoton_11.setBorderPainted(false);
        ImgBoton_11.setContentAreaFilled(false);
        ImgBoton_11.setFocusable(false);
        ImgBoton_11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImgBoton_11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ImgBoton_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgBoton_11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_IconLayout = new javax.swing.GroupLayout(P_Icon);
        P_Icon.setLayout(P_IconLayout);
        P_IconLayout.setHorizontalGroup(
            P_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_IconLayout.createSequentialGroup()
                .addGroup(P_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_IconLayout.createSequentialGroup()
                        .addGroup(P_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ImgBoton_5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImgBoton_9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(P_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(P_IconLayout.createSequentialGroup()
                                .addComponent(ImgBoton_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(ImgBoton_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(ImgBoton_8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(P_IconLayout.createSequentialGroup()
                                .addComponent(ImgBoton_10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(ImgBoton_11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(ImgBoton_12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(P_IconLayout.createSequentialGroup()
                        .addComponent(ImgBoton_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(ImgBoton_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(ImgBoton_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(ImgBoton_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        P_IconLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ImgBoton_1, ImgBoton_10, ImgBoton_11, ImgBoton_12, ImgBoton_2, ImgBoton_3, ImgBoton_4, ImgBoton_5, ImgBoton_6, ImgBoton_7, ImgBoton_8, ImgBoton_9});

        P_IconLayout.setVerticalGroup(
            P_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_IconLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(P_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgBoton_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(P_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ImgBoton_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(P_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgBoton_9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgBoton_12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        P_IconLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ImgBoton_1, ImgBoton_10, ImgBoton_11, ImgBoton_12, ImgBoton_2, ImgBoton_3, ImgBoton_4, ImgBoton_5, ImgBoton_6, ImgBoton_7, ImgBoton_8, ImgBoton_9});

        Copy_TextArea.setEditable(false);
        Copy_TextArea.setColumns(20);
        Copy_TextArea.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        Copy_TextArea.setLineWrap(true);
        Copy_TextArea.setRows(5);
        Copy_TextArea.setWrapStyleWord(true);
        Copy_TextArea.setEnabled(false);
        Text_JtextPanel.setViewportView(Copy_TextArea);

        Lista_Tipos.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Lista_Tipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any type", "Clip art", "Face", "Photo", "Line drawing" }));
        Lista_Tipos.setFocusable(false);

        Tipo_Colors.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Tipo_Colors.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Full Color", "Black and white" }));
        Tipo_Colors.setFocusable(false);

        List_Dominios.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        List_Dominios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EN", "ES", "FR", "DE", "JP", "HK", "KR" }));
        List_Dominios.setFocusable(false);

        B_Refresh.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        B_Refresh.setText("↻");
        B_Refresh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        B_Refresh.setContentAreaFilled(false);
        B_Refresh.setFocusPainted(false);
        B_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RefreshActionPerformed(evt);
            }
        });

        Label_Buscar.setForeground(new java.awt.Color(0, 153, 204));
        Label_Buscar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Label_Buscar.setText(_B_Search+":");
        Label_Buscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout Inner_PanelLayout = new javax.swing.GroupLayout(Inner_Panel);
        Inner_Panel.setLayout(Inner_PanelLayout);
        Inner_PanelLayout.setHorizontalGroup(
            Inner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Inner_PanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(Inner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_JtextPanel)
                    .addGroup(Inner_PanelLayout.createSequentialGroup()
                        .addComponent(P_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Inner_PanelLayout.createSequentialGroup()
                        .addComponent(Orig_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Traduc_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Inner_PanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Label_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lista_Tipos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tipo_Colors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(List_Dominios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        Inner_PanelLayout.setVerticalGroup(
            Inner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Inner_PanelLayout.createSequentialGroup()
                .addGroup(Inner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Orig_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Traduc_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(Inner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Inner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(List_Dominios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(Inner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lista_Tipos)
                            .addComponent(Tipo_Colors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Buscar)))
                    .addComponent(B_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(P_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Text_JtextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Inner_PanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {B_Refresh, List_Dominios});

        Pestanas.setFocusable(false);
        Pestanas.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        Pestanas.setRequestFocusEnabled(false);

        Table_Undone.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Table_Undone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                Camp_1, Camp_2,"Posc","Id"
            }

        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    Table_Undone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    Table_Undone.setEditingColumn(0);
    Table_Undone.setEditingRow(0);
    Table_Undone.setFocusable(false);
    Table_Undone.setGridColor(new java.awt.Color(255, 255, 255));
    Table_Undone.setRowSelectionAllowed(false);
    Table_Undone.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            Table_UndoneMousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            Table_UndoneMouseReleased(evt);
        }
    });
    Scroll_undone.setViewportView(Table_Undone);
    Table_Undone.getTableHeader().setReorderingAllowed(false);

    Pestanas.addTab("Undone", Scroll_undone);

    Table_injected.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
    Table_injected.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            Camp_1, Camp_2,"Posc","Id"
        }

    )
    {public boolean isCellEditable(int row, int column){return false;}}
    );
    Table_injected.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    Table_injected.setEditingColumn(0);
    Table_injected.setEditingRow(0);
    Table_injected.setGridColor(new java.awt.Color(255, 255, 255));
    Table_injected.setRowSelectionAllowed(false);
    Scroll_injected.setViewportView(Table_injected);
    Table_Undone.getTableHeader().setReorderingAllowed(false);

    Pestanas.addTab("Injected", Scroll_injected);

    Pestanas.setTitleAt(0, _Pestanas_0);  Pestanas.setTitleAt(1, _Pestanas_1);

    Ch_Descarga.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    Ch_Descarga.setSelected(true);
    Ch_Descarga.setText(_Ch_Descarga);
    Ch_Descarga.setContentAreaFilled(false);
    Ch_Descarga.setFocusPainted(false);
    Ch_Descarga.setMargin(new java.awt.Insets(0, 0, 0, 0));
    Ch_Descarga.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Ch_DescargaActionPerformed(evt);
        }
    });

    L_Amount.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    L_Amount.setText(_L_Amount);

    C_Amout.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    C_Amout.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
    C_Amout.setFocusable(false);
    C_Amout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            C_AmoutActionPerformed(evt);
        }
    });

    C_FieldPlace.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    C_FieldPlace.setFocusable(false);
    C_FieldPlace.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            C_FieldPlaceActionPerformed(evt);
        }
    });

    L_DeckFields.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    L_DeckFields.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    L_DeckFields.setText(_L_DeckFields);

    jButton1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    jButton1.setText(_Button_Load);
    jButton1.setFocusable(false);
    jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    Btn_addField.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    Btn_addField.setText("+");
    Btn_addField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    Btn_addField.setContentAreaFilled(false);
    Btn_addField.setFocusable(false);
    Btn_addField.setMargin(new java.awt.Insets(0, 0, 0, 0));
    Btn_addField.setMaximumSize(new java.awt.Dimension(50, 50));
    Btn_addField.setMinimumSize(new java.awt.Dimension(50, 50));
    Btn_addField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Btn_addFieldActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout Sub_paneLayout = new javax.swing.GroupLayout(Sub_pane);
    Sub_pane.setLayout(Sub_paneLayout);
    Sub_paneLayout.setHorizontalGroup(
        Sub_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(Sub_paneLayout.createSequentialGroup()
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(L_Amount)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(C_Amout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Ch_Descarga)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(L_DeckFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(C_FieldPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Btn_addField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    Sub_paneLayout.setVerticalGroup(
        Sub_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(Sub_paneLayout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addGroup(Sub_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Ch_Descarga)
                .addComponent(L_Amount)
                .addComponent(C_FieldPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(L_DeckFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addComponent(Btn_addField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(C_Amout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(1, 1, 1))
    );

    Btn_newfld1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    Btn_newfld1.setText(_Btn_newFld);
    Btn_newfld1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    Btn_newfld1.setBorderPainted(false);
    Btn_newfld1.setFocusable(false);
    Btn_newfld1.setMargin(new java.awt.Insets(0, 0, 0, 0));
    Btn_newfld1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Btn_newfld1ActionPerformed(evt);
        }
    });

    Btn_addFldClose.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    Btn_addFldClose.setText("X");
    Btn_addFldClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    Btn_addFldClose.setContentAreaFilled(false);
    Btn_addFldClose.setFocusable(false);
    Btn_addFldClose.setMargin(new java.awt.Insets(0, 0, 0, 0));
    Btn_addFldClose.setMaximumSize(new java.awt.Dimension(50, 50));
    Btn_addFldClose.setMinimumSize(new java.awt.Dimension(50, 50));
    Btn_addFldClose.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Btn_addFldCloseActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout Panel_newFieldLayout = new javax.swing.GroupLayout(Panel_newField);
    Panel_newField.setLayout(Panel_newFieldLayout);
    Panel_newFieldLayout.setHorizontalGroup(
        Panel_newFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(Panel_newFieldLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(text_newfld1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Btn_newfld1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(3, 3, 3)
            .addComponent(Btn_addFldClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0))
    );
    Panel_newFieldLayout.setVerticalGroup(
        Panel_newFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(Panel_newFieldLayout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addGroup(Panel_newFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Btn_newfld1)
                .addComponent(text_newfld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Btn_addFldClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, 0))
    );

    Label_NunDone.setText("0000");

    Label_injected.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    Label_injected.setText("• "+_L_Pestanas_1);

    Label_Ninject.setText("0000");

    Label_undone.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    Label_undone.setText("• "+_L_Pestanas_0);

    Check_Show.setFont(new java.awt.Font("Arial Unicode MS", 0, 10)); // NOI18N
    Check_Show.setText(_Check_Show);
    Check_Show.setContentAreaFilled(false);
    Check_Show.setFocusPainted(false);
    Check_Show.setFocusable(false);
    Check_Show.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    Check_Show.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    Check_Show.setMargin(new java.awt.Insets(0, 0, 0, 0));
    Check_Show.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            Check_ShowMousePressed(evt);
        }
    });
    Check_Show.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Check_ShowActionPerformed(evt);
        }
    });

    Btn_Campos.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
    Btn_Campos.setText(_Btn_Campos);
    Btn_Campos.setFocusable(false);
    Btn_Campos.setMargin(new java.awt.Insets(2, 2, 2, 2));
    Btn_Campos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Btn_CamposActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Campos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Check_Show))
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(Label_undone)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Label_NunDone))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(Label_injected)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Label_Ninject)))
            .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Label_undone)
                .addComponent(Label_NunDone))
            .addGap(1, 1, 1)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Label_injected)
                .addComponent(Label_Ninject))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Btn_Campos)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Check_Show)
            .addGap(0, 0, 0))
    );

    javax.swing.GroupLayout Main_PanelLayout = new javax.swing.GroupLayout(Main_Panel);
    Main_Panel.setLayout(Main_PanelLayout);
    Main_PanelLayout.setHorizontalGroup(
        Main_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(Sub_pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(Main_PanelLayout.createSequentialGroup()
            .addGap(135, 135, 135)
            .addComponent(jLabel3)
            .addGap(0, 0, Short.MAX_VALUE))
        .addGroup(Main_PanelLayout.createSequentialGroup()
            .addGroup(Main_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, 0)
            .addComponent(Inner_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addComponent(Panel_newField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    Main_PanelLayout.setVerticalGroup(
        Main_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(Main_PanelLayout.createSequentialGroup()
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(Sub_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(Panel_newField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addGroup(Main_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Main_PanelLayout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Pestanas))
                .addComponent(Inner_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, 0)
            .addComponent(jLabel3))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(Main_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(Main_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    
    @SuppressWarnings({"CallToThreadStopSuspendOrResumeManager", "UnusedAssignment"})
    private void Buscador(String Nombre){
        try {
            @SuppressWarnings("MismatchedReadAndWriteOfArray")
            String[] Color={"ic:color,","ic:gray,"};
            @SuppressWarnings("MismatchedReadAndWriteOfArray")
            String[] Tipo={"o,","itp:clipart,","itp:face,","itp:photo,","itp:lineart,"};
            @SuppressWarnings("MismatchedReadAndWriteOfArray")
            String[] Dominio = {".com",".es",".fr",".de",".co.jp",".com.hk",".co.kr"};
            Elements img=new Elements();
            boolean web=true;
            for(int j=0;j<=limite-1;j++){
                try {
                    while(web==true){   
                        Salida(_Texto0);  
                        String charset = "UTF-8";  
                        String Link_Base=("http://images.google"+Dominio[dominio]+"/search?q="+URLEncoder.encode(Nombre, charset)+"&sout=1&tbm=isch&tbs="+Color[color]+Tipo[tipo]);
                        String webSiteURL=(Link_Base); 
                        Document doc = Jsoup.connect(webSiteURL).timeout(0)
                                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36") 
                                .get();
                        img = doc.getElementsByTag("img").select("*");
                    doc.empty();
                        web=false;
                        
                    }    
                    String src = img.get(j).absUrl("src");
                    img.empty();
                    BufferedImage imagenbuff = ImageIO.read(new URL(src));
                    BuffedImg.set(j, imagenbuff);
                    ImageIcon imageIcon = new ImageIcon(imagenbuff);
                    buttons.get(j).setIcon(imageIcon);
                    ButtonReady.set(j, "1");
                    imagenbuff.flush();
                }catch (IOException ex) {}
            Salida(_Texto1+" "+(j+1)+"/"+limite+" "+_Texto1_1);
            }
            
            web=true;
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo Buscador("+Nombre+")"),e);
        }
    }

    @SuppressWarnings("Convert2Diamond")
    private void limpiador() {
        @SuppressWarnings({"Convert2Diamond", "LocalVariableHidesMemberVariable"})
        List<JButton> buttons;  
        buttons = new ArrayList<JButton>();
        buttons.add(ImgBoton_4);buttons.add(ImgBoton_12);buttons.add(ImgBoton_8);buttons.add(ImgBoton_3);       
        buttons.add(ImgBoton_7);buttons.add(ImgBoton_11);buttons.add(ImgBoton_10);buttons.add(ImgBoton_9);       
        buttons.add(ImgBoton_6);buttons.add(ImgBoton_2);buttons.add(ImgBoton_1);buttons.add(ImgBoton_5);  
                for(JButton button : buttons) {
                        button.setIcon(null);
                }
        BufferedImage BuffImg1 = null,BuffImg2 = null,BuffImg3 = null,BuffImg4 = null,BuffImg5 = null,BuffImg6 = null,BuffImg7 = null,BuffImg8 = null,BuffImg9 = null,BuffImg10 = null,BuffImg11 = null,BuffImg12 = null;        
        BuffedImg.clear();
        BuffedImg.add(BuffImg1);BuffedImg.add(BuffImg2);BuffedImg.add(BuffImg3);BuffedImg.add(BuffImg4);BuffedImg.add(BuffImg5);
        BuffedImg.add(BuffImg6);BuffedImg.add(BuffImg7);BuffedImg.add(BuffImg8);BuffedImg.add(BuffImg9);BuffedImg.add(BuffImg10);
        BuffedImg.add(BuffImg11);BuffedImg.add(BuffImg12);
        P_Icon.validate();
        P_Icon.revalidate();
        P_Icon.repaint();        
        for(int j=0;j<ButtonReady.size();j++){
            ButtonReady.set(j, "0");
        }
    }


    
    Runnable runnable = new Runnable(){
            @SuppressWarnings({"UnusedAssignment", "UseSpecificCatch"})
            @Override
            public void run() {
                    try {
                        limpiador();
                        String Traduccion="";
                        borrar++;
                        if(borrar==20){
                            Copy_TextArea.setText("");
                            borrar=0;
                        }
                        if(Table_Undone.isShowing()){
                            if(!Table_Undone.getValueAt(Table_Undone.getSelectedRow(), 0).toString().isEmpty()){
                            if(!Table_Undone.getValueAt(Table_Undone.getSelectedRow(), 0).toString().equals(" ")){
                            if(Table_Undone.getValueAt(Table_Undone.getSelectedRow(), 0).toString().length()>30)
                                JOptionPane.showMessageDialog(null, _Leng, _Alert2, JOptionPane.ERROR_MESSAGE);
                            Original =   Table_Undone.getValueAt(Table_Undone.getSelectedRow(), 0).toString();
                            Traduccion = Table_Undone.getValueAt(Table_Undone.getSelectedRow(), 1).toString();
                            posc = Table_Undone.getValueAt(Table_Undone.getSelectedRow(), 2).toString();
                            ID =  Table_Undone.getValueAt(Table_Undone.getSelectedRow(), 3).toString();
                            }
                            }
                        }
                        if(Table_injected.isShowing()){   
                            if(!Table_injected.getValueAt(Table_injected.getSelectedRow(), 0).toString().isEmpty() ){
                            if(!Table_injected.getValueAt(Table_injected.getSelectedRow(), 0).toString().equals(" ")){
                            if(Table_injected.getValueAt(Table_injected.getSelectedRow(), 0).toString().length()>30) 
                                JOptionPane.showMessageDialog(null, _Leng, _Alert2, JOptionPane.ERROR_MESSAGE);
                            Original =   Table_injected.getValueAt(Table_injected.getSelectedRow(), 0).toString();
                            Traduccion = Table_injected.getValueAt(Table_injected.getSelectedRow(), 1).toString();
                            posc = Table_injected.getValueAt(Table_injected.getSelectedRow(), 2).toString();
                            ID =  Table_injected.getValueAt(Table_injected.getSelectedRow(), 3).toString();  
                            }
                            }
                        } 
                        boolean aux = false;
                        if(aux==false){
                            Text_Original.setText(Original);
                            Text_Traduccion.setText(Traduccion);
                            aux=true;
                        }
                        Salida(_Texto2+" "+Original); 
                        Buscador(Original);
                        
                    } catch (Exception e) {
                    }
                }
        };

  
    ListSelectionListener listSelectionListener = new ListSelectionListener() {
        @Override
        @SuppressWarnings("CallToThreadStopSuspendOrResumeManager")
        public void valueChanged(final ListSelectionEvent listSelectionEvent) {
             boolean adjust = listSelectionEvent.getValueIsAdjusting();
             if (!adjust) {
                 try {
                     if (threadObject.isAlive()) {
                         threadObject.stop();
                         threadObject = new Thread(runnable);
                         threadObject.start();
                     } else {
                         threadObject = new Thread(runnable); 
                         threadObject.start();
                     }
                 } catch (Exception e) {
                 }
            }
        }
    };
   
   


    private void Selection(){
        try {
            Table_Undone.getSelectionModel().addListSelectionListener(listSelectionListener);
            Table_injected.getSelectionModel().addListSelectionListener(listSelectionListener);
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo Selection()"),e);
        }
    }
    


    
    
    public void Estadistica(){
        try {
            Label_NunDone.setText(String.valueOf(Table_Undone.getRowCount()));
            Label_Ninject.setText(String.valueOf(Table_injected.getRowCount()));
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo Estadistica"),e);
        }
    }
    
    
     private  JTable getNewRenderedTable1(final JTable table) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col+1);
                Component comp = super.getTableCellRendererComponent(
                      table,  value, isSelected, hasFocus, row, col+1);
                if (isSelected) { 
                    comp.setBackground(java.awt.Color.LIGHT_GRAY);
                    comp.setForeground(java.awt.Color.BLACK);
                    table.setColumnSelectionInterval(0, 1);
                } else {
                    comp.setBackground(table.getBackground());
                    comp.setForeground(table.getForeground());
                }       
                
                return this;
            }   
        });
        return table;
    }
    
    private  JTable getNewRenderedTable(final JTable table) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col+1);
                Component comp = super.getTableCellRendererComponent(
                      table,  value, isSelected, hasFocus, row, col+1);
                if (isSelected) { 
                    comp.setBackground(java.awt.Color.LIGHT_GRAY);
                    comp.setForeground(java.awt.Color.BLACK);
                    table.setColumnSelectionInterval(0, 1);
                } else {
                    comp.setBackground(table.getBackground());
                    comp.setForeground(table.getForeground());
                }       
                return this;
            }   
        });
        return table;
    }
    

public void yourAddRow_undone(String str1, String str2, String str3, String str4){
    try {
        DefaultTableModel yourModel = (DefaultTableModel) Table_Undone.getModel();
        yourModel.addRow(new Object[]{str1, str2, str3, str4});        
    } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo yourAddRow_undone("+str1+", "+str2+", "+str3+", "+str4+")"),e);
    }
}

public void yourAddRow_Injec(String str1, String str2, String str3, String str4){
    try {
        DefaultTableModel yourModel = (DefaultTableModel) Table_injected.getModel();
        yourModel.addRow(new Object[]{str1, str2, str3, str4});        
    } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo yourAddRow_Injec("+str1+", "+str2+", "+str3+", "+str4+")"),e);
    }
}
    
    
    @SuppressWarnings("CallToThreadStopSuspendOrResumeManager")
    private void SetNullDesc(){
        DefaultTableModel model = (DefaultTableModel) Table_Undone.getModel();
        model.setRowCount(0);
        DefaultTableModel models = (DefaultTableModel) Table_injected.getModel();
        models.setRowCount(0);
        Table_injected.removeAll();
        Label_NunDone.setText("0000");
        Label_Ninject.setText("0000");
        Copy_TextArea.setText("");
        if(texto==false) texto=false;
        else texto=false;
        limpiador();
        try{threadObject.stop();} catch (Exception ex) {}
        Text_Original.setText("");
        Text_Traduccion.setText("");
        Check_Show.setSelected(false);
        Ch_Descarga.setSelected(true);
        Label_Trans.setSelected(false);
    }
    

    public void Salida(String Mensaje){
        if(texto==false){
            Copy_TextArea.setText("── "+Mensaje);
            texto=true;
        }
        else{
            Copy_TextArea.setText(Copy_TextArea.getText()+System.getProperty("line.separator")+"── "+Mensaje);
        }
        Copy_TextArea.setCaretPosition(Copy_TextArea.getDocument().getLength());
    }
 
     

    @SuppressWarnings("UseSpecificCatch")
    private void B_paypalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_paypalActionPerformed
        try {
            Desktop.getDesktop().browse(new URL("http://dankimg.blogspot.com/p/about.html").toURI());
        } catch (Exception e) {}
    }//GEN-LAST:event_B_paypalActionPerformed

    @SuppressWarnings("null")
    private void hide(int index,int aux) {
        TableColumn column = null;
        if(aux==1){
        column = Table_Undone.getColumnModel().getColumn(index);}
        if(aux==2){
        column = Table_injected.getColumnModel().getColumn(index);}
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        doLayout();
    }
    
    @SuppressWarnings("null")
    private void unhide(int index,int aux) {
        TableColumn column = null;
        if(aux==1){
        column = Table_Undone.getColumnModel().getColumn(index);}
        if(aux==2){
        column = Table_injected.getColumnModel().getColumn(index);}
        column.setMinWidth(130);
        column.setMaxWidth(130);
        column.setWidth(130);
        column.setPreferredWidth(130);
        doLayout();
    }
    
    

    
    @SuppressWarnings({"CallToThreadStopSuspendOrResumeManager", "UnusedAssignment", "UseSpecificCatch", "CallToPrintStackTrace"})
    private void Click(int Boton,String ID){
        try {
            if(saved==true){
                save();
                saved=false;
            }
            if(threadObject.isAlive())
                threadObject.stop();
            if(C_FieldPlace.getItemCount()>0){
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            String Original=Text_Original.getText();
            Salida(_Texto4_1+(Boton+1)+_Texto4_2); 
            String dataFolder = System.getenv("APPDATA"); 
            String destination = dataFolder+File.separator+"DAnkiMG";
            File RutaImg = new File(destination+File.separator+String.valueOf("DAnkiMG"+"-"+posc));
            File outputfile = RutaImg;
            ImageIO.write(BuffedImg.get(Boton), "jpg", outputfile);
            ZipFile zipFile = new ZipFile(ruta);
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
            zipFile.addFile(outputfile, parameters);
            RutaImg.delete();
            zipFile.extractFile("media", destination);
            JsonHandle.WriteJson(posc,Original);
            File MediaFile= new File(destination+File.separator+"media");
            zipFile.addFile(MediaFile, parameters);
            CollectionHandle.CollectionWrite(Original, posc,ID);
            File MediaFile2= new File(destination+File.separator+"collection.anki2");
            zipFile.addFile(MediaFile2, parameters);
            DefaultTableModel model_undone =  (DefaultTableModel)Table_Undone.getModel();
            DefaultTableModel model_injected = (DefaultTableModel)Table_injected.getModel();
            int rows;
            if(!Table_injected.isShowing()){
                rows = Table_Undone.convertRowIndexToModel(Table_Undone.getSelectedRow()); 
                int viewRow = Table_Undone.getSelectedRow();
                @SuppressWarnings("Convert2Diamond")
                Vector<String> values = new Vector<String>();
                values.add(Table_Undone.getValueAt(viewRow, 0).toString());
                values.add(Table_Undone.getValueAt(viewRow, 1).toString());
                values.add(Table_Undone.getValueAt(viewRow, 2).toString());
                values.add(Table_Undone.getValueAt(viewRow, 3).toString());
                model_injected.addRow(values);      
                model_undone.removeRow(rows);
                Table_Undone.setModel(model_undone);
                Table_injected.setModel(model_injected);
                try {
                    Table_Undone.setRowSelectionInterval(viewRow, viewRow);
                } catch (Exception e) { 
                }
                Estadistica();
            }
            else{
                rows = Table_injected.convertRowIndexToModel(Table_injected.getSelectedRow());
                @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "Convert2Diamond"})
                Vector<String> values = new Vector<String>();
                int viewRow = Table_injected.getSelectedRow();
                values.add(Table_injected.getValueAt(rows, 0).toString());
                values.add(Table_injected.getValueAt(rows, 1).toString());
                values.add(Table_injected.getValueAt(rows, 2).toString());
                values.add(Table_injected.getValueAt(rows, 3).toString());
                 try {
                    Table_injected.setRowSelectionInterval(viewRow+1, viewRow+1);
                } catch (Exception e) {} 
                
            }
            Table_Undone.setModel(model_undone);
            Table_injected.setModel(model_injected);
            Salida("──────────────────────────────────────");       
            Salida(_Texto5_1+Original+_Texto5_2);
            Salida("──────────────────────────────────────");   
            }else{
                Panel_newField.setVisible(true);
                this.pack();
                JOptionPane.showMessageDialog(null, _createField, _Alert2, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {            
            if(Table_Undone.getRowCount()==0){
            }
            else{
                danki.Log.write(String.valueOf("Metodo Click valores"+
                System.getProperty("line.separator")+" Boton: "+Boton+" ID: "
                +ID+" Su ruta fue: "+ruta+" Posc: "+posc+" Palabra: "+Original),e);
            }
            if(Table_injected.getRowCount()==0){}
            else{
                danki.Log.write(String.valueOf("Metodo Click valores"+
                System.getProperty("line.separator")+" Boton: "+Boton+" ID: "
                +ID+" Su ruta fue: "+ruta+" Posc: "+posc+" Palabra: "+Original),e);
            }
        }
    }


    private void C_FieldPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_FieldPlaceActionPerformed
        try{
        CollectionHandle.Campo=Integer.valueOf(C_FieldPlace.getSelectedItem().toString().substring(0,C_FieldPlace.getSelectedItem().toString().indexOf(" -")));
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_C_FieldPlaceActionPerformed

    private void Check_ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_ShowActionPerformed
        try {
            if (Check_Show.isSelected()) {
                unhide(1, 1);
                unhide(1, 2);
                hide(0, 1);
                hide(0, 2);
                
            } else {
                unhide(0, 1);
                unhide(0, 2);
                hide(1, 1);
                hide(1, 2);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo Check_ShowActionPerformed"),e);
        }
    }//GEN-LAST:event_Check_ShowActionPerformed

    private void C_AmoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_AmoutActionPerformed
        limite=C_Amout.getSelectedIndex()+1;
    }//GEN-LAST:event_C_AmoutActionPerformed

    private void Ch_DescargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ch_DescargaActionPerformed
        if(Ch_Descarga.isSelected()){
            Table_Undone.getSelectionModel().addListSelectionListener(listSelectionListener);
            Table_injected.getSelectionModel().addListSelectionListener(listSelectionListener);
        }
        else{
            Table_Undone.getSelectionModel().removeListSelectionListener(listSelectionListener);
            Table_injected.getSelectionModel().removeListSelectionListener(listSelectionListener);
        }
    }//GEN-LAST:event_Ch_DescargaActionPerformed

    
    int Lan;
    
    boolean saved=false;
    
    public void save(){
        try {
            saved=true;
            String destination = System.getenv("APPDATA")+File.separator+"DAnkiMG";
            Lan = Language_List1.getSelectedIndex();
            tipo = Lista_Tipos.getSelectedIndex();
            color = Tipo_Colors.getSelectedIndex();
            dominio = List_Dominios.getSelectedIndex();
            Amo=C_Amout.getSelectedIndex();
            FLD3=C_FieldPlace.getSelectedIndex();
            Properties prop = new Properties();
            ZipFile zipFile = new ZipFile(ruta);
            zipFile.extractFile("DAnkiMG", destination);
            OutputStream DAnkiMG = new FileOutputStream(destination + File.separator + "DAnkiMG");
            prop.setProperty("FLD1", String.valueOf(Fld1));
            prop.setProperty("FLD2", String.valueOf(Fld2));
            prop.setProperty("S_Lan", String.valueOf(Lan));
            prop.setProperty("S_Type", String.valueOf(tipo));
            prop.setProperty("S_Color", String.valueOf(color));
            prop.setProperty("S_Dom", String.valueOf(dominio));
            prop.setProperty("S_Amo", String.valueOf(Amo));
            prop.setProperty("S_FLD3", String.valueOf(FLD3));
            prop.store(DAnkiMG, null);
            File aux = new File(destination+File.separator+"DAnkiMG");
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
            ZipFile zipFiles = new ZipFile(ruta);
            zipFiles.addFile(aux, parameters);
            DAnkiMG.flush();
            DAnkiMG.close();
        } catch (Exception e) {}  
    }
    
    
    @SuppressWarnings("CallToThreadStopSuspendOrResumeManager")
    private void B_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RefreshActionPerformed
        try{
            save();
            color=Tipo_Colors.getSelectedIndex();
            tipo=Lista_Tipos.getSelectedIndex();
            dominio=List_Dominios.getSelectedIndex();
            threadObject.stop();
            if(threadObject.isAlive()){
                threadObject.stop();
                Runnable();
            }else{
                Runnable();
            }
        } catch (Exception e) {
           //danki.Log.write(String.valueOf("Metodo B_RefreshActionPerformed"),e);
        }
    }//GEN-LAST:event_B_RefreshActionPerformed

    private void ImgBoton_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_11ActionPerformed
        try {
            if(ButtonReady.get(10).equals("1"))   {
                Click(10, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_11ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_11ActionPerformed

    private void ImgBoton_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_7ActionPerformed
        try {
            if(ButtonReady.get(6).equals("1"))   {
                Click(6, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_7ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_7ActionPerformed

    private void ImgBoton_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_9ActionPerformed
        try {
            if(ButtonReady.get(8).equals("1"))   {
                Click(8, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_9ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_9ActionPerformed

    private void ImgBoton_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_6ActionPerformed
        try {
            if(ButtonReady.get(5).equals("1"))   {
                Click(5, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_6ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_6ActionPerformed

    private void ImgBoton_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_3ActionPerformed
        try {
            if(ButtonReady.get(2).equals("1"))   {
                Click(2, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_3ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_3ActionPerformed

    private void ImgBoton_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_4ActionPerformed
        try {
            if(ButtonReady.get(3).equals("1"))   {
                Click(3, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_4ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_4ActionPerformed

    private void ImgBoton_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_5ActionPerformed
        try {
            if(ButtonReady.get(4).equals("1"))   {
                Click(4, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_4ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_5ActionPerformed

    private void ImgBoton_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_2ActionPerformed
        try {
            if(ButtonReady.get(1).equals("1"))   {
                Click(1, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_2ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_2ActionPerformed

    private void ImgBoton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_1ActionPerformed
        try {
                if(ButtonReady.get(0).equals("1"))   {
                    Click(0, ID);
                }
            } catch (Exception e) {
                danki.Log.write(String.valueOf("Metodo ImgBoton_1ActionPerformed"),e);
            }
            
    }//GEN-LAST:event_ImgBoton_1ActionPerformed

    private void ImgBoton_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_12ActionPerformed
        try {
            if(ButtonReady.get(11).equals("1"))   {
                Click(11, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_12ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_12ActionPerformed

    private void ImgBoton_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_8ActionPerformed
        try {
            if(ButtonReady.get(7).equals("1"))   {
                Click(7, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_8ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_8ActionPerformed

    private void ImgBoton_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgBoton_10ActionPerformed
        try {
            if(ButtonReady.get(9).equals("1"))   {
                Click(9, ID);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ImgBoton_10ActionPerformed"),e);
        }
    }//GEN-LAST:event_ImgBoton_10ActionPerformed

    private void Label_TransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Label_TransActionPerformed
        if(Label_Trans.isSelected()){
            Panel_Trans.setVisible(true);}
        else{
            Panel_Trans.setVisible(false);}
    }//GEN-LAST:event_Label_TransActionPerformed

    @SuppressWarnings("UseSpecificCatch")
    private void Menu_HowToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_HowToActionPerformed
        try {
                Desktop.getDesktop().browse(new URL("http://dankimg.blogspot.com/p/how-to.html").toURI());
            } catch (Exception e) {
                danki.Log.write(String.valueOf("Metodo jButton3ActionPerformed"),e);
        }
    }//GEN-LAST:event_Menu_HowToActionPerformed

    private void Menu_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_AboutActionPerformed
        Frame_About.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icono)));
        Frame_About.setSize(588, 350);
        Frame_About.setLocationRelativeTo(null);
        Frame_About.setAlwaysOnTop(true);
        Frame_About.setVisible(true);
    }//GEN-LAST:event_Menu_AboutActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        int L=Language_List1.getSelectedIndex();
        color=Tipo_Colors.getSelectedIndex();
        tipo=Lista_Tipos.getSelectedIndex();
        dominio=List_Dominios.getSelectedIndex();
        if(L==0){ 
            Readlang("en_us");
            Reset();
            Language_List1.setSelectedIndex(0);
        }
        if(L==1){ 
            Readlang("la_es");
            Reset();
            Language_List1.setSelectedIndex(1);
        }
        if(L==2){ 
            Readlang("eu_fr");
            Reset();
            Language_List1.setSelectedIndex(2);
        }
        if(L==3){ 
            Readlang("jp_jp");
            Reset();
            Language_List1.setSelectedIndex(3);
        }
        Tipo_Colors.setSelectedIndex(color);
        Lista_Tipos.setSelectedIndex(tipo);
        List_Dominios.setSelectedIndex(dominio);
        
        ChooseFlds.pack();
        this.pack();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    @SuppressWarnings("UseSpecificCatch")
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Desktop.getDesktop().browse(new URL("http://dankimg.blogspot.com").toURI());
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo jButton3ActionPerformed"),e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void B_HowIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_HowIActionPerformed
        danki.About.Mostrar();
    }//GEN-LAST:event_B_HowIActionPerformed

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try {
            if (Table_Undone.getRowCount() > 0) {
                int reply = JOptionPane.showConfirmDialog(null, _Alert1, _Alert2, JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    Cargar(false);
                    this.pack();
                }
            } else {
                Cargar(false);
                this.pack();
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo Button_LoadActionPerformed"),e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

   
    
    @SuppressWarnings({"ConvertToTryWithResources", "Convert2Diamond", "CallToThreadStopSuspendOrResumeManager", "UseSpecificCatch", "CallToPrintStackTrace"})
    private void Btn_AceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AceptActionPerformed
        try{
        NameFields = JsonHandle.JsonCollection();
        DefaultTableModel model = (DefaultTableModel) Table_Undone.getModel();
        DefaultTableModel models = (DefaultTableModel) Table_injected.getModel();
        model.setRowCount(0);
        models.setRowCount(0);    
        C_FieldPlace.removeAllItems();
        Properties prop = new Properties();
        String destination = System.getenv("APPDATA")+File.separator+"DAnkiMG";
        Fld1=FLD1.getSelectedIndex();
        Fld2=FLD2.getSelectedIndex();
        Camp_1 = NameFields.get(Fld1);
        Camp_2 = NameFields.get(Fld2);
        Label_Orig.setText(Camp_1);
        Label_Trans.setText(Camp_2);
        Table_Undone.getColumnModel().getColumn(0).setHeaderValue(Camp_1);
        Table_Undone.getColumnModel().getColumn(1).setHeaderValue(Camp_2);
        Table_injected.getColumnModel().getColumn(0).setHeaderValue(Camp_1);
        Table_injected.getColumnModel().getColumn(1).setHeaderValue(Camp_2);
        Table_injected.repaint();
        Table_Undone.repaint();
        OutputStream  DAnkiMG = new FileOutputStream(destination+File.separator+"DAnkiMG");
        prop.setProperty("FLD1", String.valueOf(Fld1));
        prop.setProperty("FLD2", String.valueOf(Fld2));
        prop.setProperty("S_Lan", String.valueOf("0"));
        prop.setProperty("S_Type", String.valueOf("0"));
        prop.setProperty("S_Color", String.valueOf("0"));
        prop.setProperty("S_Dom", String.valueOf("0"));
        prop.store(DAnkiMG, null);
        DAnkiMG.flush();
        DAnkiMG.close();
        File aux = new File(destination+File.separator+"DAnkiMG");
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
        ZipFile zipFile = new ZipFile(ruta);
        zipFile.addFile(aux, parameters);
        Tags = new ArrayList<String>(UnZip.LabelAnki());
        for (int i = 0; i < Palabras.size(); i++) {
            if (!Tags.get(i).contains("DAnkiMG")) {
                yourAddRow_undone((Palabras.get(i).size()<=Fld1)?" ":Palabras.get(i).get(Fld1),(Palabras.get(i).size()<=Fld2)?" ":Palabras.get(i).get(Fld2),String.valueOf(i + 1), ID_P.get(i));   
            }
            else{
               yourAddRow_Injec((Palabras.get(i).size()<=Fld1)?" ":Palabras.get(i).get(Fld1),(Palabras.get(i).size()<=Fld2)?" ":Palabras.get(i).get(Fld2), String.valueOf(i + 1), ID_P.get(i));   
            }
        }
        for (int i = 0; i < NameFields.size(); i++) {
            if(Fld1==i || Fld2==i){
            }
            else{
                C_FieldPlace.addItem(String.valueOf(i + 1) + " - " + NameFields.get(i));
            }            
        }
        Table_Undone.setCellSelectionEnabled(true);
        Table_injected.setCellSelectionEnabled(true);
        Estadistica();
        Table_Undone.getSelectionModel().addListSelectionListener(listSelectionListener);
        Table_injected.getSelectionModel().addListSelectionListener(listSelectionListener);
        Pestanas.revalidate();
        Pestanas.repaint();
        try{threadObject.stop();}catch (Exception e) {}
        this.pack();
        Label_Recomend.setVisible(false);
        ChooseFlds.dispose();
        } catch (Exception e) {
        e.printStackTrace();
        
        }
    }//GEN-LAST:event_Btn_AceptActionPerformed

    @SuppressWarnings("CallToThreadStopSuspendOrResumeManager")
    private void Btn_CamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CamposActionPerformed
        if(Table_Undone.getRowCount()==0 && Table_injected.getRowCount()==0 ){
        }
        else{
            try{threadObject.stop();} catch (Exception ex) {}
            Table_Undone.getSelectionModel().removeListSelectionListener(listSelectionListener);
            Table_injected.getSelectionModel().removeListSelectionListener(listSelectionListener);
            ChooseFlds.pack();
            ChooseFlds.setLocationRelativeTo(null);
            ChooseFlds.setVisible(true);
            ChooseFlds.setAlwaysOnTop(true);
        }
    }//GEN-LAST:event_Btn_CamposActionPerformed

    private void Btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cancelActionPerformed
        ChooseFlds.dispose();
    }//GEN-LAST:event_Btn_cancelActionPerformed

    private void FLD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FLD1ActionPerformed
       
    }//GEN-LAST:event_FLD1ActionPerformed

    private void Btn_addFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addFieldActionPerformed
        if(Table_Undone.getRowCount()==0 && Table_injected.getRowCount()==0 ){
        }
        else{
            Panel_newField.setVisible(true);
            this.pack();
        }
            
    }//GEN-LAST:event_Btn_addFieldActionPerformed

    @SuppressWarnings({"null", "UseSpecificCatch"})
    private void Btn_newfld1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_newfld1ActionPerformed
        try{
            if(text_newfld1.getText().length()<30 && !text_newfld1.getText().isEmpty()){
            String newField = text_newfld1.getText();
            @SuppressWarnings("UnusedAssignment")
            List<Row> Colum = new ArrayList();
            org.json.JSONObject object = null;
            boolean bool=false;
            int size=12;
            JSONArray Media = new JSONArray();
            JSONObject item_nuevo = new JSONObject();
            String updateSql = "update col set models = :valParam where id = :idParam";
            String sql = "update notes set flds=flds||'';";
            Class.forName("org.sqlite.JDBC");
            Sql2o sql2os = new Sql2o("jdbc:sqlite:" + destination + File.separator + "collection.anki2", "", "");
            Connection cons = sql2os.open();
            Colum = cons.createQuery("select models from col;").executeAndFetchTable().rows();
            String Json = Colum.get(0).getObject("models").toString();
            org.json.JSONObject myjson = new org.json.JSONObject(Json);
            JSONArray nameArray = myjson.names();
            JSONArray valArray = myjson.toJSONArray(nameArray);
            for (int n = 0; n < valArray.length(); n++) {
                object = valArray.getJSONObject(n);
            }
            item_nuevo.put("ord", object.getJSONArray("flds").length());
            item_nuevo.put("size", size);
            item_nuevo.put("name", newField);
            item_nuevo.put("sticky", bool);
            item_nuevo.put("media",  Media);
            item_nuevo.put("rtl", bool);
            item_nuevo.put("font", "Arial");
            object.accumulate("flds", item_nuevo);
            JSONObject myjson1 = new JSONObject(Json);
            JSONObject objectaux = new JSONObject();
            objectaux.put(myjson1.names().toString().replaceAll("\\]", "").replaceAll("\\[", "")
                    .replaceAll("\"", ""), object);
            cons.createQuery(updateSql)
                        .addParameter("valParam", objectaux)
                        .addParameter("idParam", 1)
                        .executeUpdate();
            cons.createQuery(sql).executeUpdate();
            File MediaFile= new File(destination+File.separator+"collection.anki2");
            ZipFile zipFile = new ZipFile(new File(String.valueOf(ruta)));
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
            zipFile.addFile(MediaFile, parameters);
            Panel_newField.setVisible(false);
            text_newfld1.setText("");
            String aux;
            aux=String.valueOf(FLD1.getItemCount()+1)+" - "+newField;
            C_FieldPlace.addItem(aux);
            FLD1.addItem(aux);
            FLD2.addItem(aux);
            C_FieldPlace.setSelectedIndex(C_FieldPlace.getItemCount()-1);
            this.pack();
            }
            else{
                if(text_newfld1.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, _Empty_fld, _Alert2, JOptionPane.ERROR_MESSAGE);
                if(text_newfld1.getText().length()>30)
                    JOptionPane.showMessageDialog(null, _Leng_fld, _Alert2, JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo campo nuevo="+text_newfld1.getText()),e);
        } 
    }//GEN-LAST:event_Btn_newfld1ActionPerformed

    private void Btn_addFldCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addFldCloseActionPerformed
        Panel_newField.setVisible(false);
        text_newfld1.setText("");
        this.pack();
    }//GEN-LAST:event_Btn_addFldCloseActionPerformed

    private void TermsCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TermsCheckActionPerformed
       if(TermsCheck.isSelected())
        Area_About.setText(_Policy);
       if(!TermsCheck.isSelected())
        Area_About.setText(_About);
       Area_About.setCaretPosition(0);

       
    }//GEN-LAST:event_TermsCheckActionPerformed
    
    private void Check_ShowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Check_ShowMousePressed
        
    }//GEN-LAST:event_Check_ShowMousePressed

    private void Table_UndoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_UndoneMousePressed
       

    }//GEN-LAST:event_Table_UndoneMousePressed

    private void Table_UndoneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_UndoneMouseReleased

    }//GEN-LAST:event_Table_UndoneMouseReleased

    boolean first=true;
    
    @SuppressWarnings({"Convert2Diamond", "ConvertToTryWithResources", "UseSpecificCatch"})
    public void Cargar(boolean arras){
        try{   
        int n;
        Properties prop = new Properties();
        if (arras == false) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("APKG APKG", "apkg", "apkg");
            JFileChooser VABRIR = new JFileChooser();
            VABRIR.setDialogTitle(_T_Abrir);
            VABRIR.setFileFilter(filter);
            n = VABRIR.showOpenDialog(this);
            ruta = VABRIR.getSelectedFile();
        } else {
                n = 0;
        }
        if (n == 0) {
            Palabras = new ArrayList<List<String>>(UnZip.UnzipApkg(ruta.toString()));
            Tags = new ArrayList<String>(UnZip.LabelAnki());
            ID_P = CollectionHandle.ReadID();
            NameFields = JsonHandle.JsonCollection();
            C_FieldPlace.removeAllItems();
            FLD1.removeAllItems();
            FLD2.removeAllItems();
            for (int i = 0; i < NameFields.size(); i++) {
                FLD1.addItem(String.valueOf(i + 1) + " - " + NameFields.get(i));
                FLD2.addItem(String.valueOf(i + 1) + " - " + NameFields.get(i));
            }
                String destination = System.getenv("APPDATA")+File.separator+"DAnkiMG";
                //if(first==true)
                    SetNullDesc();
                //first=false;
                Salida(_Texto3_1+" "+ruta +" "+_Texto3_2); 
                this.setTitle("DAnkiMG [BETA] 1.0.0.1");
                this.setTitle(this.getTitle() + " " + ruta);
                ZipFile zipFile = new ZipFile(ruta);
                if(zipFile.getFileHeader("DAnkiMG") == null){
                    Label_Recomend.setVisible(true);
                    ChooseFlds.pack();
                    ChooseFlds.setLocationRelativeTo(null);
                    ChooseFlds.setAlwaysOnTop(true);
                    ChooseFlds.setVisible(true);
                }
                else{
                    zipFile.extractFile("DAnkiMG", destination);
                    InputStream DAnkiMG = new FileInputStream(destination+File.separator+"DAnkiMG");
                    prop.load(DAnkiMG);
                    DAnkiMG.close();
                    Fld1=Integer.valueOf(prop.getProperty("FLD1"));
                    Fld2=Integer.valueOf(prop.getProperty("FLD2"));
                    try{
                    Language_List1.setSelectedIndex(Integer.valueOf(prop.getProperty("S_Lan")));
                    int L=Integer.valueOf(prop.getProperty("S_Lan"));
                    if(L==0){ 
                        Readlang("en_us");
                        Reset();
                        Language_List1.setSelectedIndex(0);
                    }
                    if(L==1){ 
                        Readlang("la_es");
                        Reset();
                        Language_List1.setSelectedIndex(1);
                    }
                    if(L==2){ 
                        Readlang("eu_fr");
                        Reset();
                        Language_List1.setSelectedIndex(2);
                    }
                    if(L==3){ 
                        Readlang("jp_jp");
                        Reset();
                        Language_List1.setSelectedIndex(3);
                    }
                    ChooseFlds.pack();
                    this.pack();
                    
                    Lista_Tipos.setSelectedIndex(Integer.valueOf(prop.getProperty("S_Type")));
                    Tipo_Colors.setSelectedIndex(Integer.valueOf(prop.getProperty("S_Color")));
                    List_Dominios.setSelectedIndex(Integer.valueOf(prop.getProperty("S_Dom")));
                    C_Amout.setSelectedIndex(Integer.valueOf(prop.getProperty("S_Amo")));                    
                    
                    //
                    color=Tipo_Colors.getSelectedIndex();
                    tipo=Lista_Tipos.getSelectedIndex();
                    dominio=List_Dominios.getSelectedIndex();
                    
                    } catch (Exception e) {} 
                    
                    //
                    for (int i = 0; i < Palabras.size(); i++) {
                        if (!Tags.get(i).contains("DAnkiMG")) {
                            yourAddRow_undone((Palabras.get(i).size()<=Fld1)?" ":Palabras.get(i).get(Fld1),(Palabras.get(i).size()<=Fld2)?" ":Palabras.get(i).get(Fld2),String.valueOf(i + 1), ID_P.get(i));   
                        }
                        else{
                           yourAddRow_Injec((Palabras.get(i).size()<=Fld1)?" ":Palabras.get(i).get(Fld1),(Palabras.get(i).size()<=Fld2)?" ":Palabras.get(i).get(Fld2), String.valueOf(i + 1), ID_P.get(i));   
                        }
                    }
                    Camp_1 = NameFields.get(Fld1);
                    Camp_2 = NameFields.get(Fld2);
                    Label_Orig.setText(Camp_1);
                    Label_Trans.setText(Camp_2);
                    Table_Undone.getColumnModel().getColumn(0).setHeaderValue(Camp_1);
                    Table_Undone.getColumnModel().getColumn(1).setHeaderValue(Camp_2);
                    Table_injected.getColumnModel().getColumn(0).setHeaderValue(Camp_1);
                    Table_injected.getColumnModel().getColumn(1).setHeaderValue(Camp_2);
                    Table_Undone.setCellSelectionEnabled(true);
                    Table_injected.setCellSelectionEnabled(true);
                    for (int i = 0; i < NameFields.size(); i++) {
                        if(Fld1==i || Fld2==i){}
                        else{
                            C_FieldPlace.addItem(String.valueOf(i + 1) + " - " + NameFields.get(i));
                        }            
                    }
                    C_FieldPlace.setSelectedIndex(Integer.valueOf(prop.getProperty("S_FLD3")));
                    FLD1.setSelectedIndex(Fld1);
                    FLD2.setSelectedIndex(Fld2);
                    Estadistica();
                    this.pack();
                    DAnkiMG.close();
                }
        }
        } catch (Exception e) {
            e.printStackTrace();
            danki.Log.write(String.valueOf("Metodo Cargar"),e);
        } 
        
    } 


    public void aux(Object aux){
        System.out.println(aux);
    }

 boolean s1=false;
    boolean s2=false;
    
    public void magic(){
        try {
            B_Refresh.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }
                @Override
                public void keyPressed(KeyEvent e) {
                    if((e.getKeyCode() == KeyEvent.VK_CONTROL)){
                        s1=true;
                    }
                    if((e.getKeyCode() == KeyEvent.VK_NUMPAD0)){
                        s2=true;
                    }
                    if ((s2 == true) && (s1==true)) {
                        
                        Decode.setAlwaysOnTop(rootPaneCheckingEnabled);
                        Decode.pack();
                        Decode.setLocationRelativeTo(null);
                        Decode.setVisible(true);
                        s1=false;
                        s2=false;
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo magic()"),e);
        }
    }
    
    
    public void Runnable(){
        try {
            limpiador();
            if(Table_Undone.isShowing()){
                Runnable runnables = new Runnable() {
                    @SuppressWarnings("override")
                    public void run() {
                        Buscador(Table_Undone.getValueAt(Table_Undone.getSelectedRow(), 0).toString());
                    }
                };
                threadObject = new Thread(runnables);
                threadObject.start();    
            }
            if(Table_injected.isShowing()){
                Runnable runnables = new Runnable() {
                    @SuppressWarnings("override")
                    public void run() {
                        Buscador(Table_injected.getValueAt(Table_injected.getSelectedRow(), 0).toString());
                    }
                };
                threadObject = new Thread(runnables);
                threadObject.start();    
            }
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo Runnable()"),e);
        }
       }

    
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextPane Area_About;
    public static javax.swing.JToggleButton B_HowI;
    public static javax.swing.JButton B_Refresh;
    public static javax.swing.JToggleButton B_paypal;
    public static javax.swing.JButton Btn_Acept;
    public static javax.swing.JButton Btn_Campos;
    public static javax.swing.JButton Btn_addField;
    public static javax.swing.JButton Btn_addFldClose;
    public static javax.swing.JButton Btn_cancel;
    public static javax.swing.JButton Btn_newfld1;
    public static javax.swing.JComboBox<String> C_Amout;
    public static javax.swing.JComboBox<String> C_FieldPlace;
    public static javax.swing.JCheckBox Ch_Descarga;
    public static javax.swing.JCheckBox Check_Show;
    public static javax.swing.JFrame ChooseFlds;
    public static javax.swing.JTextArea Copy_TextArea;
    public static javax.swing.JFrame Decode;
    public static javax.swing.JComboBox<String> FLD1;
    public static javax.swing.JComboBox<String> FLD2;
    public static javax.swing.JFileChooser File_Output;
    public static javax.swing.JFrame Frame_About;
    public static javax.swing.JButton ImgBoton_1;
    public static javax.swing.JButton ImgBoton_10;
    public static javax.swing.JButton ImgBoton_11;
    public static javax.swing.JButton ImgBoton_12;
    public static javax.swing.JButton ImgBoton_2;
    public static javax.swing.JButton ImgBoton_3;
    public static javax.swing.JButton ImgBoton_4;
    public static javax.swing.JButton ImgBoton_5;
    public static javax.swing.JButton ImgBoton_6;
    public static javax.swing.JButton ImgBoton_7;
    public static javax.swing.JButton ImgBoton_8;
    public static javax.swing.JButton ImgBoton_9;
    public static javax.swing.JPanel Inner_Panel;
    public static javax.swing.JLabel L_Amount;
    public static javax.swing.JLabel L_DeckFields;
    public static javax.swing.JLabel Labe_lFldT;
    public static javax.swing.JLabel Label_Buscar;
    public static javax.swing.JLabel Label_Mostrar;
    public static javax.swing.JLabel Label_Ninject;
    public static javax.swing.JLabel Label_NunDone;
    public static javax.swing.JLabel Label_Orig;
    public static javax.swing.JLabel Label_Recomend;
    public static javax.swing.JCheckBox Label_Trans;
    public static javax.swing.JLabel Label_icono;
    public static javax.swing.JLabel Label_injected;
    public static javax.swing.JLabel Label_undone;
    public static javax.swing.JComboBox<String> Language_List1;
    public static javax.swing.JComboBox List_Dominios;
    public static javax.swing.JComboBox Lista_Tipos;
    public static javax.swing.JPanel Main_Panel;
    public static javax.swing.JButton Menu_About;
    public static javax.swing.JButton Menu_HowTo;
    public static javax.swing.JPanel Orig_Panel;
    public static javax.swing.JPanel P_Icon;
    public static javax.swing.JPanel Panel_Decode;
    public static javax.swing.JPanel Panel_Trans;
    public static javax.swing.JPanel Panel_newField;
    public static javax.swing.JTabbedPane Pestanas;
    public static javax.swing.JFileChooser Salida_conjunta;
    public static javax.swing.JScrollPane Scroll_injected;
    public static javax.swing.JScrollPane Scroll_undone;
    public static javax.swing.JFileChooser Selector;
    public static javax.swing.JPanel Sub_pane;
    public static javax.swing.JTable Table_Undone;
    private javax.swing.JTable Table_Undones;
    public static javax.swing.JTable Table_injected;
    public static javax.swing.JCheckBox TermsCheck;
    public static javax.swing.JScrollPane Text_JtextPanel;
    public static javax.swing.JTextArea Text_Original;
    public static javax.swing.JTextArea Text_Traduccion;
    public static javax.swing.JTextField Text_magic;
    public static javax.swing.JComboBox Tipo_Colors;
    public static javax.swing.JPanel Traduc_Panel;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JToggleButton jToggleButton2;
    public static javax.swing.JLabel label_fld1;
    public static javax.swing.JLabel label_fld2;
    public static javax.swing.JPanel menu;
    public static javax.swing.JTextField text_newfld1;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
    
    private void setIcon() {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(icono)));
    }


    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void arrs(){
        try {
            new FileDrop(Main_Panel, new FileDrop.Listener() {                
                @SuppressWarnings("override")
                public void filesDropped(java.io.File[] files) {                    
                    try {                        
                        ruta = files[0];
                        if (!files[0].toString().substring(files[0].toString().lastIndexOf(".") + 1).equals("apkg")) {
                            JOptionPane.showMessageDialog(null, _T_Content, _Alert2, JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (Table_Undone.getRowCount() > 0) {
                                int reply = JOptionPane.showConfirmDialog(null, _Alert1, _Alert2, JOptionPane.YES_NO_OPTION);
                                if (reply == JOptionPane.YES_OPTION) {
                                    Cargar(true);
                                }
                            }
                            else Cargar(true);
                        }
                    } catch (Exception e) {
                        danki.Log.write("Metodo en el que arrastra", e);
                    }                    
                }
            });
            
            new FileDrop(Panel_Decode, new FileDrop.Listener() {                
                @SuppressWarnings({"override", "ConvertToTryWithResources"})
                public void filesDropped(java.io.File[] files) {                    
                    try {                        
                        String contenido = new String();
                        BufferedReader in = new BufferedReader(new FileReader(files[0]));
                        String line;
                        while ((line = in.readLine()) != null) {
                            contenido += line;
                        }
                        in.close();
                        String magic = Text_magic.getText();
                        String Ready = danki.CollectionHandle.yui(contenido.substring(228), magic);
                        try (PrintStream out = new PrintStream(new FileOutputStream(files[0]))) {
                            out.print(Ready);
                            out.close();
                        }
                    } catch (Exception e) {
                    }                    
                }
            });
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo arrs()"),e);
        }

    }
    
    public void Reset(){
        Menu_HowTo.setText(_Menu_HowTo);
        Menu_About.setText(_Menu_About);
        Pestanas.setTitleAt(0, _Pestanas_0); 
        Pestanas.setTitleAt(1, _Pestanas_1);   
        Label_undone.setText("• "+_L_Pestanas_0);
        Label_injected.setText("• "+_L_Pestanas_1);
        jButton1.setText(_Button_Load);         
        Label_Buscar.setText(_B_Search);
        L_DeckFields.setText(_L_DeckFields);
        Ch_Descarga.setText(_Ch_Descarga);
        Check_Show.setText(_Check_Show);
        L_Amount.setText(_L_Amount);
        Label_Mostrar.setText("<html>"+_Label_Mostrar+"<html>");
        ChooseFlds.setTitle(_Title_Campos);
        Btn_Campos.setText(_Btn_Campos);
        Labe_lFldT.setText(_Label_Campos);
        label_fld1.setText(_Label_FLD1);
        label_fld2.setText(_Label_FLD2);
        Btn_Campos.setText(_Btn_Campos);
        Btn_Acept.setText(_Btn_Acept);
        Lista_Tipos.removeAllItems();
        Lista_Tipos.addItem(_CType0);
        Lista_Tipos.addItem(_CType1);
        Lista_Tipos.addItem(_CType2);
        Lista_Tipos.addItem(_CType3);
        Tipo_Colors.removeAllItems();
        Tipo_Colors.addItem(_CColour0);
        Tipo_Colors.addItem(_CColour1);
        Language_List1.removeAllItems();
        Language_List1.addItem(_Idioma0);
        Language_List1.addItem(_Idioma1);
        Language_List1.addItem(_Idioma2);
        Language_List1.addItem(_Idioma3);
        List_Dominios.removeAllItems();
        List_Dominios.addItem(_Cidioma0);
        List_Dominios.addItem(_Cidioma1);
        List_Dominios.addItem(_Cidioma2);
        List_Dominios.addItem(_Cidioma3);
        List_Dominios.addItem(_Cidioma4);
        List_Dominios.addItem(_Cidioma5);
        List_Dominios.addItem(_Cidioma6);
        Frame_About.setTitle(_Menu_About);
        B_HowI.setText(_HowI);
        Log_frame.setTitle(_Alert2);
        jButton4.setText(_Report);
        Btn_Acept.setText(_Btn_Acept);
        Btn_cancel.setText(_Cancel);
        L_MensajeNuevo.setText(_Update);
        L_Ava.setText(_Ava);
        Frame_Upgrade.setTitle(_New);
        Frame_Upgrade.repaint();
        Frame_Upgrade.pack();
        BodyError_Label.setText(_Body_Err);
        Btn_newfld1.setText(_Btn_newFld);
        Area_About.setText(_Policy);
        Area_About.setText(_About);
        TermsCheck.setSelected(false);
        Label_Recomend.setText(_Label_Recomend);
        Area_About.setCaretPosition(0);
    }
    

    public void close_method(){
        System.exit(0);
    }
    


}

