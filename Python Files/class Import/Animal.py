class Animal():
    def __init__(self, name ,age):  
        self.name = name  
        self.age = age
        self.legs = 4  
    def sit(self):
        print(self.name.title() + " is now sitting.")
    def roll(self):
        print(self.name.title() + " rolled over.")