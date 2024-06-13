import impl.Ciudad2NumeroDinamico;
import impl.GrafoDinamico;
import interfaz.GrafoTDA;
import utilidades.GrafoUtils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GrafoUtils utilidades = new GrafoUtils();
        Ciudad2NumeroDinamico c2n = new Ciudad2NumeroDinamico();
        GrafoTDA grafito = new GrafoDinamico();

        c2n.inicializar();
        grafito.inicializarGrafo();

        c2n.agregarCiudadProvincia("la plata", "buenos aires");
        c2n.agregarCiudadProvincia("mar del plata", "buenos aires");
        c2n.agregarCiudadProvincia("CABA", "buenos aires");
        c2n.agregarCiudadProvincia("tandil", "buenos aires");

        grafito.agregarVertice(c2n.ciudad2Numero("la plata"));
        grafito.agregarVertice(c2n.ciudad2Numero("mar del plata"));
        grafito.agregarVertice(c2n.ciudad2Numero("CABA"));
        grafito.agregarVertice(c2n.ciudad2Numero("tandil"));

        grafito.agregarArista(c2n.ciudad2Numero("la plata"), c2n.ciudad2Numero("CABA"), 69);

        System.out.println("ciudad y provincia del id 2: " + c2n.numero2Ciudad(2)[0] + " - " + c2n.numero2Ciudad(2)[1]);

        System.out.print("agregar Arista: ");
        System.out.print("la plata:" + c2n.ciudad2Numero("la plata"));
        System.out.println(" - CABA:" + c2n.ciudad2Numero("CABA"));

        System.out.println("existe la arista? " + grafito.existeArista(c2n.ciudad2Numero("la plata"),c2n.ciudad2Numero("CABA")));

        System.out.println("peso de la arista: " +grafito.pesoArista(c2n.ciudad2Numero("la plata"), c2n.ciudad2Numero("CABA")));
    }
}