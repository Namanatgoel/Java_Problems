
public class conitnue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outer: 
			for (int i=0; i<5; i++)
				{ 
			inner:		for(int j=0; j<5; j++)
						{ 
							if(j > i)
								{ 
						//			System.out.println("\n It came here \n");
									System.out.println();
									break outer;
								}
				//			System.out.println("\n It came here 2 \n");
							System.out.print(" " + (i * j));
						}
		//			System.out.println(" \n It came here 3 \n");
				}
	//	System.out.println("\n It came here 4 \n");
		System.out.println();
	}

}
