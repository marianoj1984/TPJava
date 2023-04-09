package com.mycompany.tpprode;

public class TPProde {

    public static PronosticoDeportivo PRODE;
    public static void main(String[] args) {
        String equipo;
        String participante;
        String partido; 
        String pronostico;
        equipo="C:\\Users\\Onna\\OneDrive\\Documentos\\NetBeansProjects\\TPProde\\src\\com\\mycompany\\tpprode\\equipos.csv";
        partido="C:\\Users\\Onna\\OneDrive\\Documentos\\NetBeansProjects\\TPProde\\src\\com\\mycompany\\tpprode\\partidos.csv";
        participante="C:\\Users\\Onna\\OneDrive\\Documentos\\NetBeansProjects\\TPProde\\src\\com\\mycompany\\tpprode\\participantes.csv";
        pronostico="C:\\Users\\Onna\\OneDrive\\Documentos\\NetBeansProjects\\TPProde\\src\\com\\mycompany\\tpprode\\pronosticos.csv";
        PRODE = new PronosticoDeportivo();
        PRODE.cargarEquipos(equipo);   
        System.out.println ("=== EQUIPOS ===");
        System.out.println (PRODE.listarEquipos());

        System.out.println("*".repeat(40));

        PRODE.cargarParticipantes(participante);   
        System.out.println ("=== PARTICIPANTES ===");
        System.out.println (PRODE.listarParticipantes());
        
        System.out.println("*".repeat(40));

        PRODE.cargarPartidos(partido, equipo);   
        System.out.println ("=== PARTIDOS ===");
        System.out.println (PRODE.listarPartidos());
        
        System.out.println("*".repeat(40));

        PRODE.cargarPronosticos(pronostico, partido, equipo, participante);   
        System.out.println ("=== PRONOSTICO ===");
        System.out.println (PRODE.listarPronosticos());
        
    }
    
}
    
