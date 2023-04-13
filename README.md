# VibrationEffectSegmentSample
Demonstration of a suspected bug in Robolectric 4.10

Run ExampleUnitTest to see the demonstration: `./gradlew testDebugUnitTest`

The following code will work on Android devices < 32:
```
getSystemService(VIBRATOR_SERVICE) as Vibrator
```

But in a Robolectric runtime, it instead throws:
```
android/os/vibrator/VibrationEffectSegment
java.lang.NoClassDefFoundError: android/os/vibrator/VibrationEffectSegment
	at java.base/java.lang.Class.getDeclaredMethods0(Native Method)
	at java.base/java.lang.Class.privateGetDeclaredMethods(Class.java:3166)
	at java.base/java.lang.Class.getDeclaredMethod(Class.java:2473)
	at org.robolectric.internal.bytecode.ShadowWrangler.findShadowMethodDeclaredOnClass(ShadowWrangler.java:323)
	at org.robolectric.internal.bytecode.ShadowWrangler.findShadowMethod(ShadowWrangler.java:292)
	at org.robolectric.internal.bytecode.ShadowWrangler.pickShadowMethod(ShadowWrangler.java:269)
	at org.robolectric.internal.bytecode.ShadowWrangler.lambda$findShadowMethodHandle$0(ShadowWrangler.java:207)
	at org.robolectric.util.PerfStatsCollector.measure(PerfStatsCollector.java:53)
	at org.robolectric.internal.bytecode.ShadowWrangler.findShadowMethodHandle(ShadowWrangler.java:201)
	at org.robolectric.internal.bytecode.RobolectricInternals.findShadowMethodHandle(RobolectricInternals.java:36)
	at org.robolectric.internal.bytecode.InvokeDynamicSupport.bindCallSite(InvokeDynamicSupport.java:161)
	at org.robolectric.internal.bytecode.InvokeDynamicSupport.lambda$bootstrap$1(InvokeDynamicSupport.java:87)
	at org.robolectric.util.PerfStatsCollector.measure(PerfStatsCollector.java:53)
	at org.robolectric.internal.bytecode.InvokeDynamicSupport.bootstrap(InvokeDynamicSupport.java:81)
	at java.base/java.lang.invoke.BootstrapMethodInvoker.invoke(BootstrapMethodInvoker.java:215)
	at java.base/java.lang.invoke.BootstrapMethodInvoker.invoke(BootstrapMethodInvoker.java:102)
	at java.base/java.lang.invoke.CallSite.makeSite(CallSite.java:307)
	at java.base/java.lang.invoke.MethodHandleNatives.linkCallSiteImpl(MethodHandleNatives.java:258)
	at java.base/java.lang.invoke.MethodHandleNatives.linkCallSite(MethodHandleNatives.java:248)
	at android.os.Vibrator.<init>(Vibrator.java)
	at android.os.SystemVibrator.<init>(SystemVibrator.java)
	at android.app.SystemServiceRegistry$44.createService(SystemServiceRegistry.java:522)
	at android.app.SystemServiceRegistry$44.createService(SystemServiceRegistry.java:519)
	at android.app.SystemServiceRegistry$CachedServiceFetcher.getService(SystemServiceRegistry.java:928)
	at android.app.SystemServiceRegistry.getSystemService(SystemServiceRegistry.java:880)
	at android.app.ContextImpl.getSystemService(ContextImpl.java:1651)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at org.robolectric.shadows.ShadowContextImpl$_ContextImpl_$$Reflector6.getSystemService(Unknown Source)
	at org.robolectric.shadows.ShadowContextImpl.getSystemService(ShadowContextImpl.java:88)
	at android.app.ContextImpl.getSystemService(ContextImpl.java)
	at android.content.ContextWrapper.getSystemService(ContextWrapper.java:708)
  ```
