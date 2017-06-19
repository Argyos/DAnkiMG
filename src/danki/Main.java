
package danki;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
    static DAnkiMG Principal = new DAnkiMG();
    
    public static void main(String[] args) {
        
       try{
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
        System.out.println("Unable to load Windows look and feel");
        }
       try{
        danki.PreCarga.Readlang("en_us");
        Principal = new DAnkiMG();
        Principal.setLocationRelativeTo(null);
        Principal.pack();
        Principal.setTitle("DAnkiMG [BETA] 1.0.0.1");  
        Principal.setVisible(true);
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }
    

    
    
    
    
   
    
}


