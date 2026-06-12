import java.util.*;

class continuousSubstring{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String t = sc.next();

    HashMap<Character, Integer> need = new HashMap<>();

    for(char c : t.toCharArray()){
      need.put(c, need.getOrDefault(c, 0) + 1);
    }
    HashMap<Character, Integer> window = new HashMap<>();

    int required = need.size();
    int formed = 0;

    int left = 0;
    int minLen = Integer.MAX_VALUE;
    int start = 0;

    for(int right = 0; right < s.length(); right++){
      char ch = s.charAt(right);

      window.put(ch, window.getOrDefault(ch, 0) + 1);

      if(need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()){
        formed++;
      }
      while(formed == required){
        if(right - left + 1 < minLen){
          minLen = right - left + 1;
          start = left;
        }
      
      char remove = s.charAt(left);

      window.put(remove, window.get(remove) - 1);

      if(need.containsKey(remove) && window.get(remove) < need.get(remove)){
        formed--;
      }
      left++;
      }
  }
  if(minLen == Integer.MAX_VALUE) System.out.println("-1");
  else System.out.println(s.substring(start, start + minLen));
}
}