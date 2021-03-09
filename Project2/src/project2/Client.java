package project2;

/**
 * Test Driver
 * 
 * @author William Norton, Marshall Ringwood, Charlotte Saethre, 
 * Cody Salmond, & Jeremiah Smith
 *
 */
public class Client {

	public static void main(String[] args) {
		// Example
		Integer[] a = {3, 2, 0, 1, 12, 13, 20, 45, 99, 100, 101};
		Integer[] b = {33, 44, 55, 12, 1, 4, 56, 77, 12, 99};
		
		Merge.sort(a);
		Quick.sort(a);
		
		Heap heap = new Heap();
		heap.sort(a);
		System.out.println("Comparison a: " + heap.getCount());
		heap.clearCount();
		heap.sort(b);
		System.out.println("Comparison b: " + heap.getCount());
		// TODO
		// Need Shaker Sort class code

		
		// Need array generator for all permutations based on N
		//This is a rough generator for part two
		int n = 5;
        int[] perms = new int[n];
        
        for (int i = 0; i < n; i++) {
			perms[i] = i;
		}
        
        Client c = new Client();
       c.permutations(perms, perms.length, perms.length);
        
     }
     
     public void permutations(int[] a, int size, int n){
         
         if(size == 1) printArray(a, n);
         
         for (int i = 0; i < size; i++){
             
             permutations(a, size - 1, n);
             
             if(size % 2 == 1){
                 int temp = a[0];
                 a[0] = a[size-1];
                 a[size-1] = temp;
             }
             
             if(size % 2 == 0 ){
                 int temp = a[i];
                 a[i] = a[size-1];
                 a[size-1] = a[i];
             }
         }
     }
    
     public void printArray(int[] a, int n){
         
         for (int i = 0; i < a.length; i++){
             System.out.print(a[i] + " ");
         }
     }

		// Need to add methods to sort classes that keeps track of comparisons made
	}

}
