package com.aedan.ai.treeai;

/**
 * Created by Aedan Smith on 6/13/2016.
 */

public abstract class TreeAI<T> {

    public TreeAI(){
        this.initialize();
    }

    public int getScore(TreeAIObject object, T t){
        Integer breakValue = getBreakValue(object, t);
        if (breakValue != null)
            return breakValue;
        else {
            t = modifyParameters(t);
            return sumSubObjects(object.getSubObjects(), t);
        }
    }

    protected T modifyParameters(T t){
        return t;
    }

    protected int sumSubObjects(TreeAIObject[] subObjects, T t){
        int objScoreSum = 0;
        for (TreeAIObject subObject : subObjects)
            objScoreSum += this.getScore(subObject, t);
        return objScoreSum/subObjects.length;
    }

    protected abstract void initialize();

    protected abstract Integer getBreakValue(TreeAIObject object, T t);

}