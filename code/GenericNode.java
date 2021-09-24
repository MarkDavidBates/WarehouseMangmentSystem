package sample;

public class GenericNode<N> {

    public GenericNode next = null;
    private N contents;

    public N getContents() {
        return contents;
    }

    public void setContents(N contents) {
        this.contents = contents;
    }
}
