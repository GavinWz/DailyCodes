file_path = 'E:\\Python Files\\file\\pi.txt'
with open(file_path) as file_object:
    lines = file_object.readlines()
    #readlines()读取文件中的每一行，并将其存储在一个列表中

for line in lines:
    print(line.rstrip())
print()
print(lines[1])  #显示列表中存储的文件的第二行

#使用文件内容
pi_string = ""  #创建一个字符串来存储文件中的所有内容
for line in lines:
    pi_string += line.strip()
print(pi_string)
print(len(pi_string))
