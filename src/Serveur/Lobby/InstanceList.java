package Serveur.Lobby;

import java.io.Serializable;
import java.util.ArrayList;

import Utils.Couple;

public class InstanceList implements Serializable {

	private static final long serialVersionUID = 3644201388943130379L;
	private ArrayList<Couple<String, Integer>> instances;

	public InstanceList() {
		this.instances = new ArrayList<Couple<String, Integer>>();
	}

	synchronized public void add(Couple<String, Integer> g) {
		this.instances.add(g);
	}

	synchronized public void remove(String g) {
		this.instances.remove(this.get(g));
	}

	synchronized public Couple<String,Integer> get(String name){
		for(Couple<String,Integer> c: this.instances) {
			if(c.gauche().equals(name)) {
				System.out.println("non");
				return c;
			}
		}
		System.out.println("OUI");
		return null;
	}
	
	synchronized public ArrayList<Couple<String, Integer>> getInstances() {
		return this.instances;
	}

	synchronized public boolean exists(String name, Integer port) {
		for (Couple<String, Integer> c : this.instances) {
			if (c.equals(new Couple<String, Integer>(name, port))) {
				return true;
			}
		}
		return false;
	}
}
