/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.unlam.programacion.avanzada.documentos;

import ar.unlam.programacion.avanzada.billeteraImpl.Billetera;
import ar.unlam.programacion.avanzada.billeteraImpl.Movimiento;
import ar.unlam.programacion.avanzada.model.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
               fichero.flush();
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
         
        List<Movimiento> movimientos = new ArrayList<Movimiento>();
        String[] movimiento = null;
        Date fecha = null; 
        String montoDisponible = null;
         while((linea=br.readLine())!=null) {
             movimiento = linea.split("-");
             Float monto = Float.valueOf(movimiento[0]);
             String tipoMovimiento = movimiento[1];
             String descripcion = movimiento[2];
             String medioPago = movimiento[3];
             fecha = Util.formatearFecha(movimiento[4]); 
             if(movimiento[5] != null)
                 montoDisponible = movimiento[5]; 
             Movimiento mov = new Movimiento(monto.floatValue(), tipoMovimiento, descripcion, medioPago, fecha);
             movimientos.add(mov);
         }
         if(montoDisponible == null)
            billetera.setMontoTotalDineroDisponible(Float.valueOf(datosUsuario[5]));
         else
             billetera.setMontoTotalDineroDisponible(Float.valueOf(montoDisponible));
         billetera.setMovimientos(movimientos);
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
   
   public static Date formatearFecha(String fecha) {
          SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy"); 
           Date date = null;
            try {
                date = dt.parse(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, "Formato de fecha erroneo", ex);
            }
           return date;
   }
   
    public  static boolean escribirDatosMovimientos(String dni, String monto, String movimiento, String descripcion, String medioDePago, Date fecha, String montoDisponible)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            String rutaArchivo = "E:/infoUsuarios" + dni + ".txt";
            File af = new File(rutaArchivo);
        
            fichero = new FileWriter(rutaArchivo, true);
            pw = new PrintWriter(fichero);
            pw.println();
            pw.print(monto + "-");
            pw.print(movimiento + "-");
            pw.print(descripcion + "-");
            pw.print(medioDePago + "-");
            SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy"); 
            pw.print(dt.format(fecha) + "-");
            pw.print(montoDisponible);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
               fichero.flush();
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
         return true;
    }

}
