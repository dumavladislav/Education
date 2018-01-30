# Data Preprocessing

# Importing the libraries
import numpy as np # Mathematical calculations
import matplotlib.pyplot as plt # Ploting charts
import pandas as pd # Import and manage datasets

# Importing the dataset

# 1. Set the working folder - where the data sources are
# Import using pandas

dataset = pd.read_csv('Data.csv')

X = dataset.iloc[:, :-1].values #take all rows, all columns except the last one
y = dataset.iloc[:, 3].values

# ------------------------------------ Taking care of missing data
# The idea is the following: for each feature we replace missing data with the mean value
from sklearn.preprocessing import Imputer

imputer = Imputer(  # imputer - object of class Imputer
        missing_values = 'NaN', 
        strategy = 'mean', 
        axis = 0); #axis = 0 means the mean of the columns
        
imputer = imputer.fit(X[:, 1:3]) # 1-3 actually means columns 1 and 2 - upper bound is excluded
X[:, 1:3] = imputer.transform(X[:, 1:3]);

# ------------------------------------ Encode Categotical Data
# We need to encode categorical data, because it's not possible to use strings in the equasions.
# We need to replace strings with codes (numbers)

from sklearn.preprocessing import LabelEncoder, OneHotEncoder
labelEncoder_X = LabelEncoder();
X[:,0] = labelEncoder_X.fit_transform(X[:, 0]); # replace country names with digital codes

# replacing country codes with digital codes is not a very good approach, because it can affect the model - 
# France with code 0 will considered to be worse/smaller at certain sense than Germany with code 1 etc.
# The better way to align Countries weights is to split one column "Country" into separate columns "France", "Germany" etc.
# And use 0/1 codes in these columns

oneHotEncoder = OneHotEncoder(categorical_features = [0]);
X = oneHotEncoder.fit_transform(X).toarray();

labelEncoder_y = LabelEncoder();
y = labelEncoder_y.fit_transform(y);


# ------------------------------------ Splitting the dataset into the Training set and Test set
from sklearn.cross_validation import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)

# ------------------------------------ Features scaling
from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.transform(X_test) #We don't need to fit sc_X to X_test, because it's already fitted to X_train