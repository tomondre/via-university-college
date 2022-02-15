package Ex2_Add_Two_Numbers;

public class Main {
    public static void main(String[] args) {
        int[] l1 = new int[3];
        l1[0] = 2;
        l1[1] = 4;
        l1[2] = 3;

        int[] l2 = new int[3];
        l2[0] = 5;
        l2[1] = 6;
        l2[2] = 4;

        ListNode listNode = getListNode(l1);
        ListNode listNode1 = getListNode(l2);


        ListNode listNode2 = addTwoNumbers(listNode, listNode1);

        ListNode current = listNode2;
        for (int i = 0; i < 3; i++) {
            System.out.println(current.val);
            current = current.next;
        }

    }

    public static ListNode getListNode(int[] array){
        ListNode node = new ListNode();
        ListNode current = node;
        for (int i = 0; i < array.length; i++) {
            current.val = array[i];
            if(i != array.length - 1){
                current.next = new ListNode();
                current = current.next;
            }
        }
        return node;
    }

    public static ListNode getListNode(int ints){
        String stringSum = "" + ints;

        ListNode node = new ListNode();
        ListNode current = node;
        for (int i = 2; i >= 0; i--) {
            int parsedNum = Character.getNumericValue(stringSum.charAt(i));
            current.val = parsedNum;
            if (i != 0)
            {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return node;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int num = getNum(l1);
        int num1 = getNum(l2);

        int sum = num + num1;

        return getListNode(sum);
    }

    public static int getNum(ListNode node) {
        String result = "";
        ListNode current = node;
        for (int i = 0; i < 3; i++) {
            result = current.val + result;
            current = current.next;
        }
        return Integer.parseInt(result);
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
