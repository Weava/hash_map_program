/**
 * Class defining the individual nodes within the linked list.
 */
public class ListNode 
{
	private String string;
	private ListNode next;

	public ListNode(String string) 
	{
		this.string = string;
		this.next = null;
	}

	public boolean lessThan(ListNode ln) 
	{
		if(this.getString().compareTo(ln.getString()) < 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean greaterThan(ListNode ln) 
	{
		if(this.getString().compareTo(ln.getString()) > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean equalTo(ListNode ln) 
	{
		if(this.getString().equals(ln.getString()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getString() 
	{
		return this.string;
	}

	public ListNode getNext() 
	{
		return this.next;
	}

	public void setNext(ListNode next) 
	{
		this.next = next;
	}
}
