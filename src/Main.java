import acklib.utils.misc.ArgumentParseException;
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
     * TODO: .info files.
     *
     * @param args: 'xRes yRes'
     */
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new ArgumentParseException("Usage: width height");
            }
            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);

            // Initializes the game
            DisplayManager.createDisplay(width, height, false, "ASG");
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
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}