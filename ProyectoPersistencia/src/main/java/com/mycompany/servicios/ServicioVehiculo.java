/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servicios;

import com.mycompany.model.Vehiculo;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Esteban Aponte
 */

public class ServicioVehiculo {
    
    
    
    public static boolean guardarVehiculos(Vehiculo veh){
        try {
          RandomAccessFile file = new RandomAccessFile( "data//basededatos.txt","rw");
          file.seek(file.length());
          file.writeInt(veh.getModelo());
          file.writeUTF(veh.getPlaca());
          file.writeDouble(veh.getPrecio());
          file.writeBoolean(veh.isNuevo());
          file.writeUTF(formatString(veh.getEstado(), Vehiculo.TAM_ESTADO));
        } catch (Exception e) {
            return false;
        }
        return true ;   
    
    }
        public static List getVehiculo()
    {
        List <Vehiculo> vehiculos = new ArrayList();
        int modelo;
        String placa;
        double precio;
        boolean nuevo;
        String estado;
        
        Vehiculo veh = null;
        
        try {
            RandomAccessFile file = new RandomAccessFile( "data//basededatos.txt","rw");
            file.seek(0);
            
            while(file.getFilePointer() < file.length()){
                
                modelo = file.readInt();
                placa = file.readUTF();
                precio = file.readDouble();
                nuevo = file.readBoolean();
                estado= file.readUTF();
                
                veh = new Vehiculo(modelo, placa, precio, nuevo, estado);
                vehiculos.add(veh);
            }
            file.close();
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return vehiculos;
    }
    public static Vehiculo buscarVehiculo(String PLACA)// NICOLAS Y JUAN NI PIENSEN EN TOCAR ESTO 
    {
        
        int modelo;
        String placa;
        double precio;
        boolean nuevo;
        String estado;
        
        
        try {
            RandomAccessFile file = new RandomAccessFile( "data\\basededatos.txt","rw");
            
            
            
            while(file.getFilePointer() < file.length()){
                modelo = file.readInt();
                placa = file.readUTF();
                precio = file.readDouble();
                nuevo = file.readBoolean();
                estado= file.readUTF();
                
                if(PLACA.equals(placa))
                {
                    file.close();
                    return new Vehiculo(modelo, PLACA, precio, nuevo, estado);
                }
            }
            file.close();
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        return null;
    }
    public static  Vehiculo Actualizar(double Precio,boolean Nuevo,String PLACA)// SI ESTO SE CAE YO CAI EN CON EL 
    {
        int modelo; // fijo
        String placa; // fijo e identificador
        double precio; // cambiante
        boolean nuevo; // cambiante
        String estado; // cambiante pero aun no vamos lucas  
        
    try {
          RandomAccessFile file = new RandomAccessFile( "data//basededatos.txt","rw");
          while ( file.getFilePointer() < file.length()){
          
          modelo= file.readInt();
          placa = file.readUTF();
          precio= file.readDouble();
          nuevo=file.readBoolean();
          estado=file.readUTF();
          
          if(PLACA.equals(placa)){
              file.seek(file.getFilePointer()-26);
              file.writeDouble(Precio);
              file.writeBoolean(Nuevo);
              
          }
          }
          file.close();
        } catch (Exception e) {
                
        }
        return null ;   
    
    }

public static String formatString(String cad, int tam) {
        if (cad.length() < tam) {
            cad = cad + " ".repeat(tam - cad.length());
        } else {
            cad = cad.substring(0, tam);
        }

        return cad;
    }    
    public static  Vehiculo CambioEstado(String PLACA,String estadoACTUAL)// SI ESTO SE CAE YO CAI EN CON EL 
    {
        int modelo; // fijo
        String placa; // fijo e identificador
        double precio; // cambiante
        boolean nuevo; // cambiante
        String estado; // cambiante pero aun no vamos lucas  
        
        
        
    try {
          RandomAccessFile file = new RandomAccessFile( "data//basededatos.txt","rw");
          while ( file.getFilePointer() < file.length()){
          
          modelo= file.readInt();
          placa = file.readUTF();
          precio= file.readDouble();
          nuevo=file.readBoolean();
          estado=file.readUTF();
          
          if(PLACA.trim().equals(placa.trim())){
              file.seek(file.getFilePointer()-17);
              if(estado.trim().equals("Disponible"))
              {
             file.writeUTF(formatString("No Disponible", Vehiculo.TAM_ESTADO));
             
              
              }
              else{
                  file.writeUTF(formatString("Disponible", Vehiculo.TAM_ESTADO));
            
              }
              
          }
          }
     
        } catch (Exception e)    {
                
        }
        return null ;   
    }
    public static double SumaPrecios(){
        double suma =0;
        int cantidad = 0;
        
        try {
            RandomAccessFile file = new RandomAccessFile( "data//basededatos.txt","rw");
            
            while ( file.getFilePointer() < file.length()){
          
                
          int modelo= file.readInt();
          String placa = file.readUTF();
          double precio= file.readDouble();
          boolean nuevo=file.readBoolean();
          String estado=file.readUTF();
          
        
          
          // if (estado.trim().equals("Disponible")) un if de disponibilidad
            
          suma +=precio;
            
            
            }
         file.close();

        } catch (Exception e) {
        }
        
        
        return suma;
        
    }
}
