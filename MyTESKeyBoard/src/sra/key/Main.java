package sra.key;

import android.R.anim;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main extends Activity implements OnTouchListener, OnClickListener, OnFocusChangeListener {
	private EditText mainedit, mEt1;
	// private Dialog mDialog;
	// private Window mWindow;
	Animation fadeIn;
	Animation fadeOut;
	boolean checkCaps = false,functionCheck=false,setCaps=false,num=false;
	private Button q, w, e, r, t, y, u, i, o, p, a, s, d, f, g, h, j, k, l, z, x, c, v, b, n, m;
	ToggleButton caps,fn;
	// private Button mButton[] = new Button[34];
	private String st = "";
	/*
	 * private String values[] = { "q", "w", "e", "r", "t", "y", "u", "i", "o",
	 * "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "é", "è", "z", "x",
	 * "c", "b", "n", "m", "ê", "à", "â", "|______|", "ô", "ù", "<-!" };
	 */private RelativeLayout mLayout, mKLayout, mMainLayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		super.onCreate(savedInstanceState);
		try {
			setContentView(R.layout.main);
			// setKeyBoardSettings();

			fadeIn = new AlphaAnimation(0, 1);
			fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
			fadeIn.setDuration(800);
			
			fadeOut=new AlphaAnimation(1, 0);
			fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
			fadeOut.setStartOffset(800);
			fadeOut.setDuration(800);
			
			caps = (ToggleButton) findViewById(R.id.caps);
			b = (Button) findViewById(R.id.xB);
			q = (Button) findViewById(R.id.xQ);
			w = (Button) findViewById(R.id.xW);
			e = (Button) findViewById(R.id.xE);
			r = (Button) findViewById(R.id.xR);
			t = (Button) findViewById(R.id.xT);
			y = (Button) findViewById(R.id.xY);
			u = (Button) findViewById(R.id.xU);
			i = (Button) findViewById(R.id.xI);
			o = (Button) findViewById(R.id.xO);
			p = (Button) findViewById(R.id.xP);
			a = (Button) findViewById(R.id.xA);
			s = (Button) findViewById(R.id.xS);
			d = (Button) findViewById(R.id.xD);
			f = (Button) findViewById(R.id.xF);
			g = (Button) findViewById(R.id.xG);
			h = (Button) findViewById(R.id.xH);
			j = (Button) findViewById(R.id.xJ);
			k = (Button) findViewById(R.id.xK);
			l = (Button) findViewById(R.id.xL);
			z = (Button) findViewById(R.id.xZ);
			x = (Button) findViewById(R.id.xX);
			c = (Button) findViewById(R.id.xC);
			v = (Button) findViewById(R.id.xV);;
			b = (Button) findViewById(R.id.xB);
			n = (Button) findViewById(R.id.xN);
			m = (Button) findViewById(R.id.xM);
			
			z.setOnLongClickListener(new View.OnLongClickListener() {
		         public boolean onLongClick(View v) {
		             mainedit.append(" ");
		             return true;
		         }
			});
			
			fn=(ToggleButton)findViewById(R.id.fn);
			
		
			mainedit = (EditText) findViewById(R.id.xEt);
			mainedit.setOnTouchListener(this);
			mainedit.setOnFocusChangeListener(this);
			mainedit.setOnKeyListener(new View.OnKeyListener() {

				
				@Override
				public boolean onKey(View v, int keyCode, KeyEvent event) {

					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
						Toast.makeText(getBaseContext(), mainedit.getText().toString(), Toast.LENGTH_SHORT).show();
						
					}
					if(keyCode==KeyEvent.KEYCODE_0||keyCode==KeyEvent.KEYCODE_1||keyCode==KeyEvent.KEYCODE_2 || keyCode==KeyEvent.KEYCODE_3
							||keyCode==KeyEvent.KEYCODE_4||keyCode==KeyEvent.KEYCODE_5||keyCode==KeyEvent.KEYCODE_6||keyCode==KeyEvent.KEYCODE_7
							||keyCode==KeyEvent.KEYCODE_8||keyCode==KeyEvent.KEYCODE_9)
					{fn.setChecked(true);}

					if((event.getAction()== KeyEvent.ACTION_DOWN)&& (keyCode==KeyEvent.KEYCODE_NUM_LOCK))
					{num=!num;
					fn.setChecked(num);}

					if((event.getAction() == KeyEvent.ACTION_DOWN)&&keyCode==115)
					{
						setCaps=!setCaps;
						caps.setChecked(setCaps);
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_A)) {
						a.startAnimation(fadeIn);
						a.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "A is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_B)) {
						b.startAnimation(fadeIn);
						b.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "B is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_C)) {
						c.startAnimation(fadeIn);
						c.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "C is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_D)) {
						d.startAnimation(fadeIn);
						d.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "D is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_E)) {
						e.startAnimation(fadeIn);
						e.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "E is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_F)) {
						f.startAnimation(fadeIn);
						f.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "F is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_G)) {
						g.startAnimation(fadeIn);
						g.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "G is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_H)) {
						h.startAnimation(fadeIn);
						h.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "H is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_I)) {
						i.startAnimation(fadeIn);
						i.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "I is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_J)) {
						j.startAnimation(fadeIn);
						j.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "J is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_K)) {
						k.startAnimation(fadeIn);
						k.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "K is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_L)) {
						l.startAnimation(fadeIn);
						l.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "L is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_M)) {
						m.startAnimation(fadeIn);
						m.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "M is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_N)) {
						n.startAnimation(fadeIn);
						n.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "N is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_O)) {
						o.startAnimation(fadeIn);
						o.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "O is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_P)) {
						p.startAnimation(fadeIn);
						p.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "P is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_Q)) {
						q.startAnimation(fadeIn);
						q.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "Q is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_R)) {
						r.startAnimation(fadeIn);
						r.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "R is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_S)) {
						s.startAnimation(fadeIn);
						s.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "S is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_T)) {
						t.startAnimation(fadeIn);
						t.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "T is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_U)) {
						u.startAnimation(fadeIn);
						u.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "U is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_V)) {
						v.startAnimation(fadeIn);
						v.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "V is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_W)) {
						w.startAnimation(fadeIn);
						w.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "W is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_X)) {
						x.startAnimation(fadeIn);
						x.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "X is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_Y)) {
						y.startAnimation(fadeIn);
						y.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "Y is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_Z)) {
						z.startAnimation(fadeIn);
						z.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "Z is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_0)) {
						p.startAnimation(fadeIn);
						p.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "0 is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_9)) {
						if(p.getText().equals("1")){
						o.startAnimation(fadeIn);
						o.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "9 is pressed", Toast.LENGTH_SHORT).show();
						}
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_8)) {
						i.startAnimation(fadeIn);
						i.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "8 is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_7)) {
						u.startAnimation(fadeIn);
						u.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "7 is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_6)) {
						y.startAnimation(fadeIn);
						y.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "6 is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_5)) {
						t.startAnimation(fadeIn);
						t.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "5 is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_4)) {
						r.startAnimation(fadeIn);
						r.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "4 is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_3)) {
						e.startAnimation(fadeIn);
						e.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "3 is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_2)) {
						w.startAnimation(fadeIn);
						w.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "2 is pressed", Toast.LENGTH_SHORT).show();
					}
					if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_1)) {
						q.startAnimation(fadeIn);
						q.startAnimation(fadeOut);
						Toast.makeText(getBaseContext(), "1 is pressed", Toast.LENGTH_SHORT).show();
					}

					return false;
				}
			});

			mEt1 = (EditText) findViewById(R.id.et1);
			mEt1.setOnClickListener(this);
			mEt1.setOnFocusChangeListener(this);
			mLayout = (RelativeLayout) findViewById(R.id.xK1);
			mKLayout = (RelativeLayout) findViewById(R.id.xKeyBoard);
			mMainLayout = (RelativeLayout) findViewById(R.id.xMLayout);
			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
			
			
			caps.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					checkCaps=isChecked;
					if (isChecked) {
						a.setText("A");
						q.setText("Q");
						w.setText("W");
						e.setText("E");
						r.setText("R");
						t.setText("T");
						y.setText("Y");
						u.setText("U");
						i.setText("I");
						o.setText("O");
						l.setText("L");
						p.setText("P");
						k.setText("K");
						j.setText("J");
						h.setText("H");
						g.setText("G");
						f.setText("F");
						d.setText("D");
						s.setText("S");
						z.setText("Z");
						x.setText("X");
						c.setText("C");
						v.setText("V");
						b.setText("B");
						n.setText("N");
						m.setText("M");
					} else {
						a.setText("a");
						q.setText("q");
						w.setText("w");
						e.setText("e");
						r.setText("r");
						t.setText("t");
						y.setText("y");
						u.setText("u");
						i.setText("i");
						o.setText("o");
						l.setText("l");
						p.setText("p");
						k.setText("k");
						j.setText("j");
						h.setText("h");
						g.setText("g");
						f.setText("f");
						d.setText("d");
						s.setText("s");
						z.setText("z");
						x.setText("x");
						c.setText("c");
						v.setText("v");
						b.setText("b");
						n.setText("n");
						m.setText("m");
					}
				}
			});
			
			
			fn.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					if(isChecked)
					{
					q.setText("1");
					w.setText("2");
					e.setText("3");
					r.setText("4");
					t.setText("5");
					y.setText("6");
					u.setText("7");
					i.setText("8");
					o.setText("9");
					p.setText("0");
					
					a.setText("F1");
					s.setText("F2");
					d.setText("F3");
					f.setText("F4");
					g.setText("F5");
					h.setText("F6");
					j.setText("F7");
					k.setText("F8");
					l.setText("F9");
					
					z.setText("F10");
					x.setText("F11");
					c.setText("F12");
					v.setText("F13");
					b.setText("F14");
					n.setText("F15");
					m.setText("F16");
					
					}
					else
					{
						if(checkCaps)
						{
							a.setText("A");
							q.setText("Q");
							w.setText("W");
							e.setText("E");
							r.setText("R");
							t.setText("T");
							y.setText("Y");
							u.setText("U");
							i.setText("I");
							o.setText("O");
							l.setText("L");
							p.setText("P");
							k.setText("K");
							j.setText("J");
							h.setText("H");
							g.setText("G");
							f.setText("F");
							d.setText("D");
							s.setText("S");
							z.setText("Z");
							x.setText("X");
							c.setText("C");
							v.setText("V");
							b.setText("B");
							n.setText("N");
							m.setText("M");
						}
						else
						{
						a.setText("a");
						q.setText("q");
						w.setText("w");
						e.setText("e");
						r.setText("r");
						t.setText("t");
						y.setText("y");
						u.setText("u");
						i.setText("i");
						o.setText("o");
						l.setText("l");
						p.setText("p");
						k.setText("k");
						j.setText("j");
						h.setText("h");
						g.setText("g");
						f.setText("f");
						d.setText("d");
						s.setText("s");
						z.setText("z");
						x.setText("x");
						c.setText("c");
						v.setText("v");
						b.setText("b");
						n.setText("n");
						m.setText("m");
						}
					}
				}
			});
			

			
			
		} catch (Exception e) {
			Log.w(getClass().getName(), e.toString());
		}

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v == mainedit) {
			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
			// mDialog.show();
			// mEt.setFocusable(true);
			// mLayout.setVisibility(RelativeLayout.VISIBLE);
			enableKeyboard();
		}
		if (v == mEt1) {
			// mLayout.setVisibility(RelativeLayout.INVISIBLE);
			disableKeyboard();
		}
		// mLayout.setVisibility(RelativeLayout.INVISIBLE);
		/*
		 * if (v == mMainLayout) { disableKeyboard();
		 * mMainLayout.setFocusable(true); }
		 */

		return true;
	}

	@Override
	/*
	 * public void onClick(View v) { // TODO Auto-generated method stub
	 * 
	 * if (v != mBdone) {
	 * 
	 * String b = ""; b = (String) v.getTag(); if (b != null) {
	 * mainedit.append(b); Log.w(" clicked in ", b); }
	 * 
	 * } if (v == mBdone) {
	 * 
	 * disableKeyboard();
	 * 
	 * }
	 * 
	 * if (v == mMainLayout) { disableKeyboard(); //
	 * mMainLayout.setFocusable(true); } }
	 */

	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		// Log.w(" clicked ",v.getTag()+"");
		if (v == mainedit) {
			if (!hasFocus) {
				enableKeyboard();
				getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
			} else {
				disableKeyboard();
			}
		}
		if (v == mEt1)
			disableKeyboard();

	}

	private void enableKeyboard() {
		mLayout.setVisibility(RelativeLayout.VISIBLE);
		mKLayout.setVisibility(RelativeLayout.VISIBLE);
	}

	private void disableKeyboard() {
		mLayout.setVisibility(RelativeLayout.INVISIBLE);
		mKLayout.setVisibility(RelativeLayout.INVISIBLE);
	}

	public void a(View v) {
		if (((Button) v).getText().equals("a"))
			mainedit.append("a");
		else if(((Button) v).getText().equals("A"))
			mainedit.append("A");
		else
		{}
	}

	public void s(View v) {
		if (((Button) v).getText().equals("s"))
			mainedit.append("s");
		else if(((Button) v).getText().equals("S"))
			mainedit.append("S");
		else
		{}
	}

	public void d(View v) {
		if (((Button) v).getText().equals("d"))
			mainedit.append("d");
		else if(((Button) v).getText().equals("D"))
			mainedit.append("D");
		else
		{}
	}

	public void f(View v) {
		if (((Button) v).getText().equals("f"))
			mainedit.append("f");
		else if(((Button) v).getText().equals("F"))
			mainedit.append("F");
		else
		{}
	}

	public void g(View v) {
		if (((Button) v).getText().equals("g"))
			mainedit.append("g");
		else if(((Button) v).getText().equals("G"))
			mainedit.append("G");
		else
		{}
	}

	public void h(View v) {
		if (((Button) v).getText().equals("h"))
			mainedit.append("h");
		else if(((Button) v).getText().equals("H"))
			mainedit.append("H");
		else
		{}
	}

	public void j(View v) {
		if (((Button) v).getText().equals("j"))
			mainedit.append("j");
		else if(((Button) v).getText().equals("J"))
			mainedit.append("J");
		else
		{}
	}

	public void k(View v) {
		if (((Button) v).getText().equals("k"))
			mainedit.append("k");
		else if(((Button) v).getText().equals("K"))			
			mainedit.append("K");
		else
		{}
	}

	public void l(View v) {
		if (((Button) v).getText().equals("l"))
			mainedit.append("l");
		else if(((Button) v).getText().equals("L"))
			mainedit.append("L");
		else
		{}
	}

	public void q(View v) {
		if (((Button) v).getText().equals("q"))
			mainedit.append("q");
		else if(((Button) v).getText().equals("Q"))
			mainedit.append("Q");
		else
		{
			mainedit.append("1");
		}
	}

	public void w(View v) {
		if (((Button) v).getText().equals("w"))
			mainedit.append("w");
		else if((((Button) v).getText().equals("W")))
			mainedit.append("W");
		else
		{
			mainedit.append("2");
		}
	}

	public void e(View v) {
		if (((Button) v).getText().equals("e"))
			mainedit.append("e");
		else if(((Button) v).getText().equals("E"))
			mainedit.append("E");
		else
		{
			mainedit.append("3");
		}
	}

	public void r(View v) {
		if (((Button) v).getText().equals("r"))
			mainedit.append("r");
		else if(((Button) v).getText().equals("R"))
			mainedit.append("R");
		else
		{
			mainedit.append("4");
		}
	}

	public void t(View v) {
		if (((Button) v).getText().equals("t"))
			mainedit.append("t");
		else if(((Button) v).getText().equals("T"))
			mainedit.append("T");
		else
		{
			mainedit.append("5");
		}
	}

	public void y(View v) {
		if (((Button) v).getText().equals("y"))
			mainedit.append("y");
		else if(((Button) v).getText().equals("Y"))
			mainedit.append("Y");
		else
		{
			mainedit.append("6");
		}
	}

	public void u(View v) {
		if (((Button) v).getText().equals("u"))
			mainedit.append("u");
		else if(((Button) v).getText().equals("U"))
			mainedit.append("U");
		else
		{
			mainedit.append("7");
		}
	}

	public void i(View v) {
		if (((Button) v).getText().equals("i"))
			mainedit.append("i");
		else if(((Button) v).getText().equals("I"))
			mainedit.append("I");
		else
		{
			mainedit.append("8");
		}
	}

	public void o(View v) {
		if (((Button) v).getText().equals("o"))
			mainedit.append("o");
		else if(((Button) v).getText().equals("O"))
			mainedit.append("O");
		else
		{
			mainedit.append("9");
		}
	}
	
	public void p(View v) {
		if (((Button) v).getText().equals("p"))
			mainedit.append("p");
		else if(((Button) v).getText().equals("P"))
			mainedit.append("P");
		else
			mainedit.append("0");
	}

	public void z(View v) {
		if (((Button) v).getText().equals("z"))
		mainedit.append("z");
		else if(((Button) v).getText().equals("Z"))
		mainedit.append("Z");
		else
		{
		}
	}

	public void x(View v) {
		if (((Button) v).getText().equals("x"))
			mainedit.append("x");
		else if(((Button) v).getText().equals("X"))
			mainedit.append("x");
		else
		{}
	}

	public void c(View v) {
		if (((Button) v).getText().equals("c"))
			mainedit.append("c");
		else if(((Button) v).getText().equals("C"))
			mainedit.append("C");
		else
		{}
	}

	public void v(View v) {
		if (((Button) v).getText().equals("v"))
			mainedit.append("v");
		else if(((Button) v).getText().equals("V"))
			mainedit.append("V");
		else
		{}
	}

	public void b(View v) {
		if (((Button) v).getText().equals("b"))
			mainedit.append("b");
		else if(((Button) v).getText().equals("B"))
			mainedit.append("B");
		else
		{}
	}

	public void n(View v) {
		if (((Button) v).getText().equals("n"))
			mainedit.append("n");
		else if(((Button) v).getText().equals("N"))
			mainedit.append("N");
		else
		{}
	}

	public void m(View v) {
		if (((Button) v).getText().equals("m"))
			mainedit.append("m");
		else if(((Button) v).getText().equals("M"))
			mainedit.append("M");
		else
		{}
	} 

	public void enter(View v) {
	mainedit.append("\n");
	}

	public void fn(View v) {

	}

	public void caps(View v) {

	}

	public void backspace(View v) {
		String textString = mainedit.getText().toString();
		if (textString.length() > 0) {
			mainedit.setText(textString.substring(0, textString.length() - 1));
			mainedit.setSelection(mainedit.getText().length());
		}
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
