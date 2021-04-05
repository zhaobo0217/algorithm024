public class FindUniqChar{

    public int firstUniqChar(String s){
        //使用队列，FIFO,需要一个hashmap记录重复出现，每次移除队列中重复出现的头部元素，队列队列为empty就是没有，否则就为头部位置索引;时间复杂度O(n),空间复杂度为O(n);
        if(s == null || s.length() == 0) return -1;
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> record = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(record.containsKey(c)){
                record.put(c, -1);
                while(!queue.isEmpty() && record.get(queue.peek()) == -1){
                    queue.poll();
                }
            }else{
                queue.offer(c);
                record.put(c, i);
            }
        }
        return queue.isEmpty() ? -1 : record.get(queue.poll());
    }

    public int firstUniqChar2(String s){
        //使用hashMap记录字符出现次数，再次循环找出第一个出现1次的，时间复杂度O(n),空间复杂度O(n)
        //也可以使用hashmap记录字符索引，将重复出现的索引改为-1，循环hashmap找出索引最小的那个
        if(s == null || s.length() == 0) return -1;
        Map<Character, Integer> recordMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            recordMap.put(c, recordMap.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int value = recordMap.getOrDefault(c, 0);
            if(value == 1) return i;
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        //双指针法，最差时间复杂度为O(n^2),空间复杂度为最差O(n)
        if(s == null || s.length() == 0) return -1;
        if(s.length() == 1) return 0;
        int l = 0, r = 0;
        Set<Character> record = new HashSet<>();
        while(l < s.length() - 1){
            r = l + 1;
            while(r < s.length()){
                if(s.charAt(l) == s.charAt(r) || record.contains(s.charAt(l))){
                    record.add(s.charAt(l));
                    break;
                }
                if(r == s.length() - 1){
                    return l;
                }
                r++;
            }
            l++;
        }
        return record.contains(s.charAt(r)) ? -1 : r;
    }
}
