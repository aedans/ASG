package com.aedan.ai.correlationai;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * An abstract class used to represent decisions in a Correlation AI. A Neuron can be a
 * parent or child node to other Neurons. A group of Neurons is treated like a tree.
 */

public abstract class Neuron {

    /**
     * List of child nodes.
     */
    private ArrayList<Neuron> linkedNeurons = new ArrayList<>();

    /**
     * Gets the total effect of all children of this node.
     *
     * @return float: The total effect of all children of this node.
     * @throws UnavailableNeuronEffectException if any child Neurons throw an Exception.
     */
    protected float averageNeuronEffects() throws UnavailableNeuronEffectException {
        float f = 0;
        for (Neuron n : linkedNeurons)
            f += n.getEffect();
        return f;
    }

    /**
     * Links a Neuron with this as the parent node.
     *
     * @param neuron: The child Neuron to link to this node.
     * @return this.
     */
    @NotNull
    public Neuron linkNeuron(Neuron neuron) {
        this.linkedNeurons.add(neuron);
        return this;
    }

    /**
     * Deletes all children of this node.
     */
    protected void resetNeurons() {
        this.linkedNeurons = new ArrayList<>();
    }

    /**
     * Gets the total effect of this node. If not a discrete node, should return the
     * average off all linked Neurons' effects.
     *
     * @return float between -1 and 1: The effect of this node.]
     * @throws UnavailableNeuronEffectException
     */
    public abstract float getEffect() throws UnavailableNeuronEffectException;

    @Override
    public String toString() {
        try {
            if (this.linkedNeurons.size() == 0)
                return "Discrete_Neuron[" + String.valueOf(getEffect() + "]");
            else
                return "Linked_Neuron[" + String.valueOf(getEffect() + "]");
        } catch (Exception ignored){
            return "Errored_Neuron[Could not get effect]";
        }
    }

}