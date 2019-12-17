import os
import time
os.system("adb shell input tap 960 1700")
time.sleep(0.2) 
while(30):
    
    # os.system("adb shell input tap 930 920")
    # time.sleep(0.5) 
    # os.system("adb shell input tap 930 1137")
    # time.sleep(0.5)
    os.system("adb shell input tap 930 1360")
    time.sleep(0.5) 
    os.system("adb shell input keyevent 4")
    time.sleep(1) 
    os.system("adb shell input tap 560 1500")
    time.sleep(0.5) 


