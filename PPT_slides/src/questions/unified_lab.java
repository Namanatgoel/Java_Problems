package questions;

import java.util.Scanner;
/*
 * Task 1: The Inner Class NeuralModel (Lab 3, 5, 6)
Attributes: modelName (String), accuracy (double), type (String: "AE" or "VAE").

Constructor: Parameterized to initialize all values.

Logic: A method optimizeModel() that uses a StringBuffer to append " - Optimized" to the name and increases accuracy by 5%.

Comparison: A method isBetterThan(NeuralModel other) that returns true if the current model's accuracy is higher.

Task 2: The Outer Class ResearchLab (Lab 3, 4, 6)
Static Members: totalBudget (double), labCount (int).

Instance Members: labName (String), modelArray (Array of NeuralModel objects).

Static Block: Initialize totalBudget to 1,000,000.

Constructor: Initializes the lab name and the capacity for the modelArray. Increments labCount.

Method: addModel(...) which takes model details, creates a NeuralModel object, and places it in the array.

Task 3: The Main Controller (Lab 1, 2)
Implement a Menu-Driven system (switch-case inside a while loop).

Option 1: Create a Lab.

Option 2: Add a Model to a specific Lab.

Option 3: Perform an "Accuracy Audit" (Iterate through the array, display names, and check if accuracy > 0.90 using bitwise-like logic or standard comparisons).

Option 4: Compare two models using the isBetterThan method.
 */
class ResearchLab {
    // Lab 4: Static members - Shared across all Lab objects
    static String institutionName = "MIT Manipal";
    static int labCount = 0;
    static double totalBudget = 1000000.0;

    // Lab 3 & 6: Instance variables and Object Arrays
    String labName;
    NeuralModel[] models;
    int modelCount = 0;

    // Lab 4: Constructor
    ResearchLab(String name, int capacity) {
        this.labName = name;
        this.models = new NeuralModel[capacity]; // Lab 6: Initialize array of objects
        labCount++;
    }

    // Lab 5: Inner Class
    class NeuralModel {
        String modelName;
        double accuracy;
        String type;

        NeuralModel(String name, double acc, String type) {
            this.modelName = name;
            this.accuracy = acc;
            this.type = type;
        }

        // Lab 6: String Manipulation using StringBuffer
        void optimizeModel() {
            StringBuffer sb = new StringBuffer(this.modelName);
            sb.append("_OPT");
            this.modelName = sb.toString();
            this.accuracy += 0.05; // Increase accuracy by 5%
            if (this.accuracy > 1.0) this.accuracy = 1.0;
        }

        // Lab 3: Method returning boolean (Logic)
        boolean isBetterThan(NeuralModel other) {
            return this.accuracy > other.accuracy;
        }

        void displayModel() {
            System.out.println("  > [" + type + "] " + modelName + " | Accuracy: " + 
                               String.format("%.2f", accuracy));
        }
    }

    // Lab 6: Managing the array
    void addModel(String n, double a, String t) {
        if (modelCount < models.length) {
            models[modelCount] = new NeuralModel(n, a, t);
            modelCount++;
        } else {
            System.out.println("Error: Lab capacity reached.");
        }
    }
}

public class unified_lab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResearchLab[] labs = new ResearchLab[5]; // Array of Outer objects
        int currentLabs = 0;

        // Lab 2: Control Statements (Menu)
        while (true) {
            System.out.println("\n1. Create Lab\n2. Add Model\n3. Audit & Optimize\n4. Compare Top 2\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Lab Name & Capacity: ");
                    labs[currentLabs++] = new ResearchLab(sc.next(), sc.nextInt());
                    break;

                case 2:
                    System.out.print("Target Lab Name: ");
                    String target = sc.next();
                    for (int i = 0; i < currentLabs; i++) {
                        if (labs[i].labName.equals(target)) {
                            System.out.print("Model Name, Acc (0-1), Type: ");
                            labs[i].addModel(sc.next(), sc.nextDouble(), sc.next());
                        }
                    }
                    break;

                case 3: // Lab 6: Iterating through nested objects
                    for (int i = 0; i < currentLabs; i++) {
                        System.out.println("Lab: " + labs[i].labName);
                        for (int j = 0; j < labs[i].modelCount; j++) {
                            labs[i].models[j].optimizeModel(); // Lab 6: Modifying via loop
                            labs[i].models[j].displayModel();
                        }
                    }
                    break;

                case 4: // Lab 3: Object Interaction
                    if (currentLabs > 0 && labs[0].modelCount >= 2) {
                        ResearchLab.NeuralModel m1 = labs[0].models[0];
                        ResearchLab.NeuralModel m2 = labs[0].models[1];
                        if (m1.isBetterThan(m2)) System.out.println(m1.modelName + " is better.");
                        else System.out.println(m2.modelName + " is better.");
                    }
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}