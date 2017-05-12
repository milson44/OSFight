package pro.junes.osfightclient;

/**
 * Created by junes on 23.02.17.
 */

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client extends AsyncTask<Object, Object, String> {


    String dstAddress;
    int dstPort;
    String response = "";
    TextView textResponse;

    Client(String addr, int port) {
        Log.i(response,"in constructor");
        dstAddress = addr;
        dstPort = port;

    }



    @Override
    protected String doInBackground(Object... voids) {

        Socket socket = null;

        try {

            socket = new Socket(dstAddress, dstPort);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];
            int bytesRead;
            InputStream inputStream = socket.getInputStream();

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                response += byteArrayOutputStream.toString("UTF-8");
            }

            Log.i(response,"Response");

           if(response.startsWith("Hello")){

             /*  String data[] = response.split("\\s");

               System.out.println(data[4]);*/




           }


        } catch (UnknownHostException e) {
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            response = "IOException: " + e.toString();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return response;
    }

    /*@Override
    protected void onPostExecute(Void result) {
        textResponse.setText(response);
        super.onPostExecute(String.valueOf(result));
    }*/


   /* static public void main(String []args) {

        Client client = new Client("10.0.2.2",8080);
    }*/


}