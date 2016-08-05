package game.gamestates.inclientgamestate;

import game.gui.GUIList;
import game.renderer.data.RenderList;
import game.renderer.data.Renderable;
import game.renderer.math.Viewport;
import game.renderer.Renderer;
import game.gamestates.GameState;
import game.gamestates.inclientgamestate.entities.player.controller.AIController;
import game.gamestates.inclientgamestate.entities.player.controller.HostController;
import game.gamestates.inclientgamestate.entities.player.Player;
import game.gamestates.inclientgamestate.entities.structures.Base;

/**
 * Created by Aedan Smith on 7/6/2016.
 *
 * The Client GameState for Player vs. AI Games.
 */

// TODO: Comment.
public class InClientGameState extends GameState {

    /**
     * The Map and RenderList for the InClientGameState.
     */
    public Map map;

    /**
     * The RenderList for all the GUIs of the InClientGameState.
     */
    public GUIList guis = new GUIList();

    /**
     * The Bases for the red and blue team.
     */
    public Base redBase, blueBase;

    /**
     * The array of Players in the game. (Player 0 is the human player).
     */
    public Player[] players = new Player[8];

    /**
     * Default InClientGameState constructor
     */
    public InClientGameState() {
        // Creates a new Map
        map = new Map(75, 75);
        map.generate();

        // Creates the rad and blue base.
        redBase = new Base(true, 288, 288);
        blueBase = new Base(false, 4448, 4448);

        // Creates the human and AI Players.
        players = new Player[]{
                new Player(new HostController(), true, redBase.getPosition().getPixelX(), redBase.getPosition().getPixelX()),
//                new Player(new AIController(1), true, redBase.getPixelX(), redBase.getPixelY()),
//                new Player(new AIController(2), true, redBase.getPixelX(), redBase.getPixelY()),
//                new Player(new AIController(3), true, redBase.getPixelX(), redBase.getPixelY()),
//                new Player(new AIController(4), false, blueBase.getPixelX(), blueBase.getPixelY()),
//                new Player(new AIController(5), false, blueBase.getPixelX(), blueBase.getPixelY()),
//                new Player(new AIController(6), false, blueBase.getPixelX(), blueBase.getPixelY()),
//                new Player(new AIController(7), false, blueBase.getPixelX(), blueBase.getPixelY())
        };

        // Initializes the AIs.
        for (int i = 1; i < players.length; i++)
            ((AIController) players[i].getController()).getAI().ai = players[i];

        // Adds Bases and Players to the Map.
        map.add(redBase);
        map.add(blueBase);
        map.add(players);

        // Tells the Viewport to focus on the human player.
        Viewport.focusOn(players[0]);
    }

    /**
     * See game.gamestates.GameState documentation.
     */
    @Override
    public void update() {
        map.update();
        guis.update();
        Viewport.update();
    }

    /**
     * See game.gamestates.GameState documentation.
     */
    @Override
    public void render() {
        Renderer.prepare();
        Renderer.render(map, Renderer.Shader.LIGHT);
        Renderer.drawBlackBars();
        Renderer.render(guis, Renderer.Shader.COMPOSITE);
    }

    /**
     * See game.gamestates.GameState documentation.
     */
    @Override
    public RenderList findContainer(Renderable r){
        if (map.contains(r))
            return map;
        if (guis.contains(r))
            return guis;
        return null;
    }

}
