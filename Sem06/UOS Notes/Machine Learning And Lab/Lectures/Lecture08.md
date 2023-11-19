# Best Subset Selection
* 

# Stepwise Selection
* For computational reasons, the subset selection cannot be applied for very large p =>  $2^p$ 
* Best subset selection also suffer from statistical problem - overfitting

## Forward Selection
* Begins with containing predictos and then adds predictors to the model one-at-a-time until all of the predictors are in the model
* In each step, the variable that gives the greatest additional improvement to the fit is added to the model
* Steps
	1. Let $M_0$ denote the null mode, which contains no predictors
	2. For k = 0, ..., p - 1
		1. Consider all p - k models that augument the predictors in $M_k$ with one additional predictor
		2. Choose the best among these $p-k$ models, and call it $M_K+1$. Here best is defined as having smallest RSS or highest $R^2$
	3. Select a single model from among M0, ..., Mp using cross validated prediction error, $C_p$ (AIC), BIC or adjusted $R^2$
* Computational advantage over best subset selection is clear
* It is not guaranteed to find the best possible model out of all $2^p$ models containing subsets of the p predictors => the model can only append a new predictor to already existing set => cannot recreate the subset in the middle of the selection

## Backward Selection
* Efficient alternative to best subset selection
* Steps
	1. Let Mp denote the full model, which contains all p predictors
	2. For k = p, p - 1, ... , 1
		1. Consider all k models that contain all but one of the predictors in Mk for a total of k - 1 predictors
		2. Choose the best among these k models, and call it Mk-1. Here best is defined as having smallest RSS or highest $R^2$ 
	3. Select a single besst model from among M0, ... , Mp using cross valudated prediction error, Cp (AIC), BIC, 
* Search only $1 + p(p+1)/2$ models, and so can be applied ins ettings where p is too lrage to apply best subset selection

##  Choosing the optimal model
* Model containing all of the predictors will always have sme smallest RSS adn the largest R^2, since they are training errors
