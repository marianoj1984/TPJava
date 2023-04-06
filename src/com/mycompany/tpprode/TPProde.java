package com.mycompany.tpprode;

public class TPProde {

    public static PronosticoDeportivo PRODE;
    public static void main(String[] args) {
        
        PRODE = new PronosticoDeportivo();
        PRODE.cargarEquipos("equipos.csv");   
        System.out.println ("=== EQUIPOS ===");
        System.out.println (PRODE.listarEquipos());

        System.out.println("*".repeat(40));

        PRODE.cargarParticipantes("participantes.csv");   
        System.out.println ("=== PARTICIPANTES ===");
        System.out.println (PRODE.listarParticipantes());
        
        System.out.println("*".repeat(40));

        PRODE.cargarPartidos("partidos.csv", "equipos.csv");   
        System.out.println ("=== PARTIDOS ===");
        System.out.println (PRODE.listarPartidos());
        
        System.out.println("*".repeat(40));

        PRODE.cargarPronosticos("pronostico.csv", "partidos.csv", "equipos,csv", "participantes.csv");   
        System.out.println ("=== PRONOSTICO ===");
        System.out.println (PRODE.listarPronosticos());
        
    }
    
}
    
