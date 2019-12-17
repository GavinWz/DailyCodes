a = []
a.append(1)
a.append(1)
a.append(1)
i = 3
while i < 20190324:
    a.append(a[i-1] + a[i-2] + a[i-3])
    a[i] = a[i] % 10000
    i += 1
print(a[i-1])

# 答案：4569