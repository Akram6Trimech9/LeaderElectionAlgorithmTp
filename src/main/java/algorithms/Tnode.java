package algorithms;

import io.jbotsim.core.Clock;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;
import io.jbotsim.core.event.ClockListener;
import io.jbotsim.core.event.MessageListener;
public class Tnode extends Node implements ClockListener, MessageListener{
	public Node left;
	public Node right;
	public int RingSize;
		public Tnode(Integer id ) {
	setID(id);
	}
		@Override
		public void onStart() {
		send(getOutNeighbors().get(0),new Message(getID()));
		}
	private void addMessageListener(Tnode tnode) {
		// TODO Auto-generated method stub
		
	}

	public void onClock() {

		//Add code here

	}
	
	@Override
	public void onMessage(Message message) {
		if((Integer) message.getContent()==getID()) {
			System.out.println(getID()+"Leader");
		}else if((Integer) message.getContent() > getID()) {
			send(getOutNeighbors().get(0),new Message(message.getContent()));
		}
	 }
	}
	



 

 
