package com.yc.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.commons.MessageUtil;
import com.yc.dao.LoginDAO;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoginCar {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginCar window = new LoginCar();
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
	//	composite.setBackgroundImage(SWTResourceManager.getImage(Login.class, "/img/2.jpg"));
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(180, 69, 134, 21);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(179, 114, 135, 21);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setBounds(73, 69, 75, 25);
		btnNewButton.setText("用户名");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setBounds(73, 114, 75, 25);
		btnNewButton_1.setText("密码");
		
		Button btnNewButton_2 = new Button(composite, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name=text.getText();
				String pwd=text_1.getText();
				Map<String, Object> map=null;
				try{
						LoginDAO dao=new LoginDAO();
						map=new HashMap<String,Object>();
						map=dao.login(name, pwd);
						//判断登录是否成功
						if(null!=map&&map.size()>0){
							//关闭当前主窗体
							shell.close();
							CarMain c = new CarMain();
							c.open();
						}else{
							MessageUtil.promt(shell, "登录失败","您输入的用户名或密码错误，请重新输入");
						}
				}catch(SQLException e1){
					MessageUtil.promt(shell, "登录失败",e1.getMessage());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(134, 182, 75, 25);
		btnNewButton_2.setText("登录");
		
		Button button = new Button(composite, SWT.NONE);
		button.setBounds(239, 182, 75, 25);
		button.setText("退出");

	}}
