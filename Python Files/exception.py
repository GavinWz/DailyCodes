#处理ZeroDivisionError异常
print("Input two numbers:")
print("Input 'q' to exit")
while True:
    first = input("The first number: ")
    if first == 'q':
        break
    second = input("The second number: ")
    try:
        answer = int(first) / int(second)
    except ZeroDivisionError:
        print("You can't divide by zero!")
    else:  #else用来执行try代码块执行成功的后续操作
        print(str(answer))
#处理FileNotFoundError
filename = 'alice.txt'
try:
    with open(filename) as file_object:
        message = file_object.read()
except FileNotFoundError:
    msg = "The file " + filename +" does not exist."
    print(msg)
