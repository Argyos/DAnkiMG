
package danki;


import java.io.File;
import net.lingala.zip4j.core.ZipFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Row;


public class UnZip {
    static String dataFolder = System.getenv("APPDATA"); 
    
    
    public static List<List <String>> UnzipApkg(String Ruta){
        String destination = dataFolder+File.separator+"DAnkiMG";
        try {
             ZipFile zipFiles = new ZipFile(Ruta);
             zipFiles.extractFile("collection.anki2", destination);
             List Palabras = collection();
             return Palabras;
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo  Lectura UnzipApkg:"+Ruta),e);
            return null;
        }
    }

    public static int s1(){
        return 4;
    }
    
    public static List<List <String>> collection(){
        try {
            
            @SuppressWarnings("UnusedAssignment")
            List<Row> Colum = new ArrayList();
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<String>  IDAux = new ArrayList();
            Class.forName("org.sqlite.JDBC");
            Sql2o sql2o = new Sql2o("jdbc:sqlite:"+dataFolder+File.separator+"DAnkiMG"+File.separator+"collection.anki2","","");
            try(Connection con = sql2o.open()) {
                Colum=con.createQuery("select * from notes;").executeAndFetchTable().rows();
            }
            @SuppressWarnings("UnusedAssignment")
            List<String> lists = null; //aux
            @SuppressWarnings("Convert2Diamond")
            List<List <String>> lista = new ArrayList<List<String>>();
            for(int i=0;i<Colum.size();i++){
                IDAux.add(Colum.get(i).getObject("ID").toString());
                String aux1 = Colum.get(i).getObject("flds").toString();
                lists = Arrays.asList(aux1.split(""));
                lista.add(lists);
            }
            return lista;
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo collection"),e);
        }
        List lista=null;
        return lista;
    }
    
    

    
    
    public static List<String> LabelAnki(){
            try{
                @SuppressWarnings("UnusedAssignment")
                List<Row> label = new ArrayList();
                List<String> DankiMG = new ArrayList();
                Class.forName("org.sqlite.JDBC");
                Sql2o sql2o = new Sql2o("jdbc:sqlite:"+dataFolder+File.separator+"DAnkiMG"+File.separator+"collection.anki2","","");
                try(Connection con = sql2o.open()) {
                    label=con.createQuery("select * from notes;").executeAndFetchTable().rows();
                }
            for(int i=0;i<label.size();i++){
                DankiMG.add(label.get(i).getObject("tags").toString());
            }
                return DankiMG;
            }   catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo collection"),e);
            return null;
        }
    }
}
