package Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class draft {
    public static void main(String[] args) {
        String expression = "5 + ( (2+4-7) / 3 ) * 2";
        System.out.println(checkBrackets(expression));
        System.out.println(expression.toString());
        System.out.println(findIndexOfBrackets(expression));

        getSolution(findIndexOfBrackets(expression), expression);

    }

    public static Map<Character, Character> getBracketMap() {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        return brackets;
    }

    public static boolean checkBrackets(String expression) {
        Map<Character, Character> brackets = getBracketMap();
        Stack<Character> stack = new Stack<>();

        for (Character c : expression.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else {
                if (brackets.containsKey(c)) {
                    if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static List<Integer> findIndexOfBrackets(String expression) {
        List<Integer> indexBracketList = new ArrayList<>();
        Map<Character, Character> brackets = getBracketMap();
        List<Character> charList = new ArrayList<>();

        for (Character el : expression.replaceAll(" ", "").toCharArray()) {
            charList.add(el);
        }

        int counter = 0;

        for (Character c : charList) {

            if (brackets.containsValue(c) || brackets.containsKey(c)) {
                indexBracketList.add(counter);
            }
            counter += 1;
        }

        return indexBracketList;
    }

    public static void getSolution(List<Integer> indexBracketList, String expression) {
        List<Integer> halfArray0 = new ArrayList<>();
        List<Integer> halfArray2 = new ArrayList<>();
        expression = expression.replaceAll(" ", "");

        for (int i = 0; i < indexBracketList.size(); i++) {
            if (i < indexBracketList.size() / 2) {
                halfArray0.add(indexBracketList.get(i));
            }
            else {
                halfArray2.add(indexBracketList.get(i));
            }
        }   
        List<Integer> halfArray1 = halfArray0.reversed();
        List<Integer> finalIndexList = new ArrayList<>();

        for (int i = 0; i < halfArray0.size(); i++) {
            finalIndexList.add(halfArray1.get(i) + 1);
            finalIndexList.add(halfArray2.get(i) - 1);
        }
        System.out.println(finalIndexList.toString());

        List<Character> charList = new ArrayList<>();

        for (Character c : expression.toCharArray()) {
            charList.add(c);
        }

        List<Double> numberExpression = new ArrayList<>();
        List<Character> characterExpression = new ArrayList<>();
        
        for (int i = 0; i < finalIndexList.size(); i++) {
            for (int j = 0; j < finalIndexList.size()/2; j++) {
                if (Character.isDigit(charList.get(j))) {
                    double temp = Character.getNumericValue(charList.get(j));
                    numberExpression.add(temp);
                }
                else {
                    characterExpression.add(charList.get(j));
                }
            }
        }

        System.out.println(characterExpression.toString());
        System.out.println(numberExpression.toString());
    }
}

