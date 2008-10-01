/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_izforge_izpack_util_os_ShellLink */

#ifndef _Included_com_izforge_izpack_util_os_ShellLink
#define _Included_com_izforge_izpack_util_os_ShellLink
#ifdef __cplusplus
extern "C" {
#endif
#undef com_izforge_izpack_util_os_ShellLink_HIDE
#define com_izforge_izpack_util_os_ShellLink_HIDE 0L
#undef com_izforge_izpack_util_os_ShellLink_NORMAL
#define com_izforge_izpack_util_os_ShellLink_NORMAL 1L
#undef com_izforge_izpack_util_os_ShellLink_MINIMIZED
#define com_izforge_izpack_util_os_ShellLink_MINIMIZED 2L
#undef com_izforge_izpack_util_os_ShellLink_MAXIMIZED
#define com_izforge_izpack_util_os_ShellLink_MAXIMIZED 3L
#undef com_izforge_izpack_util_os_ShellLink_MINNOACTIVE
#define com_izforge_izpack_util_os_ShellLink_MINNOACTIVE 7L
#undef com_izforge_izpack_util_os_ShellLink_MIN_SHOW
#define com_izforge_izpack_util_os_ShellLink_MIN_SHOW 0L
#undef com_izforge_izpack_util_os_ShellLink_MAX_SHOW
#define com_izforge_izpack_util_os_ShellLink_MAX_SHOW 7L
#undef com_izforge_izpack_util_os_ShellLink_DESKTOP
#define com_izforge_izpack_util_os_ShellLink_DESKTOP 1L
#undef com_izforge_izpack_util_os_ShellLink_PROGRAM_MENU
#define com_izforge_izpack_util_os_ShellLink_PROGRAM_MENU 2L
#undef com_izforge_izpack_util_os_ShellLink_START_MENU
#define com_izforge_izpack_util_os_ShellLink_START_MENU 3L
#undef com_izforge_izpack_util_os_ShellLink_STARTUP
#define com_izforge_izpack_util_os_ShellLink_STARTUP 4L
#undef com_izforge_izpack_util_os_ShellLink_MIN_TYPE
#define com_izforge_izpack_util_os_ShellLink_MIN_TYPE 1L
#undef com_izforge_izpack_util_os_ShellLink_MAX_TYPE
#define com_izforge_izpack_util_os_ShellLink_MAX_TYPE 4L
#undef com_izforge_izpack_util_os_ShellLink_SL_OK
#define com_izforge_izpack_util_os_ShellLink_SL_OK 1L
#undef com_izforge_izpack_util_os_ShellLink_SL_ERROR
#define com_izforge_izpack_util_os_ShellLink_SL_ERROR -1L
#undef com_izforge_izpack_util_os_ShellLink_SL_INITIALIZED
#define com_izforge_izpack_util_os_ShellLink_SL_INITIALIZED -2L
#undef com_izforge_izpack_util_os_ShellLink_SL_NOT_INITIALIZED
#define com_izforge_izpack_util_os_ShellLink_SL_NOT_INITIALIZED -3L
#undef com_izforge_izpack_util_os_ShellLink_SL_OUT_OF_HANDLES
#define com_izforge_izpack_util_os_ShellLink_SL_OUT_OF_HANDLES -4L
#undef com_izforge_izpack_util_os_ShellLink_SL_NO_IPERSIST
#define com_izforge_izpack_util_os_ShellLink_SL_NO_IPERSIST -5L
#undef com_izforge_izpack_util_os_ShellLink_SL_NO_SAVE
#define com_izforge_izpack_util_os_ShellLink_SL_NO_SAVE -6L
#undef com_izforge_izpack_util_os_ShellLink_SL_WRONG_DATA_TYPE
#define com_izforge_izpack_util_os_ShellLink_SL_WRONG_DATA_TYPE -7L
#undef com_izforge_izpack_util_os_ShellLink_UNINITIALIZED
#define com_izforge_izpack_util_os_ShellLink_UNINITIALIZED -1L
#undef com_izforge_izpack_util_os_ShellLink_CURRENT_USER
#define com_izforge_izpack_util_os_ShellLink_CURRENT_USER 0L
#undef com_izforge_izpack_util_os_ShellLink_ALL_USERS
#define com_izforge_izpack_util_os_ShellLink_ALL_USERS 1L
/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    initializeCOM
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_initializeCOM
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    releaseCOM
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_releaseCOM
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    getInterface
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_getInterface
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    releaseInterface
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_releaseInterface
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    GetArguments
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_GetArguments
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    GetDescription
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_GetDescription
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    GetHotkey
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_GetHotkey
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    GetIconLocation
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_GetIconLocation
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    GetPath
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_GetPath
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    GetShowCommand
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_GetShowCommand
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    GetWorkingDirectory
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_GetWorkingDirectory
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    Resolve
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_Resolve
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    SetArguments
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_SetArguments
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    SetDescription
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_SetDescription
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    SetHotkey
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_SetHotkey
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    SetIconLocation
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_SetIconLocation
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    SetPath
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_SetPath
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    SetShowCommand
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_SetShowCommand
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    SetWorkingDirectory
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_SetWorkingDirectory
  (JNIEnv *, jobject);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    saveLink
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_saveLink
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    loadLink
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_loadLink
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    GetFullLinkPath
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_izforge_izpack_util_os_ShellLink_GetFullLinkPath
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_izforge_izpack_util_os_ShellLink
 * Method:    FreeLibrary
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_izforge_izpack_util_os_ShellLink_FreeLibrary
  (JNIEnv *, jobject, jstring);

#ifdef __cplusplus
}
#endif
#endif
