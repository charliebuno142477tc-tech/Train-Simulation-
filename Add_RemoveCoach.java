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