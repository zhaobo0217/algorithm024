public class FirstUniqueChar {
  public int firstUniqChar(String s) {
      if (s == null || s.length() == 0) return -1;
      if(s.length() == 1) return 0;
      //利用queue的filo的特性，如果发现头部元素有重复的移除，否则头部元素就是结果；
      //时间空间复杂度都是O（n)
      Map<Character, Integer> record = new HashMap<>();
      Queue<Character> queue = new LinkedList<>();
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (record.containsKey(c)) {
              record.put(c, -1);
              //剪枝
              if(queue.isEmpty() || queue.peek() != c) continue;
              while(!queue.isEmpty() && record.getOrDefault(queue.peek(), 0) < 0) {
                  queue.poll();
              }
          }else {
              record.put(c, i);
              queue.offer(c);
          }
      }
      return queue.isEmpty() ? -1 : record.get(queue.peek());
  }

  public int firstUniqChar1(String s) {
      //方案一，使用hashmap记录位置，发现有重复位置的话，将对应的字符索引置为-1，遍历找出不为-1的最小索引即为结果
      //时间复杂度O(n),空间复杂度O(n)
      if (s == null || s.length() == 0) return -1;
      if(s.length() == 1) return 0;
      HashMap<Character, Integer> record = new HashMap<>();
      int res = Integer.MAX_VALUE;
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (record.containsKey(c)){
              record.put(c, -1);
          }else{
              record.put(c, i);
          }
      }
      for (Map.Entry<Character, Integer> entry : record.entrySet()){
          if(entry.getValue() > -1){
              res = Math.min(res, entry.getValue());
          }
      }
      return res == Integer.MAX_VALUE ? -1 : res;
  }
}
