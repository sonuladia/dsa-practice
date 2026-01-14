public class NoOfSubstringsWithAll3Char {

    public static void main(String[] args){
        String s = "abcabc";
        System.out.println("No. of Substrings: " + numberOfSubstrings(s));
    }
    public static int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int count = 0;

        for(int i=0; i < s.length(); i++){
            lastSeen[s.charAt(i) - 'a'] = i;
            if(lastSeen[0] != -1
                    && lastSeen[1] != -1
                    && lastSeen[2] != -1){
                count = count + (1+Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]));
            }
        }
        return count;
    }

    /*            int c = s.charAt(i) - 'a';
            System.out.println("lastseen " + c + " i: " + i);*/
    //System.out.println("LastSeen: " + lastSeen[0] + " " + lastSeen[1] + " " + lastSeen[2]);
}
