import time

t1 = time.time()
n = 2019

def judge(a):
    b = 0
    while a > 0:
        b = a % 10
        a = int(a / 10)
        if b == 2 or b == 4:
            return False
    return True

i = 1
cnt = 0
while i < n:
    # print(i)
    if judge(i):
        j = i + 1
        while j < n - i:
            if judge(j):
                k = n - i - j
                if k > j and judge(k):
                    cnt += 1
            j += 1
    i += 1     
print(time.time() - t1)   
print(cnt)

answer: 40785