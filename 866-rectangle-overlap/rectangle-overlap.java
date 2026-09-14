class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long x1=rec1[0];
        long y1=rec1[1];
        long x2=rec1[2];
        long y2=rec1[3];
        long x3=rec2[0];
        long y3=rec2[1];
        long x4=rec2[2];
        long y4=rec2[3];
        if((x1<x4 && y1<y4) && (x2>x3 && y2>y3)) return true;
        return false;
    }
}