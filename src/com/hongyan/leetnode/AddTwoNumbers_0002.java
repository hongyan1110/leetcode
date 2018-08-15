package com.hongyan.leetnode;

public class AddTwoNumbers_0002 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }
    static class Solution {

        /**
         * 1563 / 1563 个通过测试用例
         * 执行用时：50ms
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int a = 0;
            ListNode head = new ListNode(0);
            ListNode curr = head;

            while (true) {
                if (l1 != null && l2 != null) {

                    int val = l1.val + l2.val + a;

                    curr.next = new ListNode(val % 10);
                    a = val / 10;

                    curr = curr.next;
                    l1 = l1.next;
                    l2 = l2.next;

                } else if (l1 != null || l2 !=null) {

                    ListNode notNullNode = l1 != null ? l1 : l2;


                    while (a != 0) {

                        int val = notNullNode.val + a;
                        curr.next = new ListNode(val % 10);
                        a = val / 10;
                        curr = curr.next;
                        notNullNode = notNullNode.next;

                        if (notNullNode == null) {
                            if (a != 0) {
                                curr.next = new ListNode(a);
                            }
                            return head.next;
                        }

                    }

                    curr.next = notNullNode;
                    return head.next;

                }else {
                    if (a != 0) {
                        curr.next = new ListNode(a);
                    }
                    return head.next;
                }
            }

        }
    }
}
