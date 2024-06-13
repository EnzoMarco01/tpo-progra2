package impl;

import impl.nodos.Nodo;
import impl.nodos.NodoCiudadNumero;
import interfaz.ConjuntoTDA;

public class Ciudad2NumeroDinamico {

    NodoCiudadNumero nodo = null;
    int id = 0;

    //guarda la ciudad, provincia, id en nodo ciudad si la ciudad no esta dentro del nodo
    public void agregarCiudadProvincia(String ciudad, String provincia){
        if (!this.perteneceCiudad(ciudad)) {
            NodoCiudadNumero nodoNuevo = new NodoCiudadNumero();
            id++;
            nodoNuevo.id = id;
            nodoNuevo.ciudad = ciudad;
            nodoNuevo.provincia = provincia;
            nodoNuevo.sig = nodo;
            nodo = nodoNuevo;
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

    //se ingresa la ciudad buscada y devuelve el id correspondiente a esta si es que existe
    // caso de que no exista devuelve 0
    public int ciudad2Numero(String ciudad) {
        NodoCiudadNumero aux = nodo;

        while (aux != null && !aux.ciudad.equals(ciudad)){
            aux = aux.sig;
        }

        return aux != null ? aux.id : 0;
    }

    //busca la ciudad y provincia mediante el id con el que se guardo en el grafo
    //devuelve un Str[], [0]=ciudad y [1]=provincia
    public String[] numero2Ciudad(int id){

        NodoCiudadNumero aux = nodo;

        while (aux != null && aux.id != id){
            aux = aux.sig;
        }

        return new String[]{aux.ciudad, aux.provincia} ;
    }

    //devuelve las provincias en un string formateado
    public String devolverProvincias() {
        String strProvincias = "Listado de provincias: \n";
        Ciudad2NumeroDinamico c2nAux = new Ciudad2NumeroDinamico();
        NodoCiudadNumero aux = nodo;

        while (aux != null){
            if (!c2nAux.perteneceProvincia(aux.provincia)) {
                c2nAux.agregarCiudadProvincia(aux.provincia, aux.provincia);
                strProvincias += (" -" + aux.provincia + "\n");
            }
            aux = aux.sig;
        }
        return strProvincias;
    }

    //devuelve las ciudades en un string formateado
    public String devolverCiudades() {
        String strCiudades = "Listado de ciudades: \n";
        NodoCiudadNumero aux = nodo;

        while (aux != null){
            strCiudades += (" -" + aux.ciudad + "\n");
            aux = aux.sig;
        }
        return strCiudades;
    }

    //metodo privado utilizado para saber si una ciudad ya existe en mi nodo
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

}
