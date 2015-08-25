public class RemoveADoubleB {

    public static void main(String[] args) {
        System.out.println(removeADoubleB("acbdbca"));
        System.out.println(removeADoubleB("a"));
        System.out.println(removeADoubleB("b"));
        System.out.println(removeADoubleB("aab"));
        System.out.println(removeADoubleB("abb"));
        System.out.println(removeADoubleB("aabb"));
    }

    private static String removeADoubleB(String input) {
        char[] in = input.toCharArray();
        int aCount = 0, bCount = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 'a')
                aCount++;
            else if (in[i] == 'b')
                bCount++;
        }
        
        char[] out = new char[in.length + bCount - aCount];
        
        for(int i = 0, j = 0; i < in.length && j < out.length;) {
            if(in[i] == 'b') {
                out[j] = 'b';
                j++;
                out[j] = 'b';
                j++;
                i++;
            } else if(in[i] != 'a') {
                out[j] = in[i];
                j++;
                i++;
            } else {
                i++;
            }
        }
        
        return String.valueOf(out);
    }
}