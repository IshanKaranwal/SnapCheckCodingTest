public class Encryption {
    public static String encrypt(String s) {
        s = s.replaceAll("\\s", "");
        int len = s.length();
        if (len == 0) {
            System.out.println("");
            return "";
        }
        int lowerBound = (int) Math.floor(Math.sqrt(len));
        int upperBound = (int) Math.ceil(Math.sqrt(len));
        if (lowerBound * lowerBound >= len) {
            upperBound = lowerBound;
        } else if (lowerBound * upperBound < len) {
            lowerBound = upperBound;
        }
        char[][] grid = new char[lowerBound][upperBound];
        int count = 0;
        for (int i = 0; i < lowerBound; i++) {
            for (int j = 0; j < upperBound; j++) {
                if (count >= len) {
                    break;
                }
                grid[i][j] = s.charAt(count);
                count++;
            }
        }
        String ans = "";
        for (int k = 0; k < upperBound; k++) {
            for(int l = 0; l < lowerBound; l++) {
                ans += grid[l][k];
            }
            ans = ans.concat(" ");
        }
        ans = ans.substring(0, ans.length() - 1);
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        encrypt("if man was meant to stay on the ground god would have given us roots");
        encrypt("have a nice day");
        encrypt("feed the dog");
        encrypt("chill out");
        encrypt("ab");
        encrypt("a");
        encrypt("");
    }
}