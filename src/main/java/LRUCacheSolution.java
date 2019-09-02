/* package whatever; // don't place package name! */

import java.util.*;

class LRUCacheSolution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        LRUCache cache = new LRUCache(1000);

        while (!scanner.hasNext("exit")) {
            if (scanner.hasNext("add")) {
                scanner.next();
                String key = scanner.next();
                String value = scanner.next();
                cache.add(key, value);
            }
            if (scanner.hasNext("get")) {
                scanner.next();
                String key = scanner.next();
                cache.get(key);
            }
            if (scanner.hasNext("remove")) {
                scanner.next();
                String key = scanner.next();
                cache.remove(key);
            }
            if (scanner.hasNext("evict")) {
                scanner.next();
                cache.evict();
            }
        }

        Node pointer = cache.getHead();
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }


    static class Node {
        String key;
        String value;
        Node prev;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {
        Node head;
        Node tail;
        HashMap<String, Node> map = null;
        int cap = 0;

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.map = new HashMap();
        }

        public Node getHead() {
            return head;
        }

        // Remove the eldest entry(the least recently accessed(add or get) entry).
        public void evict() {
            remove(head.key);
            head = head.next;
        }

        // Add items that match the key and value to the data structure.
        public void add(String key, String value) {
            if (map.containsKey(key)) {
                Node t = map.get(key);
                t.value = value;

                removeNode(t);
                offerNode(t);
            } else {
                if (map.size() >= cap) {
                    map.remove(head.key);
                    removeNode(head);
                }

                Node node = new Node(key, value);
                offerNode(node);
                map.put(key, node);
            }
        }

        // Returns the value of the item that matches the key. An exception occurs if no item is found.
        public String get(String key) {
            if (map.get(key) == null) {
                System.out.println("-1");
                return null;
            }

            Node t = map.get(key);

            removeNode(t);
            offerNode(t);
            System.out.println(t.value);
            return t.value;
        }

        // Returns the value of the item that matches the key and then removes it from the data structure. An exception occurs if no item is found.
        public String remove(String key) {
            Node n = map.get(key);
            if (n == null) {
                System.out.println("-1");
                return null;
            }
            map.remove(key);
            if (n.prev != null) {
                n.prev.next = n.next;
            } else {
                head = n.next;
            }

            if (n.next != null) {
                n.next.prev = n.prev;
            } else {
                tail = n.prev;
            }
            System.out.println(n.value);
            return n.value;
        }

        private void removeNode(Node n) {
            if (n.prev != null) {
                n.prev.next = n.next;
            } else {
                head = n.next;
            }

            if (n.next != null) {
                n.next.prev = n.prev;
            } else {
                tail = n.prev;
            }
        }

        private void offerNode(Node n) {
            if (tail != null) {
                tail.next = n;
            }

            n.prev = tail;
            n.next = null;
            tail = n;

            if (head == null) {
                head = tail;
            }
        }
    }
}
