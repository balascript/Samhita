package in.org.samhita.android.app;

import android.content.Context;
import android.content.Intent;

public final class CommonUtilities {

    static final String SERVER_URL = "http://ctdthealtcare.com/samhita/gcm_server_php/register.php"; 
   
    static final String SENDER_ID = "434760485506"; 

    
    static final String TAG = "SAMHITA_14";

    static final String DISPLAY_MESSAGE_ACTION =
            "ita.mitindia.edu.samhitapushnotifications.DISPLAY_MESSAGE";

    static final String EXTRA_MESSAGE = "message";

   
    static void displayMessage(Context context, String message) {
        Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
        intent.putExtra(EXTRA_MESSAGE, message);
        context.sendBroadcast(intent);
    }
}
