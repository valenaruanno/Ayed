package PreParcialArboles.ej8p3.ej8p3;

import java.util.Iterator;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

public class Navidad {
    private GeneralTree<Integer> arbol;

    public Navidad (GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }

    public String esAbetoNavidenio (){
        return (!this.arbol.isEmpty()) ? chequear (this.arbol) : "no";
    }

    private String chequear (GeneralTree<Integer> arbol){
        String result = "si";
        int cant = 0;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child : children){
            if (!child.isLeaf())
                cant++;
        } 
        if (! (cant >= 3))
            result = "no";
        else{
            String resC = "si";
            Iterator<GeneralTree<Integer>> it = children.iterator();
            while (it.hasNext() && resC == "si"){
                if (!(it.next().isLeaf()))
                    resC = chequear (it.next());
            }
            result = resC;
        }
        return result;
    }

public static void main(String[] args) {
    
    GeneralTree<Integer> HI = new GeneralTree <Integer> (1);
    HI.addChild(new GeneralTree <Integer> (1));
    HI.addChild(new GeneralTree <Integer> (1));
    HI.addChild(new GeneralTree <Integer> (1));
    
    GeneralTree <Integer> HM = new GeneralTree <Integer> (1);
    HM.addChild(new GeneralTree <Integer> (1));
    HM.addChild(new GeneralTree <Integer> (1));
    HM.addChild(new GeneralTree <Integer> (1));
    
    GeneralTree <Integer> HD = new GeneralTree <Integer> (1);
    HD.addChild(new GeneralTree <Integer> (1));
    HD.addChild(new GeneralTree <Integer> (1));
    HD.addChild(new GeneralTree <Integer> (1));
    
    GeneralTree <Integer> arbol = new GeneralTree <Integer> (1);
    arbol.addChild(new GeneralTree <Integer> (1));
    arbol.addChild(new GeneralTree <Integer> (1));
    arbol.addChild(new GeneralTree <Integer> (1));
    arbol.addChild(HI);
    arbol.addChild(HM);
    arbol.addChild(HD);
    
    Navidad navidad = new Navidad (arbol);
    System.out.println(navidad.esAbetoNavidenio());
}
}
