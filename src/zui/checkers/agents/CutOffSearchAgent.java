package zui.checkers.agents;

import zui.checkers.Game;
import zui.checkers.game.Move;

public class CutOffSearchAgent extends Agent {

    public CutOffSearchAgent(Game game, int timeToThink, int attackDir) {
        super(game, timeToThink, attackDir);
    }

    @Override
    public Move act() {
        return null;
    }

}
