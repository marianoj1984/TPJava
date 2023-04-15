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
public class ListaParticipantes {
    private String nombreArchivo;
    private List<Participante> listaPart;

    public ListaParticipantes(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.listaPart=new ArrayList<>();
        this.cargarDeArchivo();
    }

    public ListaParticipantes() {
        this.nombreArchivo="Participantes.csv";
        this.listaPart=new ArrayList<>();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public List<Participante> getListaPart() {
        return listaPart;
    }

    public void setListaPart(List<Participante> listaPart) {
        this.listaPart = listaPart;
    }
    
    public Participante getParticipante (int idParticipante) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Participante encontrado = null;
        // Recorro la lista de equipos que está cargada
        for (Participante part : this.listaPart) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (part.getIdParticipante() == idParticipante) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = part;
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
       String datosParticipante;
       String vectorParticipante[];
       Participante participante;
       int fila=0;
       try{
           Scanner sc = new Scanner(new File(this.nombreArchivo));
           sc.useDelimiter("\n");
           while(sc.hasNext()){
    
               datosParticipante=sc.next();             
               vectorParticipante=datosParticipante.split(",");
               
               if(fila>1){
                    int id=Integer.parseInt(vectorParticipante[0]);
                    String nombre=vectorParticipante[1];
                    participante = new Participante(id,nombre);
                    this.listaPart.add(participante);
               }
               fila++;
               }
        }
       catch(IOException ex){
           System.out.println("Error al abrir el archivo");
       }
    }
    
}
