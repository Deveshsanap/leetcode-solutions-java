class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else{
                if (stack.isEmpty()) {
                    return false;
                }
             if (map.get(stack.peek()) == c) {
                stack.pop();
            } else{
                return false;
            }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}