package com.ibm.fp.lambda.advanced;

/**
 * Function as parameter to another function.
 */

@FunctionalInterface
interface Handler {
    void connect();
}

//parameters and args with respect to function as parameters:  simulate non blocking data return

@FunctionalInterface
interface HttpHandler {
    boolean write(Object data);
}


class NetServer {
    //Take Handler as Arg
    public void start(Handler handler) {
        handler.connect();
    }
}

class HttpServer {
    public void handleRequest(HttpHandler httpHandler) {
        try {
            //fake Response
            String fakeResponse = "Hello! HttpServer";
            Thread.sleep(1000);
            boolean status = httpHandler.write(fakeResponse);
            if (status) {
                System.out.println("Response committed");
            } else {
                System.out.println("something went wrong");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}

class HandlerImpl implements Handler {
    @Override
    public void connect() {
        System.out.println("Start Net Server");
    }
}

public class FunctionAsParam {
    public static void main(String[] args) {
        NetServer netServer = null;
        netServer = new NetServer();

        netServer.start(new HandlerImpl());

        //anonous
        Handler handler = null;

        handler = new Handler() {
            @Override
            public void connect() {
                System.out.println("Start Net Server");
            }
        };
        netServer.start(handler);

        netServer.start(new Handler() {
            @Override
            public void connect() {
                System.out.println("Start Net Server");
            }
        });
        //lambda methods
        handler = () -> System.out.println("Start Net Server via Lambda");
        netServer.start(handler);
        //inline
        netServer.start(() -> System.out.println("Start Net Server via inline Lambda"));

        ///////////////////////////////////////////////////////////////////////////////////
        HttpServer httpServer = new HttpServer();

        //call
        httpServer.handleRequest(new HttpHandler() {
            @Override
            public boolean write(Object data) {
                System.out.println(data);
                return true;
            }
        });
        //lambda way of gettting data
        System.out.println("Waiting");
        httpServer.handleRequest(response -> {
            System.out.println(response);
            return true;
        });
        System.out.println("end");
    }
}
