/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio6;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class Transformacion {
    BinaryTree <Integer> arbol;
    
    public Transformacion (BinaryTree <Integer> arbol){
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree <Integer> suma (){
        if (!this.getArbol().isEmpty()){
            int tot = 0;
            if (this.getArbol().hasLeftChild())
                tot += suma(this.getArbol().getLeftChild());
            if (this.getArbol().hasRightChild())
                tot += suma(this.getArbol().getRightChild()); 
            this.getArbol().setData(tot);
        }
        return this.getArbol();
    }
    
    private static int suma (BinaryTree <Integer> bt){
        int tot = 0;
        if (bt.hasLeftChild())
            tot += suma (bt.getLeftChild());
        if (bt.hasRightChild())
            tot += suma(bt.getRightChild());
        int oldData = bt.getData();
        bt.setData(tot);
        return (tot + oldData);
    }
}
