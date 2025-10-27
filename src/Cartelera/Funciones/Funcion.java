package Cartelera.Funciones;

import Cartelera.Peliculas.Pelicula;
import Cartelera.Salas.Sala;
import Cartelera.Funciones.EstadoFuncion;

import java.time.LocalDateTime;

public class Funcion {
    private String id;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDateTime horario;
    private int asientosDisponibles;
    private EstadoFuncion estado;

    public Funcion(String id, Pelicula pelicula, Sala sala, LocalDateTime horario) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
        this.asientosDisponibles = sala.getCapacidad();
        this.estado = EstadoFuncion.PROGRAMADA;
    }

    public String getId() { return id; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public LocalDateTime getHorario() { return horario; }
    public int getAsientosDisponibles() { return asientosDisponibles; }
    public EstadoFuncion getEstado() { return estado; }

    public void ocuparAsiento() {
        if (asientosDisponibles <= 0) throw new IllegalStateException("No hay asientos disponibles");
        asientosDisponibles--;
    }

    public void setEstado(EstadoFuncion estado) { this.estado = estado; }
}
