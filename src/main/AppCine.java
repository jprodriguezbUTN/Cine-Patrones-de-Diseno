package main;

import Facturacion.ServicioFacturacion;
import Boletos.ServicioVentaBoletos;
import Cartelera.ServicioCartelera;
import Facturacion.RepositorioFacturas;
import Boletos.RepositorioBoletos;
import Cartelera.Funciones.RepositorioFunciones;
import Cartelera.Salas.RepositorioSalas;
import Cartelera.Peliculas.RepositorioPeliculas;
import Clientes.Cliente;
import Cartelera.Peliculas.Pelicula;
import Cartelera.Salas.Sala;
import Cartelera.Peliculas.Clasificacion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AppCine {
    public static void main(String[] args) {
        // Repos
        RepositorioPeliculas repoPel = new RepositorioPeliculas();
        RepositorioSalas repoSal = new RepositorioSalas();
        RepositorioFunciones repoFun = new RepositorioFunciones();
        RepositorioBoletos repoBol = new RepositorioBoletos();
        RepositorioFacturas repoFac = new RepositorioFacturas();

        // Datos base
        repoPel.guardar(new Pelicula("P-1", "Interstellar", 169, Clasificacion.PG13));
        repoSal.guardar(new Sala(1, 5));

        // Servicios
        ServicioCartelera srvCar = new ServicioCartelera(repoPel, repoSal, repoFun);
        ServicioVentaBoletos srvVen = new ServicioVentaBoletos(repoFun, repoBol);
        ServicioFacturacion srvFac = new ServicioFacturacion(repoFac);

        // Flujo
        var funcion = srvCar.programarFuncion("F-1", "P-1", 1, LocalDateTime.now().plusHours(2));
        var cliente = new Cliente("C-1", "Juan Pérez", "juan@correo.com");
        var boleto = srvVen.venderBoleto("B-100", cliente, funcion.getId(), 3, new BigDecimal("4500"));
        var factura = srvFac.generarFactura("F-9001", cliente, boleto);

        System.out.println("Boleto: " + boleto);
        System.out.println("Factura: " + factura);
    }
}
