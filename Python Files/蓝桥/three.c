#include<stdio.h>

int judge(int a){
    int b = 0;
    while(a > 0){
        b = a % 10;
        a /= 10;
        if(b == 2 || b == 4)
            return 0;
    }
    return 1;
}

int main(){
    int n = 2019, cnt = 0;
    int i, k;
    for(i = 1; i < n; i++){
        if(judge(i))
            for(int j = i + 1; j < n - i; j++){
                if(judge(j)){
                    k = n - i - j;
                    if(k > j && judge(k)){
                        cnt++;
                    }
                }
            }
    }
    printf("%d", cnt);
}