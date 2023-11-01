package LinkedList;

class LinkedList
{
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {

        Node Head = new Node(0);
        Node dummy = null;
        while (head1 != null && head2 != null) {

            if (head1.data < head2.data) {
                if(dummy==null){
                    dummy = Head;
                    dummy.data = head1.data;
                }
                dummy.next =head1;
                dummy = head1;
                head1 = head1.next;
            }
            else {
                if(dummy==null){
                    dummy = Head;
                    dummy.data = head2.data;
                }
                dummy.next = head2;
                dummy = head2;
                head2 = head2.next;
            }
        }
        while (head1!=null){
            dummy.next = head1;
        }
        while (head2!=null){
            dummy.next = head2;
        }
        return Head;
    }
}