package Cartelera;

import Cartelera.Funciones.RepositorioFunciones;
import Cartelera.Salas.RepositorioSalas;
import Cartelera.Peliculas.RepositorioPeliculas;
import Cartelera.Peliculas.Pelicula;
import Cartelera.Salas.Sala;
import Cartelera.Funciones.Funcion;
import Cartelera.Funciones.EstadoFuncion;

import java.time.LocalDateTime;

public class ServicioCartelera {
    private final RepositorioPeliculas repoPel;
    private final RepositorioSalas repoSal;
    private final RepositorioFunciones repoFun;

    public ServicioCartelera(RepositorioPeliculas repoPel, RepositorioSalas repoSal, RepositorioFunciones repoFun) {
        this.repoPel = repoPel;
        this.repoSal = repoSal;
        this.repoFun = repoFun;
    }

    public Funcion programarFuncion(String idFuncion, String idPelicula, int numSala, LocalDateTime horario) {
        Pelicula p = repoPel.buscar(idPelicula).orElseThrow(() -> new IllegalArgumentException("Película no existe"));
        Sala s = repoSal.buscar(numSala).orElseThrow(() -> new IllegalArgumentException("Sala no existe"));
        Funcion f = new Funcion(idFuncion, p, s, horario);
        f.setEstado(EstadoFuncion.PROGRAMADA);
        repoFun.guardar(f);
        return f;
    }
}
