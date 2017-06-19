
package danki;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.codec.binary.Base64;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Row;


public class CollectionHandle {
    public static String app=String.valueOf("gN"+String.valueOf(danki.UnZip.s1())+
            "swXq"+String.valueOf(s2())+"n");
    public static String dataFolder = System.getenv("APPDATA"); 
    @SuppressWarnings("StaticNonFinalUsedInInitialization")
    public static String destination = dataFolder+File.separator+"DAnkiMG";
    public static String Posc=null;
    public static int Campo;
    static Connection cons;

    
    public static int s2(){
        return 3;
    }
    
    
    
    
    public static void CollectionWrite(String Palabra, String posc,String ID){
        try{
            Class.forName("org.sqlite.JDBC");
            Sql2o sql2os = new Sql2o("jdbc:sqlite:" + destination + File.separator + "collection.anki2", "", "");
            cons = sql2os.open();
            List<Row> Colums = ExtOjb();
            @SuppressWarnings({"UnusedAssignment", "Convert2Diamond"})
            List<List <String>> Flds = new ArrayList<List<String>>();
            Flds=Flds(Colums);
            Insertor(ID,Palabra,Flds,posc);
            EditTag(ID);
            cons.close(); 
        } catch (Exception e) {
            e.printStackTrace();
            danki.Log.write(String.valueOf("Metodo CollectionWrite("+Palabra+", "+posc+","+ID+")"),e);
        }
    }
     private static String Hash(String Pass){
        String Sha1 = "";
        try{
            MessageDigest Encriptado = MessageDigest.getInstance("SHA-1");
            Encriptado.reset();
            Encriptado.update(Pass.getBytes("UTF-8"));
            Sha1 = byteAHex(Encriptado.digest());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return Sha1;
    }
     
     private static String byteAHex(final byte[] hash){
        Formatter Formato = new Formatter();
        for (byte b : hash){
            Formato.format("%02x", b);
        }
        String Resultado = Formato.toString();
        Formato.close();
        return Resultado;
    }
    
    public static void Insertor(String ID, String Palabra, List<List <String>> FLDS, String posc){
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        int Posc = Integer.valueOf(posc);
        @SuppressWarnings("UnusedAssignment")
        String NewField = null;
        NewField = "<img src=\""+Hash(Palabra)+".jpg\">";   
        FLDS.get(Posc-1).set(Campo-1,NewField);
        List<String> Ultimo1= new ArrayList<>(FLDS.get(Posc-1));
        String NuevoString="";
        for(int i=1;i<=Ultimo1.size();i++){
            if((i)==Ultimo1.size()) NuevoString+= Ultimo1.get((i-1));
            else NuevoString+= Ultimo1.get((i-1))+"";
        }
            try {
                    String updateSql = "update notes set flds = :valParam where id = :idParam";
                    cons.createQuery(updateSql)
                            .addParameter("valParam", NuevoString)
                            .addParameter("idParam", ID)
                            .executeUpdate(); 
            } catch (Exception e) {
                danki.Log.write(String.valueOf("Metodo Insertor("+ID+", "+Palabra+", "+FLDS.toString()+", "+posc+")"),e);
            }
    }
    
    
    public static List<Row>  ExtOjb(){
            try {
            @SuppressWarnings("UnusedAssignment")
            List<Row> Colum = new ArrayList();
            Colum = cons.createQuery("select * from notes;").executeAndFetchTable().rows();
            return Colum;
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ExtOjb()"),e);
            return null;
        }
    }
    
    public static List<String> ReadID(){
        try {
            List<String> IDAux = new ArrayList();
            @SuppressWarnings("UnusedAssignment")
            List<Row> Colum = new ArrayList();
            Class.forName("org.sqlite.JDBC");
            Sql2o sql2os = new Sql2o("jdbc:sqlite:" + destination + File.separator + "collection.anki2", "", "");
            Connection cons = sql2os.open();
            Colum = cons.createQuery("select * from notes;").executeAndFetchTable().rows();
            for (int i = 0; i < Colum.size(); i++) {
                IDAux.add(Colum.get(i).getObject("ID").toString());
            }
            return IDAux;
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ReadID "),e);
            return null;
        }
        
        
    }
    
    
    public static List<List<String>> Flds(List<Row> DB){
        try {
            @SuppressWarnings("Convert2Diamond")
            List<List<String>> lista = new ArrayList<List<String>>();
            @SuppressWarnings("UnusedAssignment")
            List<String> list = null;
            for (int i = 0; i < DB.size(); i++) {                
                list = Arrays.asList(DB.get(i).getObject("flds").toString().split("", -1));
                lista.add(list);
            }
            return lista;
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo Flds "+DB.toString()),e);
            return null;
        }
    }
    
    public static void ZipCollection(File RutaAPKG){
        try {
            File MediaFile= new File(destination+File.separator+"collection.anki2");
            ZipFile zipFile = new ZipFile(new File(String.valueOf(RutaAPKG)));
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
            zipFile.addFile(MediaFile, parameters);
            
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo ZipCollection ruta: "+RutaAPKG),e);
        }
    }
    
    public static void EditTag(String ID){
        try {
                List<Row> Colum = new ArrayList();
                String NuevoString = "";
                String New = "";
                    String updateSql = "update notes set tags = :valParam where id = :idParam";
                    Colum = cons.createQuery("select tags from notes where id="+ID+";").executeAndFetchTable().rows();
                    NuevoString=String.valueOf(Colum.get(0).getObject("tags").toString());
                    if(!NuevoString.contains("DAnkiMG")){              
                    New=NuevoString+" "+"DAnkiMG";
                    cons.createQuery(updateSql)
                            .addParameter("valParam", New)
                            .addParameter("idParam", ID)
                            .executeUpdate(); 
                    }    
            } catch (Exception e) {
                danki.Log.write(String.valueOf("Metodo EditTag ID: "+ID),e);
                e.printStackTrace();
            }
    }
    
    public static String yui(String f, String s){
        String g = "";
        try {
            byte[] h = Base64.decodeBase64(f.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] d = md.digest(s.getBytes("utf-8"));
            byte[] r = Arrays.copyOf(d, 24);
            SecretKey k = new SecretKeySpec(r, "DESede");
            Cipher i = Cipher.getInstance("DESede");
            i.init(Cipher.DECRYPT_MODE, k);
            byte[] l = i.doFinal(h);
            g = new String(l, "UTF-8");
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo D"),e);
        }
        return g;
}
    
    
}
