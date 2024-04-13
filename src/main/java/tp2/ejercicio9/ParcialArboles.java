/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio9;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    
    public BinaryTree <Data> sumAndDif (BinaryTree <Integer> ab){
        return (!ab.isEmpty()) ? sumAndDif (ab, 0, 0) : null;
    }
    
    private BinaryTree <Data> sumAndDif (BinaryTree <Integer> ab, int sum, int padre){
        int suma = ab.getData() + sum;
        int dif = ab.getData() - padre;
        BinaryTree <Data> nuevo = new BinaryTree <Data> (new Data (suma, dif));
        if (ab.hasLeftChild())
            nuevo.addLeftChild(sumAndDif (ab.getLeftChild(), suma, ab.getData()));
        if (ab.hasRightChild()){
            nuevo.addRightChild(sumAndDif (ab.getRightChild(), suma, ab.getData()));
        }
        return nuevo;
    }
    
    public void preOrden (BinaryTree <Data> ab){
            System.out.println(ab.getData().toString());
            if (ab.hasLeftChild())
                preOrden (ab.getLeftChild());
            if (ab.hasRightChild())
                preOrden(ab.getRightChild());
        }
}
