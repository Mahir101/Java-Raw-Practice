public class SinglyLinkedLIst {
       private Node head; // Node name er ekta class thakbe ekhon ekta head declare korlam jeta dia bujhbo
// je head holo ei SinglyLinkedLIst er head  
       public static class Node {  // Node class ta static korlam jate kore use kora jai ei class er vetore ba baire directly
         private int data;  // eita holo interger data
        private Node next;  // eita holo porer jei Node ta thakbe shetar jonne next Node point korbe porer node ta ke

          Node (int data) {
              this.data = data;
               this.next = null;            //prothome shob node e null thakbe pore amra join kore dibo 
                                  // class e auto iniisate hoi but method e hoi na
          }
      }
}


public static void main(String[] args) {
     SinglyLinkedLIst newSinglyLinkedLIst = new SinglyLinkedLIst();
     
newSinglyLinkedLIst.head = new Node(1);
     Node second = Node(2);
      Node third = Node(3);

      newSinglyLinkedLIst.head.next  = second;

     second.next = third;

third.next = null; // eta korar dorkar nai cause dekho amra emnei this.next = null set koresi  just bujhanor jonne dekhalam 

     //head
     
    // 1->2->3->null

}


public void insert(int data) {
       Node newNode = new Node(data);
        lastNode.next  = newNode; //just track the last node as we have tracked and set head in the outer class
        newNode.next = null; // eta bujhanor jonne dilam 
         //inner class can access outer class private fields
}

void print() {
Node current = head;
  while(current!=null) {
     System.out.println(current.data);
        current = current.next;
}

}


public int getLength() {
int len = 0;
Node current = head;
  while(current!=null) {
     System.out.println(current.data);
        current = current.next;
len++;
}

return len;


}

//let's review this code, vhul thakte pare
public void deleteAtPos(int pos) {

Node current = head;
int cnt = 0;
  while(current!=null  &&  cnt-1< pos) {
        current = current.next;
         cnt++;
}
     current.next = current.next.next;

}


//let's review this code, vhul thakte pare
public void deleteFirstOccuringValue(int value) {

Node current = head;
  while(current!=null  && value!=current.data) {
        current = current.next;
  
}
     current.next = current.next.next;

}

