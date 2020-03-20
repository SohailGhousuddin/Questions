package Graphs;

public class Neighbor {
    int vertexNumber;
    Neighbor next;

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public Neighbor getNext() {
        return next;
    }

    public void setNext(Neighbor next) {
        this.next = next;
    }

    public Neighbor(int vertexNumber, Neighbor next) {
        this.vertexNumber = vertexNumber;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Neighbor{" +
                "vertexNumber=" + vertexNumber +
                ", next=" + next +
                '}';
    }
}
