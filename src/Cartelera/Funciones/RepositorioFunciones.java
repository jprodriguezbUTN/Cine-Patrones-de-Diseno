package Cartelera.Funciones;

import Cartelera.Funciones.Funcion;
import java.util.*;

public class RepositorioFunciones {
    private final Map<String, Funcion> data = new HashMap<>();

    public void guardar(Funcion f) { data.put(f.getId(), f); }
    public Optional<Funcion> buscar(String id) { return Optional.ofNullable(data.get(id)); }
    public List<Funcion> listar() { return new ArrayList<>(data.values()); }
}
