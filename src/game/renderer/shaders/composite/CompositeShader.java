package game.renderer.shaders.composite;

import org.lwjgl.util.vector.Matrix4f;

public class CompositeShader extends game.renderer.shaders.Shader {

    private static final String SHADER_PATH = ".\\src\\game\\renderer\\shaders\\composite\\";
	private static final String VERTEX_FILE = SHADER_PATH + "composite.vsh";
	private static final String FRAGMENT_FILE = SHADER_PATH + "composite.fsh";

    private int transformationMatrixLocation;

	public CompositeShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

    @Override
    protected void getAllUniformLocations() {
		transformationMatrixLocation = super.getUniformLocation("transformationMatrix");
	}

    @Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}

	public void loadTransformationMatrix(Matrix4f matrix4f){
        super.loadMatrix(transformationMatrixLocation, matrix4f);
    }

}
