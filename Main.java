import javax.swing.*;//import of all necessary libraries.
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{

	JFrame frame;  //Deceleration of all components to make it globally visible.
	JTextField txtfield;
	JButton[] numbt=new JButton[10];
	JButton[] funcbt=new JButton[9];
	JButton addbt,subbt,multbt,divbt;
	JButton decbt,eqbt,delbt,clrbt,negbt;
	JPanel panel;
	Font ft=new Font("MV Boli",Font.BOLD,20); //Deceleration of style for buttons.
	
	 double num1=0,num2=0,res=0; //Variables for calculations.
	 char opr;
	
	Main(){
		frame=new JFrame("calculator");//Initialization of frame.
		frame.setSize(420,520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		txtfield =new JTextField();//Initialization of textfield.
		txtfield.setBounds(50, 25, 300, 50);
		txtfield.setFont(ft);
		txtfield.setEditable(false);
		
		addbt=new JButton("+");//Initialization of button.
		subbt=new JButton("-");
		multbt=new JButton("X");
		divbt=new JButton("/");
		decbt=new JButton(".");
		delbt=new JButton("Delete");
		eqbt=new JButton("=");
		clrbt=new JButton("Clear");
		negbt=new JButton("(-)");
		
		funcbt[0]=addbt;//Addition to a common array for functions only.
		funcbt[1]=subbt;
		funcbt[2]=multbt;
		funcbt[3]=divbt;
		funcbt[4]=decbt;
		funcbt[5]=eqbt;
		funcbt[6]=delbt;
		funcbt[7]=clrbt;
		funcbt[8]=negbt;
		
		for(int i=0;i<9;i++) {//Addition of various function listener at same time.
			funcbt[i].addActionListener(this);
			funcbt[i].setFont(ft);
			funcbt[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++) {
			numbt[i]= new JButton(String.valueOf(i));
            numbt[i].addActionListener(this);
			numbt[i].setFont(ft);
			numbt[i].setFocusable(false);
		}
		
		negbt.setBounds(50, 430, 100, 50);//Positioning of buttons.
		delbt.setBounds(150, 430, 100, 50);
		clrbt.setBounds(250, 430, 100, 50);
		
		panel=new JPanel();//Initialization of panel and addition of components into it.
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.add(numbt[1]);
		panel.add(numbt[2]);
		panel.add(numbt[3]);
		panel.add(addbt);
		panel.add(numbt[4]);
		panel.add(numbt[5]);
		panel.add(numbt[6]);
		panel.add(subbt);
		panel.add(numbt[7]);
		panel.add(numbt[8]);
		panel.add(numbt[9]);
		panel.add(multbt);
		panel.add(decbt);
		panel.add(numbt[0]);
		panel.add(eqbt);
		panel.add(divbt);
		
		frame.add(panel);//Addition of panel and other buttons in frame.
		frame.add(negbt);
		frame.add(delbt);
		frame.add(clrbt);
		frame.add(txtfield);
		frame.setVisible(true);
			}
	
public static void main(String[] args) {

		Main clac=new Main();//Creating instance of calculator.
	}

public void actionPerformed(ActionEvent e) {//Response for each button.

	for (int i=0;i<10;i++) {//for textfield.
	if(e.getSource()==numbt[i])
		txtfield.setText(txtfield.getText().concat(String.valueOf(i)));
		
	}
	
	if(e.getSource()==decbt) {//For decimal button.
		txtfield.setText(txtfield.getText().concat("."));
		decbt.setEnabled(false);
	}
	if(e.getSource()==addbt) {//For addition button.
        num1=Double.parseDouble(txtfield.getText());
        opr='+';
        txtfield.setText("");
	}
	if(e.getSource()==subbt) {//For subtraction button.
		num1=Double.parseDouble(txtfield.getText());
        opr='-';
        txtfield.setText("");
    }
	if(e.getSource()==multbt) {//For multiplication button.
		num1=Double.parseDouble(txtfield.getText());
        opr='X';
        txtfield.setText("");
    }
	if(e.getSource()==divbt) {//For division button.
		num1=Double.parseDouble(txtfield.getText());
        opr='/';
        txtfield.setText("");
    }
	if(e.getSource()==eqbt) {//For equals button.
		num2=Double.parseDouble(txtfield.getText());
		switch(opr) {//output process
		case '+':
			res=num1+num2;
			break;
		case '-':
			res=num1-num2;
			break;
		case 'X':
			res=num1*num2;
			break;
		case '/':
			res=num1/num2;
			break;
		}
		txtfield.setText(String.valueOf(res));
		num1=res;
    }
	
	if(e.getSource()==clrbt){//For clear button.
		txtfield.setText("");
    }
	if(e.getSource()==delbt){//For delete button.
		String str=txtfield.getText();
		txtfield.setText("");
		for(int i=0;i<str.length()-1;i++){
		    txtfield.setText(txtfield.getText()+str.charAt(i));
			
		}
    }
    if(e.getSource()==negbt){//For negative button.
		double temp=Double.parseDouble(txtfield.getText());
		temp*=-1;
		txtfield.setText(String.valueOf(temp));
	}
  }
}
