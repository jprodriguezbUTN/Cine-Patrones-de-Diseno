package Boletos;

import Clientes.Cliente;
import Cartelera.Funciones.Funcion;
import Boletos.EstadoBoleto;

import java.math.BigDecimal;

public class Boleto {
    private String codigo;
    private Cliente cliente;
    private Funcion funcion;
    private int asiento;
    private BigDecimal precio;
    private EstadoBoleto estado;

    public Boleto(String codigo, Cliente cliente, Funcion funcion, int asiento, BigDecimal precio) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcion = funcion;
        this.asiento = asiento;
        this.precio = precio;
        this.estado = EstadoBoleto.EMITIDO;
    }

    public String getCodigo() { return codigo; }
    public Cliente getCliente() { return cliente; }
    public Funcion getFuncion() { return funcion; }
    public int getAsiento() { return asiento; }
    public BigDecimal getPrecio() { return precio; }
    public EstadoBoleto getEstado() { return estado; }

    public void anular() { this.estado = EstadoBoleto.ANULADO; }

    @Override
    public String toString() {
        return "Boleto{" +
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente.getNombre() +
                ", pelicula='" + funcion.getPelicula().getTitulo() + '\'' +
                ", sala=" + funcion.getSala().getNumero() +
                ", asiento=" + asiento +
                ", precio=" + precio +
                '}';
    }
}
