import os
import time
i = 0
while (i < 150):
    y = 1080 + 4 * 170
    # if i < 20: 
    #     os.system("adb shell input tap 900 %d", y)
    # elif i == 21:
    #     os.system("adb shell input tap 900 %d", y)
    # os.system("adb shell input tap 900 1080")
    os.system("adb shell input tap 500 800")
    time.sleep(2)
    os.system("adb shell input tap 520 800")
    time.sleep(1)
    os.system("adb shell input swipe 900 1600 900 500 6000")
    os.system("adb shell input swipe 900 1600 900 500 6000")
    os.system("adb shell input swipe 900 1600 900 500 6000")
    os.system("adb shell input swipe 900 1600 900 500 6000")
    os.system("adb shell input swipe 900 1600 900 500 6000")
    time.sleep(20)
    os.system("adb shell input keyevent 4")
    time.sleep(0.2)
    i += 1
    print(i)




