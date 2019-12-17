#include<stdio.h>
#include<stdlib.h>
int main(){
    int* searchRange(int nums[], int numsSize, int target, int* returnSize);
    int nums[5];
    int n, target, i, j, size;
    scanf("%d", &n);
    for(i = 0; i < n; i++){
        scanf("%d", &nums[i]);
    }
    int *answer = searchRange(nums, n, 1, &size);
    printf("%d, %d", answer[0], answer[1]);
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* searchRange(int* nums, int numsSize, int target, int* returnSize){
    int i = 0, j = numsSize - 1, judge = 0;
    int temp, left, right;
    int *res = (int*)malloc(sizeof(int) * 2);
    *returnSize = 2;
    while(i <= j){
        temp = (i + j) / 2;
        if(nums[temp] > target)
            j = temp - 1;
        else if(nums[temp] < target)
            i = temp + 1;
        else{
            judge = 1;
            break;
        }
    }
    if(!judge){
        res[0] = res[1] = -1;
        return res;
    }
    left = right = temp;
    while(nums[left] == target && left >= 0)
        left--;
    while(nums[right] == target && right <= numsSize)
        right++;
    res[0] = ++left;
    res[1] = --right;
    return res;
}