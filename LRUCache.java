/*Problem Statement
Shreya was building a smart attendance portal for her college.

To improve response time, the system stored recently accessed student records in a cache. However, the cache had limited capacity.

Whenever the cache became full and a new record needed to be added, the least recently used (LRU) record was automatically removed from the cache.

Your task is to implement this smart cache system and process a series of operations.

Input Format
The first line contains an integer Capacity — the maximum number of records the cache can store.

The second line contains an integer Q — the number of operations.

The next Q lines contain one of the following operations:

PUT key value — Insert or update a record in the cache.

GET key — Retrieve the value associated with the given key.

Output Format
For every GET operation:

Print the corresponding value if the key exists in the cache.

Otherwise, print -1.

Example
Input
Capacity = 2

Q = 5

PUT 1 10

PUT 2 20

GET 1

PUT 3 30

GET 2

Output
10

-1

Explanation:

1. PUT 1 10 → Cache: {1=10}

2. PUT 2 20 → Cache: {1=10, 2=20}

3. GET 1 → Returns 10, and key 1 becomes the most recently used.

4. PUT 3 30 → Cache is full. Key 2 is the least recently used, so it is removed.

5. GET 2 → Key 2 is no longer present, so print -1.

Constraints
1 ≤ Capacity ≤ 10⁵
1 ≤ Q ≤ 10⁵
1 ≤ key, value ≤ 10⁹

Hints (3) */
import java.util.*;

  class CacheNode{
    int key, value;
    CacheNode next, prev;

      CacheNode(int key, int value){
        this.key = key;
        this.value = value;
      }
  }

class LRU{
  private int capacity;
  private HashMap<Integer, CacheNode> map;

  private CacheNode head;
  private CacheNode tail;

  public LRU(int capacity){
    this.capacity = capacity;
    map = new HashMap<>();

      head = new CacheNode(-1, -1);
    tail = new CacheNode(-1, -1);

    head.next = tail;
    tail.prev = head;
  }

  private void remove(CacheNode node){
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void insertAtFront(CacheNode node){
    node.next = head.next;
    node.prev = head;

    head.next.prev = node;
    head.next = node;
  }

  public int get(int key){
    if(!map.containsKey(key)) return -1;

    CacheNode node = map.get(key);

    remove(node);
    insertAtFront(node);

    return node.value;
  }

  public void put(int key, int value){
    if(map.containsKey(key)){
      CacheNode node = map.get(key);

      node.value = value;
      remove(node);
      insertAtFront(node);

      return;
    }
    if(map.size() == capacity){
      CacheNode lru = tail.prev;

      remove(lru);
      map.remove(lru.key);
    }
      CacheNode newNode = new CacheNode(key, value);
      insertAtFront(newNode);
    map.put(key, newNode);
  }
}

public class LRUCache{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int capacity = sc.nextInt();
    int q = sc.nextInt();

    LRU cache = new LRU(capacity);

    while(q-- > 0){
      String op = sc.next();

      if(op.equals("PUT")){
        int key = sc.nextInt();
        int value = sc.nextInt();

        cache.put(key, value);
      } else if(op.equals("GET")){
        int key = sc.nextInt();

        System.out.println(cache.get(key));
      }
    }
  }
}
