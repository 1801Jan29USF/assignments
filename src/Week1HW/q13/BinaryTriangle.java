package Week1HW.q13;

/**
 * Functionality: Implements a simple flip
 */
public class BinaryTriangle {
    int flip(int i){
        if(i==0)return 1;
        else return 0;
    }
    void generateTriangle(int n){
        int x = 1;
        for (int i = 1; i <= n; i++) {//loop to print new lines
            for (int j = 0; j < i; j++) {//loop to print each line
                x = flip(x);
                System.out.print(x);

            }
            System.out.println();
        }
    }
}
