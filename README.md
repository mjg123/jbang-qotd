# Horsing around with jbang

This repo was created during a stream ([YouTube link](https://www.youtube.com/watch?v=RgHNOH2_itw)) where I took my first look at [jbang](https://jbang.dev). It contains a single java source file which can be used as a shell script via the magic of jbang. The script fetches the quote of the day from [https://quotes.rest/qod](https://quotes.rest/qod]) and prints it to STDOUT (note that this API has a rate-limit of 10 requests per hour).  I was joined in the stream by jbang's author [Max Rydahl Andersen](https://twitter.com/maxandersen)

## How to run it

You will need jbang installed. jbang is available through [SDKMAN!](https://sdkman.io/) (promo-moment: I wrote [a blog post about SDKMAN!](https://www.twilio.com/blog/sdkman-work-with-multiple-versions-java) a while back), so `sdk install jbang` will install jbang for you.

Then, either:

### Run directly from the web

jbang includes some sensible protection for running untrusted code from the web. To trust this script you need to tell jbang:

```
jbang trust add https://raw.githubusercontent.com/mjg123/jbang-qotd
```

then run it by passing the URL for `qotd.java`:

```
jbang https://raw.githubusercontent.com/mjg123/jbang-qotd/master/qotd.java
```

### Download and run locally

Download the file and make it executable with:

```
wget https://raw.githubusercontent.com/mjg123/jbang-qotd/master/qotd.java
chmod +x ./qotd.java
```

Run with jbang explicitly: `jbang qotd.java` or as a standalone script `./qotd.java`.


## You want more jbang?

Check out the docs and everything else at [https://jbang.dev/](https://jbang.dev/).

Thanks and happy coding!

