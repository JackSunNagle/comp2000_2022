Biggest bug/issue I found was that after I synchronized the stage classes for the main and screen threads, whenever I would run the program, the program would fail as the timeout value would be negative. This was because the value of the updateDuration of canvas.stage.update() was greater than 15l and running a Thread.sleep with a negative value would cause an error. 

The way I got the program to work, was by not implementing the Thread.sleep function and the game would work correctly. But by doing this, the check user input wouldn’t be checked every 15ms but checked constantly. 

I then decided to pass the updateDuration through an if statement so that it would only sleep the thread if the value wasn’t negative. 
