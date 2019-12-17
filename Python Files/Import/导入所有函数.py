from person__name import *  
#星号*使得模块person__name中的每个函数都复制到此程序文件中

names = ['zhege', 'miaoxuan', 'huihui', 'shujie', 'peibin']
greet_users(names)  #用别名来调用其中函数

print(person_name('weizhe', 'yang').title())
print(person_name('kamanda', 'bonfils', 'david').title())