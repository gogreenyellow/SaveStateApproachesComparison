## No saving of the state

If the developer chooses not to save the state, the Activity gets destroyed on rotation. The framework recreates the view hierarchy from the proper layout file - the default `activity_main.xml` for portrait orientation and `land/activity_main.xml` for landscape. 

However, the visibility state of the secret view is not preserved. 

![Rotation](http://shaftapps.com/udacity_reviewer/gifs/nss_rotation.gif)

The visibility state of the secret view is lost when the system destroys the `Activity` in background as well.

![Home button](http://shaftapps.com/udacity_reviewer/gifs/nss_home.gif)
