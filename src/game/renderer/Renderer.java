package game.renderer;

import game.gamestates.inclientgamestate.World;
import game.gamestates.inclientgamestate.entities.Entity;
import game.renderer.annotations.AlwaysLit;
import game.renderer.lights.LightList;
import game.renderer.annotations.Invisible;
import game.renderer.annotations.ConstRender;
import game.renderer.data.RenderList;
import game.renderer.data.Renderable;
import game.renderer.math.Position;
import game.renderer.math.Viewport;
import game.renderer.textures.Textures;
import game.renderer.shaders.CompositeShader;
import game.renderer.shaders.LightShader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.util.ArrayList;

public class Renderer {

    /**
     * The Composite ShaderType to be used with GUIs.
     */
    public static CompositeShader compositeShader = new CompositeShader();

    /**
     * The Light ShaderType to be used with in-game Entities.
     */
    public static LightShader lightShader = new LightShader();

    /**
     * The RenderList of BlackBars to be rendered.
     */
    private static BlackBars blackBars = new BlackBars();

    static {
        // Enables Transparency.
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    /**
     * Prepares the Renderer to render a frame.
     */
    public static void prepare() {
        // Clears the Display.
        GL11.glClearColor(0, 0, 0, 1);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    /**
     * Renders a RenderList to the Display.
     * <p>
     *
     * @param toRender: The RenderList to render.
     * @param type:   The ShaderType to render the RenderList with.
     */
    public static void render(RenderList<? extends Renderable> toRender, ShaderType type) {
        switch (type){
            case COMPOSITE:
                renderComposite(toRender);
                break;
            case LIGHT:
                renderLight(toRender);
                break;
            default:
                System.err.println("Unrecognized Shader: " + type);
                break;
        }
    }

    /**
     * Renders a RenderList to the Display.
     *
     * @param toRender: The RenderList to Render
     */
    private static void renderComposite(RenderList<? extends Renderable> toRender) {
        for (int i = toRender.numTextures - 1; i >= 0; i--)
            Renderer.renderComposite(toRender.get(i));
    }

    /**
     * Renders a RenderList to the Display with lighting.
     *
     * @param toRender: The RenderList to Render
     */
    private static void renderLight(RenderList<? extends Renderable> toRender) {
        for (int i = toRender.numTextures - 1; i >= 0; i--)
            Renderer.renderLight(toRender.get(i), ((World) toRender).getLightList());
    }

    /**
     * Renders an ArrayList of Renderables to the Display.
     * <p>
     * TODO: Comment.
     * TODO: Improve offscreen detection.
     *
     * @param toRender: The ArrayList of Renderables to Render.
     */
    private static void renderComposite(ArrayList<? extends Renderable> toRender) {
        compositeShader.start();
        if (toRender.size() == 0)
            return;
        GL30.glBindVertexArray(toRender.get(0).getTexturedModel().getModelID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, toRender.get(0).getTexturedModel().getTrueTextureID());
        for (Renderable r : toRender) {
            if (r.getClass().isAnnotationPresent(Invisible.class) || r.getTexturedModel().getTrueTextureID() == Textures.blankTextureID)
                continue;
            Position relativePos = Viewport.getRelativePosition(r.getPosition());
            if (r.getClass().isAnnotationPresent(ConstRender.class) ||
                    (!(relativePos.getPixelX() > 1.3) && !(relativePos.getOpenGLX() < -1.3)
                            && !(relativePos.getOpenGLY() > 1.3) && !(relativePos.getOpenGLY() < -1.3))) {
                r.onRender();
                compositeShader.loadTransformationMatrix(r.getTransformationMatrix());
                GL11.glDrawElements(GL11.GL_TRIANGLES, 8, GL11.GL_UNSIGNED_INT, 0);
            }
        }
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL30.glBindVertexArray(0);
        compositeShader.stop();
    }

    /**
     * Renders an ArrayList of Renderables to the Display with lighting.
     * <p>
     * TODO: Comment.
     * TODO: Improve offscreen detection.
     *
     * @param toRender: The ArrayList of Renderables to Render.
     */
    private static void renderLight(ArrayList<? extends Renderable> toRender, LightList lightList) {
        lightShader.start();
        if (toRender.size() == 0)
            return;
        GL30.glBindVertexArray(toRender.get(0).getTexturedModel().getModelID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, toRender.get(0).getTexturedModel().getTrueTextureID());
        for (Renderable r : toRender) {
            Position relativePos = Viewport.getRelativePosition(r.getPosition());
            if (r.getClass().isAnnotationPresent(ConstRender.class) ||
                    !(relativePos.getOpenGLX() > 1.3) && !(relativePos.getOpenGLX() < -1.3)
                            && !(relativePos.getOpenGLY() > 1.3) && !(relativePos.getOpenGLY() < -1.3)) {
                r.onRender();
                if (r.getClass().isAnnotationPresent(Invisible.class))
                    continue;
                lightShader.loadTransformationMatrix(r.getTransformationMatrix());
                if (!r.getClass().isAnnotationPresent(AlwaysLit.class))
                    lightShader.loadLightDistance(lightList.getMostImportantLight((Entity) r), (Entity) r);
                else
                    lightShader.loadLightDistance(1f);
                GL11.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_INT, 0);
            }
        }
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL30.glBindVertexArray(0);
        lightShader.stop();
    }

    /**
     * Renders BlackBars.
     */
    public static void drawBlackBars() {
        renderComposite(blackBars);
    }

    /**
     * Cleans up the Renderer
     */
    public static void cleanup(){
        Renderer.compositeShader.cleanUp();
        Renderer.lightShader.cleanUp();
    }

    /**
     * Enum containing valid Shaders.
     */
    public enum ShaderType {

        COMPOSITE, LIGHT

    }

}
