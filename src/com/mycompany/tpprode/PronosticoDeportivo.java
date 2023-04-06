package com.mycompany.tpprode;

import java.util.Random;

public class PronosticoDeportivo {
    private ListaParticipantes participantes;
    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaPronosticos pronosticos;

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
    
    
    public ListaEquipos cargarEquipos(String archi) {
        
        /*String[] equipo_nombres = {
        "Boca Juniors","River Plate","Racing Club",
        "Velez Sarsfield", "Rosario Central", "Huracan",
        "Belgrano", "Talleres", "Independiente", "Aldosivi",
        "Estudiantes de La Plata", "Quilmes", "Nueva Chicago",
        "Almirante Brown", "Arsenal", "San Lorenzo", "Colón de Santa Fé"};

        int cant_equipos = equipo_nombres.length;
        equipos = new Equipo[cant_equipos];
        
        for (int i=0; i<cant_equipos; i++) {
            equipos[i] = new Equipo (equipo_nombres[i],"");
        }
        return equipos;*/
        this.equipos=new ListaEquipos(archi);
        return this.equipos;
    }
    
    public String listarEquipos() {
        String res="";
        for (Equipo equipo : this.equipos.getListaE()) {
            res += equipo.toString()+"\n";
            
        }
        return res;
    }
    
    public ListaParticipantes cargarParticipantes(String archi) {
        /*String[] nombres = 
            {"Aimar Arias","Judith Jaen","Macarena Borras","Esther Portela",
            "Jamal Barba","Flora Melero","Gustavo Bueno","Liliana Mateu",
            "Lucia Roldan","Alonso Andreu"};
        int cant = nombres.length;
        participantes = new Participante[cant];
        
        for (int i=0; i<cant; i++) {
            Participante p = new Participante ();
            p.setNombre(nombres[i]);
            participantes[i] = p;
        }
        return participantes; */
        this.participantes=new ListaParticipantes(archi);
        return this.participantes;    
    }
    
    public String listarParticipantes() {
        String res="";
        for (Participante p : this.participantes.getListaPart()) {
            res += p.toString()+"\n";
        }
        return res;
    }
    
    public ListaPartidos cargarPartidos(String archiPartido, String archiEquipo) {
        /*Random rnd = new Random();
        Equipo eq1, eq2;
        int goles1, goles2;
        
        // Si en cada partido juegan 2 equipos la cantidad
        // máxima de partidos es la cantidad de equipos / 2
        // creo un vector de ese tamaño y lo asigno a atributo partidos
        this.partidos = new Partido[(this.getEquipos().length/2)];
        // Ahora hay que cargar los partidos en el vector, creándolos de a uno
        int p_i = 0; // Esta variable se utiliza solamente para acceder al arreglo de partidos
        for (int i=0; i<this.getEquipos().length-2; i += 2) {   // el contador avanza de a dos
            eq1 = this.getEquipos()[i];
            eq2 = this.getEquipos()[i+1]; // el siguiente
            goles1 = rnd.nextInt(3);
            goles2 = rnd.nextInt(3);
            Partido p = new Partido(eq1,eq2,goles1,goles2);
            this.partidos[p_i] = p;
            p_i++;
        }
        return this.partidos;*/
        this.partidos=new ListaPartidos(archiPartido, archiEquipo);
        return this.partidos;
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
        /*Random rnd = new Random();
        // Recorrer la lista de Participantes
        for (int participante = 0; participante<this.getParticipantes().length; participante++) {
            // Crear un vector que contenga todos los pronosticos posibles (1 por cada partido)
            // para cargarlo y luego asignarlo a cada participante
            Pronosticos[] prons = prons = new Pronosticos[this.getPartidos().length];
            
            // Para cada participante recorrer la lista de partidos
            for (int partido=0; partido<this.getPartidos().length; partido++) {
                // Para cada partido generar un pronóstico
                int equipoRnd = rnd.nextInt(1); // Equipo 0 o 1
                Equipo equipoApuesta;
                switch (equipoRnd) {
                    case 0 : equipoApuesta = this.getPartidos()[partido].getEquipo1(); break;
                    default : equipoApuesta = this.getPartidos()[partido].getEquipo2(); break;
                }
                int resultadoRnd = rnd.nextInt(2); // Apuesta 0, 1 o 2
                char resultadoApuesta;
                switch (resultadoRnd) {
                    case 0 : resultadoApuesta = 'G'; break;
                    case 1 : resultadoApuesta = 'P'; break;
                    default : resultadoApuesta = 'E'; break;
                }
                
                // Crear el pronostico
                Pronosticos pron = new Pronosticos(
                        equipoApuesta,                  // El equipo
                        this.getPartidos()[partido],    // El partido
                        resultadoApuesta                // El resultado
                );
                // Cargar el pronóstico en el array de pronósticos
                prons[partido] = pron;
            }
            // Cuando terminé los pronósticos de cada partido
            // Asignarlos al participante
            this.participantes[participante].setPronosticos(prons);
        }*/
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

