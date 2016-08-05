package game.gamestates.inclientgamestate;

import game.gamestates.inclientgamestate.guis.PlayerInventory;
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
 */

// TODO: Clean up.
// TODO: Comment.
public class InClientGameState extends GameState {

    public Map map;
    public GUIList guis = new GUIList();

    public Base redBase, blueBase;
    public Player[] players = new Player[8];

    public PlayerInventory playerInventory = new PlayerInventory();

    public InClientGameState() {
        map = new Map(75, 75);
        map.generate();

        redBase = new Base(true, 288, 288);
        blueBase = new Base(false, 4448, 4448);
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

        for (int i = 1; i < players.length; i++)
            ((AIController) players[i].getController()).getAI().ai = players[i];

        map.add(redBase);
        map.add(blueBase);
        map.add(players);
        map.add(map.getEntities());

        guis.add(playerInventory);

        Viewport.focusOn(players[0]);
    }

    @Override
    public void update() {
        map.update();
        guis.update();
        Viewport.update();
    }

    @Override
    public void render() {
        Renderer.prepare();
        Renderer.render(map, Renderer.Shader.LIGHT);
        Renderer.drawBlackBars();
        Renderer.render(guis, Renderer.Shader.COMPOSITE);
    }

    /**
     * Returns the RenderList that contains the given Renderable.
     *
     * @param r: The Renderable to find.
     * @return RenderList: The containing Renderable.
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
