package impl;

import impl.nodos.NodoArista;
import impl.nodos.NodoGrafo;
import interfaz.ConjuntoTDA;
import interfaz.GrafoTDA;

public class GrafoDinamico implements GrafoTDA{

    NodoGrafo origen;

    public void inicializarGrafo() {
        origen = null;
    }

    public void agregarVertice(int v) {
        //El vertice se inserta al inicio de la lista de nodos
        NodoGrafo aux = new NodoGrafo();
        aux.nodo = v;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    /*
     * Para agregar una nueva arista al grafo, primero se deben 76
     * buscar los nodos entre los cuales se va agregar la arista,
     * y luego se inserta sobre la lista de adyacentes del nodo
     * origen (en este caso nombrado como v1)
     */
    public void agregarArista(int v1, int v2, int peso) {

        NodoGrafo n1 = vert2Nodo(v1);
        NodoGrafo n2 = vert2Nodo(v2);

        //La nueva arista se inserta al inicio de la lista de nodos adyacentes del nodo origen
        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    public void eliminarVertice(int v) {
        //Se recorre la lista de v´ ertices para remover el nodo v y las aristas con este vertice.

        //Distingue el caso que sea el primer nodo
        if (origen.nodo == v) {
            origen = origen.sigNodo;
        }

        NodoGrafo aux = origen;

        while (aux != null) {
            //remueve de aux todas las aristas hacia v
            this.eliminarAristaNodo(aux, v);

            if (aux.sigNodo != null && aux.sigNodo.nodo == v) {
                //Si el siguiente nodo de aux es v, lo elimina
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    public ConjuntoTDA vertices() {

        ConjuntoTDA c = new ConjuntoDinamico();
        NodoGrafo aux = origen;

        c.inicializarConjunto();

        while (aux != null) {

            c.agregar(aux.nodo);

            aux = aux.sigNodo;
        }

        return c;
    }


    //  Se elimina la arista que tiene como origen al vertice v1 y destino al vertice v2
    public void eliminarArista(int v1, int v2) {
        NodoGrafo n1 = vert2Nodo(v1);
        eliminarAristaNodo(n1, v2);
    }

    public boolean existeArista(int v1, int v2) {

        NodoGrafo n1 = vert2Nodo(v1);
        NodoArista aux = n1.arista;

        while (aux != null && aux.nodoDestino.nodo != v2) {
            aux = aux.sigArista;
        }

        //Solo si se encontro la arista buscada, aux no es null
        return aux != null;
    }

    public int pesoArista(int v1, int v2) {

        NodoGrafo n1 = vert2Nodo(v1);
        NodoArista aux = n1.arista;

        while (aux.nodoDestino.nodo != v2) {
            aux = aux.sigArista;
        }

        //Se encontro la arista entre los dos nodos
        return aux.etiqueta;
    }

    private NodoGrafo vert2Nodo(int v) {

        NodoGrafo aux = origen;

        while (aux != null && aux.nodo != v) {
            aux = aux.sigNodo;
        }

        return aux;
    }

    /*
     * Si en las aristas del nodo existe
     * una arista hacia v, la elimina
     */
    private void eliminarAristaNodo(NodoGrafo nodo, int v) {

        NodoArista aux = nodo.arista;

        if (aux != null) {
            //Si la arista a eliminar es la primera en la lista de nodos adyacentes
            if (aux.nodoDestino.nodo == v) {
                nodo.arista = aux.sigArista;
            }
            else {
                while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v) {
                    aux = aux.sigArista;
                }
                if (aux.sigArista != null) {
                    //Quita la referencia a la arista hacia v
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

}