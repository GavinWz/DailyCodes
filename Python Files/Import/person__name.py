def person_name(first_name, last_name, mid_name = ''):
    if mid_name:
        full_name = first_name + ' ' + mid_name + ' ' + last_name
    else:
        full_name = first_name + ' ' + last_name
    return full_name

def greet_users(names):
    names[0] = 'zhe'  #函数可对列表进行修改
    for name in names:
        message = "Hello, " + name.title() + "!"
        print(message)