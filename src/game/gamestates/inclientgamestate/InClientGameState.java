package game.gamestates.inclientgamestate;

import game.gamestates.inclientgamestate.guis.PlayerInventory;
import game.gamestates.inclientgamestate.items.TestItem;
import game.gui.GUIList;
import game.item.ItemEntity;
import game.renderer.Viewport;
import game.sprites.SpriteList;
import game.renderer.Renderer;
import game.gamestates.GameState;
import game.gamestates.inclientgamestate.entities.player.controller.AIController;
import game.gamestates.inclientgamestate.entities.player.controller.HostController;
import game.gamestates.inclientgamestate.entities.player.Player;
import game.gamestates.inclientgamestate.entities.structures.Base;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public class InClientGameState extends GameState {

    public Map map;

    public SpriteList sprites = new SpriteList();
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
                new Player(new HostController(), true, redBase.getPixelX(), redBase.getPixelY()),
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

        sprites.add(redBase);
        sprites.add(blueBase);
        sprites.add(players);
        sprites.add(map.getSprites());

        guis.add(playerInventory);
        playerInventory.add(new TestItem(), 1);
        playerInventory.add(new TestItem(), 1);

        sprites.add(new ItemEntity(new TestItem(), 400, 400));

        Viewport.focusOn(players[0]);
    }

    @Override
    public void update() {
        sprites.update();
        guis.update();
        Viewport.update();
    }

    @Override
    public void render() {
        Renderer.prepare();
        Renderer.render(sprites, Renderer.lightShader);
        Renderer.render(guis, Renderer.compositeShader);
    }

}
