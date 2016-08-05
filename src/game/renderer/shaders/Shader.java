package game.renderer.shaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public abstract class Shader {

    /**
     * The ID of the ShaderType in OpenGL
     */
    private int programID;

    /**
     * The ID of the Vertex ShaderType in OpenGL.
     */
    private int vertexShaderID;

    /**
     * The ID of the Fragment ShaderType
     */
    private int fragmentShaderID;

    /**
     * The FloatBuffer to be loaded into the TransformationMatrix.
     */
    private static FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(16);

    /**
     * Default ShaderType constructor.
     *
     * @param vertexFile:   The path to the Vertex ShaderType.
     * @param fragmentFile: The path to the Fragment ShaderType.
     */
    public Shader(String vertexFile, String fragmentFile) {
        vertexShaderID = loadShader(vertexFile, GL20.GL_VERTEX_SHADER);
        fragmentShaderID = loadShader(fragmentFile, GL20.GL_FRAGMENT_SHADER);
        programID = GL20.glCreateProgram();
        GL20.glAttachShader(programID, vertexShaderID);
        GL20.glAttachShader(programID, fragmentShaderID);
        bindAttributes();
        GL20.glLinkProgram(programID);
        GL20.glValidateProgram(programID);
        getAllUniformLocations();
    }

    /**
     * Binds an attribute to a VBO.
     *
     * @param attribute:    The attribute to bind.
     * @param variableName: The VBO name.
     */
    protected void bindAttribute(int attribute, String variableName) {
        GL20.glBindAttribLocation(programID, attribute, variableName);
    }

    /**
     * Gets the location of a uniform variable.
     *
     * @param uniformName: The name of the uniform variable.
     * @return int: The position of the uniform variable.
     */
    protected int getUniformLocation(String uniformName) {
        return GL20.glGetUniformLocation(programID, uniformName);
    }

    /**
     * Starts the ShaderType.
     */
    public void start() {
        GL20.glUseProgram(programID);
    }

    /**
     * Stops the ShaderType.
     */
    public void stop() {
        GL20.glUseProgram(0);
    }

    /**
     * Cleans up the ShaderType.
     */
    public void cleanUp() {
        stop();
        GL20.glDetachShader(programID, vertexShaderID);
        GL20.glDetachShader(programID, fragmentShaderID);
        GL20.glDeleteShader(vertexShaderID);
        GL20.glDeleteShader(fragmentShaderID);
        GL20.glDeleteProgram(programID);
    }

    /**
     * Loads a float into the ShaderType.
     *
     * @param location: The float location (see getUniformLocation).
     * @param value:    The value of the float.
     */
    protected void loadFloat(int location, float value) {
        GL20.glUniform1f(location, value);
    }

    /**
     * Loads a vector into the ShaderType.
     *
     * @param location: The vector location (see getUniformLocation).
     * @param vector:   The value of the vector.
     */
    protected void loadVector(int location, Vector3f vector) {
        GL20.glUniform3f(location, vector.x, vector.y, vector.z);
    }

    /**
     * Loads a boolean into the ShaderType.
     *
     * @param location: The boolean location (see getUniformLocation).
     * @param b:        The value of the boolean.
     */
    protected void loadBoolean(int location, boolean b) {
        GL20.glUniform1f(location, b ? 1 : 0);
    }

    /**
     * Loads a Matrix4f into the ShaderType.
     *
     * @param location: The Matrix4f location (see getUniformLocation).
     * @param matrix4f: The value of the Matrix4f.
     */
    protected void loadMatrix(int location, Matrix4f matrix4f) {
        matrix4f.store(matrixBuffer);
        matrixBuffer.flip();
        GL20.glUniformMatrix4(location, false, matrixBuffer);
    }

    /**
     * Loads a shader into OpenGL.
     *
     * @param file: The ShaderType file to load.
     * @param type: The type of ShaderType to load
     *              (GL20.GL_VERTEX_SHADER / GL20.GL_FRAGMENT_SHADER).
     * @return int: The location of the ShaderType in OpenGL.
     */
    private static int loadShader(String file, int type) {
        StringBuilder shaderSource = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                shaderSource.append(line).append("//\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        int shaderID = GL20.glCreateShader(type);
        GL20.glShaderSource(shaderID, shaderSource);
        GL20.glCompileShader(shaderID);
        if (GL20.glGetShaderi(shaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            System.err.println(GL20.glGetShaderInfoLog(shaderID, 500));
            System.err.println("Could not compile shader!");
            System.exit(1);
        }
        return shaderID;
    }

    /**
     * Required Function: Binds all VBOs.
     */
    protected abstract void bindAttributes();

    /**
     * Required Function: Gets the locations of all uniform variables and stores them
     * for later use.
     */
    protected abstract void getAllUniformLocations();

}
