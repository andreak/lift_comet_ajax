sbt is included so run:


    ./sbt.sh
    >container:start

then go to

    http://localhost:8080/

And you will see a button. When pressed a new comet-actor will be added (and only once, so don't bother pressing it multiple times), but the content won't auto-update before the long-poll is refreshed.
