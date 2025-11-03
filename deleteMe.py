myDict = {"a": "b", "e": "z"}

myStr = "apples are good"
result = ""

for char in myStr:
    if char in myDict:
        result += myDict[char]
    else:
        result += char

print(result)
