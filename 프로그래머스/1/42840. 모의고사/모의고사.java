import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int numOfOne = 0;
        int numOfTwo = 0;
        int numOfThree = 0;
        
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i % 5]) {
                numOfOne++;
            }
            if(answers[i] == student2[i % 8]) {
                numOfTwo++;
            }
            if(answers[i] == student3[i % 10]) {
                numOfThree++;
            }
        }
        
        int maxScore = Math.max(Math.max(numOfOne, numOfTwo), numOfThree);
        ArrayList<Integer> list = new ArrayList<>();
        
        if(numOfOne == maxScore)
            list.add(1);
        if(numOfTwo == maxScore)
            list.add(2);
        if(numOfThree == maxScore)
            list.add(3);
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}