import java.util.Deque;
import java.util.ArrayDeque;

class QueueInterfaceExercise2{
    
    public static Deque<Integer> changeSmallest(Deque<Integer> inputStack) {
        if (inputStack.isEmpty()) {
            return inputStack; // If stack is empty, return as is
        }
        
        int smallest = Integer.MAX_VALUE;
        int smallestCount = 0;
        Deque<Integer> tempQueue = new ArrayDeque<>();
        
        // Find the smallest element and count its occurrences
        for (Integer num : inputStack) {
            if (num < smallest) {
                smallest = num;
                smallestCount = 1;
            } else if (num == smallest) {
                smallestCount++;
            }
        }
        
        // Rearrange the stack
        while (!inputStack.isEmpty()) {
            Integer current = inputStack.pop();
            if (!current.equals(smallest)) {
                tempQueue.push(current);
            }
        }
        
        // Push smallest elements to the bottom of the stack
        for (int i = 0; i < smallestCount; i++) {
            inputStack.push(smallest);
        }
        
        // Push back the elements from tempQueue to inputStack
        while (!tempQueue.isEmpty()) {
            inputStack.push(tempQueue.pop());
        }
        
        return inputStack;
    }

    public static void main(String[] args) {
        
        Deque<Integer> inputStack = new ArrayDeque<>();
        inputStack.push(10);
        inputStack.push(8);
        inputStack.push(5);
        inputStack.push(12);
        inputStack.push(5);
    
        Deque<Integer> updatedStack = changeSmallest(inputStack);
        
        System.out.println("Stack After Modification:");
        for (Integer value : updatedStack)
            System.out.println(value);
    }
}
