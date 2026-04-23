package questions;

import java.util.Scanner;

import questions.ResearchLabSystem.Model;

class ResearchLabSystem {
	static String institutionName = "DPS";
	static int totalLabs = 0;

	String labId;
	int modelcount = 0;
	Model[] models;

	ResearchLabSystem(String id) {
		Scanner sc = new Scanner(System.in);
		this.labId = id;
		System.out.println("How many models capacity for Lab " + id + "?");
		int n = sc.nextInt();
		this.models = new Model[n];
		totalLabs++;
	}

	static void displayInstitutionInfo() {
		System.out.println("\nInstitution: " + institutionName);
		System.out.println("Total labs created: " + totalLabs);
	}

	void addModel(String name, String type, double loss) {
		if (modelcount < models.length) {
			models[modelcount] = new Model(name, type, loss);
			modelcount++;
			System.out.println("Model '" + name + "' added to lab " + labId);
		} else {
			System.out.println("Lab " + labId + " is full!");
		}
	}

	void displayLabDetails() {
		System.out.print(labId);
		for (Model m : models) {
			System.out.print(m);
		}
	}

	class Model {
		String modelName;
		String architectureType;
		double reconstructionLoss;

		public Model(String name, String type, double loss) {
			this.modelName = name;
			this.architectureType = type;
			this.reconstructionLoss = loss;
		}

		void displayModel() {
			System.out.println("Model: " + modelName + " [" + architectureType + "] Loss: " + reconstructionLoss);
		}

		void checkPerformance() {
			if (this.reconstructionLoss < 0.05) {
				System.out.println("High accurate");
			} else
				System.out.println("Needs retraining");
		}

		Model ensembleModels(Model other) {
			double avgLoss = (this.reconstructionLoss + other.reconstructionLoss) / 2;
			// Create a new model object to return
			Model ensemble = new Model("Ensemble_" + this.modelName, "Combined", avgLoss);
			return ensemble;
		}

	}
}

public class challenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the required details");
		ResearchLabSystem[] labs = new ResearchLabSystem[10];
		// holds upto 10 labs
		int currentLabCount = 0;
		while (true) {
            System.out.println("\n1. New Lab | 2. Add Model | 3. Audit | 4. Ensemble | 5. Display All | 6. Exit");
        
			int ch;
			System.out.println("Enter a valid choice");
			ch = in.nextInt();

			switch (ch) {

			case 1:
				if (currentLabCount < labs.length) {
					System.out.println("Etner lab ID: ");
					String id = in.next();
					// now create a lab and put it in the cabinate which can hold upto 10 labs
					labs[currentLabCount] = new ResearchLabSystem(id);
					currentLabCount++;
				}
				break;
			case 2:
				// find the lab in which we need to add a model
				System.out.println("LabID to add model into: ");
				String searchId = in.next();
				for (int i = 0; i < currentLabCount; i++) {
					if (labs[i].labId.equals(searchId)) {
						System.out.print("Enter Name, Type, Loss: ");
						labs[i].addModel(in.next(), in.next(), in.nextDouble());
					}
				}
				break;
			case 3:
				System.out.println("Enter the labID: ");
				String sid = in.next();
				for (int i = 0; i < currentLabCount; i++) {
					if (labs[i].labId.equals(sid)) {
						for (int j = 0; j < labs[i].modelcount; j++) {
                            labs[i].models[j].displayModel();
                            labs[i].models[j].checkPerformance();
                        }
					}
				}
				
			case 4:
				System.out.print("Enter labID to ensemble within: ");
                String ensId = in.next();
                for (int i = 0; i < currentLabCount; i++) {
                    if (labs[i].labId.equals(ensId)) {
                        if (labs[i].modelcount >= 2) {
                            // Grab the first two models and ensemble them
                            ResearchLabSystem.Model m1 = labs[i].models[0];
                            ResearchLabSystem.Model m2 = labs[i].models[1];
                            ResearchLabSystem.Model result = m1.ensembleModels(m2);
                            
                            System.out.println("New Ensemble Created:");
                            result.displayModel();
                        } else {
                            System.out.println("Need at least 2 models!");
                        }
                    }
                }
                break;
                
			case 5:
				ResearchLabSystem.displayInstitutionInfo();
                for (int i = 0; i < currentLabCount; i++) {
                    System.out.println("--- Lab ID: " + labs[i].labId + " ---");
                    for (int j = 0; j < labs[i].modelcount; j++) {
                        labs[i].models[j].displayModel();
                    }
                }
                break;
				
			case 6: System.exit(0);
				
			default:
				System.out.println("Enter correct choice");
			}

		}

	}

}
