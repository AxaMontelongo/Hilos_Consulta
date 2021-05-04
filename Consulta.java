package consultaHilos;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Consulta extends Thread{ // indicamos que es un hilo

    public BufferedReader lectorA; //Lector del archivo
    public String linea; // recibe cada linea del archivo
    public String [] partes = null; //Sirve como almacen de cada linea que tiene el archivo

    //metodo para obtener y leer el archivo csv

    public void LeerA(String nombreA){ //el metodo recibe la ruta del archivo no el nombre

        JOptionPane.showMessageDialog(null,
                "Despues de este mensaje tardara 5 segundos en aparecer la informacion");
        try {
            Thread.sleep(5000); // metodo para dormir el hilo durante 5000 milesegundos equivalente a 5 segundos

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
                lectorA = new BufferedReader(new FileReader(nombreA)); // metodo para la lectura del archivo
                while ((linea = lectorA.readLine())!=null){
                    partes = linea.split(" , "); // relleno de la informacion del archivo
                    imprimir();
                    System.out.println();
                }
                lectorA.close();
                linea=null;
                partes=null;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e); // mensaje de error
        }
    }
    public void imprimir(){

                System.out.println(Arrays.toString(partes) );
    }
}
