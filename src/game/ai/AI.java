package game.ai;

import com.aedan.ai.correlationai.CorrelationAI;
import com.aedan.ai.correlationai.Neuron;
import com.aedan.ai.correlationai.UnavailableNeuronEffectException;
import game.gamestates.inclientgamestate.entities.player.Player;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class AI extends CorrelationAI {

    // TODO: Finish AI.

    /**
     * The Player the AI Controls.
     */
    public Player ai;

    private Neuron standStill = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            return -.5f;
        }
    };
    private Neuron moveTowardsEnemyBase = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            return 1;
        }
    };
    private Neuron moveRight = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            if (!ai.canMoveRight())
                return standStill.getEffect();
            if (ai.getPixelX() < ai.getOpponentBase().getPixelX())
                return moveTowardsEnemyBase.getEffect();
            else return 0;
        }
    };
    private Neuron moveLeft = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            if (!ai.canMoveLeft())
                return standStill.getEffect();
            if (ai.getPixelX() > ai.getOpponentBase().getPixelX())
                return moveTowardsEnemyBase.getEffect();
            else return 0;
        }
    };
    private Neuron moveUp = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            if (!ai.canMoveUp())
                return standStill.getEffect();
            if (ai.getPixelY() < ai.getOpponentBase().getPixelY())
                return moveTowardsEnemyBase.getEffect();
            else return 0;
        }
    };
    private Neuron moveDown = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            if (!ai.canMoveDown())
                return standStill.getEffect();
            if (ai.getPixelY() > ai.getOpponentBase().getPixelY())
                return moveTowardsEnemyBase.getEffect();
            else return 0;
        }
    };
    private Neuron moveUpRight = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            return (moveUp.getEffect() + moveRight.getEffect())/1.5f;
        }
    };
    private Neuron moveDownRight = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            return (moveDown.getEffect() + moveRight.getEffect())/1.5f;
        }
    };
    private Neuron moveDownLeft = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            return (moveDown.getEffect() + moveLeft.getEffect())/1.5f;
        }
    };
    private Neuron moveUpLeft = new Neuron() {
        @Override
        public float getEffect() throws UnavailableNeuronEffectException {
            return (moveUp.getEffect() + moveLeft.getEffect())/1.5f;
        }
    };

    /**
     * See com.aedan.ai.correlationai.CorrelationAI documentation.
     */
    @Override
    protected void initialize() {

    }

    /**
     * See com.aedan.ai.correlationai.CorrelationAI documentation.
     */
    @Override
    public int getBestAction() throws Exception {
        return getBestAction(new Neuron[]{
                standStill,moveUp,moveDown,moveLeft,moveRight,moveUpRight,moveDownRight,moveDownLeft,moveUpLeft
        });
    }

}
