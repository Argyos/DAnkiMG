
package danki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Log {
    public static String Clipboard;
    static String dataFolder = System.getenv("APPDATA"); 
    @SuppressWarnings("StaticNonFinalUsedInInitialization")
    static String destination = dataFolder+File.separator+"DAnkiMG";
    
    public static String arg;
    public static Exception e;
    
    public static void write(String _arg,Exception _e){
        try{
            arg=_arg;
            e=_e;
            danki.Update.Ventana();    
        }catch(Exception es){
            danki.Log.write(String.valueOf("Metodo Encriptar"),es);
        } 
    }
    
    @SuppressWarnings("empty-statement")
    public static void info(String _arg,Exception _e){
        arg=_arg;
        e=_e;
        Writer writers = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writers);
        e.printStackTrace(printWriter);
        String salida = writers.toString();
        String Texto = null;
        File directorio=new File(destination+File.separator+"Log");
        if(!directorio.exists()) directorio.mkdir();
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HHmmss");
        Date date = new Date();
        Properties p = System.getProperties();
        Enumeration keys = p.keys();
        Texto="Informacion del sist"+System.getProperty("line.separator");
        Texto+="FECHA "+dateFormat.format(date)+" "+System.getProperty("line.separator");
        while (keys.hasMoreElements()) {
          String key = (String)keys.nextElement();
          String value = (String)p.get(key);
          Texto+=String.valueOf(key+": "+value+System.getProperty("line.separator"));
        }
        Texto+="Memoria disponible="+Runtime.getRuntime().totalMemory()+" Bytes"+System.getProperty("line.separator");
        long maxMemory = Runtime.getRuntime().maxMemory();
        Texto+="Memoria maxima usada por Jvm="+(maxMemory == Long.MAX_VALUE ? " Sin limite" : maxMemory)+" Bytes"+" Bytes"+System.getProperty("line.separator");
        Texto+="Memoria libre de la Jvm= "+Runtime.getRuntime().freeMemory()+" Bytes"+" Bytes"+System.getProperty("line.separator");
        Texto+="DATOS DEL ERROR"+System.getProperty("line.separator");
        Texto+=arg+System.getProperty("line.separator");
        Texto+=salida;
        String Nuevo = danki.JsonHandle.op(Texto);
        Clipboard = Nuevo;
        String aux="";
        aux+="----------------------------------------------------------------------"+System.getProperty("line.separator");
        aux+="Please send this report error to info.dankimg@gmail.com"+System.getProperty("line.separator");
        aux+="in order to improve the software."+System.getProperty("line.separator");
        aux+="----------------------------------------------------------------------"+System.getProperty("line.separator");
        @SuppressWarnings("Convert2Diamond")
        List<String> auxs = new ArrayList<String>(splitEqually(Nuevo,70));
        for(int i=0;i<auxs.size();i++){
            aux+=auxs.get(i)+System.getProperty("line.separator");;
        }
        String ruta = String.valueOf(danki.Update.Ruta);
        try (PrintStream out = new PrintStream(new FileOutputStream(ruta+File.separator+danki.Update.Nombre))) {
            out.print(aux);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<String> splitEqually(String text, int size) {
        @SuppressWarnings("Convert2Diamond")
        List<String> ret = new ArrayList<String>((text.length() + size - 1) / size);
        for (int start = 0; start < text.length(); start += size) {
            ret.add(text.substring(start, Math.min(text.length(), start + size)));
        }
        return ret;
    }
    
}
