package interfaz;

public interface GrafoTDA {

    void inicializarGrafo();

    // siempre que el grafo este inicializado y no exista el nodo
    void agregarVertice(int v);

    // siempre que el grafo este inicializado y exista el nodo
    void eliminarVertice(int v);

    // siempre que el grafo este inicializado
    ConjuntoTDA vertices();

    // siempre que el grafo este inicializado, no exista la arista, pero existan ambos nodos
    void agregarArista(int v1, int v2, int peso);

    // siempre que el grafo este inicializado y exista la arista
    void eliminarArista(int v1, int v2);

    // siempre que el grafo este inicializado y existan los nodos
    boolean existeArista(int v1, int v2);

    // siempre que el grafo este inicializado y exista la arista
    int pesoArista(int v1, int v2);

}