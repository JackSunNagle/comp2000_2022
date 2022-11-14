For running each actor on a separate thread

First I extended the actor class to extend Thread.
This then allows each instance of actor that I create to be a new thread.
To implement and start each thread, in the stageReader class, depending on the description supplied to the actor function. I assigned the actor variable to a new actor subclass, ie new Cat() or new Dog(). After declaring the variable to a new actor subclass I then start the thread. ie actor.start()

I implemented the actors class this way, as the requirement was to run all the actors onto separate threads. This way if the program wants to add more actors in, it will create more threads for each actor


