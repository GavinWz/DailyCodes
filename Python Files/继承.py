class Animal():
    def __init__(self, name ,age):  
        self.name = name  
        self.age = age
        self.legs = 4  
    def sit(self):
        print(self.name.title() + " is now sitting.")
    def roll(self):
        print(self.name.title() + " rolled over.")

class Dog(Animal):  #括号中为父类
    """Dog继承自Animal"""
    def __init__(self, name, age):
        """子类继承父类的init方法"""
        super().__init__(name, age)  #super使得子类包含父类所有属性
        self.nickName = 'Wangcai'  #给子类添加新属性
    def About_it(self):  #给子类添加新方法
        print("It's nick name is " + self.nickName)
    def sit(self):  #对父类sit方法进行重写，覆盖父类中的sit方法
        print(self.nickName + " doesn't sit.")

My_dog = Dog('Miaoxuan', 1)  #测试继承效果
My_dog.sit()

