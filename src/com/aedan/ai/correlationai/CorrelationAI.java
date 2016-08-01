package com.aedan.ai.correlationai;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * An abstract AI class that uses decision trees to find the best possible action.
 */

public abstract class CorrelationAI {

    public CorrelationAI(){
        this.initialize();
    }

    /**
     * Gets the best possible action given an array of possible actions.
     *
     * @param possibleActions: The array of possible actions.
     * @return int: The index of the best action.
     * @throws IllegalArgumentException if possibleActions has numTextures 0.
     */
    @NotNull
    protected int getBestAction(Neuron[] possibleActions) throws IllegalArgumentException {
        if (possibleActions.length == 0)
            //noinspection ImplicitArrayToString
            throw new IllegalArgumentException(
                    possibleActions + " contains 0 elements.");
        if (possibleActions.length == 1)
            return 0;

        try {
            int bestAction = 0;
            float bestActionEffect = -1.0f;
            for (int i = 0; i < possibleActions.length; i++) {
                if (possibleActions[i].getEffect() > bestActionEffect) {
                    bestAction = i;
                    bestActionEffect = possibleActions[i].getEffect();
                }
            }

            return bestAction;
        } catch (UnavailableNeuronEffectException e){
            throw new IllegalArgumentException(
                    "Could not get Neuron effect: " + e.getMessage());
        }
    }

    /**
     * Gets the best possible action given a list of possible actions.
     *
     * @param possibleActions: The list of possible actions
     * @return int: The index of the best action.
     * @throws IllegalArgumentException if possibleActions has numTextures 0.
     */
    @NotNull
    protected int getBestAction(List<Neuron> possibleActions) throws IllegalArgumentException {
        if (possibleActions.size() == 0)
            throw new IllegalArgumentException(
                    possibleActions.toString() + " contains 0 elements.");
        if (possibleActions.size() == 1)
            return 0;

        try {
            int bestAction = 0;
            float bestActionEffect = -1.0f;
            for (int i = 0; i < possibleActions.size(); i++) {
                if (possibleActions.get(i).getEffect() > bestActionEffect) {
                    bestAction = i;
                    bestActionEffect = possibleActions.get(i).getEffect();
                }
            }

            return bestAction;
        } catch (UnavailableNeuronEffectException e){
            throw new IllegalArgumentException(
                    "Could not get Neuron effect: " + e.getMessage());
        }
    }

    /**
     * Abstract method called upon AI construction.
     */
    protected abstract void initialize();

    /**
     * Abstract method to be used by other classes to get the AI's decision.
     *
     * @return int: The id of the best action.
     * @throws Exception
     */
    public abstract int getBestAction() throws Exception;

}