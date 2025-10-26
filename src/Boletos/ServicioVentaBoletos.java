package Boletos;

import Boletos.RepositorioBoletos;
import Cartelera.Funciones.RepositorioFunciones;
import Boletos.Boleto;
import Clientes.Cliente;
import Cartelera.Funciones.Funcion;

import java.math.BigDecimal;

public class ServicioVentaBoletos {
    private final RepositorioFunciones repoFun;
    private final RepositorioBoletos repoBol;

    public ServicioVentaBoletos(RepositorioFunciones repoFun, RepositorioBoletos repoBol) {
        this.repoFun = repoFun;
        this.repoBol = repoBol;
    }

    public Boleto venderBoleto(String codigo, Cliente cliente, String idFuncion, int asiento, BigDecimal precio) {
        Funcion f = repoFun.buscar(idFuncion).orElseThrow(() -> new IllegalArgumentException("Función no existe"));
        f.ocuparAsiento();
        Boleto b = new Boleto(codigo, cliente, f, asiento, precio);
        repoBol.guardar(b);
        return b;
    }
}
