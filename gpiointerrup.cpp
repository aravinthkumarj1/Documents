#include <stdio.h> 
#include <string.h> 
#include <stdlib.h> 
#include <errno.h> 
#include <unistd.h> 
#include <cutils/properties.h> 
#include <fcntl.h>
#include <cutils/log.h>

#include "JNIHelp.h" 
#include "jni.h" 
#include "utils/misc.h" 
#include "android_runtime/AndroidRuntime.h" 

#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "hello-ndk", __VA_ARGS__))
int gpio  = 60;
char buf[30];


namespace android { 

static jboolean gpio_interrup(){ 
        int fd,ad ;
	char gpio_path[30];
//	int value;
	 sprintf(gpio_path, "/sys/class/gpio/gpio6/value");
//	 fd = open( "/sys/class/gpio/gpio60/value", O_RDONLY | O_NONBLOCK );
	
//	sscanf(gpio_path,"/sys/class/gpio/gpio60/value");
//	sprintf(buf,"/sys/class/gpio/gpio60/value",gpio);
//	ALOGD("########p1 gpio_path  %d \r\n",fd);
	fd = open(gpio_path, O_RDONLY | O_NONBLOCK );

//	sscanf("%d",&x);
//	fd = gpio_interrup;
	read(fd, &gpio_path, 2);
    


	close(fd);
return 1;
 }
 
/*
static jboolean gpio_low(){ 
	int fd ;
	char gpio_path[30];
	sprintf(gpio_path,"/sys/class/gpio/gpio60/value");
	
	fd = open(gpio_path, O_RDWR | O_NONBLOCK );
//	write(fd, "0", 2);
	close(fd);
return 1; 
}
 */
/* 
JNI registration. 
*/ 

static JNINativeMethod gpioMethods[] ={ 
	/* name, signature, funcPtr */ 
	{ "gpio_inter_in", "()Z", (void*) gpio_interrup }, 
//	{ "gpio_off", "()Z", (void*) gpio_low }, 
};  

int register_android_util_gpiointerrup(JNIEnv* env){
	jclass clazz = env-> FindClass ("android/util/gpiointerrup"); 
	if(clazz == NULL){          
	//	LOGE ("Can not find android/util/gpioctrl");
		return -1;
	}
	return AndroidRuntime::registerNativeMethods(env, "android/util/gpiointerrup", gpioMethods, NELEM(gpioMethods));
	}

};
