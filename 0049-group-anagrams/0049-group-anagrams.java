class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
         HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            char[] arr = str[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (map.containsKey(key)) {
                map.get(key).add(str[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str[i]);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}