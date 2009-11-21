/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zui.checkers;

/**
 *
 * @author miso
 */
public interface GUI {

    void setAgentOnTurnHighlighted(int agentId);

    void showMessage(String message);
    
    /**
     * Prekresli/updatne hraciu plochu.
     */
    void repaintBoard();

}
