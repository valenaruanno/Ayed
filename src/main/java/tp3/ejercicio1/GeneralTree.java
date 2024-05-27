package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;
import tp1.Ej8.Queue;


public class GeneralTree<T>{
	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	
            int max = -1;
            return (!this.isEmpty()) ? max = altura (this, max): max;
	}
        
        private  int altura (GeneralTree <T> arbol, int max){
            int cant = 1;
            if (!arbol.isLeaf()){
                List <GeneralTree<T>> children = (LinkedList) arbol.getChildren();
                for (GeneralTree<T> child: children){
                    cant += altura (child, max);
                    if (cant > max){
                        max = cant;
                        cant = 1;
                    }
                }
            }
            return cant;
        }
	
	public int nivel(T dato){
            int niv;
            if (!this.isEmpty()){
                niv = 0;
                boolean ok = false;
                Queue <GeneralTree <Integer>> cola = new Queue <GeneralTree <Integer>> ();
                cola.enQueue((GeneralTree<Integer>) this);
                cola.enQueue(null);
                while ((!cola.isEmpty()) && (ok == false)){
                    GeneralTree <Integer> arb = new GeneralTree<Integer> ();
                    arb = cola.deQueue();
                    if (arb == null){
                        niv++;
                        cola.enQueue(null);
                    }
                    else {
                        if (arb.getData() == dato)
                            ok = true;
                        else{
                            LinkedList <GeneralTree<Integer>> children = (LinkedList) arb.getChildren();
                            for (GeneralTree<Integer> child : children)
                                cola.enQueue(child);
                        }
                    }
                }
            } else {
                niv = -1;
            }
            return niv;
	}

	public int ancho(){
            int max = -1;
            if (!this.isEmpty()){
                Queue <GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>> ();
                cola.enQueue((GeneralTree <Integer> )this);
                cola.enQueue(null);
                int anch = 0;
                while (!cola.isEmpty()){
                    GeneralTree<Integer> arb = new GeneralTree<Integer> ();
                    arb = cola.deQueue();
                    if (arb != null){
                        anch++;
                        LinkedList <GeneralTree<Integer>> children = (LinkedList) arb.getChildren();
                        for (GeneralTree<Integer> child: children){
                            cola.enQueue(child);
                        }
                    } else {
                        if (!cola.isEmpty()){
                            if (anch > max)
                                max = anch;
                            anch = 0;
                            cola.enQueue(null);
                        }
                    }
                }
            }
            return max;
	}
        
        public boolean esAncestro (T a, T b){
            boolean ancestro = false;
            if (!this.isEmpty()){
                GeneralTree <T> arbol = new GeneralTree<T> ();
                Queue <GeneralTree<T>> cola = new Queue <GeneralTree<T>> ();
                cola.enQueue(this);
                boolean esta = false;
                boolean primeroB = false;
                while ((!cola.isEmpty()) && !esta && !primeroB){
                    arbol = cola.deQueue();
                    if (!(arbol.getData() == a)){
                        if (!(arbol.getData() == b)){
                            LinkedList <GeneralTree<T>> children = (LinkedList) this.getChildren();
                            for (GeneralTree<T> child : children)
                                cola.enQueue(child);
                        } else{
                            primeroB = true;
                        }
                    } else{
                        esta = true;
                    }
                }
                if (esta == true)
                    ancestro = buscar (arbol, b);
            }
            
            return ancestro;
        }
        
        private boolean buscar (GeneralTree<T> arbol, T b){
            boolean esta = false;
            if (arbol.isLeaf()){
                if (arbol.getData() == b)
                    esta = true;
            } else{
                if (!(arbol.getData() == b)){
                    LinkedList <GeneralTree<T>> children = (LinkedList) arbol.getChildren();
                    for (GeneralTree<T> child: children)
                        if (esta != true)
                            esta = buscar (child, b);
                }else{
                   esta = true; 
                }
            }
            return esta;
        }
        
}
