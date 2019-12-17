from Animal import Animal
#与导入函数模块类似，
#导入整个类：import Animal  调用类中属性和方法需要用类名来调用
#导入多个类：from Animal import Animal, Other, ……   用逗号分隔
#导入所有类：from Animal import *
#可从另一个模块中将类导入另一个模块，实质就是类的复制

Dog = Animal('miaoxuan', 1)
Dog.roll()
Dog.sit()
