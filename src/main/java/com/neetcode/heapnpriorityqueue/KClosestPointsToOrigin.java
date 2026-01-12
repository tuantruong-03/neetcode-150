package com.neetcode.heapnpriorityqueue;

import java.util.*;


public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap that keeps the k closest points
        // The point with the LARGEST distance is kept at the top
        // so we can remove it when heap size exceeds k
        PriorityQueue<Point> kClosestPoints = new PriorityQueue<>((a, b) -> b.distanceFromOrigin() - a.distanceFromOrigin());

        // Iterate through all given points
        for (int i = 0; i < points.length; ++i) {
            Point point = new Point(points[i][0], points[i][1]);
            kClosestPoints.add(point);
            if (kClosestPoints.size() <= k) {
                continue;
            }
            // If heap size exceeds k:
            // Remove the farthest point (top of max heap)
            // This ensures the heap always keeps k closest points
            if (point.distanceFromOrigin() <= kClosestPoints.peek().distanceFromOrigin()) {
                kClosestPoints.remove(); // remove kth-farthest point
            }
        }
        // Convert heap result into 2D array
        int[][] res = new int[kClosestPoints.size()][2];
        int i = 0;

        // Extract points from heap
        for (Point point : kClosestPoints) {
            res[i][0] = point.x;
            res[i++][1] = point.y;
        }
        return res;
    }

    record Point(int x, int y) {
        public int distanceFromOrigin() {
            return x * x + y * y;
        }
    }
}
