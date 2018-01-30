# Data Preprocessing

#importing the dataset
dataset = read.csv('Data.csv')

# Taking care of missing data
dataset$Age = ifelse(is.na(dataset$Age), 
                     ave(dataset$Age, FUN = function(x) mean(x, na.rm = TRUE)),
                     dataset$Age)

dataset$Salary = ifelse(is.na(dataset$Salary), 
                     ave(dataset$Salary, FUN = function(x) mean(x, na.rm = TRUE)),
                     dataset$Salary)

#Encoding categorial data

dataset$Country = factor(dataset$Country,
                         levels=c('France', 'Spain', 'Germany'), #c in R is vector creation
                         labels=c(1,2,3)) #R will see these values as factors. 1,2,3 are just labels

dataset$Purchased = factor(dataset$Purchased,
                         levels=c('No', 'Yes'), 
                         labels=c(0,1))

#Splitting the dataset into the Training set and Test set
#install.packages('caTools')
library(caTools)
set.seed(123)
split = sample.split(dataset$Purchased, SplitRatio = 0.8)

# Feature Scaling
training_set[,2:3] = scale(training_set[,2:3]) # We scale only 2 and 3, because Country and Purchased
test_set[,2:3] = scale(test_set[,2:3])          # Are not actually numerics - those are factors
