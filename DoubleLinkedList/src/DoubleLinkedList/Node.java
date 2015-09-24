package DoubleLinkedList;

/**
 * 노드 클래스
 * @param <T>  the type parameter
 */
public class Node<T> {
    // 노드객체마다 data값과 이전노드를 가리키는 prev변수와 다음노드를 가리키는 next변수를 갖음
    private Node<T> next;
    private Node<T> prev;
    private T data;

    /**
     * Instantiates a new Node.
     * 노드클래스의 생성자
     * @param input the input
     */
    public Node(T input) {
        this.data = input;
        this.next = null;
        this.prev = null;
    }

    /**
     * Sets next.
     * 다음노드를 가리키는 next 변수를 초기화하는 메소드
     * @param next the next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Sets prev.
     * 이전노드를 가리키는 prev 변수를 초기화하는 메소드
     * @param prev the prev
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Gets next.
     * 다음노드를 반환하는 메소드
     * @return the next
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Gets prev.
     * 이전노드를 반환하는 메소드
     * @return the prev
     */
    public Node<T> getPrev() {
        return this.prev;
    }

    /**
     * Gets data.
     * 노드의 data 값을 반환하는 메소드
     * @return the data
     */
    public T getData() {
        return this.data;
    }
}
