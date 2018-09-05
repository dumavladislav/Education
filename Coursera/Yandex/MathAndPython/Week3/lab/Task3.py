import numpy as np;
from scipy import optimize;
from matplotlib import pylab as plt;

x = np.arange(1, 30, 0.1)
y1 = np.sin(x / 5.) * np.exp(x / 10.) + 5 * np.exp(-x / 2.)
y_gr = [int(y1_val) for y1_val in y1]
y_func = lambda x: int(np.sin(x / 5.) * np.exp(x / 10.) + 5 * np.exp(-x / 2.))

plt.plot(x,y_gr)

mmm = optimize.minimize(y_func, [30], method='BFGS')
print(mmm)
print("# Task 1 MIN: " + str(mmm.fun) + " in point " + str(mmm.x))

print("----------------------------------------------")    

mmm = optimize.differential_evolution(y_func, [(1,30)])
print(mmm)
print("# Task 2 MIN: " + str(mmm.fun) + " in point " + str(mmm.x))