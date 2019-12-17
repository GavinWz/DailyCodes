class dog():  #python3的写法，若为python2.7则需要在括号中加上object
    def __init__(self, name ,age):  #init为初始化方法，必须要有self形参，而且要在其他参数的前面
        self.name = name  #self代表的类本身的引用
        self.age = age
        self.legs = 4  #给类添加带默认值的属性
#python中，只要方法需要对类本身进行操作就需要在方法参数中加上self
#而且只能用self来调用当前类中的变量和方法
    def sit(self):
        print(self.name.title() + " is now sitting.")
    def roll(self):
        print(self.name.title() + " rolled over.")
my_dog = dog('miaoxuan', 1)
print("My dog's name is " + my_dog.name.title())
print("He is " + str(my_dog.age) + " year old")
print("He has " + str(my_dog.legs) + " legs.")
my_dog.sit()
my_dog.roll()
