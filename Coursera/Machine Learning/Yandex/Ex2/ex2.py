# -*- coding: utf-8 -*-
"""
Created on Tue Dec  5 18:20:13 2017

@author: dumavla
"""

import pandas;
import numpy as np;
data = pandas.read_csv('C:/dumavla/Education/Coursera/Machine Learning/Yandex/Ex1/titanic.csv', index_col='PassengerId');

sex_dictionary = {'female': 1, 'male' : 2}
data['Sex'] = data['Sex'].apply(lambda x: sex_dictionary[x])

X = pandas.concat([data['Pclass'], data['Fare'], data['Age'], data['Sex'], data['Survived']], axis=1);
X = X.dropna();

y = X['Survived'];
X = pandas.concat([X['Pclass'], X['Fare'], X['Age'], X['Sex']], axis=1);

#print(X.count());

#print(X.count());





from sklearn.tree import DecisionTreeClassifier
clf = DecisionTreeClassifier(random_state=241)
clf.fit(X, y)
importances = clf.feature_importances_
print(importances)