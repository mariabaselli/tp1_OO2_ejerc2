package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest {

    ItemMenu unaBebida;
    ItemMenu unPlato;
    Mesa unaMesa;


    @BeforeEach
    void inicializarVariables() {
        unaBebida = new ItemMenu(2f, "Coca Cola");
        unPlato = new ItemMenu(10f, "Pizza");
        unaMesa = Mesa.crearMesa(1);
        unaMesa.agregarBebida(unaBebida, 1);
        unaMesa.agregarPlato(unPlato, 1);
    }

    @Test
    void realizarPedido() {
        assertEquals(2, unaMesa.cantidadBebidas() + unaMesa.cantidadPlatos());
    }

    @Test
    public void calcularCostoVisa() {
        Tarjeta unaTarjeta = new Visa();
        assertEquals(12.178801F, unaMesa.cerrarMesa(unaTarjeta, 2));
    }

    @Test
    public void calcularCostoMastercard() {
        Tarjeta unaTarjeta = new Mastercard();
        assertEquals(12.154F, unaMesa.cerrarMesa(unaTarjeta, 3));
    }

    @Test
    public void calcularComarcaPlus() {
        Tarjeta unaTarjeta = new ComarcaPlus();
        assertEquals(12.348F, unaMesa.cerrarMesa(unaTarjeta, 5));
    }

    @Test
    public void calcularTarjetaViedma() {
        Tarjeta unaTarjeta = new Viedma();
        assertEquals(12.599999F, unaMesa.cerrarMesa(unaTarjeta, 5));
    }


}
