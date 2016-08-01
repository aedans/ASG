import game.renderer.DisplayManager;
import game.renderer.Loader;
import game.Game;
import game.renderer.Renderer;

/**
 * Created by Aedan Smith on 5/23/2016.
 */

public class Main {

    /**
     * @param args: xRes, yRes
     */
    public static void main(String[] args){
        try {
            DisplayManager.createDisplay(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false, "Consumables");
            Game.initialize();
            while (!DisplayManager.isCloseRequested()) {
                DisplayManager.updateDisplay();
                Game.currentGameState().update();
                Game.currentGameState().render();
            }
            Loader.cleanUp();
            Renderer.lights.cleanUp();
            DisplayManager.closeDisplay();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}