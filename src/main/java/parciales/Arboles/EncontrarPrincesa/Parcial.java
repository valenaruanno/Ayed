/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.EncontrarPrincesa;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class Parcial {
    private BinaryTree<Personaje> arbol;
    
    public Parcial (BinaryTree<Personaje> arbol){
        this.arbol = arbol;
    }
    
    public Personaje princesaAccesible (){
        Personaje per = new Personaje ();
        boolean encontre = false;
        if (!this.arbol.isEmpty())
            encontre = buscar (this.arbol, per);
        return per;
    }
    
    private boolean buscar (BinaryTree<Personaje> arbol, Personaje per){
        boolean esta = false;
        if (arbol.isLeaf()){
            if (arbol.getData().getTipo() == "Princesa")
                per.setTipo(arbol.getData().getTipo());
                per.setNombre(arbol.getData().getNombre());
                esta = true;
        } else {
            if ((arbol.hasLeftChild()) && (arbol.getLeftChild().getData().getTipo() != "Dragon"))
                esta = buscar (arbol.getLeftChild(), per);
            if ((!esta) && (arbol.hasRightChild()) && (arbol.getRightChild().getData().getTipo() != "Dragon"))
                esta = buscar (arbol.getRightChild(), per);
        }
        return esta;
    }
    
    public static void main(String args[]) {
        BinaryTree<Personaje> ab = new BinaryTree<Personaje>(new Personaje("X", "Prueba"));
        ab.addLeftChild(new BinaryTree<Personaje>(new Personaje("Dragon", "Roberto")));
        ab.getLeftChild().addLeftChild(new BinaryTree<Personaje>(new Personaje("Princesa", "Roxanne")));
        ab.getLeftChild().addRightChild(new BinaryTree<Personaje>(new Personaje("Y", "Prueba")));
        ab.addRightChild(new BinaryTree<Personaje>(new Personaje("Z", "Prueba")));
        ab.getRightChild().addRightChild(new BinaryTree<Personaje>(new Personaje("W", "Prueba")));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Personaje>(new Personaje("Princesa", "Diana")));
        
        Parcial p = new Parcial(ab);
        System.out.println(p.princesaAccesible().getNombre());
    }
}
