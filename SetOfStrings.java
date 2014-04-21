/**
 * SetOfStrings is the class that contains the various functions necessary for a hash map, and
 * makes use of linked lists to avoid collison problems.
 */
public class SetOfStrings
{
	private int arraySize;  
	private LinkedList[] listRefs;
	private int count;
    
    /**
     * Constructor for SetOfStrings
     * @param slots size of the array
     * @return void
     */
	public SetOfStrings(int slots)
	{
		this.arraySize = slots;
		this.count = 0;
		this.listRefs = new LinkedList[this.arraySize];
	}

    /**
     * Adds a value to a linked list contained within an array slot based on the hash function.
     * @param toInsert the string to be inserted
     * @return value confirming the insertion
     */
	public boolean add(String toInsert)
	{
		int hashDivision = this.hash(toInsert);
		if(this.listRefs[hashDivision] == null)
		{
			listRefs[hashDivision] = new LinkedList();
			listRefs[hashDivision].add(toInsert);
			this.count++;
			return true;
		}
		else
		{
			if(this.contains(toInsert) > 0)
			{
				return false;
			}
			else
			{
				this.listRefs[hashDivision].add(toInsert);
				this.count++;
				return true;
			}
		}
	}

    /**
     * Deletes value from the hash map, effectively deleting from its appropriate linked list.
     * @param toDelete the string to be deleted
     * @return value confirming the deletion
     */
	public boolean delete(String toDelete)
	{
		int hashDivision = this.hash(toDelete);
		if(this.listRefs[hashDivision] == null)
		{
			return false;
		}
		else
		{
			String deleted = this.listRefs[hashDivision].delete(toDelete);
			if(deleted == null)
			{
				return false;
			}
			else
			{
				this.count--;
				return true;
			}
		}
	}

    /**
     * Searches the hash map, and containing linked lists, for the value specified.
     * @param toFind the value to search for
     * @return number of comparisons required to find the string
     */
	public int contains(String toFind)
	{
        String compared = "";
		int hashDivision = this.hash(toFind);
		int comparisons = 0;

		if(this.listRefs[hashDivision] == null)
		{
			return 0;
		}
        compared = this.listRefs[hashDivision].first();
	    for(int i = 0; i < this.listRefs[hashDivision].getCount(); i++)
		{
			if(compared.equals(toFind))
			{
				comparisons++;
				return comparisons;
			}
			else
			{
				comparisons++;
			}
            compared = this.listRefs[hashDivision].next();
		}
	
		comparisons = -comparisons;
		return comparisons;
	}

    /**
     * The division hash function, determining where in the array the string will go by getting its unicode
     * values and taking the modulus of that and the size of the array.
     * @param toSum the string to gather the unicode value from
     * @return the result of the division hash function
     */
	public int hash(String toSum)
	{
		int sum = 0;
		for(int i = 0; i < toSum.length(); i++)
		{
			sum += (int) toSum.charAt(i);
		}
		return sum % this.arraySize;
	}

	public int getCount()
	{
		return this.count;
	}
}
