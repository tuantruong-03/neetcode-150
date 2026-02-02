package com.neetcode.heapnpriorityqueue;


import java.util.concurrent.ThreadLocalRandom;

public class KClosestPointsToOrigin {
//    public int[][] kClosest(int[][] points, int k) {
//        // Max-heap that keeps the k closest points
//        // The point with the LARGEST distance is kept at the top
//        // so we can remove it when heap size exceeds k
//        PriorityQueue<Point> kClosestPoints = new PriorityQueue<>((a, b) -> b.distanceFromOrigin() - a.distanceFromOrigin());
//
//        // Iterate through all given points
//        for (int i = 0; i < points.length; ++i) {
//            Point point = new Point(points[i][0], points[i][1]);
//            kClosestPoints.add(point);
//            if (kClosestPoints.size() <= k) {
//                continue;
//            }
//            // If heap size exceeds k:
//            // Remove the farthest point (top of max heap)
//            // This ensures the heap always keeps k closest points
//            if (point.distanceFromOrigin() <= kClosestPoints.peek().distanceFromOrigin()) {
//                kClosestPoints.remove(); // remove kth-farthest point
//            }
//        }
//        // Convert heap result into 2D array
//        int[][] res = new int[kClosestPoints.size()][2];
//        int i = 0;
//
//        // Extract points from heap
//        for (Point point : kClosestPoints) {
//            res[i][0] = point.x;
//            res[i++][1] = point.y;
//        }
//        return res;
//    }

    record Point(int x, int y) {
        public int distanceFromOrigin() {
            return x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int targetIndex = points.length - k;
        partition(points, 0, points.length - 1, targetIndex);
        int[][] res= new int[k][];
        for (int i =0; i < k; ++i) {
            res[i] = points[targetIndex++];
        }
        return res;
    }

    private void partition(int[][] points, int left, int right, int targetIndex) {
        if (left == right) return;
        int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
        swap(points, pivotIndex, right);
        int pivotValue = distance(points[right]);
        int low = left;
        int high = right -1;
        while(low <= high) {
            while (low <= high && distance(points[low]) > pivotValue) low++;
            while (low <= high && distance(points[high]) < pivotValue) high--;
            if (low <= high) {
                swap(points, low, high);
                low++;
                high--;
            }
        }
        pivotIndex = low;
        swap(points, pivotIndex,  right);
        if (targetIndex > pivotIndex) {
            partition(points, pivotIndex + 1, right, targetIndex);
        } else if (targetIndex < pivotIndex) {
            partition(points, left, pivotIndex -1, targetIndex);
        }
    }

    private int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }

    private void swap(int[][] points, int rowA, int rowB) {
        int[] tempRow = points[rowA];
        points[rowA] = points[rowB];
        points[rowB] = tempRow;
    }
}
