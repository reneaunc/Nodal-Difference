import java.util.*;

public class BSTTest{
	public static void main(String[] args) {
		// perform at least one test on each operation of your BST
		BSTTest test1 = new BSTTest();
		BSTTest test2 = new BSTTest();
		BSTTest test3 = new BSTTest();
		//case 1
		System.out.println("Test 1:");
		System.out.println("----------------------");
		test1.test(5);
		//case 2
		System.out.println("Test 2:");
		System.out.println("----------------------");
		test2.test(10);
		//case 3
		System.out.println("Test 3:");
		System.out.println("----------------------");
		test3.test(15);
	}

	private int[] randomArray(int size) {
		Random rand = new Random();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++){
			//fills array with random numbers between 0(inclusive) and 1001(exclusive)
			arr[i] = rand.nextInt(1001);
		}
		return insertionSort(arr);
	}
	public static int[] insertionSort(int[] unsortedArr) {
        // sorts array per lab request
        for(int i = 1; i < unsortedArr.length; i++){
            int key = unsortedArr[i];
            int j = i - 1;
            while (j >= 0 && unsortedArr[j] > key){
                unsortedArr[j + 1] = unsortedArr[j];
                j = j - 1;
            }
            unsortedArr[j + 1] = key;
        }
        return unsortedArr;
    }
	// the parameters and return are up to you to define; this method needs to be uncommented
	private void test(int size) {
		int removals = size / 5;
		int[] sortedArray = randomArray(size);
		BST testBST = new BST();
		System.out.println("Testing of BST starts.");
		for(int i = 0; i < sortedArray.length; i++){
			//fills BST with elements of sorted array
			System.out.println("Insert " + sortedArray[i]);
			testBST.insert(sortedArray[i]);
		}
		for(int x = 1; x < removals; x++){
			//deletes # of elements dependent on size of array
			System.out.println("Delete " + sortedArray[x]);
			testBST.delete(sortedArray[x]);	
		}
		System.out.print("The traverse gives a BST as ");
		System.out.println(Arrays.toString(testBST.traverse()));
		System.out.println("");
		}
}
