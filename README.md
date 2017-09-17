## SaveStateDemo

Android can destroy an `Activity` in the background when it's short on resources. It is an important manner which should be close to the Android developers because it's their responsibility to **make this behavior invisible** for the users of the app. The majority of views save and restore their state automatically as described in the [documentation](https://developer.android.com/guide/components/activities/activity-lifecycle.html#saras), but there are some things (like the visibility status of the `View`) which has to be handled by the developer.

---

I've created an extremely simple app - its only purpose is showing a `View` when the user clicks a `Button`. Check how the app behaves on screen rotation and when it gets destroyed by the system depending on the approach:


### [• No saving at all](https://github.com/paulinaglab/SaveStateDemo/tree/no_saving_at_all)

### [• The hacky workaround](https://github.com/paulinaglab/SaveStateDemo/tree/the_hacky_way)

→ Using the `android:configChanges="orientation|screenSize"`

### [✓ The correct way](https://github.com/paulinaglab/SaveStateDemo/tree/proper_save_state)

→ Using `onSaveInstanceState()` method


## Prerequisites

If you want to test it by yourself, you should start with turning on the **Don't keep activities** in the **Developer options**. 

It can be done in the following way:

![Don't keep activities](http://shaftapps.com/udacity_reviewer/gifs/dont_keep_activities.gif)

This setting will make the system **destroy the Activities as soon as they go to the background**. Android would destroy the Activities present in the background anyway, however, there would be no way to determine when. 

