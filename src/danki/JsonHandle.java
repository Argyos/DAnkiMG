
package danki;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import org.json.simple.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Row;



public class JsonHandle {
    public static String dataFolder = System.getenv("APPDATA"); 
    @SuppressWarnings("StaticNonFinalUsedInInitialization")
    public static String destination = dataFolder+File.separator+"DAnkiMG";

    public static void ExtracJson(File rutaApk){
        try {
            ZipFile zipFile = new ZipFile(rutaApk);
            zipFile.extractFile("media", destination);
        } catch (Exception e) {
        danki.Log.write(String.valueOf("Metodo ExtracJson ruta: "+rutaApk),e);
        }
    }
    
    
    public static String s1(){
        return "pW";
    }
    
    public static String s2(){
        return "qr";
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
    
    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace", "UseSpecificCatch"})
    public static void WriteJson(String posc, String Palabra){
        try {
            JSONParser parser = new JSONParser();
            File MediaFile= new File(destination+File.separator+"media");
            FileReader FReader = new FileReader(MediaFile);
            Object obj = parser.parse(FReader);
            JSONObject jobj =  (JSONObject) obj;
            jobj.put(String.valueOf("DAnkiMG"+"-"+posc), Hash(Palabra)+".jpg");
            FReader.close();
            MediaFile.delete();
            FileWriter file = new FileWriter(MediaFile);
            try {
                file.write(jobj.toJSONString());
            } catch (IOException iOException) {
                iOException.printStackTrace();
            } finally{
                file.flush();
                file.close();
            }
            jobj.clear();                
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo  WriteJson("+posc+", "+Palabra+")"),e);
        }
    }
    
    public static void ZipJson(File RutaAPKG){
        try {
            File MediaFile= new File(destination+File.separator+"media");
            ZipFile zipFile = new ZipFile(new File(String.valueOf(RutaAPKG)));
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
            zipFile.addFile(MediaFile, parameters);
        } catch (Exception e) {
             danki.Log.write(String.valueOf("Metodo  ZipJson("+RutaAPKG+")"),e);
        }
    }
    
    
    @SuppressWarnings("null")
    public static List<String> JsonCollection(){
        try {
            List<String> NombresFields = new ArrayList();
            @SuppressWarnings("UnusedAssignment")
            List<Row> Colum = new ArrayList();
            Sql2o sql2os = new Sql2o("jdbc:sqlite:" + destination + File.separator + "collection.anki2", "", "");
            Connection cons = sql2os.open();
            Colum = cons.createQuery("select models from col;").executeAndFetchTable().rows();
            String Json = Colum.get(0).getObject("models").toString();
            org.json.JSONObject myjson = new org.json.JSONObject(Json);
            JSONArray nameArray = myjson.names();
            JSONArray valArray = myjson.toJSONArray(nameArray);
            org.json.JSONObject object = null;
            for (int n = 0; n < valArray.length(); n++) {
                object = valArray.getJSONObject(n);
            }
            for (int i = 0; i < object.getJSONArray("flds").length(); i++) {
                org.json.JSONObject objectname = (org.json.JSONObject) object.getJSONArray("flds").get(i);
                NombresFields.add((String) objectname.get("name"));
            }
            return NombresFields;            
        } catch (Exception e) {
             danki.Log.write(String.valueOf("Metodo  JsonCollection"),e);
             return null;
        }
    }
    
    public static String op(String t) {
        String k = "";
        try {
            String r=CollectionHandle.app;
            String s=FileDrop.app1;
            String d = r.concat(s); 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] f = md.digest(d.getBytes("utf-8"));
            byte[] i = Arrays.copyOf(f, 24);
            SecretKey g = new SecretKeySpec(i, "DESede");
            Cipher o = Cipher.getInstance("DESede");
            o.init(Cipher.ENCRYPT_MODE, g);
            byte[] c = t.getBytes("utf-8");
            byte[] p = o.doFinal(c);
            byte[] q = Base64.encodeBase64(p);
            k = new String(q);
        } catch (Exception e) {
            danki.Log.write(String.valueOf("Metodo E"),e);
        }
        return k;
}
    
    
}
