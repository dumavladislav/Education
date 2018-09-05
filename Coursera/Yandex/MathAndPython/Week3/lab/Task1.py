from scipy import optimize;
import numpy as np;
import math;
from matplotlib import pylab as plt;

x = np.arange(1, 30, 0.1)
y1 = np.sin(x / 5.) * np.exp(x / 10.) + 5 * np.exp(-x / 2.)
y = lambda x: np.sin(x / 5.) * np.exp(x / 10.) + 5 * np.exp(-x / 2.)

plt.plot(x,y1)

# Task 1
mmm = optimize.minimize(y, [12], method='BFGS')
print(mmm)
print("# Task 1 MIN: " + str(mmm.fun) + " in point " + str(mmm.x))

# Task 2
mmm = optimize.differential_evolution(y, bounds=[(1, 30)])
print(mmm)
print("# Task 2 MIN: " + str(mmm.fun) + " in point " + str(mmm.x))