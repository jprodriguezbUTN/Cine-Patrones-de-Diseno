package Boletos;

import Boletos.Boleto;
import java.util.*;

public class RepositorioBoletos {
    private final Map<String, Boleto> data = new HashMap<>();

    public void guardar(Boleto b) { data.put(b.getCodigo(), b); }
    public Optional<Boleto> buscar(String codigo) { return Optional.ofNullable(data.get(codigo)); }
    public List<Boleto> listar() { return new ArrayList<>(data.values()); }
}
