
class HW2 {

    // Node structure containing power and coefficient of variable
    static class Node {
        // Your code here
        double coeff;
        int power;
        Node next;

        public Node(double coeff, int power) {
            this.coeff = coeff;
            this.power = power;
            this.next = null;
        }


    }

    ;

    //Function To Display The Linked list
    static void printList(Node ptr) {
        if (ptr == null) {
            System.out.println();
            return;
        } else if (ptr.next != null) {
            while (ptr.next != null) {
                System.out.print(ptr.coeff + "x^" + ptr.power + " + ");
                ptr = ptr.next;
            }
        }
        System.out.println(ptr.coeff + "x^" + ptr.power);
    }

    // Create a node and return
    static Node createNode(double coeff, int power) {
        // Your code here
        return new Node(coeff, power);

    }

    // Function add a new node
    static Node addnode(Node head, double coeff, int power) {
        // Your code here
        if (head == null) {
            return new Node(coeff, power);
        }
        head.next = new Node(coeff, power);
        return head;
    }

    static Node multiply(Node poly1, Node poly2) {
        // Your code here

        if (poly1 == null && poly2 == null) {
            return null;
        }
        Node current1 = poly1;
        Node current2 = poly2;
        Node head = null;
        Node newNode = null;
        while (current1 != null) {

            while (current2 != null) {
                if (head == null) {
                    head = addnode(null, current1.coeff * current2.coeff, current1.power + current2.power);
                    newNode = head;
                } else {
                    newNode = addnode(newNode, current1.coeff * current2.coeff, current1.power + current2.power);
                    newNode = newNode.next;
                }
                current2 = current2.next;
            }
            current2 = poly2;
            current1 = current1.next;

        }
        sort(head);
        addElements(head); //find nodes with same power, add their coefficients, delete the redundant one.

        return head;
    }

    static void addElements(Node head) { //done
        Node current = head;
        if (head != null) {
            while (current.next != null) {
                if (current.power == current.next.power) {
                    current.coeff += current.next.coeff;
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }

    }


    static Node add(Node poly1, Node poly2) {
        // Your code here
        //first sort the linklist
        sort(poly1);
        sort(poly2);
        Node head = null;
        Node newNode = null;
        Node current1 = poly1;
        Node current2 = poly2;


        while (current1 != null && current2 != null) {
            if (current1.power == current2.power) {
                if (head == null) {
                    head = addnode(null, current1.coeff + current2.coeff, current1.power);
                    newNode = head;
                } else {
                    newNode = addnode(newNode, current1.coeff + current2.coeff, current1.power);
                    newNode = newNode.next;
                }
                current1 = current1.next;
                current2 = current2.next;

            } else if (current1.power < current2.power) {
                if (head == null) {
                    head = addnode(null, current2.coeff, current2.power);
                    newNode = head;
                } else {
                    newNode = addnode(newNode, current2.coeff, current2.power);
                    newNode = newNode.next;
                }
                current2 = current2.next;
            } else {
                if (head == null) {
                    head = addnode(null, current1.coeff, current1.power);
                    newNode = head;
                } else {
                    newNode = addnode(newNode, current1.coeff, current1.power);
                    newNode = newNode.next;
                }
                current1 = current1.next;
            }

        }
        if (current1 != null) {
            while (current1 != null) {
                newNode = addnode(newNode, current1.coeff, current1.power);
                newNode = newNode.next;
                current1 = current1.next;
            }
        } else if (current2 != null) {
            while (current2 != null) {
                newNode = addnode(newNode, current2.coeff, current2.power);
                newNode = newNode.next;
                current2 = current2.next;
            }
        }


        return head;

    }

    static void sort(Node poly) { //done
        //this function will return the head reference to the linkedlist

        Node current = poly;
        Node i = null;

        while (current != null) {
            i = current.next;
            while (i != null) {

                if (current.power < i.power) {
                    swap(current, i);
                }
                i = i.next; //move to adjacent node
            }
            current = current.next; //compare next node with i's
        }


    }

    static void swap(Node current, Node i) { //done
        //swap powers
        int tempPower = 0;
        tempPower = current.power;
        current.power = i.power;
        i.power = tempPower;
        //swap coefficients
        double tempCoeff = 0;
        tempCoeff = current.coeff;
        current.coeff = i.coeff;
        i.coeff = tempCoeff;

    }

}
