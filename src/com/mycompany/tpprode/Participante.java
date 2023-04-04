
package com.mycompany.tpprode;

public class Participante {
    private int idParticipante;
    private String nombre;
    private ListaPronosticos listaPronos;
    private int puntos;

    public Participante(int idParticipante, String nombre) {
        this.idParticipante = idParticipante; 
        this.nombre = nombre;
        this.listaPronos = new ListaPronosticos();
        this.puntos = 0;
    }

    Participante() {
       this.idParticipante=0;
       this.nombre=null;
       this.listaPronos=new ListaPronosticos();
       this.puntos=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPronosticos getPronosticos() {
        return this.listaPronos;
    }

    public void setPronosticos(ListaPronosticos listaP) {
        this.listaPronos = listaP;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Participante{" + "idParticipante=" + idParticipante + ", nombre=" + nombre + ", listaPronos=" + listaPronos + ", puntos=" + puntos + '}';
    }

    
        
}
