
public class ListNode implements InterfaceNode {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

 private Comparable value;

  private Node prev;   //for the previous node
  private Node next; //for the next node

 private Node ( Comparable value, Node prev, Node next ) {
     this.value = value;
     this.prev = prev;
     this.next = next;
 }
    }

    // Instance variables
    private Node head;

    // Empty list.
    public ListNode() {
     // a dummy node is created and set with proper links.
        head = new Node(null, null,null);
        head.next = head;
        head.prev = head;
    }

    // Instance methods
    public int size() {
     Node node = head;
     int count = 0;
     while ( node.next!=head ) {
         node = node.next;
         count++;
     }
     return count;
    }
    

    public Object get( int pos ) {
     if (pos < 0) 
         throw new IndexOutOfBoundsException( Integer.toString( pos ) );

     Node node = head;
     
     for ( int i=0; i<=pos; i++ )
         if ( node.next == head )
      throw new IndexOutOfBoundsException( Integer.toString( pos ) );
         else
      node = node.next;

     return node.value;
    }

    public boolean add( Comparable obj ) {
     if ( obj == null )
         throw new IllegalArgumentException( "null" );

     if ( head.next == head ) { // special case: empty list

         head.next = new Node( obj, head, head );
         head.prev = head.next;    
     } 
     else { 
         
         Node node1 = head;

         // i)  there is at least one node
         // ii) obj is greater than p

         while (node1.next != head && node1.next.value.compareTo( obj ) < 0 ) {
          node1 = node1.next;
         }

      Node node2 = node1.next; // the node that follows

      node1.next = new Node( obj,node1, node2);

      node2.prev = node1.next;
     }

     return true;
    }

    public void remove( int pos ) {
      if ( pos < 0 ) 
         throw new IndexOutOfBoundsException( Integer.toString( pos ) );

     Node node = head;
     for ( int i=0; i<=pos; i++ ) // traversing pos nodes
      if ( node.next == head )
          throw new IndexOutOfBoundsException(Integer.toString(pos));
      else
          node = node.next;
         
         Node move = node;  // the node to remove

         node = node.prev; // node designates the previous node

         Node nodeNext = move.next; // nodeNext designates the node that follows

         node.next = nodeNext;
         
         nodeNext.prev = node;

         move.value = null;
         move.next = null;
         move.prev= null;
    }

// Both lists store their elements in increasing
  // order, so both lists can be traversed simultaneously.
  
  public void merge( ListNode other ) {
    Node node = head.next;
    Node nodeNext= other.head.next;
    while(nodeNext!=other.head){
      if ( node == head ) {  
        head.next = new Node(nodeNext.value,head,head);
        node.prev = node.next;
        nodeNext = nodeNext.next;
      } 
      else if (nodeNext.value.compareTo(node.value) < 0){
	//insert before
        node.prev = new Node(nodeNext.value,node.prev,node);
        node.prev.prev.next = node.prev;
        nodeNext =nodeNext.next;
      } 
      else if (node.next==head){
 	//insert after
        node.next = new Node(nodeNext.value,node,head);
        head.prev = node.next;
        node = node.next;
        nodeNext = nodeNext.next;
      } 
      else {
        node = node.next;
      }
    }
  }
}
