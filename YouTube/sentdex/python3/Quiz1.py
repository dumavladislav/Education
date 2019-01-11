x = 1 
def test1(): 
    x = 2 
test1() 
print(x) #1

x = 1 
def test2(): 
    global x 
    x = 2 
test2() 
print(x) #2

x = [1] 
def test3(): 
    x = [2] 
test3() 
print(x) #[1]

x = [1] 
def test4(): 
    global x 
    x = [2] 
test4() 
print(x) #[2]

x = [1] 
def test5(): 
    x[0] = 2 
test5() 
print(x) #[2]