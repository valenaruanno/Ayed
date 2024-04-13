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
public class DoubleEndedQueue <T> extends Queue <T>{
    public void enQueueFirst (T dato){
        Queue <T> temp = new Queue <T> ();                  //temp = cola
        while (! super.isEmpty())                           //si la cola super no esta vacia
            temp.enQueue (super.deQueue());                 //encolo en la cola temp el elemento del frente de la cola super
        super.enQueue (dato);                               //encolo en la cola super el dato
        while (! temp.isEmpty())                            //si la cola temp no esta vacia 
            super.enQueue (temp.deQueue());                 // encolo en la cola super el elemento del frente de la cola temp
    }
}
