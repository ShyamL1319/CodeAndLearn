public class DoublyLinkedList {
    static class Node{
        int data;
        Node nextLink;
        Node prevLink;


        public Node(int data){
            this.data = data;
            this.nextLink = null;
            this.prevLink = null;
        }

        public Node(){
        }
    }
    public static void main(String[] args) {
        Node doublyLinkedList = new Node(11);
        doublyLinkedList  = add(doublyLinkedList,new Node(12));
        doublyLinkedList = add(doublyLinkedList,new Node(13));
        doublyLinkedList = add(doublyLinkedList,new Node(15));
        doublyLinkedList = add(doublyLinkedList,new Node(16));
        //System.out.println(doublyLinkedList.data);
        //doublyLinkedList = removeFirstNode(doublyLinkedList);
        //removeNode(doublyLinkedList,12);
        doublyLinkedList = removeLastNode(doublyLinkedList);
        printDoublyLinkedList(doublyLinkedList);

    }

    public static Node add(Node head, Node node){
        Node temp = head;
        if(head != null){
            while (temp.nextLink != null ){
                temp = temp.nextLink;
            }
            temp.nextLink = node;
            node.prevLink = temp;
            //head=temp.nextLink; // lastnode
            //head = node; // makes to right firstNode if commented will make leftFirstNode;
        }else{
            head = node;
        }
        return head;
    }

    /**
     * @method printDoublyLinkedList from left to right
     * @param doublyLinkedList
     */
    public static void printDoublyLinkedList(Node doublyLinkedList){
        Node rightToLeft = doublyLinkedList;
        if(doublyLinkedList == null){
            System.out.println("Null Linkedlist");
        }
        System.out.println("Left to Right Linkedlist");
        while (doublyLinkedList != null && doublyLinkedList.nextLink != null){
            System.out.print(doublyLinkedList.data + "->");
            doublyLinkedList = doublyLinkedList.nextLink;
        }
        System.out.println(doublyLinkedList.data);
//        if(rightToLeft!=null && rightToLeft.prevLink != null) {
//            printDoublyLinkedListRTL(rightToLeft);
//            return;
//        }
    }

    public static void printDoublyLinkedListRTL(Node doublyLinkedList){
        if(doublyLinkedList.prevLink != null){
            printDoublyLinkedListRTL(doublyLinkedList.prevLink);
        }
        System.out.print(doublyLinkedList.data+" ");
    }


    public static Node removeFirstNode(Node linkedList){
        Node head = linkedList;
        if(linkedList == null) return null;
        if(linkedList.nextLink == null) return null;
        linkedList = linkedList.nextLink;
        linkedList.prevLink = null;
        return linkedList;
    }

    public static void removeNode(Node linkedList, int data){
        Node temp = linkedList;
        while (temp != null){
            if(temp.data == data){
                if(temp.prevLink == null && temp.nextLink != null){
                    temp = temp.nextLink;
                    temp.prevLink = null;
                    return;
                }else if(temp.nextLink == null && temp.prevLink != null) {
                    temp = temp.prevLink;
                    temp.nextLink = null;
                    return;
                }else{
                    temp.prevLink.nextLink = temp.nextLink;
                    temp.nextLink.prevLink = temp.prevLink;
                    return;
                }
            }
            temp = temp.nextLink;
        }
    }

    public static Node removeLastNode(Node linkedList){
        Node temp = linkedList;

        if(temp == null) return null;

        if(temp.prevLink ==  null && temp.nextLink == null) return null;
        while (temp.nextLink != null ){
            temp = temp.nextLink;
        }
        temp = temp.prevLink;
        temp.nextLink = null;
        return linkedList;
    }
}
