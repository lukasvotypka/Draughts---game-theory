package zui.checkers.pieces;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import zui.checkers.agents.Agent;

/**
 * Trieda reprezentujuca figurku patriacu konktretnemu hracovi/agentovi.
 * 
 * @author miso, lukas
 *
 */
public abstract class Piece {
    
    private Agent agent;
    
    private Map map;
    
    private int x;
    
    private int y;
    
    private Image image = null;
    
    protected Piece(Agent agent) {
        this.agent = agent;
    }
    
    protected void setMap(Map map) {
        this.map = map;
    }
    
    protected void setX(int x) {
        this.x = x;
    }
    
    protected void setY(int y) {
        this.y = y;
    }
    
    /**
     * @return Hrac/agent, ktoremu patri figurka na tomto policku, alebo
     * <tt>null</tt> ak na tomto policku nestoji ziadna figurka.
     */
    public Agent getAgent() {
        return agent;
    }
    
    /**
     * @return Vrati "pravu" diagonalu prechadzajucu polickom, na ktorom stoji
     * tato figurka.
     */
    public List<Piece> getRDiagonal() {
        return map.getRDiagonalAt(x, y);
    }
    
    /**
     * @return Vrati "lavu" diagonalu prechadzajucu polickom, na ktorom stoji
     * tato figurka.
     */
    public List<Piece> getLDiagonal() {
        return map.getLDiagonalAt(x, y);
    }
    
    /**
     * @return Image figurky.
     */
    public Image getImage() {
        if (image == null) {
            image = new ImageIcon(Piece.class.getResource(
                    "/zui/checkers/img/" + getImageId() + getAgent().attackDir + ".png")).getImage();
        }
        return image;
    }
    
    protected abstract String getImageId();
    
}
