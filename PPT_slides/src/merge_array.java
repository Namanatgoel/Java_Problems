
public class merge_array {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] firstarray = {143,65,768,87,90};
		int[] secondarray = {7,89,98,12,8};
		
		int[] mergedarray = new int[firstarray.length + secondarray.length];
		int j = 0;
		for(int i = 0; i<mergedarray.length; i++) {
			if(i<firstarray.length) {
				System.out.println("here"+i);
				mergedarray[i] = firstarray[i];
			}
			else { 
				System.out.println(i);
				System.out.println("J: "+j);
				mergedarray[i] = secondarray[j];
				j++;
			}
		}
		for(int num : mergedarray) {
			System.out.print(num + " ");
		}
	}

}
