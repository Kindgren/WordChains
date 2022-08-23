
class Queue {
    private ListNode front, back;

    public Queue() {
	front = null;
	back = null;
    }
    
 
    public void enqueue(Object element) {
    	
    	if(isEmpty()) {
    		back = front = new ListNode();	
    		}else {
    		back=back.next = new ListNode();	
    		}
    		back.element=element;
    		
    		
    	}

  
    public Object dequeue() throws Exception {
    	if (isEmpty()) {
		    throw new Exception();
		}
		Object element = front.element;
		front = front.next;
		return element;
	    }	


    public boolean isEmpty() {
	return front == null;
    }

    public void empty() {
	front = back = null;
    }

  
    class ListNode {
	Object element;
	ListNode next = null;
    }

	
	
	

	
}
