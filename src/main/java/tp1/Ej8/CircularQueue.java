/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.Ej8;

/**
 *
 * @author valen
 */
public class CircularQueue <T> extends Queue <T> {
    public T shift (){
        if (!super.isEmpty()){
            T dato = super.deQueue();      //elimina el elemento del frente y lo retorna en dato
            super.enQueue (dato);          //inserta en el rabo de la cola
            return (dato);
        } else
            return null;
    }
}
