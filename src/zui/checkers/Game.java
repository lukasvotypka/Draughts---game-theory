package zui.checkers;

import zui.checkers.agents.ABCutAgent;
import zui.checkers.agents.Agent;
import zui.checkers.agents.CutOffSearchAgent;
import zui.checkers.agents.HumanAgent;
import zui.checkers.agents.MinimaxAgent;
import zui.checkers.pieces.Bishop;
import zui.checkers.pieces.Map;

public class Game {

    public static final String[] supportedAgents = {
        HumanAgent.class.getName(),
        ABCutAgent.class.getName(),
        CutOffSearchAgent.class.getName(),
        MinimaxAgent.class.getName()
    };
    
    public static final String[] supportedAgentsTitles = {
        "Clovek",
        "A-B orezavanie",
        "Cut-off searching",
        "Minimax"
    };
    
    private Agent agent01 = null;
    
    private Agent agent02 = null;
    
    private Agent agentOnTurn = null;
    
    private Map map;
    
    private GUI gui;
    
    public Game(GUI gui) {
        this.gui = gui;
        this.map = new Map();
    }
    
    public void initAgent(int agentId, int agentType, int attackDir, int timeToThink) {
        if (agentId == 1) {
            agent01 = createAgent(agentType, attackDir, timeToThink);
            map.setPiece(1, 1, new Bishop(agent01));
            map.setPiece(2, 2, new Bishop(agent01));
            map.setPiece(3, 1, new Bishop(agent01));
            map.setPiece(4, 2, new Bishop(agent01));
            map.setPiece(5, 1, new Bishop(agent01));
            map.setPiece(6, 2, new Bishop(agent01));
            map.setPiece(7, 1, new Bishop(agent01));
            map.setPiece(8, 2, new Bishop(agent01));
        } else if (agentId == 2) {
            agent02 = createAgent(agentType, attackDir, timeToThink);
            map.setPiece(1, 7, new Bishop(agent02));
            map.setPiece(2, 8, new Bishop(agent02));
            map.setPiece(3, 7, new Bishop(agent02));
            map.setPiece(4, 8, new Bishop(agent02));
            map.setPiece(5, 7, new Bishop(agent02));
            map.setPiece(6, 8, new Bishop(agent02));
            map.setPiece(7, 7, new Bishop(agent02));
            map.setPiece(8, 8, new Bishop(agent02));
        } else {
            throw new IllegalArgumentException("Hrac cislo " + agentId + " nie je validnym hracom.");
        }
    }
    
    private Agent createAgent(int agentType, int attackDir, int timeToThink) {
        try {
            return (Agent) Class.forName(supportedAgents[agentType])
                .getConstructor(Game.class, int.class, int.class)
                .newInstance(this, timeToThink, attackDir);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Nepodarilo sa vytvorit agenta.", e);
        }
    }
    
    public Map getMap() {
        return map;
    }
    
    public void start() {
        if (agent01 == null || agent02 == null) {
            gui.showMessage("Vyberte hracov.");
        } else {
            agentOnTurn = agent01;
            gui.repaintBoard();
            // TODO: 
        }
    }
    
    public void stopAndDestroy() {
        // TODO do mem cleanup
        // agent01.destroy();
        // agent02.destroy();
        // map.destroy();
    }
    
    public Agent getAgentOnTurn() {
        return agentOnTurn;
    }
    
    public int getAgentOnTurnId() {
        if (agentOnTurn == null) {
            return -1;
        } else if (agent01 == agentOnTurn) {
            return 1;
        } else {
            return 2;
        }
    }
    
    /**
     * @return Protihraca agenta <tt>agent</tt>.
     */
    public Agent getOpponent(Agent agent) {
        if (agent == agent01) {
            return agent02;
        } else {
            return agent01;
        }
    }
    
}
