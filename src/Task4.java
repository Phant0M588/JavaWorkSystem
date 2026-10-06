import java.util.Scanner;

void main() {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int[] A = new int[a];
    System.out.println();
    for (int i = 0; i < a; i++) {
        A[i] = in.nextInt();
    }
    System.out.println();
    System.out.println(GetNumMa(a, A));
}
public static String GetNumMa(int a, int A[]){
    if (a%2 == 0){
        int b = a/2;
        int g = 0;
        while (g < b){
            for (int i = 0; i < a; i++){
                int H = A[i];
                for (int j = 0; j < a; j++){
                    if (H == A[j]){
                        g++;
                    }
                }
                if(g < b){
                    g = 0;
                }
                else if(g > b){
                    return H + " встречается " + g + " из " + a;
                }
                else {
                    return "Такого числа нет";
                }
            }
        }
    }
    else {
        int b = (int) (a/2 + 0.5);
        int g = 0;
        while (g < b){
            for (int i = 0; i < a; i++){
                int H = A[i];
                for (int j = 0; j < a; j++){
                    if (H == A[j]){
                        g++;
                    }
                }
                if(g <= b){
                    g = 0;
                }
                else if(g > b){
                    return H + " встречается " + g + " из " + a;
                }
                else {
                    return "Такого числа нет";
                }
            }
        }
    }
    return "";
}
