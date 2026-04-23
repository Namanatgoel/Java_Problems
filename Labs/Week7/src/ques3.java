class Building {

    int squareFeet;
    int stories;
    Building() {
        squareFeet = 0;
        stories = 0;
    }
    Building(int squareFeet, int stories) {
        this.squareFeet = squareFeet;
        this.stories = stories;
    }

    void display() {
        System.out.println("Square Feet: " + squareFeet);
        System.out.println("Stories: " + stories);
    }
}

class House extends Building {

    int bedrooms;
    int baths;

    House(int squareFeet, int stories, int bedrooms, int baths) {
        super(squareFeet, stories);
        this.bedrooms = bedrooms;
        this.baths = baths;
    }

    void display() {
        super.display();
        System.out.println("Bedrooms: " + bedrooms);
        System.out.println("Bathrooms: " + baths);
    }
}

class School extends Building {

    int classrooms;
    String gradeLevel;

    School(int squareFeet, int stories, int classrooms, String gradeLevel) {
        super(squareFeet, stories);
        this.classrooms = classrooms;
        this.gradeLevel = gradeLevel;
    }

    void display() {
        super.display();
        System.out.println("Classrooms: " + classrooms);
        System.out.println("Grade Level: " + gradeLevel);
    }
}

public class ques3 {
    public static void main(String[] args) {
        House h = new House(2400, 3, 5, 3);
        School s = new School(8000, 4, 23, "10th Grade");
        h.display();
        s.display();
    }
}