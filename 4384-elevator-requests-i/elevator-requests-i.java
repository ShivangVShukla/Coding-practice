class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int curr=0;
        int time=0;
        for(int i=0;i<requests.length;i++){
            if(requests[i]==curr) time+=0;
            else time += Math.abs(curr-requests[i]);
            curr =requests[i];
        }
        return time;
    }
}