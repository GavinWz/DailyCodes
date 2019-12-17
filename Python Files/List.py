fruits = ['apple', 'banana', 'pear', 'peatch']  #创建
print(fruits)
print(fruits[1])
fruits[0] = 'you' #修改
messige = "I like " + fruits[0].title() + "."  #应用
print(messige)
fruits.append('cherry')  #向末尾添加
print(fruits)
fruits.insert(0, 'orange')  #插入
print(fruits)
del fruits[1]  #删除
print(fruits)
fruits.pop()  #删除最后一个元素
print(fruits)
fruits.pop(1)    #删除1号元素
print(fruits)
fruits.remove('pear')  #删除第一个值为'pear'的元素
print(fruits)
fruits = ['apple', 'peatch', 'pear', 'banana']
print(fruits)
print("\nsort:  \n")
print("升序")
print(sorted(fruits))   #临时排序（升序）
print(fruits)
fruits.sort()   #排序（升序）
print(fruits)
print("降序")
print(sorted(fruits,reverse=True))  #临时排序（降序）
print(fruits)
fruits.sort(reverse=True)  #排序（降序）
print(fruits)
print("反序")
fruits.reverse()  #反序
print(fruits)
print(len(fruits))  #获取长度
print("for循环：")  #for循环
for fruit in fruits:  
    print(fruit)
print("创建数字列表：")   
for value in range(1, 5):  #生成范围内（1-5）的整数，不包括第二个参数5的值
    print(value)
numbers = list(range(1, 6))  #创建1-6的数字列表
print(numbers)
print(list(range(2, 10, 2)))  #以2为增量从创建10以内的偶数
print("列表计算：")
digits = range(1, 10)
min = min(digits)
max = max(digits)
sum = sum(digits)
print("min =",min , "max =", max, "sum =", sum)
print("列表解析：")
squares = [value**2 for value in range(1, 11)] 
# 列表解析将for循环和创建新元素的代码合并成一行，并自动附加新元素
# 方括号内从左到右：
# 首先要定义一个表达式，用于生成将要存储到列表里的值
# 接下来是for循环，为列表提供一个个值
# 对每层for循环提供的值进行表达式计算后存到列表中
print(squares)
print("创建切片：") #创建切片
print(squares[1:6])  #输出下标为1-5的元素
# 索引范围为第一个元素下标到想要的到的最后一个元素的下标加1
print(squares[:5])  #从第一个元素到4号元素
print(squares[5:])  #从5号元素到最后一个元素
print("利用切片遍历:") 
pay = ['WeChat', 'Zhifubao', 'BankCard', 'Caifutong', 'Cash']
for money in pay[:3]:
    print(money.title)
print("列表复制：")  #利用切片进行列表复制
payment = pay  #此时payment获得pay的引用值，并无生成新的列表
# payment和pay任何一个改变列表元素的值都将引起另一个的改变
print(payment)
pay[3] = 'will change'
print("Change Pay[3], then payment is " + payment[3])
pay[3] = 'Caifutong'
payment = pay[:]  #利用切片进行复制，将把pay中元素遍历，生成新的一个列表复制给payment
print(payment)
print("元组:")  #元组的值定义后只能通过重新复制来改变，不能直接对元组的元素进行赋值
dimensions = (200, 50)  #注意此处为圆括号( ), 与列表的方括号[ ]有所不同
