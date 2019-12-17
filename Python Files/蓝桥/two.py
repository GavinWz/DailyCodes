string = "0100110001010001"
i = 0
array = []
array.append(0)
cnt = 0
while i < len(string):
    j = i + 1
    while j < len(string):
        if not array.__contains__(string[i:j]):
            print(string[i:j])
            array.append(string[i:j])
            cnt += 1
        j += 1
    i += 1
print(cnt)

# answer:80