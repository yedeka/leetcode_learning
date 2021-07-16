package com.educative.algods.crashcourse.twoPointers;

public class TrappingRainWater {
    private static int trapRainWater(int[] elevations){
        int n = elevations.length;
        int[] leftWalls = new int[n];
        int[] rightWalls = new int[n];

        int maxLeftWall = 0;
        for (int i = 0; i < n; i++) {
            leftWalls[i] = maxLeftWall;
            maxLeftWall = Math.max(elevations[i], maxLeftWall);
        }

        int maxRightWall = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightWalls[i] = maxRightWall;
            maxRightWall = Math.max(elevations[i], maxRightWall);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int elevation = elevations[i];
            int lowestWall = Math.min(leftWalls[i], rightWalls[i]);
            if (lowestWall > elevation) {
                totalWater += lowestWall - elevation;
            }
        }

        return totalWater;
    }
    public static void main(String[] args){
        int[] nums = new int[]{3, 2, 1, 2, 2, 3, 2};
        int iRainWater = trapRainWater(nums);
        System.out.println("Total trapped rain water => "+iRainWater);
    }
}
