#include<stdio.h>
int main(){
    int k = 100;
    #pragma omp parallel for private(k)
    for(k = 0; k < 5; k++){
        printf("k = %d\n", k);
    }
    printf("Last k = %d\n", k);
    printf("The k out of the parallel didn't change.\
 It is different from the k in the parallel.\n");

    printf("\nfirstprivate\n");
    int i = 100;
    #pragma omp parallel for firstprivate(i)
    for(k = 0; k < 5; k++){
        i += k;
        printf("i + %d = %d\n", k, i);
    }
    printf("Last i = %d\n", i);
    printf("There are some operate with k, but its value haven't changed.\n");

    printf("\nlastprivate\n");
    int j = 1;
    #pragma omp parallel for firstprivate(j), lastprivate(j)
    for(k = 0; k < 5; k++){
        j *= k;
        printf("j * %d = %d\n", k, j);
    }
    printf("Last j = %d\n", j);
    printf("The value of j doesn't unchang after the operatation.\n");

    printf("threadprivate\n");
    int counter = 0;
    #pragma omp for threadprivate(counter)
    for(int n = 0; n < 5; n++){
        counter += n;
        printf("counter = %d", counter);
    }
    
}
    