/*H***********************************************************************************
* FILENAME :        printers.cpp           
*
* DESCRIPTION :
*       	This JNI file support printer application 
*
* PUBLIC FUNCTIONS :
*	int PCE_thm_check_voltage()
*	int PCE_thm_print_nchars(char const* str,int nchars)
*	int PCE_thm_set_font_size(char fontSizeH,char fontSizeW)
*	int PCE_thm_check_platen()
*	int PCE_thm_check_paper()
*	int PCE_thm_print_microLF(char const* direction,int microStepCount)
*	int PCE_thm_print_barcode_at_x_numeric(int xpoint,char const* barData)
*	int PCE_thm_print_barcode_numeric(const char const* barData)
*	int PCE_thm_print_at_x(int xpoint, char const* k)
*	int PCE_thm_print(char const* k)
*	int PCE_thm_print_image(char const* fileloc,int width,int height)
*	int PCE_thm_print_grayscl_image(char const* fileloc,int width,int height)
*	int PCE_thm_print_LF()
*
* NOTES :
*       These functions are a part of the printer.
*
*
* AUTHOR :    Zumi solutions      
*
*
*H*/



#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include <unistd.h>
#include <cutils/properties.h>
#include <fcntl.h>
#include <cutils/log.h>
#include <utils/String8.h>
#include "JNIHelp.h"
#include "jni.h"
#include "utils/misc.h"
#include "android_runtime/AndroidRuntime.h"

#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "hello-ndk", __VA_ARGS__))


namespace android {

#define __ZSIMULATE__

#ifdef __ZSIMULATE__

int PCE_thm_check_voltage()
	{
	return 0;
	}

int PCE_thm_print_nchars(char const* str,int nchars)
	{
	return 0;
	}
int PCE_thm_set_font_size(char fontSizeH,char fontSizeW)
	{
	return 0;
	}
int PCE_thm_check_platen()
	{
	return 0;
	}

int PCE_thm_check_paper()
        {
        return 0;
        }
int PCE_thm_print_microLF(char const* direction,int microStepCount)
        {
        return 0;
        }
int PCE_thm_print_barcode_at_x_numeric(int xpoint,char const* barData)
        {
        return 0;
        }
int PCE_thm_print_barcode_numeric( char const* barData)
        {
        return 0;
        }
int PCE_thm_print_at_x(int xpoint, char const* k)
        {
        return 0;
        }
int PCE_thm_print(char const* k)
        {
        return 0;
        }
int PCE_thm_print_image(char const* fileloc,int width,int height)
        {
        return 0;
        }
int PCE_thm_print_grayscl_image(char const* fileloc,int width,int height)
        {
        return 0;
        }
int PCE_thm_print_LF()
        {
        return 0;
        }

#endif 
}
