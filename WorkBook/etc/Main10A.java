//FIFO
//Queue - offer, poll
//양방향연결리스트로 구현 (기존 LinkedList의 구현 형태임)

interface Queue<T> {
    void offer(T item);
    T poll();

    void print();
}

class Node<T> {

    //값
    T value;

    //연결된 노드 - 전, 후
    Node<T> prev;
    Node<T> next;

    //생성자
    public Node (T value) {
        this.value = value;
    }

    public Node (T value, Node<T> prev, Node<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}

class QueueImpl<T> implements Queue<T> {

    Node<T> first = null;
    Node<T> last = null;

    @Override
    public void offer(T v) {
        if (first == null) {
            Node<T> newNode = new Node<T>(v);
            first = newNode;
            last = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            Node<T> newNode = new Node<T>(v, last, first);
            last.next = newNode;
            first.prev = newNode;
            last = newNode;
        }
    }


    @Override
    public T poll() {
        if (first != null) {
            //원소가 1개일 때
            T value = first.value;
            if (first == last) {
                first = null;
                last = null;
            } else { //원소가 1개 초과
                first.next.prev = last;
                first.prev.next = first.next;
                first = first.next;
            }
            return value;
        } else {
            // 값이 없어 poll 불가하므로 예외 반환
            throw new IllegalArgumentException("empty");
        }
    }

    @Override
    public void print() {
        Node<T> node = first;

        if (node == null) return;

        while (node.next != first) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println(node.value);
    }

}

public class Main10A {

    public static void main(String[] args) {
        Queue<String> q = new QueueImpl<>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        q.poll();
        q.print();
    }
}