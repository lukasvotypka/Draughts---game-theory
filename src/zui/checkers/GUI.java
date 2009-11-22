package zui.checkers;

/**
 *
 * @author miso, lukas
 */
public interface GUI {

    /**
     * Velkost grafickej reprezentacie figurky v pixeloch.
     */
    public static final int PIECE_SIZE = 50;
    
    void setAgentOnTurnHighlighted(int agentId);

    void showMessage(String message);
    
    /**
     * Prekresli/updatne hraciu plochu.
     */
    void repaintBoard();

}
