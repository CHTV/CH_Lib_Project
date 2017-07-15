# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html
#
# Starting with version 2.2 of the Android plugin for Gradle, this file is distributed together with
# the plugin and unpacked at build-time. The files in $ANDROID_HOME are no longer maintained and
# will be ignored by new version of the Android plugin for Gradle.
#
# Optimizations: If you don't want to optimize, use the
# proguard-android.txt configuration file instead of this one, which
# turns off the optimization flags.  Adding optimization introduces
# certain risks, since for example not all optimizations performed by
# ProGuard works on all versions of Dalvik.  The following flags turn
# off various optimizations known to have issues, but the list may not
# be complete or up to date. (The "arithmetic" optimization can be
# used if you are only targeting Android 2.0 or later.)  Make sure you
# test thoroughly if you go this route.
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5
-allowaccessmodification
-dontpreverify

# The remainder of this file is identical to the non-optimized version
# of the Proguard configuration file (except that the other file has
# flags to turn off optimization).

-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

# Preserve some attributes that may be required for reflection.
-keepattributes *Annotation*,Signature,InnerClasses

# Preserve line number information for debugging stack traces.
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keep public class com.google.android.vending.licensing.ILicensingService
-dontnote com.android.vending.licensing.ILicensingService
-dontnote com.google.vending.licensing.ILicensingService
-dontnote com.google.android.vending.licensing.ILicensingService

-dontwarn rx.**
-keep class rx.** { *;}

# com.changhong.android.jar filter
-dontwarn com.changhong.appsecurity.**
-keep class com.changhong.appsecurity.** { *;}

-dontwarn com.changhong.axiskeypad.**
-keep class com.changhong.axiskeypad.** { *;}

-dontwarn com.changhong.dm.**
-keep class com.changhong.dm.** { *;}

-dontwarn com.changhong.dmt.**
-keep class com.changhong.dmt.** { *;}

-dontwarn com.changhong.inface.net**
-keep class com.changhong.inface.net** { *;}

# com.changhong.tvos.jar filter
-dontwarn com.changhong.tvos.atv.**
-keep class com.changhong.tvos.atv.** { *;}

-dontwarn com.changhong.tvos.common.**
-keep class com.changhong.tvos.common.** { *;}

-dontwarn com.changhong.tvos.dtv.for3rd.**
-keep class com.changhong.tvos.dtv.for3rd.** { *;}

-dontwarn com.changhong.tvos.impl.**
-keep class com.changhong.tvos.impl.** { *;}

-dontwarn com.changhong.tvos.jni.**
-keep class com.changhong.tvos.jni.** { *;}

-dontwarn com.changhong.tvos.model.**
-keep class com.changhong.tvos.model.** { *;}

-dontwarn com.changhong.tvos.service.**
-keep class com.changhong.tvos.service.** { *;}

-dontwarn com.changhong.server.**
-keep class com.changhong.server.** { *;}

# accountsystemapi.jar filter
-dontwarn com.changhong.usercenterapi.**
-keep class com.changhong.usercenterapi.** { *;}



-dontwarn com.changhong.watson.**
-keep class com.changhong.watson.** { *;}
#-dontwarn com.changhong.softkeyboard.**
#-keep class com.changhong.softkeyboard.** { *;}
#
#-dontwarn com.changhong.system.CHPackageCmdService**
#-keep class com.changhong.system.CHPackageCmdService** { *;}
#
#-dontwarn com.changhong.system.CmdDaemonManager**
#-keep class com.changhong.system.CmdDaemonManager** { *;}

# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep setters in Views so that animations can still work. Also, keep constructors.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    void set*(***);
    *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick.
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

# Preserve annotated Javascript interface methods.
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# The support libraries contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version. We know about them, and they are safe.
-dontnote android.support.**
-dontwarn android.support.**

# Understand the @Keep support annotation.
-keep class android.support.annotation.Keep

-keep @android.support.annotation.Keep class * {*;}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <methods>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <fields>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <init>(...);
}
