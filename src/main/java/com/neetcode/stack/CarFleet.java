package com.neetcode.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        new CarFleet().carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3} );
    }
    static class Car {
        int position;
        int speed;
        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort((a, b) -> a.position - b.position);
        // Monotonically decreasing stack
        Stack<Double> mono = new Stack<>();
        for (Car car : cars) {
            double time = (double) (target - car.position) / car.speed;
            while (!mono.isEmpty() && time >= mono.peek()) {
                mono.pop();
            }
            mono.add(time);
        }
        return mono.size();
    }
}
