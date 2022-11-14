package algorithms;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.jbotsim.core.Link;
import io.jbotsim.core.Topology;
import io.jbotsim.ui.JViewer;
import java.util.Vector;



public class Anneau {
	public static void main(String args[]){
		int nbNodes=30;
		Topology t = new Topology();
		Vector<Tnode> vec= new Vector<Tnode>();
		for (int i=0; i<nbNodes; i++){
			Tnode node= new Tnode(i);
			node.disableWireless();
			node.RingSize = nbNodes;
			double angle=(2.0*Math.PI/nbNodes)*i;
			node.setLocation(300+Math.cos(angle)*200, 300+Math.sin(angle)*200);
			t.addNode(node);
			vec.add(node);			
		}
		for (int i=0; i<nbNodes-1; i++){
			t.addLink(new Link(vec.get(i), vec.get(i+1)));
			vec.get(i).right = vec.get(i+1);
			vec.get(i+1).left = vec.get(i);
		}
		t.addLink(new Link(vec.get(nbNodes-1),vec.get(0)));
		vec.get(nbNodes-1).right = vec.get(0);
		vec.get(0).left = vec.get(nbNodes-1);

		new JViewer(t);
		t.start();
	}
}
