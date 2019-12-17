with open('file/pi_digits.txt') as file_object:
#open()：参数为需要打开的文件的名称，调用后将文件打开
#open的参数可是相对路径也可是绝对路径
#with在不在需要访问文件后合适的时间将其关闭
#读取后只能遍历一遍
    contents = file_object.read()
    print(contents)
    for line in file_object:  #逐行读取，不输出空白行  
        print(line.rstrip())  #注：因只能遍历一遍，这两行和上面两行只能同时执行一个
