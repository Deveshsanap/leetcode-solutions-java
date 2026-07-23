class Solution {
    public String longestCommonPrefix(String[] arr) {
        StringBuilder str = new StringBuilder();
        
        if (arr == null || arr.length == 0) {
            return str.toString(); 
        }

        for (int i = 0; i < arr[0].length(); i++) {
            char currentChar = arr[0].charAt(i);
            
            for (int j = 1; j < arr.length; j++) {
                if (i == arr[j].length() || arr[j].charAt(i) != currentChar) {
                    return str.toString(); 
                }
            }
            
            str.append(currentChar);
        }
        
        return str.toString(); 
    }
}