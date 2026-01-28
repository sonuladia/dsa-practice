package leetcodeblind75;

public class StringCompression {

    public static void main(String[] args){
        char[] c = {'a', 'b', 'b', 'b', 'b', 'b', 'c', 'd','d','d'};
        System.out.println("Length of the compressed string is: " + compress(c));
    }

    public static int compress(char[] chars) {

        int i=0, j=0, groupLength = 0;
        StringBuilder s = new StringBuilder();

        while(j < chars.length){
            if(chars[i] == chars[j]){
                int len = j-i + 1;
                groupLength = Math.max(groupLength, len);
            } else {
                s.append(chars[i]);
                if(groupLength > 1){
                    s.append(groupLength);
                    groupLength = 1;
                }
                i = j;
            }
            j++;
        }
        return s.length();
    }
}
