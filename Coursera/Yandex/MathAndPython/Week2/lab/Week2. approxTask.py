import numpy as np;
from scipy import linalg;
from matplotlib import pylab as plt

x = np.arange(1, 15, step=0.1)
y = np.sin(x / 5.) * np.exp(x / 10.) + 5 * np.exp(-x / 2.)

plt.plot(x,y)

x1 = np.array([1, 4, 10, 15])
y1 = np.sin(x1 / 5.) * np.exp(x1 / 10.) + 5 * np.exp(-x1 / 2.)

A = np.array([[1, 1, 1, 1],[1, 4, 16, 64],[1, 10, 100, 1000],[1, 15, 225, 3375]]);
b = np.array(y1)
res = linalg.solve(A, b)

#yappr = res[0]*x1[0]+res[1]*x1[0];
yappr = np.dot(A, res.T);

plt.plot(x1,yappr)