
package com.mycompany.tpprode;

public class Partido {
    private int idPartido;
    private Equipo equipo1;
    private Equipo equipo2;
    private int goles1;
    private int goles2;

    public Partido(int id, Equipo eq1, Equipo eq2, int goles1, int goles2) {
        this.idPartido=id;
        this.equipo1 = eq1;
        this.equipo2 = eq2;
        this.goles1 = goles1;
        this.goles2 = goles2;
    }

    public Partido() {
        this.idPartido=0;
        this.equipo1 = null;
        this.equipo2 = null;
        this.goles1 = 0;
        this.goles2 = 0;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }
    
    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGoles1() {
        return goles1;
    }

    public void setGoles1(int goles1) {
        this.goles1 = goles1;
    }

    public int getGoles2() {
        return goles2;
    }

    public void setGoles2(int goles2) {
        this.goles2 = goles2;
    }
    public char getResultado(Equipo eq){
        if(this.equipo1==eq){
            if(this.goles1>this.goles2){
                return 'G';
            }else{
                if(this.goles1<this.goles2){
                    return 'P';
                }else{
                    return 'E';
                }
            }
        }else{
            if(this.equipo2==eq){
              if(this.goles1>this.goles2){
                return 'G';
            }else{
                if(this.goles1<this.goles2){
                    return 'P';
                }else{
                    return 'E';
                }
            }  
            }
        }
        return '-';
    }
    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", goles1=" + goles1 + ", goles2=" + goles2 + '}';
    }

    
    
}
