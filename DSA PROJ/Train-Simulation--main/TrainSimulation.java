import java.util.Scanner;

class Node {
    int coachNo;
    String coachType;
    Node next;

    Node(int coachNo, String coachType) {
        this.coachNo = coachNo;
        this.coachType = coachType;
        next = null;
    }
}

class Train {
    Node head = null;

    // Add Coach
    void addCoach(int coachNo, String coachType) {

        Node newNode = new Node(coachNo, coachType);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }

        System.out.println("Coach added successfully.");
    }

    // Remove Coach
    void removeCoach(int coachNo) {

        if (head == null) {
            System.out.println("Train has no coaches.");
            return;
        }

        if (head.coachNo == coachNo) {
            head = head.next;
            System.out.println("Coach removed.");
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.coachNo != coachNo)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Coach not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Coach removed.");
        }
    }

    // Search Coach
    void searchCoach(int coachNo) {

        Node temp = head;

        while (temp != null) {

            if (temp.coachNo == coachNo) {

                System.out.println("\nCoach Found");
                System.out.println("Coach Number : " + temp.coachNo);
                System.out.println("Coach Type   : " + temp.coachType);

                return;
            }

            temp = temp.next;
        }

        System.out.println("Coach not found.");
    }

    // Display Train
    void displayTrain() {

        if (head == null) {
            System.out.println("No coaches available.");
            return;
        }

        Node temp = head;

        System.out.println("\nEngine");

        while (temp != null) {

            System.out.println("   |");
            System.out.println("   V");
            System.out.println("Coach " + temp.coachNo + " - " + temp.coachType);

            temp = temp.next;
        }

        System.out.println("End of Train");
    }

    // Count Coaches
    void countCoaches() {

        int count = 0;

        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total Coaches: " + count);
    }

    // Start Train Simulation
    void startTrain() {

        if (head == null) {
            System.out.println("No train to run.");
            return;
        }

        Node temp = head;

        System.out.println("\nTrain is now running...\n");

        while (temp != null) {

            System.out.println("Passing Coach " +
                    temp.coachNo + " (" + temp.coachType + ")");

            temp = temp.next;
        }

        System.out.println("\nDestination Reached!");
    }
}

public class TrainSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Train train = new Train();

        int choice;

        do {

            System.out.println("\n====== TRAIN SIMULATION ======");
            System.out.println("1. Add Coach");
            System.out.println("2. Remove Coach");
            System.out.println("3. Search Coach");
            System.out.println("4. Display Train");
            System.out.println("5. Count Coaches");
            System.out.println("6. Start Train");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Coach Number: ");
                    int no = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Coach Type: ");
                    String type = sc.nextLine();

                    train.addCoach(no, type);
                    break;

                case 2:

                    System.out.print("Coach Number to Remove: ");
                    train.removeCoach(sc.nextInt());
                    break;

                case 3:

                    System.out.print("Coach Number to Search: ");
                    train.searchCoach(sc.nextInt());
                    break;

                case 4:

                    train.displayTrain();
                    break;

                case 5:

                    train.countCoaches();
                    break;

                case 6:

                    train.startTrain();
                    break;

                case 7:

                    System.out.println("Thank you for using Train Simulation.");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}