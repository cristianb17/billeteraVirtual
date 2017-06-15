/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzada.documentos;

import ar.unlam.programacion.avanzada.billeteraImpl.Billetera;
import avanzada.model.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Util {
    
     public  static boolean escribirArchivo(String dni, Usuario usuario)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            String rutaArchivo = "E:/infoUsuarios" + dni + ".txt";
            File af = new File(rutaArchivo);
            
            if (af.exists()) { 
                JOptionPane.showMessageDialog(null, "usuario existente");
                return false;
            }
            fichero = new FileWriter(rutaArchivo);
            pw = new PrintWriter(fichero);
            pw.print(usuario.getNombre() + "-");
            pw.print(usuario.getApellido()+ "-");
            pw.print(usuario.getCiudad()+ "-");
            pw.print(String.valueOf(usuario.getDni())+ "-");
            pw.print(String.valueOf(usuario.getPassword())+ "-");
            pw.print(usuario.getBilletera().obtenerDineroDisponible());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
         return true;
    }
     
   public static Usuario leerArchivo(String dni, Usuario usuario) throws IOException {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         archivo = new File ("E:\\infoUsuarios" + dni + ".txt");
         if(!archivo.exists()) {
             return null;
         }
        
        fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         String[] datosUsuario = null;
         if((linea=br.readLine())!=null) {
            datosUsuario = linea.split("-");
        }
         
         Billetera billetera = new Billetera();
         usuario.setNombre(datosUsuario[0]);
         usuario.setApellido(datosUsuario[1]);
         usuario.setCiudad(datosUsuario[2]);
         usuario.setDni(Long.valueOf(datosUsuario[3]));
         usuario.setPassword(datosUsuario[4]);
         billetera.setMontoTotalDineroDisponible(Float.valueOf(datosUsuario[5]));
         usuario.setBilletera(billetera);
         
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
         return usuario;
   }

}
