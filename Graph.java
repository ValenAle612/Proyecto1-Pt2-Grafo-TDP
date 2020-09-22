package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.*;

public class Graph {
	private List<Arco> arcos;
	private List<Integer> nodos;
	private static Logger logger;
	
	public Graph() {
		arcos = new LinkedList<Arco>();
		nodos = new LinkedList<Integer>();
		if( logger == null ) {
			logger = Logger.getLogger( Graph.class.getName() );
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING); // <----
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			
			}
		}
	}
	
	public void addNode(int node) {
		int indice = nodos.indexOf(node);
		
		if( indice == -1 ) {
			nodos.add(node);
			logger.info("el nodo "+node+" fue añadido correctamente.");
		}else 
			logger.warning(" el nodo "+node+" ya se encuentra en el grafo, en la posicion "+indice+" . " );
		
	}
	
	public void addEdge(int node1, int node2) {
		int i1 = nodos.indexOf(node1) , i2 = nodos.indexOf(node2);
		Iterator<Arco> it = arcos.iterator();
		boolean existe=false;
		Arco a;
		if( i1 != -1 && i2 != -1 ) {
			while( it.hasNext() && !existe ) {
			
				a=it.next(); 
				existe=( ( a.getOrigen() == node1 ) && ( a.getDestino() == node2 ) );
			
			}
			if(!existe) {
				arcos.add(new Arco(node1,node2));
				logger.info(" ahora existe un arco desde "+node1+" hacia "+node2+" . ");
			}else 
				logger.warning(" ya existe un arco entre los nodos "+node1+" y "+node2+" . ");
		}else 
			logger.warning(" uno de los nodos, o ambos, no pertenecen al arco -> ( "+node1+" , "+node2+" ).");
		
	}
	
	public void removeNode(int node) {
		
		int indice = nodos.indexOf(node);
		
		if(indice != -1) {
			
			nodos.remove(indice); 
		
			Iterator<Arco> it = arcos.iterator();
			Arco aux;
		
			while( it.hasNext() ) {
				aux=it.next();
				
				if(	aux.getOrigen() == node || aux.getDestino() == node )
					it.remove();
			}
			logger.info(" el nodo "+node+" fue removido correctamente del grafo. ");
		}else logger.warning(" el nodo "+node+" no pertenece al grafo. ");
		
	}
	
	public void removeEdge(int node1, int node2) {
		
		 Iterator<Arco> it = arcos.iterator();
		 Arco aux; boolean removi=false;
		 
		 while( it.hasNext() && !removi ) {

			 aux=it.next();
			 if( ( aux.getOrigen() == node1 ) && ( aux.getDestino() == node2 ) ) {
				 it.remove();
				 removi=true;
				 
				 logger.info(" el arco entre los nodos "+node1+" y "+node2+" fue removido. ");
			 }
			 
		 }
		 
		 if(!removi) 
			 logger.warning(" no existe un arco entre los nodos "+node1+" y "+node2+" . ");
		 
	}
}
