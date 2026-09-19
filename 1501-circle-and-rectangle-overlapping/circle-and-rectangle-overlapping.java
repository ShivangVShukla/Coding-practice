class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if((xCenter+radius)<x1) return false;
        if((xCenter-radius)>x2) return false;
        if((yCenter+radius)<y1) return false;
        if((yCenter-radius)>y2) return false;
        int x=xCenter; int y= yCenter;
        if(xCenter<x1) x=x1;
        else if(xCenter>x2) x=x2;
        if(yCenter<y1) y=y1;
        else if(yCenter>y2) y=y2;
        int dx= xCenter-x;
        int dy= yCenter-y;
        if((dx*dx + dy*dy)<=radius*radius) return true;
        return false;
    }
}