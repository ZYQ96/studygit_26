package com.yc.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class Dengji {

	protected Shell shell;
	private Table table;
	private Table table_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Dengji window = new Dengji();
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
		shell.setSize(972, 445);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		
		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				CarMain c = new CarMain();
				c.open();
			}
		});
		button.setBounds(510, 373, 75, 25);
		button.setText("返回主页");
		
		Label label = new Label(composite, SWT.NONE);
		label.setBounds(10, 29, 55, 15);
		label.setText("修车登记");
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 50, 425, 310);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBounds(484, 29, 75, 15);
		label_1.setText("汽车修理登记");
		
		table_1 = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(484, 50, 462, 310);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("New Column");

	}
}
