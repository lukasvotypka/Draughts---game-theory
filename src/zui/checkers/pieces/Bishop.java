package zui.checkers.pieces;

import java.awt.Image;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import zui.checkers.agents.Agent;
import zui.checkers.game.Move;

/**
 * Pesiak.
 * 
 * @author miso
 *
 */
public class Bishop extends Piece {

    public Bishop(Agent agent) {
        super(agent);
    }

    @Override
    protected String getImageId() {
        return "bishop";
    }

	@Override
	public Set<Move> getValidSteps( ) {
		Set<Move> moves = new HashSet();
		
		Move mr = getRValid(getRDiagonal(), false, false);
		moves.add(mr);
		Move ml = getRValid(getRDiagonal(), false, false);
		moves.add(ml);
		
		//TODO spravit rekurzivne zistovanie moznosti
		if(mr.score > 0) {
			
		}
		
		if(ml.score > 0) {
			
		}
		
		return moves;
	}
	
	private Move getRValid( List<Piece> Diagonal, boolean left, boolean onlyScore) {
		
		int indexMe = Diagonal.indexOf(this);;
		
		int length = 0;
		int to;
		if(getAgent().attackDir == 1) {
			to = Diagonal.size();
			
		}else{
			to = 0;
			
		}
		
		int score = 0;
		for(int i = indexMe; (i * getAgent().attackDir) < to; i += getAgent().attackDir) {
			length += getAgent().attackDir;
			
			if( Math.abs(length) > 1) { //max 1 figurka / skok
				return null;
			}
			
			Piece piece = Diagonal.get(i);
			if(piece == null) { // volne policko hracej plochy
				if(onlyScore) { 
					if(Math.abs(length) == 0 ) { // volne policko hned v prvom pokuse znamena ze neskorujem
						return null;
					}
				}
				
				return getMove(length, left, score);
			}else{ //obsadene policko
				if(piece.getAgent().equals(this.getAgent())) { //nemozem preskakovat svojich
					return null;
				}
				
				score++;
			}
		}
		
		return null;
	}
    
	
	private Move getMove(int length, boolean left, int score) {
		if(left) {
			new Move(this, getX()+(length * -1), getY()+length, true, score);
		}else{
			return new Move(this, getX()+length, getY()+length, true, score);
		}
		
		return null;
	}

}
