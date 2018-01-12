function ThetaV = gradientDescent(X, y, theta, alpha, iterations)

m = length(y);
h = X*theta;
tempSum = 0
for i=1:iterations
	for j=1:length(theta)
		tempSum = tempSum + (h(i)-y(i))*x(i,j);
	end;
	theta(j) = theta(j) - alpha/m*tempSum;
end;

end
