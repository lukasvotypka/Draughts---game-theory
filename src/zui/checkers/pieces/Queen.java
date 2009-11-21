package zui.checkers.pieces;

import java.awt.Image;

import zui.checkers.agents.Agent;

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

}
