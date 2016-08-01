package acklib.utils.misc;

/**
 * @author hacke
 * Holder class to hold a value of generic type.
 * This helps solve problems with lambdas where you cannot modify variables outsid of the
 * function body
 */
public final class Holder <T> {

    private T data;

    public Holder(final T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object obj) {
        return obj != this && obj instanceof Holder && ((Holder) obj).data.equals(this.data);
    }

    @Override
    public String toString() {
        return "Holder{" +
                "data=" + data +
                '}';
    }
}
