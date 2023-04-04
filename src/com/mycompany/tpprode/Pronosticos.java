
package com.mycompany.tpprode;

public class Pronosticos {
 private int idPronostico;
 private Equipo equipo;
 private Partido partido;
 private char resultado;

    public Pronosticos(int idPronostico, Equipo equipo, Partido partido, char resultado) {
        this.idPronostico = idPronostico;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

    public Pronosticos() {
        this.idPronostico = 0;
        this.equipo = null;
        this.partido = null;
        this.resultado = '.';
    }

    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }
    
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Pronosticos{" + "idPronostico=" + idPronostico + ", equipo=" + equipo + ", partido=" + partido + ", resultado=" + resultado + '}';
    }

    
 
}
