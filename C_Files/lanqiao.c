#include<stdio.h>
int main(){
    int ans, i, j, m, n, temp;
    int atk[1000];
    scanf("%d%d", &n, &m);
    for(i = 0; i < n; i++){
        scanf("%d", &atk[i]);
    }
    for(i = 0; i < n; i++){
        for(j = 0; j < n - i - 1; j++){
            if(atk[j] > atk[j+1]){
                temp = atk[j];
                atk[j] = atk[j+1];
                atk[j+1] = temp;
            }
        }
    }
    printf("%d", atk[n-m] - 1);
}