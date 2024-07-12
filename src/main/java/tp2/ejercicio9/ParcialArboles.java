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
        BinaryTree<Data> nuevo = new BinaryTree<Data> ();
        if (!ab.isEmpty())
            nuevo = sumAndDif (ab, 0, 0);
        return nuevo;
    }
    
    private BinaryTree <Data> sumAndDif (BinaryTree <Integer> ab, int sum, int padre){
        BinaryTree<Data> nuevo = new BinaryTree<Data> ();
        Data raiz = new Data (sum + ab.getData(), ab.getData() - padre);
        nuevo.setData(raiz);
        if (ab.hasLeftChild())
            nuevo.addLeftChild(sumAndDif (ab.getLeftChild(), sum + ab.getData(), ab.getData()));
        if (ab.hasRightChild()){
            nuevo.addRightChild(sumAndDif (ab.getRightChild(), sum + ab.getData(), ab.getData()));
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
