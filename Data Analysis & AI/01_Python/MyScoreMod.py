def getSum(data):
    total = 0
    
    for i in data:
        total += i
    
    return total

def getMean(data):
    return getSum(data) / len(data)

def getMax(data):
    maxVal = data[0]
    
    for i in data[1:]:
        if i > maxVal:
            maxVal = i
    
    return maxVal

def getMin(data):
    minVal = data[0]
    
    for i in data[1:]:
        if i < minVal:
            minVal = i
    
    return minVal

def getTwoSum(num2, num1=1):
    total = 0
    
    if num1>num2:
        num1,num2 = num2,num1 #두수를 스왑시킴
    
    for i in range(num1, num2+1):
        total += i
    
    return total
