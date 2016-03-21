
// Sorting07.java
// The last sort to be shown is the ultrafast recursive Merge Sort


import java.util.*;


public class Sorting07
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter list size      ===>>  ");
		int listSize = input.nextInt();
		System.out.print("Enter minimum value  ===>>  ");
		int listMin = input.nextInt();
		System.out.print("Enter maximum value  ===>>  ");
		int listMax = input.nextInt();
		List array = new List(listSize,listMin,listMax);
      
		array.display();
		array.pause();
		array.mergeSort(0,listSize-1);
		array.display();
		array.pause();
		System.out.println();
	}
}


class List
{
	private int[] intArray;	
   private int[] tempArray;
	private int size;  		
   
   public List(int s, int min, int max)
	{
		size = s;
		System.out.println("Constructing List with values in [" + min + ".." + max + "] range");
		intArray = new int[size];
      tempArray = new int[size];
		int range = max - min + 1;
		for (int k = 0; k < size; k++)
			intArray[k] = (int) (Math.random() * range + min);
	}

	public void display()
	{
		System.out.println("\nDisplaying array elements");
      for (int k = 0; k < size; k++)
      {
			System.out.print(intArray[k] + "  ");
         if (k > 1 && k % 15 == 0)
		      System.out.println();
      }
      System.out.println();
	}

	public void pause()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nPress <Enter> to continue  ===>>  ");
		String dummy = input.nextLine();
	}


	public void mergeSort(int first, int last)
	{
		if (first < last)
		{
			int mid = (first + last) / 2;
			mergeSort(first,mid);
			mergeSort(mid+1,last);
			merge(first,mid,last);
   	}
	}

   private void merge(int first, int mid, int last)
	{
	   /*
	   * p is first index of sublist your are working on
	   * q is middle of what we are breaking down into a new sublist
	   * k is a temporary value for first index of the sublist
	   */
		int p = first;
		int q = mid+1;
		int k = first;
		while (p <= mid && q <= last) //keep in range of the numbers provided
		{
			//if the value of the first item is less than or equal to the middle+1 item
			if (intArray[p] <= intArray[q]) 
			{
				//set the tempArray at k equal to the intArray at p
				tempArray[k] = intArray[p];
				p++; //increase index by 1 of the p
			}
			else
			{
				//set the tempArray at k equal to the intArray at q
				tempArray[k] = intArray[q];
				q++; //increase index by 1 of the q
			}
			k++;
   	}
		//first subset needs 4 items
		while (p <= mid)
		{
			//take values from int array and place them into the two arrays
			tempArray[k] = intArray[p];
			p++;
			k++;
   	}
		//second subset needs at least 4 items breaking values into the two arrays baded on mid +1 and last
		while (q <= last)
		{
			tempArray[k] = intArray[q];
			q++;
			k++;
   	}
		//taking two sub arrays and merging them together
		//take sorted values from sub array and put them into intArray (full array)
		for (int h = first; h <= last; h++)
			intArray[h] = tempArray[h];
	}

}