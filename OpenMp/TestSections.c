#include<stdio.h>
#include<omp.h>
int main(){
    #pragma omp parallel sections
    {
    #pragma omp section
        printf("Section1, Thread = %d\n", omp_get_thread_num());
    #pragma omp section
        printf("Section2, Thread = %d\n", omp_get_thread_num());
    #pragma omp section
        printf("Section3, Thread = %d\n", omp_get_thread_num());
    #pragma omp section
        printf("Section4, Thread = %d\n", omp_get_thread_num());
    }
    printf ("sections in 'sections' are executed in parallel and \
'sections' are executed sequentially.\n");
    #pragma omp parallel sections
    {
    #pragma omp section
        printf("Section5, Thread = %d\n", omp_get_thread_num());
    #pragma omp section
        printf("Section6, Thread = %d\n", omp_get_thread_num());
    #pragma omp section
        printf("Section7, Thread = %d\n", omp_get_thread_num());
    #pragma omp section
        printf("Section8, Thread = %d\n", omp_get_thread_num());
    }
    
}