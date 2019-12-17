from ctypes import *
import time
time.sleep(5)
for i in range(1,5):
	windll.user32.SetCursorPos(696,231)
	time.sleep(5)
	windll.user32.SetCursorPos(696,231)