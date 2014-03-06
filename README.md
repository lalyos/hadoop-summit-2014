## Hadoop Summit 2014 Amsterdam

I tried to search for interesting sessions in the official [schedue](http://hadoopsummit.org/amsterdam/schedule/) , 
but it's rather hard, as you have to explicitly click on each session to read the abstract. Even the print view lacks 
the detailes. 

So I created a small groovy script which extracts the data from the webpage, and saves it converts it into a json list.
The great [geb](http://www.gebish.org/) framework was used to drive the [selenium](http://docs.seleniumhq.org/) 
chrom automation.

## Reformatted Schedule

A couple of lines of [AngularJS](http://angularjs.org/) made a nice new Schedule:

http://lalyos.github.io/hadoop-summit-2014/

You can find the`index.html` and the `json` in the [gh-pages branch](https://github.com/lalyos/hadoop-summit-2014/tree/gh-pages).
