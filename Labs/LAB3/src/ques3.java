import java.util.Scanner;
class Mixer {
    int arr[];
    int n;

    void accept() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        arr = new int[n];

        System.out.println("Enter elements in ascending order:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    Mixer mix(Mixer A) {
        Mixer result = new Mixer();

        int i = 0, j = 0, k = 0;

        result.arr = new int[this.n + A.n];

        while (i < this.n && j < A.n) {
            if (this.arr[i] < A.arr[j]) {
                result.arr[k++] = this.arr[i++];
            } 
            else if (this.arr[i] > A.arr[j]) {
                result.arr[k++] = A.arr[j++];
            } 
            else {
                result.arr[k++] = this.arr[i];
                i++;
                j++;
            }
        }

        while (i < this.n) {
            result.arr[k++] = this.arr[i++];
        }

        while (j < A.n) {
            result.arr[k++] = A.arr[j++];
        }

        result.n = k;

        return result;
    }

    void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
class ques3{
    public static void main(String[] args) {
        Mixer M1 = new Mixer();
        Mixer M2 = new Mixer();

        System.out.println("Enter first array:");
        M1.accept();

        System.out.println("Enter second array:");
        M2.accept();

        Mixer M3=M1.mix(M2);

        System.out.println("Merged array:");
        M3.display();
    }
}




































