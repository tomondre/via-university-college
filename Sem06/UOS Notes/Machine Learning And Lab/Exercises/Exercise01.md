1.  For each of parts (a) through (d), indicate whether we would generally expect the performance of a flexible statistical learning method to be better or worse than an inflexible method. Justify your answer
	1. The sample size n is extremely large, and the number of predictors p is small. - ==flexible==, because it suits better set with bigger number of data
	2. The number of predictors p is extremely large, and the number of observations n is small. - ==in-flexible==, because it suits better set with smaller number of data
	3. The relationship between the predictors and response is highly non-linear. - ==flexible==, because the relationship is not 
	4. The variance of the error terms, i.e. σ2 = Var(ε), is extremely high. - ==flexible==

2. Explain whether each scenario is a classification or regression prob- lem, and indicate whether we are most interested in inference or pre- diction. Finally, provide n and p.
	1. We collect a set of data on the top 500 firms in the US. For each firm we record profit, number of employees, industry and the CEO salary. We are interested in understanding which factors affect CEO salary. - ==inference==, because 
	2. We are considering launching a new product and wish to know whether it will be a success or a failure. We collect data on 20 similar products that were previously launched. For each prod- uct we have recorded whether it was a success or failure, price charged for the product, marketing budget, competition price, and ten other variables. - ==Prediction==
	3. We are interested in predicting the % change in the USD/Euro exchange rate in relation to the weekly changes in the world stock markets. Hence we collect weekly data for all of 2012. For each week we record the % change in the USD/Euro, the % change in the US market, the % change in the British market, and the % change in the German market. - ==prediction==
3. We now revisit the bias-variance decomposition
	1. Provide a sketch of typical (squared) bias, variance, training error, test error, and Bayes (or irreducible) error curves, on a single plot, as we go from less flexible statistical learning methods towards more flexible approaches. The x-axis should represent the amount of flexibility in the method, and the y-axis should represent the values for each curve. There should be five curves. Make sure to label each one.
	2. Explain why each of the five curves has the shape displayed in part (a).
4. You will now think of some real-life applications for statistical learning
	1. Describe three real-life applications in which classification might be useful. Describe the response, as well as the predictors. Is the goal of each application inference or prediction? Explain your answer.
		* Classification can be useful for image recognition and labelling the image with labels of what items are in the picture
			* Inference
		* Email spam filtering
			* Prediction
		* The goal of classification is a prediction
		* The response consist of most probable response based on the predictors
		* 