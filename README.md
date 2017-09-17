## The correct way

Using the `onSaveInstanceState()` to save the state of an `Activity` is the only solution which lets the app restore the state. The rotation of the device destroys the `Activity` and recreates the view hierarchy from the correct resource (the `land/activity_main.xml` for horizontal orientation). The visibility state of the secret view is restored from the `savedInstanceState` argument of the `onCreate()` method. 

![Rotation](http://shaftapps.com/udacity_reviewer/gifs/sis_rotation.gif)

This approach prevents from losing the visibility of the secret view even when the system destroys the `Activity` in the background.

![Home button](http://shaftapps.com/udacity_reviewer/gifs/sis_home_button.gif)
