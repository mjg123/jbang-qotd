# Horsing around with jbang

This repo was created during a stream (YouTube link soon) where I took my first look at [jbang](https://jbang.dev). It contains a single java source file which can be used as a shell script.

## How to run it

You will need jbang installed. jbang is available through [SDKMAN!](https://sdkman.io/) (promo-moment: I wrote [a blog post about SDKMAN!](https://www.twilio.com/blog/sdkman-work-with-multiple-versions-java) a while back), so `sdk install jbang` will install jbang for you.

Then, either:

### Run directly from the web

jbang includes some sensible protection for running untrusted code from the web. To trust this script you need to tell jbang:

```
jbang trust add https://raw.githubusercontent.com
```

then run it by passing the URL for `qotd.java`:

```
jbang https://raw.githubusercontent.com/mjg123/jbang-qotd/master/qotd.java
```

### Download and run locally

Download the file with:

```
wget https://raw.githubusercontent.com/mjg123/jbang-qotd/master/qotd.java
```

Run with jbang explicitly: `jbang qotd.java` or as a standalone script `./qotd.java`.


## You want more jbang?

Check out the docs and everything else at [https://jbang.dev/](https://jbang.dev/).

Thanks and happy coding!

