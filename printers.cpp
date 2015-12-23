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
extern int PCE_thm_check_voltage();
extern int PCE_thm_print_nchars(char const* str,int nchars);
extern int PCE_thm_set_font_size(char fontSizeH,char fontSizeW);
extern int PCE_thm_check_platen();
extern int PCE_thm_check_paper();
extern int PCE_thm_print_microLF(char const* direction,int microStepCount);
extern int PCE_thm_print_barcode_at_x_numeric(int xpoint,char const* barData);
extern int PCE_thm_print_barcode_numeric(const char* barData);
extern int PCE_thm_print_at_x(int xpoint, char const* k);
extern int PCE_thm_print(char const* k);
extern int PCE_thm_print_image(char const* fileloc,int width,int height);
extern int PCE_thm_print_grayscl_image(char const* fileloc,int width,int height);
extern int PCE_thm_print_LF();

#ifdef __ZSIMULATE__11

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

/*******************************************************************
* NAME : static jint thm_check_voltage(JNIEnv* env, jclass clazz)                         
*
* DESCRIPTION :  To check the printer voltage ok or not
*
* PARAMETERS :   None 
*
* RETURN :
*             ERROR_THM_LOWVOLTAGE
*	      THM_VOLTAGE_PROPER
**********************************************************************/
static jint thm_check_voltage(JNIEnv* env, jclass clazz){
	
	ALOGD("## Voltage Test Key OK ## ");
	int return_voltage;

#ifdef __ZSIMULATE__
	static int voltage;
#endif
	
	return_voltage = PCE_thm_check_voltage();

#ifdef __ZSIMULATE__
	if (voltage <= 1){
		return_voltage = voltage;
		voltage ++;
	}else{
		return_voltage = 0;
	}
#endif
	return return_voltage;
	
}

/*******************************************************************
* NAME : static jint thm_print_nchars(JNIEnv* env, jclass clazz, 
*		jstring str, jint nchars)                         
*
* DESCRIPTION :  To print a given string
*
* PARAMETERS:
*              str    : string to be printed
*              nchars : Number of characters
*
* RETURN :
*             THM_SUCCESS
*
*********************************************************************/

static jint thm_print_nchars(JNIEnv* env, jclass clazz, jstring str, jint nchars){
	
	const char *nameStr = env->GetStringUTFChars(str, NULL);
	ALOGD("## Print Nchars Test Key OK ## Str %s Nchars %d ",nameStr,nchars);
	env->ReleaseStringUTFChars(str, nameStr);

        int return_nchars;

#ifdef __ZSIMULATE__
        static int nchar;
#endif

        return_nchars =  PCE_thm_print_nchars(nameStr, nchars);

#ifdef __ZSIMULATE__
        return_nchars = nchar;
	return_nchars ++;
#endif
        return return_nchars;

}

/*******************************************************************
* NAME : static jint thm_set_font_size(JNIEnv* env, jclass clazz, 
*			jchar fontSizeHeight, jchar fontSizeWidth)                        
*
* DESCRIPTION :  For selecting the font size for subsequent prints
*
* PARAMETERS :   DOUBLE_HEIGHT(0/1), DOUBLE_WIDTH(0/1) 
*
* RETURN :
*               FONT_NORMAL
*		FONT_DOUBLE_HEIGHT_WIDTH
*		FONT_DOUBLE_WIDTH
*		FONT_DOUBLE_HEIGHT
*		ERROR_FONT_SIZE_SET
*	      
**********************************************************************/

static jint thm_set_font_size(JNIEnv* env, jclass clazz, jchar fontSizeHeight, jchar fontSizeWidth){

	 ALOGD("## Font Size Test Key OK ## FontSizeHeight %d  FontSizeWidth %d",fontSizeHeight,fontSizeWidth);
	 int  return_font_size;

#ifdef __ZSIMULATE__
        static int size;
#endif

         return_font_size = PCE_thm_set_font_size(fontSizeHeight,fontSizeWidth);

#ifdef __ZSIMULATE__
	if(size <= 4){
        	return_font_size = size;
		size ++;
	}else{
		return_font_size = 0;
	}
#endif
        return return_font_size;

}


/*******************************************************************
* NAME : static jint thm_check_platen(JNIEnv* env, jclass clazz)                        
*
* DESCRIPTION :  Check the status of the platen
*
* PARAMETERS :   None
*
* RETURN :
*               THM_PLATEN_OPEN
*		THM_PLATEN_CLOSED
*	      
**********************************************************************/

static jint thm_check_platen(JNIEnv* env, jclass clazz){
	 
	ALOGD("## Platen Test Key OK ##");
        int return_platen;

#ifdef __ZSIMULATE__
        static int platen;
#endif

         return_platen =  PCE_thm_check_platen();

#ifdef __ZSIMULATE__
	if (platen <= 1){
		return_platen = platen;
		platen ++;
	}else{
		return_platen = 0;
	}
#endif
        return return_platen;

}

/*******************************************************************
* NAME : static jint thm_check_paper(JNIEnv* env, jclass clazz)                        
*
* DESCRIPTION :  Check for the paper status
*
* PARAMETERS :   None
*
* RETURN :
*               THM_PAPER_ABSENT
*		THM_PAPER_PRESENT
*	      
**********************************************************************/

static jint thm_check_paper(JNIEnv* env, jclass clazz){

	 ALOGD("## Paper Test Key OK ##");
         int return_paper;

#ifdef __ZSIMULATE__
        static int paper;
#endif

        return_paper =  PCE_thm_check_paper();

#ifdef __ZSIMULATE__
	if(paper <= 1){
        	return_paper = paper;
		paper ++;
	}
	else {
		return_paper = 0;
	}
#endif
        return return_paper;

}

/*******************************************************************
* NAME : static jint thm_print_microLF(JNIEnv* env, jclass clazz, 
			   jstring direction, jint microStepCount)                        
*
* DESCRIPTION :  Performing line feed operation
*
* PARAMETERS :   Direction of line feed, Number of line feed steps
*
* RETURN :
*               THM_MICROLF_SUCCESS
*		ERROR_THM_MICROLF
*	      
**********************************************************************/

static jint thm_print_microLF(JNIEnv* env, jclass clazz, jstring direction, jint microStepCount){

	const char *nameStr = env->GetStringUTFChars(direction, NULL);      
	ALOGD("## Print MicroLF Test Key OK ## Direction %s MicroStepCount %d",nameStr,microStepCount);
	env->ReleaseStringUTFChars(direction, nameStr);
	int return_microLF;

#ifdef __ZSIMULATE__
        static int microLF;
#endif

        return_microLF = PCE_thm_print_microLF(nameStr,microStepCount);

#ifdef __ZSIMULATE__
	if(microLF <= 1){
        	return_microLF = microLF;
		microLF ++;
	}else{
		return_microLF = 0;
	}
#endif
        return return_microLF;

}

/*******************************************************************
* NAME : static jint thm_barcode_at_x_numeric(JNIEnv* env, 
*		jclass clazz, jint xpoint, const jstring barData)                        
*
* DESCRIPTION :  Print the bar code at the specified location
*
* PARAMETERS :   Horizontal offset, Bar code data to be printed
*
* RETURN :
*               THM_BARCODEPRINT_SUCCESS
*		ERROR_THM_PRINT
*	      
**********************************************************************/

static jint thm_barcode_at_x_numeric(JNIEnv* env, jclass clazz, jint xpoint, jstring barData){

	const char *nameStr = env->GetStringUTFChars(barData, NULL);
	ALOGD("## barcode X Numeric Test Key OK ## Xpoint %d BarDatas_X %s",xpoint,nameStr);
        env->ReleaseStringUTFChars(barData, nameStr);
	int return_x_numeric;

#ifdef __ZSIMULATE__
        static int x_numeric;
#endif

        return_x_numeric = PCE_thm_print_barcode_at_x_numeric(xpoint,nameStr);

#ifdef __ZSIMULATE__
	if(x_numeric <= 1){
        	return_x_numeric = x_numeric;
		x_numeric ++;
	}else{
		return_x_numeric = 0;
	}
#endif
        return return_x_numeric;

}

/*******************************************************************
* NAME : static jint thm_barcode_numeric(JNIEnv* env, jclass clazz,
*					 const jstring barData)                       
*
* DESCRIPTION :  Printing barcode at corrent location
*
* PARAMETERS :   Bar code data to be printed
*
* RETURN :
*		ERROR_THM_BARCODEPRINT
*               THM_BARCODEPRINT_SUCCESS
*			      
**********************************************************************/

static jint thm_barcode_numeric(JNIEnv* env, jclass clazz, jstring barData){

	const char *nameStr = env->GetStringUTFChars(barData, NULL);
 	ALOGD("## Barcode Numeric Test Key OK ## BarDatas %s",nameStr);
	env->ReleaseStringUTFChars(barData, nameStr);
        int return_barcode_numeric;

#ifdef __ZSIMULATE__
        static int numeric;
#endif

        return_barcode_numeric = PCE_thm_print_barcode_numeric(nameStr);

#ifdef __ZSIMULATE__
	if(numeric <= 1){
        	return_barcode_numeric = numeric;
		numeric ++;
	}else{
		return_barcode_numeric = 0;
	}
#endif
        return return_barcode_numeric;

}

/*******************************************************************
* NAME : static jint thm_print_at_x(JNIEnv* env, jclass clazz,
*				 jint xpoint,const jstring k)                       
*
* DESCRIPTION :  Prints at the given location
*
* PARAMETERS :   Horizontal offset location, Character array to be printed
*
* RETURN :
*		THM_XPOINT_OUTOFRANGE
*		ERROR_THM_LOWVOLTAGE
*		ERROR_THM_PRINT
*               THM_PAPER_ABSENT
*		THM_PLATEN_OPEN
*		THM_PRINT_SUCCESS
*			      
**********************************************************************/

static jint thm_print_at_x(JNIEnv* env, jclass clazz, jint xpoint, jstring k){

	const char *nameStr = env->GetStringUTFChars(k, NULL);
	ALOGD("## Print X Test Key OK ## Xpoint %d K %s ",xpoint,nameStr);
        env->ReleaseStringUTFChars(k, nameStr);
	int return_x;

#ifdef __ZSIMULATE__
        static int print_x;
#endif

        return_x =  PCE_thm_print_at_x(xpoint,nameStr);

#ifdef __ZSIMULATE__
	if(print_x <= 5){
        	return_x = print_x;
		print_x ++;
	}else{
		return_x = 0;
	}
#endif
        return return_x;

}

/*******************************************************************
* NAME : static jint thm_print(JNIEnv* env, jclass clazz,
*					 const jstring k)                      
*
* DESCRIPTION :  Printing from current location
*
* PARAMETERS :   Character array to be printed
*
* RETURN :
*		ERROR_THM_LOWVOLTAGE
*		ERROR_THM_PRINT
*               THM_PRINT_SUCCESS
*			      
**********************************************************************/

static jint thm_print(JNIEnv* env, jclass clazz, jstring k){

	const char *nameStr = env->GetStringUTFChars(k, NULL);      
	ALOGD("## Print Test Key OK ## %s",nameStr);
	env->ReleaseStringUTFChars(k, nameStr);
        int return_print;

#ifdef __ZSIMULATE__
        static int print;
#endif

        return_print = PCE_thm_print(nameStr);

#ifdef __ZSIMULATE__
	if(print <= 2 ){
		return_print = print;
		print ++;
	}else{
		return_print = 0;
	}
#endif
        return return_print;
}

/*******************************************************************
* NAME : static jint thm_print_image(JNIEnv* env, jclass clazz,
*			jstring fileloc, jint width, jint height)                      
*
* DESCRIPTION :  Print image
*
* PARAMETERS :   Image file, Width and Height of the image
*
* RETURN :
*		ERROR_THM_LOWVOLTAGE
*		ERROR_THM_PRINT
*               THM_PRINT_SUCCESS
*			      
**********************************************************************/

static jint thm_print_image(JNIEnv* env, jclass clazz, jstring fileloc, jint width, jint height){

	const char *nameStr = env->GetStringUTFChars(fileloc, NULL);	
	ALOGD("## Print Image Test Key OK ## Fileloc  %s Width %d  Height %d",nameStr,width,height);
	env->ReleaseStringUTFChars(fileloc, nameStr);
        int return_image;

#ifdef __ZSIMULATE__
        static int image;
#endif

        return_image =  PCE_thm_print_image(nameStr,width,height);

#ifdef __ZSIMULATE_
	if(image <= 2 ){
	        return_image = image;
		image ++;
	}else{
		return_image = 0;
	}
#endif
        return return_image;

}

/*******************************************************************
* NAME : static jint thm_print_grayscl_image(JNIEnv* env, 
*	  jclass clazz, jstring fileloc, jint width, jint height)                      
*
* DESCRIPTION :  Print grey-scale image
*
* PARAMETERS :   Image file, Width and Height of the image
*
* RETURN :
*		ERROR_THM_LOWVOLTAGE
*		ERROR_THM_PRINT
*               THM_PRINT_SUCCESS
*			      
**********************************************************************/

static jint thm_print_grayscl_image(JNIEnv* env, jclass clazz, jstring fileloc, jint width, jint height){

	const char *nameStr = env->GetStringUTFChars(fileloc, NULL);
        env->ReleaseStringUTFChars(fileloc, nameStr);
	ALOGD("## Print Grayscl Image Test Key OK ## Fileloc %s  Width %d Height %d ",nameStr,width,height);
        int return_grayscl_image;

#ifdef __ZSIMULATE__
        static int grayscl_image;
#endif

        return_grayscl_image = PCE_thm_print_grayscl_image(nameStr,width,height);

#ifdef __ZSIMULATE__
	if(grayscl_image <= 2){
	        return_grayscl_image = grayscl_image;
		grayscl_image ++;
	}else{
		return_grayscl_image = 0;
	}
#endif
        return return_grayscl_image;

}

/*******************************************************************
* NAME : static jint thm_print_LF(JNIEnv* env, jclass clazz)                      
*
* DESCRIPTION :  Line feed
*
* PARAMETERS :   None
*
* RETURN :
*		ERROR_THM_PRINT
*               THM_PRINT_SUCCESS
*			      
**********************************************************************/

static jint thm_print_LF(JNIEnv* env, jclass clazz){

	ALOGD("## Print LF Test Key OK ##");
        int return_LF;

#ifdef __ZSIMULATE__
        static int LF;
#endif

        return_LF = PCE_thm_print_LF();

#ifdef __ZSIMULATE__
	if(LF <= 1){
        	return_LF = LF;
		LF ++;
	}else{
		return_LF = 0;
	}
#endif
        return return_LF;
}


static JNINativeMethod printersMethods[] ={
        /* name, signature, funcPtr */
        { "thm_check_voltage", "()I", (void*) thm_check_voltage },
        { "thm_print_nchars", "(Ljava/lang/String;I)I", (void*) thm_print_nchars },
	{ "thm_set_font_size", "(CC)I", (void*) thm_set_font_size },
	{ "thm_check_platen", "()I", (void*) thm_check_platen },
	{ "thm_check_paper", "()I", (void*) thm_check_paper },
	{ "thm_print_microLF", "(Ljava/lang/String;I)I", (void*) thm_print_microLF },
	{ "thm_barcode_at_x_numeric", "(ILjava/lang/String;)I", (void*) thm_barcode_at_x_numeric },
	{ "thm_barcode_numeric", "(Ljava/lang/String;)I", (void*)  thm_barcode_numeric },
	{ "thm_print_at_x", "(ILjava/lang/String;)I", (void*) thm_print_at_x },
	{ "thm_print", "(Ljava/lang/String;)I", (void*) thm_print },
	{ "thm_print_image", "(Ljava/lang/String;II)I", (void*) thm_print_image },
	{ "thm_print_grayscl_image", "(Ljava/lang/String;II)I", (void*) thm_print_grayscl_image },
	{ "thm_print_LF", "()I", (void*) thm_print_LF },
};

int register_android_util_printers(JNIEnv* env){
        jclass clazz = env-> FindClass ("android/util/printers");
        if(clazz == NULL){
        return -1;
        }
        return AndroidRuntime::registerNativeMethods(env, "android/util/printers", printersMethods, NELEM(printersMethods));
        }

};
