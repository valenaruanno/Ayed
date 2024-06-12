/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PreParcialArboles.ej6p2;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class mainEj6p2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree<Integer> HID = new BinaryTree<Integer>(4);

        BinaryTree<Integer> HI = new BinaryTree<Integer>(2);
        HI.addLeftChild(HID);

        BinaryTree<Integer> HDI = new BinaryTree<Integer>(5);
        HDI.addLeftChild(new BinaryTree<Integer>(7));
        HDI.addRightChild(new BinaryTree<Integer>(8));
        BinaryTree<Integer> HDD = new BinaryTree<Integer>(6);

        BinaryTree<Integer> HD = new BinaryTree<Integer>(3);
        HD.addLeftChild(HDI);
        HD.addRightChild(HDD);

        BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);
        arbol.addLeftChild(HI);
        arbol.addRightChild(HD);

        Transformacion trans = new Transformacion(arbol);
        BinaryTree<Integer> transformado = new BinaryTree<Integer>();
        transformado = trans.suma();
        recorrer(transformado);
    }

    public static void recorrer(BinaryTree<Integer> ab) {
        if (!ab.isEmpty()) {
            if (ab.hasLeftChild()) {
                recorrer(ab.getLeftChild());
            }
            System.out.println(ab.getData());
            if (ab.hasRightChild()) {
                recorrer(ab.getRightChild());
            }
        }
    }
}
