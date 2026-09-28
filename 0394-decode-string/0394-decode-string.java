class Solution {
    class Pair {
        int number;
        String previousString;

        Pair(int number, String previousString) {
            this.number = number;
            this.previousString = previousString;
        }
    }
    public String decodeString(String s) {
         Deque<Pair> stack = new ArrayDeque<>();

        int currentNumber = 0;
        String currentString = "";

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {

                currentNumber = currentNumber * 10 + (c - '0');

            } else if (c == '[') {

                stack.push(new Pair(currentNumber, currentString));

                currentNumber = 0;
                currentString = "";

            } else if (c == ']') {

                Pair pair = stack.pop();

                String repeatedString = "";

                for (int i = 0; i < pair.number; i++) {
                    repeatedString += currentString;
                }

                currentString = pair.previousString + repeatedString;

            } else {

                currentString += c;
            }
        }

        return currentString;
    }
}