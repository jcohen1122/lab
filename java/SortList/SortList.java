package SortList;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ArrayList<Integer> linkedListToArray(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        list.sort((x, y) -> x - y);
        return list;
    }

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = linkedListToArray(head);
        ListNode newHead = null;

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                newHead = new ListNode(list.get(i));
                continue;
            }

            // Get to end of list
            ListNode curr = newHead;
            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = new ListNode(list.get(i));
        }

        return newHead;
    }

    public String toString(ListNode head) {
        String list = "";
        ListNode curr = head;
        while (curr != null) {
            list += curr.val;
            curr = curr.next;
        }

        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Solution solution = new Solution();
        ListNode sortedHead = solution.sortList(head);

        System.out.println("Old List: " + solution.toString(head));
        System.out.println("Sorted List: " + solution.toString(sortedHead));
    }
}