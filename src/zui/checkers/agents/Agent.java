package zui.checkers.agents;

import java.util.Set;

import zui.checkers.Game;
import zui.checkers.game.Move;
import zui.checkers.pieces.Piece;

public abstract class Agent {
    
    /**
     * Smer utoku tohoto hraca/agenta. <tt>1</tt> znaci ze sa hrac
     * pohybuje po y-ovej osi smerom hore, <tt>-1</tt> ze dole.
     */
    public final int attackDir;
    
    private int timeToThink = -1;
    
    private Game game;
    
    /**
     * @param game Hra, ktoru tento hrac bude hrat.
     * @param timeToThink Casovy limit, ktory ma tento hrac na premyslenie tahu. <tt>-1</tt>
     * znaci neobmedzeny cas.
     * @param attackDir Smer utoku. Pozri {@link #attackDir}.
     */
    public Agent(Game game, int timeToThink, int attackDir) {
        if (Math.abs(attackDir) != 1) {
            throw new IllegalArgumentException("Hodnota musi byt 1 alebo -1. [" + attackDir + "]");
        }
        this.attackDir = attackDir;
        this.game = game;
    }
    
    /**
     * @return Vrati protihraca tohoto agenta.
     */
    public Agent getOpponent() {
        return game.getOpponent(this);
    }
    
    /**
     * @return Vrati zoznam figurok tohoto hraca.
     */
    public Set<Piece> getPieces() {
        return game.getMap().getPieces(this);
    }
    
    /**
     * @return Vrati zoznam figurok protihraca.
     */
    public Set<Piece> getOpponentPieces() {
        return game.getMap().getPieces(getOpponent());
    }
    
    /**
     * Metoda je zavolana, ked je agent na tahu.
     * <p>Tato metoda bude zavolana v danom casovom limite viac krat, ak agent
     * oznaci vrateny vysledok ako "docasny" ({@link Move#tmp}). Ak agent oznaci
     * vrateny vysledok ako jeho definitivne rozhodnutie (<tt>{@link Move#tmp} == false</tt>), tak
     * uz tato metoda nebude v danom tahu viac zavolana.
     * <ul>
     * <li>Ak agent vrati pocas vsetkych volani tejto metody v danom tahu iba docasne vysledky, tak
     * sa za konecne rozhodnutie agenta povazuje ten posledny.</li>
     * <li>Ak agent nevrati ziadny vysledok do vyprsania casoveho limitu, tak tah prepada v prospech supera.</li>
     * </ul>
     * </p>
     */
    public abstract Move act();
    
}
