package zui.checkers.pieces;

import java.awt.Image;
import java.util.List;
import java.util.Set;

import zui.checkers.agents.Agent;
import zui.checkers.game.Move;

/**
 * Kralovna.
 * 
 * @author miso
 *
 */
public class Queen extends Piece {

    public Queen(Agent agent) {
        super(agent);
    }

    @Override
    protected String getImageId() {
        return "queen";
    }

	@Override
	public Set<Move> getValidSteps() {
		// TODO Auto-generated method stub
		return null;
	}
    
    

}
