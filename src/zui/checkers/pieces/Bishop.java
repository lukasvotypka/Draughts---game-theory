package zui.checkers.pieces;

import java.awt.Image;

import zui.checkers.agents.Agent;

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

}
