a = [1,2,3,4,5]
if a[0] == 1:
    print('true')
else:
    print('false')
if a[0] == 3:
    print('OK')
elif a[0] == 1 and a[1] == 2:  #python中else if 的写法为elif
    print('true')
if 1 in a:  #判断特定元素是否在指定列表中
    print('true')
you_are_sb = True  #布尔表达式，值为True或者False
you_are_good = False
List = []
if List:  #判断列表是否为空
    print("yes")
else:
    print('No')