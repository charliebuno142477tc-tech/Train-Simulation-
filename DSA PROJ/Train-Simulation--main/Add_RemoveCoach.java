


import java.util.Scanner;

    

    class CoachNode {

    String coachNo;
    String coachType;
    int capacity;
    CoachNode next;

    CoachNode(String coachNo, String coachType, int capacity) {
        this.coachNo = coachNo;
        this.coachType = coachType;
        this.capacity = capacity;
        this.next = null;

    }
}

    
class TrainList {

    CoachNode head = null;

    void addCoachAtBeginning(String coachNo, String coachType, int capacity) {
        CoachNode newNode = new CoachNode(coachNo, coachType, capacity);
        newNode.next = head;
        head = newNode;
        System.out.println("Coach added at the beginning successfully.");
    }

    void addCoachAtEnd(String coachNo, String coachType, int capacity) {
        CoachNode newNode = new CoachNode(coachNo, coachType, capacity);
        if (head == null) {
            head = newNode;
        } else {
            CoachNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Coach added at the end successfully.");
    }

    void insertCoachAfter(String targetCoachNo, String coachNo, String coachType, int capacity) {
        CoachNode temp = head;
        while (temp != null && !temp.coachNo.equals(targetCoachNo)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Target coach " + targetCoachNo + " not found. Cannot insert.");
        } else {
            CoachNode newNode = new CoachNode(coachNo, coachType, capacity);
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Coach added after " + targetCoachNo + " successfully.");
        }
    }

    void removeFirstCoach() {
        if (head == null) {
            System.out.println("Train has no coaches.");
            return;
        }
        System.out.println("Coach " + head.coachNo + " removed from the beginning.");
        head = head.next;
    }

    void removeLastCoach() {
        if (head == null) {
            System.out.println("Train has no coaches.");
            return;
        }
        if (head.next == null) {
            System.out.println("Coach " + head.coachNo + " removed.");
            head = null;
            return;
        }
        CoachNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println("Coach " + temp.next.coachNo + " removed from the end.");
        temp.next = null;
    }

    void removeCoachByNumber(String coachNo) {
        if (head == null) {
            System.out.println("Train has no coaches.");
            return;
        }

        if (head.coachNo.equals(coachNo)) {
            System.out.println("Coach " + coachNo + " removed.");
            head = head.next;
            return;
        }

        CoachNode temp = head;
        while (temp.next != null && !temp.next.coachNo.equals(coachNo)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Coach not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Coach " + coachNo + " removed.");
        }
    }

    void searchCoach(String coachNo) {
        CoachNode temp = head;
        while (temp != null) {
            if (temp.coachNo.equals(coachNo)) {
                System.out.println("\nCoach Found!");
                System.out.println("Type: " + temp.coachType);
                System.out.println("Capacity: " + temp.capacity);
                return;
            }
            temp = temp.next;
        }
        System.out.println("\nCoach not found.");
    }

    void display() { // traversal
        if (head == null) {
            System.out.println("No coaches available.");
            return;
        }

        System.out.println("\nTrain Coaches\n");
        CoachNode temp = head;
        while (temp != null) {
            System.out.println(temp.coachNo + " - " + temp.coachType);
            if (temp.next != null) {
                System.out.println("\u2193");
            }
    temp = temp.next;
        }

        System.out.println("\nTrain Composition\n");
        System.out.println("Engine");
        System.out.println("\u2193\n");

        temp = head;
        while (temp != null) {
            System.out.println("Coach " + temp.coachNo);
            if (temp.next != null) {
        System.out.println("\u2193\n");
            } else {
                System.out.println("\nEnd of Train");
            }
            temp = temp.next;
        }
    }

    void countNodes() {
        int count = 0;
        CoachNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;

        }
        System.out.println("\nTotal Coaches: " + count);
    }
}

public class Add_RemoveCoach {

    public static void main(String[] args) {
        TrainList train = new TrainList();
        int choice;

        try (Scanner sc = new Scanner(System.in)) {

            do {
                System.out.println("\n========== TRAIN COACH MANAGEMENT ==========");
                System.out.println("1. Add Coach at Beginning");
                System.out.println("2. Add Coach at End");
                System.out.println("3. Insert Coach After Another Coach");
System.out.println("4. Remove First Coach");
                System.out.println("5. Remove Last Coach");
                System.out.println("6. Remove Coach by Number");
                System.out.println("7. Search Coach");
                System.out.println("8. Display Train Coaches");
                System.out.println("9. Count Coaches");
                System.out.println("10. Exit");
                System.out.print("Enter choice: ");

                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                }
choice = sc.nextInt();
                sc.nextLine(); // uwu newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Coach Number: ");
                        String no1 = sc.nextLine();
                        System.out.print("Enter Coach Type: ");
                        String type1 = sc.nextLine();
                        System.out.print("Enter Capacity: ");
                        int cap1 = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        train.addCoachAtBeginning(no1, type1, cap1);
                    }
                    case 2 -> {
                        System.out.print("Enter Coach Number: ");
                        String no2 = sc.nextLine();
                        System.out.print("Enter Coach Type: ");
                        String type2 = sc.nextLine();
                        System.out.print("Enter Capacity: ");
                        int cap2 = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        train.addCoachAtEnd(no2, type2, cap2);
                    }
                    case 3 -> {
                        System.out.print("Enter Target Coach Number to insert after: ");
                        String targetNo = sc.nextLine();
                        System.out.print("Enter New Coach Number: ");
                        String no3 = sc.nextLine();
                        System.out.print("Enter New Coach Type: ");
                        String type3 = sc.nextLine();
                        System.out.print("Enter Capacity: ");
                        int cap3 = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        train.insertCoachAfter(targetNo, no3, type3, cap3);
                    }
                    case 4 ->
                        train.removeFirstCoach();
                    case 5 ->
                        train.removeLastCoach();
                    case 6 ->
                        {
                        System.out.print("Enter Coach Number to Remove: ");
                        String removeNo = sc.nextLine();
                        train.removeCoachByNumber(removeNo);
                    }
                    case 7 -> {
 
                       System.out.print("Enter Coach Number to Search: ");
                        String searchNo = sc.nextLine();
                        train.searchCoach(searchNo);
                    }
                    case 8 ->
                        train.display();
                    case 9 ->
                        train.countNodes();
                    case 10 ->
                        System.out.println("Exiting Train Coach Management System...");
                    default ->
                        
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 10);
        }
 
   }
}
