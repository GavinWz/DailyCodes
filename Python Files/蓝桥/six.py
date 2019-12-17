n = int(input())
i = 1
cnt = 0
while i <= n:
    num = i
    while num > 0:
        judge = num % 10
        num = int(num / 10)
        if judge == 2 or judge == 0 or judge == 1 or judge == 9:
            # print(judge)
            cnt += 1
            break
    i += 1
print(cnt)

