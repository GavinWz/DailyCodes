#include<stdio.h>
#include<omp.h>
int main(){

    #pragma omp for   //单独使用for
        for(int i = 0; i < 4;i++){
            printf("%d, ThreadID = %d\n", i, omp_get_thread_num());
        }
    printf("The threads are same.\n\n");

    #pragma omp parallel for   //for与parallel搭配使用
        for(int i = 0; i < 4;i++){
            printf("%d, ThreadID = %d\n", i, omp_get_thread_num());
        }
    printf("The threads are not same.\n\n");

    #pragma omp parallel //for与parallel搭配且分别使用
    {
    #pragma omp for
        for(int i = 0; i < 4;i++){
            printf("%d, ThreadID = %d\n", i, omp_get_thread_num());
        }
        
    }   
    printf("Just same as the situation 2.\n\n");

    #pragma omp parallel //实现多个for并行
    {
    #pragma omp for
        for(int i = 0; i < 4;i++)
            printf("%d, ThreadID = %d\n", i, omp_get_thread_num());
            
    #pragma omp for 
        for(int j = 11; j < 15; j++)
            printf("%d, ThreadID = %d\n", j, omp_get_thread_num());
    }   
    printf("There are two 'for' running.\n\n");
}