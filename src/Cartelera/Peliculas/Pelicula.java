package Cartelera.Peliculas;

import Cartelera.Peliculas.Clasificacion;

public class Pelicula {
    private String id;
    private String titulo;
    private int duracionMin;
    private Clasificacion clasificacion;

    public Pelicula(String id, String titulo, int duracionMin, Clasificacion clasificacion) {
        this.id = id;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.clasificacion = clasificacion;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getDuracionMin() { return duracionMin; }
    public Clasificacion getClasificacion() { return clasificacion; }

    @Override
    public String toString() {
        return titulo + " (" + clasificacion + ")";
    }
}
