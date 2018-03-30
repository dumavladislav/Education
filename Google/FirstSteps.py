import numpy as np # Mathematical calculations
#import matplotlib.pyplot as plt # Ploting charts
import pandas as pd
print(pd.__version__)

city_names = pd.Series(['San Francisco','San Jose','Sacramento'])
population = pd.Series([852469,1015785,485199])

pd.DataFrame({'City Names':city_names, 'Population':population})

california_housing_dataframe = pd.read_csv("california_housing_train.csv", sep=",")
print(california_housing_dataframe.describe())
print(california_housing_dataframe.head())

#plt.figure();
#california_housing_dataframe.hist('housing_median_age')

cities = pd.DataFrame({ 'City name': city_names, 'Population': population })
print(type(cities['City name']))
print("------------------")
print(cities['City name'])


print(type(cities['City name'][1]))
print(cities['City name'][0])

print(cities[0:3])

print(population/3)

print(np.log(population))

print(population.apply(lambda val: val > 333))

cities['Area square miles'] = pd.Series([333,444,555])
cities['Population density'] = cities['Population']/cities['Area square miles']


cities['Is wide and has saint name'] = cities['City name'].apply(lambda name: name.startswith('San')) & (cities['Area square miles']>50)

print(city_names.index)
print(cities.index)
cities.reindex([2,0,1])