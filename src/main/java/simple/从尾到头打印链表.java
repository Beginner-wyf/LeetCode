package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangyifan
 * @create 2021/4/16 9:31
 */
public class 从尾到头打印链表 {
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        int[] ints = reversePrint3(head);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 通过list集合存储
     */
    public static int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        if (head == null){
           int [] res = new int[0];
            return res;
        }else {
            list.add(head.val);
            while (head.next != null) {
                head = head.next;
                list.add(head.val);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[list.size()-i-1] = list.get(i);
        }
        return res;
    }

    /**
     * 通过stack栈存储
     */
    public static int[] reversePrint2(ListNode head) {
        Stack<Integer> integers = new Stack<>();
        int [] res;
        if (head == null){
           res = new int[0];
           return res;
        }else {
            integers.push(head.val);
            while (head.next != null) {
                head = head.next;
                integers.push(head.val);
            }
        }
        res = new int[integers.size()];
        int i = 0;
        while (!integers.isEmpty()){
            res[i++] = integers.pop();
        }
        return res;
    }

    /**
     * 计数
     */
    public static int[] reversePrint3(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        int[] res = new int[count];
        count--;
        while (head != null && count >= 0){
            res[count--] = head.val;
            head = head.next;
        }
        return res;
    }
}
