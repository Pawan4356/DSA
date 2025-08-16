class revstr {
    public static void main(String[] args) {
        rec("Hello", 0);
    }
    public static void rec(String str, int ind) {
        if (ind >= str.length()) {
            return;
        }
        rec(str, ind + 1);
        System.out.print(str.charAt(ind));
    }
}
