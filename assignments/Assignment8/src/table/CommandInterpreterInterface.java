package table;

import scannerBean.ScannerBean;

public interface CommandInterpreterInterface {

	public String getCommandInput();
	public void setCommandInput(String commandInput);
	public ScannerBean getAScanner();
	public void interpretCommand();
	
}
