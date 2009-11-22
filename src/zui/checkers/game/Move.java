package zui.checkers.game;

import zui.checkers.pieces.Piece;

/**
 * Akcia reprezentujuca pohyb figurky na suradnice <tt>(x, y)</tt>.
 * 
 * @author miso
 *
 */
public class Move {

    public final Piece piece;
    
    /**
    * <tt>true</tt> ak tento tah nie je definitivnym
    * rozhodnutim agenta, t.z. ze sa este moze zmenit.
    */
    public final boolean tmp;
    
    public final int x;
    
    public final int y;
    
    public final int score;
    
    /**
     * @param piece Figurka, ktoru chceme tahat.
     * @param x x-ova suradnica tahu
     * @param y y-ova suradnica tahu
     * @param tmp <tt>true</tt> ak tento tah nie je definitivnym
     * rozhodnutim agenta, t.z. ze sa este moze zmenit.
     */
    public Move(Piece piece, int x, int y, boolean tmp, int score) {
        this.piece = piece;
        this.x = x;
        this.y = y;
        this.tmp = tmp;
        this.score = score;
    }
    
}
