package com.yc.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CarMain {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CarMain window = new CarMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		
		//管理
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Guanli g = new Guanli();
				g.open();
			}
		});
		btnNewButton.setBounds(33, 51, 75, 25);
		btnNewButton.setText("管理");
		
		//登记
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shell.close();
				Dengji d = new Dengji();
				d.open();
			}
		});
		btnNewButton_1.setBounds(33, 157, 75, 25);
		btnNewButton_1.setText("登记");
		
		//查询
		Button btnNewButton_2 = new Button(composite, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shell.close();
				Select s = new Select();
				s.open();
			}
		});
		btnNewButton_2.setBounds(287, 51, 75, 25);
		btnNewButton_2.setText("查询");
		
		//打印
		Button btnNewButton_3 = new Button(composite, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shell.close();
				Prinlt p = new Prinlt();
				p.open();
			}
		});
		btnNewButton_3.setBounds(287, 171, 75, 25);
		btnNewButton_3.setText("打印");
		
		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean flag = MessageDialog.openConfirm(shell, "温馨提示", "你确定要退出系统吗？");
				if (flag) {
					shell.close();
					LoginCar lo = new LoginCar();
					lo.open();
					System.exit(0);
				}
			}
		});
		button.setBounds(165, 108, 75, 25);
		button.setText("退出系统");

	}
}
