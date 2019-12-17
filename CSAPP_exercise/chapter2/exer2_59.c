#include<stdio.h>
int main(){
    unsigned x = 0x89ABCDEF;
    unsigned y = 0x76543210;
    // unsigned s = (y >> 8) << 8 | (x & 0xFF);
    unsigned s = y & ~0xFF | (x & 0xFF);
    printf("%x", s);
}