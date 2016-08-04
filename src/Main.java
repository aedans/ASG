import game.renderer.DisplayManager;
import game.renderer.data.Loader;
import game.Game;
import game.renderer.Renderer;

/**
 * Created by Aedan Smith on 5/23/2016.
 * <p>
 * The Main class for ASG
 */

public class Main {

    /**
     * VM Options: -Djava.library.path=[LWJGL Path here]
     *
     * TODO: Add fullscreen to args.
     *
     * @param args: 'xRes yRes'
     */
    public static void main(String[] args) throws Exception {
        // Initializes the game
        DisplayManager.createDisplay(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false, "ASG");
        Game.initialize();

        // Main game loop
        while (!DisplayManager.isCloseRequested()) {
            DisplayManager.updateDisplay();
            Game.update();
            Game.render();
        }

        // Cleans up OpenGL stuff
        Loader.cleanUp();
        Renderer.compositeShader.cleanUp();
        Renderer.lightShader.cleanUp();
        DisplayManager.closeDisplay();
    }

}