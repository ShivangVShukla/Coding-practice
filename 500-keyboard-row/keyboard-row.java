class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        for(int i = 0; i < words.length; i++){
            String str = words[i].toLowerCase();
            boolean r1 = true;
            boolean r2 = true;
            boolean r3 = true;
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                if(!row1.contains(String.valueOf(ch))) r1 = false;
                if(!row2.contains(String.valueOf(ch))) r2 = false;
                if(!row3.contains(String.valueOf(ch))) r3 = false;
            }
            if(r1||r2||r3) ans.add(words[i]);
        }
        return ans.toArray(new String[0]);
    }
}