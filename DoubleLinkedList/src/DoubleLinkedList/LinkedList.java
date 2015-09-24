package DoubleLinkedList;

/**
 * 양방향 연결리스트 클래스
 * 노드탐색, 노드추가, 노드삭제, 노드검색, 리스트출력 메소드
 * @param <T>  the type parameter
 */
public class LinkedList<T> {
    private Node<T> head; //  리스트의 첫노드, 마지막노드, 크기를 멤버변수로 갖는다.
    private Node<T> tail;
    private int size = 0;

    /**
     *
     * 인덱스를 입력받아 해당 인덱스의 노드를 반환하는 메소드
     * @param index the index
     * @return the node
     */
    public Node searchIndex(int index) {
        // 짝수개의 리스트에서 검색효율을 조금 더 높이기 위해 if문을 수정했습니다.
        if ((index+1) <= size / 2) {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp;
        } else {
            Node temp = tail;
            for (int i = size; i > (index+1); i--) {
                temp = temp.getPrev();
            }
            return temp;
        }
    }

    /**
     * Add node.
     * 입력받은 인덱스에 입력받은 데이터값을 갖는 노드를 추가하는 메소드
     * @param index the index
     * @param input the input
     */
    public void addNode(int index, T input) {
        if (index > size) {
            System.out.println("index 입력이 잘못되었습니다.");
        } else { // 노드 추가
            Node newNode = new Node(input); // 노드객체 생성시 생성자에 의해 next, prev 값은 null
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                if (index == 0) { // 리스트의 첫 부분에 노드 추가
                    Node nextNode = head;
                    newNode.setNext(nextNode);
                    nextNode.setPrev(newNode);
                    head = newNode;
                    newNode.setPrev(null);
                } else if (size == index) { // 리스트의 마지막 부분에 노드 추가
                    Node prevNode = tail;
                    newNode.setPrev(prevNode);
                    prevNode.setNext(newNode);
                    tail = newNode;
                    newNode.setNext(null);
                } else { // 리스트의 중간에 노드를 삽입
                    Node prevNode = searchIndex(index - 1);
                    Node nextNode = searchIndex(index);
                    newNode.setPrev(prevNode);
                    newNode.setNext(nextNode);
                    prevNode.setNext(newNode);
                    nextNode.setPrev(newNode);
                }
            }
            size++;
        }
    }

    /**
     * Delete node.
     * 입력받은 인덱스의 노드를 삭제하는 메소드
     * @param index the index
     */
    public void deleteNode(int index) {
        if (size == 0) {
            System.out.println("리스트가 없습니다.");
        } else {
            if (index >= size) {
                System.out.println("index 입력이 잘못되었습니다.");
            } else { // 노드 삭제
                if (size == 1) { // 리스트 삭제
                    head = null;
                    tail = null;
                    size = 0;
                } else {
                    Node deleteNode = searchIndex(index); // 삭제 할 노드
                    if (deleteNode == head) { // 삭제 할 노드가 첫 노드일 때
                        Node headNode = deleteNode.getNext();
                        head = headNode;
                        headNode.setPrev(null);
                    } else if (deleteNode == tail) { // 삭제 할 노드가 마지막 노드일 때
                        Node tailNode = deleteNode.getPrev();
                        tail = tailNode;
                        tailNode.setNext(null);
                    } else { // 삭제 할 노드의 prev노드와 next노드를 연결
                        Node prevNode = searchIndex(index - 1);
                        Node nextNode = searchIndex(index + 1);
                        prevNode.setNext(nextNode);
                        nextNode.setPrev(prevNode);
                    }
                    size--;
                }
            }
        }
    }

    /**
     * Search node.
     * 입력받은 인덱스의 노드를 검색하여 출력하는 메소드
     * @param index the index
     */
    public void searchNode(int index) {
        if (size == 0) {
            System.out.println("리스트가 없습니다.");
        } else {
            if (index >= size) {
                System.out.println("index 입력이 잘못되었습니다.");
            } else {
                // 입력받은 인덱스에 해당하는 노드의 값을 출력
                System.out.println(searchIndex(index).getData());
            }
        }
    }

    /**
     * Print list.
     * 리스트를 출력하는 메소드
     */
    public void printList() {
        if (size == 0) {
            System.out.println("리스트가 없습니다.");
        } else {
            Node headNode = head; // 리스트의 첫 노드를 지정
            while (headNode != null) { // 마지막 노드일 때 까지 while문 반복
                System.out.print("[" + headNode.getData() + "] ");
                headNode = headNode.getNext();
            }
        }
    }
}
