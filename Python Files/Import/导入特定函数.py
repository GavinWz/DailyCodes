#导入某一模块中的某(些)特定函数
from person__name import person_name  
#若要导入多个函数，只需要在import后将函数名全部列出，用逗号隔开就可以
#导入特定函数的话就可以直接拿来用，不需再通过模块名加 . 来调用
print(person_name('weizhe', 'yang').title())
print(person_name('kamanda', 'bonfils', 'david').title())