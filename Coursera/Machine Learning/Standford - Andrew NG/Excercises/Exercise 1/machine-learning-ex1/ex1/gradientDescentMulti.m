function [theta, J_history] = gradientDescentMulti(X, y, theta, alpha, num_iters)
%GRADIENTDESCENTMULTI Performs gradient descent to learn theta
%   theta = GRADIENTDESCENTMULTI(x, y, theta, alpha, num_iters) updates theta by
%   taking num_iters gradient steps with learning rate alpha

% Initialize some useful values
m = length(y); % number of training examples
J_history = zeros(num_iters, 1);
%theta_history = zeros(1, size(theta,1)+1);

J_initial = computeCostMulti(X, y, theta);

for iter = 1:num_iters

    % ====================== YOUR CODE HERE ======================
    % Instructions: Perform a single gradient step on the parameter vector
    %               theta. 
    %
    % Hint: While debugging, it can be useful to print out the values
    %       of the cost function (computeCostMulti) and gradient here.
    %



	h = X*theta;
	for iter2=1:length(theta)
		%tempSum = 0;
		%for iter3=1:m
		%	tempSum = tempSum + (h(iter3)-y(iter3))*X(iter3,iter2);
		%end;
		%theta(iter2) = theta(iter2) - alpha/m*tempSum;
		
		theta(iter2) = theta(iter2) - alpha/m*sum((h - y)'*X(:,iter2));
		
	end;







    % ============================================================

    % Save the cost J in every iteration    
    J_history(iter) = computeCostMulti(X, y, theta);
	%theta_history = [theta_history; [iter;  theta]'];

end

%save J_history.txt J_history
%save theta_history.txt theta_history

end
