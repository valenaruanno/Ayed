/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej3p2;
import tp2.ejercicio1.BinaryTree;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author valen
 */
public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    
    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public ArrayList<Integer> contarParesInOrder (){
        ArrayList <Integer> lista = new ArrayList<Integer> ();
        return (!this.getArbol().isEmpty()) ? inOrder (this.getArbol(), lista): lista;
    }
    
    private ArrayList<Integer> inOrder (BinaryTree<Integer> arbol, ArrayList<Integer> lista){
        if (arbol.hasLeftChild())
            inOrder (arbol.getLeftChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
        if (arbol.hasRightChild())
            inOrder (arbol.getRightChild(), lista);
        return lista;
    }
    
    public ArrayList<Integer> contarParesPostOrder (){
        ArrayList <Integer> lista = new ArrayList<Integer> ();
        return (!this.getArbol().isEmpty()) ? postOrder (this.getArbol(), lista): lista;
    }
    
    private ArrayList<Integer> postOrder (BinaryTree<Integer> arbol, ArrayList<Integer> lista){
        if (arbol.isLeaf()){
            lista.add(arbol.getData());
        } else{
            if (arbol.hasLeftChild())
                postOrder (arbol.getLeftChild(), lista);
            if (arbol.hasRightChild())
                postOrder (arbol.getRightChild(), lista);
            if (arbol.getData() % 2 == 0)
                lista.add(arbol.getData());
        }
        return lista;
    }
}
