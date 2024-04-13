package tp2.ejercicio1;

import tp1.Ej8.Queue;

public class BinaryTree <T> {	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
            int hojas = 0;
	   if (this.isEmpty()) {						//si esta vacio retorna 0. CASO BASE
		  return 0;
	   }else {
		   if (this.isLeaf())						//si es una hoja retorna 1. CASO BASE  
			   return 1;
		   	else {
			   if (this.hasLeftChild()) 
				   hojas += this.getLeftChild().contarHojas();
			   if (this.hasRightChild())
				   hojas += this.getRightChild().contarHojas();
		   }
		return hojas;
            }
	}
		
        public BinaryTree<T> espejo(){
            BinaryTree<T> aux = new BinaryTree<>();                        //Es importante hacer esto, porque sino al modificar lo que retornás también vas a modificar al árbol original.
            if(!this.isEmpty()){  									//si no esta vacio
                aux.setData(this.getData());  							//genero un arbol auxiliar a partir del original
                if(this.hasLeftChild())									// si el original tiene hijo izquierdo, lo voy a modificar con el contenido del hijo derecho
                    aux.addRightChild(this.getLeftChild().espejo());
                if(this.hasRightChild())								// si el original tiene hijo derecho, lo voy a modificar con el contenido del hijo izquierdo
                    aux.addLeftChild(this.getRightChild().espejo());
            }
            return aux;
        }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
            BinaryTree<T> aux = null;
            Queue <BinaryTree<T>> cola = new Queue <BinaryTree<T>> ();
	    cola.enQueue(this);
	    cola.enQueue(null);
	    int nivel = 0;
	    while ((cola.isEmpty()) && (nivel <= n)){
		aux = cola.deQueue();
		if (aux != null) {								//es un arbol
                    if ((nivel >= n) && (nivel <= m))
                        System.out.println(aux.getData());
                    if (aux.hasLeftChild())
			cola.enQueue(aux.getLeftChild());
                    if (aux.hasRightChild())
			cola.enQueue(aux.getRightChild());
		}else {   										//es una marca de fin de nivel
		    nivel++;
		    if (cola.isEmpty())
			cola.enQueue(null);  					//encolamos otra marca de fin de nivel
		}
            }
	}
        
}

