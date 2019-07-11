import pandas as pd
import matplotlib.pyplot as plt
from matplotlib import style
style.use('ggplot')
import numpy as np

web_stats = {'Day':[1,2,3,4,5,6],
                'Visitors': [43, 53,34,45,64,34],
                'Bounce_Rate': [65, 72,62,64,54,66]
            }

df = pd.DataFrame(web_stats)

#print(df.set_index('Day'))

print(df['Bounce_Rate'])
print(df.Visitors)
print(df[['Bounce_Rate', 'Visitors']])

print(df.Visitors.tolist())
print(np.array(df[['Bounce_Rate', 'Visitors']]))