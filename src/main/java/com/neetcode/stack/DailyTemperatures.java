package com.neetcode.stack;

import java.util.Date;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperaturesS1(new int[]{73,74,75,71,69,72,76,73});
    }
    static class Tuple {
        int temperature;
        int day;
        Tuple(int temperature, int day) {
            this.temperature = temperature;
            this.day = day;
        }
    }

    public int[] dailyTemperaturesS1(int[] temperatures) {
        int[] res = new int[temperatures.length];  // Result array, default values = 0
        Stack<Tuple> tuples = new Stack<>();       // Stack storing temperature & day index

        // Traverse from right to left
        for (int i = res.length -1 ; i >=0; --i) {
            if (i == res.length - 1) {
                res[i] = 0;                        // Last day has no future day
                tuples.push(new Tuple(temperatures[i], i));  // Push last day to stack
                continue;
            }

            Tuple peek = tuples.peek();             // Look at top of stack
            if (temperatures[i] < peek.temperature) {
                res[i] = peek.day - i;             // Next warmer day found at top
                tuples.push(new Tuple(temperatures[i], i));  // Push current day
                continue;
            }

            // Pop until finding a warmer temperature
            while (!tuples.isEmpty()) {
                Tuple localPeek = tuples.peek();
                if (temperatures[i] < localPeek.temperature) {
                    res[i] = localPeek.day - i;    // Found warmer day
                    break;
                }
                tuples.pop();                       // Remove days colder than current
            }
            tuples.push(new Tuple(temperatures[i], i));  // Push current day
        }
        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];       // Result array
        int[] stack = new int[n];     // Array to simulate stack
        int top = -1;                 // Stack pointer (-1 means empty)

        for (int i = n - 1; i >= 0; --i) {
            // Pop indices of temperatures <= current
            while (top >= 0 && temperatures[i] >= temperatures[stack[top]]) {
                top--;                // pop
            }
            // If stack not empty, top index is next warmer day
            res[i] = (top == -1) ? 0 : stack[top] - i;
            stack[++top] = i;         // push current index
        }

        return res;
    }

}
