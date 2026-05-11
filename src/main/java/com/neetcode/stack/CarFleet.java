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

class CarFleetPractice {
    static class Car {
        int position;
        int speed;
        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; ++i) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort((a, b) -> b.position - a.position);
        Stack<Double> stack = new Stack<>();
        // Monotonic Increasing Stack (by arrival time)
        //
        // Each value in the stack represents the arrival time
        // of a car fleet reaching the target.
        //
        // Cars are sorted by position in descending order,
        // meaning we process cars from closest to target
        // to the farthest behind.
        //
        // Key idea:
        // - If a car behind needs LESS or EQUAL time
        //   than the fleet ahead, it will catch up
        //   and merge into that fleet.
        // - Since overtaking is not allowed,
        //   the merged fleet keeps the SAME arrival time
        //   as the slower front fleet.
        //
        // Therefore:
        // - If current car's time > stack.peek(),
        //   the current car cannot catch the fleet ahead,
        //   so it forms a NEW fleet.
        // - Otherwise,
        //   it merges into the existing fleet ahead.
        //
        // The stack remains monotonically increasing
        // because every new fleet must have a strictly
        // larger arrival time than the fleet before it.
        for (Car car : cars) {
            double time = (double)(target - car.position) / car.speed;
            if (stack.isEmpty()) {
                stack.add(time);
                continue;
            }
            if (time > stack.peek()) {
                stack.add(time);
            }
        }
        return stack.size();
    }
}
