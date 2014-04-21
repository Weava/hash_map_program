/**
 * The class constructing and containing functions to use a linked list with list nodes.
 */
public class LinkedList 
{
	private ListNode head;
	private int count;
	private ListNode currentNode;

    /**
     * constructor for linked list
     */
	public LinkedList() 
	{
		this.head = null;
		this.count = 0;
		this.currentNode = null;
	}

    /**
     * Adds a string to the linked list
     * @param string the string to be added
     * @return void
     */
	public void add(String string) 
	{
		ListNode node = new ListNode(string);
		ListNode current = null;

		if(this.head == null || this.head.greaterThan(node)) 
		{
			node.setNext(this.head);
			this.head = node;
		}
		else
		{
			current = this.head;
			while(current.getNext() != null && 
				node.greaterThan(current.getNext()))
			{
				current = current.getNext();
			}
			node.setNext(current.getNext());
			current.setNext(node);
		}

		this.count++;
	}

    /**
     * Deletes a string from the linked list
     * @param string the string to be deleted
     * @return the string that was deleted
     */
	public String delete(String string) {
		ListNode current = this.head;
		ListNode prevNode = null;

		while(current != null && current.getString() != string)
		{
			prevNode = current;
			current = current.getNext();
		}
		if(current == null)
		{
			return null;
		}
		else if(prevNode == null)
		{
			this.count--;
			String toReturn = this.head.getString();
			this.head = current.getNext();
			return toReturn;
		}
		else
		{
			this.count--;
			String toReturn = current.getString();
			prevNode.setNext(current.getNext());
			return toReturn;
		}
	}

    /**
     * Returns the first element in the linked list and sets current node to the head.
     * @return the string in the first element
     */
	public String first() 
	{
		if(this.head == null) 
		{
			return null;
		}
		else
		{
			this.currentNode = this.head;
			return currentNode.getString();
		}
	}

    /**
     * Returns the next element in the linked list, and sets the current node to the next node.
     * @return the string found in the next element
     */
	public String next()
	{
		if(this.currentNode == null) 
		{
			return null;
		}
		else if(currentNode.getNext() != null)
        {
			this.currentNode = this.currentNode.getNext();
		}
        return currentNode.getString();
	}

	public int getCount()
	{
		return this.count;
	}
}
