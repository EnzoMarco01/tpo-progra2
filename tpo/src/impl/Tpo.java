package impl;

import impl.Ciudad2NumeroDinamico;
import interfaz.GrafoTDA;
import interfaz.TpoTDA;

public class Tpo implements TpoTDA {

    private Ciudad2NumeroDinamico c2n = new Ciudad2NumeroDinamico();
    private GrafoTDA grafito = new GrafoDinamico();

    public String listarProvincias() {return c2n.devolverProvincias();}

    public String listarCiudades() {
        return c2n.devolverCiudades();
    }

    public void cargarCiudad(String ciudad, String provincia) {
        c2n.agregarCiudadProvincia(ciudad, provincia);
        grafito.agregarVertice(c2n.ciudad2Numero(ciudad));
    }

    public void eliminarCiudad(String ciudad) {
        c2n.eliminarCiudad(ciudad);
    }

    public void listarCiudadesVecinas() {

    }

    public void listarCiudadesPuente() {

    }

    public void listarCiudadesPredecesoras() {

    }

    public void listarCiudadesExtremo() {

    }

    public void listarCiudadesFuertementeConectadas() {

    }

    public void calcularCamino() {

    }
}
