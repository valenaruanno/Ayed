/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej4p3;

import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class mainEj4p3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree<AreaEmpresa> hii = new GeneralTree<AreaEmpresa> (new AreaEmpresa ("finanzas",3));
        GeneralTree<AreaEmpresa> hid = new GeneralTree<AreaEmpresa> (new AreaEmpresa ("it",9));
        GeneralTree<AreaEmpresa> hi = new GeneralTree<AreaEmpresa> (new AreaEmpresa ("recursos",8));
        hi.addChild(hid);
        hi.addChild(hii);
        
        GeneralTree<AreaEmpresa> hdi = new GeneralTree<AreaEmpresa> (new AreaEmpresa ("administracion",10));
        GeneralTree<AreaEmpresa> hdd = new GeneralTree<AreaEmpresa> (new AreaEmpresa ("departamento",2));
        GeneralTree<AreaEmpresa> hd = new GeneralTree<AreaEmpresa> (new AreaEmpresa ("administracion",1));
        hd.addChild(hdd);
        hd.addChild(hdi);
        
        GeneralTree<AreaEmpresa> arbol = new GeneralTree<AreaEmpresa> (new AreaEmpresa ("jefe",5));
        arbol.addChild(hd);
        arbol.addChild(hi);
        
        System.out.println(AnalizarArbol.devolverMayorPromedio(arbol));
    }
    
}
