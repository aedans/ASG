package game;

import game.gamestates.GameState;
import game.gamestates.bootgamestate.BootGameState;
import game.gamestates.inclientgamestate.InClientGameState;
import game.gamestates.mainmenugamestate.MainMenuGameState;

/**
 * Created by Aedan Smith on 5/23/2016.
 */

public class Game {

    public static BootGameState bootGameState = new BootGameState();
    public static MainMenuGameState menuGameState = new MainMenuGameState();
    public static InClientGameState inClientGameState = new InClientGameState();

    private static int activeGameState = 2;
    private static GameState[] gameStates = new GameState[]{
            bootGameState, menuGameState, inClientGameState
    };

    public static void initialize(){

    }

    public static GameState currentGameState(){
        return Game.gameStates[Game.activeGameState];
    }

    public static void setGameState(int gameState){
        activeGameState = gameState;
    }

}