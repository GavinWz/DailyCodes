filename = 'file\\write_file.txt'
with open(filename, 'w') as file_object:  #'w'以写入模式打开文件
    #  'r'读取模式，'a'附加模式，'r+'读写模式.若省略模式参数即为只读模式
    file_object.write("I love coding!\n")  #将字符串写入文件，\n控制换行
    file_object.write("I love programing!\n")

#写入模式会将原有的内容全部覆盖，而附加模式不覆盖原有的内容，而是将新的内容附加在文件末尾
with open(filename, 'a') as file_object:  #'a'以附加模式打开文件
    file_object.write("Coding is interesting!\n")  #将字符串写入文件，\n控制换行
    file_object.write("Programing is interesting!\n")
