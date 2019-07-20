public class sol_38 {
    //solution 1
    public String countAndSay_1(int n) {
        StringBuilder s = new StringBuilder("1");
        for (int i = 0; i < n-1; i++) {
            StringBuilder ns = new StringBuilder();
            for (int j = 0; j < s.length();) {
                int u = 1;
                while ((j + u) < s.length() && s.charAt(j) == s.charAt(j + u)) {
                    u++;
                }
                ns.append(u);
                ns.append(s.charAt(j));
                j += u;
            }
            s = ns;
            // System.out.println("i: " + i + ", s: " + s);
        }
        return s.toString();
    }

    //solution 2
    public String countAndSay_2(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }

    public String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
