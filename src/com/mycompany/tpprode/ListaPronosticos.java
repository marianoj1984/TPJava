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
public class ListaPronosticos {
    private String nombreArchivo;
    private List<Pronosticos> listaProno;
    private ListaEquipos listaEq;
    private ListaPartidos listaPa;
    private ListaParticipantes listaPart;

    public ListaPronosticos(String nombrePronosticos, String listaEquipos, String listaPartidos, String listaParticipantes) {
        this.nombreArchivo = nombrePronosticos;
        this.listaEq=new ListaEquipos(listaEquipos);
        this.listaEq.cargarDeArchivo();
        this.listaPa=new ListaPartidos(listaPartidos, listaEquipos);
        this.listaPa.cargarDeArchivo();
        this.listaPart= new ListaParticipantes(listaParticipantes);
        this.listaPart.cargarDeArchivo();
        this.listaProno=new ArrayList<>();
        this.cargarDeArchivo();
    }

    public ListaPronosticos() {
        this.nombreArchivo="Pronosticos.csv";
        this.listaProno=new ArrayList<>();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public List<Pronosticos> getListaProno() {
        return listaProno;
    }

    public void setListaProno(List<Pronosticos> listaProno) {
        this.listaProno = listaProno;
    }
    
    public Pronosticos getPronostico (int idPronostico) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Pronosticos encontrado = null;
        // Recorro la lista de equipos que está cargada
        for (Pronosticos pronos : this.listaProno) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (pronos.getIdPronostico() == idPronostico) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = pronos;
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
      String datosPronostico;
      String vectorPronostico[];
      Pronosticos pronostico;
      int fila=0;
       try{
           Scanner sc = new Scanner(new File(this.nombreArchivo));
           sc.useDelimiter("\n");
           while(sc.hasNext()){
               datosPronostico=sc.next();
               vectorPronostico=datosPronostico.split(",");
               if(fila>1){
                   //idPronistico   //id Participante   //idPartico     //idEquipo      //Resultado
                    //Participante part = listaPart.getParticipante(Integer.parseInt(vectorPronostico[1]));
                    Partido partido = listaPa.getPartido(Integer.parseInt(vectorPronostico[2]));
                    Equipo eq = listaEq.getEquipo(Integer.parseInt(vectorPronostico[3]));
                    char resultado=vectorPronostico[4].charAt(0);
                    pronostico = new Pronosticos(Integer.parseInt(vectorPronostico[0]),eq,partido,resultado);
                    this.listaProno.add(pronostico);
               }
               fila++;
           }
       }
       catch(IOException ex){
           System.out.println("Error al abrir el archivo");
       }
    }
    
}
