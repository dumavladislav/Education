# -*- coding: utf-8 -*-
"""
Created on Tue May 15 12:32:46 2018

@author: dumavla
"""
import re
import pandas as pd;
import numpy as np;
from scipy.spatial import distance

file_obj = open("sentences.txt", "r")
sentenses = []
words = dict()
wordId = 0
for line in file_obj:
    sentenses.append(line.lower())
    splitted = re.split("[^a-z]", line.lower())
    splitted = list(filter(None, splitted))
    for word in splitted:
        if words.get(word) == None:
            words[word] = wordId
            wordId = wordId + 1
        else:
            print("Word " + word + " FOUND" )
file_obj.close()

matr = np.zeros([len(sentenses), len(words)])
sentNum = 0
for sentense in sentenses:
    splitted = list(filter(None, re.split("[^a-z]", sentense)))
    for word in splitted:
        matr[sentNum][words.get(word)] = matr[sentNum][words.get(word)] + 1

    sentNum = sentNum + 1

dists = []
i = 0
for v in matr:
    dists.append(distance.cosine(matr[0], v))

#splitted = [x for x in splitted if x!='']
#splitted = list(filter(None, splitted))

