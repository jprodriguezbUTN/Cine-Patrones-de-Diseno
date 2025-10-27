package Cartelera.Salas;

import Cartelera.Salas.Sala;
import java.util.*;

public class RepositorioSalas {
    private final Map<Integer, Sala> data = new HashMap<>();

    public void guardar(Sala s) { data.put(s.getNumero(), s); }
    public Optional<Sala> buscar(int numero) { return Optional.ofNullable(data.get(numero)); }
    public List<Sala> listar() { return new ArrayList<>(data.values()); }
}
