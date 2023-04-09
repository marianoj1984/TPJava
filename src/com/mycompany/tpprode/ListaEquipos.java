/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpprode;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Onna
 */
public class ListaEquipos {
    private String nombreArchivo;
    private ArrayList<Equipo> listaE;

    public ListaEquipos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.cargarDeArchivo();
    }

    public ListaEquipos() {
        this.nombreArchivo="equipos.Csv";
        this.listaE=new ArrayList<Equipo>();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Equipo> getListaE() {
        return this.listaE;
    }

    public void setListaE(ArrayList<Equipo> listaE) {
        this.listaE = listaE;
    }
    
    public void addEquipo(Equipo eq){
        this.listaE.add(eq);
    }
    
    public void removeEquipo(Equipo eq){
        this.listaE.remove(eq);
    }
    
    
    public Equipo getEquipo (int idEquipo) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Equipo encontrado = null;
        // Recorro la lista de equipos que está cargada
        for (Equipo eq : this.getListaE()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdEquipo() == idEquipo) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = eq;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el equipo, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }
    
    
    public void cargarDeArchivo(){
       String datosEquipo;
       String vectorEquipo[];
       Equipo equipo;
       int fila=0;
       try{
           Scanner sc = new Scanner(new File(this.nombreArchivo));
           sc.useDelimiter("\n");
                
               while(sc.hasNext()){
               datosEquipo=sc.next();
               fila++;
               if(fila==1){
                   continue;
               }
               vectorEquipo=datosEquipo.split(",");
               int id=Integer.parseInt(vectorEquipo[0]);
               equipo = new Equipo(id,vectorEquipo[1],vectorEquipo[2]);
               this.addEquipo(equipo);
               }
                    
       }
       catch(IOException ex){
           System.out.println("Error al abrir el archivo");
       }
       
    }
    
}
