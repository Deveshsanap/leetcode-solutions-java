class Solution {
    public int lengthOfLongestSubstring(String str) {
         int start = 0;
        int end = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < str.length()) {
            if (!set.contains(str.charAt(end))) {
               set.add(str.charAt(end));
               maxLength=Math.max(maxLength,end-start+1);
               end++;
            }else{
                set.remove(str.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}