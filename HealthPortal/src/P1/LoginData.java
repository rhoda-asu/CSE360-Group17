package prototype;

import java.util.HashMap;

public class LoginData {
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginData(){
	logininfo.put("pass", "pass");
	logininfo.put("567", "pass456");
	logininfo.put("8910", "pass678");
	}
	
	protected HashMap getlogininfo(){
		return logininfo;
	}

}
