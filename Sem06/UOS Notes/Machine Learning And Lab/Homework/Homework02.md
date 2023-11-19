# Solution01 - 4.8, Q5 - Differences between LDA and QDA
1. We expect LDA to be a better fit for both the training set and test set because the LDA looks for correlation in a linear manner
2. If the decision boundary is non-linear, we expect QDA to perform better because it can fit non-linear relationships closer
3. If a sample size *n* increases, the test prediction accuracy of QDA relative to LDA improves due to the fact that QDA is prone to overfitting. If the data set is big enough, the accuracy of the model and fit is better than LDA. This is true due to the nature of QDA that each feature has its own covariance matrix in comparison to LDA which has only a single covariance matrix for all features together
4. The QDA is not flexible enough to fit linear decision boundary due to the reason that the shape of the fit is quadratic

# Solution02 - 4.8, Q10 - Log Expression

$$
\log \frac{1}{\mathrm{Pr}(Y=k|X=x)} = \log \frac{\pi_k}{\pi_K + \frac{(\mu_k-\mu_K)^2}{2\sigma^2}} = \log \pi_k - \log \pi_K - \frac{(\mu_k-\mu_K)^2}{2\pi_K\sigma^2} 
$$
where $a_k = \log \frac{\pi_k}{\pi_K}$ and $b_{kj} = \frac{(\mu_j-\mu_K)^2}{2\pi_K\sigma^2}$

# Solution03 - 4.8, Q12 - Apples and Oranges Probabilities
1. The log odds of orange versus apple in our model is given by:

$$
log odds = log(\frac{P(Y=orange|X=x)}{P(Y=apple|X=x)}) = log(\frac{exp(\hat{\beta}_0+\hat{\beta}_1x)}{1+exp(\hat{\beta}_0+\hat{\beta}_1x)}) = \hat{\beta}_0+\hat{\beta}_1x
$$
2. The log odds of orange versus apple in our friend's model is given by:
$$
log odds = log(\frac{P(Y=orange|X=x)}{P(Y=apple|X=x)}) = log(\frac{exp(\hat{\alpha}_{orange0}+\hat{\alpha}_{orange1}x)}{exp(\hat{\alpha}_{apple0}+\hat{\alpha}_{apple1}x)+exp(\hat{\alpha}_{orange0}+\hat{\alpha}_{orange1}x)}) = (\hat{\alpha}_{orange0}-\hat{\alpha}_{apple0})+(\hat{\alpha}_{orange1}-\hat{\alpha}_{apple1})x
$$
3. If βˆ0 = 2 and βˆ1 = -1, then the coefficient estimates in our friend's model are:
$$
\hat{\alpha}_{orange0}-\hat{\alpha}_{apple0}=2 \hat{\alpha}_{orange1}-\hat{\alpha}_{apple1}=-1
$$
4. If αˆorange0 = 1.2, αˆorange1 = -2, αˆapple0 = 3, αˆapple1 = 0.6 in our friend's model, then the coefficient estimates in our model are:
$$
\hat{\beta}_0=\hat{\alpha}_{orange0}-\hat{\alpha}_{apple0}=-1.8 \hat{\beta}_1=\hat{\alpha}_{orange1}-\hat{\alpha}_{apple1}=-2.6
$$
5. The number between predicted class labels from our model to friend's model that are matched depends heavily on the accuracy of the prediction of class labels, complexity of decisiong boundary and overall data nature. If both of the models have a high accuraccy, we can expect high fraction of agreed labels, otherwise the fraction will be very low

# Solution04 - 4.8, Q13
![[Pasted image 20230416134759.png]]
1. From the $summary(Weekly)$ we can see that the following patterns occur:
* There are more weeks that end up with profits than those that not
* Volume has a big range - min of 0.08747 and max of 9.3281
* There seems to be colleration between the different Lag inputs

2. The result of logistic regression model is as following:
![[Pasted image 20230416135821.png]]
 
We can reject the null hypothesis for Lag2 variable, due to the fact that its Pr value is smaller than 0.05. This means that Lag2 is statistically significant.

3. 
![[Pasted image 20230417163302.png]]

E.g. The model predicted 
* True Positives - 557
* True Negatives - 54
* False Positives - 431
* False Negatives - 48

From the confusion matrix, we can state that:
* The model has many false positives
* The accuracy seems to be smaller than 0.5
* The model does not seem like a good fit

4. The overall percentage of correct predictions is 62,5%
![[Pasted image 20230417155356.png]]
5. The overall percentage of correct predictions is 62,5%
![[Pasted image 20230417155337.png]]
6. The overall percentage of correct predictions is 58,65385%
![[Pasted image 20230417155313.png]]
7. The overall percentage of correct predictions is 50%
![[Pasted image 20230417170432.png]]
8.  The overall percentage of correct predictions is 58,65385%
![[Pasted image 20230417214747.png]]
9. The best result seems to be yielded by linear models - Linear Discriminant Analysis and Logistic Regression. The rest of the models seem to have a good fit in percentage - anything bigger than 50% -  but this is very subjective. From the confusion matrix it can be seen that the results in many cases are only value - Up. If a model predicts only up/down trends, it depends heavily on the nature of the data being more likely up than down
10. Due to the small size of the dataset, I could not see any notable differences between the existing models and models with new values