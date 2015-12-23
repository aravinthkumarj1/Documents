#include <stdio.h> 
#include <string.h> 
#include <stdlib.h> 
#include <errno.h> 
#include <unistd.h> 
#include <cutils/properties.h> 
#include <fcntl.h>

#include "JNIHelp.h" 
#include "jni.h" 
#include "utils/misc.h" 
#include "android_runtime/AndroidRuntime.h" 
 

namespace android { 
	
static jboolean gpio_high(){ 
	int fd ;
	char gpio_path[30];
	sprintf(gpio_path,"/sys/class/gpio/gpio147/value");
	fd = open(gpio_path, O_RDWR | O_NONBLOCK );
	write(fd, "1", 2);
	close(fd);
return 1; 
} 

static jboolean gpio_low(){ 
	int fd ;
	char gpio_path[30];
	sprintf(gpio_path,"/sys/class/gpio/gpio147/value");
	fd = open(gpio_path, O_RDWR | O_NONBLOCK );
	write(fd, "0", 2);
	int ad = open("/sys/class/gpio/gpio147/value", O_RDONLY | O_NONBLOCK );
	close(fd);
return 1; 
}
 
/* 
JNI registration. 
*/ 

static JNINativeMethod gpioMethods[] ={ 
	/* name, signature, funcPtr */ 
	{ "gpio_on", "()Z", (void*) gpio_high }, 
	{ "gpio_off", "()Z", (void*) gpio_low },
 
};  

int register_android_util_gpioctrl(JNIEnv* env){
	jclass clazz = env-> FindClass ("android/util/gpioctrl"); 
	if(clazz == NULL){          
	//	LOGE ("Can not find android/util/gpioctrl");
	return -1;
	}
	return AndroidRuntime::registerNativeMethods(env, "android/util/gpioctrl", gpioMethods, NELEM(gpioMethods));
	}

};
