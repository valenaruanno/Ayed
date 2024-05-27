
package tp3.ejercicio8;
import tp1.Ej8.Queue;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class Navidad {
    GeneralTree <Integer> arbol = new GeneralTree <Integer> ();

    public Navidad(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public String esAbetoNavidenio (){
        String respuesta = "yes";
        boolean ok = true;
        Queue <GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>> ();
        cola.enQueue(arbol);
        while ((!cola.isEmpty()) && (ok)){
            GeneralTree <Integer> aux = new GeneralTree <Integer> ();
            aux = cola.deQueue();
            int cant = 0;
            if (aux != null){
                List <GeneralTree<Integer>> children = (LinkedList) aux.getChildren();
                for (GeneralTree <Integer> child : children){
                    if (child.isLeaf())
                        cant++;
                    else 
                        cola.enQueue(child);
                }
                if (!(cant >= 3)){
                    respuesta = "no";
                    ok = false;
                }
            }
        }
        return  respuesta;
    }
}
