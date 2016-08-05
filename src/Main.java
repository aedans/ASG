import game.renderer.DisplayManager;
import game.renderer.data.Loader;
import game.Game;
import game.renderer.Renderer;
import game.util.Logger;

import java.util.IntSummaryStatistics;

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
     * Current 'best' resolution: 1540x900.
     *
     * @param args: 'xRes yRes'
     */
    public static void main(String[] args) throws Exception {
        Logger.addOutputStream(System.err);
        if(args.length != 2){
            Logger.println("usage: ./asg width height");
            return;
        }
        int width;
        int height;
        try{
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        }catch (NumberFormatException nfe){
            Logger.println(nfe.getMessage());
            return;
        }
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
        Renderer.cleanUp();
        DisplayManager.closeDisplay();
    }

}