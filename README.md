## The hacky workaround

If the developer chooses to add the `android:configChanges="orientation|screenSize"` attribute to the Activities, the system doesn't destroy the Activities on rotation. Unfortunately, this practice only creates the impression of properly saved state of the app. 

The reason why this approach is not the solution is the fact that the visibility state of the secret view is lost when the **`Activity` goes to the background**.

![Home button](http://shaftapps.com/udacity_reviewer/gifs/thw_home.gif)

Not destroying the Activity has some other consequences. One of them is not recreating the view hierarchy which means that if we have alternative versions of layout for landscape and portrait orientations, the app won't switch between them on rotation. 

![Rotation](http://shaftapps.com/udacity_reviewer/gifs/thw_rotation.gif)
