//Change the name of the class and add a main method


class Solution {
    private int moveLeft(int[] height,int leftIdx, int rightIdx) {
        //return the index of the next point
        int orgHeight = height[rightIdx-1];
        while(--rightIdx > leftIdx) {
            if(height[rightIdx-1] > orgHeight) {
                return rightIdx;
            }
        }
        return -1;
    }
    private int moveRight(int[] height,int leftIdx, int rightIdx) {
        //return the index of the next point
        int orgHeight = height[leftIdx-1];
        while(rightIdx > ++leftIdx) {
            if(height[leftIdx-1] > orgHeight) {
                return leftIdx;
            }
        }
        return -1;
    }
    private int calculateArea(int[] height, int leftIdx, int rightIdx) {
        int minHeight = height[leftIdx-1] < height[rightIdx-1] ? height[leftIdx-1] : height[rightIdx-1];
        return minHeight*(rightIdx-leftIdx);
    }
    public int maxArea(int[] height) {
        int leftIdx = 1;
        int rightIdx = height.length;
        int mArea, tempArea;
        mArea = tempArea = calculateArea(height, leftIdx, rightIdx);
        while(true) {
            if(height[leftIdx-1] > height[rightIdx-1]) {
                rightIdx = moveLeft(height, leftIdx, rightIdx);
                if(rightIdx < 0) {
                    return mArea;
                }
                else {
                    tempArea = calculateArea(height, leftIdx, rightIdx);
                    if(tempArea > mArea) {
                        mArea = tempArea;
                    }
                }
            }
            else if(height[rightIdx-1] > height[leftIdx-1]) {
                leftIdx = moveRight(height, leftIdx, rightIdx);
                if(leftIdx < 0) {
                    return mArea;
                }
                else {
                    tempArea = calculateArea(height, leftIdx, rightIdx);
                    if(tempArea > mArea) {
                        mArea = tempArea;
                    }
                }
            }
            else {
                int orgLeftIdx = leftIdx;
                int orgRightIdx = rightIdx;
                leftIdx = moveRight(height, orgLeftIdx, orgRightIdx);
                rightIdx = moveLeft(height, orgLeftIdx, orgRightIdx);
                if(leftIdx < 0 || rightIdx < 0) {
                    return mArea;
                }
                else {
                    tempArea = calculateArea(height, leftIdx, rightIdx);
                    if(tempArea > mArea) {
                        mArea = tempArea;
                    }
                }
            }
        }
    }
}
