package impl;

import impl.Ciudad2NumeroDinamico;
import impl.nodos.NodoCiudadNumero;
import interfaz.GrafoTDA;
import interfaz.TpoTDA;

public class Tpo implements TpoTDA {

    NodoCiudadNumero nodo = null;
    int id = 0;
    private GrafoTDA grafito = new GrafoDinamico();

    public String listarProvincias() {
        String strProvincias = "Listado de provincias: \n";
        Tpo tpoAux = new Tpo();
        NodoCiudadNumero aux = nodo;

        while (aux != null){
            if (!tpoAux.perteneceProvincia(aux.provincia)) {
                tpoAux.cargarCiudad(aux.provincia, aux.provincia);
                strProvincias += (" -" + aux.provincia + "\n");
            }
            aux = aux.sig;
        }
        return strProvincias;
    }

    public String listarCiudades() {
        String strCiudades = "Listado de ciudades: \n";
        NodoCiudadNumero aux = nodo;

        while (aux != null){
            strCiudades += (" -" + aux.ciudad + "\n");
            aux = aux.sig;
        }
        return strCiudades;
    }

    public void cargarCiudad(String ciudad, String provincia) {

        if (!this.perteneceCiudad(ciudad)) {
            NodoCiudadNumero nodoNuevo = new NodoCiudadNumero();
            id++;
            nodoNuevo.id = id;
            nodoNuevo.ciudad = ciudad;
            nodoNuevo.provincia = provincia;
            nodoNuevo.sig = nodo;
            nodo = nodoNuevo;

            grafito.agregarVertice(this.ciudad2Numero(ciudad));
        }
    }

    public void eliminarCiudad(String ciudad) {
        if (nodo != null){

            if (nodo.ciudad.equals(ciudad)){
                nodo = nodo.sig;
            }
            else{
                NodoCiudadNumero aux = nodo;

                while (aux.sig != null && !aux.sig.ciudad.equals(ciudad)){
                    aux = aux.sig;
                }

                if (aux.sig != null){
                    aux.sig = aux.sig.sig;
                }

            }
        }
    }

    public void crearRuta(String ciudadOrigen, String ciudadDestino, int km) {
        grafito.agregarArista(this.ciudad2Numero(ciudadOrigen), this.ciudad2Numero(ciudadDestino), km);

        System.out.println(
                "Existe una ruta entre "
                + ciudadOrigen
                + " y "
                + ciudadDestino
                + ": "
                + grafito.existeArista(this.ciudad2Numero(ciudadOrigen), this.ciudad2Numero(ciudadDestino))
                + "\nEsta ruta tiene "
                + grafito.pesoArista(this.ciudad2Numero(ciudadOrigen), this.ciudad2Numero(ciudadDestino))
                +"KM.\n"
        );

        System.out.println(
                "Existe una ruta entre "
                        + ciudadDestino
                        + " y "
                        + ciudadDestino
                        + ": "
                        + grafito.existeArista(this.ciudad2Numero(ciudadDestino), this.ciudad2Numero(ciudadDestino))
                        + "\n"
        );

    }

    public String listarCiudadesVecinas(String ciudad) {
        String listaCiudades = "Listado de ciudades vecinas de " + ciudad + ": \n";
        NodoCiudadNumero nodoAux = nodo;

        while (nodoAux.sig != null){
            if (grafito.existeArista(this.ciudad2Numero(ciudad), this.ciudad2Numero(nodoAux.ciudad))
                    && !ciudad.equals(nodoAux.ciudad)) {
                listaCiudades += (" -" + nodoAux.ciudad + "\n");
            }
            nodoAux = nodoAux.sig;
        }

        return listaCiudades;
    }

    public void listarCiudadesPuente() {

    }

    public void listarCiudadesPredecesoras() {

    }

    public void listarCiudadesExtremo() {

    }

    public String listarCiudadesFuertementeConectadas() {
    //Las ciudades fuertemente conectadas son las que tienen rutas de ida y vueltaentre ellas.
        String listaCiudades = "Listado de ciudades fuertemente conectadas: \n";
        NodoCiudadNumero nodoAux = nodo;

        while (nodoAux.sig != null){
            if (grafito.existeArista(this.ciudad2Numero(nodoAux.ciudad), this.ciudad2Numero(nodoAux.ciudad))
                    && !nodoAux.ciudad.equals(nodoAux.ciudad)) {
                listaCiudades += (" -" + nodoAux.ciudad + "\n");
            }
            nodoAux = nodoAux.sig;
        }

        return listaCiudades;
    }

    public void calcularCamino() {

    }

    private boolean perteneceCiudad(String ciudad) {

        NodoCiudadNumero aux = nodo;

        while (aux != null && !aux.ciudad.equals(ciudad)){
            aux = aux.sig;
        }

        return aux != null;
    }

    private boolean perteneceProvincia(String provincia) {

        NodoCiudadNumero aux = nodo;

        while (aux != null && !aux.provincia.equals(provincia)){
            aux = aux.sig;
        }

        return aux != null;
    }

    private int ciudad2Numero(String ciudad) {
        NodoCiudadNumero aux = nodo;

        while (aux != null && !aux.ciudad.equals(ciudad)){
            aux = aux.sig;
        }

        return aux != null ? aux.id : 0;
    }

    private String[] numero2Ciudad(int id){

        NodoCiudadNumero aux = nodo;

        while (aux != null && aux.id != id){
            aux = aux.sig;
        }

        return new String[]{aux.ciudad, aux.provincia} ;
    }

}
