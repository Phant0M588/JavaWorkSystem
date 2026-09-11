import java.util.Scanner;
void main() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(GetNumSum(a, b));
        System.out.println(GetNumRek(a, b));
        System.out.println(GetNumSdwg(a, b));
        System.out.println(GetNumLog(a, b));
        System.out.println(GetNumDel(a, b));
}

public static int GetNumSum(int a, int b) {
    int x = 0;
    for (int i = 0; i < b; i++) {
        x += a;
    }
    return x;
}

public static int GetNumRek(int a, int b){
    if (b == 0){
        return 0;
    }
    return a + GetNumRek(a, b - 1);
}

public static int GetNumSdwg(int a, int b){
    int x = 0;
    while (b > 0){
        if ((b & 1) != 0){
            x += a;
        }
        a = a << 1;
        b = b >> 1;
    }
    return x;
}

public static int GetNumLog(int a, int b){
    double x = Math.log(a) + Math.log(b);
    double x1 = Math.pow(Math.E, x);
    int res = (int) Math.ceil(x1);
    return res;
}

public static  int GetNumDel(int a, int b){
    double a1 = (double) a;
    double b1 = (double) b;
    double x = a1 / (1 / b1);
    int res = (int) x;
    return res;
}