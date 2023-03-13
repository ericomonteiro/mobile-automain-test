### Mobile Automated Tests

<b>Libs:</b>  
https://appium.io/  
https://github.com/appium/appium-inspector  
https://testng.org/doc/index.html  
https://developer.android.com/studio  
https://nodejs.org/en/download/  
https://www.oracle.com/br/java/technologies/downloads/

### Setup

##### You need setup these environment variables
<ul>
    <li>JAVA_HOME - directory where the JDK is installed</li>
    <li>ANDROID_HOME - directory where the Android SDK is installed</li>
    <li>PATH - %ANDROID_HOME%/platform-tools</li>
    <li>PATH - %ANDROID_HOME%/tools/bin</li>
</ul>

##### Using Appium Inspector

It's an application similar than web browser inspector, used to find elements inside the app without need the app code  
<img src="./resource/inspector.png"/>  
Capabilities JSON Representation
> :warning: **Probably you will need to pass absolute path because inspector is running in another path !
```json
{
    "app": "app/ApiDemos-debug.apk",
    "deviceName": "AUTOMAIN_DEVICE",
    "automationName": "UiAutomator2",
    "platformName": "android"
}
```

##### Create a virtual Device with name `AUTOMAIN_DEVICE` like this:
<img src="./resource/virtual-device.png">

```shell
npm install -g appium@next
```

```shell
npm install -g appium-doctor
```

```shell
appium driver list
```

```shell
appium driver install uiautomator2
```

##### To Start Appium Server: !Important stay at root project directory
```shell
appium
```