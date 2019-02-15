public class KthToLastSinglyLinkedList{

    public static Node getKthToLast(Node head, int k){
        //If head is null return null
        if(head == null){
            return null;
        }
        Node runner = head;
        int size = 0;
        //First get the size of the singly linked list.
        while(runner != null){
            size++;
            runner = runner.next;
        }
        //Calculate the index we'll iterate to by subtracting k from size
        int index = size - k;
        //IF index is less than 0, return null
        if(index < 0){
            return null;
        }
        //Reset runner to the start of the linked list
        runner = head;
        //Iterate through until we find the right one
        for(int i = 0; i < index - 1; i++){
            runner = runner.next;
        }
        return runner;
    }

    //Used for debugging
    private static void printAllValues(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static void test(Node head, int k, int expectedValue){
        System.out.println("Beginning test...");
        System.out.println("LinkedList is:");
        printAllValues(head);
        System.out.println("We are searching for the kth to last element with k = " + k + " and expecting this value: " + expectedValue);
        Node output = getKthToLast(head, k);
        int actualValue = output.data;
        if(actualValue == expectedValue){
            System.out.println("SUCCESS!");
        }else{
            System.out.println("FAILURE!  Got " + actualValue + " instead of " + expectedValue + ".");
        }
    }

    public static void main(String[] args){
        Node head = new Node(5);
        head.appendToTail(10);
        head.appendToTail(7);
        head.appendToTail(3);
        test(head, 0, 3);
        test(head, 4, 5);
        test(head, 1, 7);
    }

}


//Singly linked list nodes
class Node{
    int data;;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
    
    void appendToTail(int data){
        Node end = new Node(data);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}
