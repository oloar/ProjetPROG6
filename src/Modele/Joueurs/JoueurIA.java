package Modele.Joueurs;

import java.util.ArrayList;
import Modele.Plateau.Plateau;
import Utils.Couple;
import Utils.Position;


public class JoueurIA extends Joueur {
	
	private boolean threadLancee;
	private IAshared shared;
	
	private static final long serialVersionUID = -8134226007569319548L;

	public JoueurIA(int id,int nbP,String n,Difficulte d){
		super(id,nbP,n,d);
		this.shared = new IAshared();
		this.threadLancee = false;
	}

	@Override
	public int delay() {
		switch(this.difficulte) {
			case FACILE:
				return 1000;
			case MOYEN:
				return 500;
			case DIFFICILE:
				return 0;
			default:
				return 0;
		}
	}
	
	
	@Override
	public Couple<Position,Position> prochainCoup(Plateau plateau,ArrayList<ArrayList<Integer>> scores) {
		if(this.threadLancee) {
			Couple<Position,Position> tmp = this.shared.getCoupCalcule();
			if(tmp != null) {
				this.threadLancee = false;
			}
			return tmp;
		} else {
			new IAthread(super.difficulte,plateau, super.id(),scores,this.shared);
			this.threadLancee = true;
			return null;
		}
	}

	
	
	@Override
	public Position prochainePosePingouin(Plateau plateau) {
		if(this.threadLancee) {
			Position tmp = this.shared.getPoseCalcule();
			if(tmp != null) {
				this.threadLancee = false;
			}
			return tmp;
		} else {
			new IAthread(super.difficulte,plateau, super.id(),this.shared);
			this.threadLancee = true;
			return null;
		}
	}
	
	@Override
	public boolean estIA() {
		return true;
	}
}
