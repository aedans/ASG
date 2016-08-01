package game.renderer;

import game.gamestates.inclientgamestate.entities.Entity;
import game.gamestates.inclientgamestate.entities.lights.AlwaysLit;
import game.gamestates.inclientgamestate.entities.lights.LightList;
import game.gui.Invisible;
import game.gui.OverlaidSprite;
import math.MatrixMath;
import game.renderer.shaders.composite.CompositeShader;
import game.renderer.shaders.lightshader.LightShader;
import game.sprites.SpriteList;
import game.sprites.Textures;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.awt.geom.Point2D;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

public class Renderer {

    public static CompositeShader composite = new CompositeShader();
    public static LightShader lights = new LightShader();

    static {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    public static void prepare(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glClearColor(0, 0, 0, 1);
    }

    public static void render(RenderList toRender){
        if (toRender.getClass() == SpriteList.class)
            for (int i = toRender.depth - 1; i >= 0; i--)
                Renderer.renderLight(toRender.get(i), ((SpriteList)toRender).getLightList());
        else
            for (int i = toRender.depth - 1; i >= 0; i--)
                Renderer.renderComposite(toRender.get(i));
    }

    private static void renderComposite(ArrayList<Renderable> toRender) {
        composite.start();
        if (toRender.size() == 0)
            return;
        GL30.glBindVertexArray(toRender.get(0).getTexturedModel().getModelID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, toRender.get(0).getTexturedModel().getTrueTextureID());
        for (Renderable r : toRender){
            if (r.getClass().isAnnotationPresent(Invisible.class) || r.getTexturedModel().getTrueTextureID() == Textures.blankTextureID)
                continue;
            Point2D.Float relativePos = Viewport.getRelativePosition(r.getOpenGLPosition());
            if (r.getClass().isAnnotationPresent(OverlaidSprite.class) || (!(relativePos.x > 1.3) && !(relativePos.x < -1.3) && !(relativePos.y > 1.3) && !(relativePos.y < -1.3))) {
                r.onRender();
                if (!r.getClass().isAnnotationPresent(OverlaidSprite.class))
                    composite.loadTransformationMatrix(r.getTransformationMatrix());
                else
                    composite.loadTransformationMatrix(MatrixMath.createTransformationMatrix(r.getOpenGLPosition(), 0, 0, 1));
                GL11.glDrawElements(GL11.GL_TRIANGLES, 8, GL11.GL_UNSIGNED_INT, 0);
            }
        }
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL30.glBindVertexArray(0);
        composite.stop();
    }

    // TODO Implement Black Bars

    private static void renderLight(ArrayList<Renderable> toRender, LightList lightList) {
        lights.start();
//        lights.loadBlackBars(DisplayManager.blackBarWidth, 0);
        if (toRender.size() == 0)
            return;
        GL30.glBindVertexArray(toRender.get(0).getTexturedModel().getModelID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, toRender.get(0).getTexturedModel().getTrueTextureID());
        for (Renderable r : toRender){
            Point2D.Float relativePos = Viewport.getRelativePosition(r.getOpenGLPosition());
            if (!(relativePos.x > 1.3) && !(relativePos.x < -1.3) && !(relativePos.y > 1.3) && !(relativePos.y < -1.3)) {
                r.onRender();
                if (r.getClass().isAnnotationPresent(Invisible.class))
                    continue;
                lights.loadTransformationMatrix(r.getTransformationMatrix());
                if (!r.getClass().isAnnotationPresent(AlwaysLit.class))
                    lights.loadLightDistance(lightList.getMostImportantLight((Entity) r), (Entity) r);
                else
                    lights.loadLightDistance(1f);
                GL11.glDrawElements(GL11.GL_TRIANGLES, 8, GL11.GL_UNSIGNED_INT, 0);
            }
        }
        GL20.glDisableVertexAttribArray(1);
        GL30.glBindVertexArray(0);
        lights.stop();
    }

}
