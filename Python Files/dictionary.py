print('字典：')
Zhege = {'age' : 19, 'tall' : 180, 'He_is' : 'Clever'}
# 冒号前叫键(Key)冒号后叫值(value),每个键都与一个值相关联，可以用键来访问值
print(Zhege['age'])
print('He is ' + Zhege['He_is'])
print("添加键-值对:")
print(Zhege)
Zhege['weigth'] = 150
Zhege['wait'] = 'Huihui'
print(Zhege)
print("创建空字典，一一添加键-值对:")
zhege = {}
zhege['age'] = 19
zhege['tall'] = 180
zhege['He_is'] = 'Clever'
print(zhege)
print("删除键-值对:")
del zhege['tall']
print(zhege)
#上面的Zhege为一个对象的多种信息组成的字典，也可用字典存储多个对象的同一种信息
languages = {
    'Gavin' :'python',
    'Alan' : 'go',
    'Han' : 'Java',
    'long' : 'c'
    }
print("遍历字典：")
for key, value in Zhege.items():
    print(key + ": ")
    print(value)
print("遍历所有键：")
for key in Zhege.keys():  #此处将.keys()去掉效果相同，加.key()增强效果
    print(key)
print("利用sorted函数，按特定顺序(从小到大)遍历所有键：")
for key in sorted(Zhege.keys()):
    print(key)
print("遍历所有值:")
for language in languages.values():
    print(language)
#嵌套：将一系列字典存储在列表中，或将列表作为值存储在字典中，或将字典存在字典中，称为嵌套
print("字典列表:") #将多个字典信息存储在一个列表中
alien_0 = {'color' : 'green', 'points' : 5}
alien_1 = {'color' : 'yellow', 'points' : 10}
alien_2 = {'color' : 'red', 'points' : 15}
aliens = [alien_0, alien_1, alien_2]
for alien in aliens:
    print(alien)
#input()函数
message = input("Tell me something, and I will repeat it back to you:")
print(message)

