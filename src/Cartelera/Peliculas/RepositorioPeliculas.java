package Cartelera.Peliculas;

import Cartelera.Peliculas.Pelicula;
import java.util.*;

public class RepositorioPeliculas {
    private final Map<String, Pelicula> data = new HashMap<>();

    public void guardar(Pelicula p) { data.put(p.getId(), p); }
    public Optional<Pelicula> buscar(String id) { return Optional.ofNullable(data.get(id)); }
    public List<Pelicula> listar() { return new ArrayList<>(data.values()); }
}
