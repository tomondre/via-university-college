# AND Hand-in 1 - eRoto

The app that I will be creating will be a trading platform. Because stocks/funds investing is very interesting to me and I have been educating myself in these areas for a while, I think it can be an enggaging project to me.<br/>
I am using a general repository that I have created for my Via studies, therefore the project itself can be found here: Sem04/AND1/eRoto (Sorry for this inconvenience). <br/>
The name eRoto is just a 'parody name' to the original company eToro. (I know the name suggest other things but that is not a goal.).
eRoto file itself is a project, therefore this file needs to be opened in order to run the android app.

## Requirements
1. ~~As an Investor, I want to be able to create an account, so that I can be in the system.~~
2. ~~As an Investor, I want to be able to login to the app, so that I can start using the app.~~~
3. ~~As an Investor, I want to be able to deposit money, so that I can top-up my account.~~
4. ~~As an Investor, I want to be able to see my current balance, so that I have an overview of it.~~
5. As an Investor, I want to be able to see a list of stocks, so that I can choose one.~
6. As an Investor, I want to be able to see details of selected stock, so that I can research it.~
7. As an Investor, I want to be able to buy a stock, so that I can spend my hard-earned money.
10. As an Investor, I want to be able to see my bought stocks in my portfolio, so that I can keep track of owned stocks.~
11. As an Investor, I want to be able to log out, so that no one can use my account.
12. As an Investor, I want to be automatically logged in after the app closes, so that I don't have to log in each time.
13. As an Investor, I want to be able to see my current portfolio value with today's performance, so that I have an brief overview of the portfolio.~
14. As an Investor, I want to be able to see a graph of my portfolio value, so that I can see how is it doing over a period of time.~
15. As an Investor, I want to be able to see what are the stocks are rising in price fast, so that I can FOMO buy it.~
16. As an Investor, I want to be able to see overview of different markets, so that I can see how they are doing.~
17. As an Investor, I want to be able to see my notifications, so that I can react to them accordingly.~
18. As an Investor, I want to be able to create a post about stock, so that I can express my feeling about it.
19. As an Investor, I want to be able to see most recent posts of a selected stock, so that I can see how are the people feeling about it today.~
20. As an Investor, I want to be able to see most recent posts of other users, so that I can see how are people feeling about today's stocks and markets.~
21. As an Investor, I want to be able to like a post, so that I can support it.
22. As an Investor, I want to be able to comment a post, so that I can share my opinion about the subject.
23. As an Investor, I want to be able to follow a stock, so that I can see the prices changes of it.
24. As an Investor, I want to be able to search through stocks by its ticker, so that I can find them faster.
25. As an Investor, I want to be able to edit my account details, so that I can keep it up to date.
26. As an Investor, I want to be able to withdraw money, so that I can loose them on other platform.

<!-- TODO -->
1. When and where should we fetch the data for web client?
   1. WebClient constructor - it will be fetched once when the singleton object is created.
        - This may be a problem because the data won't be up to date after each view is created or openned
   2. Call method loadData in activity after we set observe to livedata.
        - This way the data will be always updated but when the views are being created for the first time, the call will be called several times (due to more activities starting at the same time)