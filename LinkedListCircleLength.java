public class LinkedListCircleLength {
  /**
   * 获取链表的环的长度
   * @param head 链表头结点
   */
  public static int getCircleLength (Node head) {
    Node p1 = head;
    Node p2 = head;
    int steps = 0;
    int meeting_times = 0;
    while (p2 != null && p2.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
      // 第一次相遇后，开始记录前进次数
      if (meeting_times == 1) {
        steps++;
      }
      // 第二次相遇后 返回前进次数值
      if (meeting_times == 2) {
        return steps;
      }
      // 指针相遇，相遇次数加1
      if (p1 == p2) {
        meeting_times++;
      }
    }
    return steps;
  }
  /**
   * 链表节点
   */
  public static class Node {
    int data;
    Node next;
    Node(int data) {
      this.data = data;
    }
  }
  public static void main (String[] args) throws Exception {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    Node node8 = new Node(8);
    Node node9 = new Node(9);
    Node node10 = new Node(10);
    Node node11 = new Node(11);
    Node node12 = new Node(12);
    Node node13 = new Node(13);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node8;
    node8.next = node9;
    node9.next = node10;
    node10.next = node11;
    node11.next = node12;
    node12.next = node13;
    node13.next = node10;
    System.out.println(getCircleLength(node1));
  }
}
