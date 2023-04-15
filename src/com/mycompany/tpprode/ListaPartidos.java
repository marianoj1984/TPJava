/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpprode;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Onna
 */
public class ListaPartidos {
    private String nombreArchivo;
    private List<Partido> listaP;
    private ListaEquipos listaEq;

    public ListaPartidos(String listaPartidos, String listaEquipos) {
        this.nombreArchivo = listaPartidos;
        this.listaEq=new ListaEquipos(listaEquipos);
        this.listaEq.cargarDeArchivo();
        this.listaP=new ArrayList<>();
        this.cargarDeArchivo();
        
    }

    public ListaPartidos() {
        this.nombreArchivo="Partidos.csv";
        this.listaP=new ArrayList<>();   
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public List<Partido> getListaP() {
        return listaP;
    }

    public void setListaP(List<Partido> listaP) {
        this.listaP = listaP;
    }
    public Partido getPartido (int idPartido) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Partido encontrado = null;
        // Recorro la lista de equipos que está cargada
        for (Partido p : this.listaP) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (p.getIdPartido() == idPartido) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = p;
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
       String datosPartido;
       String vectorPartido[];
       Partido partido;
       int fila=0;
       try{
           Scanner sc = new Scanner(new File(this.nombreArchivo));
           sc.useDelimiter("\n");
           while(sc.hasNext()){
               datosPartido=sc.next();
               vectorPartido=datosPartido.split(",");
               if(fila>1){
                    Equipo equipo1, equipo2;
                    equipo1=listaEq.getEquipo(Integer.parseInt(vectorPartido[1]));
                    equipo2=listaEq.getEquipo(Integer.parseInt(vectorPartido[2]));
                    partido = new Partido(Integer.parseInt(vectorPartido[0]), equipo1, equipo2,Integer.parseInt(vectorPartido[3]), Integer.parseInt(vectorPartido[4]));
                    this.listaP.add(partido);
               }
               fila++;
           }
       }
       catch(IOException ex){
           System.out.println("Error al abrir el archivo");
       }
    }
    
}
