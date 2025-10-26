package Facturacion;

import Boletos.Boleto;
import Clientes.Cliente;
import Facturacion.Factura;
import Facturacion.RepositorioFacturas;

public class ServicioFacturacion {
    private final RepositorioFacturas repo;

    public ServicioFacturacion(RepositorioFacturas repo) { this.repo = repo; }

    public Factura generarFactura(String numero, Cliente cliente, Boleto boleto) {
        Factura f = new Factura(numero, cliente, boleto);
        repo.guardar(f);
        return f;
    }
}
