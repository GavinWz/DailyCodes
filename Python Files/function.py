def greet_user():   #函数头，def关键字用来表示定义一个函数
    """显示问候语"""  #文档字符串的注释，生成函数的文档，对函数进行描述
    print("Hello!")
greet_user()  #无参

def greetuser(username):   #有参
    print("Hello " + username + "!")
greetuser('Zhege')
#多实参传递
def pet(animal_type, pet_name):  
    print("My " + animal_type + "'s name is " + pet_name)
pet('cat', 'Mimi')  #位置实参，实参传递需要依照形参的顺序
pet(pet_name = 'Mimi', animal_type = 'cat')  #关键字实参，根据形参名传递实参

#形参默认值
def girl(name, age = 18): #默认形参age的值为18
    print(name + " 's age is " + str(age))
girl(name = 'Liya')
girl('Liya', 20)  #也可以给默认的形参传递实参值
def Zhe(first_name, last_name):  
    full_name = first_name + ' ' + last_name
    return full_name.title()
print(Zhe('weizhe', 'yang'))
#返回字典
def build_person(first_name, last_name):
    person = {'first' : first_name, 'last' : last_name}
    return person
zhe = build_person('weizhe', 'yang')
print(zhe)
#可选实参
def person_name(first_name, last_name, mid_name = ''):
    if mid_name:
        full_name = first_name + ' ' + mid_name + ' ' + last_name
    else:
        full_name = first_name + ' ' + last_name
    return full_name
print(person_name('weizhe', 'yang').title())
print(person_name('kamanda', 'bonfils', 'david').title())
#列表传递, 
names = ['zhege', 'huihui', 'shujie', 'peibin']
def greet_users(names):
    names[0] = 'zhe'  #函数可对列表进行修改
    for name in names:
        message = "Hello, " + name.title() + "!"
        print(message)
greet_users(names)
#禁止函数修改列表
greet_users(names[:])  #传递列表的副本
#传递任意数量的实参
def phone(*phones):  #创建一个名为phones的空元组，将接收的参数值存入元组
    print(phones)
phone('Huawei')
phone('Honor', 'oppo', 'vivo', 'iPhone')
#结合位置实参和任意数量实参
def Phone(memory, *model):
    print("The memory of " + str(model) + " is " + memory)
Phone("8G", "Honor", "Huawei P20", 'vivo X23')
Phone("2G", "iPhone 5s")
#使用任意数量的关键字实参
user_info = {'like': 'code', 'phone': 'Broken_Honor_10'}
def build_profile(name, **user_inf):
    """创建一个字典，其中包含用户信息"""
    info = {}
    info['name'] = name
    for key, value in user_inf.items():
        info[key] = value
    return info
#调用时键没有引号，用等号代替冒号
print(build_profile('Zhege',like='code', phone='Broken_Honor_10')) #基于代码规范，等号两边不能有空格



