# DBLP Status
```
Format for QueryFactory
new QueryFacotry(arg0,arg1,arg2);
arg0 = what type of query you want
Options = "findByTitleTags", "findByAuthor", "moreThanK", "predict"
For "findByTitleTags" and "findByAuthor"
arg1 = Can range from 1 argument (title/name) to 4 argument (title/name + 3 out of 4 options)
first we need the title or author name
Next, what all options you want for displaying result
Options = "dateSort", "relSort", "between", "since" (note, dateSort and relSort can't be used simultaneously)
arg2 = 0,1 or 2 integers (integer ArrayList)
1st integer, if present, is start year
2nd integer, if present, is end year
For "moreThanK" 
arg1 = null
arg2 = (integer ArrayList) of size 1```
