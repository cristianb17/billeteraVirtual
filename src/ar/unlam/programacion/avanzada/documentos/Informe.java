package ar.unlam.programacion.avanzada.documentos;

import ar.unlam.programacion.avanzada.billeteraImpl.Movimiento;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Informe {
        public  static boolean escribirDatosMovimientos(String dni, List<Movimiento> listaMovimientos)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy"); 
            String rutaArchivo = "/movimientos_" + dni + "_" + dt.format(new Date())+ ".txt";
            File af = new File(rutaArchivo);
        
            fichero = new FileWriter(rutaArchivo);
            pw = new PrintWriter(fichero);
            for(Movimiento mov : listaMovimientos) {
                pw.print("**************************************************************");
                pw.println();
                pw.print("[Tipo Movimiento : " + mov.getMovimiento() + "]");
                pw.println();
                pw.print("[Monto : " + mov.getMonto() + "]");
                pw.println();
                pw.print("[Medio de Pago : " + mov.getMedioDePago() + "]");
                pw.println();
                pw.print("[Descripcion : " + mov.getDescripcion() + "]");
                pw.println();
                pw.print("[Fecha de Movimiento : " + dt.format(mov.getFecha()) + "]");
                pw.println();
                pw.print("**************************************************************");
                pw.println();
            }
            
         
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
