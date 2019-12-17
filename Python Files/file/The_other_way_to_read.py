#另一种写法：可将路径先由一个字符串变量储存
file_path = 'E:\\Python Files\\file\\pi.txt'
with open(file_path) as PI:
    Pi = PI.read()
    print(Pi)
    
        
