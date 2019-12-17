#include<stdio.h>
#include<omp.h>
int main(){
    #pragma omp parallel   //并行运行括号中程序
    {
        printf("Hello world!\n");
    }
    printf("\n");

    #pragma omp parallel num_threads(3)  //指定分配的线程数
    {
        printf("Hello!\n");
        printf("The threadID is %d\n", omp_get_thread_num());
    }
    printf("\n");
  
    
}