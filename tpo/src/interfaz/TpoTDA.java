package interfaz;

import impl.Ciudad2NumeroDinamico;

public interface TpoTDA {

    String listarProvincias();

    String listarCiudades();

    void cargarCiudad(String ciudad, String provincia);

    void eliminarCiudad(String ciudad);

    void crearRuta(String ciudadOrigen, String ciudadDestino, int km);

    void listarCiudadesVecinas();

    void listarCiudadesPuente();

    void listarCiudadesPredecesoras();

    void listarCiudadesExtremo();

    void listarCiudadesFuertementeConectadas();

    void calcularCamino();

}
