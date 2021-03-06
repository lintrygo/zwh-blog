package com.my.blog.website.dataStructure.linklist;

public class LinkListDemo {

    public static void main(String[] args) {

        Node node1 = new Node(1,"1");
        Node node2 = new Node(2,"2");
        Node node3 = new Node(3,"3");
        Node node4 = new Node(4,"4");

        LinkList linkList = new LinkList();
        linkList.insert(node1);
        linkList.insert(node2);
        linkList.insert(node3);
        linkList.insert(node4);
        //linkList.deleteFirst();
        linkList.list();

        System.out.println(linkList.getLength());
        System.out.println(linkList.getNumNode(1).toString());
        System.out.println("----------------");
        linkList.revertList();
        linkList.list();

    }

}

class LinkList{

    private Node head = new Node(0,"");

    public boolean isEmpty(){
        return head.next == null;
    }

    /**
     * 头插法 插入节点
     * @param node
     */
    public void insert(Node node){
        node.next = head.next;
        head.next = node;
    }

    /**
     * 删除节点
     */
    public void deleteFirst(){
        head.next = head.next.next;
    }

    /**
     * 遍历
     */
    public void list(){
        if(head.next == null){
            System.out.println("当前链表为空!");
            return;
        }
        Node temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    /**
     * 获取节点个数
     * @return
     */
    public int getLength(){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        Node temp = head;
        while(temp.next!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 获取倒数n个元素
     * @return
     */
    public Node getNumNode(int n){
        if(head.next == null){
            return null;
        }
        int length = getLength();
        int index = 0;
        if(length<n){
            System.out.println("寻找位置超长!");
            return null;
        }
        Node temp = head.next;
        while(temp!=null){
            if(length - n == index){
                break;
            }
            index++;
            temp = temp.next;
        }
        return temp;

    }

    /**
     * 链表反转
     */
    public void revertList(){
        Node temp = head.next;
        Node revert = new Node(0,"0");
        while (temp!=null){
            Node a = temp;
            Node b = revert.next;
            temp = temp.next;
            revert.next = a;
            a.next = b;
        }
        head.next = revert.next;
    }

}

class Node{

    public  int no;

    public  String name;

    public Node next;


    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
