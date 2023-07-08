/**
 * 
 */
/**
 * @author jmlop
 *
 */
module HealthPortal {
        requires javafx.controls;
		requires javafx.graphics;
    
    opens P1 to javafx.graphics, javafx.fxml;
}