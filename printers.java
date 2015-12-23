package android.util;

import com.android.internal.os.RuntimeInit;
import java.io.PrintWriter;
import java.io.StringWriter;
import  java.io.BufferedReader;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public final class printers{
        public static native int thm_check_voltage();
        public static native int thm_print_nchars(String str,int nchars);
        public static native int thm_set_font_size(char fontSizeHeight, char fontSizeWidth);
        public static native int thm_check_platen();
        public static native int thm_check_paper();
        public static native int thm_print_microLF(String direction, int microStepCount);  
        public static native int thm_barcode_at_x_numeric(int xpoint,String barData);
        public static native int thm_barcode_numeric(String barData);
        public static native int thm_print_at_x(int xpoint,String k);
        public static native int thm_print(String k);
        public static native int thm_print_image(String fileloc, int width, int height);
        public static native int thm_print_grayscl_image(String fileloc, int width, int height);
        public static native int thm_print_LF();


}

