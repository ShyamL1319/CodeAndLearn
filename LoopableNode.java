import java.util.Iterator;

public class LoopableNode implements Iterable<LoopableNode> {
    int data;
    LoopableNode next;

    public LoopableNode(int data) {
        this.data = data;
        this.next = null;
    }

    public LoopableNode(int data, LoopableNode next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {

    }

    @Override
    public Iterator<LoopableNode> iterator() {
        return new nodeIterator(this);
    }

    public static class nodeIterator implements Iterator<LoopableNode> {
        LoopableNode root;

        nodeIterator(LoopableNode root) {
            this.root = root;
        }

        @Override
        public boolean hasNext() {
            return root != null;
        }

        @Override
        public LoopableNode next() {
            LoopableNode temp = root;
            root = root.next;
            return temp;
        }
    }
}