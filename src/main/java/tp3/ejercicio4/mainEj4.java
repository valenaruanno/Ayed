
package tp3.ejercicio4;
import java.util.LinkedList;
import tp3.ejercicio1.GeneralTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AreaEmpresa a = new AreaEmpresa ("marketing", 3);
        AreaEmpresa a1 = new AreaEmpresa ("mar", 5);
        AreaEmpresa a2 = new AreaEmpresa ("ket", 45);
        GeneralTree <AreaEmpresa> HDI = new GeneralTree<AreaEmpresa> (a1);
        GeneralTree <AreaEmpresa> HDD = new GeneralTree<AreaEmpresa> (a2);
        LinkedList <GeneralTree<AreaEmpresa>> hijosHD = new LinkedList <GeneralTree<AreaEmpresa>> ();
        hijosHD.add(HDI);
        hijosHD.add(HDD);
        GeneralTree <AreaEmpresa> HD = new GeneralTree<AreaEmpresa> (a, hijosHD);
        AreaEmpresa a3 = new AreaEmpresa ("negocios", 2);
        GeneralTree <AreaEmpresa> HI = new GeneralTree<AreaEmpresa> (a3);
        
        LinkedList <GeneralTree<AreaEmpresa>> hijos = new LinkedList <GeneralTree<AreaEmpresa>> ();
        hijos.add(HI);
        hijos.add(HD);
        GeneralTree <AreaEmpresa> arbol = new GeneralTree<AreaEmpresa> (a, hijos);
        
        AnalizarArbol an = new AnalizarArbol ();
        System.out.println("El promedio maximo es" + an.devolverMaximoPromedio(arbol));
    }
    
}
