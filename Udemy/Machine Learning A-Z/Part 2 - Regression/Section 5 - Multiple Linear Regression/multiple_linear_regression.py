# Multiple Linear Regression

# ------------- Data Preprocessing

# Importing the libraries
import numpy as np # Mathematical calculations
import matplotlib.pyplot as plt # Ploting charts
import pandas as pd # Import and manage datasets

# Importing the dataset
dataset = pd.read_csv('50_Startups.csv')
X = dataset.iloc[:, :-1].values
y = dataset.iloc[:, 4].values

# ------------------------------------ Encode Categotical Data
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
labelEncoder_X = LabelEncoder();
X[:,3] = labelEncoder_X.fit_transform(X[:, 3]); # replace country names with digital codes
oneHotEncoder = OneHotEncoder(categorical_features = [3]);
X = oneHotEncoder.fit_transform(X).toarray();
labelEncoder_y = LabelEncoder();
y = labelEncoder_y.fit_transform(y);

# Splitting the dataset into the Training set and Test set
from sklearn.cross_validation import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)

# Features scaling
"""from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.transform(X_test)"""