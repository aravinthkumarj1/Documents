package com.android.printer;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import android.util.printers;

public class MainActivity extends Activity {
	printers gp;
	boolean isVisible=true;
	String msg;
	String str, direction, barData, k, fileloc;
	char fontSizeH = '7', fontSizeW = '5';
	int microStepCount = 2, xpoint = 4, width = 10, height = 6, nchars = 90, check;
	TextView text;
	int starter=1;
	int return_val;
	///////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////////
	String TES ="TES";
	Animation fadein, fadeout;
	ImageButton i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15;
	/////////////////////////////////////////////////////////////////

	Thread control = new Thread() {

	final String Tag = "CONTROL THREAD RUNNING";

	public void run() {// TODO Auto-generated catch block

		for ( ; ; ){

			try {
				isVisible = true;
				visibility();
				
				if(starter==0){
				synchronized (control) {
					Log.d(Tag, "Control is Waiting For Notify");
					control.wait();
					}
				} starter=0;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Wait for the events
			switch (check) {
				case 1:
				try {
				
					msg = "Printer Test in\nProgress";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					//Going to Print Image by given values	below		

					fileloc="desktop/tes.png";
					width=11;
					height=15;

					// Printing Image Here
					return_val = gp.thm_print_image(fileloc, width, height);
							
					if (return_val == 2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltage Error in Printing Image";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 1) {
					Log.d("ERROR PRINT", "ERROR PRINT");
					msg = "\nPrinter Error in Printing\nImage";
					runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("SUCCESS", "SUCCESS");
					msg = "\nImage Printing Success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
					// After Successfully Printing Image Going to Next
					// Row
					
					//direction and noOfLines to skip is given	
					direction="vertical";
					microStepCount=2;
	
					return_val = gp.thm_print_microLF(direction, microStepCount);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nError in MicroLineFeed";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
	
					Log.d("Print Success", "Print Success");
					msg = "\nMicroLineFeed Success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
					fontSizeH='1';
					fontSizeW='1';
					return_val = gp.thm_set_font_size(fontSizeH, fontSizeW);

					if (return_val == 0) {
						Log.d("fontNormal", "fontNormal");
						msg = "\nFont Setted";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
					sleep(0060); 
					} else if (return_val == 1) {
						Log.d("fontDoubleHeightWidth", "fontDoubleHeightWidth");
						msg = "\nFont Setted";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
					sleep(0060); 
					} else if (return_val == 2) {
						Log.d("fontDoubleWidth", "fontDoubleWidth");
						msg = "\nFont Setted";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
					sleep(0050); 
					} else if (return_val == 3) {
						Log.d("fontDoubleHeight", "fontDoubleHeight");
						msg = "\nFont Setted";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
					sleep(0060); 
					} else if (return_val == 4) {
						Log.d("ErrorInFont", "ErrorInFont");
						msg = "\nError in Font";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						 continue;
					}

					// Image and Micro Line Feeds are Implemented
					// Step 1 Finished
					// Printing 'TES Tablet test Print' by leaving some
					// Gap Before

					//given string will print at given X position

					xpoint=3;
					k="TES Tablet test print";	
					return_val = gp.thm_print_at_x(xpoint, k);

					if (return_val == 2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError\nto Print String";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060);  
						continue;
					} else if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nPrinter Error to \nprint String ";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRange";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nGiven String Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
					// Using MicroLF, to
					// skip two Steps
					direction="vertical";
					microStepCount=4;

					return_val = gp.thm_print_microLF(direction, microStepCount);
								
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nPrinter Error to go\n to another step";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
	
					Log.d("Print Success", "Print Success");
					msg = "\nLineFeed Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Gonna Print CPU
					k="CPU";
					return_val=gp.thm_print(k);

					if (return_val == 1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nError Printing CPU";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage while\nprinting CPU";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
	
					Log.d("CPU Printed", "CPU Printed");
					msg = "\nCPU Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// now using PrintAtX method Gonna Print ':
					// iMX6' by
					// leaving some gap before

					xpoint=6;
					k=": iMX6";
					return_val = gp.thm_print_at_x(xpoint, k);
					if (return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError in CPU info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nPrinting Error in CPU info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					}

					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nCPU info Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Going to Next Step to print
					// 'Speed Info'
					direction="vertical";
					microStepCount=1;
					return_val = gp.thm_print_microLF(direction, microStepCount);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nLinefeed Error\n after CPU info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("Print Success", "Print Success");
					msg = "\nLineFeed Successfully";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					//Gonna Print Speed

					k="Speed";
					return_val=gp.thm_print(k);
					if (return_val == 1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nError Printing Speed";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val==2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltage Error\nPrinting Speed";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
					Log.d("'Speed' Printed", "'Speed' Printed");
					msg = "\n'Speed' Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// now using PrintAtX method Gonna 
					// Print ': 1GHz' by
					// leaving some gap before

					xpoint=6; k="1GHz";
					return_val = gp.thm_print_at_x(xpoint, k);
					if (return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltageError in speed info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nError in speed info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nSpeed info success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					//Leaving One Steps

					direction="vertical"; microStepCount=1;
					return_val = gp.thm_print_microLF(direction, microStepCount);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nMicroFeed Error after\nspeed info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("Print Success", "Print Success");
					msg = "\nMicroFeed Success after\nspeed info";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
					
					//Gonna print COM

					k="COM";
					return_val = gp.thm_print(k);
					if (return_val == 1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nError in Prining COM";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltageError in Printing COM";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
				
					Log.d("COM Printed", "COM Printed");
					msg = "\nCOM Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// now using PrintAtX method Gonna Print ':
					// GSM/GPRS/3G' by
					// leaving some gap before

					xpoint=6; k="GSM/GPRS/3G";
					return_val = gp.thm_print_at_x(xpoint, k);

					if (return_val ==1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError in COM info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val ==2) {
						Log.d("Error Print", "Error Print");
						msg = "\nError in COM info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
						@Override
							public void run() {
								text.append(msg);
								}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nCOM info Success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Going to Next Step to print
					// 'GPS Info'

					direction="vertical"; microStepCount=1;
					return_val = gp.thm_print_microLF(direction, microStepCount);
									
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nErrorMicroFeed after\nGPS info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;					
					}
					Log.d("Print Success", "Print Success");
					msg = "\nMicroFeed Success\nafter GPS info";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
				
					k="GPS";
					return_val=gp.thm_print(k);
							
					if (return_val ==1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nError in printing GPS";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltageError in printing GPS";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;				
					} 
				
					Log.d("GPS Printed", "GPS Printed");
					msg = "\nGPS Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// now using PrintAtX method Gonna Print ': Yes'
					// by
					// leaving some gap before

					xpoint=6; k=": Yes";
					return_val = gp.thm_print_at_x(xpoint, k);
								
					if (return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError in Printing GPS info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nError printing GPS info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val ==3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val== 5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nGPS info Success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Going to Next Step to print
					// 'NFC Info'
				
					direction="vertical"; microStepCount=1;
					return_val = gp.thm_print_microLF(direction, microStepCount);
					if (return_val ==1) {
						Log.d("Error Print", "Error Print");
						msg = "\nMicrofeedError after GPS info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

						Log.d("Print Success", "Print Success");
						msg = "\nMicroFeed Success\n after GPS info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
					sleep(0060); 

					// Gonna Print 'NFC'

					k="NFC";
					return_val=gp.thm_print(k);
					if (return_val == 1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nErrorPrinting NFC";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val==2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltageError printing NFC";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					}
					Log.d("NFC Printed", "NFC Printed");
					msg = "\nNFC Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
		
					// now using PrintAtX method Gonna Print ':
					// MiFare/DESFire' by
					// leaving some gap before

					xpoint=6; k=": MiFare/DESFire";
					return_val = gp.thm_print_at_x(xpoint, k);
					if(return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError in NFC info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nPrintingError in NFC info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val==4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					}
					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nNFC info Success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Going to Next Step to print
					// 'Wifi Info'
					
					direction="vertical"; microStepCount=1;
					return_val= gp.thm_print_microLF(direction, microStepCount);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nMicroFeed Error after NFC info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					}
					Log.d("Print Success", "Print Success");
					msg = "\nMicroFeed Success after NFC";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
					
					// Gonna Print 'Wifi' 

					k=": Wifi";
					return_val=gp.thm_print(k);
					if (return_val == 1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nPrinterError in Wifi";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val ==2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltageError in wifi";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					}
				
					Log.d("Wifi Printed", "Wifi Printed");
					msg = "\nWifi Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
					// now using PrintAtX method Gonna Print ': Yes'
					// by
					// leaving some gap before

					xpoint=6; k=": Yes";
					return_val = gp.thm_print_at_x(xpoint, k);
					if (return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltageError inwifi info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nErrorPrinting wifi info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val ==5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
			
					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nwifi info success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Going to Next Step to print by
					// Skipping 2 steps
					// 'PCE Volt'

					direction="vertical"; microStepCount=1;
					return_val = gp.thm_print_microLF(direction, microStepCount);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nMicroFeedError after wifi info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
					Log.d("Print Success", "Print Success");
					msg = "\nMicroLF success after wifi info";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					//PCE VOLT
						
					k="PCE Volt";				
					return_val=gp.thm_print(k);

					if (return_val == 1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nPrintingError in voltge";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltage";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
					Log.d("PCE Volt Printed", "PCE Volted Printed");
					msg = "\nPCE Voltage\nPrinted";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// now using PrintAtX method Gonna Print ': OK'
					// by
					// leaving some gap before

					xpoint=8; k=": OK";
					return_val = gp.thm_print_at_x(xpoint, k);
					if (return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError in voltage info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;			
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nErrorPrinting voltage info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val ==3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val ==4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val ==5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
				
					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nvoltage info success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Going to Next Step to print
					// 'Palten Info'

					direction="vertical"; microStepCount=1;
					return_val = gp.thm_print_microLF(direction, microStepCount);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nmicroLF after voltage info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
					Log.d("Print Success", "Print Success");
					msg = "\nmicroLF Successafter voltage info";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
				
					// Gonna print 'Palten'
				
					k="Palten";
					return_val=gp.thm_print(k);
					if (return_val == 1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nprinting error in palten";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltageerror in palton";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
					Log.d("Palten Printed", "Palten Printed");
					msg = "\nPalten Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// now using PrintAtX method Gonna Print ':
					// Closed' by
					// leaving some gap before

					xpoint=8; k=": Closed";
					return_val = gp.thm_print_at_x(xpoint, k);
					if (return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError in palten info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nError printing palten info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val ==3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
				
					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nPalten info success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 
								
					// Going to Next Step to print
					// 'Paper Info'

					direction="vertical"; microStepCount=1;
					return_val= gp.thm_print_microLF(direction, microStepCount);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nMicroLF Error after palten info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("Print Success", "Print Success");
					msg = "\nmicroLF Success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Gonna Print 'Paper'
			
					k="Paper";
					return_val=gp.thm_print(k);
					if (return_val == 1) {
						Log.d("ErrorInPrinter", "ErrorInPrinter");
						msg = "\nError printing paper";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLowVoltage in paper";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
					Log.d("Paper Printed", "Paper Printed");
					msg = "\nPaper Printed";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// now using PrintAtX method Gonna Print ': OK'
					// by
					// leaving some gap before

					xpoint=8; k=": OK";
					return_val = gp.thm_print_at_x(xpoint, k);
					if (return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError in Paper info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nErrorPrinting paper info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 3) {
						Log.d("PAPER ABSENT", "PAPER ABSENT");
						msg = "\nPaper Absent";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 4) {
						Log.d("PLATEN OPEN", "PLATEN OPEN");
						msg = "\nPlaten Open";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 5) {
						Log.d("OUTOFRANGE", "OUTOFRANGE");
						msg = "\nOutOfRanget";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("PrintSuccess", "PrintSuccess");
					msg = "\nPaper info success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Going to Next Step to print
					// 'Barcode png using BarcodeAtX'

					direction="vertical"; microStepCount=1;
					return_val = gp.thm_print_microLF(direction, microStepCount);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nMicroLF error after paper info";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 

					Log.d("Print Success", "Print Success");
					msg = "\nMicroLF Success after paper info";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					// Gonna Draw BarCode Image

					barData="18354567";
					return_val=gp.thm_barcode_numeric(barData);
					if (return_val == 1) {
						Log.d("Error Print", "Error Print");
						msg = "\nError printing barcode";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
					Log.d("Barcode", "Barcode");
					msg = "\nBarcode Success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					fileloc="greysacale/image.png"; width=4; height=6;
					return_val=gp.thm_print_grayscl_image(fileloc,width,height);
					if (return_val == 1) {
						Log.d("LOW VOLTAGE ERROR", "LOW VOLTAGE ERROR");
						msg = "\nLow Voltage\nError in grreyscale";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} else if (return_val == 2) {
						Log.d("Error Print", "Error Print");
						msg = "\nError printing grayscale";
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								text.append(msg);
							}
						});
						sleep(0060); 
						continue;
					} 
								
					Log.d("Barcode", "Barcode");
					msg = "\nGrayscale success";
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							text.append(msg);
						}
					});
					sleep(0060); 

					Log.d("Buttons", "Buttons are available now");
					isVisible = true;
					visibility();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

				default:

			}

		}
	}
	};

	/////////////////////////////////////////////////////////////////
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);
		text.setMovementMethod(new ScrollingMovementMethod());
		i1 = (ImageButton) findViewById(R.id.i1);
		i2 = (ImageButton) findViewById(R.id.i2);
		i3 = (ImageButton) findViewById(R.id.i3);
		i4 = (ImageButton) findViewById(R.id.i4);
		i5 = (ImageButton) findViewById(R.id.i5);
		i6 = (ImageButton) findViewById(R.id.i6);
		i7 = (ImageButton) findViewById(R.id.i7);
		i8 = (ImageButton) findViewById(R.id.i8);
		i9 = (ImageButton) findViewById(R.id.i9);
		i10 = (ImageButton) findViewById(R.id.i10);
		i11 = (ImageButton) findViewById(R.id.i11);
		i12 = (ImageButton) findViewById(R.id.i12);
		i13 = (ImageButton) findViewById(R.id.i13);
		i14 = (ImageButton) findViewById(R.id.i14);
		i15 = (ImageButton) findViewById(R.id.i15);

		fadein = new AlphaAnimation(0, 1);
		fadein.setInterpolator(new DecelerateInterpolator()); // add this
		fadein.setDuration(500);

		fadeout = new AlphaAnimation(1, 0);
		fadeout.setInterpolator(new AccelerateInterpolator()); // and this
		fadeout.setStartOffset(0);
		fadeout.setDuration(500);

		gp = new printers();
	}

	void visibility() {

		runOnUiThread(new Runnable() {
			public void run() {
				if (isVisible) {

					i1.setEnabled(true);
					i2.setEnabled(true);
					i3.setEnabled(true);
					i4.setEnabled(true);
					i5.setEnabled(true);
					i6.setEnabled(true);
					i7.setEnabled(true);
					i8.setEnabled(true);
					i9.setEnabled(true);
					i10.setEnabled(true);
					i11.setEnabled(true);
					i12.setEnabled(true);
					i13.setEnabled(true);
					i14.setEnabled(true);
					i15.setEnabled(true);
					i1.setImageResource(R.drawable.i1);
					i2.setImageResource(R.drawable.i2);
					i3.setImageResource(R.drawable.i3);
					i4.setImageResource(R.drawable.i4);
					i5.setImageResource(R.drawable.i5);
					i6.setImageResource(R.drawable.i6);
					i7.setImageResource(R.drawable.i7);
					i8.setImageResource(R.drawable.i8);
					i9.setImageResource(R.drawable.i9);
					i10.setImageResource(R.drawable.i10);
					i11.setImageResource(R.drawable.i11);
					i12.setImageResource(R.drawable.i12);
					i13.setImageResource(R.drawable.i13);
					i14.setImageResource(R.drawable.i14);
					i15.setImageResource(R.drawable.i15);
				} else {
					i1.setEnabled(false);
					i2.setEnabled(false);
					i3.setEnabled(false);
					i4.setEnabled(false);
					i5.setEnabled(false);
					i6.setEnabled(false);
					i7.setEnabled(false);
					i8.setEnabled(false);
					i9.setEnabled(false);
					i10.setEnabled(false);
					i11.setEnabled(false);
					i12.setEnabled(false);
					i13.setEnabled(false);
					i14.setEnabled(false);
					i15.setEnabled(false);
					i1.setImageResource(R.drawable.i111);
					i2.setImageResource(R.drawable.i22);
					i3.setImageResource(R.drawable.i33);
					i4.setImageResource(R.drawable.i44);
					i5.setImageResource(R.drawable.i55);
					i6.setImageResource(R.drawable.i66);
					i7.setImageResource(R.drawable.i77);
					i8.setImageResource(R.drawable.i88);
					i9.setImageResource(R.drawable.i99);
					i10.setImageResource(R.drawable.i100);
					i11.setImageResource(R.drawable.i101);
					i12.setImageResource(R.drawable.i102);
					i13.setImageResource(R.drawable.i103);
					i14.setImageResource(R.drawable.i104);
					i15.setImageResource(R.drawable.i105);

				}
			}
		});

	}


	public void image(View v) {
		v.startAnimation(fadein);
		v.startAnimation(fadeout);
		isVisible = false;
		visibility();
		check = 1;
		text.setText("");

		if (!control.isAlive()) {
			control.start();
		} else {
			try {
				synchronized (control) {
					control.notify();
				}

			} catch (Exception r) {
			}
		}
	}

	public void onDestroy() {
		if (/*event.isAlive() &&*/ control.isAlive()) {
			//event.interrupt();
			control.interrupt();
		}
		super.onDestroy();

	}
}
