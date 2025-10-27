package Facturacion;

import Clientes.Cliente;
import Boletos.Boleto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Factura {
    private String numero;
    private Cliente cliente;
    private Boleto boleto;
    private LocalDateTime fecha;

    public Factura(String numero, Cliente cliente, Boleto boleto) {
        this.numero = numero;
        this.cliente = cliente;
        this.boleto = boleto;
        this.fecha = LocalDateTime.now();
    }

    public String getNumero() { return numero; }
    public Cliente getCliente() { return cliente; }
    public Boleto getBoleto() { return boleto; }
    public LocalDateTime getFecha() { return fecha; }

    public BigDecimal getTotal() { return boleto.getPrecio(); }

    @Override
    public String toString() {
        return "Factura{" +
                "numero='" + numero + '\'' +
                ", cliente='" + cliente.getNombre() + '\'' +
                ", total=" + getTotal() +
                '}';
    }
}
