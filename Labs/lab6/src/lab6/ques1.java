package lab6;
import java.util.Scanner;

class ques1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1. Check Palindrome");
            System.out.println("2. Alphabetical Order");
            System.out.println("3. Reverse String");
            System.out.println("4. Concatenate Original and Reversed");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                 
                    String rev1 = "";
                    for (int i = str.length() - 1; i >= 0; i--) {
                        rev1 = rev1 + str.charAt(i);
                        System.out.println(rev1);
                    }

                    if (str.equalsIgnoreCase(rev1))
                        System.out.println("Palindrome");
                    else
                        System.out.println("Not Palindrome");
                    break;

                case 2:
                    
                    char arr[] = new char[str.length()];

                    for (int i = 0; i < str.length(); i++) {
                        arr[i] = str.charAt(i);
                        System.out.println(arr[i]);
                    }
                    
                    System.out.println("Length of the array is:" + arr.length);
                    
                    for (int i = 0; i < arr.length - 1; i++) {
                        for (int j = i + 1; j < arr.length; j++) {
                            if (arr[i] > arr[j]) {
                                char temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }

                    System.out.print("Alphabetical Order: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i]);
                    }
                    System.out.println();
                    break;

                case 3:
                    
                    String rev2 = "";
                    for (int i = str.length() - 1; i >= 0; i--) {
                        rev2 = rev2 + str.charAt(i);
                    }
                    System.out.println("Reversed String: " + rev2);
                    break;

                case 4:
                    
                    String rev3 = "";
                    for (int i = str.length() - 1; i >= 0; i--) {
                        rev3 = rev3 + str.charAt(i);
                    }
                    System.out.println("Concatenated String: " + str + rev3);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.out.println("Exited!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
