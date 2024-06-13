package interfaz;

public interface ConjuntoTDA {

    void inicializarConjunto();

    boolean conjuntoVacio();

    void agregar(int x);

    int elegir();

    void sacar(int x);

    boolean pertenece(int x);

}