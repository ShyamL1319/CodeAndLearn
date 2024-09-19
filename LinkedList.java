public class LinkedList {

    static class Node{
        int data;
        Node link;

        public Node(int data){
            this.data = data;
            this.link = null;
        }

        public Node(){
        }
    }

    public static void main(String[] args){

        Node linkedList = new Node(11);
        add(linkedList,new Node(12));
        add(linkedList,new Node(13));
        add(linkedList,new Node(15));
        add(linkedList,new Node(16));
        removeNode(linkedList,16);
        linkedList = removeFirstNode(linkedList);
        linkedList = removeLastNode(linkedList);
        printLinkedList(linkedList);

    }

    public static Node add(Node head, Node node){
        Node temp = head;
        if(head != null){
            while (temp.link != null ){
                temp = temp.link;
            }
            temp.link = node;
        }else{
            head = node;
        }
        return head;
    }

    public static void printLinkedList(Node linkedList){
        if(linkedList == null){
            System.out.println("Null Linkedlist");
        }
        while (linkedList != null){
            System.out.print(linkedList.data + "->");
            linkedList = linkedList.link;
        }
    }


    public static Node removeFirstNode(Node linkedList){
        linkedList = linkedList.link;
        return linkedList;
    }

    public static void removeNode(Node linkedList,int data){
        Node temp = linkedList;
        Node prevNode = linkedList;
        while (temp != null){
            if(temp.data == data){
                prevNode.link = temp.link;
                return;
            }
            prevNode = temp;
            temp = temp.link;
        }
    }

    public static Node removeLastNode(Node linkedList){
        Node temp = linkedList;

        if (temp == null) return null;

        if (temp.link == null) return null;
        while (temp.link.link != null) {
            temp = temp.link;
        }
        temp.link = null;
        return linkedList;
    }

    public static int checkSortedLinkedList(Node A) {
        Node temp = A;
        //edga case
        if (temp.link == null) {
            return 1;
        }

        while (temp.link != null) {
            if (temp.data > temp.link.data) {
                return 0;
            }
            temp = temp.link;
        }
        return 1;
    }

}
