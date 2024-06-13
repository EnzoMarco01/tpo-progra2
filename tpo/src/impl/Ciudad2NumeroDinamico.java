package impl;

import impl.nodos.Nodo;
import impl.nodos.NodoCiudadNumero;

public class Ciudad2NumeroDinamico {

    NodoCiudadNumero nodo;
    int id;
    public void inicializar(){
        nodo = null;
        id = 0;
    }

    //guarda la ciudad, provincia, id en nodo ciudad si la ciudad no esta dentro del nodo
    public void agregarCiudadProvincia(String ciudad, String provincia){
        if (!this.pertenece(ciudad)) {
            NodoCiudadNumero nodoNuevo = new NodoCiudadNumero();
            id++;
            nodoNuevo.id = id;
            nodoNuevo.ciudad = ciudad;
            nodoNuevo.provincia = provincia;
            nodoNuevo.sig = nodo;
            nodo = nodoNuevo;
        }
        System.out.println("agregarCiudadProvincia: " + id);
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

    //metodo privado utilizado para saber si una ciudad ya existe en mi nodo
    private boolean pertenece(String ciudad) {

        NodoCiudadNumero aux = nodo;

        while (aux != null && !aux.ciudad.equals(ciudad)){
            aux = aux.sig;
        }

        return aux != null;
    }
}
