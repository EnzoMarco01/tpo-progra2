import impl.Ciudad2NumeroDinamico;
import impl.GrafoDinamico;
import impl.Tpo;
import interfaz.GrafoTDA;
import interfaz.TpoTDA;
import utilidades.GrafoUtils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //creo las variables en donde van a ir almacenados mis objetos
        GrafoUtils utilidades = new GrafoUtils();
        Ciudad2NumeroDinamico c2n = new Ciudad2NumeroDinamico();
        GrafoTDA grafito = new GrafoDinamico();
        TpoTDA tpo = new Tpo();

        //inicializo grafoDinamico, utilidades no lo codie todavia asi q no lo inicializo
        grafito.inicializarGrafo();

        //registro las ciudades con sus respectivas provincias en el objeto c2n cuyo tipo de dato es Ciudad2NumeroDinamico
        //tambien al registrarse se les asigna un id unico que usaremos para representar la ciudad en el grafo
        c2n.agregarCiudadProvincia("la plata", "buenos aires");
        c2n.agregarCiudadProvincia("mar del plata", "buenos aires");
        c2n.agregarCiudadProvincia("CABA", "buenos aires");
        c2n.agregarCiudadProvincia("tandil", "buenos aires");

        //agrego los vertices al grafo recuperando los id creados en el paso anterior
        grafito.agregarVertice(c2n.ciudad2Numero("la plata"));
        grafito.agregarVertice(c2n.ciudad2Numero("mar del plata"));
        grafito.agregarVertice(c2n.ciudad2Numero("CABA"));
        grafito.agregarVertice(c2n.ciudad2Numero("tandil"));

        //creo una arista en mi objeto grafoDinamico llamado grafito
        //y consigo los nros del grafo que representan mis ciudades mediante c2n
        grafito.agregarArista(c2n.ciudad2Numero("la plata"), c2n.ciudad2Numero("CABA"), 69);

        //testeo que me ande todoo
        System.out.println("ciudad y provincia del id 2: " + c2n.numero2Ciudad(2)[0] + " - " + c2n.numero2Ciudad(2)[1]);

        System.out.print("agregar Arista: ");
        System.out.print("la plata:" + c2n.ciudad2Numero("la plata"));
        System.out.println(" - CABA:" + c2n.ciudad2Numero("CABA"));

        System.out.println("existe la arista? " + grafito.existeArista(c2n.ciudad2Numero("la plata"),c2n.ciudad2Numero("CABA")));
        System.out.println("existe la arista opuesta? " + grafito.existeArista(c2n.ciudad2Numero("CABA"),c2n.ciudad2Numero("la plata")));

        System.out.println("peso de la arista: " +grafito.pesoArista(c2n.ciudad2Numero("la plata"), c2n.ciudad2Numero("CABA")));

        System.out.println();

        //agregar y listar ciudades OK
        tpo.cargarCiudad("la plata", "buenos aires");
        tpo.cargarCiudad("mar del plata", "buenos aires");
        tpo.cargarCiudad("CABA", "buenos aires");
        tpo.cargarCiudad("tandil", "buenos aires");
        tpo.cargarCiudad("ciudad de cordoba", "cordoba");

        System.out.println(tpo.listarCiudades());

        //listar provincias OK
        System.out.println(tpo.listarProvincias());

        //eliminar OK
        tpo.eliminarCiudad("tandil");
        System.out.println(tpo.listarCiudades() + "(tandil eliminado)\n");

        //agregar ruta
        tpo.crearRuta("CABA", "mar del plata", 500);
    }
}