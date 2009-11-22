package zui.checkers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import zui.checkers.agents.ABCutAgent;
import zui.checkers.agents.Agent;
import zui.checkers.agents.CutOffSearchAgent;
import zui.checkers.agents.HumanAgent;
import zui.checkers.agents.MinimaxAgent;
import zui.checkers.pieces.Bishop;
import zui.checkers.pieces.Map;
import zui.checkers.pieces.Queen;

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
        } else if (agentId == 2) {
            agent02 = createAgent(agentType, attackDir, timeToThink);
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
            
            // TODO: 
        }
        
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
