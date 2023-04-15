package com.mycompany.tpprode;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class PronosticoDeportivo {
    private ListaParticipantes participantes;
    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaPronosticos pronosticos;

    public PronosticoDeportivo() {
        this.participantes=null;
        this.equipos=null;
        this.partidos=null;
        this.pronosticos=null;
    }
 
    public ListaParticipantes getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ListaParticipantes participantes) {
        this.participantes = participantes;
    }

    public ListaEquipos getEquipos() {
        return equipos;
    }

    public void setEquipos(ListaEquipos equipos) {
        this.equipos = equipos;
    }

    public ListaPartidos getPartidos() {
        return partidos;
    }

    public void setPartidos(ListaPartidos partidos) {
        this.partidos = partidos;
    }

    public ListaPronosticos getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ListaPronosticos pronosticos) {
        this.pronosticos = pronosticos;
    }
    
    
    public void cargarEquipos(String archi) {
        this.equipos=new ListaEquipos(archi);
    }
    
    public String listarEquipos() {
        String res="";
        for (Equipo eq : this.equipos.getListaE()) {
            res += eq.toString()+"\n";    
        }
        return res;
    }
    
    public void cargarParticipantes(String archi) {
        this.participantes=new ListaParticipantes(archi);   
    }
    
    public String listarParticipantes() {
        String res="";
        for (Participante p : this.participantes.getListaPart()) {
            res += p.toString()+"\n";
        }
        return res;
    }
    
    public void cargarPartidos(String archiPartido, String archiEquipo) {

        this.partidos=new ListaPartidos(archiPartido, archiEquipo);
    }
    
    public String listarPartidos() {
        String res = "";
        for (Partido p : this.partidos.getListaP()) {
            res += p.toString()+"\n";
        }
        return res;
    }
    
    // El participante apuesta a TODOS los partidos
    public void cargarPronosticos(String archiPronostico, String archiEquipos, String archiPartido, String archiParticipante) {
        this.pronosticos=new ListaPronosticos(archiPronostico, archiEquipos, archiPartido, archiParticipante);
        this.pronosticos.cargarDeArchivo();
        
    }
    
    public String listarPronosticos() {
        String res = "";
        for (Pronosticos p : this.pronosticos.getListaProno()) {
            
            res += "- - - - - - - - - - - - - - - - - -\n";
        }
        return res;
    }

    
}

